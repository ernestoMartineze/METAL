/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;

/**
 *
 * @author USER_1
 */

@JsonIgnoreProperties(ignoreUnknown=true)
public class CargaFacturasSOA {
    
    @JacksonXmlProperty(localName = "facturas")
    List<FacturaSOA> facturas;
    @JacksonXmlProperty(localName = "idBatch")
    String idBatch;

    public List<FacturaSOA> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaSOA> facturas) {
        this.facturas = facturas;
    }

    public String getIdBatch() {
        return idBatch;
    }

    public void setIdBatch(String idBatch) {
        this.idBatch = idBatch;
    }

}
