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
 * @author Ernesto
 */
@Entity
@Table(name = "XXFRC_CENTRO_COSTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrcCentroCosto.findAll", query = "SELECT x FROM XxfrcCentroCosto x")
    , @NamedQuery(name = "XxfrcCentroCosto.findByIdcarga", query = "SELECT x FROM XxfrcCentroCosto x WHERE x.idcarga = :idcarga")
    , @NamedQuery(name = "XxfrcCentroCosto.findByFlexValue", query = "SELECT x FROM XxfrcCentroCosto x WHERE x.flexValue = :flexValue")
    , @NamedQuery(name = "XxfrcCentroCosto.findByDescription", query = "SELECT x FROM XxfrcCentroCosto x WHERE x.description = :description")})

public class XxfrcCentroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "IDCARGA")
    private BigInteger idcarga;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "FLEX_VALUE")
    private String flexValue;
    @Size(max = 120)
    @Column(name = "DESCRIPTION")
    private String description;

    public XxfrcCentroCosto() {
    }

    public XxfrcCentroCosto(String flexValue) {
        this.flexValue = flexValue;
    }

    public BigInteger getIdcarga() {
        return idcarga;
    }

    public void setIdcarga(BigInteger idcarga) {
        this.idcarga = idcarga;
    }

    public String getFlexValue() {
        return flexValue;
    }

    public void setFlexValue(String flexValue) {
        this.flexValue = flexValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flexValue != null ? flexValue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrcCentroCosto)) {
            return false;
        }
        XxfrcCentroCosto other = (XxfrcCentroCosto) object;
        if ((this.flexValue == null && other.flexValue != null) || (this.flexValue != null && !this.flexValue.equals(other.flexValue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrcCentroCosto[ flexValue=" + flexValue + " ]";
    }
    
}
