/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRT_HISTORICO_FAC_BATCH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrtHistoricoFacBatch.findAll", query = "SELECT x FROM XxfrtHistoricoFacBatch x"),
    @NamedQuery(name = "XxfrtHistoricoFacBatch.findByIdfacbatch", query = "SELECT x FROM XxfrtHistoricoFacBatch x WHERE x.idfacbatch = :idfacbatch"),
    @NamedQuery(name = "XxfrtHistoricoFacBatch.findByIdfactura", query = "SELECT x FROM XxfrtHistoricoFacBatch x WHERE x.xxfrtHistoricoFacBatchPK.idfactura = :idfactura"),
    @NamedQuery(name = "XxfrtHistoricoFacBatch.findByIdbatch", query = "SELECT x FROM XxfrtHistoricoFacBatch x WHERE x.xxfrtHistoricoFacBatchPK.idbatch = :idbatch"),
    @NamedQuery(name = "XxfrtHistoricoFacBatch.findByFecharegistro", query = "SELECT x FROM XxfrtHistoricoFacBatch x WHERE x.fecharegistro = :fecharegistro"),
    @NamedQuery(name = "XxfrtHistoricoFacBatch.findByIdbatchactual", query = "SELECT x FROM XxfrtHistoricoFacBatch x WHERE x.idbatchactual = :idbatchactual")})
public class XxfrtHistoricoFacBatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XxfrtHistoricoFacBatchPK xxfrtHistoricoFacBatchPK;
    @Column(name = "IDFACBATCH")
    private BigInteger idfacbatch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAREGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @Column(name = "IDBATCHACTUAL")
    private BigInteger idbatchactual;

    public XxfrtHistoricoFacBatch() {
    }

    public XxfrtHistoricoFacBatch(XxfrtHistoricoFacBatchPK xxfrtHistoricoFacBatchPK) {
        this.xxfrtHistoricoFacBatchPK = xxfrtHistoricoFacBatchPK;
    }

    public XxfrtHistoricoFacBatch(XxfrtHistoricoFacBatchPK xxfrtHistoricoFacBatchPK, Date fecharegistro) {
        this.xxfrtHistoricoFacBatchPK = xxfrtHistoricoFacBatchPK;
        this.fecharegistro = fecharegistro;
    }

    public XxfrtHistoricoFacBatch(BigInteger idfactura, BigInteger idbatch) {
        this.xxfrtHistoricoFacBatchPK = new XxfrtHistoricoFacBatchPK(idfactura, idbatch);
    }

    public XxfrtHistoricoFacBatchPK getXxfrtHistoricoFacBatchPK() {
        return xxfrtHistoricoFacBatchPK;
    }

    public void setXxfrtHistoricoFacBatchPK(XxfrtHistoricoFacBatchPK xxfrtHistoricoFacBatchPK) {
        this.xxfrtHistoricoFacBatchPK = xxfrtHistoricoFacBatchPK;
    }

    public BigInteger getIdfacbatch() {
        return idfacbatch;
    }

    public void setIdfacbatch(BigInteger idfacbatch) {
        this.idfacbatch = idfacbatch;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public BigInteger getIdbatchactual() {
        return idbatchactual;
    }

    public void setIdbatchactual(BigInteger idbatchactual) {
        this.idbatchactual = idbatchactual;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xxfrtHistoricoFacBatchPK != null ? xxfrtHistoricoFacBatchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrtHistoricoFacBatch)) {
            return false;
        }
        XxfrtHistoricoFacBatch other = (XxfrtHistoricoFacBatch) object;
        if ((this.xxfrtHistoricoFacBatchPK == null && other.xxfrtHistoricoFacBatchPK != null) || (this.xxfrtHistoricoFacBatchPK != null && !this.xxfrtHistoricoFacBatchPK.equals(other.xxfrtHistoricoFacBatchPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrtHistoricoFacBatch[ xxfrtHistoricoFacBatchPK=" + xxfrtHistoricoFacBatchPK + " ]";
    }
    
}
