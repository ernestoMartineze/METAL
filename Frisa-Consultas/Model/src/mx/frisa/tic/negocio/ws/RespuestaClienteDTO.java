
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for respuestaClienteDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="respuestaClienteDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estadoCobro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estadoConciliacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idPago" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="montoPendienteDeAplicar" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="nombrePago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroCobro" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="proceso" type="{http://ws.negocio.tic.frisa.mx/}proceso" minOccurs="0"/&gt;
 *         &lt;element name="proyectoID" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
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
@XmlType(name = "respuestaClienteDTO",
         propOrder =
         { "cliente", "estadoCobro", "estadoConciliacion", "idPago", "montoPendienteDeAplicar", "nombrePago",
           "numeroCobro", "proceso", "proyectoID", "totalLC", "unidadNegocio"
    })
public class RespuestaClienteDTO {

    protected String cliente;
    protected String estadoCobro;
    protected String estadoConciliacion;
    protected BigDecimal idPago;
    protected BigDecimal montoPendienteDeAplicar;
    protected String nombrePago;
    protected BigDecimal numeroCobro;
    protected Proceso proceso;
    protected BigDecimal proyectoID;
    protected String unidadNegocio;
    protected BigDecimal totalLC;

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
     * Gets the value of the estadoCobro property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEstadoCobro() {
        return estadoCobro;
    }

    /**
     * Sets the value of the estadoCobro property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEstadoCobro(String value) {
        this.estadoCobro = value;
    }

    /**
     * Gets the value of the estadoConciliacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEstadoConciliacion() {
        return estadoConciliacion;
    }

    /**
     * Sets the value of the estadoConciliacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEstadoConciliacion(String value) {
        this.estadoConciliacion = value;
    }

    /**
     * Gets the value of the idPago property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdPago() {
        return idPago;
    }

    /**
     * Sets the value of the idPago property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdPago(BigDecimal value) {
        this.idPago = value;
    }

    /**
     * Gets the value of the montoPendienteDeAplicar property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoPendienteDeAplicar() {
        return montoPendienteDeAplicar;
    }

    /**
     * Sets the value of the montoPendienteDeAplicar property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoPendienteDeAplicar(BigDecimal value) {
        this.montoPendienteDeAplicar = value;
    }

    /**
     * Gets the value of the nombrePago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNombrePago() {
        return nombrePago;
    }

    /**
     * Sets the value of the nombrePago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNombrePago(String value) {
        this.nombrePago = value;
    }

    /**
     * Gets the value of the numeroCobro property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getNumeroCobro() {
        return numeroCobro;
    }

    /**
     * Sets the value of the numeroCobro property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setNumeroCobro(BigDecimal value) {
        this.numeroCobro = value;
    }

    /**
     * Gets the value of the proceso property.
     *
     * @return
     *     possible object is
     *     {@link Proceso }
     *
     */
    public Proceso getProceso() {
        return proceso;
    }

    /**
     * Sets the value of the proceso property.
     *
     * @param value
     *     allowed object is
     *     {@link Proceso }
     *
     */
    public void setProceso(Proceso value) {
        this.proceso = value;
    }

    /**
     * Gets the value of the proyectoID property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getProyectoID() {
        return proyectoID;
    }

    /**
     * Sets the value of the proyectoID property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setProyectoID(BigDecimal value) {
        this.proyectoID = value;
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
     * Gets the value of the totalLC property.
     *
     * @return
     * possible object is
     * {@link BigDecimal}
     *
     */
    public BigDecimal getTotalLC() {
        return totalLC;
    }

    /**
     * Sets the value of the totalLC property.
     *
     * @param value
     * allowed object is
     * {@link BigDecimal}
     *
     */
    public void setTotalLC(BigDecimal value) {
        this.totalLC = value;
    }

}
