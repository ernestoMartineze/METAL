/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import mx.frisa.tic.negocio.remoto.RespuestaERP_Usuario;

/**
 *
 * @author USER_1
 */
public class Respuesta_bi_usuarioDTO {
    
    private Proceso proceso;
    private RespuestaERP_Usuario usuario;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public RespuestaERP_Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(RespuestaERP_Usuario usuario) {
        this.usuario = usuario;
    }

   
    
    
}
