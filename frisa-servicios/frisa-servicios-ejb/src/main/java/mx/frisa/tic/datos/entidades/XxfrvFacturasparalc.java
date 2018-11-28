/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFRV_FACTURASPARALC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvFacturasparalc.findAll", query = "SELECT x FROM XxfrvFacturasparalc x"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByIdbatch", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.idbatch = :idbatch"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByTipocobranza", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.tipocobranza = :tipocobranza"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByDivisiontype", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.divisiontype = :divisiontype"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByProjectid", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.projectid = :projectid"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByContractnumber", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.contractnumber = :contractnumber"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByGrouptype", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.grouptype = :grouptype"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByNumerofacturas", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.numerofacturas = :numerofacturas"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByCreationdatetrx", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.creationdatetrx = :creationdatetrx"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByBankname", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.bankname = :bankname"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByTotalamount", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.totalamount = :totalamount"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByReferencenumber", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.referencenumber = :referencenumber"),
    @NamedQuery(name = "XxfrvFacturasparalc.findByPaymenttermdays", query = "SELECT x FROM XxfrvFacturasparalc x WHERE x.paymenttermdays = :paymenttermdays")})
public class XxfrvFacturasparalc implements Serializable {
    @Id
    @Column(name = "NUMREGISTRO")
    private BigInteger numregistro;

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "IDBATCH")
    private String idbatch;
    @Size(max = 20)
    @Column(name = "TIPOCOBRANZA")
    private String tipocobranza;
    @Size(max = 20)
    @Column(name = "DIVISIONTYPE")
    private String divisiontype;
    @Column(name = "PROJECTID")
    private Long projectid;
    @Column(name = "CONTRACTNUMBER")
    private Long contractnumber;
    @Size(max = 20)
    @Column(name = "GROUPTYPE")
    private String grouptype;
    @Column(name = "NUMEROFACTURAS")
    private BigInteger numerofacturas;
    @Size(max = 10)
    @Column(name = "CREATIONDATETRX")
    private String creationdatetrx;
    @Size(max = 20)
    @Column(name = "BANKNAME")
    private String bankname;
    @Size(max = 15)
    @Column(name = "TOTALAMOUNT")
    private String totalamount;
    @Size(max = 20)
    @Column(name = "REFERENCENUMBER")
    private String referencenumber;
    @Column(name = "PAYMENTTERMDAYS")
    private BigInteger paymenttermdays;

    public XxfrvFacturasparalc() {
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    public String getTipocobranza() {
        return tipocobranza;
    }

    public void setTipocobranza(String tipocobranza) {
        this.tipocobranza = tipocobranza;
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

    public BigInteger getNumerofacturas() {
        return numerofacturas;
    }

    public void setNumerofacturas(BigInteger numerofacturas) {
        this.numerofacturas = numerofacturas;
    }

    public String getCreationdatetrx() {
        return creationdatetrx;
    }

    public void setCreationdatetrx(String creationdatetrx) {
        this.creationdatetrx = creationdatetrx;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getReferencenumber() {
        return referencenumber;
    }

    public void setReferencenumber(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public BigInteger getPaymenttermdays() {
        return paymenttermdays;
    }

    public void setPaymenttermdays(BigInteger paymenttermdays) {
        this.paymenttermdays = paymenttermdays;
    }

    public BigInteger getNumregistro() {
        return numregistro;
    }

    public void setNumregistro(BigInteger numregistro) {
        this.numregistro = numregistro;
    }
    
}
