/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author USER_1
 */
public class Respuesta_bi_usuarioDTO {
    
    private List<UnidadNegocioDTO> usuario;   

    public List<UnidadNegocioDTO> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<UnidadNegocioDTO> usuario) {
        this.usuario = usuario;
    }
    
    
}
