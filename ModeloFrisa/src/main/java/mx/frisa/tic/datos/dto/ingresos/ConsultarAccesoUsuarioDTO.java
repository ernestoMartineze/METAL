/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author Ernesto
 */
public class ConsultarAccesoUsuarioDTO {
    
    private List<AccesoUsuarioDTO> accesos;
    private String usuario;

    public List<AccesoUsuarioDTO> getAccesos() {
        return accesos;
    }

    public void setAccesos(List<AccesoUsuarioDTO> accesos) {
        this.accesos = accesos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
