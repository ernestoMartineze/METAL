
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarReferenciaLCExistente complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultarReferenciaLCExistente"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filtros" type="{http://ws.negocio.tic.frisa.mx/}peticionExistente" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarReferenciaLCExistente", propOrder = { "filtros" })
public class ConsultarReferenciaLCExistente {

    protected PeticionExistente filtros;

    /**
     * Gets the value of the filtros property.
     *
     * @return
     *     possible object is
     *     {@link PeticionExistente }
     *
     */
    public PeticionExistente getFiltros() {
        return filtros;
    }

    /**
     * Sets the value of the filtros property.
     *
     * @param value
     *     allowed object is
     *     {@link PeticionExistente }
     *
     */
    public void setFiltros(PeticionExistente value) {
        this.filtros = value;
    }

}
