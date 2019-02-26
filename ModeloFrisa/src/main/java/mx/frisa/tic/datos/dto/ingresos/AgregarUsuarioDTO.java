/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;

/**
 *
 * @author Soultech
 */
public class AgregarUsuarioDTO {
    
    private BigDecimal idacceso;
    String usuario;
    String centroCostos;
    String unidadNegocio;

    public BigDecimal getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(BigDecimal idacceso) {
        this.idacceso = idacceso;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(String centroCostos) {
        this.centroCostos = centroCostos;
    }

    public String getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(String unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }
    
}
