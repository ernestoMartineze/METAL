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
public class XxfrInvoiceLinesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigInteger idfacturaprimavera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LINENUMBER")
    private short linenumber;

    public XxfrInvoiceLinesPK() {
    }

    public XxfrInvoiceLinesPK(BigInteger idfacturaprimavera, short linenumber) {
        this.idfacturaprimavera = idfacturaprimavera;
        this.linenumber = linenumber;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public short getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(short linenumber) {
        this.linenumber = linenumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturaprimavera != null ? idfacturaprimavera.hashCode() : 0);
        hash += (int) linenumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrInvoiceLinesPK)) {
            return false;
        }
        XxfrInvoiceLinesPK other = (XxfrInvoiceLinesPK) object;
        if ((this.idfacturaprimavera == null && other.idfacturaprimavera != null) || (this.idfacturaprimavera != null && !this.idfacturaprimavera.equals(other.idfacturaprimavera))) {
            return false;
        }
        if (this.linenumber != other.linenumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrInvoiceLinesPK[ idfacturaprimavera=" + idfacturaprimavera + ", linenumber=" + linenumber + " ]";
    }
    
}
