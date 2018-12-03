/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.utils.interoperabilidad;

import java.io.IOException;

import java.io.StringReader;

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

    private static void createSoapEnvelopeCURP(SOAPMessage soapMessage, String pCURP) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "http://xmlns.oracle.com/oxp/service/PublicReportService";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();

        envelope.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
        envelope.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        envelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("soap");
        SOAPElement consultarPorCurp = soapBody.addChildElement("consultarPorCurp", "", myNamespace);
        SOAPElement datos = consultarPorCurp.addChildElement("datos");
        SOAPElement cveCurp = datos.addChildElement("cveCurp");
        SOAPElement tipoTransaccion = datos.addChildElement("tipoTransaccion");
        SOAPElement direccionIp = datos.addChildElement("direccionIp");
        SOAPElement password = datos.addChildElement("password");
        SOAPElement usuario = datos.addChildElement("usuario");
        cveCurp.addTextNode(pCURP);
        direccionIp.addTextNode("192.159.36.100");
        password.addTextNode("wsgestion2011");
        usuario.addTextNode("wsgestion");
        tipoTransaccion.addTextNode("1");
    }

    public XMLStreamReader readXMLFromString(final String xmlContent) throws XMLStreamException {
        final XMLInputFactory inputFactory =creaXMLInputFactory();
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
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            soapConnection = soapConnectionFactory.createConnection();
            // Send SOAP Message to SOAP Server
            soapResponse = soapConnection.call(createSOAPRequest(soapAction, pCURP), soapEndpointUrl);

            // Print the SOAP Response
            manejadorLog.debug("Response SOAP Message:");
            manejadorLog.debug(soapResponse.getSOAPBody().getTextContent());
            manejadorLog.debug("Termina callSoapWebService ");
            soapConnection.close();

        } catch (Exception e) {
            manejadorLog.error("\nError occurred while sending SOAP Request to Server!\nAsegura el protocolo del intercambio de información!\n");
            manejadorLog.error(e.toString());
            manejadorLog.error(e, this.getClass());
        }

        return soapResponse;
    }

    private static SOAPMessage createSOAPRequest(String soapAction, String pCURP) throws SOAPException, IOException {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        try {
            createSoapEnvelopeCURP(soapMessage, pCURP);

            MimeHeaders headers = soapMessage.getMimeHeaders();
            headers.addHeader("SOAPAction", soapAction);

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
