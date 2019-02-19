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
 * @author USER_1
 */
@Entity
@Table(name = "XXFRV_ESTADOCTA_USR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvEstadoctaUsr.findAll", query = "SELECT x FROM XxfrvEstadoctaUsr x"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByIdEdoCta", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.idEdoCta = :idEdoCta"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByBankAccountNum", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.bankAccountNum = :bankAccountNum"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByGlDate", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.glDate = :glDate"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByLineNumber", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.lineNumber = :lineNumber"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByTrxType", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.trxType = :trxType"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByAmount", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.amount = :amount"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByTrxCode", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.trxCode = :trxCode"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByCurrencyCode", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.currencyCode = :currencyCode"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByCustomerReference", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.customerReference = :customerReference"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByAddiotionalEntryInformation", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.addiotionalEntryInformation = :addiotionalEntryInformation"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByProyectoPropietario", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.proyectoPropietario = :proyectoPropietario"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByLineCapture", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.lineCapture = :lineCapture"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByIdLineaCaptura", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.idLineaCaptura = :idLineaCaptura"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByRmethodid", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.rmethodid = :rmethodid"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByStatementHeaderId", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.statementHeaderId = :statementHeaderId"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByStatementLineId", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.statementLineId = :statementLineId"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByBankAccountId", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.bankAccountId = :bankAccountId"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByStmtFromDate", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.stmtFromDate = :stmtFromDate"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByStmtToDate", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.stmtToDate = :stmtToDate"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByStatementNumber", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.statementNumber = :statementNumber"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByDescripLookup", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.descripLookup = :descripLookup"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByCashreceiptid", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.cashreceiptid = :cashreceiptid"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByFecharegistroreciboerp", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.fecharegistroreciboerp = :fecharegistroreciboerp"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByReceiptMethodId", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.receiptMethodId = :receiptMethodId"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByUuid", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.uuid = :uuid"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByNombrecliente", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.nombrecliente = :nombrecliente"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByBusinessunitname", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.businessunitname = :businessunitname"),
    @NamedQuery(name = "XxfrvEstadoctaUsr.findByUsuario", query = "SELECT x FROM XxfrvEstadoctaUsr x WHERE x.usuario = :usuario")})
