
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accesoUsuarioDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="accesoUsuarioDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="centrocostos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idacceso" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="unidadnegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accesoUsuarioDTO", propOrder = { "centrocostos", "idacceso", "unidadnegocio" })
public class AccesoUsuarioDTO {

    protected String centrocostos;
    protected BigDecimal idacceso;
    protected String unidadnegocio;

    /**
     * Gets the value of the centrocostos property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCentrocostos() {
        return centrocostos;
    }

    /**
     * Sets the value of the centrocostos property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCentrocostos(String value) {
        this.centrocostos = value;
    }

    /**
     * Gets the value of the idacceso property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdacceso() {
        return idacceso;
    }

    /**
     * Sets the value of the idacceso property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdacceso(BigDecimal value) {
        this.idacceso = value;
    }

    /**
     * Gets the value of the unidadnegocio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnidadnegocio() {
        return unidadnegocio;
    }

    /**
     * Sets the value of the unidadnegocio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnidadnegocio(String value) {
        this.unidadnegocio = value;
    }

}
