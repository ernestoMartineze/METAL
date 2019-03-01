
package mx.frisa.tic.negocio.ws;

import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineaCaptutaFacturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lineaCaptutaFacturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idbatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idfacturaprimavera" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="lineacaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineaCaptutaFacturaDTO", propOrder = { "idbatch", "idfacturaprimavera", "lineacaptura" })
public class LineaCaptutaFacturaDTO {

    protected String idbatch;
    protected BigInteger idfacturaprimavera;
    protected String lineacaptura;

    /**
     * Gets the value of the idbatch property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdbatch() {
        return idbatch;
    }

    /**
     * Sets the value of the idbatch property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdbatch(String value) {
        this.idbatch = value;
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

}
