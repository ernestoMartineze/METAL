/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import java.util.List;
import mx.frisa.tic.datos.dto.ingresos.FacturaPagoDTO;
import mx.frisa.tic.datos.dto.ingresos.Proceso;

/**
 *
 * @author USER_1
 */
public class RespuestaCreaFactura {
    
    private Proceso proceso;
    private List<FacturaPagoDTO> facturas;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public List<FacturaPagoDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaPagoDTO> facturas) {
        this.facturas = facturas;
    }

   
    
}
