/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;


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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author USER_1
 */
public class adaptadorWS {

    public String getOBI_generarFacturaAlCobro(List<FacturaPagoDTO> facturas) throws MalformedURLException{
        return null;
    }
    
    public String getERP_ejecutarReporteEdoCuenta(String fechaInicio, String fechaFinal, String noCuenta) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

//Code to make a webservice HTTP request
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
                + "                     <pub:item>"+noCuenta+"</pub:item>\n"
                + "                  </pub:values>\n"
                + "               </pub:item>\n"
                + "               <pub:item>\n"
                + "                  <pub:name>FROM_DATE</pub:name>\n"
                + "                  <multiValuesAllowed>TRUE</multiValuesAllowed>\n"
                + "                  <pub:values>\n"
                + "                     <pub:item>"+fechaInicio+"</pub:item>\n"
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
        
        
        System.out.println("Encoded Authorization String for FinLitLog is :" + encodedAuthorization);
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

//Read the response.
        InputStreamReader isr
                = new InputStreamReader(httpConn.getInputStream());
        BufferedReader in = new BufferedReader(isr);

//Write the SOAP message response to a String.
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
//Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
        Document document = parseXmlFile(outputString);
        NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
        String resultado = nodeLst.item(0).getTextContent();
        System.out.println("ns2:reportBytes HEX: " + resultado);
        //Write the SOAP message formatted to the console.
        String formattedSOAPResponse = formatXML(outputString);
        System.out.println(formattedSOAPResponse);
        return resultado;
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

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        adaptadorWS weatherWebserviceTester
                = new adaptadorWS();
        try {
            weatherWebserviceTester.getOBI_RunReport("11-05-2018","11-05-2018","0521838999");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
