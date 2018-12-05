/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
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
    public RespuestaDTO generarPago(List<PagoDTO> pagos) {
        RespuestaDTO respuesta = new RespuestaDTO();
        /*SECUENCIA DEL PROCESO 
        1. Consulta de estado de cuenta (ERP)
        2. Validar existencia de LC o Ref (BD)
        3. Validar factura al cobro o normal
        4. Crear factura al cobro (ERP)
        5. Registrar cabecera de pago en ERP
        6. Aplicar facturas en ERP
         */

        respuesta.setProceso("GestorPagosBean-generarPago");
        respuesta.setIdError("000");
        respuesta.setDescripcionError("OK");
        return respuesta;
    }

    private RespuestaDTO recuperaFacturas(List<PagoDTO> pagos) throws IOException {
        ManejadorLog log = new ManejadorLog();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        DAO<XxfrvFactparapagos> consultaDAO = new DAO(XxfrvFactparapagos.class);
        List<XxfrvFactparapagos> facturasDTO = null;
        List<FacturaPagoDTO> facturasAlCobro = null;
        List<FacturaPagoDTO> facturas = null;
        List<PagoDTO> response = null;
        StringBuilder query = new StringBuilder();
        StringBuilder paramLc = new StringBuilder();
        RespuestaDTO respuesta = new RespuestaDTO("ERROR", "100", "Existe error en proceso de facturas al cobro");

        for (PagoDTO pago : pagos) {
            paramLc.append("'" + pago.getLineaCaptura() + "',");
        }

        query.append("SELECT x ")
                .append(" FROM XxfrvFactparapagos x ")
                .append("WHERE x.lineacaptura in ('")
                .append(paramLc.toString().substring(0, paramLc.toString().length() - 1))
                .append("')");
        try {
            facturasDTO = consultaDAO.consultaQueryNativo(query.toString());
        } catch (Exception ex) {
            log.debug("Error al ejecutar el query: " + query.toString());
            log.error(ex, GestorPagosBean.class);
        }

        for (XxfrvFactparapagos pago : facturasDTO) {
            FacturaPagoDTO factura = null;
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
        respuesta = new RespuestaDTO("EXITOSO", "0", "");

        return respuesta;
    }
}
