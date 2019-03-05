
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lineaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descripManual" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripOrigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripciOnAdicional1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripciOnAdicional2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripciOnAdicional3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripciOnAdicional4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="descripciOnAdicional5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flexContext" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flexContextDisplayvalue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="flexNumofsegments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lineType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memoLineName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="montoIVALinea" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="montotaxCodeRetIva" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="montotaxCodoRetISR" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="orderLineNumber" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="orderNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="periodoDeFacturacionDesde" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="periodoDeFacturacionHasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="siguienteFechaDeExigibilidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="taxCodeRetIva" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="taxCodoRetISR" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="unitSellingPrice" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineaDTO",
         propOrder =
         { "descripManual", "descripOrigen", "descripciOnAdicional1", "descripciOnAdicional2", "descripciOnAdicional3",
           "descripciOnAdicional4", "descripciOnAdicional5", "flexContext", "flexContextDisplayvalue",
           "flexNumofsegments", "lineType", "memoLineName", "montoIVALinea", "montotaxCodeRetIva", "montotaxCodoRetISR",
           "orderLineNumber", "orderNumber", "periodoDeFacturacionDesde", "periodoDeFacturacionHasta", "quantity",
           "siguienteFechaDeExigibilidad", "taxCode", "taxCodeRetIva", "taxCodoRetISR", "unitSellingPrice"
    })
public class LineaDTO {

    protected String descripManual;
    protected String descripOrigen;
    protected String descripciOnAdicional1;
    protected String descripciOnAdicional2;
    protected String descripciOnAdicional3;
    protected String descripciOnAdicional4;
    protected String descripciOnAdicional5;
    protected String flexContext;
    protected String flexContextDisplayvalue;
    protected String flexNumofsegments;
    protected String lineType;
    protected String memoLineName;
    protected BigInteger montoIVALinea;
    protected BigInteger montotaxCodeRetIva;
    protected BigInteger montotaxCodoRetISR;
    protected short orderLineNumber;
    protected BigInteger orderNumber;
    protected String periodoDeFacturacionDesde;
    protected String periodoDeFacturacionHasta;
    protected Integer quantity;
    protected String siguienteFechaDeExigibilidad;
    protected String taxCode;
    protected BigInteger taxCodeRetIva;
    protected BigInteger taxCodoRetISR;
    protected BigDecimal unitSellingPrice;

