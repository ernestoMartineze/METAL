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
import javax.validation.constraints.Size;

/**
 *
 * @author USER_1
 */
@Embeddable
public class XxfrtBitacoraCargaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "UUID")
    private String uuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "IDBATCH")
    private String idbatch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigInteger idfacturaprimavera;

    public XxfrtBitacoraCargaPK() {
    }

    public XxfrtBitacoraCargaPK(String uuid, String idbatch, BigInteger idfacturaprimavera) {
        this.uuid = uuid;
        this.idbatch = idbatch;
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        hash += (idbatch != null ? idbatch.hashCode() : 0);
        hash += (idfacturaprimavera != null ? idfacturaprimavera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtBitacoraCargaPK)) {
            return false;
        }
        XxfrtBitacoraCargaPK other = (XxfrtBitacoraCargaPK) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        if ((this.idbatch == null && other.idbatch != null) || (this.idbatch != null && !this.idbatch.equals(other.idbatch))) {
            return false;
        }
        if ((this.idfacturaprimavera == null && other.idfacturaprimavera != null) || (this.idfacturaprimavera != null && !this.idfacturaprimavera.equals(other.idfacturaprimavera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtBitacoraCargaPK[ uuid=" + uuid + ", idbatch=" + idbatch + ", idfacturaprimavera=" + idfacturaprimavera + " ]";
    }
    
}
