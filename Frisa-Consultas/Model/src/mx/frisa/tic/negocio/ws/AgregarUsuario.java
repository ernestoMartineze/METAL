
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for agregarUsuario complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="agregarUsuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuarioAcceso" type="{http://ws.negocio.tic.frisa.mx/}agregarUsuarioDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agregarUsuario", propOrder = { "usuarioAcceso" })
public class AgregarUsuario {

    protected AgregarUsuarioDTO usuarioAcceso;

    /**
     * Gets the value of the usuarioAcceso property.
     *
     * @return
     *     possible object is
     *     {@link AgregarUsuarioDTO }
     *
     */
    public AgregarUsuarioDTO getUsuarioAcceso() {
        return usuarioAcceso;
    }

    /**
     * Sets the value of the usuarioAcceso property.
     *
     * @param value
     *     allowed object is
     *     {@link AgregarUsuarioDTO }
     *
     */
    public void setUsuarioAcceso(AgregarUsuarioDTO value) {
        this.usuarioAcceso = value;
    }

}
