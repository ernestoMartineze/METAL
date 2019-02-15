/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.AgregarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUsuarioDTO;

/**
 *
 * @author Soultech
 */
public interface GestorAcceso {
    
    public RespuestaDTO agregarUsuario(AgregarUsuarioDTO usuarioAcceso);
    
    public RespuestaDTO consultarUsuario(ConsultarUsuarioDTO usuarioAcceso);
    
}
