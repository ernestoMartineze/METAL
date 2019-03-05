
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaLCFactDet complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="consultaLCFactDet"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="centroCostos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="entidadLegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "consultaLCFactDet",
         propOrder = { "cliente", "cuenta", "centroCostos", "entidadLegal", "unidadNegocio" })
public class ConsultaLCFactDet {

    protected String cliente;
    protected String cuenta;
    protected String centroCostos;
    protected String entidadLegal;
    protected String unidadNegocio;

    /**
     * Gets the value of the cliente property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCliente(String value) {
        this.cliente = value;
    }

    /**
     * Gets the value of the cuenta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Sets the value of the cuenta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCuenta(String value) {
        this.cuenta = value;
    }

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
