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
public class XxfrtHistoricoFacBatchPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURA")
    private BigInteger idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBATCH")
    private BigInteger idbatch;

    public XxfrtHistoricoFacBatchPK() {
    }

    public XxfrtHistoricoFacBatchPK(BigInteger idfactura, BigInteger idbatch) {
        this.idfactura = idfactura;
        this.idbatch = idbatch;
    }

    public BigInteger getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(BigInteger idfactura) {
        this.idfactura = idfactura;
    }

    public BigInteger getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(BigInteger idbatch) {
        this.idbatch = idbatch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        hash += (idbatch != null ? idbatch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtHistoricoFacBatchPK)) {
            return false;
        }
        XxfrtHistoricoFacBatchPK other = (XxfrtHistoricoFacBatchPK) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        if ((this.idbatch == null && other.idbatch != null) || (this.idbatch != null && !this.idbatch.equals(other.idbatch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtHistoricoFacBatchPK[ idfactura=" + idfactura + ", idbatch=" + idbatch + " ]";
    }
    
}
