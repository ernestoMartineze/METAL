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
 * @author USER_1
 */
@Entity
@Table(name = "XXFRV_LC_CANCELAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvLcCancelar.findAll", query = "SELECT x FROM XxfrvLcCancelar x"),
    @NamedQuery(name = "XxfrvLcCancelar.findByIdbatch", query = "SELECT x FROM XxfrvLcCancelar x WHERE x.idbatch = :idbatch"),
    @NamedQuery(name = "XxfrvLcCancelar.findByIdlineacaptura", query = "SELECT x FROM XxfrvLcCancelar x WHERE x.idlineacaptura = :idlineacaptura"),
    @NamedQuery(name = "XxfrvLcCancelar.findByIdfacturaprimavera", query = "SELECT x FROM XxfrvLcCancelar x WHERE x.idfacturaprimavera = :idfacturaprimavera"),
    @NamedQuery(name = "XxfrvLcCancelar.findByContractnumber", query = "SELECT x FROM XxfrvLcCancelar x WHERE x.contractnumber = :contractnumber"),
    @NamedQuery(name = "XxfrvLcCancelar.findByGrouptype", query = "SELECT x FROM XxfrvLcCancelar x WHERE x.grouptype = :grouptype"),
    @NamedQuery(name = "XxfrvLcCancelar.findByDivisiontype", query = "SELECT x FROM XxfrvLcCancelar x WHERE x.divisiontype = :divisiontype"),
    @NamedQuery(name = "XxfrvLcCancelar.findByProjectid", query = "SELECT x FROM XxfrvLcCancelar x WHERE x.projectid = :projectid")})
public class XxfrvLcCancelar implements Serializable {
    @Id
    @Column(name = "NUMREGISTRO")
    private BigInteger numregistro;

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "IDBATCH")
    private String idbatch;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLINEACAPTURA")
    private BigInteger idlineacaptura;
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigInteger idfacturaprimavera;
    @Column(name = "CONTRACTNUMBER")
    private Long contractnumber;
    @Size(max = 20)
    @Column(name = "GROUPTYPE")
    private String grouptype;
    @Size(max = 20)
    @Column(name = "DIVISIONTYPE")
    private String divisiontype;
    @Column(name = "PROJECTID")
    private Long projectid;

    public XxfrvLcCancelar() {
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    public BigInteger getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(BigInteger idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public Long getContractnumber() {
        return contractnumber;
    }

    public void setContractnumber(Long contractnumber) {
        this.contractnumber = contractnumber;
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    public String getDivisiontype() {
        return divisiontype;
    }

    public void setDivisiontype(String divisiontype) {
        this.divisiontype = divisiontype;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public BigInteger getNumregistro() {
        return numregistro;
    }

    public void setNumregistro(BigInteger numregistro) {
        this.numregistro = numregistro;
    }
    
}
