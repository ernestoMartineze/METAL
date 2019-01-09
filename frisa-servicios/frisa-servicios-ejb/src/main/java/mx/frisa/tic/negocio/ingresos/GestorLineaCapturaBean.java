/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.comun.ProcedimientoAlmacendo;

import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.CargaFacturasSOA;
import mx.frisa.tic.datos.dto.ingresos.DetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.FacturaSOA;
import mx.frisa.tic.datos.dto.ingresos.LCFactDetDTO;

import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCaptutaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineasFacturaSOA;
import mx.frisa.tic.datos.dto.ingresos.PeticionCargaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCargaFacturaDTO;
import mx.frisa.tic.datos.entidades.XxfrCabeceraFactura;
import mx.frisa.tic.datos.entidades.XxfrConsultaLcFacDet;
import mx.frisa.tic.datos.entidades.XxfrInvoiceLines;
import mx.frisa.tic.datos.entidades.XxfrInvoiceLinesPK;
import mx.frisa.tic.datos.entidades.XxfrLineaCaptura;
import mx.frisa.tic.datos.entidades.XxfrtCargaFactura;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLc;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcPagos;
import mx.frisa.tic.datos.validator.ValidationUtils;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.utils.PropiedadesFRISA;
import mx.frisa.tic.utils.ManejadorArchivo;
import mx.frisa.tic.utils.UUIDFrisa;

/**
 *
 * @author martin
 */
@Stateless(name = "GestorLineaCapturaBean")
@LocalBean
public class GestorLineaCapturaBean implements GestorLineaCaptura {


    /**
     *
     * @param lineaCaptura
     * @return
     */
    @Override
    public List<LineaCapturaDTO> consultarLineaCaptura(LineaCapturaDTO lineaCaptura) {

        DAO<XxfrLineaCaptura> lineaCapturaDAO = new DAO(XxfrLineaCaptura.class);
        List<LineaCapturaDTO> lineasCapturaDTO = new ArrayList<LineaCapturaDTO>();
        List<XxfrLineaCaptura> lineasCaptura = lineaCapturaDAO.consultaQueryNamed("XxfrLineaCaptura.findAll");
        for (XxfrLineaCaptura lineaCapturaRespuesta : lineasCaptura) {

            LineaCapturaDTO lineaCapturaDto = new LineaCapturaDTO();
            lineaCapturaDto.setLineaCaptura(lineaCapturaRespuesta.getLineacaptura());
            lineaCapturaDto.setFechaCreacion(String.valueOf(lineaCapturaRespuesta.getFechacreacion()));
            //Agregar los valores necesarios requeridos....
            lineasCapturaDTO.add(lineaCapturaDto);

        }

        return lineasCapturaDTO;
    }

    /**
     *
     * @param pLC
     * @return
     */
    public int ejecutaCuentaFacturas(String pLC) {
        ProcedimientoAlmacendo procedimiento = new ProcedimientoAlmacendo();
        return procedimiento.ejecutaCuentaFacturas(pLC);
    }

    public int ejecutaBatchLC(String idBatch) {
        ProcedimientoAlmacendo procedimiento = new ProcedimientoAlmacendo();
        return procedimiento.ejecutaBatchLC(idBatch);
    }

    public String consultaBatchFinalizado(String idBatch) {
        ProcedimientoAlmacendo procedimiento = new ProcedimientoAlmacendo();
        String respuesta = "EN PROCESO";
        if (procedimiento.consultaBatchFinalizado(idBatch) == 0) {
            respuesta = "TERMINADO";
        }
        return respuesta;
    }

    public List<LineaCaptutaFacturaDTO> consultaLCGeneradas(String idBatch) {
        ProcedimientoAlmacendo procedimiento = new ProcedimientoAlmacendo();
        return procedimiento.consultaLCGeneradas(idBatch);
    }

