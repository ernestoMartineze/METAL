/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

/**
 *
 * @author soultech
 */
public class LineaCapturaDTO {
    
    
    String lineaCaptura;
    String fechaCreacion;

    public LineaCapturaDTO() {
    }

    
    public LineaCapturaDTO(String lineaCaptura, String fechaCreacion) {
        this.lineaCaptura = lineaCaptura;
        this.fechaCreacion = fechaCreacion;
    }

    public String getLineaCaptura() {
        return lineaCaptura;
    }

    public void setLineaCaptura(String lineaCaptura) {
        this.lineaCaptura = lineaCaptura;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    
}
