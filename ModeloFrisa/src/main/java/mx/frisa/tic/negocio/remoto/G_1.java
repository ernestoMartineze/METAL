/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.Date;

/**
 *
 * @author USER_1
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class G_1 {
    @JacksonXmlProperty(localName = "BANK_ACCOUNT_NUM")
    private String BANK_ACCOUNT_NUM;
    @JacksonXmlProperty(localName = "STMT_FROM_DATE")
    private String STMT_FROM_DATE;
    @JacksonXmlProperty(localName = "STMT_TO_DATE")
    private String STMT_TO_DATE;
    
    @JacksonXmlProperty(localName = "STATEMENT_HEADER_ID")
    private String STATEMENT_HEADER_ID;
    @JacksonXmlProperty(localName = "STATEMENT_LINE_ID")
    private String STATEMENT_LINE_ID;
    @JacksonXmlProperty(localName = "BANK_ACCOUNT_ID")
    private String BANK_ACCOUNT_ID;
    @JacksonXmlProperty(localName = "STATEMENT_NUMBER")
    private String STATEMENT_NUMBER; //Fecha
    @JacksonXmlProperty(localName = "REFERENCIA")
    private String REFERENCIA;
    
    
    @JacksonXmlProperty(localName = "DESCRIP_LOOKUP")
    private String DESCRIP_LOOKUP;
    
   
    @JacksonXmlProperty(localName = "LINE_NUMBER")
    private String LINE_NUMBER;
    @JacksonXmlProperty(localName = "ADDITIONAL_ENTRY_INFORMATION")
    private String ADDITIONAL_ENTRY_INFORMATION;
    @JacksonXmlProperty(localName = "TRX_TYPE")
    private String TRX_TYPE;
    @JacksonXmlProperty(localName = "PROYECTO_PROPIETARIO")
    private String PROYECTO_PROPIETARIO;
    @JacksonXmlProperty(localName = "LINEA_CAPTURA")
    private String LINEA_CAPTURA;
    @JacksonXmlProperty(localName = "AMOUNT")
    private String AMOUNT;
    @JacksonXmlProperty(localName = "TRX_CODE")
    private String TRX_CODE;
    @JacksonXmlProperty(localName = "CURRENCY_CODE")
    private String CURRENCY_CODE;
    
    private String idEstadoCuenta;

    public String getBANK_ACCOUNT_NUM() {
        return BANK_ACCOUNT_NUM;
    }

    public void setBANK_ACCOUNT_NUM(String BANK_ACCOUNT_NUM) {
        this.BANK_ACCOUNT_NUM = BANK_ACCOUNT_NUM;
    }

    public String getSTMT_FROM_DATE() {
        return STMT_FROM_DATE;
    }

    public void setSTMT_FROM_DATE(String STMT_FROM_DATE) {
        this.STMT_FROM_DATE = STMT_FROM_DATE;
    }

    public String getSTMT_TO_DATE() {
        return STMT_TO_DATE;
    }

    public void setSTMT_TO_DATE(String STMT_TO_DATE) {
        this.STMT_TO_DATE = STMT_TO_DATE;
    }

    public String getSTATEMENT_HEADER_ID() {
        return STATEMENT_HEADER_ID;
    }

    public void setSTATEMENT_HEADER_ID(String STATEMENT_HEADER_ID) {
        this.STATEMENT_HEADER_ID = STATEMENT_HEADER_ID;
    }

    public String getSTATEMENT_LINE_ID() {
        return STATEMENT_LINE_ID;
    }

    public void setSTATEMENT_LINE_ID(String STATEMENT_LINE_ID) {
        this.STATEMENT_LINE_ID = STATEMENT_LINE_ID;
    }

    public String getBANK_ACCOUNT_ID() {
        return BANK_ACCOUNT_ID;
    }

    public void setBANK_ACCOUNT_ID(String BANK_ACCOUNT_ID) {
        this.BANK_ACCOUNT_ID = BANK_ACCOUNT_ID;
    }

    public String getSTATEMENT_NUMBER() {
        return STATEMENT_NUMBER;
    }

    public void setSTATEMENT_NUMBER(String STATEMENT_NUMBER) {
        this.STATEMENT_NUMBER = STATEMENT_NUMBER;
    }

    public String getREFERENCIA() {
        return REFERENCIA;
    }

    public void setREFERENCIA(String REFERENCIA) {
        this.REFERENCIA = REFERENCIA;
    }

    public String getDESCRIP_LOOKUP() {
        return DESCRIP_LOOKUP;
    }

    public void setDESCRIP_LOOKUP(String DESCRIP_LOOKUP) {
        this.DESCRIP_LOOKUP = DESCRIP_LOOKUP;
    }

    public String getLINE_NUMBER() {
        return LINE_NUMBER;
    }

    public void setLINE_NUMBER(String LINE_NUMBER) {
        this.LINE_NUMBER = LINE_NUMBER;
    }

    public String getADDITIONAL_ENTRY_INFORMATION() {
        return ADDITIONAL_ENTRY_INFORMATION;
    }

    public void setADDITIONAL_ENTRY_INFORMATION(String ADDITIONAL_ENTRY_INFORMATION) {
        this.ADDITIONAL_ENTRY_INFORMATION = ADDITIONAL_ENTRY_INFORMATION;
    }

    public String getTRX_TYPE() {
        return TRX_TYPE;
    }

    public void setTRX_TYPE(String TRX_TYPE) {
        this.TRX_TYPE = TRX_TYPE;
    }

    public String getPROYECTO_PROPIETARIO() {
        return PROYECTO_PROPIETARIO;
    }

    public void setPROYECTO_PROPIETARIO(String PROYECTO_PROPIETARIO) {
        this.PROYECTO_PROPIETARIO = PROYECTO_PROPIETARIO;
    }

    public String getLINEA_CAPTURA() {
        return LINEA_CAPTURA;
    }

    public void setLINEA_CAPTURA(String LINEA_CAPTURA) {
        this.LINEA_CAPTURA = LINEA_CAPTURA;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getTRX_CODE() {
        return TRX_CODE;
    }

    public void setTRX_CODE(String TRX_CODE) {
        this.TRX_CODE = TRX_CODE;
    }

    public String getCURRENCY_CODE() {
        return CURRENCY_CODE;
    }

    public void setCURRENCY_CODE(String CURRENCY_CODE) {
        this.CURRENCY_CODE = CURRENCY_CODE;
    }

    public String getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public void setIdEstadoCuenta(String idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }
    
    


    
}
