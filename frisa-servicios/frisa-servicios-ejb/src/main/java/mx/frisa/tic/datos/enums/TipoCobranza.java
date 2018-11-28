package mx.frisa.tic.datos.enums;

public enum TipoCobranza {
    LINEA_CAPTURA("LINEA CAPTURA"),
    REFERENCIA("REFERENCIA"),
    NINGUNO("NINGUNO");

    TipoCobranza(final String descripcion) {
        this.descripcion = descripcion;
    }

    private final String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
