/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.comun;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import mx.frisa.tic.datos.dto.ingresos.LineaCaptutaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaEdoCuentaDTO;
import mx.frisa.tic.datos.entidades.XxfrcOrganizacionMetodopago;
import mx.frisa.tic.datos.entidades.XxfrcOrganizacionMetodopagoPK;
import mx.frisa.tic.datos.entidades.XxfrtEstadoCuenta;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcBatch;
import mx.frisa.tic.negocio.remoto.MetodoPagoG1OBI;
import mx.frisa.tic.negocio.remoto.MetodoPagoOBI;
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

    public int consultaBatchFinalizado(String idBatch) {
        ManejadorLog manejadorLog = new ManejadorLog();
        int respuesta = 0;
        manejadorLog.debug("Entró consultaBatchLC : idBatch=" + idBatch);
        try {
            super.instanciarManager();
            StoredProcedureQuery procedure = super.getEntityManager().createStoredProcedureQuery("XXFRP_CONSULTA_BATCH");
            procedure.registerStoredProcedureParameter("PIDBATCH", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("PROCESO", int.class, ParameterMode.OUT);
            procedure.setParameter("PIDBATCH", idBatch);
            Boolean ejecuta = procedure.execute();
            int respuestaProceso = 0;
            try {
                respuestaProceso = (int) procedure.getOutputParameterValue("PROCESO");
                ejecuta = true;
            } catch (Exception ex) {
                manejadorLog.error("Error : " + respuestaProceso);
                manejadorLog.error("Resultado: " + ex.getLocalizedMessage());
                manejadorLog.error("Resultado: " + ex.getMessage());
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

    public List<LineaCaptutaFacturaDTO> consultaLCGeneradas(String idBatch) {
        ManejadorLog manejadorLog = new ManejadorLog();
        DAO<XxfrvConsultaLcBatch> consultaDAO = new DAO(XxfrvConsultaLcBatch.class);
        List<XxfrvConsultaLcBatch> consultaDTO;
        List<LineaCaptutaFacturaDTO> facturas = new ArrayList<>();
        LineaCaptutaFacturaDTO factura = new LineaCaptutaFacturaDTO();
        StringBuilder consulta = new StringBuilder();
        consulta.append("SELECT x ")
                .append("FROM XxfrvConsultaLcBatch x ")
                .append("WHERE x.idbatch = '")
                .append(idBatch)
                .append("'");
        consultaDTO = consultaDAO.consultaQueryNativo(consulta.toString());
        for (XxfrvConsultaLcBatch resConsulta : consultaDTO) {
            factura.setIdbatch(resConsulta.getIdbatch());
            factura.setIdfacturaprimavera(resConsulta.getIdfacturaprimavera());
            factura.setLineacaptura(resConsulta.getLineacaptura());
            facturas.add(factura);
        }
        return facturas;
    }/**/

    public RespuestaEdoCuentaDTO ejecutarEstadoCuenta(XxfrtEstadoCuenta lineaEstadoCuenta) {
        ManejadorLog manejadorLog = new ManejadorLog();
        manejadorLog.debug("Entró ejecutarProcedimiento : getBANK_ACCOUNT_NUM=" + lineaEstadoCuenta.getBankAccountNum());
        RespuestaEdoCuentaDTO respuestaDTO = new RespuestaEdoCuentaDTO("ERROR", "100", "");
        try {
            super.instanciarManager();
            StoredProcedureQuery procedure = super.getEntityManager().createStoredProcedureQuery("INGRESOS.XXFRP_ESTADO_CUENTA");
            procedure.registerStoredProcedureParameter("PBANK_ACCOUNT_NUM", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pTRX_DATE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pLINE_NUMBER", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pTRX_TYPE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pAMOUNT", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pTRX_CODE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pCURRENCY_CODE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pCUSTOMER_REFERENCE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pADDIOTIONAL_ENTRY_INFORMATION", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pPROYECTO_PROPIETARIO", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pLINE_CAPTURE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pSTATEMENT_HEADER_ID", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pSTATEMENT_LINE_ID", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pBANK_ACCOUNT_ID", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pSTMT_FROM_DATE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pSTMT_TO_DATE", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pSTATEMENT_NUMBER", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pDESCRIP_LOOKUP", String.class, ParameterMode.IN);
            
            procedure.registerStoredProcedureParameter("PRESPUESTA", int.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter("pIdEdoCuenta", int.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter("pIdMetodo", BigInteger.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter("pIdPago", int.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter("pORG_ID", String.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter("pCUSTOMER_ID", String.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter("pSITE_ID", String.class, ParameterMode.OUT);
            procedure.registerStoredProcedureParameter("pBillCustomerName", String.class, ParameterMode.OUT);

            procedure.setParameter("PBANK_ACCOUNT_NUM", lineaEstadoCuenta.getBankAccountNum()+"");
            procedure.setParameter("pTRX_DATE", lineaEstadoCuenta.getTrxDate());
            procedure.setParameter("pLINE_NUMBER", lineaEstadoCuenta.getLineNumber() + "");
            procedure.setParameter("pTRX_TYPE", lineaEstadoCuenta.getTrxType());
            procedure.setParameter("pAMOUNT", lineaEstadoCuenta.getAmount() + "");
            procedure.setParameter("pTRX_CODE", lineaEstadoCuenta.getTrxCode() + "");
            procedure.setParameter("pCURRENCY_CODE", lineaEstadoCuenta.getCurrencyCode());
            procedure.setParameter("pCUSTOMER_REFERENCE", lineaEstadoCuenta.getCustomerReference());
            procedure.setParameter("pADDIOTIONAL_ENTRY_INFORMATION", lineaEstadoCuenta.getAddiotionalEntryInformation());
            procedure.setParameter("pPROYECTO_PROPIETARIO", lineaEstadoCuenta.getProyectoPropietario());
            procedure.setParameter("pSTATEMENT_HEADER_ID", lineaEstadoCuenta.getStatementHeaderId());
            procedure.setParameter("pSTATEMENT_LINE_ID", lineaEstadoCuenta.getStatementLineId());
            procedure.setParameter("pBANK_ACCOUNT_ID", lineaEstadoCuenta.getBankAccountId());
            procedure.setParameter("pSTMT_FROM_DATE", "2018-05-11");
//            procedure.setParameter("pSTMT_FROM_DATE", lineaEstadoCuenta.getStmtFromDate());
            procedure.setParameter("pSTMT_TO_DATE", "2018-05-11");
//            procedure.setParameter("pSTMT_TO_DATE", lineaEstadoCuenta.getStmtToDate());
            procedure.setParameter("pSTATEMENT_NUMBER", "2018-05-11");
//            procedure.setParameter("pSTATEMENT_NUMBER", lineaEstadoCuenta.getStatementNumber());
            procedure.setParameter("pDESCRIP_LOOKUP", lineaEstadoCuenta.getDescripLookup());
            procedure.setParameter("pLINE_CAPTURE", lineaEstadoCuenta.getLineCapture());

            Boolean ejecuta = procedure.execute();

            int respuestaProceso = 0;
            int idEdoCuenta = 0;

            respuestaProceso = (int) procedure.getOutputParameterValue("PRESPUESTA");
            idEdoCuenta = (int) procedure.getOutputParameterValue("pIdEdoCuenta");
            Long idMetodoPago = (Long) procedure.getOutputParameterValue("pIdMetodo");
            Integer pIdPago = (Integer) procedure.getOutputParameterValue("pIdPago");
            String pORG_ID = (String) procedure.getOutputParameterValue("pORG_ID");
            String pCUSTOMER_ID = (String) procedure.getOutputParameterValue("pCUSTOMER_ID");
            String pSITE_ID = (String) procedure.getOutputParameterValue("pSITE_ID");
            String pBillCustomerName = (String) procedure.getOutputParameterValue("pBillCustomerName");
            lineaEstadoCuenta.setIdEdoCta(BigDecimal.valueOf(Long.valueOf(idEdoCuenta+"")));
            manejadorLog.debug("pORG_ID : " + pORG_ID);
            manejadorLog.debug("pIdPago : " + pIdPago);
            manejadorLog.debug("idMetodoPago : " + idMetodoPago);
            ejecuta = true;

            manejadorLog.debug("Resultado: " + respuestaProceso);
            manejadorLog.debug("Resultado : " + ejecuta);
            respuestaDTO = new RespuestaEdoCuentaDTO("EXITOSO", "0", "");
            respuestaDTO.setIdLineaCaptura(respuestaProceso);
            respuestaDTO.setIdEdoCuenta(idEdoCuenta);
            respuestaDTO.setIdMetodoPago(idMetodoPago);
            respuestaDTO.setIdPago(pIdPago);
            respuestaDTO.setOrgID(pORG_ID);
            respuestaDTO.setCustomerID(pCUSTOMER_ID);
            respuestaDTO.setSiteID(pSITE_ID);
            respuestaDTO.setSiteID(pSITE_ID);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            manejadorLog.error("Resultado: " + ex.getLocalizedMessage());
            manejadorLog.error("Resultado: " + ex.getMessage());
            respuestaDTO = new RespuestaEdoCuentaDTO("ERROR", "100", ex.getMessage());
        }
        return respuestaDTO;
    }

    public RespuestaDTO cargaInicialMetodos(MetodoPagoOBI metodos) {
        ManejadorLog manejadorLog = new ManejadorLog();
        manejadorLog.debug("Entró cargaInicialMetodos : metodos por insertar =" + metodos.getG_1().size());
        RespuestaDTO respuestaDTO = new RespuestaDTO("ERROR", "100", "");
        try {
            super.instanciarManager();

            StoredProcedureQuery procedure = super.getEntityManager().createStoredProcedureQuery("INGRESOS.XXFRP_REGISTRAR_METODOS");
//            StoredProcedureCall callProc = new StoredProcedureCall();
//            callProc.se

            procedure.registerStoredProcedureParameter("pORGID", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pCUENTABANCO", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pIDMETODO", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("pNOMBREMETODO", String.class, ParameterMode.IN);
            procedure.registerStoredProcedureParameter("resMetodosPago", String.class, ParameterMode.OUT);

            List<XxfrcOrganizacionMetodopago> metodosPorGuardar = new ArrayList<XxfrcOrganizacionMetodopago>();
            DAO<XxfrcOrganizacionMetodopago> metodoDao = new DAO(XxfrcOrganizacionMetodopago.class);
            Boolean ejecuta = true;
            for (MetodoPagoG1OBI metodo : metodos.getG_1()) {
                XxfrcOrganizacionMetodopago metodoPagoEntidad = new XxfrcOrganizacionMetodopago();
                XxfrcOrganizacionMetodopagoPK metodoPk = new XxfrcOrganizacionMetodopagoPK();
                metodoPk.setBankAccountId(BigInteger.valueOf(Long.valueOf(metodo.getBAU_BANK_ACCOUNTID())));
                metodoPk.setOrgId(BigInteger.valueOf(Long.valueOf(metodo.getORG_ID())));
                metodoPk.setReceiptMethodId(BigInteger.valueOf(Long.valueOf(metodo.getRECEIPT_METHOD_ID())));
                metodoPagoEntidad.setBankAccountNum(BigInteger.valueOf(Long.valueOf(metodo.getBANK_ACCOUNT_NUM())));
                metodoPagoEntidad.setOuName(metodo.getOU_NAME());

                metodoPagoEntidad.setReceiptMethodName(metodo.getPRINTED_NAME());
                metodoPagoEntidad.setXxfrcOrganizacionMetodopagoPK(metodoPk);

                procedure.setParameter("pORGID", metodoPagoEntidad.getXxfrcOrganizacionMetodopagoPK().getOrgId() + "");
                procedure.setParameter("pCUENTABANCO", metodoPagoEntidad.getXxfrcOrganizacionMetodopagoPK().getBankAccountId() + "");
                procedure.setParameter("pIDMETODO", metodoPagoEntidad.getXxfrcOrganizacionMetodopagoPK().getReceiptMethodId() + "");
                procedure.setParameter("pNOMBREMETODO", metodo.getPRINTED_NAME());
                ejecuta = procedure.execute();
                String respuestaProceso;

                respuestaProceso = (String) procedure.getOutputParameterValue("resMetodosPago");
                if (respuestaProceso.equals("0")) {
                    metodoPagoEntidad.setFechaRegistro(new Date());
                } else {
                    ejecuta = false;
                }

//                manejadorLog.debug("Resultado: " + respuestaProceso);
//                manejadorLog.debug("Resultado : " + ejecuta);
            }
            if (ejecuta) {
                respuestaDTO = new RespuestaDTO("EXITOSO", "1", "");
            } else {
                respuestaDTO = new RespuestaDTO("ERROR", "0", "Alguno de los metodos de pago no fue registrado satisfactoriamiente");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            manejadorLog.error("Resultado: " + ex.getLocalizedMessage());
            manejadorLog.error("Resultado: " + ex.getMessage());
            respuestaDTO = new RespuestaDTO("ERROR", "100", ex.getMessage());
        }
        return respuestaDTO;
    }
}
