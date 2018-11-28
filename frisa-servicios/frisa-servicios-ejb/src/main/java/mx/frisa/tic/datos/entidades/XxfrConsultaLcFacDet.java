/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ernesto
 */
@Entity
@Table(name = "XXFR_CONSULTA_LC_FAC_DET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrConsultaLcFacDet.findAll", query = "SELECT x FROM XxfrConsultaLcFacDet x")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByLineacaptura", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.lineacaptura = :lineacaptura")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByFechavigencia", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.fechavigencia = :fechavigencia")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByEntidadlegal", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.entidadlegal = :entidadlegal")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByIdfacturaprimavera", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.idfacturaprimavera = :idfacturaprimavera")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByRelatederpinvoice", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.relatederpinvoice = :relatederpinvoice")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByBilltoconsumername", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.billtoconsumername = :billtoconsumername")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByCompanyaccountcode", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.companyaccountcode = :companyaccountcode")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByPaymenttermdate", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.paymenttermdate = :paymenttermdate")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByProjectid", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.projectid = :projectid")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByBusinessunitname", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.businessunitname = :businessunitname")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByMontoLineacaptura", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.montoLineacaptura = :montoLineacaptura")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByMontoFactura", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.montoFactura = :montoFactura")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByImpuestos", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.impuestos = :impuestos")
    , @NamedQuery(name = "XxfrConsultaLcFacDet.findByMontoPagado", query = "SELECT x FROM XxfrConsultaLcFacDet x WHERE x.montoPagado = :montoPagado")})
public class XxfrConsultaLcFacDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "LINEACAPTURA")
    private String lineacaptura;
    @Column(name = "FECHAVIGENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechavigencia;
    @Size(max = 20)
    @Column(name = "ENTIDADLEGAL")
    private String entidadlegal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    @Id
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
    @Size(max = 20)
    @Column(name = "BUSINESSUNITNAME")
    private String businessunitname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTO_LINEACAPTURA")
    private BigDecimal montoLineacaptura;
    @Column(name = "MONTO_FACTURA")
    private BigDecimal montoFactura;
    @Column(name = "IMPUESTOS")
    private BigInteger impuestos;
    @Column(name = "MONTO_PAGADO")
    private BigDecimal montoPagado;

    public XxfrConsultaLcFacDet() {
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

    public String getBusinessunitname() {
        return businessunitname;
    }

    public void setBusinessunitname(String businessunitname) {
        this.businessunitname = businessunitname;
    }

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
    
}
