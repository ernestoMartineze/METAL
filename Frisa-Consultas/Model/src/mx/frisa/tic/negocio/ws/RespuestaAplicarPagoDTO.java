
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaAplicarPagoDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="respuestaAplicarPagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="aplicarPago" type="{http://ws.negocio.tic.frisa.mx/}aplicarPagoDTO" minOccurs="0"/&gt;
 *         &lt;element name="proceso" type="{http://ws.negocio.tic.frisa.mx/}proceso" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaAplicarPagoDTO", propOrder = { "aplicarPago", "proceso" })
public class RespuestaAplicarPagoDTO {

    protected AplicarPagoDTO aplicarPago;
    protected Proceso proceso;

    /**
     * Gets the value of the aplicarPago property.
     *
     * @return
     *     possible object is
     *     {@link AplicarPagoDTO }
     *
     */
    public AplicarPagoDTO getAplicarPago() {
        return aplicarPago;
    }

    /**
     * Sets the value of the aplicarPago property.
     *
     * @param value
     *     allowed object is
     *     {@link AplicarPagoDTO }
     *
     */
    public void setAplicarPago(AplicarPagoDTO value) {
        this.aplicarPago = value;
    }

    /**
     * Gets the value of the proceso property.
     *
     * @return
     *     possible object is
     *     {@link Proceso }
     *
     */
    public Proceso getProceso() {
        return proceso;
    }

    /**
     * Sets the value of the proceso property.
     *
     * @param value
     *     allowed object is
     *     {@link Proceso }
     *
     */
    public void setProceso(Proceso value) {
        this.proceso = value;
    }

}
