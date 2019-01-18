
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pagoDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="pagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="billCustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaAplicacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaContable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idCabeceraRecibo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idEdoCta" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="lineaCaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="metodoId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="moneda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nroRecibo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="siteId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unidadNegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagoDTO",
         propOrder =
         { "billCustomerName", "customerId", "fechaAplicacion", "fechaContable", "fechaCreacion", "idCabeceraRecibo",
           "idEdoCta", "lineaCaptura", "metodoId", "moneda", "monto", "nroRecibo", "referencia", "siteId",
           "unidadNegocio"
    })
public class PagoDTO {

    protected String billCustomerName;
    protected String customerId;
    protected String fechaAplicacion;
    protected String fechaContable;
    protected String fechaCreacion;
    protected BigDecimal idCabeceraRecibo;
    protected BigDecimal idEdoCta;
    protected String lineaCaptura;
    protected String metodoId;
    protected String moneda;
    protected String monto;
    protected String nroRecibo;
    protected String referencia;
    protected String siteId;
    protected String unidadNegocio;

    /**
     * Gets the value of the billCustomerName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBillCustomerName() {
        return billCustomerName;
    }

    /**
     * Sets the value of the billCustomerName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBillCustomerName(String value) {
        this.billCustomerName = value;
    }

    /**
     * Gets the value of the customerId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the fechaAplicacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    /**
     * Sets the value of the fechaAplicacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechaAplicacion(String value) {
        this.fechaAplicacion = value;
    }

    /**
     * Gets the value of the fechaContable property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechaContable() {
        return fechaContable;
    }

    /**
     * Sets the value of the fechaContable property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechaContable(String value) {
        this.fechaContable = value;
    }

    /**
     * Gets the value of the fechaCreacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets the value of the fechaCreacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechaCreacion(String value) {
        this.fechaCreacion = value;
    }

    /**
     * Gets the value of the idCabeceraRecibo property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdCabeceraRecibo() {
        return idCabeceraRecibo;
    }

    /**
     * Sets the value of the idCabeceraRecibo property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdCabeceraRecibo(BigDecimal value) {
        this.idCabeceraRecibo = value;
    }

    /**
     * Gets the value of the idEdoCta property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdEdoCta() {
        return idEdoCta;
    }

    /**
     * Sets the value of the idEdoCta property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdEdoCta(BigDecimal value) {
        this.idEdoCta = value;
    }

    /**
     * Gets the value of the lineaCaptura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineaCaptura() {
        return lineaCaptura;
    }

    /**
     * Sets the value of the lineaCaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineaCaptura(String value) {
        this.lineaCaptura = value;
    }

    /**
     * Gets the value of the metodoId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMetodoId() {
        return metodoId;
    }

    /**
     * Sets the value of the metodoId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMetodoId(String value) {
        this.metodoId = value;
    }

    /**
     * Gets the value of the moneda property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Sets the value of the moneda property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMoneda(String value) {
        this.moneda = value;
    }

    /**
     * Gets the value of the monto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMonto(String value) {
        this.monto = value;
    }

    /**
     * Gets the value of the nroRecibo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNroRecibo() {
        return nroRecibo;
    }

    /**
     * Sets the value of the nroRecibo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNroRecibo(String value) {
        this.nroRecibo = value;
    }

    /**
     * Gets the value of the referencia property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Sets the value of the referencia property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Gets the value of the siteId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSiteId() {
        return siteId;
    }

    /**
     * Sets the value of the siteId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSiteId(String value) {
        this.siteId = value;
    }

    /**
     * Gets the value of the unidadNegocio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnidadNegocio() {
        return unidadNegocio;
    }

    /**
     * Sets the value of the unidadNegocio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnidadNegocio(String value) {
        this.unidadNegocio = value;
    }

}
