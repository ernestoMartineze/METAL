/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRT_BITACORA_CARGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtBitacoraCarga.findAll", query = "SELECT x FROM XxfrtBitacoraCarga x"),
    @NamedQuery(name = "XxfrtBitacoraCarga.findByUuid", query = "SELECT x FROM XxfrtBitacoraCarga x WHERE x.xxfrtBitacoraCargaPK.uuid = :uuid"),
    @NamedQuery(name = "XxfrtBitacoraCarga.findByIdbatch", query = "SELECT x FROM XxfrtBitacoraCarga x WHERE x.xxfrtBitacoraCargaPK.idbatch = :idbatch"),
    @NamedQuery(name = "XxfrtBitacoraCarga.findByIdfacturaprimavera", query = "SELECT x FROM XxfrtBitacoraCarga x WHERE x.xxfrtBitacoraCargaPK.idfacturaprimavera = :idfacturaprimavera"),
    @NamedQuery(name = "XxfrtBitacoraCarga.findByEstatus", query = "SELECT x FROM XxfrtBitacoraCarga x WHERE x.estatus = :estatus"),
    @NamedQuery(name = "XxfrtBitacoraCarga.findByFechaRegistro", query = "SELECT x FROM XxfrtBitacoraCarga x WHERE x.fechaRegistro = :fechaRegistro")})
public class XxfrtBitacoraCarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XxfrtBitacoraCargaPK xxfrtBitacoraCargaPK;
    @Size(max = 20)
    @Column(name = "ESTATUS")
    private String estatus;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "IDFACTURAPRIMAVERA", referencedColumnName = "IDFACTURAPRIMAVERA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private XxfrCabeceraFactura xxfrCabeceraFactura;

    public XxfrtBitacoraCarga() {
    }

    public XxfrtBitacoraCarga(XxfrtBitacoraCargaPK xxfrtBitacoraCargaPK) {
        this.xxfrtBitacoraCargaPK = xxfrtBitacoraCargaPK;
    }

    public XxfrtBitacoraCarga(String uuid, String idbatch, BigInteger idfacturaprimavera) {
        this.xxfrtBitacoraCargaPK = new XxfrtBitacoraCargaPK(uuid, idbatch, idfacturaprimavera);
    }

    public XxfrtBitacoraCargaPK getXxfrtBitacoraCargaPK() {
        return xxfrtBitacoraCargaPK;
    }

    public void setXxfrtBitacoraCargaPK(XxfrtBitacoraCargaPK xxfrtBitacoraCargaPK) {
        this.xxfrtBitacoraCargaPK = xxfrtBitacoraCargaPK;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public XxfrCabeceraFactura getXxfrCabeceraFactura() {
        return xxfrCabeceraFactura;
    }

    public void setXxfrCabeceraFactura(XxfrCabeceraFactura xxfrCabeceraFactura) {
        this.xxfrCabeceraFactura = xxfrCabeceraFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xxfrtBitacoraCargaPK != null ? xxfrtBitacoraCargaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtBitacoraCarga)) {
            return false;
        }
        XxfrtBitacoraCarga other = (XxfrtBitacoraCarga) object;
        if ((this.xxfrtBitacoraCargaPK == null && other.xxfrtBitacoraCargaPK != null) || (this.xxfrtBitacoraCargaPK != null && !this.xxfrtBitacoraCargaPK.equals(other.xxfrtBitacoraCargaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtBitacoraCarga[ xxfrtBitacoraCargaPK=" + xxfrtBitacoraCargaPK + " ]";
    }
    
}
