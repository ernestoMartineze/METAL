/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRT_LINEAFACT_PAGO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtLineafactPago.findAll", query = "SELECT x FROM XxfrtLineafactPago x"),
    @NamedQuery(name = "XxfrtLineafactPago.findByIdpago", query = "SELECT x FROM XxfrtLineafactPago x WHERE x.xxfrtLineafactPagoPK.idpago = :idpago"),
    @NamedQuery(name = "XxfrtLineafactPago.findByIdfacturaprimavera", query = "SELECT x FROM XxfrtLineafactPago x WHERE x.xxfrtLineafactPagoPK.idfacturaprimavera = :idfacturaprimavera"),
    @NamedQuery(name = "XxfrtLineafactPago.findByIdlineafactura", query = "SELECT x FROM XxfrtLineafactPago x WHERE x.xxfrtLineafactPagoPK.idlineafactura = :idlineafactura"),
    @NamedQuery(name = "XxfrtLineafactPago.findByFechaRegistro", query = "SELECT x FROM XxfrtLineafactPago x WHERE x.xxfrtLineafactPagoPK.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "XxfrtLineafactPago.findByMonto", query = "SELECT x FROM XxfrtLineafactPago x WHERE x.monto = :monto")})
public class XxfrtLineafactPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XxfrtLineafactPagoPK xxfrtLineafactPagoPK;
    @Column(name = "MONTO")
    private BigInteger monto;

    public XxfrtLineafactPago() {
    }

    public XxfrtLineafactPago(XxfrtLineafactPagoPK xxfrtLineafactPagoPK) {
        this.xxfrtLineafactPagoPK = xxfrtLineafactPagoPK;
    }

    public XxfrtLineafactPago(BigInteger idpago, BigInteger idfacturaprimavera, BigInteger idlineafactura, Date fechaRegistro) {
        this.xxfrtLineafactPagoPK = new XxfrtLineafactPagoPK(idpago, idfacturaprimavera, idlineafactura, fechaRegistro);
    }

    public XxfrtLineafactPagoPK getXxfrtLineafactPagoPK() {
        return xxfrtLineafactPagoPK;
    }

    public void setXxfrtLineafactPagoPK(XxfrtLineafactPagoPK xxfrtLineafactPagoPK) {
        this.xxfrtLineafactPagoPK = xxfrtLineafactPagoPK;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xxfrtLineafactPagoPK != null ? xxfrtLineafactPagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtLineafactPago)) {
            return false;
        }
        XxfrtLineafactPago other = (XxfrtLineafactPago) object;
        if ((this.xxfrtLineafactPagoPK == null && other.xxfrtLineafactPagoPK != null) || (this.xxfrtLineafactPagoPK != null && !this.xxfrtLineafactPagoPK.equals(other.xxfrtLineafactPagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtLineafactPago[ xxfrtLineafactPagoPK=" + xxfrtLineafactPagoPK + " ]";
    }
    
}
