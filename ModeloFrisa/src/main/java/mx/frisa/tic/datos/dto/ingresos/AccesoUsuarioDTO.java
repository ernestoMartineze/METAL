/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;

/**
 *
 * @author Ernesto
 */
public class AccesoUsuarioDTO {
    
    private BigDecimal idacceso;
    private String centrocostos;
    private String unidadnegocio;

    public BigDecimal getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(BigDecimal idacceso) {
        this.idacceso = idacceso;
    }

    public String getCentrocostos() {
        return centrocostos;
    }

    public void setCentrocostos(String centrocostos) {
        this.centrocostos = centrocostos;
    }

    public String getUnidadnegocio() {
        return unidadnegocio;
    }

    public void setUnidadnegocio(String unidadnegocio) {
        this.unidadnegocio = unidadnegocio;
    }
    
    
}
