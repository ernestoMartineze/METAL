/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.enums;

/**
 *
 * @author USER_1
 */
public enum TipoTransaccion {
    FAC_INGRESOS_MN("FAC_INGRESOS_MN"),
    FAC_INGRESOS_US("FAC_INGRESOS_US"),
    NINGUNO("NINGUNO");

    TipoTransaccion(final String descripcion) {
        this.descripcion = descripcion;
    }

    private final String descripcion;

  

    @Override
    public String toString() {
        return descripcion;
    }
}
