/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

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
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.frisa.tic.datos.dto.ingresos.CreditMemoDTO;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.NotaCreditoListaDTO;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaMetodoPagoDTO;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import mx.frisa.tic.negocio.utils.PropiedadesFRISA;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author USER_1
 */
public class AdaptadorWS {

    public RespuestaERP_Edo_Cuenta getOBI_generarFacturaAlCobro(List<FacturaPagoDTO> facturas) throws MalformedURLException, IOException {

        String xmlInput = "<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" \n"
                + "xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" \n"
                + "xmlns:tran=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderDff/\"\n"
                + "xmlns:tran1=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionHeaderGdf/\"  \n"
                + "xmlns:tran4=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/shared/model/flex/TransactionLineDff/\" \n"
                + "xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\" \n"
                + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "<soapenv:Body>\n"
                + "      <typ:createSimpleInvoice>\n"
                + "         <typ:invoiceHeaderInformation>\n"
                + "            <inv:BusinessUnit>LMF MUNDO E - RENTAS</inv:BusinessUnit>\n"
                + "            <inv:TransactionSource>RENTA</inv:TransactionSource>\n"
                + "            <inv:TransactionType>FAC_INGRESOS_MN</inv:TransactionType>\n"
                + "            <inv:TrxDate>2018-09-08</inv:TrxDate>\n"
                + "            <inv:GlDate>2018-09-08</inv:GlDate>\n"
                + "            <inv:BillToCustomerName>Nueva Wal-Mart DE MEXICO SA DE CV</inv:BillToCustomerName>\n"
                + "            <inv:BillToAccountNumber>10249</inv:BillToAccountNumber>\n"
                + "            <inv:PaymentTermsName>IMMEDIATE</inv:PaymentTermsName>\n"
                + "            <inv:InvoiceLine>\n"
                + "               <inv:LineNumber>1</inv:LineNumber>\n"
                + "               <inv:MemoLineName>FACTURA RENTA MENSUAL LOCAL</inv:MemoLineName>\n"
                + "               <inv:Description>FACTURA RENTA MENSUAL LOCAL</inv:Description>\n"
                + "               <inv:Quantity>1</inv:Quantity>\n"
                + "               <inv:UnitSellingPrice>45000</inv:UnitSellingPrice>\n"
                + "               <inv:TaxClassificationCode>IVA 16% AR</inv:TaxClassificationCode>\n"
                + "               <inv:TransactionLineFLEX xsi:type=\"tran4:Rentas\">\n"
                + "                  <tran4:descripciOnAdicional1>Des 1 JP</tran4:descripciOnAdicional1>\n"
                + "                  <tran4:descripciOnAdicional2>Des 2 JP</tran4:descripciOnAdicional2>\n"
                + "                  <tran4:descripciOnAdicional3>Des 3 JP</tran4:descripciOnAdicional3>\n"
                + "                  <tran4:descripciOnAdicional4>Des 4 JP</tran4:descripciOnAdicional4>\n"
                + "                  <tran4:descripciOnAdicional5>Des 5 JP</tran4:descripciOnAdicional5>\n"
                + "                  <tran4:periodoDeFacturacionDesde>01-09-2018</tran4:periodoDeFacturacionDesde>\n"
                + "                  <tran4:periodoDeFacturacionHasta>31-09-2018</tran4:periodoDeFacturacionHasta>\n"
                + "                  <tran4:__FLEX_Context>RENTAS</tran4:__FLEX_Context>\n"
                + "                  <tran4:siguienteFechaDeExigibilidad>31-09-2018</tran4:siguienteFechaDeExigibilidad>\n"
                + "               </inv:TransactionLineFLEX>\n"
                + "            </inv:InvoiceLine>\n"
                + "			<inv:InvoiceLine>\n"
                + "               <inv:LineNumber>2</inv:LineNumber>\n"
                + "               <inv:MemoLineName>FACTURA VARIOS SERVICIOS</inv:MemoLineName>\n"
                + "               <inv:Description>FACTURA VARIOS SERVICIOS</inv:Description>\n"
                + "               <inv:Quantity>1</inv:Quantity>\n"
                + "               <inv:UnitSellingPrice>45000</inv:UnitSellingPrice>\n"
                + "               <inv:TaxClassificationCode>IVA 16% AR</inv:TaxClassificationCode>\n"
                + "               <inv:TransactionLineFLEX xsi:type=\"tran4:Rentas\">\n"
                + "                  <tran4:descripciOnAdicional1>Des 1 JP</tran4:descripciOnAdicional1>\n"
                + "                  <tran4:descripciOnAdicional2>Des 2 JP</tran4:descripciOnAdicional2>\n"
                + "                  <tran4:descripciOnAdicional3>Des 3 JP</tran4:descripciOnAdicional3>\n"
                + "                  <tran4:descripciOnAdicional4>Des 4 JP</tran4:descripciOnAdicional4>\n"
                + "                  <tran4:descripciOnAdicional5>Des 5 JP</tran4:descripciOnAdicional5>\n"
                + "                  <tran4:periodoDeFacturacionDesde>01-09-2018</tran4:periodoDeFacturacionDesde>\n"
                + "                  <tran4:periodoDeFacturacionHasta>31-09-2018</tran4:periodoDeFacturacionHasta>\n"
                + "                  <tran4:__FLEX_Context>RENTAS</tran4:__FLEX_Context>\n"
                + "                  <tran4:siguienteFechaDeExigibilidad>31-09-2018</tran4:siguienteFechaDeExigibilidad>\n"
                + "               </inv:TransactionLineFLEX>\n"
                + "            </inv:InvoiceLine>\n"
                + "            <inv:TransactionHeaderFLEX xsi:type=\"tran:Rentas\">\n"
                + "               <tran:proyecto>151</tran:proyecto>\n"
                + "               <tran:folio>J-000-001</tran:folio>\n"
                + "               <tran:__FLEX_Context>RENTAS</tran:__FLEX_Context>\n"
                + "               <tran:nUmeroDeLocal>24JPL</tran:nUmeroDeLocal>\n"
                + "            </inv:TransactionHeaderFLEX>\n"
                + "         </typ:invoiceHeaderInformation>\n"
                + "      </typ:createSimpleInvoice>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

//Code to make a webservice HTTP request
        RespuestaERP_Edo_Cuenta respestaWS = new RespuestaERP_Edo_Cuenta();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));
        String responseString = "";
        String outputString = "";
        String wsURL = "https://efar-test.fin.us2.oraclecloud.com:443/fscmService/RecInvoiceService";

        String SOAPAction
                = "http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/";

        //Ready with sending the request.
        try {
            //Read the response.

            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, "text/xml; charset=UTF-8");
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

    private String inyectaParametro(String pPayload, String nombreParametro, String valor) {
        String parametro = "_PARAM" + nombreParametro + "_";
        pPayload = pPayload.replaceAll(parametro, valor);
        return pPayload;
    }

    
    private String inyectaParametroNota(String pPayload, String nombreParametro, String valor) {
        pPayload = pPayload.replaceAll(nombreParametro, valor);
        return pPayload;
    }

    public RespuestaERP_Edo_Cuenta getERP_ejecutarReporteEdoCuenta(String fechaInicio, String fechaFinal, String noCuenta) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaERP_Edo_Cuenta respestaWS = new RespuestaERP_Edo_Cuenta();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));

        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("edoCuentaServiceEndPoint");

        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("edoCuentaServicePayload"));

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("edoCuentaServiceSoapAction");

        //Ready with sending the request.
        try {
            //Read the response.
            xmlInput = inyectaParametro(xmlInput, "FROM-DATE", fechaInicio);
            xmlInput = inyectaParametro(xmlInput, "TO-DATE", fechaFinal);
            xmlInput = inyectaParametro(xmlInput, "BANK_ACCOUNT_NUMBER", noCuenta);

            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("edoCuentaServiceContentType"));

