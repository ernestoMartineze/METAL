/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.LCFacturaDTO;
import mx.frisa.tic.datos.entidades.XxfrvConsultaLcFactura;

/**
 *
 * @author Ernesto
 */
@Stateless(name = "GestorFacturasBean")
@LocalBean
public class GestorFacturasBean implements GestorFacturas{

    @Override
    public List<LCFacturaDTO> consultarLCFactura(String facturaERp) {
        
        DAO<XxfrvConsultaLcFactura> lcFacturaDAO = new DAO(XxfrvConsultaLcFactura.class);
        List<LCFacturaDTO> lcFacturasDTO = new ArrayList<LCFacturaDTO>();
        List<XxfrvConsultaLcFactura> lcFacturas = new ArrayList<>();
        if(facturaERp!=null && !facturaERp.equals("")){
            List<CatalogoParametroDTO> parametros =new ArrayList<>();
            parametros.add(new CatalogoParametroDTO("idlineacaptura",facturaERp,"CADENA"));
            lcFacturas = lcFacturaDAO.consultaQueryByParameters("XxfrvConsultaLcFactura.findByIdlineacaptura",parametros);
        }


        for (XxfrvConsultaLcFactura lcFacturaRespuesta : lcFacturas) {
            LCFacturaDTO lcFacturaDTO = new LCFacturaDTO();
            lcFacturaDTO.setBilltoconsumername(lcFacturaRespuesta.getBilltoconsumername());
            lcFacturaDTO.setCompanyaccountcode(lcFacturaRespuesta.getCompanyaccountcode());
            lcFacturaDTO.setIdfacturaprimavera(lcFacturaRespuesta.getIdfacturaprimavera());
            lcFacturaDTO.setIdlineacaptura(lcFacturaRespuesta.getIdlineacaptura());
            lcFacturaDTO.setLinenumber(lcFacturaRespuesta.getLinenumber());
            lcFacturaDTO.setMontobrutolinea(lcFacturaRespuesta.getMontobrutolinea());
            lcFacturaDTO.setPaymenttermdate(lcFacturaRespuesta.getPaymenttermdate());
            lcFacturaDTO.setProjectid(lcFacturaRespuesta.getProjectid());
            lcFacturaDTO.setRelatederpinvoice(lcFacturaRespuesta.getRelatederpinvoice());
            lcFacturaDTO.setTaxrate(lcFacturaRespuesta.getTaxrate());
            lcFacturaDTO.setTotalamount(lcFacturaRespuesta.getTotalamount());
            //Agregar los valores necesarios requeridos....
            lcFacturasDTO.add(lcFacturaDTO);

        }
        return lcFacturasDTO;
    }
    
    
}
