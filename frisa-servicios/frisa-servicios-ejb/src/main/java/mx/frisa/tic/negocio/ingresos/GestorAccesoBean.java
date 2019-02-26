/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.AccesoUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.AgregarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarAccesoUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUniNegocioDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.entidades.XxfrtAccesoUsuarios;

/**
 *
 * @author Soultech
 */
@Stateless(name = "GestorAccesoBean")
@LocalBean
public class GestorAccesoBean {

    public RespuestaDTO agregarUsuario(AgregarUsuarioDTO usuarioAcceso) {
        RespuestaDTO response = new RespuestaDTO();
        response.setProceso("agregarUsuario");
        DAO<XxfrtAccesoUsuarios> persist = new DAO(XxfrtAccesoUsuarios.class);
        //validar combinacion existente
        List<CatalogoParametroDTO> parametros = new ArrayList<>();
        parametros.add(new CatalogoParametroDTO("usuario", usuarioAcceso.getUsuario(), CONSTANTE.CADENA));
        parametros.add(new CatalogoParametroDTO("centrocostos", usuarioAcceso.getCentroCostos(), CONSTANTE.CADENA));
        parametros.add(new CatalogoParametroDTO("unidadnegocio", usuarioAcceso.getUnidadNegocio(), CONSTANTE.CADENA));
        List<XxfrtAccesoUsuarios> usuarios = persist.consultaQueryByParameters("XxfrtAccesoUsuarios.findByAll", parametros);
        if(usuarios.size()>0){
            response.setDescripcionError("La combinacion (unidad de negocio - centro de costos) ya existe para el usuario");
            response.setIdError("1");
        }else{
            XxfrtAccesoUsuarios entidadUsuario = new XxfrtAccesoUsuarios();
            entidadUsuario.setUsuario(usuarioAcceso.getUsuario());
            entidadUsuario.setCentrocostos(usuarioAcceso.getCentroCostos());
            entidadUsuario.setUnidadnegocio(usuarioAcceso.getUnidadNegocio());
            entidadUsuario.setHabilitado("H");
            persist.registra(entidadUsuario);
            response.setDescripcionError("Permisos otorgados a usuario");
            response.setIdError("0");
        }
        
        return response;
    }
    
    
    public RespuestaDTO actualizarUsuario(String usuarioAcceso) {
        RespuestaDTO response = new RespuestaDTO();
        response.setProceso("agregarUsuario");
        DAO<XxfrtAccesoUsuarios> persist = new DAO(XxfrtAccesoUsuarios.class);
        List<CatalogoParametroDTO> parametros = new ArrayList<>();
        parametros.add(new CatalogoParametroDTO("idacceso", usuarioAcceso, CONSTANTE.NUMERO));
        List<XxfrtAccesoUsuarios> result = persist.consultaQueryByParameters("XxfrtAccesoUsuarios.findByIdacceso", parametros);
        if(result != null && result.size()>0){
            result.get(0).setHabilitado("N");
            if(persist.actualiza(result.get(0))){
                response.setDescripcionError("Se actualizo correctamente");
                response.setIdError("0");
            }else{
                response.setDescripcionError("No se pudo actualizar");
                response.setIdError("1");
            }
        }else{
            response.setDescripcionError("id no encontrado");
            response.setIdError("1");
        }
        
        return response;
    }

    public RespuestaDTO consultarUsuario(ConsultarUniNegocioDTO unidadNegocio) {
        RespuestaDTO response = new RespuestaDTO();
        response.setProceso("consultarUsuario");
        response.setIdError("1300");
        response.setDescripcionError("No existe el usuario");
        DAO<XxfrtAccesoUsuarios> persist = new DAO(XxfrtAccesoUsuarios.class);
        List<XxfrtAccesoUsuarios> ds = null;
        List<CatalogoParametroDTO> parametros = new ArrayList<>();
        parametros.add(new CatalogoParametroDTO("unidadnegocio", unidadNegocio.getNombre(), CONSTANTE.CADENA));
        ds = persist.consultaQueryByParameters("XxfrtAccesoUsuarios.findByUnidadnegocio", parametros);
        if(!ds.isEmpty()){
            response.setIdError("0");
            response.setDescripcionError("EXISTE");
        }
        return response;
    }

    public ConsultarAccesoUsuarioDTO consultarAcceso(String usuario) {
        ConsultarAccesoUsuarioDTO response= new ConsultarAccesoUsuarioDTO();
        response.setUsuario(usuario);
        DAO<XxfrtAccesoUsuarios> accesoDao = new DAO(XxfrtAccesoUsuarios.class);
        List<XxfrtAccesoUsuarios> accesosDao = null;
        List<AccesoUsuarioDTO> accesosDto=new ArrayList();
        List<CatalogoParametroDTO> parametros = new ArrayList<>();
        parametros.add(new CatalogoParametroDTO("usuario", usuario, CONSTANTE.CADENA));
        accesosDao = (List<XxfrtAccesoUsuarios>) accesoDao.consultaQueryByParameters("XxfrtAccesoUsuarios.findByUsuarioHabilitado", parametros);
        for(XxfrtAccesoUsuarios acceso : accesosDao){
            AccesoUsuarioDTO accesoDto = new AccesoUsuarioDTO();
            accesoDto.setCentrocostos(acceso.getCentrocostos());
            accesoDto.setIdacceso(acceso.getIdacceso());
            accesoDto.setUnidadnegocio(acceso.getUnidadnegocio());
            accesosDto.add(accesoDto);
            response.setAccesos(accesosDto);
        }
        return response;
    }
}
