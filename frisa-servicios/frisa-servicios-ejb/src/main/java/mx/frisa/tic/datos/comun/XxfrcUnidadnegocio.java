/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.comun;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import mx.frisa.tic.datos.entidades.XxfrtCargaBu;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRC_UNIDADNEGOCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrcUnidadnegocio.findAll", query = "SELECT x FROM XxfrcUnidadnegocio x"),
    @NamedQuery(name = "XxfrcUnidadnegocio.findByIdCarga", query = "SELECT x FROM XxfrcUnidadnegocio x WHERE x.idCarga = :idCarga"),
    @NamedQuery(name = "XxfrcUnidadnegocio.findByCveBu", query = "SELECT x FROM XxfrcUnidadnegocio x WHERE x.cveBu = :cveBu"),
    @NamedQuery(name = "XxfrcUnidadnegocio.findByNombre", query = "SELECT x FROM XxfrcUnidadnegocio x WHERE x.nombre = :nombre"),
    @NamedQuery(name = "XxfrcUnidadnegocio.findByEstatus", query = "SELECT x FROM XxfrcUnidadnegocio x WHERE x.estatus = :estatus")})
public class XxfrcUnidadnegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARGA")
    private BigDecimal idCarga;
    @Size(max = 32)
    @Column(name = "CVE_BU")
    private String cveBu;
    @Size(max = 120)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 1)
    @Column(name = "ESTATUS")
    private String estatus;
    @JoinColumn(name = "ID_CARGA", referencedColumnName = "ID_CARGA", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private XxfrtCargaBu xxfrtCargaBu;

    public XxfrcUnidadnegocio() {
    }

    public XxfrcUnidadnegocio(BigDecimal idCarga) {
        this.idCarga = idCarga;
    }

    public BigDecimal getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(BigDecimal idCarga) {
        this.idCarga = idCarga;
    }

    public String getCveBu() {
        return cveBu;
    }

    public void setCveBu(String cveBu) {
        this.cveBu = cveBu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public XxfrtCargaBu getXxfrtCargaBu() {
        return xxfrtCargaBu;
    }

    public void setXxfrtCargaBu(XxfrtCargaBu xxfrtCargaBu) {
        this.xxfrtCargaBu = xxfrtCargaBu;
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
        if (!(object instanceof XxfrcUnidadnegocio)) {
            return false;
        }
        XxfrcUnidadnegocio other = (XxfrcUnidadnegocio) object;
        if ((this.idCarga == null && other.idCarga != null) || (this.idCarga != null && !this.idCarga.equals(other.idCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.comun.XxfrcUnidadnegocio[ idCarga=" + idCarga + " ]";
    }
    
}
