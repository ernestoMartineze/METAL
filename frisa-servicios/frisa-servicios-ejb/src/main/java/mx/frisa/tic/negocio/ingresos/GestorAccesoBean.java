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
import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.AgregarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.entidades.XxfrtAccesoUsuarios;

/**
 *
 * @author Soultech
 */

@Stateless(name = "GestorAccesoBean")
@LocalBean
public class GestorAccesoBean {
    
    
    public RespuestaDTO agregarUsuario(AgregarUsuarioDTO usuarioAcceso){
        RespuestaDTO response = new RespuestaDTO();
        response.setProceso("agregarUsuario");
        DAO<XxfrtAccesoUsuarios> persist = new DAO(XxfrtAccesoUsuarios.class);
        XxfrtAccesoUsuarios entidadUsuario = new XxfrtAccesoUsuarios();
        entidadUsuario.setUsuario(usuarioAcceso.getUsuario());
        entidadUsuario.setCentrocostos(usuarioAcceso.getCentroCostos());
        entidadUsuario.setUnidadnegocio(usuarioAcceso.getUnidadNegocio());
        entidadUsuario.setHabilitado("H");
        persist.registra(entidadUsuario);
        response.setDescripcionError("Permisos otorgados a usuarios");
        response.setIdError("0");
        return response;
    }
    
    public RespuestaDTO consultarUsuario(ConsultarUsuarioDTO usuarioAcceso){
        RespuestaDTO response = new RespuestaDTO();
        response.setProceso("consultarUsuario");
        response.setIdError("1300");
        response.setDescripcionError("No existe el usuario");
        DAO<XxfrtAccesoUsuarios> persist = new DAO(XxfrtAccesoUsuarios.class);
        List<XxfrtAccesoUsuarios> ds = null;
        List<CatalogoParametroDTO> parametros = new ArrayList<>();
        parametros.add(new CatalogoParametroDTO("unidadnegocio", usuarioAcceso.getUnidadNegocio(), CONSTANTE.CADENA));
        ds = persist.consultaQueryByParameters("XxfrtAccesoUsuarios.findByUnidadnegocio", parametros);
        if(!ds.isEmpty()){
            response.setIdError("0");
            response.setDescripcionError("EXISTE");
        }
        return response;
    }
    
}
