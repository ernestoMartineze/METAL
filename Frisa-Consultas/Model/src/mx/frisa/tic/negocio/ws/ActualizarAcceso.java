
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actualizarAcceso complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="actualizarAcceso"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAcceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizarAcceso", propOrder = { "idAcceso" })
public class ActualizarAcceso {

    protected String idAcceso;

    /**
     * Gets the value of the idAcceso property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdAcceso() {
        return idAcceso;
    }

    /**
     * Sets the value of the idAcceso property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdAcceso(String value) {
        this.idAcceso = value;
    }

}
