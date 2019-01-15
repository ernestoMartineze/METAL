/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.comun.ProcedimientoAlmacendo;

import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.FacturaActualizaIdERPDTO;
import mx.frisa.tic.datos.dto.ingresos.LCFactDetDTO;

import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCaptutaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.PeticionCargaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCargaFacturaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.lineaActualizaIdERPDTO;
import mx.frisa.tic.datos.entidades.XxfrConsultaLcFacDet;
import mx.frisa.tic.datos.entidades.XxfrLineaCaptura;
import mx.frisa.tic.datos.entidades.XxfrtCargaFactura;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLc;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcPagos;
import mx.frisa.tic.datos.entidades.XxfrCabeceraFactura;
import mx.frisa.tic.datos.entidades.XxfrInvoiceLines;
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

            String dtosJSON = lanzarCargaFacturas(peticion.getFacturas(), cargaArchivo.getUuid());
            String restaAlProcesarJSON = procesarJSONcomoFactura(dtosJSON);

            cargaArchivo.setDatosjson(dtosJSON);
            DAO<XxfrtCargaFactura> cargaFacturaDao = new DAO(XxfrtCargaFactura.class);
            cargaFacturaDao.registra(cargaArchivo);
            respuesta.setUuid(cargaArchivo.getUuid());

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

    private String lanzarCargaFacturas(String datosFactura, String uuid) throws IOException {

        String pathZip = PropiedadesFRISA.recuperaPropiedadBackend("pathFileSysteZIP");
        String dirArchivoZip = pathZip + uuid;
        String nombreArchivoZip = pathZip + uuid + "/" + uuid + ".zip";

        String facturasJson = ManejadorArchivo.procesarArchivoZip(dirArchivoZip, nombreArchivoZip, datosFactura);
        return facturasJson;
    }

    private String procesarJSONcomoFactura(String dtosJSON) {
        String respuesta = "";

        return respuesta;
    }

    //public RespuestaDTO actualizarIdERP(BigDecimal IdPrimavera, String IdErp) {
    public RespuestaDTO actualizarIdERP(List<FacturaActualizaIdERPDTO> facturas){
        RespuestaDTO respuesta = new RespuestaDTO();
        DAO<XxfrCabeceraFactura> lcidprimDAO = new DAO(XxfrCabeceraFactura.class);
        DAO<XxfrInvoiceLines> lineasFacturaDAO = new DAO(XxfrInvoiceLines.class);
        List<XxfrCabeceraFactura> listaFacturas = new ArrayList<>();
        List<XxfrInvoiceLines> lineasFactura = new ArrayList<>(); 
        
        for(FacturaActualizaIdERPDTO facturaReq : facturas){
            try {
                if (facturaReq.getCabecera().getIdfacturaprimavera() != null) {
                    List<CatalogoParametroDTO> parametrosC = new ArrayList<>();
                    parametrosC.add(new CatalogoParametroDTO("idfacturaprimavera", facturaReq.getCabecera().getIdfacturaprimavera() + "", "NUMERO"));
                    listaFacturas = lcidprimDAO.consultaQueryByParameters("XxfrCabeceraFactura.findByIdfacturaprimavera2", parametrosC);
                    Boolean responseOperation = false;
                    XxfrCabeceraFactura cabeceraBD = listaFacturas.get(0);
                        for (lineaActualizaIdERPDTO lineaReq : facturaReq.getLineas().getLinea()) {
                            List<XxfrInvoiceLines> listaTMP = new ArrayList<>();
                            for(XxfrInvoiceLines lineaFacturaBD : cabeceraBD.getXxfrInvoiceLinesList()){
                                if(lineaReq.getLinenumber() == lineaFacturaBD.getXxfrInvoiceLinesPK().getLinenumber()){
                                    lineaFacturaBD.setTaxivalinea(lineaReq.getTaxivalinea());
                                    lineaFacturaBD.setMontoivalinea(lineaReq.getMontoivalinea());
                                    lineaFacturaBD.setTaxclassificationcoderetiva(lineaReq.getTaxclassificationcoderetiva());
                                    lineaFacturaBD.setMontobrutolinearetiva(lineaReq.getMontobrutolinearetiva());
                                    lineaFacturaBD.setTaxclassificationcodeisr(lineaReq.getTaxclassificationcodeisr());
                                    lineaFacturaBD.setMontobrutolineaisr(lineaReq.getMontobrutolineaisr());
                                }
                                listaTMP.add(lineaFacturaBD);
                            }
                            cabeceraBD.getXxfrInvoiceLinesList().clear();
                            cabeceraBD.getXxfrInvoiceLinesList().addAll(listaTMP);
                        }
                        cabeceraBD.setRelatederpinvoice(facturaReq.getCabecera().getRelatederpinvoice());
                        cabeceraBD.setCodigoerror(facturaReq.getCabecera().getCodigoerror());
                        cabeceraBD.setMensajeerror(facturaReq.getCabecera().getMensajeerror());
                        cabeceraBD.setErptransactionnumber(facturaReq.getCabecera().getErptransactionnumber());
                        responseOperation = lcidprimDAO.actualiza(cabeceraBD);
                    if(responseOperation){
                        respuesta.setProceso("EXITOSO");
                        respuesta.setIdError("0");
                    }
                    else{
                        respuesta.setProceso("ERROR - No se pudo guardar la información");
                        respuesta.setIdError("600");
                    }
                } else {
                    respuesta.setProceso("ERROR - Debe ingresar el ID Factura Primavera");
                    respuesta.setIdError("600");
                }
            } catch (Exception ex) {
                respuesta.setProceso("ERROR - Validar los datos de la petición");
                respuesta.setIdError("600");
                ex.printStackTrace();
            }
            
        }

        return respuesta;
    }
}
