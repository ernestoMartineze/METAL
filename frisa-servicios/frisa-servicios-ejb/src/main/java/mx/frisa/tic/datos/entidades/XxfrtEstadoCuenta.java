/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "XXFRT_ESTADO_CUENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtEstadoCuenta.findAll", query = "SELECT x FROM XxfrtEstadoCuenta x"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByIdEdoCta", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.idEdoCta = :idEdoCta"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByBankAccountNum", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.bankAccountNum = :bankAccountNum"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByLineNumber", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.lineNumber = :lineNumber"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByTrxType", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.trxType = :trxType"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByAmount", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.amount = :amount"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByTrxCode", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.trxCode = :trxCode"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByCurrencyCode", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.currencyCode = :currencyCode"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByCustomerReference", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.customerReference = :customerReference"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByAddiotionalEntryInformation", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.addiotionalEntryInformation = :addiotionalEntryInformation"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByProyectoPropietario", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.proyectoPropietario = :proyectoPropietario"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByLineCapture", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.lineCapture = :lineCapture"),
    @NamedQuery(name = "XxfrtEstadoCuenta.findByIdLineaCaptura", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.idLineaCaptura = :idLineaCaptura")})
public class XxfrtEstadoCuenta implements Serializable {

    @Column(name = "BANK_ACCOUNT_NUM")
    private BigDecimal bankAccountNum;
    @Column(name = "LINE_NUMBER")
    private BigDecimal lineNumber;
    @Column(name = "TRX_CODE")
    private BigDecimal trxCode;
    @Column(name = "ID_LINEA_CAPTURA")
    private BigDecimal idLineaCaptura;
    @Column(name = "RMETHODID")
    private BigDecimal rmethodid;
    @Column(name = "CASHRECEIPTID")
    private BigDecimal cashreceiptid;
    @Column(name = "FECHAREGISTRORECIBOERP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistroreciboerp;
    @Size(max = 50)
    @Column(name = "RECEIPT_METHOD_ID")
    private String receiptMethodId;
    @Column(name = "GL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date glDate;
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

    @Size(max = 80)
    @Column(name = "UUID")
    private String uuid;

    @Size(max = 120)
    @Column(name = "NOMBRECLIENTE")
    private String nombreCliente;

    @Size(max = 120)
    @Column(name = "BUSINESSUNITNAME")
    private String BUSINESSUNITNAME;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EDO_CTA")
    private BigDecimal idEdoCta;

    @Size(max = 30)
    @Column(name = "TRX_TYPE")
    private String trxType;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
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

    public XxfrtEstadoCuenta() {
    }

    public XxfrtEstadoCuenta(BigDecimal idEdoCta) {
        this.idEdoCta = idEdoCta;
    }

    public BigDecimal getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(BigDecimal bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public BigDecimal getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public BigDecimal getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(BigDecimal trxCode) {
        this.trxCode = trxCode;
    }

    public BigDecimal getIdLineaCaptura() {
        return idLineaCaptura;
    }

    public void setIdLineaCaptura(BigDecimal idLineaCaptura) {
        this.idLineaCaptura = idLineaCaptura;
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

    public Date getGlDate() {
        return glDate;
    }

    public void setGlDate(Date glDate) {
        this.glDate = glDate;
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

    public BigDecimal getIdEdoCta() {
        return idEdoCta;
    }

    public void setIdEdoCta(BigDecimal idEdoCta) {
        this.idEdoCta = idEdoCta;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEdoCta != null ? idEdoCta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtEstadoCuenta)) {
            return false;
        }
        XxfrtEstadoCuenta other = (XxfrtEstadoCuenta) object;
        if ((this.idEdoCta == null && other.idEdoCta != null) || (this.idEdoCta != null && !this.idEdoCta.equals(other.idEdoCta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtEstadoCuenta[ idEdoCta=" + idEdoCta + " ]";
    }

    public BigDecimal getRmethodid() {
        return rmethodid;
    }

    public void setRmethodid(BigDecimal rmethodid) {
        this.rmethodid = rmethodid;
    }

    public BigDecimal getCashreceiptid() {
        return cashreceiptid;
    }

    public void setCashreceiptid(BigDecimal cashreceiptid) {
        this.cashreceiptid = cashreceiptid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getBUSINESSUNITNAME() {
        return BUSINESSUNITNAME;
    }

    public void setBUSINESSUNITNAME(String BUSINESSUNITNAME) {
        this.BUSINESSUNITNAME = BUSINESSUNITNAME;
    }

}
