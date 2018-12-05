/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;

import mx.frisa.tic.datos.comun.ProcedimientoAlmacendo;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.entidades.XxfrLineaCaptura;
import mx.frisa.tic.datos.entidades.XxfrtEstadoCuenta;
import mx.frisa.tic.datos.enums.ProcesoEnum;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.remoto.G_1;
import mx.frisa.tic.negocio.remoto.RespuestaERP_Edo_Cuenta;
import mx.frisa.tic.negocio.remoto.RespuestaERP_EncabezadoRecibo;
import mx.frisa.tic.negocio.utils.ManejadorLog;

/**
 *
 * @author USER_1
 */
@Stateless(name = "GestorEstadoCuenta")
@LocalBean
public class GestorEstadoCuenta implements GestorEstadoCuentaLocal {

    @Override
    public RespuestaDTO procesarEstadosCuenta(final String fechaInicio, final String fechaFinal, final String numeroCuenta) {
        RespuestaDTO respuesta = new RespuestaDTO();
        RespuestaERP_Edo_Cuenta respuestaWS;
        ManejadorLog manejaLog = new ManejadorLog();
        try {
            AdaptadorWS clienteWS = new AdaptadorWS();
            respuestaWS = clienteWS.getERP_ejecutarReporteEdoCuenta(fechaInicio, fechaFinal, numeroCuenta);
            respuesta.setIdError(respuestaWS.getProceso().getTermino());
            respuesta.setDescripcionError(respuestaWS.getProceso().getDescripcion());
            List<PagoDTO> pagosDto = new ArrayList<>();
            if (respuestaWS.getProceso().getTermino().equals("0")) {
                //Proceso exitoso persistir en BD estados de cuenta
                List<G_1> lineasPago = respuestaWS.getDATA_DSObject().getG_1();
                DAO<XxfrtEstadoCuenta> estadoCuentaDao = new DAO(XxfrtEstadoCuenta.class);
                for (G_1 lineaPago : lineasPago) {

                    manejaLog.debug("Procesando el estado de cuenta : getBANK_ACCOUNT_NUM" + lineaPago.getBANK_ACCOUNT_NUM());
                    manejaLog.debug("getSTMT_TO_DATE : " + lineaPago.getSTMT_TO_DATE());
                    manejaLog.debug("getLINE_NUMBER : " + lineaPago.getLINE_NUMBER());

                    XxfrtEstadoCuenta edoCuenta = new XxfrtEstadoCuenta();
                    edoCuenta.setBankAccountNum(BigDecimal.valueOf(Long.valueOf(lineaPago.getBANK_ACCOUNT_NUM())));
                    edoCuenta.setAddiotionalEntryInformation(lineaPago.getAMOUNT());
                    edoCuenta.setLineNumber(BigDecimal.valueOf(Long.valueOf(lineaPago.getLINE_NUMBER())));
                    edoCuenta.setTrxType(lineaPago.getTRX_TYPE());
                    edoCuenta.setAmount(BigDecimal.valueOf(Long.valueOf(lineaPago.getAMOUNT())));
                    edoCuenta.setTrxCode(BigDecimal.valueOf(Long.valueOf(lineaPago.getTRX_CODE())));
                    edoCuenta.setCurrencyCode(lineaPago.getCURRENCY_CODE());
                    edoCuenta.setCustomerReference("123456789012341"); //CUSTOMER_REFERENCE
                    edoCuenta.setAddiotionalEntryInformation("WERTYUTR|011510000019400000026417676205|DFGSDFGHFDGHERYRSGSFRG|123456789012341|RWTEYUHGFDS#$"); //ADDIOTIONAL_ENTRY_INFORMATION
                    edoCuenta.setProyectoPropietario("151"); //PROYECTO_PROPIETARIO

                    edoCuenta.setLineCapture("011510000019400000026417676205");  //Linea captura hardcodeada
                    //Guardar en base de datos el estado de cuenta
                    ProcedimientoAlmacendo procEdoCta = new ProcedimientoAlmacendo();
                    String idLineaCaptura = procEdoCta.ejecutarEstadoCuenta(edoCuenta).getProceso();
                    if (!idLineaCaptura.equals("0")) {
                        manejaLog.debug("Error al procesar el estado de cuenta : " + estadoCuentaDao.getProceso().getDescripcion() + ", NoLinea : " + lineaPago.getLINE_NUMBER());
                    } else {
                        //Existe LineaCaptura asiganarla
                        edoCuenta.setIdLineaCaptura(BigDecimal.valueOf(Long.valueOf(idLineaCaptura)));
                        PagoDTO pago = new PagoDTO(edoCuenta.getIdEdoCta(), edoCuenta.getLineNumber(),
                                edoCuenta.getLineCapture(), edoCuenta.getCustomerReference(), "METODOID",
                                edoCuenta.getCurrencyCode(), edoCuenta.getProyectoPropietario(), "NOMRECIBO",
                                edoCuenta.getAmount() + "", edoCuenta.getTrxDate() + "", "CUSTOMER_ID", "SITE_ID");
                        pagosDto.add(pago);

                    }
                    //Guardar en base de datos el estado de cuenta si es valida la linea de captura y su monto
                    if (lineasCaptura.get(0).getMontolineacaptura() == BigDecimal.valueOf(Long.valueOf(lineaPago.getAMOUNT()))) {
                        estadoCuentaDao.actualizaQuery("INSERT INTO \"INGRESOS\".\"XXFR_ESTADO_CUENTA\" (BANK_ACCOUNT_NUM, TRX_DATE, LINE_NUMBER, TRX_TYPE, AMOUNT, TRX_CODE, CURRENCY_CODE, CUSTOMER_REFERENCE, ADDIOTIONAL_ENTRY_INFORMATION, PROYECTO_PROPIETARIO, LINE_CAPTURE) VALUES ('1136556', TO_DATE('2018-12-04 00:01:00', 'YYYY-MM-DD HH24:MI:SS'), '1', 'qweqe', '123', '12', 'mfg', '2312312', 'wasdfsadf23', '151', 'wesdgfhdsa')");
                        if (!estadoCuentaDao.getProceso().getTermino().equals("0")) {
                            manejaLog.debug("Error al procesar el estado de cuenta : " + estadoCuentaDao.getProceso().getDescripcion() + ", NoLinea : " + lineaPago.getLINE_NUMBER());
                            respuesta.setProceso(ProcesoEnum.ERROR.toString());
                        } else {
                            respuesta.setProceso(ProcesoEnum.EXITOSO.toString());
                        }
                    } else {
                        respuesta.setProceso(ProcesoEnum.ERROR.toString());
                    }

                }

                //Procesar Encabezado de recibo y obtener NoREcibo
                RespuestaERP_EncabezadoRecibo respuestaEnca = clienteWS.getERP_generarEncabezadoRecibo(pagosDto);
                //Llamar al procesar pagos
//                GestorPagos pagosBean = new GestorPagosBean();
//                pagosBean.generarPago(pagosDto);
                respuesta.setProceso(ProcesoEnum.EXITOSO.toString());


            } else {
                //Notificar error detectado

                respuesta.setProceso(ProcesoEnum.ERROR.toString());
                respuesta.setDescripcionError("Noexisten estados de cuenta pendientes de procesar");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta.setProceso(ProcesoEnum.ERROR.toString());
            respuesta.setDescripcionError("No existen estados de cuenta pendientes de procesar");
        }

        System.out.println("-------------------------------");

        System.out.println("-------------------------------");
        //Lanzar a procedimiento de base de datos los estados de cuenta a procesar

        //Regresar respuesta exitosa
        return respuesta;
    }

}
