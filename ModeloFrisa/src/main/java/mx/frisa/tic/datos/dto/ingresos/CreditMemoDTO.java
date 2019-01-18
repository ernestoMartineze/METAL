/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlElementRef;
//import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
//import mx.frisa.tic.datos.dto.ingresos.AmountTypeDTO;
//import mx.frisa.tic.datos.dto.ingresos.CreditMemoFLEXDTO;
//import com.oracle.xmlns.adf.svc.types.AmountType;
//import com.oracle.xmlns.apps.financials.receivables.transactions.creditmemos.model.flex.creditmemodff.CreditMemoFLEX;

/**
 *
 * @author Soultech
 */


public class CreditMemoDTO {

    protected Long batchSourceSequenceId = null;
    protected Long customerTransactionId = null;
    protected String comments = null;
    protected Long customerTransactionTypeSequenceId = null;
    protected String customerReference = null;
    protected XMLGregorianCalendar customerReferenceDate = null;
    protected Long documentSequenceId = null;
    protected Long documentSequenceValue = null;
    protected AmountTypeDTO freightAmount = null;
    protected BigDecimal freightPercent = null;
    protected XMLGregorianCalendar glDate = null;
    protected String internalNotes = null;
    protected AmountTypeDTO lineAmount = null;
    protected BigDecimal linePercent = null;
    protected String methodForRules = null;
    protected Long previousCustomerTransactionId = null;
    protected String reasonCode = null;
    protected String splitTerminationMethod = null;
    protected XMLGregorianCalendar transactionDate = null;
    protected String currencyCode = null;
    protected String transactionNumber = null;
    protected AmountTypeDTO taxAmount = null;
    protected BigDecimal taxPercent = null;
    protected String computeTax = null;
    protected CreditMemoFLEXDTO creditMemoFLEXVA = null;

    

    /**
     * Obtiene el valor de la propiedad batchSourceSequenceId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public Long getBatchSourceSequenceId() {
        return batchSourceSequenceId;
    }

    /**
     * Define el valor de la propiedad batchSourceSequenceId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public void setBatchSourceSequenceId(Long value) {
        this.batchSourceSequenceId = value;
    }

    /**
     * Obtiene el valor de la propiedad customerTransactionId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerTransactionId() {
        return customerTransactionId;
    }

    /**
     * Define el valor de la propiedad customerTransactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerTransactionId(Long value) {
        this.customerTransactionId = value;
    }

    /**
     * Obtiene el valor de la propiedad comments.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Define el valor de la propiedad comments.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    /**
     * Obtiene el valor de la propiedad customerTransactionTypeSequenceId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerTransactionTypeSequenceId() {
        return customerTransactionTypeSequenceId;
    }

    /**
     * Define el valor de la propiedad customerTransactionTypeSequenceId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerTransactionTypeSequenceId(Long value) {
        this.customerTransactionTypeSequenceId = value;
    }

    /**
     * Obtiene el valor de la propiedad customerReference.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getCustomerReference() {
        return customerReference;
    }

    /**
     * Define el valor de la propiedad customerReference.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setCustomerReference(String value) {
        this.customerReference = value;
    }

    /**
     * Obtiene el valor de la propiedad customerReferenceDate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code }
     *     
     */
    public XMLGregorianCalendar getCustomerReferenceDate() {
        return customerReferenceDate;
    }

    /**
     * Define el valor de la propiedad customerReferenceDate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code }
     *     
     */
    public void setCustomerReferenceDate(XMLGregorianCalendar value) {
        this.customerReferenceDate = value;
    }

    /**
     * Obtiene el valor de la propiedad documentSequenceId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public Long getDocumentSequenceId() {
        return documentSequenceId;
    }

    /**
     * Define el valor de la propiedad documentSequenceId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public void setDocumentSequenceId(Long value) {
        this.documentSequenceId = value;
    }

    /**
     * Obtiene el valor de la propiedad documentSequenceValue.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public Long getDocumentSequenceValue() {
        return documentSequenceValue;
    }

    /**
     * Define el valor de la propiedad documentSequenceValue.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public void setDocumentSequenceValue(Long value) {
        this.documentSequenceValue = value;
    }

    /**
     * Obtiene el valor de la propiedad freightAmount.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code }
     *     
     */
    public AmountTypeDTO getFreightAmount() {
        return freightAmount;
    }

