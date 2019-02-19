/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRC_UNIDADNEGOCIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrcUnidadnegocio.findAll", query = "SELECT x FROM XxfrcUnidadnegocio x"),
    @NamedQuery(name = "XxfrcUnidadnegocio.findByCveBu", query = "SELECT x FROM XxfrcUnidadnegocio x WHERE x.cveBu = :cveBu"),
    @NamedQuery(name = "XxfrcUnidadnegocio.findByNombre", query = "SELECT x FROM XxfrcUnidadnegocio x WHERE x.nombre = :nombre"),
    @NamedQuery(name = "XxfrcUnidadnegocio.findByEstatus", query = "SELECT x FROM XxfrcUnidadnegocio x WHERE x.estatus = :estatus")})
public class XxfrcUnidadnegocio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "CVE_BU")
    private String cveBu;
    @Size(max = 120)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 1)
    @Column(name = "ESTATUS")
    private String estatus;
    @JoinColumn(name = "ID_CARGA", referencedColumnName = "ID_CARGA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private XxfrtCargaBu idCarga;

    public XxfrcUnidadnegocio() {
    }

    public XxfrcUnidadnegocio(String cveBu) {
        this.cveBu = cveBu;
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

    public XxfrtCargaBu getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(XxfrtCargaBu idCarga) {
        this.idCarga = idCarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cveBu != null ? cveBu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrcUnidadnegocio)) {
            return false;
        }
        XxfrcUnidadnegocio other = (XxfrcUnidadnegocio) object;
        if ((this.cveBu == null && other.cveBu != null) || (this.cveBu != null && !this.cveBu.equals(other.cveBu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrcUnidadnegocio[ cveBu=" + cveBu + " ]";
    }
    
}
