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
public class PeticionCargaFacturaDTO {
    String facturas;
    String idBatch;

    public String getIdBatch() {
        return idBatch;
    }

    public void setIdBatch(String idBatch) {
        this.idBatch = idBatch;
    }

    
    
    public String getFacturas() {
        return facturas;
    }

    public void setFacturas(String facturas) {
        this.facturas = facturas;
    }    
    
}