    /**
     * Gets the value of the descripManual property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripManual() {
        return descripManual;
    }

    /**
     * Sets the value of the descripManual property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripManual(String value) {
        this.descripManual = value;
    }

    /**
     * Gets the value of the descripOrigen property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripOrigen() {
        return descripOrigen;
    }

    /**
     * Sets the value of the descripOrigen property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripOrigen(String value) {
        this.descripOrigen = value;
    }

    /**
     * Gets the value of the descripciOnAdicional1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripciOnAdicional1() {
        return descripciOnAdicional1;
    }

    /**
     * Sets the value of the descripciOnAdicional1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripciOnAdicional1(String value) {
        this.descripciOnAdicional1 = value;
    }

    /**
     * Gets the value of the descripciOnAdicional2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripciOnAdicional2() {
        return descripciOnAdicional2;
    }

    /**
     * Sets the value of the descripciOnAdicional2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripciOnAdicional2(String value) {
        this.descripciOnAdicional2 = value;
    }

    /**
     * Gets the value of the descripciOnAdicional3 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripciOnAdicional3() {
        return descripciOnAdicional3;
    }

    /**
     * Sets the value of the descripciOnAdicional3 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripciOnAdicional3(String value) {
        this.descripciOnAdicional3 = value;
    }

    /**
     * Gets the value of the descripciOnAdicional4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripciOnAdicional4() {
        return descripciOnAdicional4;
    }

    /**
     * Sets the value of the descripciOnAdicional4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripciOnAdicional4(String value) {
        this.descripciOnAdicional4 = value;
    }

    /**
     * Gets the value of the descripciOnAdicional5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripciOnAdicional5() {
        return descripciOnAdicional5;
    }

    /**
     * Sets the value of the descripciOnAdicional5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripciOnAdicional5(String value) {
        this.descripciOnAdicional5 = value;
    }

    /**
     * Gets the value of the flexContext property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFlexContext() {
        return flexContext;
    }

    /**
     * Sets the value of the flexContext property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFlexContext(String value) {
        this.flexContext = value;
    }

    /**
     * Gets the value of the flexContextDisplayvalue property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFlexContextDisplayvalue() {
        return flexContextDisplayvalue;
    }

    /**
     * Sets the value of the flexContextDisplayvalue property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFlexContextDisplayvalue(String value) {
        this.flexContextDisplayvalue = value;
    }

    /**
     * Gets the value of the flexNumofsegments property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFlexNumofsegments() {
        return flexNumofsegments;
    }

    /**
     * Sets the value of the flexNumofsegments property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFlexNumofsegments(String value) {
        this.flexNumofsegments = value;
    }

    /**
     * Gets the value of the lineType property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineType() {
        return lineType;
    }

    /**
     * Sets the value of the lineType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineType(String value) {
        this.lineType = value;
    }

    /**
     * Gets the value of the memoLineName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMemoLineName() {
        return memoLineName;
    }

    /**
     * Sets the value of the memoLineName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMemoLineName(String value) {
        this.memoLineName = value;
    }

    /**
     * Gets the value of the montoIVALinea property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMontoIVALinea() {
        return montoIVALinea;
    }

    /**
     * Sets the value of the montoIVALinea property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMontoIVALinea(BigInteger value) {
        this.montoIVALinea = value;
    }

    /**
     * Gets the value of the montotaxCodeRetIva property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMontotaxCodeRetIva() {
        return montotaxCodeRetIva;
    }

    /**
     * Sets the value of the montotaxCodeRetIva property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMontotaxCodeRetIva(BigInteger value) {
        this.montotaxCodeRetIva = value;
    }

    /**
     * Gets the value of the montotaxCodoRetISR property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMontotaxCodoRetISR() {
        return montotaxCodoRetISR;
    }

    /**
     * Sets the value of the montotaxCodoRetISR property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMontotaxCodoRetISR(BigInteger value) {
        this.montotaxCodoRetISR = value;
    }

    /**
     * Gets the value of the orderLineNumber property.
     *
     */
    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    /**
     * Sets the value of the orderLineNumber property.
     *
     */
    public void setOrderLineNumber(short value) {
        this.orderLineNumber = value;
    }

    /**
     * Gets the value of the orderNumber property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setOrderNumber(BigInteger value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the periodoDeFacturacionDesde property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPeriodoDeFacturacionDesde() {
        return periodoDeFacturacionDesde;
    }

    /**
     * Sets the value of the periodoDeFacturacionDesde property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPeriodoDeFacturacionDesde(String value) {
        this.periodoDeFacturacionDesde = value;
    }

    /**
     * Gets the value of the periodoDeFacturacionHasta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPeriodoDeFacturacionHasta() {
        return periodoDeFacturacionHasta;
    }

    /**
     * Sets the value of the periodoDeFacturacionHasta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPeriodoDeFacturacionHasta(String value) {
        this.periodoDeFacturacionHasta = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the siguienteFechaDeExigibilidad property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSiguienteFechaDeExigibilidad() {
        return siguienteFechaDeExigibilidad;
    }

    /**
     * Sets the value of the siguienteFechaDeExigibilidad property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSiguienteFechaDeExigibilidad(String value) {
        this.siguienteFechaDeExigibilidad = value;
    }

    /**
     * Gets the value of the taxCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTaxCode() {
        return taxCode;
    }

    /**
     * Sets the value of the taxCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaxCode(String value) {
        this.taxCode = value;
    }

    /**
     * Gets the value of the taxCodeRetIva property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getTaxCodeRetIva() {
        return taxCodeRetIva;
    }

    /**
     * Sets the value of the taxCodeRetIva property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setTaxCodeRetIva(BigInteger value) {
        this.taxCodeRetIva = value;
    }

    /**
     * Gets the value of the taxCodoRetISR property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getTaxCodoRetISR() {
        return taxCodoRetISR;
    }

    /**
     * Sets the value of the taxCodoRetISR property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setTaxCodoRetISR(BigInteger value) {
        this.taxCodoRetISR = value;
    }

    /**
     * Gets the value of the unitSellingPrice property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getUnitSellingPrice() {
        return unitSellingPrice;
    }

    /**
     * Sets the value of the unitSellingPrice property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setUnitSellingPrice(BigDecimal value) {
        this.unitSellingPrice = value;
    }

}
