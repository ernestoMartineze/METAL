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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "XXFRC_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrcUsuario.findAll", query = "SELECT x FROM XxfrcUsuario x order by x.fullname"),
    @NamedQuery(name = "XxfrcUsuario.findByUsername", query = "SELECT x FROM XxfrcUsuario x WHERE x.username = :username order by x.fullname"),
    @NamedQuery(name = "XxfrcUsuario.findByFullname", query = "SELECT x FROM XxfrcUsuario x WHERE x.fullname = :fullname order by x.fullname"),
    @NamedQuery(name = "XxfrcUsuario.findByLikeUsername", query = "SELECT x FROM XxfrcUsuario x WHERE x.username LIKE :username order by x.fullname")})
public class XxfrcUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 200)
    @Column(name = "FULLNAME")
    private String fullname;
    @JoinColumn(name = "IDCARGA", referencedColumnName = "ID_CARGA")
    @ManyToOne(fetch = FetchType.LAZY)
    private XxfrtCargaUsuario idcarga;

    public XxfrcUsuario() {
    }

    public XxfrcUsuario(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public XxfrtCargaUsuario getIdcarga() {
        return idcarga;
    }

    public void setIdcarga(XxfrtCargaUsuario idcarga) {
        this.idcarga = idcarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrcUsuario)) {
            return false;
        }
        XxfrcUsuario other = (XxfrcUsuario) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrcUsuario[ username=" + username + " ]";
    }
    
}
