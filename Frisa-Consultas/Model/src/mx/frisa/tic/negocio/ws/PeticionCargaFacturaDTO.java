
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for peticionCargaFacturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="peticionCargaFacturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="facturas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idBatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "peticionCargaFacturaDTO", propOrder = { "facturas", "idBatch" })
public class PeticionCargaFacturaDTO {

    protected String facturas;
    protected String idBatch;

    /**
     * Gets the value of the facturas property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFacturas() {
        return facturas;
    }

    /**
     * Sets the value of the facturas property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFacturas(String value) {
        this.facturas = value;
    }

    /**
     * Gets the value of the idBatch property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdBatch() {
        return idBatch;
    }

    /**
     * Sets the value of the idBatch property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdBatch(String value) {
        this.idBatch = value;
    }

}