/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mx.frisa.tic.datos.dto.ingresos.InterfaceLineDTO;
import mx.frisa.tic.datos.dto.ingresos.LCFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaLCFacturaDTO;
import mx.frisa.tic.negocio.utils.ManejadorLog;

/**
 *
 * @author Ernesto
 */
@WebService(serviceName = "GestorFacturasWS")
public class GestorFacturasWS {

    @EJB(beanName = "GestorFacturasBean")
    private GestorFacturasBean gestorFacturasBean;

    // "Web Service > Add Operation"

    /**
     * Web service operation
     *
     * @param lineaCaptura
     * @return
     */
    @WebMethod(operationName = "consultarLCFacturas")
    public RespuestaLCFacturaDTO consultarLCFacturas(@WebParam(name = "lineaCaptura") String lineaCaptura) {

        RespuestaLCFacturaDTO respuestaLCFactura = new RespuestaLCFacturaDTO();
        ManejadorLog manejarLog = new ManejadorLog();
        List<LCFacturaDTO> lcFacturas = new ArrayList<>();
        manejarLog.debug("Entro a metodo : GestorFacturasWS-consultarLCFacturas");
        try {
            lcFacturas = gestorFacturasBean.consultarLCFactura(lineaCaptura);
            respuestaLCFactura.setProceso(new Proceso("0", "Exitoso"));
            respuestaLCFactura.setLcFacturas(lcFacturas);
        } catch (Exception ex) {
            ex.printStackTrace();
            respuestaLCFactura.setProceso(new Proceso("1", ex.getLocalizedMessage()));
        }
        manejarLog.debug("Termina metodo : GestorFacturasWS-consultarLCFacturas");

        return respuestaLCFactura;
    }

    /**
     * Web service operation
     *
     * @param idBatch
     * @return
     */
    @WebMethod(operationName = "consultaDetalleFacturas")
    public RespuestaDetalleFacturaDTO consultaDetalleFacturas(@WebParam(name = "idBatch") String idBatch) {

        RespuestaDetalleFacturaDTO respuestaDetalleFactura = new RespuestaDetalleFacturaDTO();
        ManejadorLog manejarLog = new ManejadorLog();
        List<ProcessInterfaceLineDTO> processInterfaceLine = new ArrayList<>();
        manejarLog.debug("Entro a metodo : GestorFacturasWS-consultarLCFacturas");
        try {
            processInterfaceLine = gestorFacturasBean.consultarDetalleFactura(idBatch);
            respuestaDetalleFactura.setProceso(new Proceso("0", "Exitoso"));
            respuestaDetalleFactura.setProcessInterfaceLine(processInterfaceLine);
        } catch (Exception ex) {
            ex.printStackTrace();
            respuestaDetalleFactura.setProceso(new Proceso("1", ex.getLocalizedMessage()));
        }
        manejarLog.debug("Termina metodo : GestorFacturasWS-consultarLCFacturas");

        return respuestaDetalleFactura;
    }

}
