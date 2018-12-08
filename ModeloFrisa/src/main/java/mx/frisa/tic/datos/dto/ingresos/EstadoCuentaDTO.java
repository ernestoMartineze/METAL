/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import java.sql.Date;

public class EstadoCuentaDTO {

    private BigDecimal idEdoCta;
    private BigDecimal bankAccountNum;
    private Date trxDate;
    private BigDecimal lineNumber;
    private String trxType;
    private BigDecimal amount;
    private BigDecimal trxCode;
    private String currencyCode;
    private String customerReference;
    private String addiotionalEntryInformation;
    private String proyectoPropietario;
    private String lineCapture;
    private BigDecimal idLineaCaptura;

    public BigDecimal getIdEdoCta() {
        return idEdoCta;
    }

    public void setIdEdoCta(BigDecimal idEdoCta) {
        this.idEdoCta = idEdoCta;
    }

    public BigDecimal getBankAccountNum() {
        return bankAccountNum;
    }

    public void setBankAccountNum(BigDecimal bankAccountNum) {
        this.bankAccountNum = bankAccountNum;
    }

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public BigDecimal getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(BigDecimal lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTrxCode() {
        return trxCode;
    }

    public void setTrxCode(BigDecimal trxCode) {
        this.trxCode = trxCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    public String getAddiotionalEntryInformation() {
        return addiotionalEntryInformation;
    }

    public void setAddiotionalEntryInformation(String addiotionalEntryInformation) {
        this.addiotionalEntryInformation = addiotionalEntryInformation;
    }

    public String getProyectoPropietario() {
        return proyectoPropietario;
    }

    public void setProyectoPropietario(String proyectoPropietario) {
        this.proyectoPropietario = proyectoPropietario;
    }

    public String getLineCapture() {
        return lineCapture;
    }

    public void setLineCapture(String lineCapture) {
        this.lineCapture = lineCapture;
    }

    public BigDecimal getIdLineaCaptura() {
        return idLineaCaptura;
    }

    public void setIdLineaCaptura(BigDecimal idLineaCaptura) {
        this.idLineaCaptura = idLineaCaptura;
    }
    
    
}
