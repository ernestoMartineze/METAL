/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.utils.interoperabilidad;

import java.io.IOException;

import java.io.StringReader;
import java.net.URL;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import javax.xml.soap.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import org.w3c.dom.DOMException;


public class SOAPClientSAAJ {

    ManejadorLog manejadorLog = new ManejadorLog();
    //DEV
    //private static String soapEndpointUrl = "https://201.175.34.119/WebServicesGestion/services/ConsultaPorCurpService";
    //QA
    private static String soapEndpointUrl = "https://efar-test.fin.us2.oraclecloud.com/xmlpserver/services/ExternalReportWSSService";
    private static String soapAction = "runReport";

    private static void creaParametro(SOAPElement parameterNameValues, String nombreParametro, String valor) throws SOAPException{
        
                //Parametro Cuenta
        SOAPElement item = parameterNameValues.addChildElement("item", "pub");
        SOAPElement name = item.addChildElement("name", "pub");
        name.addTextNode(nombreParametro);
        SOAPElement multiValuesAllowed = item.addChildElement("multiValuesAllowed", "");
        multiValuesAllowed.addTextNode("TRUE");
        SOAPElement values = item.addChildElement("values", "pub");
        SOAPElement valorNoCuenta = values.addChildElement("item", "pub");
        valorNoCuenta.addTextNode(valor);

        
//        return parameterNameValues;
    }

    private static void createSoapEnvelope(SOAPMessage soapMessage, String pCURP) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "http://xmlns.oracle.com/oxp/service/PublicReportService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.setPrefix("soap");
        envelope.getHeader().setPrefix("soap");

        envelope.addNamespaceDeclaration("pub", "http://xmlns.oracle.com/oxp/service/PublicReportService");
        envelope.addNamespaceDeclaration("x", "http://schemas.xmlsoap.org/soap/envelope/");
        envelope.addNamespaceDeclaration("soap", "http://www.w3.org/2003/05/soap-envelope");

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("soap");
        SOAPElement runReport = soapBody.addChildElement("runReport", "pub", myNamespace);
        SOAPElement reportRequest = runReport.addChildElement("reportRequest", "pub");
        //Parametro Report
                SOAPElement parameterNameValues = reportRequest.addChildElement("parameterNameValues", "pub");
        creaParametro(parameterNameValues, "BANK_ACCOUNT_NUMBER", "05218389991");
        creaParametro(parameterNameValues, "FROM_DATE", "11-05-2018");
        creaParametro(parameterNameValues, "TO_DATE", "11-05-2018");

