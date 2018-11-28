/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Ernesto
 */
public class LCFacturaDTO {
    
    private BigInteger idfacturaprimavera;
    private String relatederpinvoice;
    private String billtoconsumername;
    private Long companyaccountcode;
    private String paymenttermdate;
    private Long projectid;
    private BigDecimal totalamount;
    private String idlineacaptura;
    private Short linenumber;
    private BigDecimal montobrutolinea;
    private String taxrate;

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

    public String getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(String idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    public Short getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(Short linenumber) {
        this.linenumber = linenumber;
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
