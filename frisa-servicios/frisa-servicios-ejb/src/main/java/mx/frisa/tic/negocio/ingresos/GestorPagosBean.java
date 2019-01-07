/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaProcesaFacturasDTO;
import mx.frisa.tic.datos.entidades.XxfrvFactparapagos;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.utils.ManejadorLog;

/**
 *
 * @author Soultech
 */
@Stateless(name = "GestorPagosBean")
@LocalBean
public class GestorPagosBean implements GestorPagos {

    @Override
    public RespuestaProcesaFacturasDTO generarPago(List<PagoDTO> pagos) {
        RespuestaProcesaFacturasDTO respuesta = new RespuestaProcesaFacturasDTO();
        /*SECUENCIA DEL PROCESO 
        1. Consulta de estado de cuenta (ERP)
        2. Validar existencia de LC o Ref (BD)
        3. Validar factura al cobro o normal
        4. Crear factura al cobro (ERP)
        5. Registrar cabecera de pago en ERP
        6. Aplicar facturas en ERP
         */
        try {
            respuesta = recuperaFacturas(pagos);
        } catch (IOException ex) {
            Logger.getLogger(GestorPagosBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        respuesta.setProceso("GestorPagosBean-generarPago");
        respuesta.setIdError("000");
        respuesta.setDescripcionError("OK");
        return respuesta;
    }

    private RespuestaProcesaFacturasDTO recuperaFacturas(List<PagoDTO> pagos) throws IOException {
        ManejadorLog log = new ManejadorLog();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        DAO<XxfrvFactparapagos> consultaDAO = new DAO(XxfrvFactparapagos.class);
        List<XxfrvFactparapagos> facturasDTO = new ArrayList();
        List<FacturaPagoDTO> facturasAlCobro = new ArrayList();
        List<FacturaPagoDTO> facturas = new ArrayList();
        List<PagoDTO> response = new ArrayList();
        StringBuilder query = new StringBuilder();
        StringBuilder paramLc = new StringBuilder();
        RespuestaProcesaFacturasDTO respuesta = new RespuestaProcesaFacturasDTO("ERROR", "100", "Existe error en proceso de facturas al cobro");

        //REcorrer los pagos y solo generar facturas de aquellas que tienen LINEA DE CAPTURA y numero de recibo de pago
        for (PagoDTO pago : pagos) {
            if (!pago.getNroRecibo().equals("")) {
                paramLc.append("'" + pago.getLineaCaptura() + "',");
            }
        }
        //En caso de no contar con ninguan linea de captura valida no debe generar alguna consulta
        if (paramLc.length() != 0) {
            query.append("SELECT x ")
                    .append(" FROM XxfrvFactparapagos x ")
                    .append("WHERE x.lineacaptura in (")
                    .append(paramLc.toString().substring(0, paramLc.toString().length() - 1))
                    .append(")");
            try {
                facturasDTO = consultaDAO.consultaQueryNativo(query.toString());
            } catch (Exception ex) {
                log.debug("Error al ejecutar el query: " + query.toString());
                log.error(ex, GestorPagosBean.class);
            }

            for (XxfrvFactparapagos pago : facturasDTO) {
                FacturaPagoDTO factura = new FacturaPagoDTO();
                factura.setIdlinea(pago.getIdlinea());
                factura.setBusinessunitname(pago.getBusinessunitname());
                factura.setTransactionsource(pago.getTransactionsource());
                factura.setTransactiontype(pago.getTransactiontype());
                factura.setCreationdatetrx(dateFormat.format(pago.getCreationdatetrx()));
                factura.setCreationdategl(dateFormat.format(pago.getCreationdategl()));
                factura.setBilltoconsumername(pago.getBilltoconsumername());
                factura.setBilltolocation(pago.getBilltolocation());
                factura.setPaymenttermdays(pago.getPaymenttermdays());
                factura.setGenerationtype(pago.getGenerationtype());
                factura.setIdfacturaprimavera(pago.getIdfacturaprimavera());
                factura.setLinenumber(pago.getLinenumber());
                factura.setMemolinename(pago.getMemolinename());
                factura.setDescription_origen(pago.getDescriptionOrigen());
                factura.setQuantity(pago.getQuantity());
                factura.setMontobrutolinea(pago.getMontobrutolinea());
                factura.setClasificadordescuento(pago.getClasificadordescuento());
                factura.setDescadicional1(pago.getDescadicional1());
                factura.setDescadicional2(pago.getDescadicional2());
                factura.setDescadicional3(pago.getDescadicional3());
                factura.setDescadicional4(pago.getDescadicional4());
                factura.setDescadicional5(pago.getDescadicional5());
                factura.setFechadesde(dateFormat.format(pago.getFechadesde()));
                factura.setFechahasta(dateFormat.format(pago.getFechahasta()));
                factura.setDffheadercontext(pago.getDffheadercontext());
                factura.setFechaexigibilidad(dateFormat.format(pago.getFechaexigibilidad()));
                factura.setProjectid(pago.getProjectid());
                factura.setFolioavisocargo(pago.getFolioavisocargo());
                factura.setLocalnumber(pago.getLocalnumber());
                factura.setLineacaptura(pago.getLineacaptura());
                facturas.add(factura);
                if (factura.getGenerationtype().equals("INVOICE_TO_COLLECTION")) {
                    facturasAlCobro.add(factura);
                }
            }
            //TODO - Llamada al servicio de creación de facturas
            AdaptadorWS adaptador = new AdaptadorWS();
            if (facturasAlCobro.size() > 0) {
                adaptador.getOBI_generarFacturaAlCobro(facturasAlCobro);
            }
            respuesta = new RespuestaProcesaFacturasDTO("EXITOSO", "0", "");
            respuesta.setFacturas(facturas);
        }
        return respuesta;
    }
}
