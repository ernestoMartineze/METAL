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
 * @author Ernesto
 */
@Entity
@Table(name = "XXFR_DETALLE_FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrDetalleFactura.findAll", query = "SELECT x FROM XxfrDetalleFactura x")
    , @NamedQuery(name = "XxfrDetalleFactura.findByIdbatch", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.idbatch = :idbatch")
    , @NamedQuery(name = "XxfrDetalleFactura.findByIdfacturaprimavera", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.idfacturaprimavera = :idfacturaprimavera")
    , @NamedQuery(name = "XxfrDetalleFactura.findByOrgid", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.orgid = :orgid")
    , @NamedQuery(name = "XxfrDetalleFactura.findByOrigsystembatchname", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.origsystembatchname = :origsystembatchname")
    , @NamedQuery(name = "XxfrDetalleFactura.findByBillcustomeraccountnumber", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.billcustomeraccountnumber = :billcustomeraccountnumber")
    , @NamedQuery(name = "XxfrDetalleFactura.findByBillcustomersitenumber", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.billcustomersitenumber = :billcustomersitenumber")
    , @NamedQuery(name = "XxfrDetalleFactura.findByTrxdate", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.trxdate = :trxdate")
    , @NamedQuery(name = "XxfrDetalleFactura.findByDescription", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.description = :description")
    , @NamedQuery(name = "XxfrDetalleFactura.findByCurrencycode", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.currencycode = :currencycode")
    , @NamedQuery(name = "XxfrDetalleFactura.findByBatchsourcename", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.batchsourcename = :batchsourcename")
    , @NamedQuery(name = "XxfrDetalleFactura.findByCustomertrxtypename", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.customertrxtypename = :customertrxtypename")
    , @NamedQuery(name = "XxfrDetalleFactura.findByGldate", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.gldate = :gldate")
    , @NamedQuery(name = "XxfrDetalleFactura.findByLinetype", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.linetype = :linetype")
    , @NamedQuery(name = "XxfrDetalleFactura.findByMemolinename", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.memolinename = :memolinename")
    , @NamedQuery(name = "XxfrDetalleFactura.findByQuantity", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.quantity = :quantity")
    , @NamedQuery(name = "XxfrDetalleFactura.findByTaxcode", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.taxcode = :taxcode")
    , @NamedQuery(name = "XxfrDetalleFactura.findByPaymenttermsname", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.paymenttermsname = :paymenttermsname")
    , @NamedQuery(name = "XxfrDetalleFactura.findByUnitsellingprice", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.unitsellingprice = :unitsellingprice")
    , @NamedQuery(name = "XxfrDetalleFactura.findByFlexContext", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.flexContext = :flexContext")
    , @NamedQuery(name = "XxfrDetalleFactura.findByFlexContextDisplayvalue", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.flexContextDisplayvalue = :flexContextDisplayvalue")
    , @NamedQuery(name = "XxfrDetalleFactura.findByFlexNumofsegments", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.flexNumofsegments = :flexNumofsegments")
    , @NamedQuery(name = "XxfrDetalleFactura.findByOrdernumber", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.ordernumber = :ordernumber")
    , @NamedQuery(name = "XxfrDetalleFactura.findByOrderlinenumber", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.orderlinenumber = :orderlinenumber")
    , @NamedQuery(name = "XxfrDetalleFactura.findByDescripcionadicional1", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.descripcionadicional1 = :descripcionadicional1")
    , @NamedQuery(name = "XxfrDetalleFactura.findByDescripcionadicional2", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.descripcionadicional2 = :descripcionadicional2")
    , @NamedQuery(name = "XxfrDetalleFactura.findByDescripcionadicional3", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.descripcionadicional3 = :descripcionadicional3")
    , @NamedQuery(name = "XxfrDetalleFactura.findByDescripcionadicional4", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.descripcionadicional4 = :descripcionadicional4")
    , @NamedQuery(name = "XxfrDetalleFactura.findByDescripcionadicional5", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.descripcionadicional5 = :descripcionadicional5")
    , @NamedQuery(name = "XxfrDetalleFactura.findByPeriododefacturaciondesde", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.periododefacturaciondesde = :periododefacturaciondesde")
    , @NamedQuery(name = "XxfrDetalleFactura.findByPeriododefacturacionhasta", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.periododefacturacionhasta = :periododefacturacionhasta")
    , @NamedQuery(name = "XxfrDetalleFactura.findByFlexContext1", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.flexContext1 = :flexContext1")
    , @NamedQuery(name = "XxfrDetalleFactura.findBySiguientefechadeexigibilidad", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.siguientefechadeexigibilidad = :siguientefechadeexigibilidad")
    , @NamedQuery(name = "XxfrDetalleFactura.findByProyecto", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.proyecto = :proyecto")
    , @NamedQuery(name = "XxfrDetalleFactura.findByNumerodecontrato", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.numerodecontrato = :numerodecontrato")
    , @NamedQuery(name = "XxfrDetalleFactura.findByLineadecaptura", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.lineadecaptura = :lineadecaptura")
    , @NamedQuery(name = "XxfrDetalleFactura.findBySerie", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.serie = :serie")
    , @NamedQuery(name = "XxfrDetalleFactura.findByFolio", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.folio = :folio")
    , @NamedQuery(name = "XxfrDetalleFactura.findByAddendaid", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.addendaid = :addendaid")
    , @NamedQuery(name = "XxfrDetalleFactura.findByFacturaunifier", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.facturaunifier = :facturaunifier")
    , @NamedQuery(name = "XxfrDetalleFactura.findByFlexContext2", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.flexContext2 = :flexContext2")
    , @NamedQuery(name = "XxfrDetalleFactura.findByNumerodelocal", query = "SELECT x FROM XxfrDetalleFactura x WHERE x.numerodelocal = :numerodelocal")})
public class XxfrDetalleFactura implements Serializable {

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private static final long serialVersionUID = 1L;
    @Column(name = "IDFACTURAPRIMAVERA")
    @Id
    private BigInteger idfacturaprimavera;
    @Size(max = 20)
    @Column(name = "IDBATCH")
    private String idbatch;
    @Size(max = 20)
    @Column(name = "ORGID")
    private String orgid;
    @Size(max = 19)
    @Column(name = "ORIGSYSTEMBATCHNAME")
    private String origsystembatchname;
    @Size(max = 20)
    @Column(name = "BILLCUSTOMERACCOUNTNUMBER")
    private String billcustomeraccountnumber;
    @Column(name = "BILLCUSTOMERSITENUMBER")
    private BigInteger billcustomersitenumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRXDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trxdate;
    @Size(max = 11)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 20)
    @Column(name = "CURRENCYCODE")
    private String currencycode;
    @Size(max = 15)
    @Column(name = "BATCHSOURCENAME")
    private String batchsourcename;
    @Size(max = 19)
    @Column(name = "CUSTOMERTRXTYPENAME")
    private String customertrxtypename;
    @Column(name = "GLDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gldate;
    @Size(max = 8)
    @Column(name = "LINETYPE")
    private String linetype;
    @Size(max = 100)
    @Column(name = "MEMOLINENAME")
    private String memolinename;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Size(max = 71)
    @Column(name = "TAXCODE")
    private String taxcode;
    @Size(max = 16)
    @Column(name = "PAYMENTTERMSNAME")
    private String paymenttermsname;
    @Size(max = 12)
    @Column(name = "FLEX_CONTEXT")
    private String flexContext;
    @Size(max = 25)
    @Column(name = "FLEX_CONTEXT_DISPLAYVALUE")
    private String flexContextDisplayvalue;
    @Size(max = 18)
    @Column(name = "FLEX_NUMOFSEGMENTS")
    private String flexNumofsegments;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERLINENUMBER")
    private short orderlinenumber;
    @Size(max = 240)
    @Column(name = "DESCRIPCIONADICIONAL1")
    private String descripcionadicional1;
    @Size(max = 240)
    @Column(name = "DESCRIPCIONADICIONAL2")
    private String descripcionadicional2;
    @Size(max = 240)
    @Column(name = "DESCRIPCIONADICIONAL3")
    private String descripcionadicional3;
    @Size(max = 240)
    @Column(name = "DESCRIPCIONADICIONAL4")
    private String descripcionadicional4;
    @Size(max = 240)
    @Column(name = "DESCRIPCIONADICIONAL5")
    private String descripcionadicional5;
    @Column(name = "PERIODODEFACTURACIONDESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periododefacturaciondesde;
    @Column(name = "PERIODODEFACTURACIONHASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periododefacturacionhasta;
    @Size(max = 12)
    @Column(name = "FLEX_CONTEXT1")
    private String flexContext1;
    @Column(name = "SIGUIENTEFECHADEEXIGIBILIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siguientefechadeexigibilidad;
    @Column(name = "PROYECTO")
    private Long proyecto;
    @Column(name = "NUMERODECONTRATO")
    private Long numerodecontrato;
    @Size(max = 14)
    @Column(name = "LINEADECAPTURA")
    private String lineadecaptura;
    @Size(max = 5)
    @Column(name = "SERIE")
    private String serie;
    @Size(max = 20)
    @Column(name = "FOLIO")
    private String folio;
    @Size(max = 9)
    @Column(name = "ADDENDAID")
    private String addendaid;
    @Size(max = 12)
    @Column(name = "FLEX_CONTEXT2")
    private String flexContext2;
    @Size(max = 20)
    @Column(name = "NUMERODELOCAL")
    private String numerodelocal;
    @Column(name = "UNITSELLINGPRICE")
    private BigDecimal unitsellingprice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERNUMBER")
    private BigInteger ordernumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FACTURAUNIFIER")
    private BigInteger facturaunifier;
    @Column(name = "MONTOIVALINEA")
    private BigInteger montoivalinea;
    @Column(name = "TAXCODERETIVA")
    private BigInteger taxcoderetiva;
    @Column(name = "MONTOTAXCODERETIVA")
    private BigInteger montotaxcoderetiva;
    @Column(name = "TAXCODORETISR")
    private BigInteger taxcodoretisr;
    @Column(name = "MONTOTAXCODORETISR")
    private BigInteger montotaxcodoretisr;
    @Size(max = 100)
    @Column(name = "DESCRIPORIGEN")
    private String descriporigen;
    @Size(max = 100)
    @Column(name = "DESCRIPMANUAL")
    private String descripmanual;
    @Size(max = 20)
    @Column(name = "BUSINESSUNIT")
    private String businessunit;

    public XxfrDetalleFactura() {
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrigsystembatchname() {
        return origsystembatchname;
    }

    public void setOrigsystembatchname(String origsystembatchname) {
        this.origsystembatchname = origsystembatchname;
    }

    public String getBillcustomeraccountnumber() {
        return billcustomeraccountnumber;
    }

    public void setBillcustomeraccountnumber(String billcustomeraccountnumber) {
        this.billcustomeraccountnumber = billcustomeraccountnumber;
    }

    public BigInteger getBillcustomersitenumber() {
        return billcustomersitenumber;
    }

    public void setBillcustomersitenumber(BigInteger billcustomersitenumber) {
        this.billcustomersitenumber = billcustomersitenumber;
    }

    public Date getTrxdate() {
        return trxdate;
    }

    public void setTrxdate(Date trxdate) {
        this.trxdate = trxdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public String getBatchsourcename() {
        return batchsourcename;
    }

    public void setBatchsourcename(String batchsourcename) {
        this.batchsourcename = batchsourcename;
    }

    public String getCustomertrxtypename() {
        return customertrxtypename;
    }

    public void setCustomertrxtypename(String customertrxtypename) {
        this.customertrxtypename = customertrxtypename;
    }

    public Date getGldate() {
        return gldate;
    }

    public void setGldate(Date gldate) {
        this.gldate = gldate;
    }

    public String getLinetype() {
        return linetype;
    }

    public void setLinetype(String linetype) {
        this.linetype = linetype;
    }

    public String getMemolinename() {
        return memolinename;
    }

    public void setMemolinename(String memolinename) {
        this.memolinename = memolinename;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode;
    }

    public String getPaymenttermsname() {
        return paymenttermsname;
    }

    public void setPaymenttermsname(String paymenttermsname) {
        this.paymenttermsname = paymenttermsname;
    }


    public String getFlexContext() {
        return flexContext;
    }

    public void setFlexContext(String flexContext) {
        this.flexContext = flexContext;
    }

    public String getFlexContextDisplayvalue() {
        return flexContextDisplayvalue;
    }

    public void setFlexContextDisplayvalue(String flexContextDisplayvalue) {
        this.flexContextDisplayvalue = flexContextDisplayvalue;
    }

    public String getFlexNumofsegments() {
        return flexNumofsegments;
    }

    public void setFlexNumofsegments(String flexNumofsegments) {
        this.flexNumofsegments = flexNumofsegments;
    }


    public short getOrderlinenumber() {
        return orderlinenumber;
    }

    public void setOrderlinenumber(short orderlinenumber) {
        this.orderlinenumber = orderlinenumber;
    }

    public String getDescripcionadicional1() {
        return descripcionadicional1;
    }

    public void setDescripcionadicional1(String descripcionadicional1) {
        this.descripcionadicional1 = descripcionadicional1;
    }

    public String getDescripcionadicional2() {
        return descripcionadicional2;
    }

    public void setDescripcionadicional2(String descripcionadicional2) {
        this.descripcionadicional2 = descripcionadicional2;
    }

    public String getDescripcionadicional3() {
        return descripcionadicional3;
    }

    public void setDescripcionadicional3(String descripcionadicional3) {
        this.descripcionadicional3 = descripcionadicional3;
    }

    public String getDescripcionadicional4() {
        return descripcionadicional4;
    }

    public void setDescripcionadicional4(String descripcionadicional4) {
        this.descripcionadicional4 = descripcionadicional4;
    }

    public String getDescripcionadicional5() {
        return descripcionadicional5;
    }

    public void setDescripcionadicional5(String descripcionadicional5) {
        this.descripcionadicional5 = descripcionadicional5;
    }

    public Date getPeriododefacturaciondesde() {
        return periododefacturaciondesde;
    }

    public void setPeriododefacturaciondesde(Date periododefacturaciondesde) {
        this.periododefacturaciondesde = periododefacturaciondesde;
    }

    public Date getPeriododefacturacionhasta() {
        return periododefacturacionhasta;
    }

    public void setPeriododefacturacionhasta(Date periododefacturacionhasta) {
        this.periododefacturacionhasta = periododefacturacionhasta;
    }

    public String getFlexContext1() {
        return flexContext1;
    }

    public void setFlexContext1(String flexContext1) {
        this.flexContext1 = flexContext1;
    }

    public Date getSiguientefechadeexigibilidad() {
        return siguientefechadeexigibilidad;
    }

    public void setSiguientefechadeexigibilidad(Date siguientefechadeexigibilidad) {
        this.siguientefechadeexigibilidad = siguientefechadeexigibilidad;
    }

    public Long getProyecto() {
        return proyecto;
    }

    public void setProyecto(Long proyecto) {
        this.proyecto = proyecto;
    }

    public Long getNumerodecontrato() {
        return numerodecontrato;
    }

    public void setNumerodecontrato(Long numerodecontrato) {
        this.numerodecontrato = numerodecontrato;
    }

    public String getLineadecaptura() {
        return lineadecaptura;
    }

    public void setLineadecaptura(String lineadecaptura) {
        this.lineadecaptura = lineadecaptura;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getAddendaid() {
        return addendaid;
    }

    public void setAddendaid(String addendaid) {
        this.addendaid = addendaid;
    }


    public String getFlexContext2() {
        return flexContext2;
    }

    public void setFlexContext2(String flexContext2) {
        this.flexContext2 = flexContext2;
    }

    public String getNumerodelocal() {
        return numerodelocal;
    }

    public void setNumerodelocal(String numerodelocal) {
        this.numerodelocal = numerodelocal;
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    public BigDecimal getUnitsellingprice() {
        return unitsellingprice;
    }

    public void setUnitsellingprice(BigDecimal unitsellingprice) {
        this.unitsellingprice = unitsellingprice;
    }

    public BigInteger getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(BigInteger ordernumber) {
        this.ordernumber = ordernumber;
    }

    public BigInteger getFacturaunifier() {
        return facturaunifier;
    }

    public void setFacturaunifier(BigInteger facturaunifier) {
        this.facturaunifier = facturaunifier;
    }

    public BigInteger getMontoivalinea() {
        return montoivalinea;
    }

    public void setMontoivalinea(BigInteger montoivalinea) {
        this.montoivalinea = montoivalinea;
    }

    public BigInteger getTaxcoderetiva() {
        return taxcoderetiva;
    }

    public void setTaxcoderetiva(BigInteger taxcoderetiva) {
        this.taxcoderetiva = taxcoderetiva;
    }

    public BigInteger getMontotaxcoderetiva() {
        return montotaxcoderetiva;
    }

    public void setMontotaxcoderetiva(BigInteger montotaxcoderetiva) {
        this.montotaxcoderetiva = montotaxcoderetiva;
    }

    public BigInteger getTaxcodoretisr() {
        return taxcodoretisr;
    }

    public void setTaxcodoretisr(BigInteger taxcodoretisr) {
        this.taxcodoretisr = taxcodoretisr;
    }

    public BigInteger getMontotaxcodoretisr() {
        return montotaxcodoretisr;
    }

    public void setMontotaxcodoretisr(BigInteger montotaxcodoretisr) {
        this.montotaxcodoretisr = montotaxcodoretisr;
    }

    public String getDescriporigen() {
        return descriporigen;
    }

    public void setDescriporigen(String descriporigen) {
        this.descriporigen = descriporigen;
    }

    public String getDescripmanual() {
        return descripmanual;
    }

    public void setDescripmanual(String descripmanual) {
        this.descripmanual = descripmanual;
    }

    public String getBusinessunit() {
        return businessunit;
    }

    public void setBusinessunit(String businessunit) {
        this.businessunit = businessunit;
    }
    
}
