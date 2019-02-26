
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarUniNegocioDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultarUniNegocioDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cveBu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarUniNegocioDTO", propOrder = { "cveBu", "nombre" })
public class ConsultarUniNegocioDTO {

    protected String cveBu;
    protected String nombre;

    /**
     * Gets the value of the cveBu property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCveBu() {
        return cveBu;
    }

    /**
     * Sets the value of the cveBu property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCveBu(String value) {
        this.cveBu = value;
    }

    /**
     * Gets the value of the nombre property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

}
