/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.AplicarPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.EstadoCuentaDTO;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.FiltroPagoSinReferencia;
import mx.frisa.tic.datos.dto.ingresos.LineaEstadoCuentaDTO;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.PagoPorAplicarDTO;
import mx.frisa.tic.datos.dto.ingresos.PeticionExistente;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.ingresos.RespuestaAplicarPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaClienteDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaEdoCuentaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaPagoSinReferencia;
import mx.frisa.tic.datos.dto.ingresos.RespuestaProcesaFacturasDTO;
import mx.frisa.tic.datos.entidades.XxfrCabeceraFactura;
import mx.frisa.tic.datos.entidades.XxfrLineaCaptura;
import mx.frisa.tic.datos.entidades.XxfrReciboLineaCaptura;
import mx.frisa.tic.datos.entidades.XxfrtEstadoCuenta;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcFactura;
import mx.frisa.tic.datos.entidades.XxfrvEstadoctaUsr;
import mx.frisa.tic.datos.entidades.XxfrvFactparapagos;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.remoto.RespuestaCreaFactura;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import mx.frisa.tic.utils.FechaUtils;

/**
 *
 * @author Soultech
 */
@Stateless(name = "GestorPagosBean")
@LocalBean
public class GestorPagosBean implements GestorPagos {

