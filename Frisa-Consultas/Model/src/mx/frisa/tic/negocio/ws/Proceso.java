
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for proceso complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="proceso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="termino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "proceso", propOrder = { "descripcion", "termino" })
public class Proceso {

    protected String descripcion;
    protected String termino;

    /**
     * Gets the value of the descripcion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Gets the value of the termino property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTermino() {
        return termino;
    }

    /**
     * Sets the value of the termino property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTermino(String value) {
        this.termino = value;
    }

}
