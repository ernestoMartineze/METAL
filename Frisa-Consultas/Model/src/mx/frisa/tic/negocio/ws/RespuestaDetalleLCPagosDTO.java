
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaDetalleLCPagosDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="respuestaDetalleLCPagosDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="detalleLCPagos" type="{http://ws.negocio.tic.frisa.mx/}detalleLCPagosDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "respuestaDetalleLCPagosDTO", propOrder = { "detalleLCPagos", "proceso" })
public class RespuestaDetalleLCPagosDTO {

    @XmlElement(nillable = true)
    protected List<DetalleLCPagosDTO> detalleLCPagos;
    protected Proceso proceso;

    /**
     * Gets the value of the detalleLCPagos property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalleLCPagos property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalleLCPagos().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetalleLCPagosDTO }
     *
     *
     */
    public List<DetalleLCPagosDTO> getDetalleLCPagos() {
        if (detalleLCPagos == null) {
            detalleLCPagos = new ArrayList<DetalleLCPagosDTO>();
        }
        return this.detalleLCPagos;
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