//            outputString = consumir.getEstadosCuenta(fechaInicio, fechaFinal, noCuenta);

            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            respestaWS.setDATA_DSObject((DATA_DS) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), new DATA_DS()));

//            respestaWS.setDATA_DSObject((DATA_DS) respuestaXMLaPOJO(getCadenaDesdeB64(outputString), new DATA_DS()));
        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", "ERROR"));
        }
        return respestaWS;
    }

    public RespuestaMetodoPagoDTO getERP_obtenerMetodosCargaInicial() throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaMetodoPagoDTO respestaWS = new RespuestaMetodoPagoDTO();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));;

        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoTodosServiceEndPoint");

        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoTodosServicePayload"));

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoTodosServiceSoapAction");

        //Ready with sending the request.
        try {
            xmlInput = inyectaParametro(xmlInput, "BU_Name", "CARGA INICIAL");
            //Read the response.
//            ConsumirBI consumir = new ConsumirBI();
            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoTodosServiceContentType"));
//            outputString = consumir.getMetodosPago("123", "", "");

            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            MetodoPagoOBI metodos = new MetodoPagoOBI();
            metodos = (MetodoPagoOBI) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), metodos);
            respestaWS.setProceso(new Proceso("0", "EXITOSO"));
            respestaWS.setMetodosPago(metodos);

        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", ex.getLocalizedMessage()));
        }
        return respestaWS;
    }

    public RespuestaDTO getERP_obtenerMetodosPorID(String pORG_ID, String pCuentaBancaria) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaDTO respestaWS = new RespuestaDTO();
        respestaWS.setProceso("EXITOSO");

        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoPorIDServiceEndPoint");

        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoPorIDServicePayload"));

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoPorIDServiceSoapAction");

        //Ready with sending the request.
        try {
            //Read the response.
//            ConsumirBI consumir = new ConsumirBI();

            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetMetodosPagoTodosServiceContentType"));
//            outputString = consumir.getMetodosPago(pORG_ID, pCuentaBancaria, "NO ES CARGA INICIAL");
            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            respestaWS.setIdError("0");
            respestaWS.setDescripcionError("");

        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setIdError("100");
            respestaWS.setDescripcionError(ex.getLocalizedMessage());
        }
        return respestaWS;
    }

    public RespuestaERP_EncabezadoRecibo getERP_generarEncabezadoRecibo(PagoDTO pagos) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaERP_EncabezadoRecibo respestaWS = new RespuestaERP_EncabezadoRecibo();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));
        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("encabezadoFacturaServiceEndPoint");

