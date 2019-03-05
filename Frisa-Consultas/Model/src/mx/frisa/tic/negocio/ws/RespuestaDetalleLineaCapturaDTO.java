
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaDetalleLineaCapturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="respuestaDetalleLineaCapturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lineasCaptura" type="{http://ws.negocio.tic.frisa.mx/}detalleLineaCapturaDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "respuestaDetalleLineaCapturaDTO", propOrder = { "lineasCaptura", "proceso" })
public class RespuestaDetalleLineaCapturaDTO {

    @XmlElement(nillable = true)
    protected List<DetalleLineaCapturaDTO> lineasCaptura;
    protected Proceso proceso;

    /**
     * Gets the value of the lineasCaptura property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineasCaptura property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineasCaptura().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleLineaCapturaDTO }
     *
     *
     */
    public List<DetalleLineaCapturaDTO> getLineasCaptura() {
        if (lineasCaptura == null) {
            lineasCaptura = new ArrayList<DetalleLineaCapturaDTO>();
        }
        return this.lineasCaptura;
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
