
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarPagosSinReferenciaResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultarPagosSinReferenciaResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://ws.negocio.tic.frisa.mx/}respuestaPagoSinReferencia" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarPagosSinReferenciaResponse", propOrder = { "_return" })
public class ConsultarPagosSinReferenciaResponse {

    @XmlElement(name = "return")
    protected RespuestaPagoSinReferencia _return;

    /**
     * Gets the value of the return property.
     *
     * @return
     *     possible object is
     *     {@link RespuestaPagoSinReferencia }
     *
     */
    public RespuestaPagoSinReferencia getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value
     *     allowed object is
     *     {@link RespuestaPagoSinReferencia }
     *
     */
    public void setReturn(RespuestaPagoSinReferencia value) {
        this._return = value;
    }

}
