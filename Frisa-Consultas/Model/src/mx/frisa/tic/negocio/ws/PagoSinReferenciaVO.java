package mx.frisa.tic.negocio.ws;

public class PagoSinReferenciaVO {
    
    private String cuentaBancaria;
    private String fecha;
    private String moneda;
    private String monto;
    private String tipoDeposito;
    private String conceptoDeposito;
    private String referencia;
    private String lineaDeCaptura;
    private String unidadDeNegocio;
    private String proyecto;
    private String cliente;
    private String nCuenta;
    
    public PagoSinReferenciaVO() {
    }


    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getMonto() {
        return monto;
    }

    public void setCuentaBancaria(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setTipoDeposito(String tipoDeposito) {
        this.tipoDeposito = tipoDeposito;
    }

    public String getTipoDeposito() {
        return tipoDeposito;
    }

    public void setConceptoDeposito(String conceptoDeposito) {
        this.conceptoDeposito = conceptoDeposito;
    }

    public String getConceptoDeposito() {
        return conceptoDeposito;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setLineaDeCaptura(String lineaDeCaptura) {
        this.lineaDeCaptura = lineaDeCaptura;
    }

    public String getLineaDeCaptura() {
        return lineaDeCaptura;
    }

    public void setUnidadDeNegocio(String unidadDeNegocio) {
        this.unidadDeNegocio = unidadDeNegocio;
    }

    public String getUnidadDeNegocio() {
        return unidadDeNegocio;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setNCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getNCuenta() {
        return nCuenta;
    }
}
