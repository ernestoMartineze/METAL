/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.comun;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import mx.frisa.tic.negocio.utils.ManejadorLog;

/**
 *
 * @author ernestomtz
 */
public class ProcedimientoAlmacendo extends ManejadorEntidad {

    

    public int ejecutaCuentaFacturas(String pLC) {
        //return "";
        ManejadorLog manejadorLog = new ManejadorLog();
        int respuesta = 0;
//        ManejadorLog manejaLog = ManejadorLog();
        manejadorLog.debug("Entró ejecutaCuentaFacturas : pLC=" + pLC);
        try {
            //Clonar la solicitud recuperando la información del idSolicitud
            super.instanciarManager();

            StoredProcedureQuery procedure = super.getEntityManager().createStoredProcedureQuery("XXFR_FACTURAS_POR_LC");
            procedure.registerStoredProcedureParameter("lineaCaptura", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("totalFacturas", int.class, ParameterMode.OUT);
            procedure.setParameter("lineaCaptura", pLC);
            Boolean ejecuta = procedure.execute();
            int totalFacturas = 0;

            try {
                totalFacturas = (int) procedure.getOutputParameterValue("totalFacturas");
                ejecuta = true; 
            } catch (Exception ex) {
                manejadorLog.error("Error : " + totalFacturas);
                manejadorLog.error("Resultado: " + ex.getLocalizedMessage());
                manejadorLog.error("Resultado: " + ex.getMessage());
            }

            manejadorLog.debug("Resultado: " + totalFacturas);
            manejadorLog.debug("Resultado : " + ejecuta);
            respuesta = totalFacturas;

            //return respues;
        } catch (Exception ex) {
            Logger.getLogger(ProcedimientoAlmacendo.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = 0;
            //return msj;
        } finally {
            super.getEntityManager().close();
            super.cerrarManager();
        }
        return respuesta;
    }
    
    /**/
    public int ejecutaBatchLC(String idBatch) {
        ManejadorLog manejadorLog = new ManejadorLog();
        int respuesta = 0;
        manejadorLog.debug("Entró ejecutaBatchLC : idBatch=" + idBatch);
        try {
            super.instanciarManager();
            StoredProcedureQuery procedure = super.getEntityManager().createStoredProcedureQuery("XXFRP_PROCESAR_BATCH");
            procedure.registerStoredProcedureParameter("IDPARBATCH", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("PROCESO", int.class, ParameterMode.OUT);
            procedure.setParameter("IDPARBATCH", idBatch);
            Boolean ejecuta = procedure.execute();
            int respuestaProceso = 0;
            try {
                respuestaProceso = (int) procedure.getOutputParameterValue("PROCESO");
                ejecuta = true; 
            } catch (Exception ex) {
                manejadorLog.error("Error : " + respuestaProceso);
                manejadorLog.error("Resultado: " + ex.getLocalizedMessage());
                manejadorLog.error("Resultado: " + ex.getMessage());
                System.out.println("SE OBTUVO EL ERROR");
            }

            manejadorLog.debug("Resultado: " + respuestaProceso);
            manejadorLog.debug("Resultado : " + ejecuta);
            respuesta = respuestaProceso;

            //return respues;
        } catch (Exception ex) {
            Logger.getLogger(ProcedimientoAlmacendo.class.getName()).log(Level.SEVERE, null, ex);
            respuesta = 100;
            //return msj;
        } finally {
            super.getEntityManager().close();
            super.cerrarManager();
        }
        return respuesta;
    }
    
    
}
