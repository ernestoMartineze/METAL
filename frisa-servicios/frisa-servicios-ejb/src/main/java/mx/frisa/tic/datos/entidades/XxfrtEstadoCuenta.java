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
    @NamedQuery(name = "XxfrtEstadoCuenta.findByTrxDate", query = "SELECT x FROM XxfrtEstadoCuenta x WHERE x.trxDate = :trxDate"),
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

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_EDO_CTA")
    private BigDecimal idEdoCta;
    @Column(name = "BANK_ACCOUNT_NUM")
    private BigDecimal bankAccountNum;
    @Column(name = "TRX_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trxDate;
    @Column(name = "LINE_NUMBER")
    private BigDecimal lineNumber;
    @Size(max = 30)
    @Column(name = "TRX_TYPE")
    private String trxType;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "TRX_CODE")
    private BigDecimal trxCode;
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
    private BigDecimal idLineaCaptura;

    public XxfrtEstadoCuenta() {
    }

    public XxfrtEstadoCuenta(BigDecimal idEdoCta) {
        this.idEdoCta = idEdoCta;
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

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public BigDecimal getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(BigDecimal lineNumber) {
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

    public BigDecimal getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(BigDecimal trxCode) {
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

    public BigDecimal getIdLineaCaptura() {
        return idLineaCaptura;
    }

    public void setIdLineaCaptura(BigDecimal idLineaCaptura) {
        this.idLineaCaptura = idLineaCaptura;
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
    
}