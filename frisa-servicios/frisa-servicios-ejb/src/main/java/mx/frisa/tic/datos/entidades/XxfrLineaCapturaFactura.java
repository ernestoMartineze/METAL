/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
 * @author soultech
 */
@Entity
@Table(name = "XXFR_LINEA_CAPTURA_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrLineaCapturaFactura.findAll", query = "SELECT x FROM XxfrLineaCapturaFactura x")
    , @NamedQuery(name = "XxfrLineaCapturaFactura.findByIdtransaccion", query = "SELECT x FROM XxfrLineaCapturaFactura x WHERE x.idtransaccion = :idtransaccion")
    , @NamedQuery(name = "XxfrLineaCapturaFactura.findByIdlineacaptura", query = "SELECT x FROM XxfrLineaCapturaFactura x WHERE x.idlineacaptura = :idlineacaptura")})
public class XxfrLineaCapturaFactura implements Serializable {

    @Column(name = "CS_ESTATUS")
    private BigInteger csEstatus;
    @Column(name = "FEC_VENCIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVencida;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTRANSACCION")
    private BigDecimal idtransaccion;
    @Size(max = 20)
    @Column(name = "IDLINEACAPTURA")
    private String idlineacaptura;
    @JoinColumn(name = "IDFACTURAPRIMAVERA", referencedColumnName = "IDFACTURAPRIMAVERA")
    @ManyToOne(fetch = FetchType.LAZY)
    private XxfrCabeceraFactura idfacturaprimavera;

    public XxfrLineaCapturaFactura() {
    }

    public XxfrLineaCapturaFactura(BigDecimal idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public BigDecimal getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(BigDecimal idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public String getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(String idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    /**
     *
     * @return
     */
    public XxfrCabeceraFactura getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    /**
     *
     * @param idfacturaprimavera
     */
    public void setIdfacturaprimavera(XxfrCabeceraFactura idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransaccion != null ? idtransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrLineaCapturaFactura)) {
            return false;
        }
        XxfrLineaCapturaFactura other = (XxfrLineaCapturaFactura) object;
        if ((this.idtransaccion == null && other.idtransaccion != null) || (this.idtransaccion != null && !this.idtransaccion.equals(other.idtransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrLineaCapturaFactura[ idtransaccion=" + idtransaccion + " ]";
    }

    public BigInteger getCsEstatus() {
        return csEstatus;
    }

    public void setCsEstatus(BigInteger csEstatus) {
        this.csEstatus = csEstatus;
    }

    public Date getFecVencida() {
        return fecVencida;
    }

    public void setFecVencida(Date fecVencida) {
        this.fecVencida = fecVencida;
    }
    
}
