/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.ingresos.CreditMemoDTO;
import mx.frisa.tic.datos.dto.ingresos.NotaCreditoListaDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.entidades.XxfrtNotaCredito;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.remoto.RespuestaERP_Nota_Credito;
import mx.frisa.tic.negocio.utils.ManejadorLog;

/**
 *
 * @author Ernesto
 */
@Stateless(name = "GestorNotaCreditoBean")
@LocalBean
public class GestorNotaCreditoBean implements GestorNotaCreditoBeanLocal {

    @Override
    public RespuestaERP_Nota_Credito cargarNota(NotaCreditoListaDTO notaCredito) {
        RespuestaERP_Nota_Credito respuesta = new RespuestaERP_Nota_Credito();
        ManejadorLog manejaLog = new ManejadorLog();
        AdaptadorWS adapter = new AdaptadorWS();
        XxfrtNotaCredito notaPersist = new XxfrtNotaCredito();
        DAO<XxfrtNotaCredito> notaCreditoDAO = new DAO(XxfrtNotaCredito.class);
        List<CreditMemoDTO> notas = notaCredito.getNotas();
        for (CreditMemoDTO nota : notas) {
            try {
                respuesta = adapter.getERP_ejecutarNotaCredito(nota);
//                respuesta.setProceso(new Proceso("0", "REGISTRADO EN ERP"));
                try {
                    if (respuesta.getProceso().getTermino().equals("0")) {
                        System.out.println("Persistiendo objeto en BD: Nota de Crédito");
                        notaPersist.setBatchsourcesequenceid(BigInteger.valueOf(nota.getBatchSourceSequenceId().intValue()));
                        notaPersist.setCustomertransactionid(BigInteger.valueOf(nota.getCustomerTransactionId().intValue()));
                        notaPersist.setComments(nota.getComments());
                        notaPersist.setCustomertrxtypesequenceid(BigInteger.valueOf(nota.getCustomerTransactionTypeSequenceId().intValue()));
                        notaPersist.setCustomerreference(nota.getCustomerReference());
                        notaPersist.setCustomerreferencedate(nota.getCustomerReferenceDate() == null ? null : nota.getCustomerReferenceDate().toGregorianCalendar().getTime());
                        notaPersist.setDocumentsequenceid(BigInteger.valueOf(nota.getDocumentSequenceId().intValue()));
                        notaPersist.setDocumentsequencevalue(BigInteger.valueOf(nota.getDocumentSequenceValue().intValue()));
                        if (nota.getFreightAmount() != null) {
                            notaPersist.setFreightamount(nota.getFreightAmount().getValue() == null ? null : BigDecimal.valueOf(nota.getFreightAmount().getValue().intValue()));
                        }
                        notaPersist.setFreightpercent(nota.getFreightPercent() == null ? null : BigDecimal.valueOf(nota.getFreightPercent().intValue()));
                        notaPersist.setGldate(nota.getGlDate() == null ? null : nota.getGlDate().toGregorianCalendar().getTime());
                        notaPersist.setInternalnotes(nota.getInternalNotes());
                        if (nota.getLineAmount() != null) {
                            notaPersist.setLineamount(nota.getLineAmount().getValue() == null ? null : BigDecimal.valueOf(nota.getLineAmount().getValue().intValue()));
                        }
                        notaPersist.setLinepercent(nota.getLinePercent() == null ? null : BigDecimal.valueOf(nota.getLinePercent().intValue()));
                        notaPersist.setMethodforrules(nota.getMethodForRules());
                        notaPersist.setPreviouscustomertransactionid(BigInteger.valueOf(nota.getPreviousCustomerTransactionId().intValue()));
                        notaPersist.setReasoncode(nota.getReasonCode());
                        notaPersist.setSplitterminationmethod(nota.getSplitTerminationMethod());
                        notaPersist.setTransactiondate(nota.getTransactionDate() == null ? null : nota.getTransactionDate().toGregorianCalendar().getTime());
                        notaPersist.setCurrencycode(nota.getCurrencyCode());
                        notaPersist.setTransactionnumber(nota.getTransactionNumber());
                        if (nota.getTaxAmount() != null) {
                            notaPersist.setTaxamount(nota.getTaxAmount().getValue() == null ? null : BigDecimal.valueOf(nota.getTaxAmount().getValue().intValue()));
                        }
                        notaPersist.setTaxpercent(nota.getTaxPercent() == null ? null : BigDecimal.valueOf(nota.getTaxPercent().intValue()));
                        notaPersist.setComputetax(nota.getComputeTax());
                        if (nota.getCreditMemoFLEXVA() != null) {
                            notaPersist.setCustomertrxid(nota.getCreditMemoFLEXVA().getCustomerTrxId() == null ? null : BigDecimal.valueOf(nota.getCreditMemoFLEXVA().getCustomerTrxId().intValue()));
                            notaPersist.setProyecto(nota.getCreditMemoFLEXVA().getProyecto());
                            notaPersist.setEstatusdecfdi(nota.getCreditMemoFLEXVA().getEstatusDeCfdi());
                            notaPersist.setUsodecfdi(nota.getCreditMemoFLEXVA().getUsoDeCfdi());
                            notaPersist.setFormadepago(nota.getCreditMemoFLEXVA().getFormaDePago());
                            notaPersist.setFoliodecancelacionsat(nota.getCreditMemoFLEXVA().getFolioDeCancelaciOnSat());
                            notaPersist.setUuiddocumentorelacionado(nota.getCreditMemoFLEXVA().getUuidDocumentoRelacionado());
                            notaPersist.setNumerodecontrato(nota.getCreditMemoFLEXVA().getUuidDocumentoRelacionado());
                            notaPersist.setLineadecaptura(nota.getCreditMemoFLEXVA().getLineaDeCaptura());
                            notaPersist.setSerie(nota.getCreditMemoFLEXVA().getSerie());
                            notaPersist.setFolio(nota.getCreditMemoFLEXVA().getFolio());
                            notaPersist.setFechadeprescripcion(nota.getCreditMemoFLEXVA().getFechaDePrescripcion());
                            notaPersist.setFechatimbrado(nota.getCreditMemoFLEXVA().getFechaTimbrado());
                            notaPersist.setAddendaid(nota.getCreditMemoFLEXVA().getAddendaid());
                            notaPersist.setFlexContext(nota.getCreditMemoFLEXVA().getFLEXContext());
                            notaPersist.setFlexContextDisplayvalue(nota.getCreditMemoFLEXVA().getFLEXContextDisplayValue());
                            notaPersist.setFlexNumofsegments(BigInteger.valueOf(nota.getCreditMemoFLEXVA().getFLEXNumOfSegments()));
                        }

//                notaPersist.setIdNotacredito(BigDecimal.ZERO);
                        if (respuesta.getProceso().getDescripcion().contains("Error en WS ERP")) {
                            notaPersist.setEstadoErp("300");
                        }
                        notaCreditoDAO.registra(notaPersist);
                    }
                } catch (Exception Ex) {
                    manejaLog.error(Ex, this.getClass());
                    Ex.printStackTrace();
                    respuesta.setProceso(new Proceso("100", "ERROR - La información de la nota de crédito no se puede guardar en la base de datos"));
                }
            } catch (Exception Ex) {
                //manejaLog.error(Ex, this.getClass());
                Ex.printStackTrace();
                respuesta.setProceso(new Proceso("100", "ERROR - No se puede enlazar con el WS: getERP_ejecutarNotaCredito"));
            }

        }
        return respuesta;
    }

}
