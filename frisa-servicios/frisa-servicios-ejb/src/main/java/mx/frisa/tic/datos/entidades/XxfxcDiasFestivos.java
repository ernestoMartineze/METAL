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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFXC_DIAS_FESTIVOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfxcDiasFestivos.findAll", query = "SELECT x FROM XxfxcDiasFestivos x"),
    @NamedQuery(name = "XxfxcDiasFestivos.findByIddiafestivo", query = "SELECT x FROM XxfxcDiasFestivos x WHERE x.iddiafestivo = :iddiafestivo"),
    @NamedQuery(name = "XxfxcDiasFestivos.findByFecha", query = "SELECT x FROM XxfxcDiasFestivos x WHERE x.fecha = :fecha"),
    @NamedQuery(name = "XxfxcDiasFestivos.findByIndActivo", query = "SELECT x FROM XxfxcDiasFestivos x WHERE x.indActivo = :indActivo")})
public class XxfxcDiasFestivos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDIAFESTIVO")
    private BigDecimal iddiafestivo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IND_ACTIVO")
    private BigInteger indActivo;

    public XxfxcDiasFestivos() {
    }

    public XxfxcDiasFestivos(BigDecimal iddiafestivo) {
        this.iddiafestivo = iddiafestivo;
    }

    public XxfxcDiasFestivos(BigDecimal iddiafestivo, Date fecha, BigInteger indActivo) {
        this.iddiafestivo = iddiafestivo;
        this.fecha = fecha;
        this.indActivo = indActivo;
    }

    public BigDecimal getIddiafestivo() {
        return iddiafestivo;
    }

    public void setIddiafestivo(BigDecimal iddiafestivo) {
        this.iddiafestivo = iddiafestivo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(BigInteger indActivo) {
        this.indActivo = indActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddiafestivo != null ? iddiafestivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfxcDiasFestivos)) {
            return false;
        }
        XxfxcDiasFestivos other = (XxfxcDiasFestivos) object;
        if ((this.iddiafestivo == null && other.iddiafestivo != null) || (this.iddiafestivo != null && !this.iddiafestivo.equals(other.iddiafestivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfxcDiasFestivos[ iddiafestivo=" + iddiafestivo + " ]";
    }
    
}
