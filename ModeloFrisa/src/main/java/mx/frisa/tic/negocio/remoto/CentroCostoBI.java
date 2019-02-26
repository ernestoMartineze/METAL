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

@JsonIgnoreProperties(ignoreUnknown = true)
public class CentroCostoBI {
    
    @JacksonXmlProperty(localName = "FLEX_VALUE")
    private String FLEX_VALUE; 
    @JacksonXmlProperty(localName = "DESCRIPTION")
    private String DESCRIPTION; 

    public String getFLEX_VALUE() {
        return FLEX_VALUE;
    }

    public void setFLEX_VALUE(String FLEX_VALUE) {
        this.FLEX_VALUE = FLEX_VALUE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }
    
    
}