    /**
     *
     * @param detalleLineaCaptura
     * @return
     */
    @Override
    public List<DetalleLineaCapturaDTO> consultarDetalleLineaCaptura(DetalleLineaCapturaDTO detalleLineaCaptura) {
        DAO<XxfrvConsultaLc> DetalleLineaCapturaDAO = new DAO(XxfrvConsultaLc.class);
        List<DetalleLineaCapturaDTO> detalleLineasCapturaDTO = new ArrayList<DetalleLineaCapturaDTO>();
        List<XxfrvConsultaLc> detalleLineasCaptura;
        if (detalleLineaCaptura == null) {
            detalleLineasCaptura = DetalleLineaCapturaDAO.consultaQueryNamed("XxfrvConsultaLc.findAll");
        } else {
            StringBuilder lcQuery = new StringBuilder("SELECT x FROM XxfrvConsultaLc x ");
            List<CatalogoParametroDTO> parametros = new ArrayList<>();
            String clausula = "WHERE";
            if (detalleLineaCaptura.getLineacaptura() != null && !detalleLineaCaptura.getLineacaptura().equals("")) {
                lcQuery.append(clausula).append(" x.lineacaptura like '%" + detalleLineaCaptura.getLineacaptura() + "%' ");
                clausula = "AND";
            }
            if (detalleLineaCaptura.getReferencia() != null && !detalleLineaCaptura.getReferencia().equals("")) {
                lcQuery.append(clausula).append(" x.referencia like '%" + detalleLineaCaptura.getReferencia() + "%' ");
                clausula = "AND";
            }
            if (detalleLineaCaptura.getBanco() != null && !detalleLineaCaptura.getBanco().equals("")) {
                lcQuery.append(clausula).append(" x.banco like '%" + detalleLineaCaptura.getBanco() + "%' ");
                clausula = "AND";
            }
            if (detalleLineaCaptura.getEntidadlegal() != null && !detalleLineaCaptura.getEntidadlegal().equals("")) {
                lcQuery.append(clausula).append(" x.entidadlegal like '%" + detalleLineaCaptura.getEntidadlegal() + "%' ");
                clausula = "AND";
            }
            if (detalleLineaCaptura.getUnidadnegocio() != null && !detalleLineaCaptura.getUnidadnegocio().equals("")) {
                lcQuery.append(clausula).append(" x.unidadnegocio like '%" + detalleLineaCaptura.getUnidadnegocio() + "%' ");
                clausula = "AND";
            }
            detalleLineasCaptura = DetalleLineaCapturaDAO.consultaQueryNativo(lcQuery.toString());
//            parametros.add(new CatalogoParametroDTO(":lc",detalleLineaCaptura.getLineacaptura(),"CADENA | NUMERO"));

        }

        for (XxfrvConsultaLc detalleLineaCapturaRespuesta : detalleLineasCaptura) {
            DetalleLineaCapturaDTO lineaCapturaDetalleDto = new DetalleLineaCapturaDTO();
            lineaCapturaDetalleDto.setBanco(detalleLineaCapturaRespuesta.getBanco());
            lineaCapturaDetalleDto.setCapitalrentacondonada(detalleLineaCapturaRespuesta.getCapitalrentacondonada());
            lineaCapturaDetalleDto.setCentrocostosproyecto(detalleLineaCapturaRespuesta.getCentrocostosproyecto());
            lineaCapturaDetalleDto.setCuentabancaria(detalleLineaCapturaRespuesta.getCuentabancaria());
            lineaCapturaDetalleDto.setDivision(detalleLineaCapturaRespuesta.getDivision());
            lineaCapturaDetalleDto.setEntidadlegal(detalleLineaCapturaRespuesta.getEntidadlegal());
            lineaCapturaDetalleDto.setFechacreacion(detalleLineaCapturaRespuesta.getFechacreacion());
            lineaCapturaDetalleDto.setFechavigencia(detalleLineaCapturaRespuesta.getFechavigencia());
            lineaCapturaDetalleDto.setFolioacuerdocobranza(detalleLineaCapturaRespuesta.getFolioacuerdocobranza());
            lineaCapturaDetalleDto.setIdlineacaptura(detalleLineaCapturaRespuesta.getIdlineacaptura());
            lineaCapturaDetalleDto.setInteresmoratoriocondonado(detalleLineaCapturaRespuesta.getInteresmoratoriocondonado());
            lineaCapturaDetalleDto.setLineacaptura(detalleLineaCapturaRespuesta.getLineacaptura());
            lineaCapturaDetalleDto.setLineacapturaref(detalleLineaCapturaRespuesta.getLineacapturaref());
            lineaCapturaDetalleDto.setMontoacuerdocobranza(detalleLineaCapturaRespuesta.getMontoacuerdocobranza());
            lineaCapturaDetalleDto.setMontolineacaptura(detalleLineaCapturaRespuesta.getMontolineacaptura());
            lineaCapturaDetalleDto.setNumerorecibo(detalleLineaCapturaRespuesta.getNumerorecibo());
            lineaCapturaDetalleDto.setOrdinariocondonado(detalleLineaCapturaRespuesta.getOrdinariocondonado());
            lineaCapturaDetalleDto.setReferencia(detalleLineaCapturaRespuesta.getReferencia());
            lineaCapturaDetalleDto.setSistemaorigen(detalleLineaCapturaRespuesta.getSistemaorigen());
            lineaCapturaDetalleDto.setTipocobranza(detalleLineaCapturaRespuesta.getTipocobranza());
            lineaCapturaDetalleDto.setUnidadnegocio(detalleLineaCapturaRespuesta.getUnidadnegocio());
            lineaCapturaDetalleDto.setEstatuslc(detalleLineaCapturaRespuesta.getEstatuslc());
            //Agregar los valores necesarios requeridos....
            detalleLineasCapturaDTO.add(lineaCapturaDetalleDto);
        }
        return detalleLineasCapturaDTO;
    }

