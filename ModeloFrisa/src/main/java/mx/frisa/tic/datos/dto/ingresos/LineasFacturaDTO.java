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
class LineasFacturaDTO {
    private int idfacturaprimavera;
    private int linenumber;
    private String description_origen;

    public int getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(int idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public int getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(int linenumber) {
        this.linenumber = linenumber;
    }

    public String getDescription_origen() {
        return description_origen;
    }

    public void setDescription_origen(String description_origen) {
        this.description_origen = description_origen;
    }
    
    
}