//        for (PagoDTO pagoDto : pagos) {
        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("encabezadoFacturaServicePayload"));

        xmlInput = inyectaParametro(xmlInput, "com:Amount", pagos.getMonto());
        xmlInput = inyectaParametro(xmlInput, "com:Comments", "");
        xmlInput = inyectaParametro(xmlInput, "currencyCode", pagos.getMoneda());
        xmlInput = inyectaParametro(xmlInput, "com:CurrencyCode", pagos.getMoneda());
        xmlInput = inyectaParametro(xmlInput, "com:GlDate", "2018-12-17");
        xmlInput = inyectaParametro(xmlInput, "com:OrgId", pagos.getUnidadNegocio());
        xmlInput = inyectaParametro(xmlInput, "com:ReceiptDate", "2018-12-17");
        xmlInput = inyectaParametro(xmlInput, "com:ReceiptMethodId", pagos.getMetodoId());
        xmlInput = inyectaParametro(xmlInput, "com:ReceiptNumber", pagos.getNroRecibo());

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("encabezadoFacturaServiceSoapAction");

        //Ready with sending the request.
        try {
            //Read the response.
            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("encabezadoFacturaServiceContentType"));
            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            if (outputString.indexOf("=_Part") > -1) {
                outputString = outputString.substring(outputString.indexOf("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"), outputString.lastIndexOf("</env:Envelope>") + 15);
            }
            System.out.println("outputString : " + outputString);

            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns3:CashReceiptId");
            String resultado = nodeLst.item(0).getTextContent();

            respestaWS.setNumeroRecibo(resultado);
            System.out.println("resultado : " + resultado);
        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", "ERROR"));
        }

