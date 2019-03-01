
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaDetalleLineaCaptura complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultaDetalleLineaCaptura"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lineaCaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="entidadLegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="banco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unidadNegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaDetalleLineaCaptura",
         propOrder = { "lineaCaptura", "entidadLegal", "referencia", "banco", "unidadNegocio" })
public class ConsultaDetalleLineaCaptura {

    protected String lineaCaptura;
    protected String entidadLegal;
    protected String referencia;
    protected String banco;
    protected String unidadNegocio;

    /**
     * Gets the value of the lineaCaptura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineaCaptura() {
        return lineaCaptura;
    }

    /**
     * Sets the value of the lineaCaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineaCaptura(String value) {
        this.lineaCaptura = value;
    }

    /**
     * Gets the value of the entidadLegal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEntidadLegal() {
        return entidadLegal;
    }

    /**
     * Sets the value of the entidadLegal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEntidadLegal(String value) {
        this.entidadLegal = value;
    }

    /**
     * Gets the value of the referencia property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Sets the value of the referencia property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Gets the value of the banco property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Sets the value of the banco property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBanco(String value) {
        this.banco = value;
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

}
