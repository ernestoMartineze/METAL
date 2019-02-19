/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;


import mx.frisa.tic.negocio.remoto.RespuestaERP_UnidadNegocio;

/**
 *
 * @author USER_1
 */
public class RespuestaUnidadNegocioDTO {
    
    private Proceso proceso;
    private RespuestaERP_UnidadNegocio unidadesNegocio;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public RespuestaERP_UnidadNegocio getUnidadesNegocio() {
        return unidadesNegocio;
    }

    public void setUnidadesNegocio(RespuestaERP_UnidadNegocio unidadesNegocio) {
        this.unidadesNegocio = unidadesNegocio;
    }

    
    
    
    
}
