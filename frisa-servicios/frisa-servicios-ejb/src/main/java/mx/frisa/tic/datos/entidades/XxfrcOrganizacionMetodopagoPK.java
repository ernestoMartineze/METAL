/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author USER_1
 */
@Embeddable
public class XxfrcOrganizacionMetodopagoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ORG_ID")
    private BigInteger orgId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BANK_ACCOUNT_ID")
    private BigInteger bankAccountId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEIPT_METHOD_ID")
    private BigInteger receiptMethodId;

    public XxfrcOrganizacionMetodopagoPK() {
    }

    public XxfrcOrganizacionMetodopagoPK(BigInteger orgId, BigInteger bankAccountId, BigInteger receiptMethodId) {
        this.orgId = orgId;
        this.bankAccountId = bankAccountId;
        this.receiptMethodId = receiptMethodId;
    }

    public BigInteger getOrgId() {
        return orgId;
    }

    public void setOrgId(BigInteger orgId) {
        this.orgId = orgId;
    }

    public BigInteger getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(BigInteger bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public BigInteger getReceiptMethodId() {
        return receiptMethodId;
    }

    public void setReceiptMethodId(BigInteger receiptMethodId) {
        this.receiptMethodId = receiptMethodId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orgId != null ? orgId.hashCode() : 0);
        hash += (bankAccountId != null ? bankAccountId.hashCode() : 0);
        hash += (receiptMethodId != null ? receiptMethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrcOrganizacionMetodopagoPK)) {
            return false;
        }
        XxfrcOrganizacionMetodopagoPK other = (XxfrcOrganizacionMetodopagoPK) object;
        if ((this.orgId == null && other.orgId != null) || (this.orgId != null && !this.orgId.equals(other.orgId))) {
            return false;
        }
        if ((this.bankAccountId == null && other.bankAccountId != null) || (this.bankAccountId != null && !this.bankAccountId.equals(other.bankAccountId))) {
            return false;
        }
        if ((this.receiptMethodId == null && other.receiptMethodId != null) || (this.receiptMethodId != null && !this.receiptMethodId.equals(other.receiptMethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrcOrganizacionMetodopagoPK[ orgId=" + orgId + ", bankAccountId=" + bankAccountId + ", receiptMethodId=" + receiptMethodId + " ]";
    }
    
}
