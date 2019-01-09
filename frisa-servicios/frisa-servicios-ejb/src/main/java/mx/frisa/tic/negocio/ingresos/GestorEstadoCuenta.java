/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.parsers.ParserConfigurationException;
import mx.frisa.tic.datos.comun.DAO;

import mx.frisa.tic.datos.comun.ProcedimientoAlmacendo;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaEdoCuentaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaMetodoPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaProcesaFacturasDTO;
import mx.frisa.tic.datos.entidades.XxfrcOrganizacionMetodopago;
import mx.frisa.tic.datos.entidades.XxfrtEstadoCuenta;
import mx.frisa.tic.datos.enums.ProcesoEnum;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.remoto.G_1;
import mx.frisa.tic.negocio.remoto.MetodoPagoOBI;
import mx.frisa.tic.negocio.remoto.RespuestaERP_Edo_Cuenta;
import mx.frisa.tic.negocio.remoto.RespuestaERP_EncabezadoRecibo;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import org.xml.sax.SAXException;

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
            //Validar carga inicial de Metodos de pago
            this.validarCargaInicialMetodosPago();
            respuestaWS = clienteWS.getERP_ejecutarReporteEdoCuenta(fechaInicio, fechaFinal, numeroCuenta);
            respuesta.setIdError(respuestaWS.getProceso().getTermino());
            respuesta.setDescripcionError(respuestaWS.getProceso().getDescripcion());
            List<PagoDTO> pagosDto = new ArrayList<>();
            if (respuestaWS.getProceso().getTermino().equals("0")) {
                //Proceso exitoso persistir en BD estados de cuenta
                List<G_1> lineasPago = respuestaWS.getDATA_DSObject().getG_1();
                DAO<XxfrtEstadoCuenta> estadoCuentaDao = new DAO(XxfrtEstadoCuenta.class);

                for (G_1 lineaPago : lineasPago) {

//                    manejaLog.debug("Procesando el estado de cuenta : getBANK_ACCOUNT_NUM" + lineaPago.getBANK_ACCOUNT_NUM());
//                    manejaLog.debug("getSTMT_TO_DATE : " + lineaPago.getSTMT_TO_DATE());
//                    manejaLog.debug("getLINE_NUMBER : " + lineaPago.getLINE_NUMBER());
                    XxfrtEstadoCuenta edoCuenta = new XxfrtEstadoCuenta();
                    edoCuenta.setBankAccountNum(BigDecimal.valueOf(Long.valueOf(lineaPago.getBANK_ACCOUNT_NUM())));
                    edoCuenta.setAddiotionalEntryInformation(lineaPago.getAMOUNT());
                    edoCuenta.setLineNumber(BigDecimal.valueOf(Long.valueOf(lineaPago.getLINE_NUMBER())));
                    edoCuenta.setTrxType(lineaPago.getTRX_TYPE());
                    edoCuenta.setAmount(BigDecimal.valueOf(Double.valueOf(lineaPago.getAMOUNT())));
                    edoCuenta.setTrxCode(BigDecimal.valueOf(Long.valueOf(lineaPago.getTRX_CODE())));
                    edoCuenta.setCurrencyCode(lineaPago.getCURRENCY_CODE());
                    edoCuenta.setCustomerReference(lineaPago.getREFERENCIA()); //CUSTOMER_REFERENCE
                    edoCuenta.setAddiotionalEntryInformation(lineaPago.getADDITIONAL_ENTRY_INFORMATION()); //ADDIOTIONAL_ENTRY_INFORMATION
                    edoCuenta.setProyectoPropietario(lineaPago.getPROYECTO_PROPIETARIO()); //PROYECTO_PROPIETARIO

                    edoCuenta.setLineCapture(lineaPago.getLINEA_CAPTURA());  //
                    edoCuenta.setDescripLookup(lineaPago.getDESCRIP_LOOKUP());  //
                    edoCuenta.setStatementHeaderId(lineaPago.getSTATEMENT_HEADER_ID());  //
                    edoCuenta.setStatementLineId(lineaPago.getSTATEMENT_LINE_ID());  //
                    edoCuenta.setStatementNumber((new Date()));
                    //Guardar en base de datos el estado de cuenta
                    ProcedimientoAlmacendo procEdoCta = new ProcedimientoAlmacendo();
                    RespuestaEdoCuentaDTO edoCtaDto = new RespuestaEdoCuentaDTO();

                    //Lanza a base la linea en estado de cuenta recuperando info escencial
                    edoCtaDto = procEdoCta.ejecutarEstadoCuenta(edoCuenta);
                    String idLineaCaptura = edoCtaDto.getIdLineaCaptura() + "";
                    manejaLog.debug("idLineaCaptura : " + idLineaCaptura);
                    manejaLog.debug("edoCtaDto.getOrgID : " + edoCtaDto.getOrgID());
                    manejaLog.debug("edoCtaDto.getIdPago() : " + edoCtaDto.getIdPago());
                    manejaLog.debug("edoCtaDto.getIdMetodoPago() : " + edoCtaDto.getIdMetodoPago());
                    manejaLog.debug("edoCtaDto.getCustomerID() : " + edoCtaDto.getCustomerID());
                    manejaLog.debug("edoCtaDto.getSiteID() : " + edoCtaDto.getSiteID());
                    manejaLog.debug("edoCtaDto.getBillCustomerName() : " + edoCtaDto.getBillCustomerName());


                    //Si no existe el metodo de pago en la BASE, vamos a buscarlo en el ERP
                    if (edoCtaDto.getIdMetodoPago() == null) {
                        edoCuenta.setReceiptMethodId(recuperarMetodoPagoId(edoCtaDto.getOrgID() + "", lineaPago.getBANK_ACCOUNT_NUM()));
                    }

                    //Asignamos datos al pago por el cobro del estado de cuenta actual
                    String numeroReciboERP = "";
                    PagoDTO pago = new PagoDTO(BigDecimal.valueOf(edoCtaDto.getIdEdoCuenta()), edoCuenta.getLineNumber(),
                            edoCuenta.getLineCapture(), edoCuenta.getCustomerReference(),
                            edoCuenta.getReceiptMethodId(), // Metodo de pago
                            edoCuenta.getCurrencyCode(),
                            edoCtaDto.getOrgID() + "", //ORG_ID
                            edoCtaDto.getIdPago() + "", // Numero de recibo Secuencial 
                            edoCuenta.getAmount() + "", edoCuenta.getGlDate()+ "", edoCtaDto.getCustomerID(), edoCtaDto.getSiteID());
                    
                    pago.setFechaContable("2018-12-26");
                    pago.setFechaAplicacion("2018-12-26");
                    
                    pago.setBillCustomerName(edoCtaDto.getBillCustomerName());
                    

                    //VALIDAMOS SI EL COBRO APLICA PARA UN PAGO valido DE LC o REFERENCIA
                    if (edoCtaDto.getIdPago() == null || edoCtaDto.getIdMetodoPago() == null || edoCtaDto.getCustomerID() == null || edoCtaDto.getSiteID() == null) {
                        //NO ES UN COBRO VALIDO errores posibles y persistirlos en base
                        manejaLog.debug("Error al procesar el estado de cuenta : " + estadoCuentaDao.getProceso().getDescripcion() + ", NoLinea : " + lineaPago.getLINE_NUMBER());
                        numeroReciboERP = ""; //Indicar el codigo de error como COBRO CON ERROR DE DATOS
                        edoCuenta.setRmethodid(BigDecimal.valueOf(Long.valueOf("4")));
                        /*
                        "Estatus del pago.
                            0:PAGOSINREF = pago sin referencia,
                            1:CERRADA
                            2:PROCESANDO,
                            3:SALDO 
                            4: COBRO CON ERRORES DE DATOS - ver reporte de errores
                            "
                         */

                        /*ADICIONAL En tabla de control de Errores corresponde a tabla xxfrc_error
                        110 - La linea del estado de cuenta no cuenta con un metodo de pago valido
                        111 - La linea del estado de cuenta no cuenta con el id de organizacion valido
                        112 - La linea del estado de cuenta no cuenta con el id de Customer valido
                        113 - La linea del estado de cuenta no cuenta con el id de Customer valido
                         */
                    } else {

                        edoCuenta.setIdLineaCaptura(BigDecimal.valueOf(Long.valueOf(idLineaCaptura)));
                        //Asignar proceso a EDO-PROCESANDO
                        edoCuenta.setRmethodid(BigDecimal.valueOf(Long.valueOf("2")));
                        edoCuenta.setIdEdoCta(BigDecimal.valueOf(Long.valueOf(edoCtaDto.getIdEdoCuenta())));
                        DAO<XxfrtEstadoCuenta> edoCtaEnt = new DAO(XxfrtEstadoCuenta.class);

                        //Llamar a WS Genera cabecera recibo
                        AdaptadorWS adpCabecera = new AdaptadorWS();
                        //Solo si existe metodo de pago se genera la cabecera
                        if (edoCuenta.getReceiptMethodId() != null && edoCtaDto.getOrgID() != null) {
                            numeroReciboERP = adpCabecera.getERP_generarEncabezadoRecibo(pago).getNumeroRecibo();
                            edoCuenta.setRmethodid(BigDecimal.valueOf(Long.valueOf("2")));
                        } else {
                            //Hubo algun error al generar la cabecera del cobro
                            edoCuenta.setRmethodid(BigDecimal.valueOf(Long.valueOf("0")));
                        }

                        //Registrar en BD el estatus final de la LINEA ACTUAL DEL estado de cuenta 
                        edoCtaEnt.actualiza(edoCuenta);

                    }

                    pago.setNroRecibo(numeroReciboERP);
                    pagosDto.add(pago);

                }

                //Llamar al procesar pagos
                RespuestaERP_EncabezadoRecibo respAplicaPago = new RespuestaERP_EncabezadoRecibo();
                respuesta.setProceso(ProcesoEnum.ERROR.toString());
                respuesta.setIdError("100");
                respuesta.setDescripcionError("No hay líneas con referencia validas en el estado de cuenta para procesar pagos");

                if (pagosDto.size() > 0) {
                    GestorPagos pagosBean = new GestorPagosBean();
                    RespuestaProcesaFacturasDTO respuestaPagos = pagosBean.generarPago(pagosDto);
                    //Recorrer facturas para asociar info a pagos
                    for (FacturaPagoDTO factura : respuestaPagos.getFacturas()) {
                        //Asociar pagosDto contra facturas generadas
                        for (PagoDTO pagoElemento :pagosDto){
                            if (pagoElemento.getLineaCaptura().equals(factura.getLineacaptura())
                                    && pagoElemento.getNroRecibo().equals(factura.getIdfacturaprimavera())){
                                //Asignar valores que necesite el pago desde la factura
                                pagoElemento.setBillCustomerName(factura.getBilltoconsumername());
                            }
                        }
                    }

                    AdaptadorWS adpCabecera = new AdaptadorWS();
                    //Aplicar pagos en ERP
                    respAplicaPago = adpCabecera.getERP_AplicarPago(pagosDto);
                    respuesta.setProceso(respAplicaPago.getProceso().getTermino());
                    if (respAplicaPago.getProceso().getTermino().equals("0")) {
                        respuesta.setProceso(ProcesoEnum.EXITOSO.toString());
                        respuesta.setDescripcionError("Consultar pagos-facturas procesados");
                    }
                }

            } else {
                //Notificar error detectado

                respuesta.setProceso(ProcesoEnum.ERROR.toString());
                respuesta.setDescripcionError("No existen estados de cuenta pendientes de procesar");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta.setProceso(ProcesoEnum.ERROR.toString());
            respuesta.setDescripcionError("No existen estados de cuenta validos de procesar");
        }

        System.out.println("-------------------------------");

        System.out.println("-------------------------------");
        //Lanzar a procedimiento de base de datos los estados de cuenta a procesar

        //Regresar respuesta exitosa
        return respuesta;
    }

    private void validarCargaInicialMetodosPago() throws IOException, MalformedURLException, SAXException, ParserConfigurationException {
        DAO<XxfrcOrganizacionMetodopago> metodosPagoDao = new DAO(XxfrcOrganizacionMetodopago.class);
        List<XxfrcOrganizacionMetodopago> metodoPago = (List<XxfrcOrganizacionMetodopago>) metodosPagoDao.consultaQueryNamed("XxfrcOrganizacionMetodopago.findAll");
        if (metodoPago.size() == 0) {
            //Lanzar la carga de info desde el ERP
            AdaptadorWS adaptador = new AdaptadorWS();
            RespuestaMetodoPagoDTO respuesta
                    = adaptador.getERP_obtenerMetodosCargaInicial();

            if (respuesta.getProceso().getTermino().equals("0")) {
                //Insertar las encontradas
                MetodoPagoOBI metodos = respuesta.getMetodosPago();
                ProcedimientoAlmacendo procE = new ProcedimientoAlmacendo();
                procE.cargaInicialMetodos(metodos);

            }
        }
    }

    private String recuperarMetodoPagoId(String organizacion, String cuentaBanco) {
//        return "300000007076780";
        DAO<XxfrcOrganizacionMetodopago> metodoPagoDao = new DAO(XxfrcOrganizacionMetodopago.class);
        List<XxfrcOrganizacionMetodopago> metodos
                = (List<XxfrcOrganizacionMetodopago>) metodoPagoDao.consultaQueryNativo("Select x from XxfrcOrganizacionMetodopago x where x.xxfrcOrganizacionMetodopagoPK.orgId = " + organizacion + " and x.xxfrcOrganizacionMetodopagoPK.bankAccountId = " + cuentaBanco);
        String metodoEncontrado = "";
        if (metodos != null) {
            metodoEncontrado = metodos.get(0).getXxfrcOrganizacionMetodopagoPK().getReceiptMethodId() + "";
        }
        if (metodoEncontrado.equals("")) {
            //Buscar en BI el metodo correspondiente
            AdaptadorWS adaptador = new AdaptadorWS();
            try {
                metodoEncontrado = adaptador.getERP_obtenerMetodosPorID(organizacion, cuentaBanco).getDescripcionError();
            } catch (IOException ex) {
                Logger.getLogger(GestorEstadoCuenta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(GestorEstadoCuenta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(GestorEstadoCuenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return metodoEncontrado;
    }

}
