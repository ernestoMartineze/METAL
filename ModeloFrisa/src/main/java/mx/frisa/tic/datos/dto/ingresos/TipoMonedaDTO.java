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
public class TipoMonedaDTO {
    String codigo;
    String descripcion;
    String ind_activo;
    String cveTipoMonedaFrisa;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInd_activo() {
        return ind_activo;
    }

    public void setInd_activo(String ind_activo) {
        this.ind_activo = ind_activo;
    }

    public String getCveTipoMonedaFrisa() {
        return cveTipoMonedaFrisa;
    }

    public void setCveTipoMonedaFrisa(String cveTipoMonedaFrisa) {
        this.cveTipoMonedaFrisa = cveTipoMonedaFrisa;
    }
    
    
    
}
