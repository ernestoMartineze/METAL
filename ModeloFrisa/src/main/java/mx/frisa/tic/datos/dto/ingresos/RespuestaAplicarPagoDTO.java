/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

/**
 *
 * @author USER_1
 */
public class RespuestaAplicarPagoDTO {
    private Proceso proceso;
    private AplicarPagoDTO aplicarPago;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public AplicarPagoDTO getAplicarPago() {
        return aplicarPago;
    }

    public void setAplicarPago(AplicarPagoDTO aplicarPago) {
        this.aplicarPago = aplicarPago;
    }
    
}
