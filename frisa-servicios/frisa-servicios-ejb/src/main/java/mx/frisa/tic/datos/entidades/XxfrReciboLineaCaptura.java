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
import javax.persistence.Id;
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
@Table(name = "XXFR_RECIBO_LINEA_CAPTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrReciboLineaCaptura.findAll", query = "SELECT x FROM XxfrReciboLineaCaptura x")
    , @NamedQuery(name = "XxfrReciboLineaCaptura.findByIdpago", query = "SELECT x FROM XxfrReciboLineaCaptura x WHERE x.idpago = :idpago")
    , @NamedQuery(name = "XxfrReciboLineaCaptura.findByIdlineacaptura", query = "SELECT x FROM XxfrReciboLineaCaptura x WHERE x.idlineacaptura = :idlineacaptura")
    , @NamedQuery(name = "XxfrReciboLineaCaptura.findByIdpagoerp", query = "SELECT x FROM XxfrReciboLineaCaptura x WHERE x.idpagoerp = :idpagoerp")
    , @NamedQuery(name = "XxfrReciboLineaCaptura.findByMontopagado", query = "SELECT x FROM XxfrReciboLineaCaptura x WHERE x.montopagado = :montopagado")
    , @NamedQuery(name = "XxfrReciboLineaCaptura.findByFechaaplicacion", query = "SELECT x FROM XxfrReciboLineaCaptura x WHERE x.fechaaplicacion = :fechaaplicacion")
//    , @NamedQuery(name = "XxfrReciboLineaCaptura.findByFechapago", query = "SELECT x FROM XxfrReciboLineaCaptura x WHERE x.fechapago = :fechapago")
    , @NamedQuery(name = "XxfrReciboLineaCaptura.findByReferencia", query = "SELECT x FROM XxfrReciboLineaCaptura x WHERE x.referencia = :referencia")})
public class XxfrReciboLineaCaptura implements Serializable {

    @Column(name = "NORECIBO")
    private Long norecibo;
    @Column(name = "FECHARECIBO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecibo;
    @Column(name = "FECHATRANSACCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatransaccion;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
//    @Basic(optional = false)
//    @NotNull
    @Column(name = "IDPAGO")
    private BigDecimal idpago;
    @Column(name = "IDLINEACAPTURA")
    private Long idlineacaptura;
    @Column(name = "IDPAGOERP")
    private BigInteger idpagoerp;
    @Column(name = "MONTOPAGADO")
    private BigDecimal montopagado;
    @Column(name = "FECHAAPLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaaplicacion;
//    @Column(name = "FECHAPAGO")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date fechapago;
    @Size(max = 20)
    @Column(name = "REFERENCIA")
    private String referencia;

    public XxfrReciboLineaCaptura() {
    }

    public XxfrReciboLineaCaptura(BigDecimal idpago) {
        this.idpago = idpago;
    }

    public BigDecimal getIdpago() {
        return idpago;
    }

    public void setIdpago(BigDecimal idpago) {
        this.idpago = idpago;
    }

    public Long getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(Long idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    public BigInteger getIdpagoerp() {
        return idpagoerp;
    }

    public void setIdpagoerp(BigInteger idpagoerp) {
        this.idpagoerp = idpagoerp;
    }

    public BigDecimal getMontopagado() {
        return montopagado;
    }

    public void setMontopagado(BigDecimal montopagado) {
        this.montopagado = montopagado;
    }

    public Date getFechaaplicacion() {
        return fechaaplicacion;
    }

    public void setFechaaplicacion(Date fechaaplicacion) {
        this.fechaaplicacion = fechaaplicacion;
    }

//    public Date getFechapago() {
//        return fechapago;
//    }
//
//    public void setFechapago(Date fechapago) {
//        this.fechapago = fechapago;
//    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpago != null ? idpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrReciboLineaCaptura)) {
            return false;
        }
        XxfrReciboLineaCaptura other = (XxfrReciboLineaCaptura) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrReciboLineaCaptura[ idpago=" + idpago + " ]";
    }

    public Long getNorecibo() {
        return norecibo;
    }

    public void setNorecibo(Long norecibo) {
        this.norecibo = norecibo;
    }

    public Date getFecharecibo() {
        return fecharecibo;
    }

    public void setFecharecibo(Date fecharecibo) {
        this.fecharecibo = fecharecibo;
    }

    public Date getFechatransaccion() {
        return fechatransaccion;
    }

    public void setFechatransaccion(Date fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }
    
}
