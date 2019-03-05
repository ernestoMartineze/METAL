
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cabeceraActualizaIdERPDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="cabeceraActualizaIdERPDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoerror" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="erptransactionnumber" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="idfacturaprimavera" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="mensajeerror" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="relatederpinvoice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cabeceraActualizaIdERPDTO",
         propOrder = { "codigoerror", "erptransactionnumber", "idfacturaprimavera", "mensajeerror", "relatederpinvoice"
    })
public class CabeceraActualizaIdERPDTO {

    protected Long codigoerror;
    protected BigDecimal erptransactionnumber;
    protected BigDecimal idfacturaprimavera;
    protected String mensajeerror;
    protected String relatederpinvoice;

    /**
     * Gets the value of the codigoerror property.
     *
     * @return
     *     possible object is
     *     {@link Long }
     *
     */
    public Long getCodigoerror() {
        return codigoerror;
    }

    /**
     * Sets the value of the codigoerror property.
     *
     * @param value
     *     allowed object is
     *     {@link Long }
     *
     */
    public void setCodigoerror(Long value) {
        this.codigoerror = value;
    }

    /**
     * Gets the value of the erptransactionnumber property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getErptransactionnumber() {
        return erptransactionnumber;
    }

    /**
     * Sets the value of the erptransactionnumber property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setErptransactionnumber(BigDecimal value) {
        this.erptransactionnumber = value;
    }

    /**
     * Gets the value of the idfacturaprimavera property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    /**
     * Sets the value of the idfacturaprimavera property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdfacturaprimavera(BigDecimal value) {
        this.idfacturaprimavera = value;
    }

    /**
     * Gets the value of the mensajeerror property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMensajeerror() {
        return mensajeerror;
    }

    /**
     * Sets the value of the mensajeerror property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMensajeerror(String value) {
        this.mensajeerror = value;
    }

    /**
     * Gets the value of the relatederpinvoice property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRelatederpinvoice() {
        return relatederpinvoice;
    }

    /**
     * Sets the value of the relatederpinvoice property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRelatederpinvoice(String value) {
        this.relatederpinvoice = value;
    }

}
