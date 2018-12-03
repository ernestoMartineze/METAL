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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRT_NOTA_CREDITO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtNotaCredito.findAll", query = "SELECT x FROM XxfrtNotaCredito x"),
    @NamedQuery(name = "XxfrtNotaCredito.findByUuid", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.uuid = :uuid"),
    @NamedQuery(name = "XxfrtNotaCredito.findByRefDescripcion", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.refDescripcion = :refDescripcion"),
    @NamedQuery(name = "XxfrtNotaCredito.findByCanAplicable", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.canAplicable = :canAplicable"),
    @NamedQuery(name = "XxfrtNotaCredito.findByFecRegistro", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.fecRegistro = :fecRegistro"),
    @NamedQuery(name = "XxfrtNotaCredito.findByCsEstatus", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.csEstatus = :csEstatus"),
    @NamedQuery(name = "XxfrtNotaCredito.findByFecAplicacion", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.fecAplicacion = :fecAplicacion"),
    @NamedQuery(name = "XxfrtNotaCredito.findByIdFacturaprimavera", query = "SELECT x FROM XxfrtNotaCredito x WHERE x.idFacturaprimavera = :idFacturaprimavera")})
public class XxfrtNotaCredito implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_APLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAplicacion;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UUID")
    private BigInteger uuid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "REF_DESCRIPCION")
    private String refDescripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAN_APLICABLE")
    private BigDecimal canAplicable;
    @Column(name = "FEC_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CS_ESTATUS")
    private String csEstatus;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FACTURAPRIMAVERA")
    private BigDecimal idFacturaprimavera;
    @JoinColumn(name = "ID_FACTURAPRIMAVERA", referencedColumnName = "IDFACTURAPRIMAVERA", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private XxfrCabeceraFactura xxfrCabeceraFactura;

    public XxfrtNotaCredito() {
    }

    public XxfrtNotaCredito(BigDecimal idFacturaprimavera) {
        this.idFacturaprimavera = idFacturaprimavera;
    }

    public XxfrtNotaCredito(Date fecAplicacion, BigInteger uuid, String refDescripcion, BigDecimal canAplicable, Date fecRegistro, String csEstatus, BigDecimal idFacturaprimavera) {
        this.fecAplicacion = fecAplicacion;
        this.uuid = uuid;
        this.refDescripcion = refDescripcion;
        this.canAplicable = canAplicable;
        this.fecRegistro = fecRegistro;
        this.csEstatus = csEstatus;
        this.idFacturaprimavera = idFacturaprimavera;
    }

    

    public BigInteger getUuid() {
        return uuid;
    }

    public void setUuid(BigInteger uuid) {
        this.uuid = uuid;
    }

    public String getRefDescripcion() {
        return refDescripcion;
    }

    public void setRefDescripcion(String refDescripcion) {
        this.refDescripcion = refDescripcion;
    }

    public BigDecimal getCanAplicable() {
        return canAplicable;
    }

    public void setCanAplicable(BigDecimal canAplicable) {
        this.canAplicable = canAplicable;
    }

    public Date getFecRegistro() {
        return fecRegistro;
    }

    public void setFecRegistro(Date fecRegistro) {
        this.fecRegistro = fecRegistro;
    }

    public String getCsEstatus() {
        return csEstatus;
    }

    public void setCsEstatus(String csEstatus) {
        this.csEstatus = csEstatus;
    }

    public BigDecimal getIdFacturaprimavera() {
        return idFacturaprimavera;
    }

    public void setIdFacturaprimavera(BigDecimal idFacturaprimavera) {
        this.idFacturaprimavera = idFacturaprimavera;
    }

    public XxfrCabeceraFactura getXxfrCabeceraFactura() {
        return xxfrCabeceraFactura;
    }

    public void setXxfrCabeceraFactura(XxfrCabeceraFactura xxfrCabeceraFactura) {
        this.xxfrCabeceraFactura = xxfrCabeceraFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaprimavera != null ? idFacturaprimavera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtNotaCredito)) {
            return false;
        }
        XxfrtNotaCredito other = (XxfrtNotaCredito) object;
        if ((this.idFacturaprimavera == null && other.idFacturaprimavera != null) || (this.idFacturaprimavera != null && !this.idFacturaprimavera.equals(other.idFacturaprimavera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtNotaCredito[ idFacturaprimavera=" + idFacturaprimavera + " ]";
    }

    public Date getFecAplicacion() {
        return fecAplicacion;
    }

    public void setFecAplicacion(Date fecAplicacion) {
        this.fecAplicacion = fecAplicacion;
    }
    
}
