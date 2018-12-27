/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRT_CARGA_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtCargaFactura.findAll", query = "SELECT x FROM XxfrtCargaFactura x"),
    @NamedQuery(name = "XxfrtCargaFactura.findByUuid", query = "SELECT x FROM XxfrtCargaFactura x WHERE x.uuid = :uuid"),
    @NamedQuery(name = "XxfrtCargaFactura.findByFechaRegistro", query = "SELECT x FROM XxfrtCargaFactura x WHERE x.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "XxfrtCargaFactura.findByDatosjson", query = "SELECT x FROM XxfrtCargaFactura x WHERE x.datosjson = :datosjson"),
    @NamedQuery(name = "XxfrtCargaFactura.findByEstatus", query = "SELECT x FROM XxfrtCargaFactura x WHERE x.estatus = :estatus")})
public class XxfrtCargaFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "UUID")
    private String uuid;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Lob
    @Column(name = "DATOSRECIBIDOS")
    private String datosrecibidos;
    @Size(max = 4000)
    @Column(name = "DATOSJSON")
    private String datosjson;
    @Size(max = 1)
    @Column(name = "ESTATUS")
    private String estatus;

    public XxfrtCargaFactura() {
    }

    public XxfrtCargaFactura(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDatosrecibidos() {
        return datosrecibidos;
    }

    public void setDatosrecibidos(String datosrecibidos) {
        this.datosrecibidos = datosrecibidos;
    }

    public String getDatosjson() {
        return datosjson;
    }

    public void setDatosjson(String datosjson) {
        this.datosjson = datosjson;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uuid != null ? uuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtCargaFactura)) {
            return false;
        }
        XxfrtCargaFactura other = (XxfrtCargaFactura) object;
        if ((this.uuid == null && other.uuid != null) || (this.uuid != null && !this.uuid.equals(other.uuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtCargaFactura[ uuid=" + uuid + " ]";
    }
    
}
