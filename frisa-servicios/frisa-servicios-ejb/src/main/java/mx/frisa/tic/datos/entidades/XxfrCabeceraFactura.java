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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFR_CABECERA_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrCabeceraFactura.findAll", query = "SELECT x FROM XxfrCabeceraFactura x"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByIdfacturaprimavera", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.idfacturaprimavera = :idfacturaprimavera"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByFacilitynumber", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.facilitynumber = :facilitynumber"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByCompanyaccountcode", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.companyaccountcode = :companyaccountcode"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByBusinessunitname", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.businessunitname = :businessunitname"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByTransactionsource", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.transactionsource = :transactionsource"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByTransactiontype", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.transactiontype = :transactiontype"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByCreationdatetrx", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.creationdatetrx = :creationdatetrx"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByCreationdategl", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.creationdategl = :creationdategl"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByCurrency", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.currency = :currency"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByConversionratetype", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.conversionratetype = :conversionratetype"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByConversionratevalue", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.conversionratevalue = :conversionratevalue"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByBilltoconsumername", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.billtoconsumername = :billtoconsumername"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByBilltolocation", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.billtolocation = :billtolocation"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByPaymenttermdays", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.paymenttermdays = :paymenttermdays"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByPaymenttermdate", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.paymenttermdate = :paymenttermdate"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByGraceperiod", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.graceperiod = :graceperiod"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByPaymentmethod", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.paymentmethod = :paymentmethod"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByDffheadercontext", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.dffheadercontext = :dffheadercontext"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByContractnumber", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.contractnumber = :contractnumber"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByContextrentas", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.contextrentas = :contextrentas"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByLocalnumber", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.localnumber = :localnumber"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByLandtaxaccount", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.landtaxaccount = :landtaxaccount"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByReferencenumber", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.referencenumber = :referencenumber"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByRelatederpinvoice", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.relatederpinvoice = :relatederpinvoice"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByLegalinvoiceuse", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.legalinvoiceuse = :legalinvoiceuse"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByAddendum", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.addendum = :addendum"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByTipocobranza", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.tipocobranza = :tipocobranza"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByDivisiontype", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.divisiontype = :divisiontype"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByProjectid", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.projectid = :projectid"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByGenerationtype", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.generationtype = :generationtype"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByFolioavisocargo", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.folioavisocargo = :folioavisocargo"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByGrouptype", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.grouptype = :grouptype"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByBankname", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.bankname = :bankname"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByBankaccountnumber", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.bankaccountnumber = :bankaccountnumber"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByTotalamount", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.totalamount = :totalamount"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByIdlineacaptura", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.idlineacaptura = :idlineacaptura"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByEstadoprocesamiento", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.estadoprocesamiento = :estadoprocesamiento"),
    @NamedQuery(name = "XxfrCabeceraFactura.findByIdbatch", query = "SELECT x FROM XxfrCabeceraFactura x WHERE x.idbatch = :idbatch")})
public class XxfrCabeceraFactura implements Serializable {

