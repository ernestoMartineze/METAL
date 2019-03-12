
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for aplicarPagoDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="aplicarPagoDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pagoPorAplicar" type="{http://ws.negocio.tic.frisa.mx/}pagoPorAplicarDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "aplicarPagoDTO", propOrder = { "pagoPorAplicar" })
public class AplicarPagoDTO {

    @XmlElement(nillable = true)
    protected List<PagoPorAplicarDTO> pagoPorAplicar;


    /**
     * Gets the value of the pagoPorAplicar property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pagoPorAplicar property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPagoPorAplicar().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PagoPorAplicarDTO }
     *
     *
     */
    public List<PagoPorAplicarDTO> getPagoPorAplicar() {
        if (pagoPorAplicar == null) {
            pagoPorAplicar = new ArrayList<PagoPorAplicarDTO>();
        }
        return this.pagoPorAplicar;
    }

    public void setPagoPorAplicar(List<PagoPorAplicarDTO> pagoPorAplicar) {
        this.pagoPorAplicar = pagoPorAplicar;
    }

}