        SOAPElement sizeOfDataChunkDownload = reportRequest.addChildElement("sizeOfDataChunkDownload", "pub");
        sizeOfDataChunkDownload.addTextNode("-1");
        SOAPElement attributeFormat = reportRequest.addChildElement("attributeFormat", "pub");
        attributeFormat.addTextNode("xml");
        SOAPElement reportAbsolutePath = reportRequest.addChildElement("reportAbsolutePath", "pub");
        reportAbsolutePath.addTextNode("/Custom/Financials/Cash Management/Reports/XXFRISA_CE_ESTADO_CUENTA.xdo");
    }

    public XMLStreamReader readXMLFromString(final String xmlContent) throws XMLStreamException {
        final XMLInputFactory inputFactory = creaXMLInputFactory();
        final StringReader reader = new StringReader(xmlContent);
        return inputFactory.createXMLStreamReader(reader);
    }

    private XMLInputFactory creaXMLInputFactory() {
        final XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        inputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false); // This disables DTDs entirely for that factory
        inputFactory.setProperty("javax.xml.stream.isSupportingExternalEntities", false); // disable external entities
        return inputFactory;
    }

    private RespuestaCURP SOAPToPojo(SOAPBody soapBody) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(RespuestaCURP.class);
        Unmarshaller u = jc.createUnmarshaller();

        manejadorLog.debug("Nodo1 : " + soapBody.getFirstChild().getTextContent());

        RespuestaCURP salidaConsulta = (RespuestaCURP) u.unmarshal(readXMLFromString(soapBody.getFirstChild().getTextContent()));
        manejadorLog.debug(salidaConsulta.toString());
        return salidaConsulta;
    }

    public RespuestaConsultaCurpDTO consultarOBI_runReport(String pCURP) {
        RespuestaConsultaCurpDTO respuesta = new RespuestaConsultaCurpDTO();
        try {
            soapEndpointUrl = "https://efar-test.fin.us2.oraclecloud.com:443/xmlpserver/services/ExternalReportWSSService";
            soapAction = "";

            manejadorLog.debug("Invocando servicio para : " + pCURP);
            manejadorLog.debug("soapEndpointUrl : " + soapEndpointUrl);
            manejadorLog.debug("soapAction : " + soapAction);
//            SSLConector conectorSSL = new SSLConector();
//            conectorSSL.asegurarCanal();
//            RespuestaCURP respuestaCURP =  SOAPToPojo(null);
            SOAPMessage respuestaRenapo = (SOAPMessage) callSoapWebService(soapEndpointUrl, soapAction, pCURP);

            manejadorLog.debug("RESPUESTA: ");
            manejadorLog.debug(respuestaRenapo.toString());
            SOAPBody soapBody = respuestaRenapo.getSOAPBody();

            RespuestaCURP respuestaCURP = SOAPToPojo(soapBody);
            respuesta.setCURP(respuestaCURP.getCURP());
            respuesta.setNombre(respuestaCURP.getNombres());
            respuesta.setFechaNacimiento(respuestaCURP.getFechNac());
            respuesta.setPrimarApellido(respuestaCURP.getApellido1());
//            respuesta.setSegundoApellido(respuestaCURP.getApellido2() == null ? CONSTANTE.VACIO : respuestaCURP.getApellido2());
            respuesta.setDescEstado(respuestaCURP.getCveEntidadNac());
            respuesta.setIdEstado(respuestaCURP.getNumEntidadReg());
            respuesta.setSexo(respuestaCURP.getSexo());
//            respuesta.setIdError(CONSTANTE.CERO);

        } catch (IOException e) {
            manejadorLog.error("\nError occurred while sending SOAP Request to Server!\nAsegura la comunicación entre servidores!\n");
            manejadorLog.error(e.toString());
            manejadorLog.error(e, this.getClass());
//            respuesta.setIdError(CONSTANTE.UNO);
            respuesta.setDescripcionError("No existe comunicación con el servicio de RENAPO");

        } catch (UnsupportedOperationException e) {
            manejadorLog.error("\nError occurred while sending SOAP Request to Server!\nAsegura el endpoint y operación!\n");
            manejadorLog.error(e.toString());
            manejadorLog.error(e, this.getClass());
//            respuesta.setIdError(CONSTANTE.DOS);
            respuesta.setDescripcionError("No existe el servicio u operación de RENAPO en el endpoint especificado");
        } catch (DOMException e) {
            manejadorLog.error("\nError occurred while sending SOAP Request to Server!\nLa estructura de respuesta entre aplicativos!\n");
            manejadorLog.error(e.toString());
            manejadorLog.error(e, this.getClass());
//            respuesta.setIdError(CONSTANTE.TRES);
            respuesta.setDescripcionError("No existe compatibilidad en la respuesta de RENAPO con RUPA");
        } catch (SOAPException e) {
            manejadorLog.error("\nError occurred while sending SOAP Request to Server!\nAsegura el protocolo del intercambio de información!\n");
            manejadorLog.error(e.toString());
            manejadorLog.error(e, this.getClass());
//            respuesta.setIdError(CONSTANTE.CUATRO);
            respuesta.setDescripcionError("El servicio de RENAPO no es compatible con SOAP.");

        } catch (Exception ex) {
            manejadorLog.error(ex, this.getClass());
//            respuesta.setIdError(CONSTANTE.CINCO);
            respuesta.setDescripcionError("Error general en consumo del servicio de RENAPO");
        }
        manejadorLog.debug("getIdError: " + respuesta.getIdError());
        return respuesta;
    }


    private SOAPMessage callSoapWebService(String soapEndpointUrl, String soapAction, String pCURP) {
        SOAPMessage soapResponse = null;

        SOAPConnection soapConnection;
        try {

            final boolean isHttps = soapEndpointUrl.toLowerCase().startsWith("https");
            HttpsURLConnection httpsConnection = null;
            // Open HTTPS connection
            if (isHttps) {
                // Create SSL context and trust all certificates
                SSLContext sslContext = SSLContext.getInstance("SSL");
                TrustManager[] trustAll
                        = new TrustManager[]{new TrustAllCertificates()};
                sslContext.init(null, trustAll, new java.security.SecureRandom());
                // Set trust all certificates context to HttpsURLConnection
                HttpsURLConnection
                        .setDefaultSSLSocketFactory(sslContext.getSocketFactory());
                // Open HTTPS connection
                URL url = new URL(soapEndpointUrl);
                httpsConnection = (HttpsURLConnection) url.openConnection();
                // Trust all hosts
                httpsConnection.setHostnameVerifier(new TrustAllHosts());
                // Connect
                httpsConnection.connect();
            }
            // Send HTTP SOAP request and get response
            soapConnection
                    = SOAPConnectionFactory.newInstance().createConnection();
            SOAPMessage response = soapConnection.call(createSOAPRequest(soapAction, pCURP), soapEndpointUrl);
            // Close connection
            soapConnection.close();
            // Close HTTPS connection
            if (isHttps) {
                httpsConnection.disconnect();
            }

            // Send HTTP SOAP request and get response
//            SOAPConnection soapConnection
//                    = SOAPConnectionFactory.newInstance().createConnection();
//            SOAPMessage response = soapConnection.call(request, endpointUrl);
//            // Close connection
//            soapConnection.close();
            // Close HTTPS connection
//            if (isHttps) {
//                httpsConnection.disconnect();
//            }
            // Create SOAP Connection
//            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//            soapConnection = soapConnectionFactory.createConnection();
//            // Send SOAP Message to SOAP Server
//            soapResponse = soapConnection.call(createSOAPRequest(soapAction, pCURP), soapEndpointUrl);
            // Print the SOAP Response
            manejadorLog.debug("Response SOAP Message:");
            manejadorLog.debug(response.getSOAPBody().getTextContent());
            manejadorLog.debug("Termina callSoapWebService ");
            soapConnection.close();

        } catch (Exception e) {
            manejadorLog.error("\nError occurred while sending SOAP Request to Server!");
            manejadorLog.error(e.toString());
            manejadorLog.error(e, this.getClass());
        }

        return soapResponse;
    }

    /**
     * Dummy class implementing HostnameVerifier to trust all host names
     */
    private static class TrustAllHosts implements HostnameVerifier {

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    /**
     * Dummy class implementing X509TrustManager to trust all certificates
     */
    private static class TrustAllCertificates implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction, String pCURP) throws SOAPException, IOException {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        try {
            createSoapEnvelope(soapMessage, pCURP);

            MimeHeaders headers = soapMessage.getMimeHeaders();
//            headers.addHeader("SOAPAction", soapAction);

            soapMessage.saveChanges();

            /* Print the request message, just for debugging purposes */
            System.out.println("Request SOAP Message:");
            soapMessage.writeTo(System.out);
            System.out.println("\n");

        } catch (SOAPException ex) {
            throw new SOAPException();
        }
        return soapMessage;
    }

}
