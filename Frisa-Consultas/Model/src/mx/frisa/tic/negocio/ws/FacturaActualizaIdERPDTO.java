
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for facturaActualizaIdERPDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="facturaActualizaIdERPDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cabecera" type="{http://ws.negocio.tic.frisa.mx/}cabeceraActualizaIdERPDTO" minOccurs="0"/&gt;
 *         &lt;element name="lineas" type="{http://ws.negocio.tic.frisa.mx/}listaLineaActualizaIdERPDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "facturaActualizaIdERPDTO", propOrder = { "cabecera", "lineas" })
public class FacturaActualizaIdERPDTO {

    protected CabeceraActualizaIdERPDTO cabecera;
    protected ListaLineaActualizaIdERPDTO lineas;

    /**
     * Gets the value of the cabecera property.
     *
     * @return
     *     possible object is
     *     {@link CabeceraActualizaIdERPDTO }
     *
     */
    public CabeceraActualizaIdERPDTO getCabecera() {
        return cabecera;
    }

    /**
     * Sets the value of the cabecera property.
     *
     * @param value
     *     allowed object is
     *     {@link CabeceraActualizaIdERPDTO }
     *
     */
    public void setCabecera(CabeceraActualizaIdERPDTO value) {
        this.cabecera = value;
    }

    /**
     * Gets the value of the lineas property.
     *
     * @return
     *     possible object is
     *     {@link ListaLineaActualizaIdERPDTO }
     *
     */
    public ListaLineaActualizaIdERPDTO getLineas() {
        return lineas;
    }

    /**
     * Sets the value of the lineas property.
     *
     * @param value
     *     allowed object is
     *     {@link ListaLineaActualizaIdERPDTO }
     *
     */
    public void setLineas(ListaLineaActualizaIdERPDTO value) {
        this.lineas = value;
    }

}
