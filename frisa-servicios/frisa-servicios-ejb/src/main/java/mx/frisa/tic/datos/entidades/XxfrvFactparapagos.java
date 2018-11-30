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
 * @author Soultech
 */
@Entity
@Table(name = "XXFRV_FACTPARAPAGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrvFactparapagos.findAll", query = "SELECT x FROM XxfrvFactparapagos x")
    , @NamedQuery(name = "XxfrvFactparapagos.findByIdlinea", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.idlinea = :idlinea")
    , @NamedQuery(name = "XxfrvFactparapagos.findByBusinessunitname", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.businessunitname = :businessunitname")
    , @NamedQuery(name = "XxfrvFactparapagos.findByTransactionsource", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.transactionsource = :transactionsource")
    , @NamedQuery(name = "XxfrvFactparapagos.findByTransactiontype", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.transactiontype = :transactiontype")
    , @NamedQuery(name = "XxfrvFactparapagos.findByCreationdatetrx", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.creationdatetrx = :creationdatetrx")
    , @NamedQuery(name = "XxfrvFactparapagos.findByCreationdategl", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.creationdategl = :creationdategl")
    , @NamedQuery(name = "XxfrvFactparapagos.findByBilltoconsumername", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.billtoconsumername = :billtoconsumername")
    , @NamedQuery(name = "XxfrvFactparapagos.findByBilltolocation", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.billtolocation = :billtolocation")
    , @NamedQuery(name = "XxfrvFactparapagos.findByPaymenttermdays", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.paymenttermdays = :paymenttermdays")
    , @NamedQuery(name = "XxfrvFactparapagos.findByGenerationtype", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.generationtype = :generationtype")
    , @NamedQuery(name = "XxfrvFactparapagos.findByIdfacturaprimavera", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.idfacturaprimavera = :idfacturaprimavera")
    , @NamedQuery(name = "XxfrvFactparapagos.findByLinenumber", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.linenumber = :linenumber")
    , @NamedQuery(name = "XxfrvFactparapagos.findByMemolinename", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.memolinename = :memolinename")
    , @NamedQuery(name = "XxfrvFactparapagos.findByDescriptionOrigen", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.descriptionOrigen = :descriptionOrigen")
    , @NamedQuery(name = "XxfrvFactparapagos.findByQuantity", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.quantity = :quantity")
    , @NamedQuery(name = "XxfrvFactparapagos.findByMontobrutolinea", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.montobrutolinea = :montobrutolinea")
    , @NamedQuery(name = "XxfrvFactparapagos.findByClasificadordescuento", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.clasificadordescuento = :clasificadordescuento")
    , @NamedQuery(name = "XxfrvFactparapagos.findByDescadicional1", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.descadicional1 = :descadicional1")
    , @NamedQuery(name = "XxfrvFactparapagos.findByDescadicional2", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.descadicional2 = :descadicional2")
    , @NamedQuery(name = "XxfrvFactparapagos.findByDescadicional3", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.descadicional3 = :descadicional3")
    , @NamedQuery(name = "XxfrvFactparapagos.findByDescadicional4", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.descadicional4 = :descadicional4")
    , @NamedQuery(name = "XxfrvFactparapagos.findByDescadicional5", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.descadicional5 = :descadicional5")
    , @NamedQuery(name = "XxfrvFactparapagos.findByFechadesde", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.fechadesde = :fechadesde")
    , @NamedQuery(name = "XxfrvFactparapagos.findByFechahasta", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.fechahasta = :fechahasta")
    , @NamedQuery(name = "XxfrvFactparapagos.findByDffheadercontext", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.dffheadercontext = :dffheadercontext")
    , @NamedQuery(name = "XxfrvFactparapagos.findByFechaexigibilidad", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.fechaexigibilidad = :fechaexigibilidad")
    , @NamedQuery(name = "XxfrvFactparapagos.findByProjectid", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.projectid = :projectid")
    , @NamedQuery(name = "XxfrvFactparapagos.findByFolioavisocargo", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.folioavisocargo = :folioavisocargo")
    , @NamedQuery(name = "XxfrvFactparapagos.findByLocalnumber", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.localnumber = :localnumber")
    , @NamedQuery(name = "XxfrvFactparapagos.findByLineacaptura", query = "SELECT x FROM XxfrvFactparapagos x WHERE x.lineacaptura = :lineacaptura")})
public class XxfrvFactparapagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Size(max = 52)
    @Column(name = "IDLINEA")
    private String idlinea;
    @Size(max = 20)
    @Column(name = "BUSINESSUNITNAME")
    private String businessunitname;
    @Size(max = 20)
    @Column(name = "TRANSACTIONSOURCE")
    private String transactionsource;
    @Size(max = 20)
    @Column(name = "TRANSACTIONTYPE")
    private String transactiontype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATIONDATETRX")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdatetrx;
    @Column(name = "CREATIONDATEGL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdategl;
    @Size(max = 240)
    @Column(name = "BILLTOCONSUMERNAME")
    private String billtoconsumername;
    @Column(name = "BILLTOLOCATION")
    private Long billtolocation;
    @Column(name = "PAYMENTTERMDAYS")
    private Short paymenttermdays;
    @Size(max = 21)
    @Column(name = "GENERATIONTYPE")
    private String generationtype;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFACTURAPRIMAVERA")
    private BigInteger idfacturaprimavera;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LINENUMBER")
    private short linenumber;
    @Size(max = 100)
    @Column(name = "MEMOLINENAME")
    private String memolinename;
    @Size(max = 100)
    @Column(name = "DESCRIPTION_ORIGEN")
    private String descriptionOrigen;
    @Column(name = "QUANTITY")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTOBRUTOLINEA")
    private BigDecimal montobrutolinea;
    @Size(max = 20)
    @Column(name = "CLASIFICADORDESCUENTO")
    private String clasificadordescuento;
    @Size(max = 240)
    @Column(name = "DESCADICIONAL1")
    private String descadicional1;
    @Size(max = 240)
    @Column(name = "DESCADICIONAL2")
    private String descadicional2;
    @Size(max = 240)
    @Column(name = "DESCADICIONAL3")
    private String descadicional3;
    @Size(max = 240)
    @Column(name = "DESCADICIONAL4")
    private String descadicional4;
    @Size(max = 240)
    @Column(name = "DESCADICIONAL5")
    private String descadicional5;
    @Column(name = "FECHADESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadesde;
    @Column(name = "FECHAHASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahasta;
    @Size(max = 20)
    @Column(name = "DFFHEADERCONTEXT")
    private String dffheadercontext;
    @Column(name = "FECHAEXIGIBILIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaexigibilidad;
    @Column(name = "PROJECTID")
    private Long projectid;
    @Size(max = 20)
    @Column(name = "FOLIOAVISOCARGO")
    private String folioavisocargo;
    @Size(max = 20)
    @Column(name = "LOCALNUMBER")
    private String localnumber;
    @Size(max = 30)
    @Column(name = "LINEACAPTURA")
    private String lineacaptura;

    public XxfrvFactparapagos() {
    }

    public String getIdlinea() {
        return idlinea;
    }

    public void setIdlinea(String idlinea) {
        this.idlinea = idlinea;
    }

    public String getBusinessunitname() {
        return businessunitname;
    }

    public void setBusinessunitname(String businessunitname) {
        this.businessunitname = businessunitname;
    }

    public String getTransactionsource() {
        return transactionsource;
    }

    public void setTransactionsource(String transactionsource) {
        this.transactionsource = transactionsource;
    }

    public String getTransactiontype() {
        return transactiontype;
    }

    public void setTransactiontype(String transactiontype) {
        this.transactiontype = transactiontype;
    }

    public Date getCreationdatetrx() {
        return creationdatetrx;
    }

    public void setCreationdatetrx(Date creationdatetrx) {
        this.creationdatetrx = creationdatetrx;
    }

    public Date getCreationdategl() {
        return creationdategl;
    }

    public void setCreationdategl(Date creationdategl) {
        this.creationdategl = creationdategl;
    }

    public String getBilltoconsumername() {
        return billtoconsumername;
    }

    public void setBilltoconsumername(String billtoconsumername) {
        this.billtoconsumername = billtoconsumername;
    }

    public Long getBilltolocation() {
        return billtolocation;
    }

    public void setBilltolocation(Long billtolocation) {
        this.billtolocation = billtolocation;
    }

    public Short getPaymenttermdays() {
        return paymenttermdays;
    }

    public void setPaymenttermdays(Short paymenttermdays) {
        this.paymenttermdays = paymenttermdays;
    }

    public String getGenerationtype() {
        return generationtype;
    }

    public void setGenerationtype(String generationtype) {
        this.generationtype = generationtype;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public short getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(short linenumber) {
        this.linenumber = linenumber;
    }

    public String getMemolinename() {
        return memolinename;
    }

    public void setMemolinename(String memolinename) {
        this.memolinename = memolinename;
    }

    public String getDescriptionOrigen() {
        return descriptionOrigen;
    }

    public void setDescriptionOrigen(String descriptionOrigen) {
        this.descriptionOrigen = descriptionOrigen;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getMontobrutolinea() {
        return montobrutolinea;
    }

    public void setMontobrutolinea(BigDecimal montobrutolinea) {
        this.montobrutolinea = montobrutolinea;
    }

    public String getClasificadordescuento() {
        return clasificadordescuento;
    }

    public void setClasificadordescuento(String clasificadordescuento) {
        this.clasificadordescuento = clasificadordescuento;
    }

    public String getDescadicional1() {
        return descadicional1;
    }

    public void setDescadicional1(String descadicional1) {
        this.descadicional1 = descadicional1;
    }

    public String getDescadicional2() {
        return descadicional2;
    }

    public void setDescadicional2(String descadicional2) {
        this.descadicional2 = descadicional2;
    }

    public String getDescadicional3() {
        return descadicional3;
    }

    public void setDescadicional3(String descadicional3) {
        this.descadicional3 = descadicional3;
    }

    public String getDescadicional4() {
        return descadicional4;
    }

    public void setDescadicional4(String descadicional4) {
        this.descadicional4 = descadicional4;
    }

    public String getDescadicional5() {
        return descadicional5;
    }

    public void setDescadicional5(String descadicional5) {
        this.descadicional5 = descadicional5;
    }

    public Date getFechadesde() {
        return fechadesde;
    }

    public void setFechadesde(Date fechadesde) {
        this.fechadesde = fechadesde;
    }

    public Date getFechahasta() {
        return fechahasta;
    }

    public void setFechahasta(Date fechahasta) {
        this.fechahasta = fechahasta;
    }

    public String getDffheadercontext() {
        return dffheadercontext;
    }

    public void setDffheadercontext(String dffheadercontext) {
        this.dffheadercontext = dffheadercontext;
    }

    public Date getFechaexigibilidad() {
        return fechaexigibilidad;
    }

    public void setFechaexigibilidad(Date fechaexigibilidad) {
        this.fechaexigibilidad = fechaexigibilidad;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public String getFolioavisocargo() {
        return folioavisocargo;
    }

    public void setFolioavisocargo(String folioavisocargo) {
        this.folioavisocargo = folioavisocargo;
    }

    public String getLocalnumber() {
        return localnumber;
    }

    public void setLocalnumber(String localnumber) {
        this.localnumber = localnumber;
    }

    public String getLineacaptura() {
        return lineacaptura;
    }

    public void setLineacaptura(String lineacaptura) {
        this.lineacaptura = lineacaptura;
    }
    
}
