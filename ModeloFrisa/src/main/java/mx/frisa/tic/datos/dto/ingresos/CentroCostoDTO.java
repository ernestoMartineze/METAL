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
public class CentroCostoDTO {
    private String FLEX_VALUE;
    private String DESCRIPTION;
    private Integer idCarga;

    public String getFLEX_VALUE() {
        return FLEX_VALUE;
    }

    public void setFLEX_VALUE(String FLEX_VALUE) {
        this.FLEX_VALUE = FLEX_VALUE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Integer getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(Integer idCarga) {
        this.idCarga = idCarga;
    }
    
    
}