    /**
     *
     * @param detalleLCPagos
     * @return
     */
    public List<DetalleLCPagosDTO> consultarLCPagos(DetalleLCPagosDTO detalleLCPagos) {
        DAO<XxfrvConsultaLcPagos> lcPagosDAO = new DAO(XxfrvConsultaLcPagos.class);
        List<DetalleLCPagosDTO> lcPagosDTO = new ArrayList<>();
        List<XxfrvConsultaLcPagos> lcPagos = lcPagosDAO.consultaQueryNamed("XxfrvConsultaLcPagos.findAll");
        for (XxfrvConsultaLcPagos lcPagosRespuesta : lcPagos) {
            DetalleLCPagosDTO lcPagosDto = new DetalleLCPagosDTO();
            lcPagosDto.setFechaaplicacion(lcPagosRespuesta.getFechaaplicacion());
            lcPagosDto.setFecharecibo(lcPagosRespuesta.getFecharecibo());
            lcPagosDto.setFechatransaccion(lcPagosRespuesta.getFechatransaccion());
            lcPagosDto.setIdlineacaptura(lcPagosRespuesta.getIdlineacaptura());
            lcPagosDto.setIdpago(lcPagosRespuesta.getIdpago());
            lcPagosDto.setMontopagado(lcPagosRespuesta.getMontopagado());
            lcPagosDto.setNorecibo(lcPagosRespuesta.getNorecibo());
            //Agregar los valores necesarios requeridos....
            lcPagosDTO.add(lcPagosDto);
        }
        return lcPagosDTO;
    }

    /**
     *
     * @param lineaCaptura
     * @return
     */
    @Override
    public List<DetalleLCPagosDTO> consultarLCPagos(String facturaERP) {
        DAO<XxfrvConsultaLcPagos> lcPagosDAO = new DAO(XxfrvConsultaLcPagos.class);
        List<DetalleLCPagosDTO> lcPagosDTO = new ArrayList<>();
        List<CatalogoParametroDTO> parametros = new ArrayList<>();
        parametros.add(new CatalogoParametroDTO("idfacturaerp", facturaERP, CONSTANTE.NUMERO));
        List<XxfrvConsultaLcPagos> lcPagos = lcPagosDAO.consultaQueryByParameters("XxfrvConsultaLcPagos.findByIdfacturaerp", parametros);
        for (XxfrvConsultaLcPagos lcPagosRespuesta : lcPagos) {
            DetalleLCPagosDTO lcPagosDto = new DetalleLCPagosDTO();
            lcPagosDto.setFechaaplicacion(lcPagosRespuesta.getFechaaplicacion());
            lcPagosDto.setFecharecibo(lcPagosRespuesta.getFecharecibo());
            lcPagosDto.setFechatransaccion(lcPagosRespuesta.getFechatransaccion());
            lcPagosDto.setIdlineacaptura(lcPagosRespuesta.getIdlineacaptura());
            lcPagosDto.setIdpago(lcPagosRespuesta.getIdpago());
            lcPagosDto.setIdfacturaerp(lcPagosRespuesta.getIdfacturaerp());
            lcPagosDto.setMontopagado(lcPagosRespuesta.getMontopagado());
            lcPagosDto.setNorecibo(lcPagosRespuesta.getNorecibo());
            //Agregar los valores necesarios requeridos....
            lcPagosDTO.add(lcPagosDto);
        }
        return lcPagosDTO;
    }

