
package mx.frisa.tic.negocio.ws;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for facturaPagoDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="facturaPagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billtoconsumername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billtolocation" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="businessunitname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="clasificadordescuento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creationdategl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creationdatetrx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descadicional1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descadicional2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descadicional3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descadicional4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descadicional5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description_origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dffheadercontext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechadesde" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaexigibilidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechahasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="folioavisocargo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="generationtype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idfacturaprimavera" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="idlinea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lineacaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="linenumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="localnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memolinename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="montobrutolinea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="paymenttermdays" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/&gt;
 *         &lt;element name="projectid" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="transactionsource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactiontype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "facturaPagoDTO",
         propOrder =
         { "billtoconsumername", "billtolocation", "businessunitname", "clasificadordescuento", "creationdategl",
           "creationdatetrx", "descadicional1", "descadicional2", "descadicional3", "descadicional4", "descadicional5",
           "descriptionOrigen", "dffheadercontext", "fechadesde", "fechaexigibilidad", "fechahasta", "folioavisocargo",
           "generationtype", "idfacturaprimavera", "idlinea", "lineacaptura", "linenumber", "localnumber",
           "memolinename", "montobrutolinea", "paymenttermdays", "projectid", "quantity", "transactionsource",
           "transactiontype"
    })
public class FacturaPagoDTO {

    protected String billtoconsumername;
    protected BigInteger billtolocation;
    protected String businessunitname;
    protected String clasificadordescuento;
    protected String creationdategl;
    protected String creationdatetrx;
    protected String descadicional1;
    protected String descadicional2;
    protected String descadicional3;
    protected String descadicional4;
    protected String descadicional5;
    @XmlElement(name = "description_origen")
    protected String descriptionOrigen;
    protected String dffheadercontext;
    protected String fechadesde;
    protected String fechaexigibilidad;
    protected String fechahasta;
    protected String folioavisocargo;
    protected String generationtype;
    protected BigInteger idfacturaprimavera;
    protected String idlinea;
    protected String lineacaptura;
    protected BigInteger linenumber;
    protected String localnumber;
    protected String memolinename;
    protected BigInteger montobrutolinea;
    protected Short paymenttermdays;
    protected BigInteger projectid;
    protected BigInteger quantity;
    protected String transactionsource;
    protected String transactiontype;

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
     * Gets the value of the billtolocation property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getBilltolocation() {
        return billtolocation;
    }

