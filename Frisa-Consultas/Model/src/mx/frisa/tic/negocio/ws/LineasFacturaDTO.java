
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineasFacturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lineasFacturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="description_origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idfacturaprimavera" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="linenumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineas_FacturaDTO", propOrder = { "lineaDTO" })
public class LineasFacturaDTO {

    @XmlElement(nillable = true)
    protected List<LineaDTO> lineaDTO;


    /**
     * Gets the value of the lineaDTO property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineaDTO property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     * getLineaDTO().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineaDTO}
     *
     *
     */
    public List<LineaDTO> getLineaDTO() {
        if (lineaDTO == null) {
            lineaDTO = new ArrayList<LineaDTO>();
        }
        return this.lineaDTO;
    }

}
