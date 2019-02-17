/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;
import mx.frisa.tic.negocio.remoto.RespuestaERP_Cuenta;

/**
 *
 * @author USER_1
 */
public class RespuestaCuentaBancariaDTO {
    
    private RespuestaERP_Cuenta cuentaBancaria;
    private Proceso proceso;

    public RespuestaERP_Cuenta getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(RespuestaERP_Cuenta cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }
    
    
    
}
