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
public class RespuestaERP_Edo_Cuenta {

    DATA_DS DATA_DSObject;
    Proceso proceso;

    public DATA_DS getDATA_DSObject() {
        return DATA_DSObject;
    }

    public void setDATA_DSObject(DATA_DS DATA_DSObject) {
        this.DATA_DSObject = DATA_DSObject;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

}
