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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "XxfrtCuentabancaria.findByLikeNumerocuenta", query = "SELECT x FROM XxfrtCuentabancaria x WHERE x.numerocuenta LIKE :numerocuenta"),
    @NamedQuery(name = "XxfrtCuentabancaria.findByFecharegistro", query = "SELECT x FROM XxfrtCuentabancaria x WHERE x.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "XxfrtCuentabancaria.findByEstatus", query = "SELECT x FROM XxfrtCuentabancaria x WHERE x.estatus = :estatus")})
public class XxfrtCuentabancaria implements Serializable {

    @Column(name = "ESTATUS")
    private Integer estatus;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private XxfrcCargaCtabancaria id;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "NUMEROCUENTA")
    private String numerocuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;

    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MONEDA")
    private String moneda;

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


    public String getNumerocuenta() {
        return numerocuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerocuenta = numerocuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public XxfrcCargaCtabancaria getId() {
        return id;
    }

    public void setId(XxfrcCargaCtabancaria id) {
        this.id = id;
    }

}