    @Column(name = "CUSTOMERID")
    private BigInteger customerid;
    @Column(name = "SITEID")
    private BigInteger siteid;
    @Size(max = 20)
    @Column(name = "TRANSACTIONID")
    private String transactionid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "xxfrCabeceraFactura", fetch = FetchType.LAZY)
    private List<XxfrInvoiceLines> xxfrInvoiceLinesList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigDecimal idfacturaprimavera;
    @Size(max = 20)
    @Column(name = "FACILITYNUMBER")
    private String facilitynumber;
    @Column(name = "COMPANYACCOUNTCODE")
    private Long companyaccountcode;
    @Size(max = 20)
    @Column(name = "BUSINESSUNITNAME")
    private String businessunitname;
    @Size(max = 20)
    @Column(name = "TRANSACTIONSOURCE")
    private String transactionsource;
    @Size(max = 20)
    @Column(name = "TRANSACTIONTYPE")
    private String transactiontype;
    @Column(name = "CREATIONDATETRX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdatetrx;
    @Column(name = "CREATIONDATEGL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdategl;
    @Size(max = 20)
    @Column(name = "CURRENCY")
    private String currency;
    @Size(max = 20)
    @Column(name = "CONVERSIONRATETYPE")
    private String conversionratetype;
    @Size(max = 20)
    @Column(name = "CONVERSIONRATEVALUE")
    private String conversionratevalue;
    @Size(max = 240)
    @Column(name = "BILLTOCONSUMERNAME")
    private String billtoconsumername;
    @Column(name = "BILLTOLOCATION")
    private Long billtolocation;
    @Column(name = "PAYMENTTERMDAYS")
    private Short paymenttermdays;
    @Size(max = 20)
    @Column(name = "PAYMENTTERMDATE")
    private String paymenttermdate;
    @Column(name = "GRACEPERIOD")
    private Short graceperiod;
    @Size(max = 10)
    @Column(name = "PAYMENTMETHOD")
    private String paymentmethod;
    @Size(max = 20)
    @Column(name = "DFFHEADERCONTEXT")
    private String dffheadercontext;
    @Column(name = "CONTRACTNUMBER")
    private Long contractnumber;
    @Size(max = 20)
    @Column(name = "CONTEXTRENTAS")
    private String contextrentas;
    @Size(max = 20)
    @Column(name = "LOCALNUMBER")
    private String localnumber;
    @Size(max = 20)
    @Column(name = "LANDTAXACCOUNT")
    private String landtaxaccount;
    @Size(max = 20)
    @Column(name = "REFERENCENUMBER")
    private String referencenumber;
    @Size(max = 20)
    @Column(name = "RELATEDERPINVOICE")
    private String relatederpinvoice;
    @Size(max = 20)
    @Column(name = "LEGALINVOICEUSE")
    private String legalinvoiceuse;
    @Size(max = 20)
    @Column(name = "ADDENDUM")
    private String addendum;
    @Size(max = 20)
    @Column(name = "TIPOCOBRANZA")
    private String tipocobranza;
    @Size(max = 20)
    @Column(name = "DIVISIONTYPE")
    private String divisiontype;
    @Column(name = "PROJECTID")
    private Long projectid;
    @Size(max = 21)
    @Column(name = "GENERATIONTYPE")
    private String generationtype;
    @Size(max = 20)
    @Column(name = "FOLIOAVISOCARGO")
    private String folioavisocargo;
    @Size(max = 20)
    @Column(name = "GROUPTYPE")
    private String grouptype;
    @Size(max = 20)
    @Column(name = "BANKNAME")
    private String bankname;
    @Size(max = 20)
    @Column(name = "BANKACCOUNTNUMBER")
    private String bankaccountnumber;
    @Column(name = "TOTALAMOUNT")
    private BigDecimal totalamount;
    @Size(max = 20)
    @Column(name = "IDLINEACAPTURA")
    private String idlineacaptura;
    @Size(max = 20)
    @Column(name = "ESTADOPROCESAMIENTO")
    private String estadoprocesamiento;
    @Size(max = 20)
    @Column(name = "IDBATCH")
    private String idbatch;
    @OneToMany(mappedBy = "idfacturaprimavera", fetch = FetchType.LAZY)
    private List<XxfrLineaCapturaFactura> xxfrLineaCapturaFacturaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "xxfrCabeceraFactura", fetch = FetchType.LAZY)
    private XxfrtNotaCredito xxfrtNotaCredito;

    public XxfrCabeceraFactura() {
    }

    public XxfrCabeceraFactura(BigDecimal idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public BigDecimal getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigDecimal idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getFacilitynumber() {
        return facilitynumber;
    }

    public void setFacilitynumber(String facilitynumber) {
        this.facilitynumber = facilitynumber;
    }

    public Long getCompanyaccountcode() {
        return companyaccountcode;
    }

    public void setCompanyaccountcode(Long companyaccountcode) {
        this.companyaccountcode = companyaccountcode;
    }

    public String getBusinessunitname() {
        return businessunitname;
    }

    public void setBusinessunitname(String businessunitname) {
        this.businessunitname = businessunitname;
    }

    public String getTransactionsource() {
        return transactionsource;
    }

    public void setTransactionsource(String transactionsource) {
        this.transactionsource = transactionsource;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public Date getCreationdatetrx() {
        return creationdatetrx;
    }

    public void setCreationdatetrx(Date creationdatetrx) {
        this.creationdatetrx = creationdatetrx;
    }

    public Date getCreationdategl() {
        return creationdategl;
    }

    public void setCreationdategl(Date creationdategl) {
        this.creationdategl = creationdategl;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getConversionratetype() {
        return conversionratetype;
    }

    public void setConversionratetype(String conversionratetype) {
        this.conversionratetype = conversionratetype;
    }

    public String getConversionratevalue() {
        return conversionratevalue;
    }

    public void setConversionratevalue(String conversionratevalue) {
        this.conversionratevalue = conversionratevalue;
    }

    public String getBilltoconsumername() {
        return billtoconsumername;
    }

    public void setBilltoconsumername(String billtoconsumername) {
        this.billtoconsumername = billtoconsumername;
    }

    public Long getBilltolocation() {
        return billtolocation;
    }

    public void setBilltolocation(Long billtolocation) {
        this.billtolocation = billtolocation;
    }

    public Short getPaymenttermdays() {
        return paymenttermdays;
    }

    public void setPaymenttermdays(Short paymenttermdays) {
        this.paymenttermdays = paymenttermdays;
    }

    public String getPaymenttermdate() {
        return paymenttermdate;
    }

    public void setPaymenttermdate(String paymenttermdate) {
        this.paymenttermdate = paymenttermdate;
    }

    public Short getGraceperiod() {
        return graceperiod;
    }

    public void setGraceperiod(Short graceperiod) {
        this.graceperiod = graceperiod;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getDffheadercontext() {
        return dffheadercontext;
    }

    public void setDffheadercontext(String dffheadercontext) {
        this.dffheadercontext = dffheadercontext;
    }

    public Long getContractnumber() {
        return contractnumber;
    }

    public void setContractnumber(Long contractnumber) {
        this.contractnumber = contractnumber;
    }

    public String getContextrentas() {
        return contextrentas;
    }

    public void setContextrentas(String contextrentas) {
        this.contextrentas = contextrentas;
    }

    public String getLocalnumber() {
        return localnumber;
    }

    public void setLocalnumber(String localnumber) {
        this.localnumber = localnumber;
    }

    public String getLandtaxaccount() {
        return landtaxaccount;
    }

    public void setLandtaxaccount(String landtaxaccount) {
        this.landtaxaccount = landtaxaccount;
    }

    public String getReferencenumber() {
        return referencenumber;
    }

    public void setReferencenumber(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public String getRelatederpinvoice() {
        return relatederpinvoice;
    }

    public void setRelatederpinvoice(String relatederpinvoice) {
        this.relatederpinvoice = relatederpinvoice;
    }

    public String getLegalinvoiceuse() {
        return legalinvoiceuse;
    }

    public void setLegalinvoiceuse(String legalinvoiceuse) {
        this.legalinvoiceuse = legalinvoiceuse;
    }

    public String getAddendum() {
        return addendum;
    }

    public void setAddendum(String addendum) {
        this.addendum = addendum;
    }

    public String getTipocobranza() {
        return tipocobranza;
    }

    public void setTipocobranza(String tipocobranza) {
        this.tipocobranza = tipocobranza;
    }

    public String getDivisiontype() {
        return divisiontype;
    }

    public void setDivisiontype(String divisiontype) {
        this.divisiontype = divisiontype;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public String getGenerationtype() {
        return generationtype;
    }

    public void setGenerationtype(String generationtype) {
        this.generationtype = generationtype;
    }

    public String getFolioavisocargo() {
        return folioavisocargo;
    }

    public void setFolioavisocargo(String folioavisocargo) {
        this.folioavisocargo = folioavisocargo;
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBankaccountnumber() {
        return bankaccountnumber;
    }

    public void setBankaccountnumber(String bankaccountnumber) {
        this.bankaccountnumber = bankaccountnumber;
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

    public String getEstadoprocesamiento() {
        return estadoprocesamiento;
    }

    public void setEstadoprocesamiento(String estadoprocesamiento) {
        this.estadoprocesamiento = estadoprocesamiento;
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    @XmlTransient
    public List<XxfrLineaCapturaFactura> getXxfrLineaCapturaFacturaList() {
        return xxfrLineaCapturaFacturaList;
    }

    public void setXxfrLineaCapturaFacturaList(List<XxfrLineaCapturaFactura> xxfrLineaCapturaFacturaList) {
        this.xxfrLineaCapturaFacturaList = xxfrLineaCapturaFacturaList;
    }

    public XxfrtNotaCredito getXxfrtNotaCredito() {
        return xxfrtNotaCredito;
    }

    public void setXxfrtNotaCredito(XxfrtNotaCredito xxfrtNotaCredito) {
        this.xxfrtNotaCredito = xxfrtNotaCredito;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturaprimavera != null ? idfacturaprimavera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrCabeceraFactura)) {
            return false;
        }
        XxfrCabeceraFactura other = (XxfrCabeceraFactura) object;
        if ((this.idfacturaprimavera == null && other.idfacturaprimavera != null) || (this.idfacturaprimavera != null && !this.idfacturaprimavera.equals(other.idfacturaprimavera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrCabeceraFactura[ idfacturaprimavera=" + idfacturaprimavera + " ]";
    }

    public BigInteger getCustomerid() {
        return customerid;
    }

    public void setCustomerid(BigInteger customerid) {
        this.customerid = customerid;
    }

    public BigInteger getSiteid() {
        return siteid;
    }

    public void setSiteid(BigInteger siteid) {
        this.siteid = siteid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    @XmlTransient
    public List<XxfrInvoiceLines> getXxfrInvoiceLinesList() {
        return xxfrInvoiceLinesList;
    }

    public void setXxfrInvoiceLinesList(List<XxfrInvoiceLines> xxfrInvoiceLinesList) {
        this.xxfrInvoiceLinesList = xxfrInvoiceLinesList;
    }
    
}
