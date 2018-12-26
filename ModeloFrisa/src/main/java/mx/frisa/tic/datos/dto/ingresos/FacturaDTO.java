/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author USER_1
 */
class FacturaDTO {
    private int idfacturaprimavera;
    private List<LineasFacturaDTO> lineas;

    public int getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(int idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public List<LineasFacturaDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineasFacturaDTO> lineas) {
        this.lineas = lineas;
    }
    
}
