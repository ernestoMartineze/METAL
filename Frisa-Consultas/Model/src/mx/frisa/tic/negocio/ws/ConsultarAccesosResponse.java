
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarAccesosResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultarAccesosResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://ws.negocio.tic.frisa.mx/}consultarAccesoUsuarioDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarAccesosResponse", propOrder = { "_return" })
public class ConsultarAccesosResponse {

    @XmlElement(name = "return")
    protected ConsultarAccesoUsuarioDTO _return;

    /**
     * Gets the value of the return property.
     *
     * @return
     *     possible object is
     *     {@link ConsultarAccesoUsuarioDTO }
     *
     */
    public ConsultarAccesoUsuarioDTO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultarAccesoUsuarioDTO }
     *
     */
    public void setReturn(ConsultarAccesoUsuarioDTO value) {
        this._return = value;
    }

}