    @Override
    public RespuestaProcesaFacturasDTO generarPago(List<PagoDTO> pagos) {
        RespuestaProcesaFacturasDTO respuesta = new RespuestaProcesaFacturasDTO();
        /*SECUENCIA DEL PROCESO 
        1. LOGRADO - Consulta de estado de cuenta (ERP)
        2. Validar existencia de LC o Ref (BD)
        3. Validar factura al cobro o normal
        4. Crear factura al cobro (ERP)
        5. Registrar cabecera de facturaPago en ERP
        6. Aplicar facturas en ERP
         */
        try {
            respuesta = recuperaFacturas(pagos);
        } catch (IOException ex) {
            Logger.getLogger(GestorPagosBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        respuesta.setProceso("GestorPagosBean-generarPago");
        respuesta.setIdError("000");
        respuesta.setDescripcionError("OK");
        return respuesta;
    }

    private RespuestaProcesaFacturasDTO recuperaFacturas(List<PagoDTO> pagos) throws IOException {
        ManejadorLog log = new ManejadorLog();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        DAO<XxfrvFactparapagos> consultaDAO = new DAO(XxfrvFactparapagos.class);
        List<XxfrvFactparapagos> facturasDTO = new ArrayList();
        List<FacturaPagoDTO> facturasAlCobro = new ArrayList();
        List<FacturaPagoDTO> facturas = new ArrayList();
        List<PagoDTO> response = new ArrayList();
        StringBuilder query = new StringBuilder();
        StringBuilder paramLc = new StringBuilder();
        RespuestaProcesaFacturasDTO respuesta = new RespuestaProcesaFacturasDTO("ERROR", "100", "Existe error en proceso de facturas al cobro");

        //Recorrer los pagos y solo generar facturas de aquellas que tienen LINEA DE CAPTURA y numero de recibo de facturaPago
        for (PagoDTO pago : pagos) {
            paramLc.append("'" + pago.getLineaCaptura() + "',");

        }
        //En caso de no contar con ninguan linea de captura valida no debe generar alguna consulta
        if (paramLc.length() != 0) {
            query.append("SELECT x ")
                    .append(" FROM XxfrvFactparapagos x ")
                    .append("WHERE x.lineacaptura in (")
                    .append(paramLc.toString().substring(0, paramLc.toString().length() - 1))
                    .append(")");
            try {
                facturasDTO = consultaDAO.consultaQueryNativo(query.toString());
            } catch (Exception ex) {
                log.debug("Error al ejecutar el query: " + query.toString());
                log.error(ex, GestorPagosBean.class);
            }

            for (XxfrvFactparapagos pago : facturasDTO) {
                FacturaPagoDTO factura = new FacturaPagoDTO();
                factura.setIdlinea(pago.getIdlinea());
                factura.setBusinessunitname(pago.getBusinessunitname());
                factura.setTransactionsource(pago.getTransactionsource());
                factura.setTransactiontype(pago.getTransactiontype());
                factura.setCreationdatetrx(dateFormat.format(pago.getCreationdatetrx()));
                factura.setCreationdategl(dateFormat.format(pago.getCreationdategl()));
                factura.setBilltoconsumername(pago.getBilltoconsumername());
                factura.setBilltolocation(pago.getBilltolocation());
                factura.setPaymenttermdays(pago.getPaymenttermdays());
                factura.setGenerationtype(pago.getGenerationtype());
                factura.setIdfacturaprimavera(pago.getIdfacturaprimavera());
                factura.setLinenumber(pago.getLinenumber());
                factura.setMemolinename(pago.getMemolinename());
                factura.setDescription_origen(pago.getDescriptionOrigen());
                factura.setQuantity(pago.getQuantity());
                factura.setMontobrutolinea(pago.getMontobrutolinea());
                factura.setClasificadordescuento(pago.getClasificadordescuento());
                factura.setDescadicional1(pago.getDescadicional1());
                factura.setDescadicional2(pago.getDescadicional2());
                factura.setDescadicional3(pago.getDescadicional3());
                factura.setDescadicional4(pago.getDescadicional4());
                factura.setDescadicional5(pago.getDescadicional5());
                factura.setFechadesde(dateFormat.format(pago.getFechadesde()));
                factura.setFechahasta(dateFormat.format(pago.getFechahasta()));
                factura.setDffheadercontext(pago.getDffheadercontext());
                factura.setFechaexigibilidad(dateFormat.format(pago.getFechaexigibilidad()));
                factura.setProjectid(pago.getProjectid());
                factura.setFolioavisocargo(pago.getFolioavisocargo());
                factura.setLocalnumber(pago.getLocalnumber());
                factura.setLineacaptura(pago.getLineacaptura());
                facturas.add(factura);
                if (factura.getGenerationtype().equals("INVOICE_TO_COLLECTION")) {
                    facturasAlCobro.add(factura);
                }
            }
            //TODO - Llamada al servicio de creación de facturas
            AdaptadorWS adaptador = new AdaptadorWS();
            if (facturasAlCobro.size() > 0) {
                adaptador.getOBI_generarFacturaAlCobro(facturasAlCobro);
            }
            respuesta = new RespuestaProcesaFacturasDTO("EXITOSO", "0", "");
            respuesta.setFacturas(facturas);
        }
        return respuesta;
    }

    public RespuestaProcesaFacturasDTO recuperaFacturas(PagoDTO pago) throws IOException {
        ManejadorLog log = new ManejadorLog();
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        DAO<XxfrvFactparapagos> consultaDAO = new DAO(XxfrvFactparapagos.class);
        List<XxfrvFactparapagos> facturasDTO = new ArrayList();
        List<FacturaPagoDTO> facturasAlCobro = new ArrayList();
        List<FacturaPagoDTO> facturas = new ArrayList();
        StringBuilder query = new StringBuilder();
        RespuestaProcesaFacturasDTO respuesta = new RespuestaProcesaFacturasDTO("ERROR", "100", "Existe error en proceso de facturas al cobro");

        if (!pago.getLineaCaptura().equals("")) {

            query.append("SELECT x ")
                    .append(" FROM XxfrvFactparapagos x ")
                    .append("WHERE x.estadoprocesamiento = 'REGISTRADA' and x.lineacaptura in (")
                    .append("'" + pago.getLineaCaptura() + "'")
                    .append(")");
        } else {
            query.append("SELECT x ")
                    .append(" FROM XxfrvFactparapagos x ")
                    .append("WHERE x.estadoprocesamiento = 'REGISTRADA' and x.REFERENCENUMBER in (")
                    .append("'" + pago.getReferencia() + "'")
                    .append(")");
        }

        //En caso de no contar con ninguan linea de captura valida no debe generar alguna consulta
        if (query.length() != 0) {
            log.debug("Query : " + query.toString());
            try {
                facturasDTO = consultaDAO.consultaQueryNativo(query.toString());
            } catch (Exception ex) {
                log.debug("Error al ejecutar el query: " + query.toString());
                log.error(ex, GestorPagosBean.class);
            }

            for (XxfrvFactparapagos facturaPago : facturasDTO) {
                FacturaPagoDTO factura = new FacturaPagoDTO();
                factura.setIdlinea(facturaPago.getIdlinea());
                factura.setBusinessunitname(facturaPago.getBusinessunitname());
                factura.setTransactionsource(facturaPago.getTransactionsource());
                factura.setTransactiontype(facturaPago.getTransactiontype());
                factura.setCreationdatetrx(FechaUtils.convierteFecha(facturaPago.getCreationdatetrx()));
                factura.setCreationdategl(FechaUtils.convierteFecha(facturaPago.getCreationdategl()));
                factura.setBilltoconsumername(facturaPago.getBilltoconsumername());
                factura.setBilltolocation(facturaPago.getBilltolocation());
                factura.setPaymenttermdays(facturaPago.getPaymenttermdays());
                factura.setGenerationtype(facturaPago.getGenerationtype());
                factura.setIdfacturaprimavera(facturaPago.getIdfacturaprimavera());
                factura.setLinenumber(facturaPago.getLinenumber());
                factura.setMemolinename(facturaPago.getMemolinename());
                factura.setDescription_origen(facturaPago.getDescriptionOrigen());
                factura.setQuantity(facturaPago.getQuantity());
                factura.setMontobrutolinea(facturaPago.getMontobrutolinea());
                factura.setClasificadordescuento(facturaPago.getClasificadordescuento());
                factura.setDescadicional1(facturaPago.getDescadicional1());
                factura.setDescadicional2(facturaPago.getDescadicional2());
                factura.setDescadicional3(facturaPago.getDescadicional3());
                factura.setDescadicional4(facturaPago.getDescadicional4());
                factura.setDescadicional5(facturaPago.getDescadicional5());
                factura.setFechadesde(FechaUtils.convierteFecha(facturaPago.getFechadesde()));
                factura.setFechahasta(FechaUtils.convierteFecha(facturaPago.getFechahasta()));
                factura.setDffheadercontext(facturaPago.getDffheadercontext());
                factura.setFechaexigibilidad(FechaUtils.convierteFecha(facturaPago.getFechaexigibilidad()));
                factura.setProjectid(facturaPago.getProjectid());
                factura.setFolioavisocargo(facturaPago.getFolioavisocargo());
                factura.setLocalnumber(facturaPago.getLocalnumber());
                factura.setLineacaptura(facturaPago.getLineacaptura());
                factura.setServiceStatus_ERP("S");
                facturas.add(factura);
                log.debug("Tipo de factura : " + factura.getGenerationtype());
                if (factura.getGenerationtype().equals("INVOICE_TO_COLLECTION")) {
                    facturasAlCobro.add(factura);
                }
            }
            //TODO - Llamada al servicio de creación de facturas
            AdaptadorWS adaptador = new AdaptadorWS();
            if (facturasAlCobro.size() > 0) {
                RespuestaCreaFactura respuestaCrea = adaptador.getOBI_generarFacturaAlCobro(facturasAlCobro);
                if (respuestaCrea.getProceso().getTermino().equals("0")) {
                    respuesta = new RespuestaProcesaFacturasDTO("EXITOSO", "0", "");
                    int contadorFactura = 0;
                    for (FacturaPagoDTO facturaActual : facturas) {
                        for (FacturaPagoDTO facturaGeneradaAlCobro : respuestaCrea.getFacturas()) {
                            if (facturas.get(contadorFactura).getIdfacturaprimavera() == facturaGeneradaAlCobro.getIdfacturaprimavera()
                                    && facturas.get(contadorFactura).getIdlinea() == facturaGeneradaAlCobro.getIdlinea()) {
                                //Si corresponde la factura y linea con la creada se... asigna el valor transaccional con el ERP
                                facturas.get(contadorFactura).setTransactionID_ERP(facturaGeneradaAlCobro.getTransactionID_ERP());
                                facturas.get(contadorFactura).setServiceStatus_ERP(facturaGeneradaAlCobro.getServiceStatus_ERP());
                                facturas.get(contadorFactura).setCustomerTrxID_ERP(facturaGeneradaAlCobro.getCustomerTrxID_ERP());
                            }
                        }
                        contadorFactura++;
                    }
                } else {
                    respuesta = new RespuestaProcesaFacturasDTO("ERROR", "1000", "Al procesar facturas al cobro");
                }
            } else {
                respuesta = new RespuestaProcesaFacturasDTO("EXITOSO", "0", "");

            }
            respuesta.setFacturas(facturas);
        }
        return respuesta;
    }

    /**
     *
     * @param filtros
     * @return
     */
    @Override
    public RespuestaPagoSinReferencia consultarPagosSinReferencia(FiltroPagoSinReferencia filtros) {
        RespuestaPagoSinReferencia respuesta = new RespuestaPagoSinReferencia();
        ManejadorLog log = new ManejadorLog();
        DAO<XxfrvEstadoctaUsr> lineasEstadoCuentaDAO = new DAO(XxfrvEstadoctaUsr.class);
        List<XxfrvEstadoctaUsr> lineasEdoCtaEntidad = new ArrayList();
        String queryArmado = "SELECT x FROM XxfrvEstadoctaUsr x WHERE ";

        try {

            //Para saber si necesitamos eliminar de la consulta a los PAGOS APLICADOS
            if (filtros.getMostrarAplicar().equals("NO")) {
                queryArmado += " x.rmethodid = 0 ";

            } else { // De lo contrario, se muestran los Manuales POR APLICAR, y LOS APLICADOS que cumplan el criterio
                queryArmado += " x.rmethodid = 1 ";
            }

            if (!filtros.getCuentaBancaria().equals("")) {
                queryArmado += " and x.bankAccountNum =".concat(filtros.getCuentaBancaria());

            }
            if (!filtros.getUsuario().equals("")) {
                queryArmado += " and x.usuario =  '" + filtros.getUsuario() + "'";

            }
            if (!(filtros.getFechaFinal().equals("")
                    && filtros.getFechaFinal().equals(""))) {
                queryArmado += " and x.glDate between "
                        .concat(" FUNCTION('TO_DATE', '").concat(filtros.getFechaInicial() + "','yyyy-MM-dd')")
                        .concat(" and ")
                        .concat(" FUNCTION('TO_DATE', '").concat(filtros.getFechaFinal() + "','yyyy-MM-dd')+1");

            }
            //HAcer la consulta
            System.err.println("queryArmado : " + queryArmado);
            lineasEdoCtaEntidad = (List<XxfrvEstadoctaUsr>) lineasEstadoCuentaDAO.consultaQueryNativo(queryArmado);
            List<LineaEstadoCuentaDTO> lineas = new ArrayList();
            for (XxfrvEstadoctaUsr lineasEdoCuentaEnt : lineasEdoCtaEntidad) {
                LineaEstadoCuentaDTO lineaDto = new LineaEstadoCuentaDTO();
                lineaDto.setIdEstadoCuenta(lineasEdoCuentaEnt.getIdEdoCta());
                lineaDto.setCuentaBancaria(lineasEdoCuentaEnt.getBankAccountNum());
                String fechaLinea = "";
                if (lineasEdoCuentaEnt.getGlDate() != null) {
                    fechaLinea = FechaUtils.convierteFecha(lineasEdoCuentaEnt.getGlDate());
                }
                lineaDto.setFecha(fechaLinea);
                lineaDto.setConceptoMovimiento(lineasEdoCuentaEnt.getAddiotionalEntryInformation());
                lineaDto.setIdPago(lineasEdoCuentaEnt.getIdEdoCta());
                lineaDto.setMonto(lineasEdoCuentaEnt.getAmount());
                lineaDto.setMetodoPago(lineasEdoCuentaEnt.getReceiptMethodId());
                lineaDto.setTipoDeposito(lineasEdoCuentaEnt.getDescripLookup());
                lineaDto.setProyecto(BigDecimal.valueOf(Long.valueOf(lineasEdoCuentaEnt.getProyectoPropietario())));
                lineaDto.setOrgID(lineasEdoCuentaEnt.getBusinessunitname());
                lineaDto.setCliente(lineasEdoCuentaEnt.getNombrecliente());
                lineaDto.setUsuario(lineasEdoCuentaEnt.getUsuario());
                lineaDto.setMoneda(lineasEdoCuentaEnt.getCurrencyCode());
                lineas.add(lineaDto);
            }
            respuesta.setProceso(new Proceso("0", "EXITOSO"));
            respuesta.setLineas(lineas);
        } catch (NoResultException | NonUniqueResultException ex) {
            respuesta.setProceso(new Proceso("700", "ERROR"));
            ex.printStackTrace();
        }

        return respuesta;
    }

    @Override
    public RespuestaClienteDTO consultarReferenciaLCExistente(PeticionExistente filtros) {

        RespuestaClienteDTO respuesta = new RespuestaClienteDTO();
        ManejadorLog log = new ManejadorLog();

        try {
            log.debug("Entro consultarReferenciaLCExistente");
            if (!filtros.getLineaCaptura().equals("") || !filtros.getReferencia().equals("")) {
                DAO<XxfrvConsultaLcFactura> lineasOreferenciasDao = new DAO(XxfrvConsultaLcFactura.class);
                List<XxfrvConsultaLcFactura> lineasReferencias = new ArrayList<>();

                //Buscar por
                String nombreConsulta = "";
                List<CatalogoParametroDTO> parametros = new ArrayList<>();

                if (!filtros.getLineaCaptura().equals("")) {
                    nombreConsulta = "XxfrvConsultaLcFactura.findByLineacaptura";
                    parametros.add(new CatalogoParametroDTO("lineacaptura", filtros.getLineaCaptura(), CONSTANTE.CADENA));
                } else {
                    nombreConsulta = "XxfrvConsultaLcFactura.findByReferencia";
                    parametros.add(new CatalogoParametroDTO("referencenumber", filtros.getReferencia(), CONSTANTE.CADENA));
                }
                lineasReferencias = (List<XxfrvConsultaLcFactura>) lineasOreferenciasDao.consultaQueryByParameters(nombreConsulta, parametros);

                respuesta.setProceso(new Proceso("0", "EXITOSO"));
                Boolean montoPagoCubreTotalDeuda = true;
                for (XxfrvConsultaLcFactura lineasReferenRecuperada : lineasReferencias) {
                    respuesta.setCliente(lineasReferenRecuperada.getBilltoconsumername());
                    respuesta.setProyectoID(BigDecimal.valueOf(lineasReferenRecuperada.getProjectid()));
                    //CONSULTAR POR BI
                    respuesta.setEstadoCobro("Por Aplicar");
                    respuesta.setEstadoConciliacion("Conciliado");
                    respuesta.setIdPago(BigDecimal.ONE);
                    try {
                        respuesta.setMontoPendienteDeAplicar(BigDecimal.valueOf(Long.valueOf(lineasReferenRecuperada.getPendientePorAplicar())));
                    } catch (Exception ex) {
                        respuesta.setMontoPendienteDeAplicar(BigDecimal.valueOf(Long.valueOf("99999999999")));
                        ex.printStackTrace();
                    }
                    if (filtros.getMontoPago().compareTo(respuesta.getMontoPendienteDeAplicar()) < 0) { //Si el monto de pago es menor al monto pendiente de cobro
                        montoPagoCubreTotalDeuda = false;
                    }
                    respuesta.setNombrePago(lineasReferenRecuperada.getIdlinea());
                    respuesta.setUnidadNegocio(lineasReferenRecuperada.getBusinessUnitName());
                    respuesta.setTotalLC(lineasReferenRecuperada.getTotalamount()); //Total de la linea de captura / referencia
                }

                if (montoPagoCubreTotalDeuda == false) {
                    respuesta.setProceso(new Proceso("1202", "Error no cubre el monto de la línea de captura"));
                }

            } else {
                respuesta.setProceso(new Proceso("800", "ERROR : No existe la referencia al documento."));
            }

            log.debug("TErmino consultarReferenciaLCExistente");
        } catch (Exception ex) {
            respuesta.setProceso(new Proceso("700", "ERROR"));
            ex.printStackTrace();
        }

        return respuesta;
    }

    @Override
    public RespuestaAplicarPagoDTO aplicarPagoManual(AplicarPagoDTO aplicarPagoDTO) {
        System.err.println("Tamaño pagos" + aplicarPagoDTO.getPagoPorAplicar().size());
        RespuestaAplicarPagoDTO respuesta = new RespuestaAplicarPagoDTO();
        ManejadorLog log = new ManejadorLog();
        log.debug("Entro aplicarPagoManual");

        DAO<XxfrvConsultaLcFactura> lineasOreferenciasDao = new DAO(XxfrvConsultaLcFactura.class);
        List<XxfrvConsultaLcFactura> lineasReferencias = new ArrayList();

        AplicarPagoDTO aplicaPagoDTO = new AplicarPagoDTO();
        List<PagoPorAplicarDTO> respuestaPagoPA = new ArrayList();
        try {
            for (PagoPorAplicarDTO pagoXAplicar : aplicarPagoDTO.getPagoPorAplicar()) {

                String nombreConsulta;
                List<CatalogoParametroDTO> parametros = new ArrayList<>();

                if (pagoXAplicar.getLineaCaptura() != null && !pagoXAplicar.getLineaCaptura().equals("")) {
                    nombreConsulta = "XxfrvConsultaLcFactura.findByLineacaptura";
                    parametros.add(new CatalogoParametroDTO("lineacaptura", "" + pagoXAplicar.getLineaCaptura(), CONSTANTE.CADENA));
                } else {
                    nombreConsulta = "XxfrvConsultaLcFactura.findByReferencia";
                    parametros.add(new CatalogoParametroDTO("referencenumber", pagoXAplicar.getReferencia(), CONSTANTE.CADENA));
                }
                //Consultamos datos de la linea de captura
                lineasReferencias = (List<XxfrvConsultaLcFactura>) lineasOreferenciasDao.consultaQueryByParameters(nombreConsulta, parametros);
                for (XxfrvConsultaLcFactura consultaFactura : lineasReferencias) {
                    try {
                        XxfrtEstadoCuenta edoCuenta = new XxfrtEstadoCuenta();
                        PagoDTO pago = new PagoDTO();
                        RespuestaEdoCuentaDTO edoCuentaDTO = new RespuestaEdoCuentaDTO();
                        XxfrReciboLineaCaptura reciboLC = new XxfrReciboLineaCaptura();

                        pago.setIdEdoCta(new BigDecimal(pagoXAplicar.getIdEdoCuenta()));
                        pago.setLineaCaptura(pagoXAplicar.getLineaCaptura()== null ? "" : pagoXAplicar.getLineaCaptura().toString());

                        pago.setReferencia(consultaFactura.getReferencenumber());
                        edoCuentaDTO.setIdEdoCuenta(pagoXAplicar.getIdEdoCuenta().intValue());

                        pago.setSiteId(consultaFactura.getSiteId() == null ? null : consultaFactura.getSiteId().toString());
                        pago.setCustomerId(consultaFactura.getCustumerId() == null ? "" : consultaFactura.getCustumerId().toString());
                        pago.setUnidadNegocio(consultaFactura.getOrgId());
                        pago.setBillCustomerName(consultaFactura.getBilltoconsumername());

                        edoCuentaDTO.setOrgID(consultaFactura.getOrgId());
                        edoCuentaDTO.setSiteID(consultaFactura.getSiteId() == null ? null : consultaFactura.getSiteId().toString());
                        edoCuentaDTO.setCustomerID(consultaFactura.getCustumerId() == null ? "" : consultaFactura.getCustumerId().toString());
                        edoCuentaDTO.setBillCustomerName(consultaFactura.getBilltoconsumername());
                        edoCuentaDTO.setReferencia(consultaFactura.getReferencenumber());
                        edoCuentaDTO.setIdLineaCaptura(consultaFactura.getIdlineacaptura() == null ? null : Integer.parseInt(consultaFactura.getIdlineacaptura()));

                        reciboLC.setReferencia(consultaFactura.getReferencenumber());
                        reciboLC.setIdlineacaptura(consultaFactura.getIdlineacaptura() == null ? null : new Long(consultaFactura.getIdlineacaptura()));

                        DAO<XxfrtEstadoCuenta> estadoCuentaDao = new DAO(XxfrtEstadoCuenta.class);
                        List<XxfrtEstadoCuenta> estadosCuenta = new ArrayList<>();
                        List<CatalogoParametroDTO> parametrosEdCta = new ArrayList();
                        parametrosEdCta.add(new CatalogoParametroDTO("idEdoCta", pago.getIdEdoCta().toString(), CONSTANTE.NUMERO));
                        estadosCuenta = estadoCuentaDao.consultaQueryByParameters("XxfrtEstadoCuenta.findByIdEdoCta", parametrosEdCta);
                        for (XxfrtEstadoCuenta estadoCuenta : estadosCuenta) {
                            edoCuenta = estadoCuenta;
                            pago.setIdCabeceraRecibo(estadoCuenta.getLineNumber());
                            pago.setMetodoId(estadoCuenta.getReceiptMethodId());
                            pago.setMoneda(estadoCuenta.getCurrencyCode());
                            pago.setMonto(estadoCuenta.getAmount().toString());

                            edoCuentaDTO.setIdMetodoPago(estadoCuenta.getReceiptMethodId() == null ? null : new Long(estadoCuenta.getReceiptMethodId()));

                            reciboLC.setMontopagado(estadoCuenta.getAmount());

                        }
                        //                    reciboLC.setIdpago(BigDecimal.ZERO);
                        DAO<XxfrReciboLineaCaptura> reciboLCDao = new DAO(XxfrReciboLineaCaptura.class);
                        List<XxfrReciboLineaCaptura> recibo;
                        reciboLCDao.registra(reciboLC);
                        System.out.println(reciboLC.getReferencia());
                        System.out.println(reciboLC.getMontopagado());
                        StringBuilder queryReciboLC = new StringBuilder();
                        queryReciboLC.append("SELECT x FROM XxfrReciboLineaCaptura x WHERE x.referencia = '")
                                .append(reciboLC.getReferencia())
                                .append("' AND x.montopagado = ")
                                .append(reciboLC.getMontopagado())
                                .append(" order by x.idpago DESC");
                        recibo = reciboLCDao.consultaQuery(queryReciboLC.toString());
                        edoCuentaDTO.setIdPago(recibo.get(0).getIdpago().intValue());
                        //                    System.out.println(recibo.get(0).getIdpago());

                        GestorEstadoCuenta gestorEC = new GestorEstadoCuenta();

//                    gestorEC.procesarPago(edoCuenta, pago, edoCuentaDTO);
                        edoCuenta = gestorEC.procesarPago(edoCuenta, pago, edoCuentaDTO);
                        if (edoCuenta.getRmethodid().toString().equals("0")) {
                            edoCuenta.setRmethodid(BigDecimal.ONE);
                        }
                        estadoCuentaDao.actualiza(edoCuenta);
                        pagoXAplicar.setTermino(edoCuenta.getRmethodid().toBigInteger());
                    } catch (Exception e) {
                        e.printStackTrace();
                        pagoXAplicar.setTermino(BigInteger.valueOf(1));
                    }

                    respuestaPagoPA.add(pagoXAplicar);
                    //pagos.add(pago);
                    break;
                }
            }
//            RespuestaProcesaFacturasDTO respuestaPF = generarPago(pagos);
            aplicaPagoDTO.setPagoPorAplicar(respuestaPagoPA);
            if (lineasReferencias.size() > 0) {
                respuesta.setProceso(new Proceso("0", "EXITOSO"));
            }else
                respuesta.setProceso(new Proceso("902", "ERROR"));
            respuesta.setAplicarPago(aplicaPagoDTO);
        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setProceso(new Proceso("901", "ERROR"));
        }
        if (!respuesta.getProceso().getTermino().equals("0")) {
            respuesta.setProceso(new Proceso("901", "ERROR"));
//                respuesta.setDescripcionError("ERROR : Al procesar la aplicación del pago por no existir información a procesar.");
        }
        log.debug("Termino aplicarPagoManual");
        return respuesta;
    }

}
