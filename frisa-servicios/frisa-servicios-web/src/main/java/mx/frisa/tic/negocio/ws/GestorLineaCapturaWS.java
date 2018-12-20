/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import mx.frisa.tic.datos.dto.ingresos.DetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLineaCapturaDTO;

import mx.frisa.tic.datos.dto.ingresos.LCFactDetDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCaptutaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.PeticionCargaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCargaFacturaDTO;


import mx.frisa.tic.datos.dto.ingresos.RespuestaDetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDetalleLineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaLCFactDetDTO;

import mx.frisa.tic.datos.dto.ingresos.RespuestaLineaCapturaDTO;
import mx.frisa.tic.negocio.ingresos.GestorLineaCaptura;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import mx.frisa.tic.utils.UUIDFrisa;

/**
 *
 * @author soultech
 */
@WebService(serviceName = "GestorLineaCapturaWS")
public class GestorLineaCapturaWS {

    @EJB(beanName = "GestorLineaCapturaBean")
    private GestorLineaCaptura gestorLineaCapturaBean;

   


    /**
     * Web service operation
     *
     * @param lineaCaptura
     * @return
     */
    @WebMethod(operationName = "consultarLineaCaptura")
    public RespuestaLineaCapturaDTO consultarLineaCaptura(@WebParam(name = "lineaCaptura") LineaCapturaDTO lineaCaptura) {

        RespuestaLineaCapturaDTO respuestaLineaCapturaDto = new RespuestaLineaCapturaDTO();
        ManejadorLog manejarLog = new ManejadorLog();
        List<LineaCapturaDTO> lineasCaptura = new ArrayList<>();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultarLineaCaptura");
        try {
            lineasCaptura = gestorLineaCapturaBean.consultarLineaCaptura(lineaCaptura);
            respuestaLineaCapturaDto.setProceso(new Proceso("0", "Exitoso"));
            respuestaLineaCapturaDto.setLineasCaptura(lineasCaptura);
        } catch (Exception ex) {
            ex.printStackTrace();
            respuestaLineaCapturaDto.setProceso(new Proceso("1", ex.getLocalizedMessage()));
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultarLineaCaptura");

        return respuestaLineaCapturaDto;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultaNumeroFacturas")
    public int consultaNumeroFacturas(@WebParam(name = "lineaCaptura") String lineaCaptura) {

        ManejadorLog manejarLog = new ManejadorLog();
        List<LineaCapturaDTO> lineasCaptura = new ArrayList<>();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultaNumeroFacturas");
        int numeroFacturas = 0;
        try {
            numeroFacturas = gestorLineaCapturaBean.ejecutaCuentaFacturas(lineaCaptura);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultaNumeroFacturas");

        return numeroFacturas;
    }
    
    /**
     * Web service operation
     * @param idBatch
     * @return
     */
    @WebMethod(operationName = "ejecutaBatchLC")
    public int ejecutaBatchLC(@WebParam(name = "idBatch") String idBatch) {
        ManejadorLog manejarLog = new ManejadorLog();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-ejecutaBatchLC");
        int respuesta = 0;
        try {
            respuesta = gestorLineaCapturaBean.ejecutaBatchLC(idBatch);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-ejecutaBatchLC");
        return respuesta;
    }
    
    /**
     * Web service operation
     */

    @WebMethod(operationName = "consultaDetalleLineaCaptura")
    public RespuestaDetalleLineaCapturaDTO consultaDetalleLineaCaptura(@WebParam(name = "lineaCaptura") String lineaCaptura,
                                                        @WebParam(name = "entidadLegal") String entidadLegal,
                                                        @WebParam(name = "referencia") String referencia,
                                                        @WebParam(name = "banco") String banco,
                                                        @WebParam(name = "unidadNegocio") String unidadNegocio) {
        DetalleLineaCapturaDTO detalleLineaCaptura = new DetalleLineaCapturaDTO();
        detalleLineaCaptura.setLineacaptura(lineaCaptura);
        detalleLineaCaptura.setEntidadlegal(entidadLegal);
        detalleLineaCaptura.setReferencia(referencia);
        detalleLineaCaptura.setBanco(banco);
        detalleLineaCaptura.setUnidadnegocio(unidadNegocio);
        RespuestaDetalleLineaCapturaDTO respuestaDetalleLineaCapturaDto = new RespuestaDetalleLineaCapturaDTO();
        ManejadorLog manejarLog = new ManejadorLog();
        List<DetalleLineaCapturaDTO> detalleLineasCaptura = new ArrayList<>();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultaDetalleLineaCaptura");
        try {
            detalleLineasCaptura = gestorLineaCapturaBean.consultarDetalleLineaCaptura(detalleLineaCaptura);
            respuestaDetalleLineaCapturaDto.setProceso(new Proceso("0", "Exitoso"));
            respuestaDetalleLineaCapturaDto.setLineasCaptura(detalleLineasCaptura);
        } catch (Exception ex) {
            ex.printStackTrace();
            respuestaDetalleLineaCapturaDto.setProceso(new Proceso("1", ex.getLocalizedMessage()));
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultarLineaCaptura");

        return respuestaDetalleLineaCapturaDto;

    }
    
    /**
     * Web service operation
     * @param idBatch
     * @return
     */
    @WebMethod(operationName = "consultaLCGeneradas")
    public List<LineaCaptutaFacturaDTO> consultaLCGeneradas(@WebParam(name = "idBatch") String idBatch) {
        ManejadorLog manejarLog = new ManejadorLog();
        List<LineaCaptutaFacturaDTO> respuesta = null;
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultaLCGeneradas");
        try {
            respuesta = gestorLineaCapturaBean.consultaLCGeneradas(idBatch);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultaLCGeneradas");
        return respuesta;
    }

     /**
     * Web service operation
     * @param facturaERP
     * @return
     */
    @WebMethod(operationName = "consultaDetalleLCPagos")
    public RespuestaDetalleLCPagosDTO consultaDetalleLCPagos(@WebParam(name = "facturaERP") String facturaERP) {

        
        RespuestaDetalleLCPagosDTO respuestaDetalleLCPagosDTO = new RespuestaDetalleLCPagosDTO();
        ManejadorLog manejarLog = new ManejadorLog();
        List<DetalleLCPagosDTO> detalleLCPagosDTO = new ArrayList<>();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultaDetalleLineaCaptura");
        try {

            detalleLCPagosDTO = gestorLineaCapturaBean.consultarLCPagos(facturaERP);

            respuestaDetalleLCPagosDTO.setProceso(new Proceso("0", "Exitoso"));
            respuestaDetalleLCPagosDTO.setDetalleLCPagos(detalleLCPagosDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            respuestaDetalleLCPagosDTO.setProceso(new Proceso("1", ex.getLocalizedMessage()));
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultarLineaCaptura");

        return respuestaDetalleLCPagosDTO;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultaLCFactDet")
    public RespuestaLCFactDetDTO consultaLCFactDet(@WebParam(name = "cliente") String cliente,
                                                        @WebParam(name = "cuenta") String cuenta,
                                                        @WebParam(name = "centroCostos") String centroCostos,
                                                        @WebParam(name = "entidadLegal") String entidadLegal,
                                                        @WebParam(name = "unidadNegocio") String unidadNegocio) {
        LCFactDetDTO lcFactDetDTO = new LCFactDetDTO();
        lcFactDetDTO.setBilltoconsumername(cliente);
        lcFactDetDTO.setCompanyaccountcode(cuenta!=null&&!cuenta.equals("") ? Long.parseLong(cuenta):null);
        lcFactDetDTO.setProjectid(centroCostos!=null&&!centroCostos.equals("") ? Long.parseLong(centroCostos):null);
        lcFactDetDTO.setEntidadlegal(entidadLegal);
        lcFactDetDTO.setBusinessunitname(unidadNegocio);
        RespuestaLCFactDetDTO respuestaLCFactDetDTO = new RespuestaLCFactDetDTO();
        ManejadorLog manejarLog = new ManejadorLog();
        List<LCFactDetDTO> detalleLCFactDTO = new ArrayList<>();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultaDetalleLineaCaptura");
        try {
            detalleLCFactDTO = gestorLineaCapturaBean.consultarLCFactDet(lcFactDetDTO);
            respuestaLCFactDetDTO.setProceso(new Proceso("0", "Exitoso"));
            respuestaLCFactDetDTO.setLcFactDetalle(detalleLCFactDTO);
        } catch (Exception ex) {
            ex.printStackTrace();
            respuestaLCFactDetDTO.setProceso(new Proceso("1", ex.getLocalizedMessage()));
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultarLineaCaptura");

        return respuestaLCFactDetDTO;
    }
    
//    @Asynchronous
    @WebMethod(operationName = "cargarFactura")
//    public Future<RespuestaCargaFacturaDTO cargarFactura(@WebParam(name = "facturas") PeticionCargaFacturaDTO peticion) {
    public RespuestaCargaFacturaDTO cargarFactura(@WebParam(name = "facturas") PeticionCargaFacturaDTO peticion) {
        ManejadorLog manejarLog = new ManejadorLog();
        RespuestaCargaFacturaDTO respuesta = new RespuestaCargaFacturaDTO();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultaLCGeneradas");
        try {
            respuesta.setProceso(new Proceso("0","EXITOSO"));
            respuesta.setUuid(UUIDFrisa.regresaUUID());
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultaLCGeneradas");
        return (respuesta);
//        return new AsyncResult<RespuestaCargaFacturaDTO>(respuesta);
    }
    
//    // Operación asíncrona con retorno de llamada.
//       Future<RespuestaCargaFacturaDTO> cargarFacturaPrimavera(PeticionCargaFacturaDTO peticion, 
//              AsyncHandler<Score> handler){
//           RespuestaCargaFacturaDTO respuesta = new RespuestaCargaFacturaDTO();
//           
//           return new AsyncResult<RespuestaCargaFacturaDTO>(respuesta);
//       }
    @WebMethod (operationName = "consultarEstadoCarga")
    public RespuestaCargaFacturaDTO consultarEstadoCarga(@WebParam(name = "uuid") String pUUID) {
        ManejadorLog manejarLog = new ManejadorLog();
        RespuestaCargaFacturaDTO respuesta = new RespuestaCargaFacturaDTO();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultarEstadoCarga");
        try {
            respuesta.setProceso(new Proceso("0","EXITOSO"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultarEstadoCarga");
        return respuesta;
    }

}
