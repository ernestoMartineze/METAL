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
import mx.frisa.tic.datos.dto.ingresos.LineaCapturaDTO;
import mx.frisa.tic.datos.dto.ingresos.LineaCaptutaFacturaDTO;
import mx.frisa.tic.datos.entidades.XxfrLineaCaptura;

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

}
