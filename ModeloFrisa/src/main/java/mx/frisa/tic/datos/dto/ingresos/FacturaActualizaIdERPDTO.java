/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author Soultech
 */
public class FacturaActualizaIdERPDTO {
    
    protected cabeceraActualizaIdERPDTO cabecera;
    protected ListaLineaActualizaIdERPDTO lineas;

    public cabeceraActualizaIdERPDTO getCabecera() {
        return cabecera;
    }

    public void setCabecera(cabeceraActualizaIdERPDTO cabecera) {
        this.cabecera = cabecera;
    }

    public ListaLineaActualizaIdERPDTO getLineas() {
        return lineas;
    }

    public void setLineas(ListaLineaActualizaIdERPDTO lineas) {
        this.lineas = lineas;
    }
    
    
}
