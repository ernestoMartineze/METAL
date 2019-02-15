
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="respuestaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="descripcionError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="proceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuestaDTO", propOrder = { "descripcionError", "idError", "proceso", "uuid" })
public class RespuestaDTO {

    protected String descripcionError;
    protected String idError;
    protected String proceso;
    protected String uuid;

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

    /**
     * Gets the value of the uuid property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

}
