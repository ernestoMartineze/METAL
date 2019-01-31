
package mx.frisa.tic.negocio.ws;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pagoPorAplicarDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="pagoPorAplicarDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idEdoCuenta" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="idLineaCaputura" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="idPago" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagoPorAplicarDTO",
         propOrder = { "idEdoCuenta", "idLineaCaputura", "idPago", "referencia", "termino" })
public class PagoPorAplicarDTO {

    protected BigInteger idEdoCuenta;
    protected String idLineaCaputura;
    protected BigInteger idPago;
    protected String referencia;
    protected BigInteger termino;

    /**
     * Gets the value of the idEdoCuenta property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdEdoCuenta() {
        return idEdoCuenta;
    }

    /**
     * Sets the value of the idEdoCuenta property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdEdoCuenta(BigInteger value) {
        this.idEdoCuenta = value;
    }

    /**
     * Gets the value of the idLineaCaputura property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public String getIdLineaCaputura() {
        return idLineaCaputura;
    }

    /**
     * Sets the value of the idLineaCaputura property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdLineaCaputura(String value) {
        this.idLineaCaputura = value;
    }

    /**
     * Gets the value of the idPago property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getIdPago() {
        return idPago;
    }

    /**
     * Sets the value of the idPago property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setIdPago(BigInteger value) {
        this.idPago = value;
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
     * Gets the value of the termino property.
     *
     * @return
     * possible object is
     * {@link BigInteger}
     *
     */
    public BigInteger getTermino() {
        return termino;
    }

    /**
     * Sets the value of the termino property.
     *
     * @param value
     * allowed object is
     * {@link BigInteger}
     *
     */
    public void setTermino(BigInteger value) {
        this.termino = value;
    }

}
