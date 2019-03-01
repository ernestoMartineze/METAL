
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineaCapturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lineaCapturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lineaCaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineaCapturaDTO", propOrder = { "fechaCreacion", "lineaCaptura" })
public class LineaCapturaDTO {

    protected String fechaCreacion;
    protected String lineaCaptura;

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

}
