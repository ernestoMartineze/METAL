
package mx.frisa.tic.negocio.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for detalleLineaCapturaDTO complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="detalleLineaCapturaDTO"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="banco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="capitalrentacondonada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="centrocostosproyecto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cuentabancaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="division" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="entidadlegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estatuslc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechacreacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fechavigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="folioacuerdocobranza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idlineacaptura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="interesmoratoriocondonado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lineacaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lineacapturaref" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="montoacuerdocobranza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="montolineacaptura" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="numerorecibo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ordinariocondonado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sistemaorigen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipocobranza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="unidadnegocio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "detalleLineaCapturaDTO",
         propOrder =
         { "banco", "capitalrentacondonada", "centrocostosproyecto", "cuentabancaria", "division", "entidadlegal",
           "estatuslc", "fechacreacion", "fechavigencia", "folioacuerdocobranza", "idlineacaptura",
           "interesmoratoriocondonado", "lineacaptura", "lineacapturaref", "montoacuerdocobranza", "montolineacaptura",
           "numerorecibo", "ordinariocondonado", "referencia", "sistemaorigen", "tipocobranza", "unidadnegocio"
    })
public class DetalleLineaCapturaDTO {

    protected String banco;
    protected String capitalrentacondonada;
    protected String centrocostosproyecto;
    protected String cuentabancaria;
    protected String division;
    protected String entidadlegal;
    protected String estatuslc;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechacreacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechavigencia;
    protected String folioacuerdocobranza;
    protected BigDecimal idlineacaptura;
    protected String interesmoratoriocondonado;
    protected String lineacaptura;
    protected String lineacapturaref;
    protected String montoacuerdocobranza;
    protected BigDecimal montolineacaptura;
    protected String numerorecibo;
    protected String ordinariocondonado;
    protected String referencia;
    protected String sistemaorigen;
    protected String tipocobranza;
    protected String unidadnegocio;

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
     * Gets the value of the capitalrentacondonada property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCapitalrentacondonada() {
        return capitalrentacondonada;
    }

    /**
     * Sets the value of the capitalrentacondonada property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCapitalrentacondonada(String value) {
        this.capitalrentacondonada = value;
    }

    /**
     * Gets the value of the centrocostosproyecto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCentrocostosproyecto() {
        return centrocostosproyecto;
    }

    /**
     * Sets the value of the centrocostosproyecto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCentrocostosproyecto(String value) {
        this.centrocostosproyecto = value;
    }

    /**
     * Gets the value of the cuentabancaria property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCuentabancaria() {
        return cuentabancaria;
    }

    /**
     * Sets the value of the cuentabancaria property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCuentabancaria(String value) {
        this.cuentabancaria = value;
    }

    /**
     * Gets the value of the division property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDivision() {
        return division;
    }

    /**
     * Sets the value of the division property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDivision(String value) {
        this.division = value;
    }

    /**
     * Gets the value of the entidadlegal property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEntidadlegal() {
        return entidadlegal;
    }

    /**
     * Sets the value of the entidadlegal property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEntidadlegal(String value) {
        this.entidadlegal = value;
    }

    /**
     * Gets the value of the estatuslc property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getEstatuslc() {
        return estatuslc;
    }

    /**
     * Sets the value of the estatuslc property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setEstatuslc(String value) {
        this.estatuslc = value;
    }

    /**
     * Gets the value of the fechacreacion property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechacreacion() {
        return fechacreacion;
    }

    /**
     * Sets the value of the fechacreacion property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechacreacion(XMLGregorianCalendar value) {
        this.fechacreacion = value;
    }

    /**
     * Gets the value of the fechavigencia property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFechavigencia() {
        return fechavigencia;
    }

    /**
     * Sets the value of the fechavigencia property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFechavigencia(XMLGregorianCalendar value) {
        this.fechavigencia = value;
    }

    /**
     * Gets the value of the folioacuerdocobranza property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFolioacuerdocobranza() {
        return folioacuerdocobranza;
    }

    /**
     * Sets the value of the folioacuerdocobranza property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFolioacuerdocobranza(String value) {
        this.folioacuerdocobranza = value;
    }

    /**
     * Gets the value of the idlineacaptura property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdlineacaptura() {
        return idlineacaptura;
    }

    /**
     * Sets the value of the idlineacaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdlineacaptura(BigDecimal value) {
        this.idlineacaptura = value;
    }

    /**
     * Gets the value of the interesmoratoriocondonado property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getInteresmoratoriocondonado() {
        return interesmoratoriocondonado;
    }

    /**
     * Sets the value of the interesmoratoriocondonado property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setInteresmoratoriocondonado(String value) {
        this.interesmoratoriocondonado = value;
    }

    /**
     * Gets the value of the lineacaptura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineacaptura() {
        return lineacaptura;
    }

    /**
     * Sets the value of the lineacaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineacaptura(String value) {
        this.lineacaptura = value;
    }

    /**
     * Gets the value of the lineacapturaref property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineacapturaref() {
        return lineacapturaref;
    }

    /**
     * Sets the value of the lineacapturaref property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineacapturaref(String value) {
        this.lineacapturaref = value;
    }

    /**
     * Gets the value of the montoacuerdocobranza property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMontoacuerdocobranza() {
        return montoacuerdocobranza;
    }

    /**
     * Sets the value of the montoacuerdocobranza property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMontoacuerdocobranza(String value) {
        this.montoacuerdocobranza = value;
    }

    /**
     * Gets the value of the montolineacaptura property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontolineacaptura() {
        return montolineacaptura;
    }

    /**
     * Sets the value of the montolineacaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontolineacaptura(BigDecimal value) {
        this.montolineacaptura = value;
    }

    /**
     * Gets the value of the numerorecibo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumerorecibo() {
        return numerorecibo;
    }

    /**
     * Sets the value of the numerorecibo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumerorecibo(String value) {
        this.numerorecibo = value;
    }

    /**
     * Gets the value of the ordinariocondonado property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrdinariocondonado() {
        return ordinariocondonado;
    }

    /**
     * Sets the value of the ordinariocondonado property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrdinariocondonado(String value) {
        this.ordinariocondonado = value;
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
     * Gets the value of the sistemaorigen property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSistemaorigen() {
        return sistemaorigen;
    }

    /**
     * Sets the value of the sistemaorigen property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSistemaorigen(String value) {
        this.sistemaorigen = value;
    }

    /**
     * Gets the value of the tipocobranza property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipocobranza() {
        return tipocobranza;
    }

    /**
     * Sets the value of the tipocobranza property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipocobranza(String value) {
        this.tipocobranza = value;
    }

    /**
     * Gets the value of the unidadnegocio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUnidadnegocio() {
        return unidadnegocio;
    }

    /**
     * Sets the value of the unidadnegocio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUnidadnegocio(String value) {
        this.unidadnegocio = value;
    }

}
