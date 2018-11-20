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
import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.ingresos.Respuesta;
import mx.frisa.tic.datos.dto.ingresos.RespuestaLineaCapturaDTO;
import mx.frisa.tic.negocio.ingresos.GestorLineaCaptura;
import mx.frisa.tic.negocio.utils.ManejadorLog;

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
     * @param idBatch
     * @return
     */
    @WebMethod(operationName = "generarLineasCaptura")
    public Respuesta generarLineasCaptura(@WebParam(name = "idBatch") String idBatch) {

        Respuesta respuesta = new Respuesta();
        respuesta.setProceso("generarLineasCaptura");
        respuesta.setIdError("000");
        respuesta.setDescripcionError("OK");

        return respuesta;
    }

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
     * @param idBatch
     * @return
     */
    @WebMethod(operationName = "consultaBatchLC")
    public String consultaBatchLC(@WebParam(name = "idBatch") String idBatch) {
        ManejadorLog manejarLog = new ManejadorLog();
        manejarLog.debug("Entro a metodo : GestorLineaCapturaWS-consultaBatchLC");
        String respuesta = "SIN RESPUESTA";
        try {
            respuesta = gestorLineaCapturaBean.consultaBatchLC(idBatch);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        manejarLog.debug("Termina metodo : GestorLineaCapturaWS-consultaBatchLC");
        return respuesta;
    }

}
