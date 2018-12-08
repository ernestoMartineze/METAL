/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import mx.frisa.tic.datos.dto.ingresos.Proceso;

/**
 *
 * @author USER_1
 */
public class RespuestaERP_EncabezadoRecibo {

    String numeroRecibo;
    Proceso proceso;

    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

}
