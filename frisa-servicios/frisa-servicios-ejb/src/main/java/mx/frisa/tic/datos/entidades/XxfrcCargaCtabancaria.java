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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRC_CARGA_CTABANCARIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrcCargaCtabancaria.findAll", query = "SELECT x FROM XxfrcCargaCtabancaria x"),
    @NamedQuery(name = "XxfrcCargaCtabancaria.findById", query = "SELECT x FROM XxfrcCargaCtabancaria x WHERE x.id = :id"),
    @NamedQuery(name = "XxfrcCargaCtabancaria.findByFecha", query = "SELECT x FROM XxfrcCargaCtabancaria x WHERE x.fecha = :fecha"),
    @NamedQuery(name = "XxfrcCargaCtabancaria.findByUudi", query = "SELECT x FROM XxfrcCargaCtabancaria x WHERE x.uudi = :uudi"),
    @NamedQuery(name = "XxfrcCargaCtabancaria.findByEstatus", query = "SELECT x FROM XxfrcCargaCtabancaria x WHERE x.estatus = :estatus")})
public class XxfrcCargaCtabancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 50)
    @Column(name = "UUDI")
    private String uudi;
    @Column(name = "ESTATUS")
    private BigInteger estatus;
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<XxfrtCuentabancaria> xxfrtCuentabancariaList;

    public XxfrcCargaCtabancaria() {
    }

    public XxfrcCargaCtabancaria(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUudi() {
        return uudi;
    }

    public void setUudi(String uudi) {
        this.uudi = uudi;
    }

    public BigInteger getEstatus() {
        return estatus;
    }

    public void setEstatus(BigInteger estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<XxfrtCuentabancaria> getXxfrtCuentabancariaList() {
        return xxfrtCuentabancariaList;
    }

    public void setXxfrtCuentabancariaList(List<XxfrtCuentabancaria> xxfrtCuentabancariaList) {
        this.xxfrtCuentabancariaList = xxfrtCuentabancariaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrcCargaCtabancaria)) {
            return false;
        }
        XxfrcCargaCtabancaria other = (XxfrcCargaCtabancaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrcCargaCtabancaria[ id=" + id + " ]";
    }
    
}
