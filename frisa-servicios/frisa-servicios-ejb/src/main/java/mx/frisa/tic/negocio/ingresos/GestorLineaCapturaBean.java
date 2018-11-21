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
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLCPagosDTO;
import mx.frisa.tic.datos.dto.ingresos.DetalleLineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
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
}
