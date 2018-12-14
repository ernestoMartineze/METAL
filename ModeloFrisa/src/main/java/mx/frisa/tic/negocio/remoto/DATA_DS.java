/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.List;



@JsonIgnoreProperties(ignoreUnknown=true)
public class DATA_DS {
    @JacksonXmlProperty(localName = "BANK_ACCOUNT_NUMBER")
 private String BANK_ACCOUNT_NUMBER;
    @JacksonXmlProperty(localName = "FROM_DATE")
 private String FROM_DATE;
    @JacksonXmlProperty(localName = "TO_DATE")
 private String TO_DATE;
 
@JacksonXmlProperty(localName = "G_1")
@JacksonXmlCData
@JacksonXmlElementWrapper(useWrapping = false)
 private List < G_1 > G_1;

    public String getBANK_ACCOUNT_NUMBER() {
        return BANK_ACCOUNT_NUMBER;
    }

    public void setBANK_ACCOUNT_NUMBER(String BANK_ACCOUNT_NUMBER) {
        this.BANK_ACCOUNT_NUMBER = BANK_ACCOUNT_NUMBER;
    }

    public String getFROM_DATE() {
        return FROM_DATE;
    }

    public void setFROM_DATE(String FROM_DATE) {
        this.FROM_DATE = FROM_DATE;
    }

    public String getTO_DATE() {
        return TO_DATE;
    }

    public void setTO_DATE(String TO_DATE) {
        this.TO_DATE = TO_DATE;
    }

    public List<G_1> getG_1() {
        return G_1;
    }

    public void setG_1(List<G_1> G_1) {
        this.G_1 = G_1;
    }

 
 
}