//        }
        return respestaWS;
    }

    public RespuestaERP_EncabezadoRecibo getERP_AplicarPago(List<PagoDTO> pagos) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaERP_EncabezadoRecibo respestaWS = new RespuestaERP_EncabezadoRecibo();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));
        String responseString = "";
        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServiceEndPoint");

        for (PagoDTO pagoDto : pagos) {
            if (pagoDto.getNroRecibo().equals("")) {
                continue;
            }
            String xmlInput
                    = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServicePayload"));

            String SOAPAction
                    = PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServiceSoapAction");

            //Ready with sending the request.
            try {
                //Inyectar parametros a la peticion
                xmlInput = inyectaParametro(xmlInput, "com:AmountApplied", pagoDto.getMonto());
                xmlInput = inyectaParametro(xmlInput, "com:ReceiptNumber", pagoDto.getNroRecibo());
                xmlInput = inyectaParametro(xmlInput, "com:TransactionNumber", pagoDto.getIdCabeceraRecibo() + "");
                xmlInput = inyectaParametro(xmlInput, "com:TransactionDate", pagoDto.getFechaCreacion());
                xmlInput = inyectaParametro(xmlInput, "com:CustomerName", pagoDto.getBillCustomerName());
                xmlInput = inyectaParametro(xmlInput, "com:ApplicationDate", pagoDto.getFechaAplicacion());
                xmlInput = inyectaParametro(xmlInput, "com:AccountingDate", pagoDto.getFechaContable());

                //Read the response.
                outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServiceContentType"));

                //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
                if (outputString.indexOf("=_Part") > -1) {
                    outputString = outputString.substring(outputString.indexOf("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"), outputString.lastIndexOf("</env:Envelope>") + 15);
                }

                System.out.println("outputString : " + outputString);

                Document document = parseXmlFile(outputString);
                NodeList nodeLst = document.getElementsByTagName("ns3:CashReceiptId");
                String resultado = nodeLst.item(0).getTextContent();

                //Write the SOAP message formatted to the console.
//                    String formattedSOAPResponse = formatXML(outputString);
                respestaWS.setNumeroRecibo(resultado);
                System.out.println("resultado : " + resultado);
            } catch (Exception ex) {
                ex.printStackTrace();
                respestaWS.setProceso(new Proceso("100", "ERROR"));
            }

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

    public String enviarMsg(String endPoint, String SOAPAction, String msg, String contentType)
            throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        String outputString = "";
        RespuestaERP_Edo_Cuenta respestaWS = new RespuestaERP_Edo_Cuenta();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));
        String responseString = "";
        String wsURL = endPoint;
