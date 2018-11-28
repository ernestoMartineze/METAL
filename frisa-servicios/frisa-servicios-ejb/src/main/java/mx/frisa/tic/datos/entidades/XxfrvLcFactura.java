/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "XXFRV_LC_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvLcFactura.findAll", query = "SELECT x FROM XxfrvLcFactura x"),
    @NamedQuery(name = "XxfrvLcFactura.findByIdbatch", query = "SELECT x FROM XxfrvLcFactura x WHERE x.idbatch = :idbatch"),
    @NamedQuery(name = "XxfrvLcFactura.findByIdfacturaprimavera", query = "SELECT x FROM XxfrvLcFactura x WHERE x.idfacturaprimavera = :idfacturaprimavera"),
    @NamedQuery(name = "XxfrvLcFactura.findByLcCalculada", query = "SELECT x FROM XxfrvLcFactura x WHERE x.lcCalculada = :lcCalculada"),
    @NamedQuery(name = "XxfrvLcFactura.findByIdlineacaptura", query = "SELECT x FROM XxfrvLcFactura x WHERE x.idlineacaptura = :idlineacaptura")})
public class XxfrvLcFactura implements Serializable {
    @Id
    @Column(name = "NUMREGISTRO")
    private BigInteger numregistro;

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "IDBATCH")
    private String idbatch;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigDecimal idfacturaprimavera;
    @Size(max = 4000)
    @Column(name = "LC_CALCULADA")
    private String lcCalculada;
    @Size(max = 20)
    @Column(name = "IDLINEACAPTURA")
    private String idlineacaptura;

    public XxfrvLcFactura() {
    }

    public XxfrvLcFactura(BigDecimal idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    public BigDecimal getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigDecimal idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getLcCalculada() {
        return lcCalculada;
    }

    public void setLcCalculada(String lcCalculada) {
        this.lcCalculada = lcCalculada;
    }

    public String getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(String idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfacturaprimavera != null ? idfacturaprimavera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrvLcFactura)) {
            return false;
        }
        XxfrvLcFactura other = (XxfrvLcFactura) object;
        if ((this.idfacturaprimavera == null && other.idfacturaprimavera != null) || (this.idfacturaprimavera != null && !this.idfacturaprimavera.equals(other.idfacturaprimavera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrvLcFactura[ idfacturaprimavera=" + idfacturaprimavera + " ]";
    }

    public BigInteger getNumregistro() {
        return numregistro;
    }

    public void setNumregistro(BigInteger numregistro) {
        this.numregistro = numregistro;
    }
    
}
