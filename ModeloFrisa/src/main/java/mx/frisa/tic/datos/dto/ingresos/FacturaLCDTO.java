/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

/**
 *
 * @author Ernesto
 */
public class FacturaLCDTO {
    
    private Cabecera_FacturaDTO cabecera_Factura;
    private Lineas_FacturaDTO lineas_Factura;

    public Cabecera_FacturaDTO getCabecera_Factura() {
        return cabecera_Factura;
    }

    public void setCabecera_Factura(Cabecera_FacturaDTO cabecera_Factura) {
        this.cabecera_Factura = cabecera_Factura;
    }

    public Lineas_FacturaDTO getLineas_Factura() {
        return lineas_Factura;
    }

    public void setLineas_Factura(Lineas_FacturaDTO lineas_Factura) {
        this.lineas_Factura = lineas_Factura;
    }
    
    
    
}
