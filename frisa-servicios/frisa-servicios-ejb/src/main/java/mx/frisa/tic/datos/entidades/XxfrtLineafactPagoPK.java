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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author USER_1
 */
@Embeddable
public class XxfrtLineafactPagoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPAGO")
    private BigInteger idpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigInteger idfacturaprimavera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLINEAFACTURA")
    private BigInteger idlineafactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public XxfrtLineafactPagoPK() {
    }

    public XxfrtLineafactPagoPK(BigInteger idpago, BigInteger idfacturaprimavera, BigInteger idlineafactura, Date fechaRegistro) {
        this.idpago = idpago;
        this.idfacturaprimavera = idfacturaprimavera;
        this.idlineafactura = idlineafactura;
        this.fechaRegistro = fechaRegistro;
    }

    public BigInteger getIdpago() {
        return idpago;
    }

    public void setIdpago(BigInteger idpago) {
        this.idpago = idpago;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public BigInteger getIdlineafactura() {
        return idlineafactura;
    }

    public void setIdlineafactura(BigInteger idlineafactura) {
        this.idlineafactura = idlineafactura;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        hash += (idfacturaprimavera != null ? idfacturaprimavera.hashCode() : 0);
        hash += (idlineafactura != null ? idlineafactura.hashCode() : 0);
        hash += (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtLineafactPagoPK)) {
            return false;
        }
        XxfrtLineafactPagoPK other = (XxfrtLineafactPagoPK) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        if ((this.idfacturaprimavera == null && other.idfacturaprimavera != null) || (this.idfacturaprimavera != null && !this.idfacturaprimavera.equals(other.idfacturaprimavera))) {
            return false;
        }
        if ((this.idlineafactura == null && other.idlineafactura != null) || (this.idlineafactura != null && !this.idlineafactura.equals(other.idlineafactura))) {
            return false;
        }
        if ((this.fechaRegistro == null && other.fechaRegistro != null) || (this.fechaRegistro != null && !this.fechaRegistro.equals(other.fechaRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtLineafactPagoPK[ idpago=" + idpago + ", idfacturaprimavera=" + idfacturaprimavera + ", idlineafactura=" + idlineafactura + ", fechaRegistro=" + fechaRegistro + " ]";
    }
    
}
