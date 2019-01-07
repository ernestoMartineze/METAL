/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigInteger;

/**
 *
 * @author Ernesto
 */
public class Cabecera_FacturaDTO {
    
    private String orgId;
    private String businessUnit;
    private String origSystemBatchName;
    private String billCustomerAccountNumber;
    private BigInteger billCustomerSiteNumber;
    private String trxDate;
    private String description;
    private String currencyCode;
    private String customerTrxTypeName;
    private String glDate;
    private String paymentTermsName;
    private Long proyecto;
    private Long numeroDeContrato;
    private String lineaDeCaptura;
    private String addendaid;
    private BigInteger facturaUnifier;
    private String numeroDeLocal;
    private String batchSourceName;
    private String folio;
    
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getOrigSystemBatchName() {
        return origSystemBatchName;
    }

    public void setOrigSystemBatchName(String origSystemBatchName) {
        this.origSystemBatchName = origSystemBatchName;
    }

    public String getBillCustomerAccountNumber() {
        return billCustomerAccountNumber;
    }

    public void setBillCustomerAccountNumber(String billCustomerAccountNumber) {
        this.billCustomerAccountNumber = billCustomerAccountNumber;
    }

    public BigInteger getBillCustomerSiteNumber() {
        return billCustomerSiteNumber;
    }

    public void setBillCustomerSiteNumber(BigInteger billCustomerSiteNumber) {
        this.billCustomerSiteNumber = billCustomerSiteNumber;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCustomerTrxTypeName() {
        return customerTrxTypeName;
    }

    public void setCustomerTrxTypeName(String customerTrxTypeName) {
        this.customerTrxTypeName = customerTrxTypeName;
    }

    public String getGlDate() {
        return glDate;
    }

    public void setGlDate(String glDate) {
        this.glDate = glDate;
    }

    public String getPaymentTermsName() {
        return paymentTermsName;
    }

    public void setPaymentTermsName(String paymentTermsName) {
        this.paymentTermsName = paymentTermsName;
    }

    public Long getProyecto() {
        return proyecto;
    }

    public void setProyecto(Long proyecto) {
        this.proyecto = proyecto;
    }

    public Long getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public void setNumeroDeContrato(Long numeroDeContrato) {
        this.numeroDeContrato = numeroDeContrato;
    }

    public String getLineaDeCaptura() {
        return lineaDeCaptura;
    }

    public void setLineaDeCaptura(String lineaDeCaptura) {
        this.lineaDeCaptura = lineaDeCaptura;
    }

    public String getAddendaid() {
        return addendaid;
    }

    public void setAddendaid(String addendaid) {
        this.addendaid = addendaid;
    }

    public BigInteger getFacturaUnifier() {
        return facturaUnifier;
    }

    public void setFacturaUnifier(BigInteger facturaUnifier) {
        this.facturaUnifier = facturaUnifier;
    }

    public String getNumeroDeLocal() {
        return numeroDeLocal;
    }

    public void setNumeroDeLocal(String numeroDeLocal) {
        this.numeroDeLocal = numeroDeLocal;
    }

    public String getBatchSourceName() {
        return batchSourceName;
    }

    public void setBatchSourceName(String batchSourceName) {
        this.batchSourceName = batchSourceName;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
    
}
