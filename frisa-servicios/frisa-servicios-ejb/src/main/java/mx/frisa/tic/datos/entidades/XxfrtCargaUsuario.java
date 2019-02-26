/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRT_CARGA_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtCargaUsuario.findAll", query = "SELECT x FROM XxfrtCargaUsuario x"),
    @NamedQuery(name = "XxfrtCargaUsuario.findByIdCarga", query = "SELECT x FROM XxfrtCargaUsuario x WHERE x.idCarga = :idCarga"),
    @NamedQuery(name = "XxfrtCargaUsuario.findByFecha", query = "SELECT x FROM XxfrtCargaUsuario x WHERE x.fecha = :fecha"),
    @NamedQuery(name = "XxfrtCargaUsuario.findByEstatus", query = "SELECT x FROM XxfrtCargaUsuario x WHERE x.estatus = :estatus")})
public class XxfrtCargaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CARGA")
    private BigDecimal idCarga;
    @Size(max = 20)
    @Column(name = "FECHA")
    private String fecha;
    @Column(name = "ESTATUS")
    private BigInteger estatus;
    @OneToMany(mappedBy = "idcarga", fetch = FetchType.LAZY)
    private List<XxfrcUsuario> xxfrcUsuarioList;

    public XxfrtCargaUsuario() {
    }

    public XxfrtCargaUsuario(BigDecimal idCarga) {
        this.idCarga = idCarga;
    }

    public BigDecimal getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(BigDecimal idCarga) {
        this.idCarga = idCarga;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigInteger getEstatus() {
        return estatus;
    }

    public void setEstatus(BigInteger estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<XxfrcUsuario> getXxfrcUsuarioList() {
        return xxfrcUsuarioList;
    }

    public void setXxfrcUsuarioList(List<XxfrcUsuario> xxfrcUsuarioList) {
        this.xxfrcUsuarioList = xxfrcUsuarioList;
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
        if (!(object instanceof XxfrtCargaUsuario)) {
            return false;
        }
        XxfrtCargaUsuario other = (XxfrtCargaUsuario) object;
        if ((this.idCarga == null && other.idCarga != null) || (this.idCarga != null && !this.idCarga.equals(other.idCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtCargaUsuario[ idCarga=" + idCarga + " ]";
    }
    
}
