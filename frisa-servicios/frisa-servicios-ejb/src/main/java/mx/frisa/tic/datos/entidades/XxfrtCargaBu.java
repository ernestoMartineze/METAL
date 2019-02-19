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
import javax.persistence.CascadeType;
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
@Table(name = "XXFRT_CARGA_BU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtCargaBu.findAll", query = "SELECT x FROM XxfrtCargaBu x"),
    @NamedQuery(name = "XxfrtCargaBu.findByIdCarga", query = "SELECT x FROM XxfrtCargaBu x WHERE x.idCarga = :idCarga"),
    @NamedQuery(name = "XxfrtCargaBu.findByFechaRegistro", query = "SELECT x FROM XxfrtCargaBu x WHERE x.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "XxfrtCargaBu.findByUuid", query = "SELECT x FROM XxfrtCargaBu x WHERE x.uuid = :uuid"),
    @NamedQuery(name = "XxfrtCargaBu.findByCsEstatus", query = "SELECT x FROM XxfrtCargaBu x WHERE x.csEstatus = :csEstatus")})
public class XxfrtCargaBu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CARGA")
    private BigDecimal idCarga;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 50)
    @Column(name = "UUID")
    private String uuid;
    @Column(name = "CS_ESTATUS")
    private BigInteger csEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCarga", fetch = FetchType.LAZY)
    private List<XxfrcUnidadnegocio> xxfrcUnidadnegocioList;

    public XxfrtCargaBu() {
    }

    public XxfrtCargaBu(BigDecimal idCarga) {
        this.idCarga = idCarga;
    }

    public BigDecimal getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(BigDecimal idCarga) {
        this.idCarga = idCarga;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BigInteger getCsEstatus() {
        return csEstatus;
    }

    public void setCsEstatus(BigInteger csEstatus) {
        this.csEstatus = csEstatus;
    }

    @XmlTransient
    public List<XxfrcUnidadnegocio> getXxfrcUnidadnegocioList() {
        return xxfrcUnidadnegocioList;
    }

    public void setXxfrcUnidadnegocioList(List<XxfrcUnidadnegocio> xxfrcUnidadnegocioList) {
        this.xxfrcUnidadnegocioList = xxfrcUnidadnegocioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarga != null ? idCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtCargaBu)) {
            return false;
        }
        XxfrtCargaBu other = (XxfrtCargaBu) object;
        if ((this.idCarga == null && other.idCarga != null) || (this.idCarga != null && !this.idCarga.equals(other.idCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtCargaBu[ idCarga=" + idCarga + " ]";
    }
    
}
