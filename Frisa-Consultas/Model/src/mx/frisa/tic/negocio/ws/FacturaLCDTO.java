
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for facturaLCDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="facturaLCDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cabecera_Factura" type="{http://ws.negocio.tic.frisa.mx/}cabecera_FacturaDTO" minOccurs="0"/&gt;
 *         &lt;element name="lineas_Factura" type="{http://ws.negocio.tic.frisa.mx/}lineas_FacturaDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "facturaLCDTO", propOrder = { "cabeceraFactura", "lineasFactura" })
public class FacturaLCDTO {

    @XmlElement(name = "cabecera_Factura")
    protected CabeceraFacturaDTO cabeceraFactura;
    @XmlElement(name = "lineas_Factura")
    protected LineasFacturaDTO lineasFactura;

    /**
     * Gets the value of the cabeceraFactura property.
     *
     * @return
     *     possible object is
     *     {@link CabeceraFacturaDTO }
     *
     */
    public CabeceraFacturaDTO getCabeceraFactura() {
        return cabeceraFactura;
    }

    /**
     * Sets the value of the cabeceraFactura property.
     *
     * @param value
     *     allowed object is
     *     {@link CabeceraFacturaDTO }
     *
     */
    public void setCabeceraFactura(CabeceraFacturaDTO value) {
        this.cabeceraFactura = value;
    }

    /**
     * Gets the value of the lineasFactura property.
     *
     * @return
     *     possible object is
     *     {@link LineasFacturaDTO }
     *
     */
    public LineasFacturaDTO getLineasFactura() {
        return lineasFactura;
    }

    /**
     * Sets the value of the lineasFactura property.
     *
     * @param value
     *     allowed object is
     *     {@link LineasFacturaDTO }
     *
     */
    public void setLineasFactura(LineasFacturaDTO value) {
        this.lineasFactura = value;
    }

}
