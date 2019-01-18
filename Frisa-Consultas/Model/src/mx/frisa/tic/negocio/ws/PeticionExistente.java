
package mx.frisa.tic.negocio.ws;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for peticionExistente complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="peticionExistente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idPago" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="lineaCaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroRecibo" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
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
@XmlType(name = "peticionExistente", propOrder = { "idPago", "lineaCaptura", "numeroRecibo", "referencia" })
public class PeticionExistente {

    protected BigInteger idPago;
    protected String lineaCaptura;
    protected BigInteger numeroRecibo;
    protected String referencia;

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
     * Gets the value of the numeroRecibo property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getNumeroRecibo() {
        return numeroRecibo;
    }

    /**
     * Sets the value of the numeroRecibo property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNumeroRecibo(BigInteger value) {
        this.numeroRecibo = value;
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

}