//        URL url = new URL(wsURL);

        URL url = new URL(null, wsURL, new sun.net.www.protocol.https.Handler());
        URLConnection connection = url.openConnection();
        HttpsURLConnection httpConn = (HttpsURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput
                = msg;
        System.out.println("msg : " + msg);
        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length",
                String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", contentType);
        String encodedAuthorization = PropiedadesFRISA.recuperaPropiedadBackend("autinticaBasico");

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
            System.out.println("Respuesta :");
            System.out.println(outputString);
        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", "ERROR"));
        }
        return outputString;
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
        System.out.println(str);
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
            throw new JsonSyntaxException("Failed : " + ex.getMessage());
        }

        return vObj;
    }

    public Object respuestaXMLaPOJO(String xmlOrigen, Object clase) throws IOException {
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

//            RespuestaERP_Edo_Cuenta respuesta = adaptadorWS.getERP_ejecutarReporteEdoCuenta("11-05-2018", "11-05-2018", "0521838999");
            RespuestaMetodoPagoDTO respuesta = adaptadorWS.getERP_obtenerMetodosCargaInicial();

            System.out.println(respuesta.getProceso());

//            List<PagoDTO> pagosDto = new ArrayList<PagoDTO>();
//            pagosDto.add(new PagoDTO(BigDecimal.ONE, BigDecimal.ONE, "02546545455", "11234567890123145", "123",
//                    "MXN", "300000002785501", "TEST-016", "1000", "2018-12-05", "", "300000007076442"));
//            RespuestaERP_EncabezadoRecibo respuesta = adaptadorWS.getERP_generarEncabezadoRecibo(pagosDto);
//            RespuestaERP_Edo_Cuenta respuesta = adaptadorWS.getOBI_generarFacturaAlCobro(null);
//            System.out.println(respuesta.getProceso().getTermino());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public RespuestaERP_Nota_Credito getERP_ejecutarNotaCredito(CreditMemoDTO nota) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {
        RespuestaERP_Nota_Credito respuestaWS = new RespuestaERP_Nota_Credito();
        respuestaWS.setProceso(new Proceso("0", "EXITOSO"));
        List<DATA_DS> lista = null;
        String outputString = "";
//        System.err.println("Endpoint: "+PropiedadesFRISA.recuperaPropiedadBackend("GetGeneraNotaCreditoServiceEndPoint"));
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetGeneraNotaCreditoServiceEndPoint");
        try{
//            System.err.println("Llamando WS - ERP: Nota de Crédito");
            String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetGeneraNotaCreditoServicePayload"));
            String SOAPAction
                    = PropiedadesFRISA.recuperaPropiedadBackend("edoCuentaServiceSoapAction");
            xmlInput = inyectaParametroNota(xmlInput, "_BATCHSOURCESEQUENCEID", nota.getBatchSourceSequenceId().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_CUSTOMERTRANSACTIONID", nota.getCustomerReference());
            xmlInput = inyectaParametroNota(xmlInput, "_COMMENTS", nota.getComments());
            xmlInput = inyectaParametroNota(xmlInput, "_CUSTOMERTRANSACTIONTYPESEQUENCEID", nota.getCustomerTransactionTypeSequenceId().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_CUSTOMERREFERENCEDATE", nota.getCustomerReferenceDate().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_CUSTOMERREFERENCE", nota.getCustomerReference());
            xmlInput = inyectaParametroNota(xmlInput, "_DOCUMENTSEQUENCEID", nota.getDocumentSequenceId().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_DOCUMENTSEQUENCEVALUE", nota.getDocumentSequenceValue().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_FREIGHTAMOUNT", nota.getFreightAmount().getValue().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_FREIGHTPERCENT", nota.getFreightPercent().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_GLDATE", nota.getGlDate().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_INTERNALNOTES", nota.getInternalNotes());
            xmlInput = inyectaParametroNota(xmlInput, "_LINEAMOUNT", nota.getLineAmount().getValue().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_LINEPERCENT", nota.getLinePercent().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_METHODFORRULES", nota.getMethodForRules());
            xmlInput = inyectaParametroNota(xmlInput, "_PREVIOUSCUSTOMERTRANSACTIONID", nota.getPreviousCustomerTransactionId().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_REASONCODE", nota.getReasonCode());
            xmlInput = inyectaParametroNota(xmlInput, "_SPLITTERMINATIONMETHOD", nota.getSplitTerminationMethod());
            xmlInput = inyectaParametroNota(xmlInput, "_TRANSACTIONDATE", nota.getTransactionDate().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_CURRENCYCODE", nota.getCurrencyCode());
            xmlInput = inyectaParametroNota(xmlInput, "_TRANSACTIONNUMBER", nota.getTransactionNumber());
            xmlInput = inyectaParametroNota(xmlInput, "_TAXAMOUNT", nota.getTaxAmount().getValue().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_TAXPERCENT", nota.getTaxPercent().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_COMPUTETAX", nota.getComputeTax());
            xmlInput = inyectaParametroNota(xmlInput, "_CUSTOMERTRXID", nota.getCreditMemoFLEXVA().getCustomerTrxId().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_PROYECTO", nota.getCreditMemoFLEXVA().getProyecto());
            xmlInput = inyectaParametroNota(xmlInput, "_ESTATUSDECFDI", nota.getCreditMemoFLEXVA().getEstatusDeCfdi());
            xmlInput = inyectaParametroNota(xmlInput, "_USODECFDI", nota.getCreditMemoFLEXVA().getUsoDeCfdi());
            xmlInput = inyectaParametroNota(xmlInput, "_FORMADEPAGO", nota.getCreditMemoFLEXVA().getFormaDePago());
            xmlInput = inyectaParametroNota(xmlInput, "_FOLIODECANCELACIONSAT", nota.getCreditMemoFLEXVA().getFolioDeCancelaciOnSat());
            xmlInput = inyectaParametroNota(xmlInput, "_UUIDDOCUMENTORELACIONADO", nota.getCreditMemoFLEXVA().getUuidDocumentoRelacionado());
            xmlInput = inyectaParametroNota(xmlInput, "_NUMERODECONTRATO", nota.getCreditMemoFLEXVA().getNumeroDeContrato());
            xmlInput = inyectaParametroNota(xmlInput, "_LINEADECAPTURA", nota.getCreditMemoFLEXVA().getLineaDeCaptura());
            xmlInput = inyectaParametroNota(xmlInput, "_SERIE", nota.getCreditMemoFLEXVA().getSerie());
            xmlInput = inyectaParametroNota(xmlInput, "_FOLIO", nota.getCreditMemoFLEXVA().getFolio());
            xmlInput = inyectaParametroNota(xmlInput, "_FECHADEPRESCRIPCION", nota.getCreditMemoFLEXVA().getFechaDePrescripcion());
            xmlInput = inyectaParametroNota(xmlInput, "_FECHATIMBRADO", nota.getCreditMemoFLEXVA().getFechaTimbrado());
            xmlInput = inyectaParametroNota(xmlInput, "_ADDENDAID", nota.getCreditMemoFLEXVA().getAddendaid());
            xmlInput = inyectaParametroNota(xmlInput, "_FLEX_CONTEXT", nota.getCreditMemoFLEXVA().getFLEXContext());
            xmlInput = inyectaParametroNota(xmlInput, "_DISPLAYVALUE", nota.getCreditMemoFLEXVA().getFLEXContextDisplayValue());
            xmlInput = inyectaParametroNota(xmlInput, "_FLEX_NUMOFSEGMENTS", nota.getCreditMemoFLEXVA().getFLEXNumOfSegments().toString());
            xmlInput = inyectaParametroNota(xmlInput, "_FLEX_NUMOFSEGMENTS", nota.getCreditMemoFLEXVA().getFLEXNumOfSegments().toString());
            try{
                outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetGeneraNotaCreditoContentType"));
                if (outputString.indexOf("=_Part") > -1) {
                    outputString = outputString.substring(outputString.indexOf("<?xml version=\"1.0\" encoding=\"utf-8\" ?>"), outputString.lastIndexOf("env:Envelope>") + 13);
                }
                Document document = parseXmlFile(outputString);
                NodeList nodeLst;
                nodeLst = document.getElementsByTagName("ns2:reportBytes");
                if(nodeLst.getLength()>0){
                    respuestaWS.setProceso(new Proceso("0","EXITOSO"));
                }else{
                    nodeLst = document.getElementsByTagName("faultstring");
                    respuestaWS.setProceso(new Proceso("100","Eror en WS ERP : "+nodeLst.item(0).getTextContent()));
            }
//                String resultado = nodeLst.item(0).getTextContent();
//                lista.add((DATA_DS) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), new DATA_DS()));
            }catch(Exception ex){
                ex.printStackTrace();
                respuestaWS.setProceso(new Proceso("100", "Eror en WS ERP : "+ex.toString()));
            }
        }
        catch(Exception Ex){
//            System.err.println(Ex.getLocalizedMessage());
            Ex.printStackTrace();
        }
        respuestaWS.setDATA_DSObject(lista);
        return respuestaWS;
    }
}
