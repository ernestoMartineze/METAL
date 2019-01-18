
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineaEstadoCuentaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lineaEstadoCuentaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="conceptoMovimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuentaBancaria" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idEstadoCuenta" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idPago" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="metodoPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="monto" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="orgID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tipoDeposito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineaEstadoCuentaDTO",
         propOrder =
         { "conceptoMovimiento", "cuentaBancaria", "fecha", "idEstadoCuenta", "idPago", "metodoPago", "monto", "orgID",
           "tipoDeposito"
    })
public class LineaEstadoCuentaDTO {

    protected String conceptoMovimiento;
    protected BigDecimal cuentaBancaria;
    protected String fecha;
    protected BigDecimal idEstadoCuenta;
    protected BigDecimal idPago;
    protected String metodoPago;
    protected BigDecimal monto;
    protected BigDecimal orgID;
    protected String tipoDeposito;

    /**
     * Gets the value of the conceptoMovimiento property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    /**
     * Sets the value of the conceptoMovimiento property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConceptoMovimiento(String value) {
        this.conceptoMovimiento = value;
    }

    /**
     * Gets the value of the cuentaBancaria property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Sets the value of the cuentaBancaria property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setCuentaBancaria(BigDecimal value) {
        this.cuentaBancaria = value;
    }

    /**
     * Gets the value of the fecha property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Sets the value of the fecha property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFecha(String value) {
        this.fecha = value;
    }

    /**
     * Gets the value of the idEstadoCuenta property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    /**
     * Sets the value of the idEstadoCuenta property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdEstadoCuenta(BigDecimal value) {
        this.idEstadoCuenta = value;
    }

    /**
     * Gets the value of the idPago property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdPago() {
        return idPago;
    }

    /**
     * Sets the value of the idPago property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdPago(BigDecimal value) {
        this.idPago = value;
    }

    /**
     * Gets the value of the metodoPago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Sets the value of the metodoPago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMetodoPago(String value) {
        this.metodoPago = value;
    }

    /**
     * Gets the value of the monto property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

    /**
     * Gets the value of the orgID property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setOrgID(BigDecimal value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the tipoDeposito property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipoDeposito() {
        return tipoDeposito;
    }

    /**
     * Sets the value of the tipoDeposito property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipoDeposito(String value) {
        this.tipoDeposito = value;
    }

}
