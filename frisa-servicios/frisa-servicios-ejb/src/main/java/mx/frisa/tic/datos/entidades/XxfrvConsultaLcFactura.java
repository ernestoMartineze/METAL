/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ernesto
 */
@Entity
@Table(name = "XXFRV_CONSULTA_LC_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvConsultaLcFactura.findAll", query = "SELECT x FROM XxfrvConsultaLcFactura x")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByIdfacturaprimavera", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.idfacturaprimavera = :idfacturaprimavera")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByRelatederpinvoice", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.relatederpinvoice = :relatederpinvoice")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByBilltoconsumername", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.billtoconsumername = :billtoconsumername")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByCompanyaccountcode", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.companyaccountcode = :companyaccountcode")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByPaymenttermdate", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.paymenttermdate = :paymenttermdate")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByProjectid", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.projectid = :projectid")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByTotalamount", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.totalamount = :totalamount")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByIdlineacaptura", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.idlineacaptura = :idlineacaptura")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByLinenumber", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.linenumber = :linenumber")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByMontobrutolinea", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.montobrutolinea = :montobrutolinea")
    , @NamedQuery(name = "XxfrvConsultaLcFactura.findByTaxrate", query = "SELECT x FROM XxfrvConsultaLcFactura x WHERE x.taxrate = :taxrate")})
public class XxfrvConsultaLcFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 52)
    @Column(name = "IDLINEA")
    @Id
    private String idlinea;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LINENUMBER")
    private short linenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigInteger idfacturaprimavera;
    @Size(max = 20)
    @Column(name = "RELATEDERPINVOICE")
    private String relatederpinvoice;
    @Size(max = 240)
    @Column(name = "BILLTOCONSUMERNAME")
    private String billtoconsumername;
    @Column(name = "COMPANYACCOUNTCODE")
    private Long companyaccountcode;
    @Size(max = 20)
    @Column(name = "PAYMENTTERMDATE")
    private String paymenttermdate;
    @Column(name = "PROJECTID")
    private Long projectid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALAMOUNT")
    private BigDecimal totalamount;
    @Size(max = 20)
    @Column(name = "IDLINEACAPTURA")
    private String idlineacaptura;
    @Column(name = "MONTOBRUTOLINEA")
    private BigDecimal montobrutolinea;
    @Size(max = 20)
    @Column(name = "TAXRATE")
    private String taxrate;

    public XxfrvConsultaLcFactura() {
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

    public String getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(String idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
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

    public String getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(String idlinea) {
        this.idlinea = idlinea;
    }

    public short getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(short linenumber) {
        this.linenumber = linenumber;
    }
    
}
