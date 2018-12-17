/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "XXFRC_ORGANIZACION_METODOPAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findAll", query = "SELECT x FROM XxfrcOrganizacionMetodopago x"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByOrgId", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.xxfrcOrganizacionMetodopagoPK.orgId = :orgId"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByBankAccountId", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.xxfrcOrganizacionMetodopagoPK.bankAccountId = :bankAccountId"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByReceiptMethodId", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.xxfrcOrganizacionMetodopagoPK.receiptMethodId = :receiptMethodId"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByReceiptMethodName", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.receiptMethodName = :receiptMethodName"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByFechaRegistro", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByRemitBankAcctUseId", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.remitBankAcctUseId = :remitBankAcctUseId"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByOrgbau", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.orgbau = :orgbau"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByBankAccountNum", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.bankAccountNum = :bankAccountNum"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByBankBranchId", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.bankBranchId = :bankBranchId"),
    @NamedQuery(name = "XxfrcOrganizacionMetodopago.findByOuName", query = "SELECT x FROM XxfrcOrganizacionMetodopago x WHERE x.ouName = :ouName")})

public class XxfrcOrganizacionMetodopago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XxfrcOrganizacionMetodopagoPK xxfrcOrganizacionMetodopagoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RECEIPT_METHOD_NAME")
    private String receiptMethodName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "REMIT_BANK_ACCT_USE_ID")
    private BigInteger remitBankAcctUseId;
    @Column(name = "ORGBAU")
    private BigInteger orgbau;
    @Column(name = "BANK_ACCOUNT_NUM")
    private BigInteger bankAccountNum;
    @Column(name = "BANK_BRANCH_ID")
    private BigInteger bankBranchId;
    @Size(max = 200)
    @Column(name = "OU_NAME")
    private String ouName;

    public XxfrcOrganizacionMetodopago() {
    }

    public XxfrcOrganizacionMetodopago(XxfrcOrganizacionMetodopagoPK xxfrcOrganizacionMetodopagoPK) {
        this.xxfrcOrganizacionMetodopagoPK = xxfrcOrganizacionMetodopagoPK;
    }

    public XxfrcOrganizacionMetodopago(XxfrcOrganizacionMetodopagoPK xxfrcOrganizacionMetodopagoPK, String receiptMethodName, Date fechaRegistro) {
        this.xxfrcOrganizacionMetodopagoPK = xxfrcOrganizacionMetodopagoPK;
        this.receiptMethodName = receiptMethodName;
        this.fechaRegistro = fechaRegistro;
    }

    public XxfrcOrganizacionMetodopago(BigInteger orgId, BigInteger bankAccountId, BigInteger receiptMethodId) {
        this.xxfrcOrganizacionMetodopagoPK = new XxfrcOrganizacionMetodopagoPK(orgId, bankAccountId, receiptMethodId);
    }

    public XxfrcOrganizacionMetodopagoPK getXxfrcOrganizacionMetodopagoPK() {
        return xxfrcOrganizacionMetodopagoPK;
    }

    public void setXxfrcOrganizacionMetodopagoPK(XxfrcOrganizacionMetodopagoPK xxfrcOrganizacionMetodopagoPK) {
        this.xxfrcOrganizacionMetodopagoPK = xxfrcOrganizacionMetodopagoPK;
    }

    public String getReceiptMethodName() {
        return receiptMethodName;
    }

    public void setReceiptMethodName(String receiptMethodName) {
        this.receiptMethodName = receiptMethodName;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BigInteger getRemitBankAcctUseId() {
        return remitBankAcctUseId;
    }

    public void setRemitBankAcctUseId(BigInteger remitBankAcctUseId) {
        this.remitBankAcctUseId = remitBankAcctUseId;
    }

    public BigInteger getOrgbau() {
        return orgbau;
    }

    public void setOrgbau(BigInteger orgbau) {
        this.orgbau = orgbau;
    }

    public BigInteger getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(BigInteger bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public BigInteger getBankBranchId() {
        return bankBranchId;
    }

    public void setBankBranchId(BigInteger bankBranchId) {
        this.bankBranchId = bankBranchId;
    }

    public String getOuName() {
        return ouName;
    }

    public void setOuName(String ouName) {
        this.ouName = ouName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xxfrcOrganizacionMetodopagoPK != null ? xxfrcOrganizacionMetodopagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrcOrganizacionMetodopago)) {
            return false;
        }
        XxfrcOrganizacionMetodopago other = (XxfrcOrganizacionMetodopago) object;
        if ((this.xxfrcOrganizacionMetodopagoPK == null && other.xxfrcOrganizacionMetodopagoPK != null) || (this.xxfrcOrganizacionMetodopagoPK != null && !this.xxfrcOrganizacionMetodopagoPK.equals(other.xxfrcOrganizacionMetodopagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrcOrganizacionMetodopago[ xxfrcOrganizacionMetodopagoPK=" + xxfrcOrganizacionMetodopagoPK + " ]";
    }
    
}
