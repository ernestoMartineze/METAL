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
public class RespuestaCargaFacturaDTO {
    String uuid;
    List<FacturaDTO> facturas;
    Proceso proceso;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    
    
    public List<FacturaDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaDTO> facturas) {
        this.facturas = facturas;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

}
