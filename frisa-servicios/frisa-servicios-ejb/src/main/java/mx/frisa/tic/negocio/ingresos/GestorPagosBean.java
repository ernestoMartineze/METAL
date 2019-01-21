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
import mx.frisa.tic.datos.dto.ingresos.RespuestaPagoSinReferencia;
import mx.frisa.tic.datos.dto.ingresos.RespuestaProcesaFacturasDTO;
import mx.frisa.tic.datos.entidades.XxfrtEstadoCuenta;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcFactura;
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
                    .append("WHERE x.lineacaptura in (")
                    .append("'" + pago.getLineaCaptura() + "'")
                    .append(")");
        } else {
            query.append("SELECT x ")
                    .append(" FROM XxfrvFactparapagos x ")
                    .append("WHERE x.REFERENCENUMBER in (")
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
                facturas.add(factura);
                log.debug("Tipo de factura : " + factura.getGenerationtype().equals("INVOICE_TO_COLLECTION"));
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
        DAO<XxfrtEstadoCuenta> lineasEstadoCuentaDAO = new DAO(XxfrtEstadoCuenta.class);
        List<XxfrtEstadoCuenta> lineasEdoCtaEntidad = new ArrayList();
        String queryArmado = "SELECT x FROM XxfrtEstadoCuenta x WHERE ";

        try {

            //Para saber si necesitamos eliminar de la consulta a los PAGOS APLICADOS
            if (filtros.getMostrarAplicar().equals("NO")) {
                queryArmado += " x.rmethodid = 0 ";

            } else { // De lo contrario, se muestran los Manuales POR APLICAR, y LOS APLICADOS que cumplan el criterio
                queryArmado += " x.rmethodid in (0,1) ";
            }

            if (!filtros.getCuentaBancaria().equals("")) {
                queryArmado += " and x.bankAccountNum =".concat(filtros.getCuentaBancaria());

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
            lineasEdoCtaEntidad = (List<XxfrtEstadoCuenta>) lineasEstadoCuentaDAO.consultaQueryNativo(queryArmado);
            List<LineaEstadoCuentaDTO> lineas = new ArrayList();
            for (XxfrtEstadoCuenta lineasEdoCuentaEnt : lineasEdoCtaEntidad) {
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
                for (XxfrvConsultaLcFactura lineasReferenRecuperada : lineasReferencias) {
                    respuesta.setCliente(lineasReferenRecuperada.getBilltoconsumername());
                    respuesta.setProyectoID(BigDecimal.valueOf(lineasReferenRecuperada.getProjectid()));
                    //CONSULTAR POR 
                    respuesta.setEstadoCobro("Por Aplicar");
                    respuesta.setEstadoConciliacion("Conciliado");
                    respuesta.setIdPago(BigDecimal.ONE);
                    respuesta.setMontoPendienteDeAplicar(BigDecimal.TEN);
                    respuesta.setNombrePago("1345");
                    respuesta.setUnidadNegocio("LMF MUNDO E - RENTAS");
                    break;
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

        RespuestaAplicarPagoDTO respuesta = new RespuestaAplicarPagoDTO();
        ManejadorLog log = new ManejadorLog();
        log.debug("Entro aplicarPagoManual");
        try {
            List<PagoPorAplicarDTO> pagoPorAplicar = aplicarPagoDTO.getPagoPorAplicar();
            AplicarPagoDTO plicarPagoDTO = new AplicarPagoDTO();
            plicarPagoDTO.setPagoPorAplicar(pagoPorAplicar);
            respuesta.setAplicarPago(plicarPagoDTO);
            for (PagoPorAplicarDTO pagoXAplicar : aplicarPagoDTO.getPagoPorAplicar()) {
                respuesta.setProceso(new Proceso("0", "EXITOSO"));
                int contador = 0;
                respuesta.getAplicarPago().getPagoPorAplicar().get(contador).setTermino(BigInteger.ZERO);
                if (contador == 1) {
                    respuesta.getAplicarPago().getPagoPorAplicar().get(contador).setTermino(BigInteger.ONE);
                }
                contador++;

                //break;
            }
            if (!respuesta.getProceso().getTermino().equals("0")) {
                respuesta.setProceso(new Proceso("901", "ERROR"));
//                respuesta.setDescripcionError("ERROR : Al procesar la aplicación del pago por no existir información a procesar.");
            }

        } catch (Exception ex) {
            respuesta.setProceso(new Proceso("900", "ERROR"));
//            respuesta.setDescripcionError("ERROR : No es posible procesar la petición de aplicación de pago " + ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        log.debug("Termino aplicarPagoManual");
        return respuesta;
    }

}
