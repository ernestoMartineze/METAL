/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Soultech
 */

public class CreditMemoFLEXDTO {

    protected Long customerTrxId = null;
    protected String proyecto = null;
    protected String estatusDeCfdi = null;
    protected String usoDeCfdi = null;
    protected String formaDePago = null;
    protected String folioDeCancelaciOnSat = null;
    protected String uuidDocumentoRelacionado = null;
    protected String numeroDeContrato = null;
    protected String lineaDeCaptura = null;
    protected String serie = null;
    protected String folio = null;
    protected String fechaDePrescripcion = null;
    protected String fechaTimbrado = null;
    protected String addendaid = null;
    protected String facturaUnifier;
    protected String flexContext = null;
    protected String flexContextDisplayValue = null;
    protected Integer flexNumOfSegments = null;

    public Long getCustomerTrxId() {
        return customerTrxId;
    }

    public void setCustomerTrxId(Long value) {
        this.customerTrxId = value;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String value) {
        this.proyecto = value;
    }

    public String getEstatusDeCfdi() {
        return estatusDeCfdi;
    }

    public void setEstatusDeCfdi(String value) {
        this.estatusDeCfdi = value;
    }

    public String getUsoDeCfdi() {
        return usoDeCfdi;
    }

    public void setUsoDeCfdi(String value) {
        this.usoDeCfdi = value;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String value) {
        this.formaDePago = value;
    }

    public String getFolioDeCancelaciOnSat() {
        return folioDeCancelaciOnSat;
    }

    public void setFolioDeCancelaciOnSat(String value) {
        this.folioDeCancelaciOnSat = value;
    }

    public String getUuidDocumentoRelacionado() {
        return uuidDocumentoRelacionado;
    }

    public void setUuidDocumentoRelacionado(String value) {
        this.uuidDocumentoRelacionado = value;
    }

    public String getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public void setNumeroDeContrato(String value) {
        this.numeroDeContrato = value;
    }

    public String getLineaDeCaptura() {
        return lineaDeCaptura;
    }

    public void setLineaDeCaptura(String value) {
        this.lineaDeCaptura = value;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String value) {
        this.serie = value;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String value) {
        this.folio = value;
    }

    public String getFechaDePrescripcion() {
        return fechaDePrescripcion;
    }

    public void setFechaDePrescripcion(String value) {
        this.fechaDePrescripcion = value;
    }

    public String getFechaTimbrado() {
        return fechaTimbrado;
    }

    public void setFechaTimbrado(String value) {
        this.fechaTimbrado = value;
    }

    public String getAddendaid() {
        return addendaid;
    }

    public void setAddendaid(String value) {
        this.addendaid = value;
    }

    public String getFLEXContext() {
        return flexContext;
    }

    public void setFLEXContext(String value) {
        this.flexContext = value;
    }

    public String getFLEXContextDisplayValue() {
        return flexContextDisplayValue;
    }

    public void setFLEXContextDisplayValue(String value) {
        this.flexContextDisplayValue = value;
    }

    public Integer getFLEXNumOfSegments() {
        return flexNumOfSegments;
    }

    public void setFLEXNumOfSegments(Integer value) {
        this.flexNumOfSegments = value;
    }

    public String getFacturaUnifier() {
        return facturaUnifier;
    }

    public void setFacturaUnifier(String facturaUnifier) {
        this.facturaUnifier = facturaUnifier;
    }

}