    /**
     * Sets the value of the billtolocation property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setBilltolocation(BigInteger value) {
        this.billtolocation = value;
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
     * Gets the value of the clasificadordescuento property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClasificadordescuento() {
        return clasificadordescuento;
    }

    /**
     * Sets the value of the clasificadordescuento property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClasificadordescuento(String value) {
        this.clasificadordescuento = value;
    }

    /**
     * Gets the value of the creationdategl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreationdategl() {
        return creationdategl;
    }

    /**
     * Sets the value of the creationdategl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreationdategl(String value) {
        this.creationdategl = value;
    }

    /**
     * Gets the value of the creationdatetrx property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCreationdatetrx() {
        return creationdatetrx;
    }

    /**
     * Sets the value of the creationdatetrx property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCreationdatetrx(String value) {
        this.creationdatetrx = value;
    }

    /**
     * Gets the value of the descadicional1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescadicional1() {
        return descadicional1;
    }

    /**
     * Sets the value of the descadicional1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescadicional1(String value) {
        this.descadicional1 = value;
    }

    /**
     * Gets the value of the descadicional2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescadicional2() {
        return descadicional2;
    }

    /**
     * Sets the value of the descadicional2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescadicional2(String value) {
        this.descadicional2 = value;
    }

    /**
     * Gets the value of the descadicional3 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescadicional3() {
        return descadicional3;
    }

    /**
     * Sets the value of the descadicional3 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescadicional3(String value) {
        this.descadicional3 = value;
    }

    /**
     * Gets the value of the descadicional4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescadicional4() {
        return descadicional4;
    }

    /**
     * Sets the value of the descadicional4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescadicional4(String value) {
        this.descadicional4 = value;
    }

    /**
     * Gets the value of the descadicional5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescadicional5() {
        return descadicional5;
    }

    /**
     * Sets the value of the descadicional5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescadicional5(String value) {
        this.descadicional5 = value;
    }

    /**
     * Gets the value of the descriptionOrigen property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescriptionOrigen() {
        return descriptionOrigen;
    }

    /**
     * Sets the value of the descriptionOrigen property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescriptionOrigen(String value) {
        this.descriptionOrigen = value;
    }

    /**
     * Gets the value of the dffheadercontext property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDffheadercontext() {
        return dffheadercontext;
    }

    /**
     * Sets the value of the dffheadercontext property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDffheadercontext(String value) {
        this.dffheadercontext = value;
    }

    /**
     * Gets the value of the fechadesde property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechadesde() {
        return fechadesde;
    }

    /**
     * Sets the value of the fechadesde property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechadesde(String value) {
        this.fechadesde = value;
    }

    /**
     * Gets the value of the fechaexigibilidad property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechaexigibilidad() {
        return fechaexigibilidad;
    }

    /**
     * Sets the value of the fechaexigibilidad property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechaexigibilidad(String value) {
        this.fechaexigibilidad = value;
    }

    /**
     * Gets the value of the fechahasta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechahasta() {
        return fechahasta;
    }

    /**
     * Sets the value of the fechahasta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechahasta(String value) {
        this.fechahasta = value;
    }

    /**
     * Gets the value of the folioavisocargo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFolioavisocargo() {
        return folioavisocargo;
    }

    /**
     * Sets the value of the folioavisocargo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFolioavisocargo(String value) {
        this.folioavisocargo = value;
    }

    /**
     * Gets the value of the generationtype property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGenerationtype() {
        return generationtype;
    }

    /**
     * Sets the value of the generationtype property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGenerationtype(String value) {
        this.generationtype = value;
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
     * Gets the value of the idlinea property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdlinea() {
        return idlinea;
    }

    /**
     * Sets the value of the idlinea property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdlinea(String value) {
        this.idlinea = value;
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
     * Gets the value of the linenumber property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getLinenumber() {
        return linenumber;
    }

    /**
     * Sets the value of the linenumber property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setLinenumber(BigInteger value) {
        this.linenumber = value;
    }

    /**
     * Gets the value of the localnumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLocalnumber() {
        return localnumber;
    }

    /**
     * Sets the value of the localnumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLocalnumber(String value) {
        this.localnumber = value;
    }

    /**
     * Gets the value of the memolinename property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMemolinename() {
        return memolinename;
    }

    /**
     * Sets the value of the memolinename property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMemolinename(String value) {
        this.memolinename = value;
    }

    /**
     * Gets the value of the montobrutolinea property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMontobrutolinea() {
        return montobrutolinea;
    }

    /**
     * Sets the value of the montobrutolinea property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMontobrutolinea(BigInteger value) {
        this.montobrutolinea = value;
    }

    /**
     * Gets the value of the paymenttermdays property.
     *
     * @return
     *     possible object is
     *     {@link Short }
     *
     */
    public Short getPaymenttermdays() {
        return paymenttermdays;
    }

    /**
     * Sets the value of the paymenttermdays property.
     *
     * @param value
     *     allowed object is
     *     {@link Short }
     *
     */
    public void setPaymenttermdays(Short value) {
        this.paymenttermdays = value;
    }

    /**
     * Gets the value of the projectid property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getProjectid() {
        return projectid;
    }

    /**
     * Sets the value of the projectid property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setProjectid(BigInteger value) {
        this.projectid = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the transactionsource property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTransactionsource() {
        return transactionsource;
    }

    /**
     * Sets the value of the transactionsource property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTransactionsource(String value) {
        this.transactionsource = value;
    }

    /**
     * Gets the value of the transactiontype property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTransactiontype() {
        return transactiontype;
    }

    /**
     * Sets the value of the transactiontype property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTransactiontype(String value) {
        this.transactiontype = value;
    }

}
