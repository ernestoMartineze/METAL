/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author USER_1
 */
public class AdaptadorWS {

    public String getOBI_generarFacturaAlCobro(List<FacturaPagoDTO> facturas) throws MalformedURLException {
        return null;
    }

    public RespuestaERP_Edo_Cuenta getERP_ejecutarReporteEdoCuenta(String fechaInicio, String fechaFinal, String noCuenta) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

//Code to make a webservice HTTP request
        RespuestaERP_Edo_Cuenta respestaWS = new RespuestaERP_Edo_Cuenta();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));
        String responseString = "";
        String outputString = "";
        String wsURL = "https://efar-test.fin.us2.oraclecloud.com/xmlpserver/services/ExternalReportWSSService";
        URL url = new URL(wsURL);
        URLConnection connection = url.openConnection();
        HttpsURLConnection httpConn = (HttpsURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput
                = " <soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\">\n"
                + "   <soap:Header/>\n"
                + "   <soap:Body>\n"
                + "      <pub:runReport>\n"
                + "         <pub:reportRequest>\n"
                + "            <pub:parameterNameValues>\n"
                + "               <pub:item>\n"
                + "                  <pub:name>BANK_ACCOUNT_NUMBER</pub:name>\n"
                + "                  <multiValuesAllowed>false</multiValuesAllowed>\n"
                + "                  <pub:values>\n"
                + "                     <pub:item>" + noCuenta + "</pub:item>\n"
                + "                  </pub:values>\n"
                + "               </pub:item>\n"
                + "               <pub:item>\n"
                + "                  <pub:name>FROM_DATE</pub:name>\n"
                + "                  <multiValuesAllowed>TRUE</multiValuesAllowed>\n"
                + "                  <pub:values>\n"
                + "                     <pub:item>" + fechaInicio + "</pub:item>\n"
                + "                  </pub:values>\n"
                + "               </pub:item>\n"
                + "               <pub:item>\n"
                + "                  <pub:name>TO_DATE</pub:name>\n"
                + "                  <multiValuesAllowed>TRUE</multiValuesAllowed>\n"
                + "                  <pub:values>\n"
                + "                     <pub:item>" + fechaFinal + "</pub:item>\n"
                + "                  </pub:values>\n"
                + "               </pub:item>\n"
                + "\n"
                + "            </pub:parameterNameValues>\n"
                + "            <pub:attributeFormat>xml</pub:attributeFormat>\n"
                + "            <pub:attributeLocale/>\n"
                + "            <pub:attributeTemplate/>\n"
                + "            <pub:attributeTimezone/>\n"
                + "            <pub:attributeUILocale/>\n"
                + "            <pub:reportAbsolutePath>/Custom/Financials/Cash Management/Reports/XXFRISA_CE_ESTADO_CUENTA.xdo</pub:reportAbsolutePath>\n"
                + "            <pub:sizeOfDataChunkDownload>-1</pub:sizeOfDataChunkDownload>\n"
                + "         </pub:reportRequest>\n"
                + "      </pub:runReport>\n"
                + "   </soap:Body>\n"
                + "</soap:Envelope>";

        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction
                = "http://xmlns.oracle.com/oxp/service/PublicReportService/ExternalReportWSSService/runReportRequest";
// Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length",
                String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
        String encodedAuthorization = "dGFfanBlcmV6OldlbGNvbWUxMg==";

//        System.out.println("Encoded Authorization String for FinLitLog is :" + encodedAuthorization);
        httpConn.setRequestProperty("Authorization", "Basic " + encodedAuthorization);

        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        //Write the content of the request to the outputstream of the HTTP Connection.
        out.write(b);
        out.close();
        //Ready with sending the request.
        try (InputStreamReader isr
                = new InputStreamReader(httpConn.getInputStream());) {
            //Read the response.

            BufferedReader in = new BufferedReader(isr);

            //Write the SOAP message response to a String.
            while ((responseString = in.readLine()) != null) {
                outputString = outputString + responseString;
            }
            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            //        String formattedSOAPResponse = formatXML(outputString);
            respestaWS.setDATA_DSObject((DATA_DS) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), new DATA_DS()));
            //        System.out.println(formattedSOAPResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", "ERROR"));
        }
        return respestaWS;
    }
//format the XML in your String

    public String formatXML(String unformattedXml) throws IOException, ParserConfigurationException, SAXException {
        Document document = parseXmlFile(unformattedXml);
        OutputFormat format = new OutputFormat(document);
        format.setIndenting(true);
        format.setIndent(3);
        format.setOmitXMLDeclaration(true);
        Writer out = new StringWriter();
        XMLSerializer serializer = new XMLSerializer(out, format);
        serializer.serialize(document);
        return out.toString();
    }

    private Document parseXmlFile(String in) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(in));
        return db.parse(is);
    }

    private String getCadenaDesdeB64(String cadB64) {
        String str = new String(DatatypeConverter.parseBase64Binary(cadB64));
//          String res = DatatypeConverter.printBase64Binary(str.getBytes());
//          System.out.println(str);
        return str;
    }

    public Object respuestaJSONA_Dto(String datos, Object obj) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().create();
        ManejadorLog manejadorLog = new ManejadorLog();
        Object vObj = null;

        if (datos.contains("Error 404--Not Found")) {
            datos = "{\"proceso\": {\n"
                    + "      \"descripcion\": \"El servicio no se encuentra disponible.\",\n"
                    + "      \"termino\": \"999\"\n"
                    + "   }";
        }

        try {
            vObj = gson.fromJson(datos, obj.getClass());

        } catch (JsonSyntaxException ex) {
            manejadorLog.debug("Error 0006 :" + ex.getMessage());
            manejadorLog.error("Error :" + ex.getMessage());
            manejadorLog.error("Error :" + ex.getLocalizedMessage());
            throw new JsonSyntaxException("Failed : HTTP error code : " + ex.getMessage());
        }

        return vObj;
    }

    private Object respuestaXMLaPOJO(String xmlOrigen, Object clase) throws IOException {
        Object vObj = null;
        XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        vObj
                = xmlMapper.readValue(xmlOrigen, clase.getClass());
        return vObj;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        AdaptadorWS adaptadorWS
                = new AdaptadorWS();
        try {
            RespuestaERP_Edo_Cuenta respuesta = adaptadorWS.getERP_ejecutarReporteEdoCuenta("11-05-2018", "11-05-2018", "0521838999");

            System.out.println(respuesta.getProceso().getTermino());
            System.out.println(respuesta.getDATA_DSObject().getBANK_ACCOUNT_NUMBER());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
