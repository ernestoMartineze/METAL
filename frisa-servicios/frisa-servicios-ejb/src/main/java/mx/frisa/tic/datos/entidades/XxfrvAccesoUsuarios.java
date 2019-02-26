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
@Table(name = "XXFRV_ACCESO_USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvAccesoUsuarios.findAll", query = "SELECT x FROM XxfrvAccesoUsuarios x")
    , @NamedQuery(name = "XxfrvAccesoUsuarios.findByIdacceso", query = "SELECT x FROM XxfrvAccesoUsuarios x WHERE x.idacceso = :idacceso")
    , @NamedQuery(name = "XxfrvAccesoUsuarios.findByUsuario", query = "SELECT x FROM XxfrvAccesoUsuarios x WHERE x.usuario = :usuario")
    , @NamedQuery(name = "XxfrvAccesoUsuarios.findByCentrocostos", query = "SELECT x FROM XxfrvAccesoUsuarios x WHERE x.centrocostos = :centrocostos")
    , @NamedQuery(name = "XxfrvAccesoUsuarios.findByUnidadnegocio", query = "SELECT x FROM XxfrvAccesoUsuarios x WHERE x.unidadnegocio = :unidadnegocio")})
public class XxfrvAccesoUsuarios implements Serializable {

    @Size(max = 200)
    @Column(name = "FULLNAME")
    private String fullname;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACCESO")
    @Id
    private BigInteger idacceso;
    @Size(max = 20)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 20)
    @Column(name = "CENTROCOSTOS")
    private String centrocostos;
    @Size(max = 120)
    @Column(name = "UNIDADNEGOCIO")
    private String unidadnegocio;

    public XxfrvAccesoUsuarios() {
    }

    public BigInteger getIdacceso() {
        return idacceso;
    }

    public void setIdacceso(BigInteger idacceso) {
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
}
