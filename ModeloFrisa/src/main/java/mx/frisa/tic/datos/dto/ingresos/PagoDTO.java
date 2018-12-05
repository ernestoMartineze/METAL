/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;

/**
 *
 * @author Soultech
 */
public class PagoDTO {
    
    protected BigDecimal IdEdoCta;
    protected BigDecimal IdCabeceraRecibo;
    protected String LineaCaptura;
    protected String Referencia;
    protected String MetodoId;
    protected String Moneda;
    protected String UnidadNegocio;
    protected String NroRecibo;
    protected String Monto;
    protected String FechaCreacion;
    protected String CustomerId;
    protected String SiteId;

    public PagoDTO() {
    }

    public PagoDTO(BigDecimal IdEdoCta, BigDecimal IdCabeceraRecibo, String LineaCaptura, String Referencia, String MetodoId, String Moneda, String UnidadNegocio, String NroRecibo, String Monto, String FechaCreacion, String CustomerId, String SiteId) {
        this.IdEdoCta = IdEdoCta;
        this.IdCabeceraRecibo = IdCabeceraRecibo;
        this.LineaCaptura = LineaCaptura;
        this.Referencia = Referencia;
        this.MetodoId = MetodoId;
        this.Moneda = Moneda;
        this.UnidadNegocio = UnidadNegocio;
        this.NroRecibo = NroRecibo;
        this.Monto = Monto;
        this.FechaCreacion = FechaCreacion;
        this.CustomerId = CustomerId;
        this.SiteId = SiteId;
    }

    
    
    public BigDecimal getIdEdoCta() {
        return IdEdoCta;
    }

    public void setIdEdoCta(BigDecimal IdEdoCta) {
        this.IdEdoCta = IdEdoCta;
    }

    public BigDecimal getIdCabeceraRecibo() {
        return IdCabeceraRecibo;
    }

    public void setIdCabeceraRecibo(BigDecimal IdCabeceraRecibo) {
        this.IdCabeceraRecibo = IdCabeceraRecibo;
    }

    public String getLineaCaptura() {
        return LineaCaptura;
    }

    public void setLineaCaptura(String LineaCaptura) {
        this.LineaCaptura = LineaCaptura;
    }

    public String getReferencia() {
        return Referencia;
    }

    public void setReferencia(String Referencia) {
        this.Referencia = Referencia;
    }

    public String getMetodoId() {
        return MetodoId;
    }

    public void setMetodoId(String MetodoId) {
        this.MetodoId = MetodoId;
    }

    public String getMoneda() {
        return Moneda;
    }

    public void setMoneda(String Moneda) {
        this.Moneda = Moneda;
    }

    public String getUnidadNegocio() {
        return UnidadNegocio;
    }

    public void setUnidadNegocio(String UnidadNegocio) {
        this.UnidadNegocio = UnidadNegocio;
    }

    public String getNroRecibo() {
        return NroRecibo;
    }

    public void setNroRecibo(String NroRecibo) {
        this.NroRecibo = NroRecibo;
    }

    public String getMonto() {
        return Monto;
    }

    public void setMonto(String Monto) {
        this.Monto = Monto;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getSiteId() {
        return SiteId;
    }

    public void setSiteId(String SiteId) {
        this.SiteId = SiteId;
    }

    
    
}
