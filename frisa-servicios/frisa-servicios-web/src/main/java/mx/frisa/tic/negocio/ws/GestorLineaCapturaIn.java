/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import mx.frisa.tic.datos.dto.ingresos.PeticionCargaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCargaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDetalleLineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaLCFactDetDTO;

/**
 *
 * @author USER_1
 */
@WebService(name = "GestorLineaCapturaWS")
public interface GestorLineaCapturaIn {

    
    @WebMethod(operationName = "cargarFacturas")
    RespuestaCargaFacturaDTO cargarFacturas(@WebParam(name = "facturas") PeticionCargaFacturaDTO peticion);
    
    
    //    @Asynchronous
    /**
     * 
     * @param peticion
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "cargarFacturas")
    @RequestWrapper(localName = "peticion", className = "mx.frisa.tic.datos.dto.ingresos.PeticionCargaFacturaDTO")
    @ResponseWrapper(localName = "respuestaCargaFactura", className = "mx.frisa.tic.datos.dto.ingresos.RespuestaCargaFacturaDTO")
    public Future<?> cargarFacturasAsync(
        @WebParam(name = "facturas") PeticionCargaFacturaDTO peticion,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<RespuestaCargaFacturaDTO> asyncHandler);
    
    
    /**
     * Web service operation
     * @param idBatch
     * @return
     */
    @WebMethod(operationName = "ejecutaBatchLC")
    int ejecutaBatchLC(@WebParam(name = "idBatch") String idBatch);
    
    RespuestaDetalleLineaCapturaDTO consultaDetalleLineaCaptura(@WebParam(name = "lineaCaptura") String lineaCaptura,
                                                        @WebParam(name = "entidadLegal") String entidadLegal,
                                                        @WebParam(name = "referencia") String referencia,
                                                        @WebParam(name = "banco") String banco,
                                                        @WebParam(name = "unidadNegocio") String unidadNegocio);
    
    @WebMethod(operationName = "consultaDetalleLCPagos")
    RespuestaDetalleLCPagosDTO consultaDetalleLCPagos(@WebParam(name = "facturaERP") String facturaERP);
    
    @WebMethod(operationName = "consultaLCFactDet")
    RespuestaLCFactDetDTO consultaLCFactDet(@WebParam(name = "cliente") String cliente,
                                                        @WebParam(name = "cuenta") String cuenta,
                                                        @WebParam(name = "centroCostos") String centroCostos,
                                                        @WebParam(name = "entidadLegal") String entidadLegal,
                                                        @WebParam(name = "unidadNegocio") String unidadNegocio);
    
    
}
