
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for lcFactDetDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lcFactDetDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billtoconsumername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="businessunitname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="companyaccountcode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="entidadlegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechavigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idfacturaprimavera" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="impuestos" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="lineacaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="montoFactura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="montoLineacaptura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="montoPagado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="montobrutolinea" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="paymenttermdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="projectid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="relatederpinvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxrate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="totalamount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lcFactDetDTO",
         propOrder =
         { "billtoconsumername", "businessunitname", "companyaccountcode", "entidadlegal", "fechavigencia",
           "idfacturaprimavera", "impuestos", "lineacaptura", "montoFactura", "montoLineacaptura", "montoPagado",
           "montobrutolinea", "paymenttermdate", "projectid", "relatederpinvoice", "taxrate", "totalamount"
    })
public class LcFactDetDTO {

    protected String billtoconsumername;
    protected String businessunitname;
    protected Long companyaccountcode;
    protected String entidadlegal;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechavigencia;
    protected BigInteger idfacturaprimavera;
    protected BigInteger impuestos;
    protected String lineacaptura;
    protected BigDecimal montoFactura;
    protected BigDecimal montoLineacaptura;
    protected BigDecimal montoPagado;
    protected BigDecimal montobrutolinea;
    protected String paymenttermdate;
    protected Long projectid;
    protected String relatederpinvoice;
    protected String taxrate;
    protected BigDecimal totalamount;

    /**
     * Gets the value of the billtoconsumername property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBilltoconsumername() {
        return billtoconsumername;
    }

    /**
     * Sets the value of the billtoconsumername property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBilltoconsumername(String value) {
        this.billtoconsumername = value;
    }

    /**
     * Gets the value of the businessunitname property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBusinessunitname() {
        return businessunitname;
    }

    /**
     * Sets the value of the businessunitname property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBusinessunitname(String value) {
        this.businessunitname = value;
    }

    /**
     * Gets the value of the companyaccountcode property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getCompanyaccountcode() {
        return companyaccountcode;
    }

    /**
     * Sets the value of the companyaccountcode property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setCompanyaccountcode(Long value) {
        this.companyaccountcode = value;
    }

    /**
     * Gets the value of the entidadlegal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEntidadlegal() {
        return entidadlegal;
    }

    /**
     * Sets the value of the entidadlegal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEntidadlegal(String value) {
        this.entidadlegal = value;
    }

    /**
     * Gets the value of the fechavigencia property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechavigencia() {
        return fechavigencia;
    }

    /**
     * Sets the value of the fechavigencia property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechavigencia(XMLGregorianCalendar value) {
        this.fechavigencia = value;
    }

    /**
     * Gets the value of the idfacturaprimavera property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    /**
     * Sets the value of the idfacturaprimavera property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdfacturaprimavera(BigInteger value) {
        this.idfacturaprimavera = value;
    }

    /**
     * Gets the value of the impuestos property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getImpuestos() {
        return impuestos;
    }

    /**
     * Sets the value of the impuestos property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setImpuestos(BigInteger value) {
        this.impuestos = value;
    }

    /**
     * Gets the value of the lineacaptura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineacaptura() {
        return lineacaptura;
    }

    /**
     * Sets the value of the lineacaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineacaptura(String value) {
        this.lineacaptura = value;
    }

    /**
     * Gets the value of the montoFactura property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoFactura() {
        return montoFactura;
    }

    /**
     * Sets the value of the montoFactura property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoFactura(BigDecimal value) {
        this.montoFactura = value;
    }

    /**
     * Gets the value of the montoLineacaptura property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoLineacaptura() {
        return montoLineacaptura;
    }

    /**
     * Sets the value of the montoLineacaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoLineacaptura(BigDecimal value) {
        this.montoLineacaptura = value;
    }

    /**
     * Gets the value of the montoPagado property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    /**
     * Sets the value of the montoPagado property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoPagado(BigDecimal value) {
        this.montoPagado = value;
    }

    /**
     * Gets the value of the montobrutolinea property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontobrutolinea() {
        return montobrutolinea;
    }

    /**
     * Sets the value of the montobrutolinea property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontobrutolinea(BigDecimal value) {
        this.montobrutolinea = value;
    }

    /**
     * Gets the value of the paymenttermdate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaymenttermdate() {
        return paymenttermdate;
    }

    /**
     * Sets the value of the paymenttermdate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaymenttermdate(String value) {
        this.paymenttermdate = value;
    }

    /**
     * Gets the value of the projectid property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getProjectid() {
        return projectid;
    }

    /**
     * Sets the value of the projectid property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setProjectid(Long value) {
        this.projectid = value;
    }

    /**
     * Gets the value of the relatederpinvoice property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRelatederpinvoice() {
        return relatederpinvoice;
    }

    /**
     * Sets the value of the relatederpinvoice property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRelatederpinvoice(String value) {
        this.relatederpinvoice = value;
    }

    /**
     * Gets the value of the taxrate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTaxrate() {
        return taxrate;
    }

    /**
     * Sets the value of the taxrate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaxrate(String value) {
        this.taxrate = value;
    }

    /**
     * Gets the value of the totalamount property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTotalamount() {
        return totalamount;
    }

    /**
     * Sets the value of the totalamount property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTotalamount(BigDecimal value) {
        this.totalamount = value;
    }

}
