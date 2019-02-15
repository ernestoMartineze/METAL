
package mx.frisa.tic.negocio.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for filtroPagoSinReferencia complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="filtroPagoSinReferencia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cuentaBancaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaFinal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaInicial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mostrarAplicar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filtroPagoSinReferencia",
         propOrder = { "cuentaBancaria", "fechaFinal", "fechaInicial", "mostrarAplicar", "usuario"
    })
public class FiltroPagoSinReferencia {

    protected String cuentaBancaria;
    protected String fechaFinal;
    protected String fechaInicial;
    protected String mostrarAplicar;
    protected String usuario;

    /**
     * Gets the value of the cuentaBancaria property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Sets the value of the cuentaBancaria property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCuentaBancaria(String value) {
        this.cuentaBancaria = value;
    }

    /**
     * Gets the value of the fechaFinal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Sets the value of the fechaFinal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechaFinal(String value) {
        this.fechaFinal = value;
    }

    /**
     * Gets the value of the fechaInicial property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechaInicial() {
        return fechaInicial;
    }

    /**
     * Sets the value of the fechaInicial property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechaInicial(String value) {
        this.fechaInicial = value;
    }

    /**
     * Gets the value of the mostrarAplicar property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMostrarAplicar() {
        return mostrarAplicar;
    }

    /**
     * Sets the value of the mostrarAplicar property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMostrarAplicar(String value) {
        this.mostrarAplicar = value;
    }

    /**
     * Gets the value of the usuario property.
     *
     * @return
     * possible object is
     * {@link String}
     *
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     *
     * @param value
     * allowed object is
     * {@link String}
     *
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
