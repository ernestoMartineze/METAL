package mx.frisa.tic.datos.dto;

import java.util.List;

public class CollectionFacturaBO {
    protected List<FacturaBO> facturas;

    public void setFacturas(List<FacturaBO> facturas) {
        this.facturas = facturas;
    }

    public List<FacturaBO> getFacturas() {
        return facturas;
    }
}
