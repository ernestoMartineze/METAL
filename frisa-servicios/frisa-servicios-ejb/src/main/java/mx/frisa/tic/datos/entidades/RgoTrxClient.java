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
 * @author soultech
 */
@Entity
@Table(name = "RGO_TRX_CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RgoTrxClient.findAll", query = "SELECT r FROM RgoTrxClient r")
    , @NamedQuery(name = "RgoTrxClient.findByClientId", query = "SELECT r FROM RgoTrxClient r WHERE r.clientId = :clientId")
    , @NamedQuery(name = "RgoTrxClient.findByClienteArId", query = "SELECT r FROM RgoTrxClient r WHERE r.clienteArId = :clienteArId")
    , @NamedQuery(name = "RgoTrxClient.findByNameClient", query = "SELECT r FROM RgoTrxClient r WHERE r.nameClient = :nameClient")
    , @NamedQuery(name = "RgoTrxClient.findByParyNumber", query = "SELECT r FROM RgoTrxClient r WHERE r.paryNumber = :paryNumber")})
public class RgoTrxClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private Long clientId;
    @Size(max = 50)
    @Column(name = "CLIENTE_AR_ID")
    private String clienteArId;
    @Size(max = 100)
    @Column(name = "NAME_CLIENT")
    private String nameClient;
    @Size(max = 100)
    @Column(name = "PARY_NUMBER")
    private String paryNumber;

    public RgoTrxClient() {
    }

    public RgoTrxClient(Long clientId) {
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClienteArId() {
        return clienteArId;
    }

    public void setClienteArId(String clienteArId) {
        this.clienteArId = clienteArId;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getParyNumber() {
        return paryNumber;
    }

    public void setParyNumber(String paryNumber) {
        this.paryNumber = paryNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RgoTrxClient)) {
            return false;
        }
        RgoTrxClient other = (RgoTrxClient) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.RgoTrxClient[ clientId=" + clientId + " ]";
    }
    
}