public class XxfrvEstadoctaUsr implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EDO_CTA")
    private BigDecimal idEdoCta;
    @Column(name = "BANK_ACCOUNT_NUM")
    private BigDecimal bankAccountNum;
    @Column(name = "GL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date glDate;
    @Column(name = "LINE_NUMBER")
    private BigInteger lineNumber;
    @Size(max = 30)
    @Column(name = "TRX_TYPE")
    private String trxType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "TRX_CODE")
    private BigInteger trxCode;
    @Size(max = 3)
    @Column(name = "CURRENCY_CODE")
    private String currencyCode;
    @Size(max = 30)
    @Column(name = "CUSTOMER_REFERENCE")
    private String customerReference;
    @Size(max = 300)
    @Column(name = "ADDIOTIONAL_ENTRY_INFORMATION")
    private String addiotionalEntryInformation;
    @Size(max = 3)
    @Column(name = "PROYECTO_PROPIETARIO")
    private String proyectoPropietario;
    @Size(max = 30)
    @Column(name = "LINE_CAPTURE")
    private String lineCapture;
    @Column(name = "ID_LINEA_CAPTURA")
    private BigInteger idLineaCaptura;
    @Column(name = "RMETHODID")
    private BigInteger rmethodid;
    @Size(max = 30)
    @Column(name = "STATEMENT_HEADER_ID")
    private String statementHeaderId;
    @Size(max = 30)
    @Column(name = "STATEMENT_LINE_ID")
    private String statementLineId;
    @Size(max = 30)
    @Column(name = "BANK_ACCOUNT_ID")
    private String bankAccountId;
    @Column(name = "STMT_FROM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stmtFromDate;
    @Column(name = "STMT_TO_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date stmtToDate;
    @Column(name = "STATEMENT_NUMBER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statementNumber;
    @Size(max = 30)
    @Column(name = "DESCRIP_LOOKUP")
    private String descripLookup;
    @Column(name = "CASHRECEIPTID")
    private BigInteger cashreceiptid;
    @Column(name = "FECHAREGISTRORECIBOERP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistroreciboerp;
    @Size(max = 50)
    @Column(name = "RECEIPT_METHOD_ID")
    private String receiptMethodId;
    @Size(max = 80)
    @Column(name = "UUID")
    private String uuid;
    @Size(max = 120)
    @Column(name = "NOMBRECLIENTE")
    private String nombrecliente;
    @Size(max = 120)
    @Column(name = "BUSINESSUNITNAME")
    private String businessunitname;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;

    public XxfrvEstadoctaUsr() {
    }

    

    public Date getGlDate() {
        return glDate;
    }

    public void setGlDate(Date glDate) {
        this.glDate = glDate;
    }

    public BigInteger getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(BigInteger lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigInteger getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(BigInteger trxCode) {
        this.trxCode = trxCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getAddiotionalEntryInformation() {
        return addiotionalEntryInformation;
    }

    public void setAddiotionalEntryInformation(String addiotionalEntryInformation) {
        this.addiotionalEntryInformation = addiotionalEntryInformation;
    }

    public String getProyectoPropietario() {
        return proyectoPropietario;
    }

    public void setProyectoPropietario(String proyectoPropietario) {
        this.proyectoPropietario = proyectoPropietario;
    }

    public String getLineCapture() {
        return lineCapture;
    }

    public void setLineCapture(String lineCapture) {
        this.lineCapture = lineCapture;
    }

    public BigInteger getIdLineaCaptura() {
        return idLineaCaptura;
    }

    public void setIdLineaCaptura(BigInteger idLineaCaptura) {
        this.idLineaCaptura = idLineaCaptura;
    }

    public BigInteger getRmethodid() {
        return rmethodid;
    }

    public void setRmethodid(BigInteger rmethodid) {
        this.rmethodid = rmethodid;
    }

    public String getStatementHeaderId() {
        return statementHeaderId;
    }

    public void setStatementHeaderId(String statementHeaderId) {
        this.statementHeaderId = statementHeaderId;
    }

    public String getStatementLineId() {
        return statementLineId;
    }

    public void setStatementLineId(String statementLineId) {
        this.statementLineId = statementLineId;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Date getStmtFromDate() {
        return stmtFromDate;
    }

    public void setStmtFromDate(Date stmtFromDate) {
        this.stmtFromDate = stmtFromDate;
    }

    public Date getStmtToDate() {
        return stmtToDate;
    }

    public void setStmtToDate(Date stmtToDate) {
        this.stmtToDate = stmtToDate;
    }

    public Date getStatementNumber() {
        return statementNumber;
    }

    public void setStatementNumber(Date statementNumber) {
        this.statementNumber = statementNumber;
    }

    public String getDescripLookup() {
        return descripLookup;
    }

    public void setDescripLookup(String descripLookup) {
        this.descripLookup = descripLookup;
    }

    public BigInteger getCashreceiptid() {
        return cashreceiptid;
    }

    public void setCashreceiptid(BigInteger cashreceiptid) {
        this.cashreceiptid = cashreceiptid;
    }

    public Date getFecharegistroreciboerp() {
        return fecharegistroreciboerp;
    }

    public void setFecharegistroreciboerp(Date fecharegistroreciboerp) {
        this.fecharegistroreciboerp = fecharegistroreciboerp;
    }

    public String getReceiptMethodId() {
        return receiptMethodId;
    }

    public void setReceiptMethodId(String receiptMethodId) {
        this.receiptMethodId = receiptMethodId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getBusinessunitname() {
        return businessunitname;
    }

    public void setBusinessunitname(String businessunitname) {
        this.businessunitname = businessunitname;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getIdEdoCta() {
        return idEdoCta;
    }

    public void setIdEdoCta(BigDecimal idEdoCta) {
        this.idEdoCta = idEdoCta;
    }

    public BigDecimal getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(BigDecimal bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }
    
}
