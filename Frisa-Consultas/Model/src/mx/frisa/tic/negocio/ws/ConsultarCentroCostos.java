
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarCentroCostos complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultarCentroCostos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="centroCostos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarCentroCostos", propOrder = { "centroCostos" })
public class ConsultarCentroCostos {

    protected String centroCostos;

    /**
     * Gets the value of the centroCostos property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCentroCostos() {
        return centroCostos;
    }

    /**
     * Sets the value of the centroCostos property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCentroCostos(String value) {
        this.centroCostos = value;
    }

}
