/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "XXFR_PRIORIDAD_COBRANZA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrPrioridadCobranza.findAll", query = "SELECT x FROM XxfrPrioridadCobranza x"),
    @NamedQuery(name = "XxfrPrioridadCobranza.findByIdPrioridad", query = "SELECT x FROM XxfrPrioridadCobranza x WHERE x.idPrioridad = :idPrioridad"),
    @NamedQuery(name = "XxfrPrioridadCobranza.findByClaveFrisa", query = "SELECT x FROM XxfrPrioridadCobranza x WHERE x.claveFrisa = :claveFrisa"),
    @NamedQuery(name = "XxfrPrioridadCobranza.findByValorPrioridad", query = "SELECT x FROM XxfrPrioridadCobranza x WHERE x.valorPrioridad = :valorPrioridad"),
    @NamedQuery(name = "XxfrPrioridadCobranza.findByDescripcion", query = "SELECT x FROM XxfrPrioridadCobranza x WHERE x.descripcion = :descripcion")})
public class XxfrPrioridadCobranza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "ID_PRIORIDAD")
    private String idPrioridad;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CLAVE_FRISA")
    private String claveFrisa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_PRIORIDAD")
    private BigInteger valorPrioridad;
    @Size(max = 120)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public XxfrPrioridadCobranza() {
    }

    public XxfrPrioridadCobranza(String claveFrisa) {
        this.claveFrisa = claveFrisa;
    }

    public XxfrPrioridadCobranza(String claveFrisa, BigInteger valorPrioridad) {
        this.claveFrisa = claveFrisa;
        this.valorPrioridad = valorPrioridad;
    }

    public String getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(String idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getClaveFrisa() {
        return claveFrisa;
    }

    public void setClaveFrisa(String claveFrisa) {
        this.claveFrisa = claveFrisa;
    }

    public BigInteger getValorPrioridad() {
        return valorPrioridad;
    }

    public void setValorPrioridad(BigInteger valorPrioridad) {
        this.valorPrioridad = valorPrioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveFrisa != null ? claveFrisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrPrioridadCobranza)) {
            return false;
        }
        XxfrPrioridadCobranza other = (XxfrPrioridadCobranza) object;
        if ((this.claveFrisa == null && other.claveFrisa != null) || (this.claveFrisa != null && !this.claveFrisa.equals(other.claveFrisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrPrioridadCobranza[ claveFrisa=" + claveFrisa + " ]";
    }
    
}
