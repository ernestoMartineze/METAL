
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for facturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="facturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idfacturaprimavera" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="lineas" type="{http://ws.negocio.tic.frisa.mx/}lineasFacturaDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "facturaDTO", propOrder = { "idfacturaprimavera", "lineas" })
public class FacturaDTO {

    protected int idfacturaprimavera;
    @XmlElement(nillable = true)
    protected List<LineasFacturaDTO> lineas;

    /**
     * Gets the value of the idfacturaprimavera property.
     *
     */
    public int getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    /**
     * Sets the value of the idfacturaprimavera property.
     *
     */
    public void setIdfacturaprimavera(int value) {
        this.idfacturaprimavera = value;
    }

    /**
     * Gets the value of the lineas property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineas property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineas().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineasFacturaDTO }
     *
     *
     */
    public List<LineasFacturaDTO> getLineas() {
        if (lineas == null) {
            lineas = new ArrayList<LineasFacturaDTO>();
        }
        return this.lineas;
    }

}
