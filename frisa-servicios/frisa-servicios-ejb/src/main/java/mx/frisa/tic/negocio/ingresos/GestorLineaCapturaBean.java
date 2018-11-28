/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.comun.ProcedimientoAlmacendo;

import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LCFactDetDTO;

import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCaptutaFacturaDTO;
import mx.frisa.tic.datos.entidades.XxfrConsultaLcFacDet;
import mx.frisa.tic.datos.entidades.XxfrLineaCaptura;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLc;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcPagos;

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
        if(procedimiento.consultaBatchFinalizado(idBatch) == 0){
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
        if(detalleLineaCaptura==null){
            detalleLineasCaptura = DetalleLineaCapturaDAO.consultaQueryNamed("XxfrvConsultaLc.findAll");
        }else{
            StringBuilder lcQuery=new StringBuilder("SELECT x FROM XxfrvConsultaLc x ");
            List<CatalogoParametroDTO> parametros=new ArrayList<>();
            String clausula="WHERE";
            if(detalleLineaCaptura.getLineacaptura() != null && !detalleLineaCaptura.getLineacaptura().equals("")){
                lcQuery.append(clausula).append(" x.lineacaptura like '%"+detalleLineaCaptura.getLineacaptura()+"%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getReferencia() != null && !detalleLineaCaptura.getReferencia().equals("")){
                lcQuery.append(clausula).append(" x.referencia like '%"+detalleLineaCaptura.getReferencia()+"%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getBanco() != null && !detalleLineaCaptura.getBanco().equals("")){
                lcQuery.append(clausula).append(" x.banco like '%"+detalleLineaCaptura.getBanco()+"%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getEntidadlegal()!= null && !detalleLineaCaptura.getEntidadlegal().equals("")){
                lcQuery.append(clausula).append(" x.entidadlegal like '%"+detalleLineaCaptura.getEntidadlegal()+"%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getUnidadnegocio() != null && !detalleLineaCaptura.getUnidadnegocio().equals("")){
                lcQuery.append(clausula).append(" x.unidadnegocio like '%"+detalleLineaCaptura.getUnidadnegocio()+"%' ");
                clausula="AND";
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
    @Override
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
     * @param detalleLineaCaptura
     * @return
     */
    @Override
    public List<DetalleLineaCapturaDTO> consultarDetalleLineaCaptura(DetalleLineaCapturaDTO detalleLineaCaptura) {
        DAO<XxfrvConsultaLc> DetalleLineaCapturaDAO = new DAO(XxfrvConsultaLc.class);
        List<DetalleLineaCapturaDTO> detalleLineasCapturaDTO = new ArrayList<DetalleLineaCapturaDTO>();
        List<XxfrvConsultaLc> detalleLineasCaptura;
        if(detalleLineaCaptura==null){
            detalleLineasCaptura = DetalleLineaCapturaDAO.consultaQueryNamed("XxfrvConsultaLc.findAll");
        }else{
            StringBuilder lcQuery=new StringBuilder("SELECT x FROM XxfrvConsultaLc x ");
            String clausula="WHERE";
            if(detalleLineaCaptura.getLineacaptura() != null && !detalleLineaCaptura.getLineacaptura().equals("")){
                lcQuery.append(clausula).append(" x.lineacaptura like '%").append(detalleLineaCaptura.getLineacaptura()).append("%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getReferencia() != null && !detalleLineaCaptura.getReferencia().equals("")){
                lcQuery.append(clausula).append(" x.referencia like '%").append(detalleLineaCaptura.getReferencia()).append("%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getBanco() != null && !detalleLineaCaptura.getBanco().equals("")){
                lcQuery.append(clausula).append(" x.banco like '%").append(detalleLineaCaptura.getBanco()).append("%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getEntidadlegal()!= null && !detalleLineaCaptura.getEntidadlegal().equals("")){
                lcQuery.append(clausula).append(" x.entidadlegal like '%").append(detalleLineaCaptura.getEntidadlegal()).append("%' ");
                clausula="AND";
            }
            if(detalleLineaCaptura.getUnidadnegocio() != null && !detalleLineaCaptura.getUnidadnegocio().equals("")){
                lcQuery.append(clausula).append(" x.unidadnegocio like '%").append(detalleLineaCaptura.getUnidadnegocio()).append("%' ");
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
     * @param lineaCaptura
     * @return
     */
    @Override
    public List<DetalleLCPagosDTO> consultarLCPagos(String facturaERP) {
        DAO<XxfrvConsultaLcPagos> lcPagosDAO = new DAO(XxfrvConsultaLcPagos.class);
        List<DetalleLCPagosDTO> lcPagosDTO = new ArrayList<>();
        List<CatalogoParametroDTO> parametros= new ArrayList<>();
        parametros.add(new CatalogoParametroDTO("idfacturaerp",facturaERP,CONSTANTE.NUMERO));
        List<XxfrvConsultaLcPagos> lcPagos = lcPagosDAO.consultaQueryByParameters("XxfrvConsultaLcPagos.findByIdfacturaerp",parametros);
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
        List<XxfrConsultaLcFacDet> detallesLCFactDet =new ArrayList<>();
        if(lcFactDetalle!=null){
            StringBuilder lcQuery=new StringBuilder("SELECT x FROM XxfrConsultaLcFacDet x ");
            String clausula="WHERE";
            if(lcFactDetalle.getBilltoconsumername()!= null && !lcFactDetalle.getBilltoconsumername().equals("")){
                lcQuery.append(clausula).append(" x.billtoconsumername like '%").append(lcFactDetalle.getBilltoconsumername()).append("%' ");
                clausula="AND";
            }
            if(lcFactDetalle.getCompanyaccountcode() != null && !lcFactDetalle.getCompanyaccountcode().equals("")){
                lcQuery.append(clausula).append(" x.companyaccountcode like '%").append(lcFactDetalle.getCompanyaccountcode()).append("%' ");
                clausula="AND";
            }
            if(lcFactDetalle.getProjectid() != null && !lcFactDetalle.getProjectid().equals("")){
                lcQuery.append(clausula).append(" x.projectid like '%").append(lcFactDetalle.getProjectid()).append("%' ");
                clausula="AND";
            }
            if(lcFactDetalle.getEntidadlegal()!= null && !lcFactDetalle.getEntidadlegal().equals("")){
                lcQuery.append(clausula).append(" x.entidadlegal like '%").append(lcFactDetalle.getEntidadlegal()).append("%' ");
                clausula="AND";
            }
            if(lcFactDetalle.getBusinessunitname() != null && !lcFactDetalle.getBusinessunitname().equals("")){
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
}
