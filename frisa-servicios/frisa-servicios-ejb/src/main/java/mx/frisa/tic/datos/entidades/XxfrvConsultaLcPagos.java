/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ernesto
 */
@Entity
@Table(name = "XXFRV_CONSULTA_LC_PAGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvConsultaLcPagos.findAll", query = "SELECT x FROM XxfrvConsultaLcPagos x")
    , @NamedQuery(name = "XxfrvConsultaLcPagos.findByIdpago", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.idpago = :idpago")
    , @NamedQuery(name = "XxfrvConsultaLcPagos.findByIdlineacaptura", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.idlineacaptura = :idlineacaptura")
    , @NamedQuery(name = "XxfrvConsultaLcPagos.findByNorecibo", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.norecibo = :norecibo")
    , @NamedQuery(name = "XxfrvConsultaLcPagos.findByFecharecibo", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.fecharecibo = :fecharecibo")
    , @NamedQuery(name = "XxfrvConsultaLcPagos.findByFechaaplicacion", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.fechaaplicacion = :fechaaplicacion")
    , @NamedQuery(name = "XxfrvConsultaLcPagos.findByFechatransaccion", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.fechatransaccion = :fechatransaccion")
    , @NamedQuery(name = "XxfrvConsultaLcPagos.findByMontopagado", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.montopagado = :montopagado")
    ,@NamedQuery(name = "XxfrvConsultaLcPagos.findByIdfacturaerp", query = "SELECT x FROM XxfrvConsultaLcPagos x WHERE x.idfacturaerp = :idfacturaerp")})
public class XxfrvConsultaLcPagos implements Serializable {
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPAGO")
    private BigDecimal idpago;
    @Column(name = "IDPAGOERP")
    private BigDecimal idpagoerp;
    @Column(name = "IDFACTURAERP")
    private BigDecimal idfacturaerp;

    private static final long serialVersionUID = 1L;

    @Column(name = "IDLINEACAPTURA")
    private Long idlineacaptura;
    @Column(name = "NORECIBO")
    private Long norecibo;
    @Column(name = "FECHARECIBO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharecibo;
    @Column(name = "FECHAAPLICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaaplicacion;
    @Column(name = "FECHATRANSACCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechatransaccion;
    @Column(name = "MONTOPAGADO")
    private BigDecimal montopagado;

    public XxfrvConsultaLcPagos() {
    }

    public XxfrvConsultaLcPagos(BigDecimal idpago) {
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

    public Date getFechaaplicacion() {
        return fechaaplicacion;
    }

    public void setFechaaplicacion(Date fechaaplicacion) {
        this.fechaaplicacion = fechaaplicacion;
    }

    public Date getFechatransaccion() {
        return fechatransaccion;
    }

    public void setFechatransaccion(Date fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }

    public BigDecimal getMontopagado() {
        return montopagado;
    }

    public void setMontopagado(BigDecimal montopagado) {
        this.montopagado = montopagado;
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
        if (!(object instanceof XxfrvConsultaLcPagos)) {
            return false;
        }
        XxfrvConsultaLcPagos other = (XxfrvConsultaLcPagos) object;
        if ((this.idpago == null && other.idpago != null) || (this.idpago != null && !this.idpago.equals(other.idpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrvConsultaLcPagos[ idpago=" + idpago + " ]";
    }

    public BigDecimal getIdpagoerp() {
        return idpagoerp;
    }

    public void setIdpagoerp(BigDecimal idpagoerp) {
        this.idpagoerp = idpagoerp;
    }

    public BigDecimal getIdfacturaerp() {
        return idfacturaerp;
    }

    public void setIdfacturaerp(BigDecimal idfacturaerp) {
        this.idfacturaerp = idfacturaerp;
    }
    
}
