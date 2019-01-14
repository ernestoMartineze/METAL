
package mx.frisa.tic.negocio.ws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaProcesaFacturasDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="respuestaProcesaFacturasDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descripcionError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="facturas" type="{http://ws.negocio.tic.frisa.mx/}facturaPagoDTO" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="idError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="proceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaProcesaFacturasDTO", propOrder = { "descripcionError", "facturas", "idError", "proceso" })
public class RespuestaProcesaFacturasDTO {

    protected String descripcionError;
    @XmlElement(nillable = true)
    protected List<FacturaPagoDTO> facturas;
    protected String idError;
    protected String proceso;

    /**
     * Gets the value of the descripcionError property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescripcionError() {
        return descripcionError;
    }

    /**
     * Sets the value of the descripcionError property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescripcionError(String value) {
        this.descripcionError = value;
    }

    /**
     * Gets the value of the facturas property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the facturas property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFacturas().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FacturaPagoDTO }
     *
     *
     */
    public List<FacturaPagoDTO> getFacturas() {
        if (facturas == null) {
            facturas = new ArrayList<FacturaPagoDTO>();
        }
        return this.facturas;
    }

    /**
     * Gets the value of the idError property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIdError() {
        return idError;
    }

    /**
     * Sets the value of the idError property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIdError(String value) {
        this.idError = value;
    }

    /**
     * Gets the value of the proceso property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * Sets the value of the proceso property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setProceso(String value) {
        this.proceso = value;
    }

}
