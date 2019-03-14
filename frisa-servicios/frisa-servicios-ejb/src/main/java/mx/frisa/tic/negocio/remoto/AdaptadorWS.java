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
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.ingresos.CreditMemoDTO;
import mx.frisa.tic.datos.dto.ingresos.CreditMemoFLEXDTO;
import mx.frisa.tic.datos.dto.ingresos.CuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.NotaCreditoListaDTO;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCentroCostoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaMetodoPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaUnidadNegocioDTO;
import mx.frisa.tic.datos.entidades.XxfrCabeceraFactura;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import mx.frisa.tic.negocio.utils.PropiedadesFRISA;
import mx.frisa.tic.utils.FechaUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author USER_1
 */
public class AdaptadorWS {

    public RespuestaCreaFactura getOBI_generarFacturaAlCobro(List<FacturaPagoDTO> facturas) throws MalformedURLException, IOException {

        System.err.println("Entró al método de factura al cobro");
        String xmlInput = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("generaFacturaServicePayload"));
        System.err.println("XML-Factura a enviar: " + xmlInput);
//Code to make a webservice HTTP request
        RespuestaCreaFactura respestaWS = new RespuestaCreaFactura();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));
        String outputString = "";
        List<FacturaPagoDTO> facturasProcesadas = new ArrayList();
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("generaFacturaServiceEndPoint");

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("generaFacturaServiceSoapAction");
        String tipoContenido
                = PropiedadesFRISA.recuperaPropiedadBackend("generaFacturaServiceContentType");

        //Ready with sending the request.
        try {
            //Genera todas las facturas al cobro detectadas
            for (FacturaPagoDTO factura : facturas) {
                //Parametrizar mensaje
                xmlInput = inyectaParametro(xmlInput, "inv:BusinessUnit", factura.getBusinessunitname());
                xmlInput = inyectaParametro(xmlInput, "inv:TransactionSource", factura.getTransactionsource());
                xmlInput = inyectaParametro(xmlInput, "inv:TransactionType", factura.getTransactiontype());
                xmlInput = inyectaParametro(xmlInput, "inv:TrxDate", FechaUtils.convierteHoy().substring(0, 10));
                xmlInput = inyectaParametro(xmlInput, "inv:GlDate", FechaUtils.convierteHoy().substring(0, 10));
                xmlInput = inyectaParametro(xmlInput, "inv:BillToCustomerName", factura.getBilltoconsumername());
                xmlInput = inyectaParametro(xmlInput, "inv:BillToAccountNumber", factura.getBilltolocation() + "");
                String terminoPago = "";
                if (factura.getPaymenttermdays() > 0) {
                    terminoPago = "IMMEDIATE";
                } else {
                    terminoPago = factura.getPaymenttermdays().toString();
                }
                xmlInput = inyectaParametro(xmlInput, "inv:PaymentTermsName", terminoPago);
                xmlInput = inyectaParametro(xmlInput, "inv:LineNumber", factura.getIdlinea());
                xmlInput = inyectaParametro(xmlInput, "inv:MemoLineName", factura.getMemolinename());
                xmlInput = inyectaParametro(xmlInput, "inv:Description", factura.getDescription_origen());
                xmlInput = inyectaParametro(xmlInput, "inv:Quantity", factura.getQuantity() + "");
                xmlInput = inyectaParametro(xmlInput, "inv:UnitSellingPrice", factura.getMontobrutolinea() + "");
                xmlInput = inyectaParametro(xmlInput, "inv:TaxClassificationCode", factura.getTransactionsource());
                xmlInput = inyectaParametro(xmlInput, "tran4:descripciOnAdicional1", factura.getDescadicional1());
                xmlInput = inyectaParametro(xmlInput, "tran4:descripciOnAdicional2", factura.getDescadicional2());
                xmlInput = inyectaParametro(xmlInput, "tran4:descripciOnAdicional3", factura.getDescadicional3());
                xmlInput = inyectaParametro(xmlInput, "tran4:descripciOnAdicional4", factura.getDescadicional4());
                xmlInput = inyectaParametro(xmlInput, "tran4:descripciOnAdicional5", factura.getDescadicional5());
                xmlInput = inyectaParametro(xmlInput, "tran4:periodoDeFacturacionDesde", factura.getFechadesde());
                xmlInput = inyectaParametro(xmlInput, "tran4:periodoDeFacturacionHasta", factura.getFechahasta());
                xmlInput = inyectaParametro(xmlInput, "tran4:siguienteFechaDeExigibilidad", factura.getFechaexigibilidad());
                xmlInput = inyectaParametro(xmlInput, "tran:proyecto", factura.getProjectid() + "");
                xmlInput = inyectaParametro(xmlInput, "tran:folio", "SI-" + factura.getLinenumber());
                xmlInput = inyectaParametro(xmlInput, "tran:nUmeroDeLocal", factura.getLocalnumber() + "");
                System.err.println("XML-Factura a enviar: " + xmlInput);

                outputString = enviarMsg(wsURL, SOAPAction, xmlInput, tipoContenido);
                //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
                Document document = parseXmlFile(outputString);
                NodeList nodeLstServiceStatus = document.getElementsByTagName("ns2:ServiceStatus");

                String serviceStatus = recuperarValorDesdeNodo(outputString, "ns2:ServiceStatus");
                String transactionNumber = recuperarValorDesdeNodo(outputString, "ns2:TransactionNumber");
                String customerTrxId = recuperarValorDesdeNodo(outputString, "ns2:CustomerTrxId");

                factura.setTransactionID_ERP(Integer.valueOf(transactionNumber));
                factura.setServiceStatus_ERP(serviceStatus);
                factura.setCustomerTrxID_ERP(customerTrxId);
                facturasProcesadas.add(factura);

            }
            //        System.out.println(formattedSOAPResponse);
        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", "ERROR"));
        }
        respestaWS.setFacturas(facturasProcesadas);
        return respestaWS;
    }

    private String inyectaParametro(String pPayload, String nombreParametro, String valor) {
        String parametro = "_PARAM" + nombreParametro + "_";
        if (valor == null) {
            valor = "";
        }
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
        ManejadorLog log = new ManejadorLog();

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
            log.error(ex, this.getClass());
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

    public RespuestaCuentaBancariaDTO getERP_obtenerCuentaBancaria() throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaCuentaBancariaDTO respestaWS = new RespuestaCuentaBancariaDTO();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));;

        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetConsultaCuentaBancariaServiceEndPoint");

        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetConsultaCuentaBancariaServicePayload"));

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("GetConsultaCuentaBancariaServiceSoapAction");

        //Ready with sending the request.
        try {
            xmlInput = inyectaParametro(xmlInput, "BU_Name", "CARGA INICIAL");
            //Read the response.
//            ConsumirBI consumir = new ConsumirBI();
            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetConsultaCuentaBancariaServiceContentType"));
//            outputString = consumir.getMetodosPago("123", "", "");

            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            RespuestaERP_Cuenta respuestaERP_Cuenta = new RespuestaERP_Cuenta();
            respuestaERP_Cuenta = (RespuestaERP_Cuenta) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), new RespuestaERP_Cuenta());
            respestaWS.setProceso(new Proceso("0", "EXITOSO"));
            respestaWS.setCuentaBancaria(respuestaERP_Cuenta);

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

        xmlInput = inyectaParametro(xmlInput, "ORG_ID", pORG_ID);
        xmlInput = inyectaParametro(xmlInput, "BANK_ACCOUNT_NUMBER", pCuentaBancaria);
        xmlInput = inyectaParametro(xmlInput, "BU_Name", "NO_ES_CARGA_INICIAL");

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
            String resultado = "";
            if (nodeLst.getLength() == 0) //Dato fijo del idMetodoPago efecto prueba
            {
                respestaWS.setDescripcionError("300000007076478");
            } else {
                resultado = nodeLst.item(0).getTextContent();
            }

            //Write the SOAP message formatted to the console.
            respestaWS.setIdError("0");

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
        xmlInput = inyectaParametro(xmlInput, "com:GlDate", FechaUtils.convierteHoyFecha());
        xmlInput = inyectaParametro(xmlInput, "com:OrgId", pagos.getUnidadNegocio());
        xmlInput = inyectaParametro(xmlInput, "com:CustomerId", pagos.getCustomerId());
        xmlInput = inyectaParametro(xmlInput, "com:ReceiptDate", FechaUtils.convierteHoyFecha());
        xmlInput = inyectaParametro(xmlInput, "com:ReceiptMethodId", pagos.getMetodoId());
        xmlInput = inyectaParametro(xmlInput, "com:ReceiptNumber", "10" + pagos.getIdEdoCta());

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("encabezadoFacturaServiceSoapAction");
        System.err.println("XML-Pagos a enviar: " + xmlInput);

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
            respestaWS.setProceso(new Proceso("100", "ERROR : " + ex.getLocalizedMessage()));
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

    public RespuestaERP_EncabezadoRecibo getERP_AplicarPago(PagoDTO pagoDto, List<XxfrCabeceraFactura> pLstFacturas) throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaERP_EncabezadoRecibo respestaWS = new RespuestaERP_EncabezadoRecibo();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));
        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServiceEndPoint");

        if (pagoDto.getNroRecibo().equals("")) {
            respestaWS.setProceso(new Proceso("1001", "No existe numero de recibo para aplicacion del pago"));
            return respestaWS;
        }

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServiceSoapAction");

        //Ready with sending the request.
        try {

            for (XxfrCabeceraFactura facturasEnt : pLstFacturas) {
                if (!facturasEnt.getGenerationtype().equals("ONLY_CAPTURE_LINE")) {

                    String xmlInput
                            = getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServicePayload"));

                    //Inyectar parametros a la peticion
                    xmlInput = inyectaParametro(xmlInput, "com:ReceiptId", pagoDto.getNroRecibo()); //RECIBO ERP
                    xmlInput = inyectaParametro(xmlInput, "com:ReceiptNumber", "10" + pagoDto.getIdEdoCta()); //RECIBO NUESTRO SecuencialInterno

                    xmlInput = inyectaParametro(xmlInput, "com:CustomerTrxId", facturasEnt.getCustomerTrxID_erp() + ""); // FACTURA ERP
                    xmlInput = inyectaParametro(xmlInput, "com:TransactionNumber", facturasEnt.getTransactioNumber_erp() + ""); //FACTURA
//            xmlInput = inyectaParametro(xmlInput, "com:CustomerTrxId", pLstFacturas.get(0).getCustomerTrxID_erp() + ""); // FACTURA ERP
//            xmlInput = inyectaParametro(xmlInput, "com:TransactionNumber", pLstFacturas.get(0).getTransactioNumber_erp() + ""); //FACTURA
                    xmlInput = inyectaParametro(xmlInput, "com:AmountApplied", facturasEnt.getTotalamount() + "");//Monto Factura

//            xmlInput = inyectaParametro(xmlInput, "com:AmountApplied", "7000");//Monto Factura
                    xmlInput = inyectaParametro(xmlInput, "com:CustomerName", pagoDto.getBillCustomerName()); //CLIENTE
                    xmlInput = inyectaParametro(xmlInput, "com:ApplicationDate", pagoDto.getFechaAplicacion());
                    xmlInput = inyectaParametro(xmlInput, "com:AccountingDate", pagoDto.getFechaContable());
                    System.out.println("peticion " + xmlInput);
                    //Read the response.
                    outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("aplicaPagoFacturaServiceContentType"));

                    //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
                    if (outputString.indexOf("=_Part") > -1) {
                        outputString = outputString.substring(outputString.indexOf("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"), outputString.lastIndexOf("</env:Envelope>") + 15);
                    }

                    System.out.println("outputString : " + outputString);

                    Document document = parseXmlFile(outputString);
                    NodeList nodeLst = document.getElementsByTagName("wsa:MessageID");
                    String resultado = nodeLst.item(0).getTextContent();

                    //Write the SOAP message formatted to the console.
//                    String formattedSOAPResponse = formatXML(outputString);
                    respestaWS.setNumeroRecibo(resultado);
                    System.out.println("resultado : " + resultado);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("107", "ERROR"));
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

        ManejadorLog log = new ManejadorLog();
        String responseString = "";
        String wsURL = endPoint;
//        URL url = new URL(wsURL);

        log.debug("wsURL : " + wsURL);
        URL url = new URL(null, wsURL, new sun.net.www.protocol.https.Handler());
        URLConnection connection = url.openConnection();
        HttpsURLConnection httpConn = (HttpsURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput
                = msg;
        log.debug("msg : " + msg);
        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length",
                String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", contentType);
        httpConn.setRequestProperty("Accept-Encoding", "gzip");
        String encodedAuthorization = PropiedadesFRISA.recuperaPropiedadBackend("autinticaBasico");

        //        System.out.println("Encoded Authorization String for FinLitLog is :" + encodedAuthorization);
        httpConn.setRequestProperty("Authorization", "Basic " + encodedAuthorization);

        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(httpConn.getOutputStream(), "UTF-8"));
        bw.write(xmlInput);
        bw.flush();
        bw.close();
        //Ready with sending the request.
        InputStreamReader isr = null;
        if (httpConn.getResponseCode() == 200) {
            log.debug(httpConn.getResponseMessage());
            log.debug(httpConn.toString());
            if (httpConn.getContentEncoding().equals("gzip")) {
                isr = new InputStreamReader(new GZIPInputStream(httpConn.getInputStream()));
            } else {
                isr = new InputStreamReader(httpConn.getInputStream());
            }
        } else {
            if (httpConn.getContentEncoding().equals("gzip")) {
                isr = new InputStreamReader(new GZIPInputStream(httpConn.getErrorStream()));
            } else {
                isr = new InputStreamReader(httpConn.getErrorStream());

            }
        }
        BufferedReader in = new BufferedReader(isr);

        //Write the SOAP message response to a String.
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
        log.debug("Respuesta :");
        log.debug(outputString);
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
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetGeneraNotaCreditoServiceEndPoint");
        try {
            String xmlInput
                    = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetGeneraNotaCreditoServicePayload"));
            String SOAPAction
                    = PropiedadesFRISA.recuperaPropiedadBackend("edoCuentaServiceSoapAction");

            xmlInput = inyectaParametro(xmlInput, "cred:BatchSourceSequenceId", nota.getBatchSourceSequenceId()+"");
            xmlInput = inyectaParametro(xmlInput, "cred:Comments", nota.getComments());
            xmlInput = inyectaParametro(xmlInput, "cred:GlDate", nota.getGlDate()+"");
            xmlInput = inyectaParametro(xmlInput, "cred:CustomerTransactionTypeSequenceId", nota.getCustomerTransactionTypeSequenceId()+"");
            xmlInput = inyectaParametro(xmlInput, "cred:BatchSourceSequenceId", nota.getBatchSourceSequenceId()+"");
            xmlInput = inyectaParametro(xmlInput, "cred:LinePercent", nota.getLinePercent()+"");
            xmlInput = inyectaParametro(xmlInput, "cred:TransactionDate", nota.getTransactionDate()+"");
            xmlInput = inyectaParametro(xmlInput, "cred:CurrencyCode", nota.getCurrencyCode()+"");
            xmlInput = inyectaParametro(xmlInput, "cred:PreviousCustomerTransactionId", nota.getPreviousCustomerTransactionId()+"");
            xmlInput = inyectaParametro(xmlInput, "cred1:__FLEX_Context", nota.getCreditMemoFLEXVA().getFLEXContext()+"");
            xmlInput = inyectaParametro(xmlInput, "cred1:CustomerTrxId", nota.getCreditMemoFLEXVA().getCustomerTrxId()+"");
            xmlInput = inyectaParametro(xmlInput, "cred1:proyecto", nota.getCreditMemoFLEXVA().getProyecto()+"");

            try {
                outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetGeneraNotaCreditoContentType"));
                if (outputString.indexOf("=_Part") > -1) {
                    outputString = outputString.substring(outputString.indexOf("<?xml version=\"1.0\" encoding=\"utf-8\" ?>"), outputString.lastIndexOf("env:Envelope>") + 13);
                }
                Document document = parseXmlFile(outputString);
                NodeList nodeLst;
                nodeLst = document.getElementsByTagName("ns0:createCreditMemoResponse");

                if (nodeLst.getLength() > 0) {
                    nodeLst = document.getElementsByTagName("wsa:MessageID");
                    respuestaWS.setMessageID(nodeLst.item(0).getTextContent());
                    nodeLst = document.getElementsByTagName("ns1:CustomerTransactionId");
                    respuestaWS.setCustomerTransactionId(nodeLst.item(0).getTextContent());
                    nodeLst = document.getElementsByTagName("ns1:TransactionNumber");
                    respuestaWS.setTransactionNumber(nodeLst.item(0).getTextContent());
                    respuestaWS.setProceso(new Proceso("0", "EXITOSO"));
                } else {
                    nodeLst = document.getElementsByTagName("faultstring");
                    respuestaWS.setProceso(new Proceso("100", "Error en WS ERP : faultstring= " + nodeLst.item(0).getTextContent()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();

                respuestaWS.setProceso(new Proceso("100", "Error en WS ERP : " + ex.toString()));
            }
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }
        return respuestaWS;
    }

    private String recuperarValorDesdeNodo(String outputString, String nombreNodo) throws ParserConfigurationException, SAXException, IOException {

        Document document = parseXmlFile(outputString);
        NodeList nodeLstServiceStatus = document.getElementsByTagName(nombreNodo);
        return nodeLstServiceStatus.item(0).getTextContent();
    }

    public RespuestaUnidadNegocioDTO getERP_obtenerUnidadesNegocio() throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaUnidadNegocioDTO respestaWS = new RespuestaUnidadNegocioDTO();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));;

        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetBUServiceEndPoint");

        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetBUServicePayload"));

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("GetBUServiceSoapAction");

        //Ready with sending the request.
        try {
            //Read the response.
//            ConsumirBI consumir = new ConsumirBI();
            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetBUServiceContentType"));
//            outputString = consumir.getMetodosPago("123", "", "");

            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            RespuestaERP_UnidadNegocio respuestaERP_Unidad = new RespuestaERP_UnidadNegocio();
            respuestaERP_Unidad = (RespuestaERP_UnidadNegocio) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), new RespuestaERP_UnidadNegocio());
            respestaWS.setProceso(new Proceso("0", "EXITOSO"));
            respestaWS.setUnidadesNegocio(respuestaERP_Unidad);

        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", ex.getLocalizedMessage()));
        }
        return respestaWS;
    }

    public RespuestaCentroCostoDTO getERP_obtenerCentroCosto() throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaCentroCostoDTO respestaWS = new RespuestaCentroCostoDTO();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));;

        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetCCServiceEndPoint");

        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetCCServicePayload"));

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("GetCCServiceSoapAction");

        //Ready with sending the request.
        try {
            //Read the response.
//            ConsumirBI consumir = new ConsumirBI();
            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetCCServiceContentType"));
//            outputString = consumir.getMetodosPago("123", "", "");

            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            RespuestaERP_CentroCosto respuestaERP_CC = new RespuestaERP_CentroCosto();
            respuestaERP_CC = (RespuestaERP_CentroCosto) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), new RespuestaERP_CentroCosto());
            respestaWS.setProceso(new Proceso("0", "EXITOSO"));
            respestaWS.setCentroCosto(respuestaERP_CC);

        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", ex.getLocalizedMessage()));
        }
        return respestaWS;
    }

    public RespuestaUnidadNegocioDTO getERP_obtenerUsuarios() throws MalformedURLException,
            IOException,
            ParserConfigurationException,
            SAXException {

        //Code to make a webservice HTTP request
        RespuestaUnidadNegocioDTO respestaWS = new RespuestaUnidadNegocioDTO();
        respestaWS.setProceso(new Proceso("0", "EXITOSO"));;

        String outputString = "";
        String wsURL = PropiedadesFRISA.recuperaPropiedadBackend("GetUsuarioServiceEndPoint");

        String xmlInput
                = this.getCadenaDesdeB64(PropiedadesFRISA.recuperaPropiedadBackend("GetUsuarioServicePayload"));

        String SOAPAction
                = PropiedadesFRISA.recuperaPropiedadBackend("GetUsuarioServiceSoapAction");

        //Ready with sending the request.
        try {
            //Read the response.
//            ConsumirBI consumir = new ConsumirBI();
            outputString = enviarMsg(wsURL, SOAPAction, xmlInput, PropiedadesFRISA.recuperaPropiedadBackend("GetUsuarioServiceContentType"));
//            outputString = consumir.getMetodosPago("123", "", "");

            //Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
            Document document = parseXmlFile(outputString);
            NodeList nodeLst = document.getElementsByTagName("ns2:reportBytes");
            String resultado = nodeLst.item(0).getTextContent();

            //Write the SOAP message formatted to the console.
            RespuestaERP_UnidadNegocio respuestaERP_Unidad = new RespuestaERP_UnidadNegocio();
            respuestaERP_Unidad = (RespuestaERP_UnidadNegocio) respuestaXMLaPOJO(getCadenaDesdeB64(resultado), new RespuestaERP_UnidadNegocio());
            respestaWS.setProceso(new Proceso("0", "EXITOSO"));
            respestaWS.setUnidadesNegocio(respuestaERP_Unidad);

        } catch (Exception ex) {
            ex.printStackTrace();
            respestaWS.setProceso(new Proceso("100", ex.getLocalizedMessage()));
        }
        return respestaWS;
    }
}
