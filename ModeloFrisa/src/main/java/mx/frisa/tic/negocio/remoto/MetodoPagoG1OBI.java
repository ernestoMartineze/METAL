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
public class MetodoPagoG1OBI {
    @JacksonXmlProperty(localName = "BANK_ACCOUNT_NUM")
    private String BANK_ACCOUNT_NUM;
    @JacksonXmlProperty(localName = "RECEIPT_METHOD_ID")
    private String RECEIPT_METHOD_ID;
    @JacksonXmlProperty(localName = "NAME")
    private String NAME;
    @JacksonXmlProperty(localName = "PRINTED_NAME")
    private String PRINTED_NAME;
    @JacksonXmlProperty(localName = "REMIT_BANK_ACCT_USE_ID")
    private String REMIT_BANK_ACCT_USE_ID;
    @JacksonXmlProperty(localName = "ORG_ID")
    private String ORG_ID;
    @JacksonXmlProperty(localName = "BAU_BANK_ACCOUNTID")
    private String BAU_BANK_ACCOUNTID;
    @JacksonXmlProperty(localName = "ORGBAU")
    private String ORGBAU;
    @JacksonXmlProperty(localName = "BANK_BRANCH_ID")
    private String BANK_BRANCH_ID;
    @JacksonXmlProperty(localName = "OU_NAME")
    private String OU_NAME;

    public String getBANK_ACCOUNT_NUM() {
        return BANK_ACCOUNT_NUM;
    }

    public void setBANK_ACCOUNT_NUM(String BANK_ACCOUNT_NUM) {
        this.BANK_ACCOUNT_NUM = BANK_ACCOUNT_NUM;
    }

    public String getRECEIPT_METHOD_ID() {
        return RECEIPT_METHOD_ID;
    }

    public void setRECEIPT_METHOD_ID(String RECEIPT_METHOD_ID) {
        this.RECEIPT_METHOD_ID = RECEIPT_METHOD_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPRINTED_NAME() {
        return PRINTED_NAME;
    }

    public void setPRINTED_NAME(String PRINTED_NAME) {
        this.PRINTED_NAME = PRINTED_NAME;
    }

    public String getREMIT_BANK_ACCT_USE_ID() {
        return REMIT_BANK_ACCT_USE_ID;
    }

    public void setREMIT_BANK_ACCT_USE_ID(String REMIT_BANK_ACCT_USE_ID) {
        this.REMIT_BANK_ACCT_USE_ID = REMIT_BANK_ACCT_USE_ID;
    }

    public String getORG_ID() {
        return ORG_ID;
    }

    public void setORG_ID(String ORG_ID) {
        this.ORG_ID = ORG_ID;
    }

    public String getBAU_BANK_ACCOUNTID() {
        return BAU_BANK_ACCOUNTID;
    }

    public void setBAU_BANK_ACCOUNTID(String BAU_BANK_ACCOUNTID) {
        this.BAU_BANK_ACCOUNTID = BAU_BANK_ACCOUNTID;
    }

    public String getORGBAU() {
        return ORGBAU;
    }

    public void setORGBAU(String ORGBAU) {
        this.ORGBAU = ORGBAU;
    }

    public String getBANK_BRANCH_ID() {
        return BANK_BRANCH_ID;
    }

    public void setBANK_BRANCH_ID(String BANK_BRANCH_ID) {
        this.BANK_BRANCH_ID = BANK_BRANCH_ID;
    }

    public String getOU_NAME() {
        return OU_NAME;
    }

    public void setOU_NAME(String OU_NAME) {
        this.OU_NAME = OU_NAME;
    }
    
    
    
}