    /**
     * Define el valor de la propiedad freightAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code }
     *     
     */
    public void setFreightAmount(AmountTypeDTO value) {
        this.freightAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad freightPercent.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code }
     *     
     */
    public BigDecimal getFreightPercent() {
        return freightPercent;
    }

    /**
     * Define el valor de la propiedad freightPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code }
     *     
     */
    public void setFreightPercent(BigDecimal value) {
        this.freightPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad glDate.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code }
     *     
     */
    public XMLGregorianCalendar getGlDate() {
        return glDate;
    }

    /**
     * Define el valor de la propiedad glDate.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code }
     *     
     */
    public void setGlDate(XMLGregorianCalendar value) {
        this.glDate = value;
    }

    /**
     * Obtiene el valor de la propiedad internalNotes.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getInternalNotes() {
        return internalNotes;
    }

    /**
     * Define el valor de la propiedad internalNotes.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setInternalNotes(String value) {
        this.internalNotes = value;
    }

    /**
     * Obtiene el valor de la propiedad lineAmount.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code }
     *     
     */
    public AmountTypeDTO getLineAmount() {
        return lineAmount;
    }

    /**
     * Define el valor de la propiedad lineAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code }
     *     
     */
    public void setLineAmount(AmountTypeDTO value) {
        this.lineAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad linePercent.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code }
     *     
     */
    public BigDecimal getLinePercent() {
        return linePercent;
    }

    /**
     * Define el valor de la propiedad linePercent.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code }
     *     
     */
    public void setLinePercent(BigDecimal value) {
        this.linePercent = value;
    }

    /**
     * Obtiene el valor de la propiedad methodForRules.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getMethodForRules() {
        return methodForRules;
    }

    /**
     * Define el valor de la propiedad methodForRules.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setMethodForRules(String value) {
        this.methodForRules = value;
    }

    /**
     * Obtiene el valor de la propiedad previousCustomerTransactionId.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public Long getPreviousCustomerTransactionId() {
        return previousCustomerTransactionId;
    }

    /**
     * Define el valor de la propiedad previousCustomerTransactionId.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code }
     *     
     */
    public void setPreviousCustomerTransactionId(Long value) {
        this.previousCustomerTransactionId = value;
    }

    /**
     * Obtiene el valor de la propiedad reasonCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getReasonCode() {
        return reasonCode;
    }

    /**
     * Define el valor de la propiedad reasonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setReasonCode(String value) {
        this.reasonCode = value;
    }

    /**
     * Obtiene el valor de la propiedad splitTerminationMethod.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getSplitTerminationMethod() {
        return splitTerminationMethod;
    }

    /**
     * Define el valor de la propiedad splitTerminationMethod.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setSplitTerminationMethod(String value) {
        this.splitTerminationMethod = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionDate() {
        return transactionDate;
    }

    /**
     * Define el valor de la propiedad transactionDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionDate(XMLGregorianCalendar value) {
        this.transactionDate = value;
    }

    /**
     * Obtiene el valor de la propiedad currencyCode.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Define el valor de la propiedad currencyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * Define el valor de la propiedad transactionNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionNumber(String value) {
        this.transactionNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad taxAmount.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code }
     *     
     */
    public AmountTypeDTO getTaxAmount() {
        return taxAmount;
    }

    /**
     * Define el valor de la propiedad taxAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AmountType }{@code }
     *     
     */
    public void setTaxAmount(AmountTypeDTO value) {
        this.taxAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad taxPercent.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code }
     *     
     */
    public BigDecimal getTaxPercent() {
        return taxPercent;
    }

    /**
     * Define el valor de la propiedad taxPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code }
     *     
     */
    public void setTaxPercent(BigDecimal value) {
        this.taxPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad computeTax.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public String getComputeTax() {
        return computeTax;
    }

    /**
     * Define el valor de la propiedad computeTax.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code }
     *     
     */
    public void setComputeTax(String value) {
        this.computeTax = value;
    }

    /**
     * Obtiene el valor de la propiedad creditMemoFLEXVA.
     * 
     * @return
     *     possible object is
     *     {@link CreditMemoFLEX }
     *     
     */
    public CreditMemoFLEXDTO getCreditMemoFLEXVA() {
        return creditMemoFLEXVA;
    }

    /**
     * Define el valor de la propiedad creditMemoFLEXVA.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditMemoFLEX }
     *     
     */
    public void setCreditMemoFLEXVA(CreditMemoFLEXDTO value) {
        this.creditMemoFLEXVA = value;
    }

}
