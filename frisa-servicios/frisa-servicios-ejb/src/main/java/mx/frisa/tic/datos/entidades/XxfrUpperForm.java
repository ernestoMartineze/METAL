/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author soultech
 */
@Entity
@Table(name = "XXFR_UPPER_FORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrUpperForm.findAll", query = "SELECT x FROM XxfrUpperForm x")
    , @NamedQuery(name = "XxfrUpperForm.findByIdfacturaprimavera", query = "SELECT x FROM XxfrUpperForm x WHERE x.idfacturaprimavera = :idfacturaprimavera")
    , @NamedQuery(name = "XxfrUpperForm.findByFacilitynumber", query = "SELECT x FROM XxfrUpperForm x WHERE x.facilitynumber = :facilitynumber")
    , @NamedQuery(name = "XxfrUpperForm.findByCompanyaccountcode", query = "SELECT x FROM XxfrUpperForm x WHERE x.companyaccountcode = :companyaccountcode")
    , @NamedQuery(name = "XxfrUpperForm.findByBusinessunitname", query = "SELECT x FROM XxfrUpperForm x WHERE x.businessunitname = :businessunitname")
    , @NamedQuery(name = "XxfrUpperForm.findByTransactionsource", query = "SELECT x FROM XxfrUpperForm x WHERE x.transactionsource = :transactionsource")
    , @NamedQuery(name = "XxfrUpperForm.findByTransactiontype", query = "SELECT x FROM XxfrUpperForm x WHERE x.transactiontype = :transactiontype")
    , @NamedQuery(name = "XxfrUpperForm.findByCreationdatetrx", query = "SELECT x FROM XxfrUpperForm x WHERE x.creationdatetrx = :creationdatetrx")
    , @NamedQuery(name = "XxfrUpperForm.findByCreationdategl", query = "SELECT x FROM XxfrUpperForm x WHERE x.creationdategl = :creationdategl")
    , @NamedQuery(name = "XxfrUpperForm.findByCurrency", query = "SELECT x FROM XxfrUpperForm x WHERE x.currency = :currency")
    , @NamedQuery(name = "XxfrUpperForm.findByConversionratetype", query = "SELECT x FROM XxfrUpperForm x WHERE x.conversionratetype = :conversionratetype")
    , @NamedQuery(name = "XxfrUpperForm.findByConversionratevalue", query = "SELECT x FROM XxfrUpperForm x WHERE x.conversionratevalue = :conversionratevalue")
    , @NamedQuery(name = "XxfrUpperForm.findByBilltoconsumername", query = "SELECT x FROM XxfrUpperForm x WHERE x.billtoconsumername = :billtoconsumername")
    , @NamedQuery(name = "XxfrUpperForm.findByBilltolocation", query = "SELECT x FROM XxfrUpperForm x WHERE x.billtolocation = :billtolocation")
    , @NamedQuery(name = "XxfrUpperForm.findByPaymenttermdays", query = "SELECT x FROM XxfrUpperForm x WHERE x.paymenttermdays = :paymenttermdays")
    , @NamedQuery(name = "XxfrUpperForm.findByPaymenttermdate", query = "SELECT x FROM XxfrUpperForm x WHERE x.paymenttermdate = :paymenttermdate")
    , @NamedQuery(name = "XxfrUpperForm.findByGraceperiod", query = "SELECT x FROM XxfrUpperForm x WHERE x.graceperiod = :graceperiod")
    , @NamedQuery(name = "XxfrUpperForm.findByPaymentmethod", query = "SELECT x FROM XxfrUpperForm x WHERE x.paymentmethod = :paymentmethod")
    , @NamedQuery(name = "XxfrUpperForm.findByDffheadercontext", query = "SELECT x FROM XxfrUpperForm x WHERE x.dffheadercontext = :dffheadercontext")
    , @NamedQuery(name = "XxfrUpperForm.findByContractnumber", query = "SELECT x FROM XxfrUpperForm x WHERE x.contractnumber = :contractnumber")
    , @NamedQuery(name = "XxfrUpperForm.findByContextrentas", query = "SELECT x FROM XxfrUpperForm x WHERE x.contextrentas = :contextrentas")
    , @NamedQuery(name = "XxfrUpperForm.findByLocalnumber", query = "SELECT x FROM XxfrUpperForm x WHERE x.localnumber = :localnumber")
    , @NamedQuery(name = "XxfrUpperForm.findByLandtaxaccount", query = "SELECT x FROM XxfrUpperForm x WHERE x.landtaxaccount = :landtaxaccount")
    , @NamedQuery(name = "XxfrUpperForm.findByReferencenumber", query = "SELECT x FROM XxfrUpperForm x WHERE x.referencenumber = :referencenumber")
    , @NamedQuery(name = "XxfrUpperForm.findByRelatederpinvoice", query = "SELECT x FROM XxfrUpperForm x WHERE x.relatederpinvoice = :relatederpinvoice")
    , @NamedQuery(name = "XxfrUpperForm.findByLegalinvoiceuse", query = "SELECT x FROM XxfrUpperForm x WHERE x.legalinvoiceuse = :legalinvoiceuse")
    , @NamedQuery(name = "XxfrUpperForm.findByAddendum", query = "SELECT x FROM XxfrUpperForm x WHERE x.addendum = :addendum")
    , @NamedQuery(name = "XxfrUpperForm.findByTipocobranza", query = "SELECT x FROM XxfrUpperForm x WHERE x.tipocobranza = :tipocobranza")
    , @NamedQuery(name = "XxfrUpperForm.findByDivisiontype", query = "SELECT x FROM XxfrUpperForm x WHERE x.divisiontype = :divisiontype")
    , @NamedQuery(name = "XxfrUpperForm.findByProjectid", query = "SELECT x FROM XxfrUpperForm x WHERE x.projectid = :projectid")
    , @NamedQuery(name = "XxfrUpperForm.findByGenerationtype", query = "SELECT x FROM XxfrUpperForm x WHERE x.generationtype = :generationtype")
    , @NamedQuery(name = "XxfrUpperForm.findByFolioavisocargo", query = "SELECT x FROM XxfrUpperForm x WHERE x.folioavisocargo = :folioavisocargo")
    , @NamedQuery(name = "XxfrUpperForm.findByGrouptype", query = "SELECT x FROM XxfrUpperForm x WHERE x.grouptype = :grouptype")
    , @NamedQuery(name = "XxfrUpperForm.findByBankname", query = "SELECT x FROM XxfrUpperForm x WHERE x.bankname = :bankname")
    , @NamedQuery(name = "XxfrUpperForm.findByBankaccountnumber", query = "SELECT x FROM XxfrUpperForm x WHERE x.bankaccountnumber = :bankaccountnumber")
    , @NamedQuery(name = "XxfrUpperForm.findByTotalamount", query = "SELECT x FROM XxfrUpperForm x WHERE x.totalamount = :totalamount")
    , @NamedQuery(name = "XxfrUpperForm.findByIdlineacaptura", query = "SELECT x FROM XxfrUpperForm x WHERE x.idlineacaptura = :idlineacaptura")
    , @NamedQuery(name = "XxfrUpperForm.findByEstadoprocesamiento", query = "SELECT x FROM XxfrUpperForm x WHERE x.estadoprocesamiento = :estadoprocesamiento")
    , @NamedQuery(name = "XxfrUpperForm.findByIdbatch", query = "SELECT x FROM XxfrUpperForm x WHERE x.idbatch = :idbatch")})
public class XxfrUpperForm implements Serializable {

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
    @Size(max = 20)
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

    public XxfrUpperForm() {
    }

    public XxfrUpperForm(BigDecimal idfacturaprimavera) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturaprimavera != null ? idfacturaprimavera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrUpperForm)) {
            return false;
        }
        XxfrUpperForm other = (XxfrUpperForm) object;
        if ((this.idfacturaprimavera == null && other.idfacturaprimavera != null) || (this.idfacturaprimavera != null && !this.idfacturaprimavera.equals(other.idfacturaprimavera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrUpperForm[ idfacturaprimavera=" + idfacturaprimavera + " ]";
    }
    
}
