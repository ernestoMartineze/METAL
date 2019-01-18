
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarPagosSinReferencia complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultarPagosSinReferencia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filtros" type="{http://ws.negocio.tic.frisa.mx/}filtroPagoSinReferencia" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarPagosSinReferencia", propOrder = { "filtros" })
public class ConsultarPagosSinReferencia {

    protected FiltroPagoSinReferencia filtros;

    /**
     * Gets the value of the filtros property.
     *
     * @return
     *     possible object is
     *     {@link FiltroPagoSinReferencia }
     *
     */
    public FiltroPagoSinReferencia getFiltros() {
        return filtros;
    }

    /**
     * Sets the value of the filtros property.
     *
     * @param value
     *     allowed object is
     *     {@link FiltroPagoSinReferencia }
     *
     */
    public void setFiltros(FiltroPagoSinReferencia value) {
        this.filtros = value;
    }

}
