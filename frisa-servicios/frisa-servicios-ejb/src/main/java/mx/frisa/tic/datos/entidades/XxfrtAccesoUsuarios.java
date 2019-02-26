/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Soultech
 */
@Entity
@Table(name = "XXFRT_ACCESO_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtAccesoUsuarios.findAll", query = "SELECT x FROM XxfrtAccesoUsuarios x")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.findByIdacceso", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE x.idacceso = :idacceso")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.findByUsuario", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE x.usuario = :usuario")
        , @NamedQuery(name = "XxfrtAccesoUsuarios.findByUsuarioHabilitado", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE x.usuario = :usuario and x.habilitado = 'H'")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.findByUsuario1", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE x.usuario like :usuario")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.findByCentrocostos", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE x.centrocostos = :centrocostos")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.findByUnidadnegocio", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE x.unidadnegocio = :unidadnegocio")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.findByHabilitado", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE x.habilitado = :habilitado")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.findByAll", query = "SELECT x FROM XxfrtAccesoUsuarios x WHERE "
            + "x.habilitado ='H' and x.centrocostos = :centrocostos and x.usuario = :usuario and x.unidadnegocio = :unidadnegocio")
    , @NamedQuery(name = "XxfrtAccesoUsuarios.disable", query = "UPDATE XxfrtAccesoUsuarios x SET x.habilitado ='N' WHERE "
            + "x.idacceso = :idacceso")})
public class XxfrtAccesoUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "IDACCESO")
    private BigDecimal idacceso;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 20)
    @Column(name = "CENTROCOSTOS")
    private String centrocostos;
    @Size(max = 20)
    @Column(name = "UNIDADNEGOCIO")
    private String unidadnegocio;
    @Size(max = 20)
    @Column(name = "HABILITADO")
    private String habilitado;

    public XxfrtAccesoUsuarios() {
    }

    public XxfrtAccesoUsuarios(BigDecimal idacceso) {
        this.idacceso = idacceso;
    }

    public BigDecimal getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(BigDecimal idacceso) {
        this.idacceso = idacceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCentrocostos() {
        return centrocostos;
    }

    public void setCentrocostos(String centrocostos) {
        this.centrocostos = centrocostos;
    }

    public String getUnidadnegocio() {
        return unidadnegocio;
    }

    public void setUnidadnegocio(String unidadnegocio) {
        this.unidadnegocio = unidadnegocio;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idacceso != null ? idacceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtAccesoUsuarios)) {
            return false;
        }
        XxfrtAccesoUsuarios other = (XxfrtAccesoUsuarios) object;
        if ((this.idacceso == null && other.idacceso != null) || (this.idacceso != null && !this.idacceso.equals(other.idacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtAccesoUsuarios[ idacceso=" + idacceso + " ]";
    }
    
}
