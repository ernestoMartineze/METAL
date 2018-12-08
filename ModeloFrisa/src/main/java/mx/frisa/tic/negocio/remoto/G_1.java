/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

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
    
    @JacksonXmlProperty(localName = "STATEMENT_NUMBER")
    private String STATEMENT_NUMBER;
    
   
    @JacksonXmlProperty(localName = "LINE_NUMBER")
    private String LINE_NUMBER;
    @JacksonXmlProperty(localName = "RECON_STATUS")
    private String RECON_STATUS;
    @JacksonXmlProperty(localName = "TRX_TYPE")
    private String TRX_TYPE;
    @JacksonXmlProperty(localName = "FLOW_INDICATOR")
    private String FLOW_INDICATOR;
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

    public String getSTATEMENT_NUMBER() {
        return STATEMENT_NUMBER;
    }

    public void setSTATEMENT_NUMBER(String STATEMENT_NUMBER) {
        this.STATEMENT_NUMBER = STATEMENT_NUMBER;
    }

    public String getLINE_NUMBER() {
        return LINE_NUMBER;
    }

    public void setLINE_NUMBER(String LINE_NUMBER) {
        this.LINE_NUMBER = LINE_NUMBER;
    }

    public String getRECON_STATUS() {
        return RECON_STATUS;
    }

    public void setRECON_STATUS(String RECON_STATUS) {
        this.RECON_STATUS = RECON_STATUS;
    }

    public String getTRX_TYPE() {
        return TRX_TYPE;
    }

    public void setTRX_TYPE(String TRX_TYPE) {
        this.TRX_TYPE = TRX_TYPE;
    }

    public String getFLOW_INDICATOR() {
        return FLOW_INDICATOR;
    }

    public void setFLOW_INDICATOR(String FLOW_INDICATOR) {
        this.FLOW_INDICATOR = FLOW_INDICATOR;
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

    
}
