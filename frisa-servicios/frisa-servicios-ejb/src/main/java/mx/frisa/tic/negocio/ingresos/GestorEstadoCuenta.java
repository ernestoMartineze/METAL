/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.comun.ParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.entidades.XxfrLineaCaptura;
import mx.frisa.tic.datos.entidades.XxfrtEstadoCuenta;
import mx.frisa.tic.datos.enums.ProcesoEnum;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.remoto.G_1;
import mx.frisa.tic.negocio.remoto.RespuestaERP_Edo_Cuenta;
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
            if (respuestaWS.getProceso().getTermino().equals("0")) {
                //Proceso exitoso persistir en BD estados de cuenta
                List<G_1> lineasPago = respuestaWS.getDATA_DSObject().getG_1();
                DAO<XxfrLineaCaptura> LineaCapturaDao = new DAO(XxfrLineaCaptura.class);
                DAO<XxfrtEstadoCuenta> estadoCuentaDao = new DAO(XxfrtEstadoCuenta.class);
                for (G_1 lineaPago : lineasPago) {

                    manejaLog.debug("Procesando el estado de cuenta : getBANK_ACCOUNT_NUM" + lineaPago.getBANK_ACCOUNT_NUM());
                    manejaLog.debug("getSTMT_TO_DATE : " + lineaPago.getSTMT_TO_DATE());
                    manejaLog.debug("getLINE_NUMBER : " + lineaPago.getLINE_NUMBER());

                    XxfrtEstadoCuenta edoCuenta = new XxfrtEstadoCuenta();
                    edoCuenta.setBankAccountNum(BigDecimal.valueOf(Long.valueOf(lineaPago.getBANK_ACCOUNT_NUM())));
//                    edoCuenta.setTrxDate(new Date());
                    edoCuenta.setIdEdoCta(null);
                    edoCuenta.setLineNumber(BigDecimal.valueOf(Long.valueOf(lineaPago.getLINE_NUMBER())));
                    edoCuenta.setTrxType(lineaPago.getTRX_TYPE());
                    edoCuenta.setAmount(BigDecimal.valueOf(Long.valueOf(lineaPago.getAMOUNT())));
                    edoCuenta.setTrxCode(BigDecimal.valueOf(Long.valueOf(lineaPago.getTRX_CODE())));
                    edoCuenta.setCurrencyCode(lineaPago.getCURRENCY_CODE());
                    edoCuenta.setCustomerReference("123456789012341"); //CUSTOMER_REFERENCE
                    edoCuenta.setAddiotionalEntryInformation("WERTYUTR|011510000019400000026417676205|DFGSDFGHFDGHERYRSGSFRG|123456789012341|RWTEYUHGFDS#$"); //ADDIOTIONAL_ENTRY_INFORMATION
                    edoCuenta.setProyectoPropietario("151"); //PROYECTO_PROPIETARIO
                    String lineaCapturaEnERP = "011510000019400000026417676205";
                    edoCuenta.setLineCapture(lineaCapturaEnERP);  //Linea captura
                    List<CatalogoParametroDTO> plistaParametros = new ArrayList<>();
                    plistaParametros.add (new CatalogoParametroDTO("lineacaptura",lineaCapturaEnERP,"CADENA"));
                    List<XxfrLineaCaptura> lineasCaptura = (List<XxfrLineaCaptura>) LineaCapturaDao.consultaQueryByParameters("XxfrLineaCaptura.findByLineacaptura", plistaParametros);
                    if (!estadoCuentaDao.getProceso().getTermino().equals("0")) {
                        edoCuenta.setIdLineaCaptura(lineasCaptura.get(0).getIdlineacaptura());  // ID Linea captura
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

            } else {
                //Notificar error detectado

                respuesta.setProceso(ProcesoEnum.ERROR.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("-------------------------------");

        System.out.println("-------------------------------");
        //Lanzar a procedimiento de base de datos los estados de cuenta a procesar

        //Regresar respuesta exitosa
        return respuesta;
    }

}
