package mx.frisa.tic.datos.dto.ingresos;

import java.util.List;

/**
 *
 * @author soultech
 */
public class RespuestaProcesaFacturasDTO {
    String proceso;
    String idError;
    String descripcionError;
    List<FacturaPagoDTO> facturas;

    public RespuestaProcesaFacturasDTO() {
    }

    public RespuestaProcesaFacturasDTO(String proceso, String idError, String descripcionError) {
        this.proceso = proceso;
        this.idError = idError;
        this.descripcionError = descripcionError;
        this.facturas.clear();
    }
    
    

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public List<FacturaPagoDTO> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaPagoDTO> facturas) {
        this.facturas = facturas;
    }

}
