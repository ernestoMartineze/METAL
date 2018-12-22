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
 * @author Soultech
 */
@Entity
@Table(name = "XXFRT_NOTA_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtNotaCredito.findAll", query = "SELECT x FROM XxfrtNotaCredito x")
    , @NamedQuery(name = "XxfrtNotaCredito.findByBatchsourcesequenceid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.batchsourcesequenceid = :batchsourcesequenceid")
    , @NamedQuery(name = "XxfrtNotaCredito.findByCustomertransactionid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.customertransactionid = :customertransactionid")
    , @NamedQuery(name = "XxfrtNotaCredito.findByComments", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.comments = :comments")
    , @NamedQuery(name = "XxfrtNotaCredito.findByCustomertrxtypesequenceid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.customertrxtypesequenceid = :customertrxtypesequenceid")
    , @NamedQuery(name = "XxfrtNotaCredito.findByCustomerreference", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.customerreference = :customerreference")
    , @NamedQuery(name = "XxfrtNotaCredito.findByCustomerreferencedate", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.customerreferencedate = :customerreferencedate")
    , @NamedQuery(name = "XxfrtNotaCredito.findByDocumentsequenceid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.documentsequenceid = :documentsequenceid")
    , @NamedQuery(name = "XxfrtNotaCredito.findByDocumentsequencevalue", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.documentsequencevalue = :documentsequencevalue")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFreightamount", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.freightamount = :freightamount")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFreightpercent", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.freightpercent = :freightpercent")
    , @NamedQuery(name = "XxfrtNotaCredito.findByGldate", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.gldate = :gldate")
    , @NamedQuery(name = "XxfrtNotaCredito.findByInternalnotes", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.internalnotes = :internalnotes")
    , @NamedQuery(name = "XxfrtNotaCredito.findByLineamount", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.lineamount = :lineamount")
    , @NamedQuery(name = "XxfrtNotaCredito.findByLinepercent", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.linepercent = :linepercent")
    , @NamedQuery(name = "XxfrtNotaCredito.findByMethodforrules", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.methodforrules = :methodforrules")
    , @NamedQuery(name = "XxfrtNotaCredito.findByPreviouscustomertransactionid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.previouscustomertransactionid = :previouscustomertransactionid")
    , @NamedQuery(name = "XxfrtNotaCredito.findByReasoncode", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.reasoncode = :reasoncode")
    , @NamedQuery(name = "XxfrtNotaCredito.findBySplitterminationmethod", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.splitterminationmethod = :splitterminationmethod")
    , @NamedQuery(name = "XxfrtNotaCredito.findByTransactiondate", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.transactiondate = :transactiondate")
    , @NamedQuery(name = "XxfrtNotaCredito.findByCurrencycode", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.currencycode = :currencycode")
    , @NamedQuery(name = "XxfrtNotaCredito.findByTransactionnumber", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.transactionnumber = :transactionnumber")
    , @NamedQuery(name = "XxfrtNotaCredito.findByTaxamount", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.taxamount = :taxamount")
    , @NamedQuery(name = "XxfrtNotaCredito.findByTaxpercent", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.taxpercent = :taxpercent")
    , @NamedQuery(name = "XxfrtNotaCredito.findByComputetax", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.computetax = :computetax")
    , @NamedQuery(name = "XxfrtNotaCredito.findByCustomertrxid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.customertrxid = :customertrxid")
    , @NamedQuery(name = "XxfrtNotaCredito.findByProyecto", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.proyecto = :proyecto")
    , @NamedQuery(name = "XxfrtNotaCredito.findByEstatusdecfdi", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.estatusdecfdi = :estatusdecfdi")
    , @NamedQuery(name = "XxfrtNotaCredito.findByUsodecfdi", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.usodecfdi = :usodecfdi")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFormadepago", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.formadepago = :formadepago")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFoliodecancelacionsat", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.foliodecancelacionsat = :foliodecancelacionsat")
    , @NamedQuery(name = "XxfrtNotaCredito.findByUuiddocumentorelacionado", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.uuiddocumentorelacionado = :uuiddocumentorelacionado")
    , @NamedQuery(name = "XxfrtNotaCredito.findByNumerodecontrato", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.numerodecontrato = :numerodecontrato")
    , @NamedQuery(name = "XxfrtNotaCredito.findByLineadecaptura", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.lineadecaptura = :lineadecaptura")
    , @NamedQuery(name = "XxfrtNotaCredito.findBySerie", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.serie = :serie")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFolio", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.folio = :folio")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFechadeprescripcion", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.fechadeprescripcion = :fechadeprescripcion")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFechatimbrado", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.fechatimbrado = :fechatimbrado")
    , @NamedQuery(name = "XxfrtNotaCredito.findByAddendaid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.addendaid = :addendaid")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFlexContext", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.flexContext = :flexContext")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFlexContextDisplayvalue", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.flexContextDisplayvalue = :flexContextDisplayvalue")
    , @NamedQuery(name = "XxfrtNotaCredito.findByFlexNumofsegments", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.flexNumofsegments = :flexNumofsegments")
    , @NamedQuery(name = "XxfrtNotaCredito.findByIdNotacredito", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.idNotacredito = :idNotacredito")
    , @NamedQuery(name = "XxfrtNotaCredito.findByEstadoErp", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.estadoErp = :estadoErp")})
public class XxfrtNotaCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "BATCHSOURCESEQUENCEID")
    private BigInteger batchsourcesequenceid;
    @Column(name = "CUSTOMERTRANSACTIONID")
    private BigInteger customertransactionid;
    @Size(max = 250)
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "CUSTOMERTRXTYPESEQUENCEID")
    private BigInteger customertrxtypesequenceid;
    @Size(max = 250)
    @Column(name = "CUSTOMERREFERENCE")
    private String customerreference;
    @Column(name = "CUSTOMERREFERENCEDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date customerreferencedate;
    @Column(name = "DOCUMENTSEQUENCEID")
    private BigInteger documentsequenceid;
    @Column(name = "DOCUMENTSEQUENCEVALUE")
    private BigInteger documentsequencevalue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FREIGHTAMOUNT")
    private BigDecimal freightamount;
    @Column(name = "FREIGHTPERCENT")
    private BigDecimal freightpercent;
    @Column(name = "GLDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gldate;
    @Size(max = 250)
    @Column(name = "INTERNALNOTES")
    private String internalnotes;
    @Column(name = "LINEAMOUNT")
    private BigDecimal lineamount;
    @Column(name = "LINEPERCENT")
    private BigDecimal linepercent;
    @Size(max = 250)
    @Column(name = "METHODFORRULES")
    private String methodforrules;
    @Column(name = "PREVIOUSCUSTOMERTRANSACTIONID")
    private BigInteger previouscustomertransactionid;
    @Size(max = 250)
    @Column(name = "REASONCODE")
    private String reasoncode;
    @Size(max = 250)
    @Column(name = "SPLITTERMINATIONMETHOD")
    private String splitterminationmethod;
    @Column(name = "TRANSACTIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactiondate;
    @Size(max = 5)
    @Column(name = "CURRENCYCODE")
    private String currencycode;
    @Size(max = 250)
    @Column(name = "TRANSACTIONNUMBER")
    private String transactionnumber;
    @Column(name = "TAXAMOUNT")
    private BigDecimal taxamount;
    @Column(name = "TAXPERCENT")
    private BigDecimal taxpercent;
    @Size(max = 250)
    @Column(name = "COMPUTETAX")
    private String computetax;
    @Column(name = "CUSTOMERTRXID")
    private BigDecimal customertrxid;
    @Size(max = 250)
    @Column(name = "PROYECTO")
    private String proyecto;
    @Size(max = 250)
    @Column(name = "ESTATUSDECFDI")
    private String estatusdecfdi;
    @Size(max = 250)
    @Column(name = "USODECFDI")
    private String usodecfdi;
    @Size(max = 250)
    @Column(name = "FORMADEPAGO")
    private String formadepago;
    @Size(max = 250)
    @Column(name = "FOLIODECANCELACIONSAT")
    private String foliodecancelacionsat;
    @Size(max = 250)
    @Column(name = "UUIDDOCUMENTORELACIONADO")
    private String uuiddocumentorelacionado;
    @Size(max = 250)
    @Column(name = "NUMERODECONTRATO")
    private String numerodecontrato;
    @Size(max = 250)
    @Column(name = "LINEADECAPTURA")
    private String lineadecaptura;
    @Size(max = 250)
    @Column(name = "SERIE")
    private String serie;
    @Size(max = 250)
    @Column(name = "FOLIO")
    private String folio;
    @Size(max = 250)
    @Column(name = "FECHADEPRESCRIPCION")
    private String fechadeprescripcion;
    @Size(max = 250)
    @Column(name = "FECHATIMBRADO")
    private String fechatimbrado;
    @Size(max = 250)
    @Column(name = "ADDENDAID")
    private String addendaid;
    @Size(max = 250)
    @Column(name = "FLEX_CONTEXT")
    private String flexContext;
    @Size(max = 250)
    @Column(name = "FLEX_CONTEXT_DISPLAYVALUE")
    private String flexContextDisplayvalue;
    @Column(name = "FLEX_NUMOFSEGMENTS")
    private BigInteger flexNumofsegments;
    @Id
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "ID_NOTACREDITO")
    private BigDecimal idNotacredito;
    @Size(max = 20)
    @Column(name = "ESTADO_ERP")
    private String estadoErp;

    public XxfrtNotaCredito() {
    }

    public XxfrtNotaCredito(BigDecimal idNotacredito) {
        this.idNotacredito = idNotacredito;
    }

    public BigInteger getBatchsourcesequenceid() {
        return batchsourcesequenceid;
    }

    public void setBatchsourcesequenceid(BigInteger batchsourcesequenceid) {
        this.batchsourcesequenceid = batchsourcesequenceid;
    }

    public BigInteger getCustomertransactionid() {
        return customertransactionid;
    }

    public void setCustomertransactionid(BigInteger customertransactionid) {
        this.customertransactionid = customertransactionid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigInteger getCustomertrxtypesequenceid() {
        return customertrxtypesequenceid;
    }

    public void setCustomertrxtypesequenceid(BigInteger customertrxtypesequenceid) {
        this.customertrxtypesequenceid = customertrxtypesequenceid;
    }

    public String getCustomerreference() {
        return customerreference;
    }

    public void setCustomerreference(String customerreference) {
        this.customerreference = customerreference;
    }

    public Date getCustomerreferencedate() {
        return customerreferencedate;
    }

    public void setCustomerreferencedate(Date customerreferencedate) {
        this.customerreferencedate = customerreferencedate;
    }

    public BigInteger getDocumentsequenceid() {
        return documentsequenceid;
    }

    public void setDocumentsequenceid(BigInteger documentsequenceid) {
        this.documentsequenceid = documentsequenceid;
    }

    public BigInteger getDocumentsequencevalue() {
        return documentsequencevalue;
    }

    public void setDocumentsequencevalue(BigInteger documentsequencevalue) {
        this.documentsequencevalue = documentsequencevalue;
    }

    public BigDecimal getFreightamount() {
        return freightamount;
    }

    public void setFreightamount(BigDecimal freightamount) {
        this.freightamount = freightamount;
    }

    public BigDecimal getFreightpercent() {
        return freightpercent;
    }

    public void setFreightpercent(BigDecimal freightpercent) {
        this.freightpercent = freightpercent;
    }

    public Date getGldate() {
        return gldate;
    }

    public void setGldate(Date gldate) {
        this.gldate = gldate;
    }

    public String getInternalnotes() {
        return internalnotes;
    }

    public void setInternalnotes(String internalnotes) {
        this.internalnotes = internalnotes;
    }

    public BigDecimal getLineamount() {
        return lineamount;
    }

    public void setLineamount(BigDecimal lineamount) {
        this.lineamount = lineamount;
    }

    public BigDecimal getLinepercent() {
        return linepercent;
    }

    public void setLinepercent(BigDecimal linepercent) {
        this.linepercent = linepercent;
    }

    public String getMethodforrules() {
        return methodforrules;
    }

    public void setMethodforrules(String methodforrules) {
        this.methodforrules = methodforrules;
    }

    public BigInteger getPreviouscustomertransactionid() {
        return previouscustomertransactionid;
    }

    public void setPreviouscustomertransactionid(BigInteger previouscustomertransactionid) {
        this.previouscustomertransactionid = previouscustomertransactionid;
    }

    public String getReasoncode() {
        return reasoncode;
    }

    public void setReasoncode(String reasoncode) {
        this.reasoncode = reasoncode;
    }

    public String getSplitterminationmethod() {
        return splitterminationmethod;
    }

    public void setSplitterminationmethod(String splitterminationmethod) {
        this.splitterminationmethod = splitterminationmethod;
    }

    public Date getTransactiondate() {
        return transactiondate;
    }

    public void setTransactiondate(Date transactiondate) {
        this.transactiondate = transactiondate;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getTransactionnumber() {
        return transactionnumber;
    }

    public void setTransactionnumber(String transactionnumber) {
        this.transactionnumber = transactionnumber;
    }

    public BigDecimal getTaxamount() {
        return taxamount;
    }

    public void setTaxamount(BigDecimal taxamount) {
        this.taxamount = taxamount;
    }

    public BigDecimal getTaxpercent() {
        return taxpercent;
    }

    public void setTaxpercent(BigDecimal taxpercent) {
        this.taxpercent = taxpercent;
    }

    public String getComputetax() {
        return computetax;
    }

    public void setComputetax(String computetax) {
        this.computetax = computetax;
    }

    public BigDecimal getCustomertrxid() {
        return customertrxid;
    }

    public void setCustomertrxid(BigDecimal customertrxid) {
        this.customertrxid = customertrxid;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getEstatusdecfdi() {
        return estatusdecfdi;
    }

    public void setEstatusdecfdi(String estatusdecfdi) {
        this.estatusdecfdi = estatusdecfdi;
    }

    public String getUsodecfdi() {
        return usodecfdi;
    }

    public void setUsodecfdi(String usodecfdi) {
        this.usodecfdi = usodecfdi;
    }

    public String getFormadepago() {
        return formadepago;
    }

    public void setFormadepago(String formadepago) {
        this.formadepago = formadepago;
    }

    public String getFoliodecancelacionsat() {
        return foliodecancelacionsat;
    }

    public void setFoliodecancelacionsat(String foliodecancelacionsat) {
        this.foliodecancelacionsat = foliodecancelacionsat;
    }

    public String getUuiddocumentorelacionado() {
        return uuiddocumentorelacionado;
    }

    public void setUuiddocumentorelacionado(String uuiddocumentorelacionado) {
        this.uuiddocumentorelacionado = uuiddocumentorelacionado;
    }

    public String getNumerodecontrato() {
        return numerodecontrato;
    }

    public void setNumerodecontrato(String numerodecontrato) {
        this.numerodecontrato = numerodecontrato;
    }

    public String getLineadecaptura() {
        return lineadecaptura;
    }

    public void setLineadecaptura(String lineadecaptura) {
        this.lineadecaptura = lineadecaptura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFechadeprescripcion() {
        return fechadeprescripcion;
    }

    public void setFechadeprescripcion(String fechadeprescripcion) {
        this.fechadeprescripcion = fechadeprescripcion;
    }

    public String getFechatimbrado() {
        return fechatimbrado;
    }

    public void setFechatimbrado(String fechatimbrado) {
        this.fechatimbrado = fechatimbrado;
    }

    public String getAddendaid() {
        return addendaid;
    }

    public void setAddendaid(String addendaid) {
        this.addendaid = addendaid;
    }

    public String getFlexContext() {
        return flexContext;
    }

    public void setFlexContext(String flexContext) {
        this.flexContext = flexContext;
    }

    public String getFlexContextDisplayvalue() {
        return flexContextDisplayvalue;
    }

    public void setFlexContextDisplayvalue(String flexContextDisplayvalue) {
        this.flexContextDisplayvalue = flexContextDisplayvalue;
    }

    public BigInteger getFlexNumofsegments() {
        return flexNumofsegments;
    }

    public void setFlexNumofsegments(BigInteger flexNumofsegments) {
        this.flexNumofsegments = flexNumofsegments;
    }

    public BigDecimal getIdNotacredito() {
        return idNotacredito;
    }

    public void setIdNotacredito(BigDecimal idNotacredito) {
        this.idNotacredito = idNotacredito;
    }

    public String getEstadoErp() {
        return estadoErp;
    }

    public void setEstadoErp(String estadoErp) {
        this.estadoErp = estadoErp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotacredito != null ? idNotacredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtNotaCredito)) {
            return false;
        }
        XxfrtNotaCredito other = (XxfrtNotaCredito) object;
        if ((this.idNotacredito == null && other.idNotacredito != null) || (this.idNotacredito != null && !this.idNotacredito.equals(other.idNotacredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtNotaCredito[ idNotacredito=" + idNotacredito + " ]";
    }
    
}
