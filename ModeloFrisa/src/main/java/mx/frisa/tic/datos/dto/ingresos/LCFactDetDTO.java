/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Ernesto
 */
public class LCFactDetDTO {
    
    private BigDecimal montoLineacaptura;
    private BigDecimal montoFactura;
    private BigInteger impuestos;
    private BigDecimal montoPagado;
    private String lineacaptura;
    private Date fechavigencia;
    private String entidadlegal;
    private BigInteger idfacturaprimavera;
    private String relatederpinvoice;
    private String billtoconsumername;
    private Long companyaccountcode;
    private String paymenttermdate;
    private Long projectid;
    private BigDecimal totalamount;
    private String businessunitname;
    private BigDecimal montobrutolinea;
    private String taxrate;

    public BigDecimal getMontoLineacaptura() {
        return montoLineacaptura;
    }

    public void setMontoLineacaptura(BigDecimal montoLineacaptura) {
        this.montoLineacaptura = montoLineacaptura;
    }

    public BigDecimal getMontoFactura() {
        return montoFactura;
    }

    public void setMontoFactura(BigDecimal montoFactura) {
        this.montoFactura = montoFactura;
    }

    public BigInteger getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(BigInteger impuestos) {
        this.impuestos = impuestos;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(BigDecimal montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getLineacaptura() {
        return lineacaptura;
    }

    public void setLineacaptura(String lineacaptura) {
        this.lineacaptura = lineacaptura;
    }

    public Date getFechavigencia() {
        return fechavigencia;
    }

    public void setFechavigencia(Date fechavigencia) {
        this.fechavigencia = fechavigencia;
    }

    public String getEntidadlegal() {
        return entidadlegal;
    }

    public void setEntidadlegal(String entidadlegal) {
        this.entidadlegal = entidadlegal;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getRelatederpinvoice() {
        return relatederpinvoice;
    }

    public void setRelatederpinvoice(String relatederpinvoice) {
        this.relatederpinvoice = relatederpinvoice;
    }

    public String getBilltoconsumername() {
        return billtoconsumername;
    }

    public void setBilltoconsumername(String billtoconsumername) {
        this.billtoconsumername = billtoconsumername;
    }

    public Long getCompanyaccountcode() {
        return companyaccountcode;
    }

    public void setCompanyaccountcode(Long companyaccountcode) {
        this.companyaccountcode = companyaccountcode;
    }

    public String getPaymenttermdate() {
        return paymenttermdate;
    }

    public void setPaymenttermdate(String paymenttermdate) {
        this.paymenttermdate = paymenttermdate;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public String getBusinessunitname() {
        return businessunitname;
    }

    public void setBusinessunitname(String businessunitname) {
        this.businessunitname = businessunitname;
    }

    public BigDecimal getMontobrutolinea() {
        return montobrutolinea;
    }

    public void setMontobrutolinea(BigDecimal montobrutolinea) {
        this.montobrutolinea = montobrutolinea;
    }

    public String getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(String taxrate) {
        this.taxrate = taxrate;
    }
    
}
