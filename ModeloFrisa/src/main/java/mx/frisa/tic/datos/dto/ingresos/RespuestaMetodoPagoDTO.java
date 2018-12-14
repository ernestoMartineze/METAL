/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;


import mx.frisa.tic.negocio.remoto.MetodoPagoOBI;

/**
 *
 * @author USER_1
 */
public class RespuestaMetodoPagoDTO {
    public static final long serialVersionUID = 87996564786747L;
    private Proceso proceso;
    private MetodoPagoOBI metodosPago;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public MetodoPagoOBI getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(MetodoPagoOBI metodosPago) {
        this.metodosPago = metodosPago;
    }

    
}
