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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER_1
 */
@Entity
@Table(name = "XXFR_INVOICE_LINES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "XxfrInvoiceLines.findAll", query = "SELECT x FROM XxfrInvoiceLines x"),
    @NamedQuery(name = "XxfrInvoiceLines.findByIdfacturaprimavera", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.xxfrInvoiceLinesPK.idfacturaprimavera = :idfacturaprimavera"),
    @NamedQuery(name = "XxfrInvoiceLines.findByLinenumber", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.xxfrInvoiceLinesPK.linenumber = :linenumber"),
    @NamedQuery(name = "XxfrInvoiceLines.findByDescriptionOrigen", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.descriptionOrigen = :descriptionOrigen"),
    @NamedQuery(name = "XxfrInvoiceLines.findByDescriptionmanual", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.descriptionmanual = :descriptionmanual"),
    @NamedQuery(name = "XxfrInvoiceLines.findByMemolinename", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.memolinename = :memolinename"),
    @NamedQuery(name = "XxfrInvoiceLines.findByQuantity", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.quantity = :quantity"),
    @NamedQuery(name = "XxfrInvoiceLines.findByTaxclassificationcode", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.taxclassificationcode = :taxclassificationcode"),
    @NamedQuery(name = "XxfrInvoiceLines.findByTaxrate", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.taxrate = :taxrate"),
    @NamedQuery(name = "XxfrInvoiceLines.findByClasificadordescuento", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.clasificadordescuento = :clasificadordescuento"),
    @NamedQuery(name = "XxfrInvoiceLines.findByDescadicional1", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.descadicional1 = :descadicional1"),
    @NamedQuery(name = "XxfrInvoiceLines.findByDescadicional2", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.descadicional2 = :descadicional2"),
    @NamedQuery(name = "XxfrInvoiceLines.findByDescadicional3", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.descadicional3 = :descadicional3"),
    @NamedQuery(name = "XxfrInvoiceLines.findByDescadicional4", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.descadicional4 = :descadicional4"),
    @NamedQuery(name = "XxfrInvoiceLines.findByDescadicional5", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.descadicional5 = :descadicional5"),
    @NamedQuery(name = "XxfrInvoiceLines.findByMontobrutolinea", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.montobrutolinea = :montobrutolinea"),
    @NamedQuery(name = "XxfrInvoiceLines.findByMontonetolinea", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.montonetolinea = :montonetolinea"),
    @NamedQuery(name = "XxfrInvoiceLines.findByIdconcepto", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.idconcepto = :idconcepto"),
    @NamedQuery(name = "XxfrInvoiceLines.findByFechadesde", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.fechadesde = :fechadesde"),
    @NamedQuery(name = "XxfrInvoiceLines.findByFechahasta", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.fechahasta = :fechahasta"),
    @NamedQuery(name = "XxfrInvoiceLines.findByFechaexigibilidad", query = "SELECT x FROM XxfrInvoiceLines x WHERE x.fechaexigibilidad = :fechaexigibilidad")})
public class XxfrInvoiceLines implements Serializable {

    @JoinColumn(name = "IDFACTURAPRIMAVERA", referencedColumnName = "IDFACTURAPRIMAVERA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private XxfrCabeceraFactura xxfrCabeceraFactura;

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected XxfrInvoiceLinesPK xxfrInvoiceLinesPK;
    @Size(max = 100)
    @Column(name = "DESCRIPTION_ORIGEN")
    private String descriptionOrigen;
    @Size(max = 100)
    @Column(name = "DESCRIPTIONMANUAL")
    private String descriptionmanual;
    @Size(max = 100)
    @Column(name = "MEMOLINENAME")
    private String memolinename;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Size(max = 30)
    @Column(name = "TAXCLASSIFICATIONCODE")
    private String taxclassificationcode;
    @Column(name = "TAXRATE")
    private BigInteger taxrate;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTOBRUTOLINEA")
    private BigDecimal montobrutolinea;
    @Column(name = "MONTONETOLINEA")
    private BigDecimal montonetolinea;
    @Column(name = "IDCONCEPTO")
    private Long idconcepto;
    @Column(name = "FECHADESDE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadesde;
    @Column(name = "FECHAHASTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahasta;
    @Column(name = "FECHAEXIGIBILIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaexigibilidad;

    public XxfrInvoiceLines() {
    }

    public XxfrInvoiceLines(XxfrInvoiceLinesPK xxfrInvoiceLinesPK) {
        this.xxfrInvoiceLinesPK = xxfrInvoiceLinesPK;
    }

    public XxfrInvoiceLines(BigInteger idfacturaprimavera, short linenumber) {
        this.xxfrInvoiceLinesPK = new XxfrInvoiceLinesPK(idfacturaprimavera, linenumber);
    }

    public XxfrInvoiceLinesPK getXxfrInvoiceLinesPK() {
        return xxfrInvoiceLinesPK;
    }

    public void setXxfrInvoiceLinesPK(XxfrInvoiceLinesPK xxfrInvoiceLinesPK) {
        this.xxfrInvoiceLinesPK = xxfrInvoiceLinesPK;
    }

    public String getDescriptionOrigen() {
        return descriptionOrigen;
    }

    public void setDescriptionOrigen(String descriptionOrigen) {
        this.descriptionOrigen = descriptionOrigen;
    }

    public String getDescriptionmanual() {
        return descriptionmanual;
    }

    public void setDescriptionmanual(String descriptionmanual) {
        this.descriptionmanual = descriptionmanual;
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

    public String getTaxclassificationcode() {
        return taxclassificationcode;
    }

    public void setTaxclassificationcode(String taxclassificationcode) {
        this.taxclassificationcode = taxclassificationcode;
    }

    public BigInteger getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigInteger taxrate) {
        this.taxrate = taxrate;
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

    public BigDecimal getMontobrutolinea() {
        return montobrutolinea;
    }

    public void setMontobrutolinea(BigDecimal montobrutolinea) {
        this.montobrutolinea = montobrutolinea;
    }

    public BigDecimal getMontonetolinea() {
        return montonetolinea;
    }

    public void setMontonetolinea(BigDecimal montonetolinea) {
        this.montonetolinea = montonetolinea;
    }

    public Long getIdconcepto() {
        return idconcepto;
    }

    public void setIdconcepto(Long idconcepto) {
        this.idconcepto = idconcepto;
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

    public Date getFechaexigibilidad() {
        return fechaexigibilidad;
    }

    public void setFechaexigibilidad(Date fechaexigibilidad) {
        this.fechaexigibilidad = fechaexigibilidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xxfrInvoiceLinesPK != null ? xxfrInvoiceLinesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XxfrInvoiceLines)) {
            return false;
        }
        XxfrInvoiceLines other = (XxfrInvoiceLines) object;
        if ((this.xxfrInvoiceLinesPK == null && other.xxfrInvoiceLinesPK != null) || (this.xxfrInvoiceLinesPK != null && !this.xxfrInvoiceLinesPK.equals(other.xxfrInvoiceLinesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.frisa.tic.datos.entidades.XxfrInvoiceLines[ xxfrInvoiceLinesPK=" + xxfrInvoiceLinesPK + " ]";
    }

    public XxfrCabeceraFactura getXxfrCabeceraFactura() {
        return xxfrCabeceraFactura;
    }

    public void setXxfrCabeceraFactura(XxfrCabeceraFactura xxfrCabeceraFactura) {
        this.xxfrCabeceraFactura = xxfrCabeceraFactura;
    }
    
}