    /**
     *
     * @param lineaCaptura
     * @return
     */
    @Override
    public List<LCFactDetDTO> consultarLCFactDet(LCFactDetDTO lcFactDetalle) {
        DAO<XxfrConsultaLcFacDet> LcFacDetDAO = new DAO(XxfrConsultaLcFacDet.class);
        List<LCFactDetDTO> lcFactsDetDTO = new ArrayList<>();
        List<XxfrConsultaLcFacDet> detallesLCFactDet = new ArrayList<>();
        if (lcFactDetalle != null) {
            StringBuilder lcQuery = new StringBuilder("SELECT x FROM XxfrConsultaLcFacDet x ");
            String clausula = "WHERE";
            if (lcFactDetalle.getBilltoconsumername() != null && !lcFactDetalle.getBilltoconsumername().equals("")) {
                lcQuery.append(clausula).append(" x.billtoconsumername like '%").append(lcFactDetalle.getBilltoconsumername()).append("%' ");
                clausula = "AND";
            }
            if (lcFactDetalle.getCompanyaccountcode() != null && !lcFactDetalle.getCompanyaccountcode().equals("")) {
                lcQuery.append(clausula).append(" x.companyaccountcode like '%").append(lcFactDetalle.getCompanyaccountcode()).append("%' ");
                clausula = "AND";
            }
            if (lcFactDetalle.getProjectid() != null && !lcFactDetalle.getProjectid().equals("")) {
                lcQuery.append(clausula).append(" x.projectid like '%").append(lcFactDetalle.getProjectid()).append("%' ");
                clausula = "AND";
            }
            if (lcFactDetalle.getEntidadlegal() != null && !lcFactDetalle.getEntidadlegal().equals("")) {
                lcQuery.append(clausula).append(" x.entidadlegal like '%").append(lcFactDetalle.getEntidadlegal()).append("%' ");
                clausula = "AND";
            }
            if (lcFactDetalle.getBusinessunitname() != null && !lcFactDetalle.getBusinessunitname().equals("")) {
                lcQuery.append(clausula).append(" x.businessunitname like '%").append(lcFactDetalle.getBusinessunitname()).append("%' ");
            }
            detallesLCFactDet = LcFacDetDAO.consultaQueryNativo(lcQuery.toString());
//            parametros.add(new CatalogoParametroDTO(":lc",detalleLineaCaptura.getLineacaptura(),"CADENA | NUMERO"));
        }

        for (XxfrConsultaLcFacDet detalleLcFac : detallesLCFactDet) {
            LCFactDetDTO lcFactDetDTO = new LCFactDetDTO();
            lcFactDetDTO.setBilltoconsumername(detalleLcFac.getBilltoconsumername());
            lcFactDetDTO.setBusinessunitname(detalleLcFac.getBusinessunitname());
            lcFactDetDTO.setCompanyaccountcode(detalleLcFac.getCompanyaccountcode());
            lcFactDetDTO.setEntidadlegal(detalleLcFac.getEntidadlegal());
            lcFactDetDTO.setFechavigencia(detalleLcFac.getFechavigencia());
            lcFactDetDTO.setIdfacturaprimavera(detalleLcFac.getIdfacturaprimavera());
            lcFactDetDTO.setImpuestos(detalleLcFac.getImpuestos());
            lcFactDetDTO.setLineacaptura(detalleLcFac.getLineacaptura());
            lcFactDetDTO.setMontoFactura(detalleLcFac.getMontoFactura());
            lcFactDetDTO.setMontoLineacaptura(detalleLcFac.getMontoLineacaptura());
            lcFactDetDTO.setMontoPagado(detalleLcFac.getMontoPagado());
            lcFactDetDTO.setPaymenttermdate(detalleLcFac.getPaymenttermdate());
            lcFactDetDTO.setProjectid(detalleLcFac.getProjectid());
            lcFactDetDTO.setRelatederpinvoice(detalleLcFac.getRelatederpinvoice());
            //Agregar los valores necesarios requeridos....
            lcFactsDetDTO.add(lcFactDetDTO);
        }

        return lcFactsDetDTO;
    }

