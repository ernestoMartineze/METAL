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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danie
 */
@Entity
@Table(name = "XXFRC_TIPO_MONEDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrcTipoMoneda.findAll", query = "SELECT x FROM XxfrcTipoMoneda x")
    , @NamedQuery(name = "XxfrcTipoMoneda.findByCodigo", query = "SELECT x FROM XxfrcTipoMoneda x WHERE x.codigo = :codigo")
    , @NamedQuery(name = "XxfrcTipoMoneda.findByDescripcion", query = "SELECT x FROM XxfrcTipoMoneda x WHERE x.descripcion = :descripcion")
    , @NamedQuery(name = "XxfrcTipoMoneda.findByIndActivo", query = "SELECT x FROM XxfrcTipoMoneda x WHERE x.indActivo = :indActivo")})
public class XxfrcTipoMoneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO")
    private String codigo;
    @Size(max = 125)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "IND_ACTIVO")
    private String indActivo;

    public XxfrcTipoMoneda() {
    }

    public XxfrcTipoMoneda(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIndActivo() {
        return indActivo;
    }

    public void setIndActivo(String indActivo) {
        this.indActivo = indActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrcTipoMoneda)) {
            return false;
        }
        XxfrcTipoMoneda other = (XxfrcTipoMoneda) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrcTipoMoneda[ codigo=" + codigo + " ]";
    }
    
}
