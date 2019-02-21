/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import mx.frisa.tic.negocio.remoto.RespuestaERP_CentroCosto;



/**
 *
 * @author USER_1
 */
public class RespuestaCentroCostoDTO {
    
    private Proceso proceso;
    private RespuestaERP_CentroCosto centroCosto;
    

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public RespuestaERP_CentroCosto getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(RespuestaERP_CentroCosto centroCosto) {
        this.centroCosto = centroCosto;
    }

    
    
}