    @Override
    public RespuestaCargaFacturaDTO cargarFacturas(PeticionCargaFacturaDTO peticion) {
        RespuestaCargaFacturaDTO respuesta = new RespuestaCargaFacturaDTO();

        try {

            XxfrtCargaFactura cargaArchivo = new XxfrtCargaFactura();
            cargaArchivo.setEstatus("R"); //Registrada
            cargaArchivo.setFechaRegistro(new Date()); //Registrada
            cargaArchivo.setIdBatch(BigInteger.valueOf(Long.valueOf(peticion.getIdBatch())));
            cargaArchivo.setDatosrecibidos(peticion.getFacturas());
            cargaArchivo.setUuid(UUIDFrisa.regresaUUID());

            List<Object> respuestaLanza = lanzarCargaFacturas(peticion.getFacturas(), cargaArchivo.getUuid());
            String dtosJSON = (String) respuestaLanza.get(0);
            String nombreArchivo = (String) respuestaLanza.get(1);

            cargaArchivo.setDatosjson(dtosJSON);
            DAO<XxfrtCargaFactura> cargaFacturaDao = new DAO(XxfrtCargaFactura.class);
            cargaFacturaDao.registra(cargaArchivo);
            respuesta.setUuid(cargaArchivo.getUuid());

            dtosJSON = procesarJSONcomoFactura (dtosJSON, nombreArchivo);

            if (!dtosJSON.equals("")) {
                respuesta.setProceso(new Proceso("0", "EXITOSO"));

            } else {
                respuesta.setProceso(new Proceso("1", "ERROR"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta.setProceso(new Proceso("ERROR", ex.getMessage()));
        }

        return respuesta;
    }

    private List<Object> lanzarCargaFacturas(String datosFactura, String uuid) throws IOException {

        String pathZip = PropiedadesFRISA.recuperaPropiedadBackend("pathFileSysteZIP");
        String dirArchivoZip = pathZip + uuid;
        String nombreArchivoZip = pathZip + uuid + "/" + uuid + ".zip";

        List<Object> respuesta = ManejadorArchivo.procesarArchivoZip(dirArchivoZip, nombreArchivoZip, datosFactura);
        return respuesta;
    }

    private String procesarJSONcomoFactura(String dtosJSON, String datosJsonPathArchivo) throws ProcessingException, IOException {
        String respuesta = "";
        //REcuperar B64 del esquema de validacion
        String esquemaValidaFacturaPath = PropiedadesFRISA.recuperaPropiedadBackend("esquemaValidaFacturaPath");

        System.err.println("Archivo Esquema JS :" + esquemaValidaFacturaPath);
        System.err.println("Archivo Json Datos :" + datosJsonPathArchivo);

//        File esquema = new File (esquemaValidaFacturaPath);
//        File datosJsonArchivo = new File (datosJsonPathArchivo);

        //Validar datos en la factura
//        if (ValidationUtils.isJsonValid(esquema, datosJsonArchivo)) {
        if (true) {

            //Procesar facturas
            AdaptadorWS adaptadorWS = new AdaptadorWS();
            CargaFacturasSOA facturasIn = new CargaFacturasSOA();

            facturasIn = (CargaFacturasSOA) adaptadorWS.respuestaJSONA_Dto(dtosJSON, facturasIn);
            DAO<XxfrCabeceraFactura> cabeceraFacturaDao = new DAO(XxfrCabeceraFactura.class);
            for (FacturaSOA factura : facturasIn.getFacturas()) {
                XxfrCabeceraFactura facturaEntidad = new XxfrCabeceraFactura();
                facturaEntidad.setIdfacturaprimavera(BigDecimal.valueOf(factura.getIdfacturaprimavera()));
                facturaEntidad.setBankaccountnumber(factura.getBankaccountnumber());
                facturaEntidad.setBankname(factura.getBankname());
                facturaEntidad.setBilltoconsumername(factura.getBilltoconsumername());
                facturaEntidad.setBilltolocation(factura.getBilltolocation());
                facturaEntidad.setBusinessunitname(factura.getBusinessunitname());
                facturaEntidad.setCompanyaccountcode(factura.getCompanyaccountcode());
                facturaEntidad.setContextrentas(factura.getContextrentas());
                facturaEntidad.setContractnumber(factura.getContractnumber());
//                facturaEntidad.setConversionratetype(factura.get());
//                facturaEntidad.setConversionratevalue(factura.get());
//                facturaEntidad.setCreationdategl(factura.getCreationdategl());
//                facturaEntidad.setCreationdatetrx(factura.getCreationdatetrx());
                facturaEntidad.setCreationdategl(new Date());
                facturaEntidad.setCreationdatetrx(new Date());
                facturaEntidad.setCurrency(factura.getCurrency());
                facturaEntidad.setCustomerid(BigInteger.valueOf(factura.getCustomerid()));
                facturaEntidad.setDffheadercontext(factura.getDffheadercontext());
                facturaEntidad.setDivisiontype(factura.getDivisiontype());
                facturaEntidad.setAddendum(factura.getAddendum());
                facturaEntidad.setEstadoprocesamiento("REGISTRADA");
                facturaEntidad.setFacilitynumber(factura.getFacilitynumber());
//                facturaEntidad.setFolioavisocargo(factura.get());
                facturaEntidad.setGenerationtype(factura.getGenerationtype());
                facturaEntidad.setGraceperiod(Short.valueOf(""+factura.getGraceperiod()));
                facturaEntidad.setGrouptype(factura.getGrouptype());
                facturaEntidad.setIdbatch(factura.getIdbatch());
//                facturaEntidad.setLandtaxaccount(factura.get());
//                facturaEntidad.setLegalinvoiceuse(factura.get());
                facturaEntidad.setLocalnumber(factura.getLocalnumber());
                facturaEntidad.setOrgid(factura.getOrgid());
                facturaEntidad.setProjectid(Long.valueOf(factura.getProjectid()));
                facturaEntidad.setReferencenumber(factura.getReferencenumber());
//                facturaEntidad.setRelatederpinvoice(factura.get());
                facturaEntidad.setSiteid(BigInteger.valueOf(factura.getSiteid()));
                facturaEntidad.setTipocobranza(factura.getTipocobranza());
                facturaEntidad.setTotalamount(BigDecimal.valueOf(factura.getTotalamount()));
                facturaEntidad.setTransactionid(factura.getTransactionid());
                facturaEntidad.setTransactionsource(factura.getTransactionsource());
                facturaEntidad.setTransactiontype(factura.getTransactiontype());
                facturaEntidad.setBatchsourcename(factura.getBATCHSOURCENAME());
                List<XxfrInvoiceLines> xxfrInvoiceLinesList = new ArrayList<>();
                for ( LineasFacturaSOA lineasFacturaSOA : factura.getLineas()) {
                    XxfrInvoiceLines lineaFactura = new XxfrInvoiceLines();
                    XxfrInvoiceLinesPK xxfrInvoiceLinesPK = new XxfrInvoiceLinesPK ();
                    xxfrInvoiceLinesPK.setIdfacturaprimavera(BigInteger.valueOf(factura.getIdfacturaprimavera()));
                    xxfrInvoiceLinesPK.setLinenumber(Short.valueOf(lineasFacturaSOA.getLinenumber()+""));
                    lineaFactura.setXxfrInvoiceLinesPK(xxfrInvoiceLinesPK);
                    lineaFactura.setIdconcepto(lineasFacturaSOA.getIdconcepto());
                    lineaFactura.setMemolinename(lineasFacturaSOA.getMemolinename());
                    lineaFactura.setClasificadordescuento(lineasFacturaSOA.getClasificadordescuento());
                    lineaFactura.setTaxclassificationcode(lineasFacturaSOA.getTaxclassificationcode());
                    lineaFactura.setQuantity(Integer.valueOf(lineasFacturaSOA.getQuantity()+""));
                    lineaFactura.setTaxrate(BigInteger.valueOf(lineasFacturaSOA.getTaxrate()));
                    lineaFactura.setMontobrutolinea(BigDecimal.valueOf(lineasFacturaSOA.getMontobrutolinea()));
                    lineaFactura.setMontonetolinea(BigDecimal.valueOf(lineasFacturaSOA.getMontonetolinea()));
//                    lineaFactura.setFechadesde(String.lineasFacturaSOA.getFechadesde());
//                    lineaFactura.setFechaexigibilidad(lineasFacturaSOA.getFechaexigibilidad());
//                    lineaFactura.setFechahasta(lineasFacturaSOA.getFechahasta());
                    lineaFactura.setFechadesde(new Date()); //CORREGIR DE FUENTE
                    lineaFactura.setFechaexigibilidad(new Date()); //CORREGIR DE FUENTE
                    lineaFactura.setFechahasta(new Date()); //CORREGIR DE FUENTE
                    lineaFactura.setDescriptionOrigen(lineasFacturaSOA.getDescription_origen());
                    lineaFactura.setDescriptionmanual(lineasFacturaSOA.getDescriptionmanual());
                    lineaFactura.setDescadicional1(lineasFacturaSOA.getDescadicional1());
                    lineaFactura.setDescadicional2(lineasFacturaSOA.getDescadicional2());
                    lineaFactura.setDescadicional3(lineasFacturaSOA.getDescadicional3());
                    lineaFactura.setDescadicional4(lineasFacturaSOA.getDescadicional4());
                    lineaFactura.setDescadicional5(lineasFacturaSOA.getDescadicional5());


                    lineaFactura.setLinetype(lineasFacturaSOA.getLinetype());
                    lineaFactura.setFlexContext(lineasFacturaSOA.getFlexContext());
                    lineaFactura.setFlexContextDisplayvalue(lineasFacturaSOA.getFlexContextDisplayvalue());
                    lineaFactura.setFlexNumofsegments(lineasFacturaSOA.getFlexNumofsegments());
                    lineaFactura.setMontoivalinea(lineasFacturaSOA.getMontoivalinea());
                    lineaFactura.setTaxclassificationcode(lineasFacturaSOA.getTaxclassificationcode());
                    lineaFactura.setMontobrutolinearetiva(lineasFacturaSOA.getMontobrutolinearetiva());
                    lineaFactura.setTaxclassificationcodeisr(lineasFacturaSOA.getTaxclassificationcodeisr());
                    lineaFactura.setMontobrutolineaisr(lineasFacturaSOA.getMontobrutolineaisr());


                    xxfrInvoiceLinesList.add(lineaFactura);
                }
                facturaEntidad.setXxfrInvoiceLinesList(xxfrInvoiceLinesList);
                cabeceraFacturaDao.registra(facturaEntidad);
            }
            //Si todo termina con bien mandamos los datos JSON intactos de regreso
            respuesta = dtosJSON;
        }


    public RespuestaDTO actualizarIdERP(BigDecimal IdPrimavera, String IdErp) {

        RespuestaDTO respuesta = new RespuestaDTO();
        DAO<XxfrCabeceraFactura> lcidprimDAO = new DAO(XxfrCabeceraFactura.class);

        List<XxfrCabeceraFactura> lcidprim = new ArrayList<>();
        try {

            if (IdPrimavera != null) {
                List<CatalogoParametroDTO> parametros = new ArrayList<>();
                parametros.add(new CatalogoParametroDTO("idfacturaprimavera", IdPrimavera + "", "NUMERO"));
                lcidprim = lcidprimDAO.consultaQueryByParameters("XxfrCabeceraFactura.findByIdfacturaprimavera", parametros);

                for (XxfrCabeceraFactura lcidRespuesta : lcidprim) {

                    lcidRespuesta.setRelatederpinvoice(IdErp);
                    lcidprimDAO.actualiza(lcidRespuesta);
                }
                respuesta.setProceso("EXITOSO");
                respuesta.setIdError("0");
            } else {
                respuesta.setProceso("Error");
                respuesta.setIdError("600");
            }

        } catch (Exception ex) {
            respuesta.setProceso("ERROR");
            respuesta.setDescripcionError(ex.getMessage());
            respuesta.setIdError("600");
        }

        return respuesta;
    }
}
