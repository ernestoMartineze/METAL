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
 * @author Soultech
 */
@Entity
@Table(name = "XXFRV_CONSULTA_LC_BATCH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvConsultaLcBatch.findAll", query = "SELECT x FROM XxfrvConsultaLcBatch x")
    , @NamedQuery(name = "XxfrvConsultaLcBatch.findByLineacaptura", query = "SELECT x FROM XxfrvConsultaLcBatch x WHERE x.lineacaptura = :lineacaptura")
    , @NamedQuery(name = "XxfrvConsultaLcBatch.findByIdfacturaprimavera", query = "SELECT x FROM XxfrvConsultaLcBatch x WHERE x.idfacturaprimavera = :idfacturaprimavera")
    , @NamedQuery(name = "XxfrvConsultaLcBatch.findByIdbatch", query = "SELECT x FROM XxfrvConsultaLcBatch x WHERE x.idbatch = :idbatch")})
public class XxfrvConsultaLcBatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "LINEACAPTURA")
    private String lineacaptura;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigInteger idfacturaprimavera;
    @Size(max = 20)
    @Column(name = "IDBATCH")
    private String idbatch;

    public XxfrvConsultaLcBatch() {
    }

    public String getLineacaptura() {
        return lineacaptura;
    }

    public void setLineacaptura(String lineacaptura) {
        this.lineacaptura = lineacaptura;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }
    
}
