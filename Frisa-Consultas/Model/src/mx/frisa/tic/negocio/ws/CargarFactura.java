
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cargarFactura complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="cargarFactura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="facturas" type="{http://ws.negocio.tic.frisa.mx/}peticionCargaFacturaDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cargarFactura", propOrder = { "facturas" })
public class CargarFactura {

    protected PeticionCargaFacturaDTO facturas;

    /**
     * Gets the value of the facturas property.
     *
     * @return
     *     possible object is
     *     {@link PeticionCargaFacturaDTO }
     *
     */
    public PeticionCargaFacturaDTO getFacturas() {
        return facturas;
    }

    /**
     * Sets the value of the facturas property.
     *
     * @param value
     *     allowed object is
     *     {@link PeticionCargaFacturaDTO }
     *
     */
    public void setFacturas(PeticionCargaFacturaDTO value) {
        this.facturas = value;
    }

}
