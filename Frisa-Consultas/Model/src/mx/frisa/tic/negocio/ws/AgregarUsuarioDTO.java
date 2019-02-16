
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for agregarUsuarioDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="agregarUsuarioDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="centroCostos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unidadNegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agregarUsuarioDTO", propOrder = { "centroCostos", "unidadNegocio", "usuario" })
public class AgregarUsuarioDTO {

    protected String centroCostos;
    protected String unidadNegocio;
    protected String usuario;

    /**
     * Gets the value of the centroCostos property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCentroCostos() {
        return centroCostos;
    }

    /**
     * Sets the value of the centroCostos property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCentroCostos(String value) {
        this.centroCostos = value;
    }

    /**
     * Gets the value of the unidadNegocio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnidadNegocio() {
        return unidadNegocio;
    }

    /**
     * Sets the value of the unidadNegocio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnidadNegocio(String value) {
        this.unidadNegocio = value;
    }

    /**
     * Gets the value of the usuario property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
