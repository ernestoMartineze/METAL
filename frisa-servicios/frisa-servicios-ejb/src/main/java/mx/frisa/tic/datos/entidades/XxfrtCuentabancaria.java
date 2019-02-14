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
@Table(name = "XXFRT_CUENTABANCARIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtCuentabancaria.findAll", query = "SELECT x FROM XxfrtCuentabancaria x"),
    @NamedQuery(name = "XxfrtCuentabancaria.findByNumerocuenta", query = "SELECT x FROM XxfrtCuentabancaria x WHERE x.numerocuenta = :numerocuenta"),
    @NamedQuery(name = "XxfrtCuentabancaria.findByLikeNumerocuenta", query = "SELECT x FROM XxfrtCuentabancaria x WHERE x.numerocuenta like :numerocuenta "),
    @NamedQuery(name = "XxfrtCuentabancaria.findByFecharegistro", query = "SELECT x FROM XxfrtCuentabancaria x WHERE x.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "XxfrtCuentabancaria.findByEstatus", query = "SELECT x FROM XxfrtCuentabancaria x WHERE x.estatus = :estatus")})
public class XxfrtCuentabancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NUMEROCUENTA")
    private Integer numerocuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "ESTATUS")
    private Integer estatus;
    
        @Column(name = "NOMBRE")
    private String nombre;

    public XxfrtCuentabancaria() {
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerocuenta != null ? numerocuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtCuentabancaria)) {
            return false;
        }
        XxfrtCuentabancaria other = (XxfrtCuentabancaria) object;
        if ((this.numerocuenta == null && other.numerocuenta != null) || (this.numerocuenta != null && !this.numerocuenta.equals(other.numerocuenta))) {
            return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(Integer numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }
    
    
    
}
