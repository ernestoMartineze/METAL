
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for lineaActualizaIdERPDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="lineaActualizaIdERPDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="linenumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="montobrutolineaisr" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="montobrutolinearetiva" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="montoivalinea" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="taxclassificationcodeisr" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="taxclassificationcoderetiva" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="taxivalinea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lineaActualizaIdERPDTO",
         propOrder =
         { "linenumber", "montobrutolineaisr", "montobrutolinearetiva", "montoivalinea", "taxclassificationcodeisr",
           "taxclassificationcoderetiva", "taxivalinea"
    })
public class LineaActualizaIdERPDTO {

    protected int linenumber;
    protected BigDecimal montobrutolineaisr;
    protected BigDecimal montobrutolinearetiva;
    protected BigDecimal montoivalinea;
    protected BigInteger taxclassificationcodeisr;
    protected BigInteger taxclassificationcoderetiva;
    protected String taxivalinea;

    /**
     * Gets the value of the linenumber property.
     *
     */
    public int getLinenumber() {
        return linenumber;
    }

    /**
     * Sets the value of the linenumber property.
     *
     */
    public void setLinenumber(int value) {
        this.linenumber = value;
    }

    /**
     * Gets the value of the montobrutolineaisr property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontobrutolineaisr() {
        return montobrutolineaisr;
    }

    /**
     * Sets the value of the montobrutolineaisr property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontobrutolineaisr(BigDecimal value) {
        this.montobrutolineaisr = value;
    }

    /**
     * Gets the value of the montobrutolinearetiva property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontobrutolinearetiva() {
        return montobrutolinearetiva;
    }

    /**
     * Sets the value of the montobrutolinearetiva property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontobrutolinearetiva(BigDecimal value) {
        this.montobrutolinearetiva = value;
    }

    /**
     * Gets the value of the montoivalinea property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoivalinea() {
        return montoivalinea;
    }

    /**
     * Sets the value of the montoivalinea property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoivalinea(BigDecimal value) {
        this.montoivalinea = value;
    }

    /**
     * Gets the value of the taxclassificationcodeisr property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getTaxclassificationcodeisr() {
        return taxclassificationcodeisr;
    }

    /**
     * Sets the value of the taxclassificationcodeisr property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setTaxclassificationcodeisr(BigInteger value) {
        this.taxclassificationcodeisr = value;
    }

    /**
     * Gets the value of the taxclassificationcoderetiva property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getTaxclassificationcoderetiva() {
        return taxclassificationcoderetiva;
    }

    /**
     * Sets the value of the taxclassificationcoderetiva property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setTaxclassificationcoderetiva(BigInteger value) {
        this.taxclassificationcoderetiva = value;
    }

    /**
     * Gets the value of the taxivalinea property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTaxivalinea() {
        return taxivalinea;
    }

    /**
     * Sets the value of the taxivalinea property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTaxivalinea(String value) {
        this.taxivalinea = value;
    }

}
