
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lcFacturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lcFacturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billtoconsumername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="companyaccountcode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idfacturaprimavera" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="idlineacaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linenumber" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="montobrutolinea" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="paymenttermdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="projectid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="relatederpinvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxrate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
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
@XmlType(name = "lcFacturaDTO",
         propOrder =
         { "billtoconsumername", "companyaccountcode", "idfacturaprimavera", "idlineacaptura", "linenumber",
           "montobrutolinea", "paymenttermdate", "projectid", "relatederpinvoice", "taxrate", "totalamount"
    })
public class LcFacturaDTO {

    protected String billtoconsumername;
    protected Long companyaccountcode;
    protected BigInteger idfacturaprimavera;
    protected String idlineacaptura;
    protected Short linenumber;
    protected BigDecimal montobrutolinea;
    protected String paymenttermdate;
    protected Long projectid;
    protected String relatederpinvoice;
    protected BigDecimal taxrate;
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
     * Gets the value of the idlineacaptura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdlineacaptura() {
        return idlineacaptura;
    }

    /**
     * Sets the value of the idlineacaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdlineacaptura(String value) {
        this.idlineacaptura = value;
    }

    /**
     * Gets the value of the linenumber property.
     *
     * @return
     *     possible object is
     *     {@link Short }
     *
     */
    public Short getLinenumber() {
        return linenumber;
    }

    /**
     * Sets the value of the linenumber property.
     *
     * @param value
     *     allowed object is
     *     {@link Short }
     *
     */
    public void setLinenumber(Short value) {
        this.linenumber = value;
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
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getTaxrate() {
        return taxrate;
    }

    /**
     * Sets the value of the taxrate property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setTaxrate(BigDecimal value) {
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
