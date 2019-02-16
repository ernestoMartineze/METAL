
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarUsuario complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultarUsuario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="usuarioAcceso" type="{http://ws.negocio.tic.frisa.mx/}consultarUsuarioDTO" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarUsuario", propOrder = { "usuarioAcceso" })
public class ConsultarUsuario {

    protected ConsultarUsuarioDTO usuarioAcceso;

    /**
     * Gets the value of the usuarioAcceso property.
     *
     * @return
     *     possible object is
     *     {@link ConsultarUsuarioDTO }
     *
     */
    public ConsultarUsuarioDTO getUsuarioAcceso() {
        return usuarioAcceso;
    }

    /**
     * Sets the value of the usuarioAcceso property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultarUsuarioDTO }
     *
     */
    public void setUsuarioAcceso(ConsultarUsuarioDTO value) {
        this.usuarioAcceso = value;
    }

}
