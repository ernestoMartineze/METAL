/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ernesto
 */
@Entity
@Table(name = "XXFRV_CENTRO_COSTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvCentroCosto.findAll", query = "SELECT x FROM XxfrvCentroCosto x")
    , @NamedQuery(name = "XxfrvCentroCosto.findByFlexValue", query = "SELECT x FROM XxfrvCentroCosto x WHERE x.flexValue = :flexValue")
    , @NamedQuery(name = "XxfrvCentroCosto.findByIdcarga", query = "SELECT x FROM XxfrvCentroCosto x WHERE x.idcarga = :idcarga")
    , @NamedQuery(name = "XxfrvCentroCosto.findByDescription", query = "SELECT x FROM XxfrvCentroCosto x WHERE x.description = :description")})
public class XxfrvCentroCosto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "FLEX_VALUE")
    @Id
    private Long flexValue;
    @Column(name = "IDCARGA")
    private BigInteger idcarga;
    @Size(max = 0)
    @Column(name = "DESCRIPTION")
    private String description;

    public XxfrvCentroCosto() {
    }

    public Long getFlexValue() {
        return flexValue;
    }

    public void setFlexValue(Long flexValue) {
        this.flexValue = flexValue;
    }

    public BigInteger getIdcarga() {
        return idcarga;
    }

    public void setIdcarga(BigInteger idcarga) {
        this.idcarga = idcarga;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
