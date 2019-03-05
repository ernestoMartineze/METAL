
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for detalleLCPagosDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="detalleLCPagosDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fechaaplicacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fecharecibo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechatransaccion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="idfacturaerp" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idlineacaptura" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idpago" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="montopagado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="norecibo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleLCPagosDTO",
         propOrder =
         { "fechaaplicacion", "fecharecibo", "fechatransaccion", "idfacturaerp", "idlineacaptura", "idpago",
           "montopagado", "norecibo"
    })
public class DetalleLCPagosDTO {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaaplicacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecharecibo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechatransaccion;
    protected BigDecimal idfacturaerp;
    protected Long idlineacaptura;
    protected BigDecimal idpago;
    protected BigDecimal montopagado;
    protected Long norecibo;

    /**
     * Gets the value of the fechaaplicacion property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechaaplicacion() {
        return fechaaplicacion;
    }

    /**
     * Sets the value of the fechaaplicacion property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechaaplicacion(XMLGregorianCalendar value) {
        this.fechaaplicacion = value;
    }

    /**
     * Gets the value of the fecharecibo property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFecharecibo() {
        return fecharecibo;
    }

    /**
     * Sets the value of the fecharecibo property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFecharecibo(XMLGregorianCalendar value) {
        this.fecharecibo = value;
    }

    /**
     * Gets the value of the fechatransaccion property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechatransaccion() {
        return fechatransaccion;
    }

    /**
     * Sets the value of the fechatransaccion property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechatransaccion(XMLGregorianCalendar value) {
        this.fechatransaccion = value;
    }

    /**
     * Gets the value of the idfacturaerp property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdfacturaerp() {
        return idfacturaerp;
    }

    /**
     * Sets the value of the idfacturaerp property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdfacturaerp(BigDecimal value) {
        this.idfacturaerp = value;
    }

    /**
     * Gets the value of the idlineacaptura property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getIdlineacaptura() {
        return idlineacaptura;
    }

    /**
     * Sets the value of the idlineacaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setIdlineacaptura(Long value) {
        this.idlineacaptura = value;
    }

    /**
     * Gets the value of the idpago property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdpago() {
        return idpago;
    }

    /**
     * Sets the value of the idpago property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdpago(BigDecimal value) {
        this.idpago = value;
    }

    /**
     * Gets the value of the montopagado property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontopagado() {
        return montopagado;
    }

    /**
     * Sets the value of the montopagado property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontopagado(BigDecimal value) {
        this.montopagado = value;
    }

    /**
     * Gets the value of the norecibo property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getNorecibo() {
        return norecibo;
    }

    /**
     * Sets the value of the norecibo property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setNorecibo(Long value) {
        this.norecibo = value;
    }

}
