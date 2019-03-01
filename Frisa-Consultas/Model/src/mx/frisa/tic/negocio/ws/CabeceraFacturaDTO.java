
package mx.frisa.tic.negocio.ws;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cabecera_FacturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="cabecera_FacturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="addendaid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="batchSourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billCustomerAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="billCustomerSiteNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="businessUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerTrxTypeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="facturaUnifier" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="folio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="glDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lineaDeCaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroDeContrato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="numeroDeLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="origSystemBatchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentTermsName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="proyecto" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="trxDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cabecera_FacturaDTO",
         propOrder =
         { "addendaid", "batchSourceName", "billCustomerAccountNumber", "billCustomerSiteNumber", "businessUnit",
           "currencyCode", "customerTrxTypeName", "description", "facturaUnifier", "folio", "glDate", "lineaDeCaptura",
           "numeroDeContrato", "numeroDeLocal", "orgId", "origSystemBatchName", "paymentTermsName", "proyecto",
           "trxDate"
    })
public class CabeceraFacturaDTO {

    protected String addendaid;
    protected String batchSourceName;
    protected String billCustomerAccountNumber;
    protected BigInteger billCustomerSiteNumber;
    protected String businessUnit;
    protected String currencyCode;
    protected String customerTrxTypeName;
    protected String description;
    protected BigInteger facturaUnifier;
    protected String folio;
    protected String glDate;
    protected String lineaDeCaptura;
    protected Long numeroDeContrato;
    protected String numeroDeLocal;
    protected String orgId;
    protected String origSystemBatchName;
    protected String paymentTermsName;
    protected Long proyecto;
    protected String trxDate;

    /**
     * Gets the value of the addendaid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAddendaid() {
        return addendaid;
    }

    /**
     * Sets the value of the addendaid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAddendaid(String value) {
        this.addendaid = value;
    }

    /**
     * Gets the value of the batchSourceName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBatchSourceName() {
        return batchSourceName;
    }

    /**
     * Sets the value of the batchSourceName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBatchSourceName(String value) {
        this.batchSourceName = value;
    }

    /**
     * Gets the value of the billCustomerAccountNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBillCustomerAccountNumber() {
        return billCustomerAccountNumber;
    }

    /**
     * Sets the value of the billCustomerAccountNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBillCustomerAccountNumber(String value) {
        this.billCustomerAccountNumber = value;
    }

    /**
     * Gets the value of the billCustomerSiteNumber property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getBillCustomerSiteNumber() {
        return billCustomerSiteNumber;
    }

    /**
     * Sets the value of the billCustomerSiteNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setBillCustomerSiteNumber(BigInteger value) {
        this.billCustomerSiteNumber = value;
    }

    /**
     * Gets the value of the businessUnit property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Sets the value of the businessUnit property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBusinessUnit(String value) {
        this.businessUnit = value;
    }

    /**
     * Gets the value of the currencyCode property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the customerTrxTypeName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerTrxTypeName() {
        return customerTrxTypeName;
    }

    /**
     * Sets the value of the customerTrxTypeName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerTrxTypeName(String value) {
        this.customerTrxTypeName = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the facturaUnifier property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getFacturaUnifier() {
        return facturaUnifier;
    }

    /**
     * Sets the value of the facturaUnifier property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setFacturaUnifier(BigInteger value) {
        this.facturaUnifier = value;
    }

    /**
     * Gets the value of the folio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Sets the value of the folio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFolio(String value) {
        this.folio = value;
    }

    /**
     * Gets the value of the glDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getGlDate() {
        return glDate;
    }

    /**
     * Sets the value of the glDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setGlDate(String value) {
        this.glDate = value;
    }

    /**
     * Gets the value of the lineaDeCaptura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineaDeCaptura() {
        return lineaDeCaptura;
    }

    /**
     * Sets the value of the lineaDeCaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineaDeCaptura(String value) {
        this.lineaDeCaptura = value;
    }

    /**
     * Gets the value of the numeroDeContrato property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getNumeroDeContrato() {
        return numeroDeContrato;
    }

    /**
     * Sets the value of the numeroDeContrato property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setNumeroDeContrato(Long value) {
        this.numeroDeContrato = value;
    }

    /**
     * Gets the value of the numeroDeLocal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumeroDeLocal() {
        return numeroDeLocal;
    }

    /**
     * Sets the value of the numeroDeLocal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumeroDeLocal(String value) {
        this.numeroDeLocal = value;
    }

    /**
     * Gets the value of the orgId property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * Sets the value of the orgId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrgId(String value) {
        this.orgId = value;
    }

    /**
     * Gets the value of the origSystemBatchName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrigSystemBatchName() {
        return origSystemBatchName;
    }

    /**
     * Sets the value of the origSystemBatchName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrigSystemBatchName(String value) {
        this.origSystemBatchName = value;
    }

    /**
     * Gets the value of the paymentTermsName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPaymentTermsName() {
        return paymentTermsName;
    }

    /**
     * Sets the value of the paymentTermsName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPaymentTermsName(String value) {
        this.paymentTermsName = value;
    }

    /**
     * Gets the value of the proyecto property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getProyecto() {
        return proyecto;
    }

    /**
     * Sets the value of the proyecto property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setProyecto(Long value) {
        this.proyecto = value;
    }

    /**
     * Gets the value of the trxDate property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTrxDate() {
        return trxDate;
    }

    /**
     * Sets the value of the trxDate property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTrxDate(String value) {
        this.trxDate = value;
    }

}
