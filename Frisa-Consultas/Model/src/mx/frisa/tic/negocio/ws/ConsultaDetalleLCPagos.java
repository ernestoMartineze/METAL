
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaDetalleLCPagos complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultaDetalleLCPagos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="facturaERP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaDetalleLCPagos", propOrder = { "facturaERP" })
public class ConsultaDetalleLCPagos {

    protected String facturaERP;

    /**
     * Gets the value of the facturaERP property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFacturaERP() {
        return facturaERP;
    }

    /**
     * Sets the value of the facturaERP property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFacturaERP(String value) {
        this.facturaERP = value;
    }

}
