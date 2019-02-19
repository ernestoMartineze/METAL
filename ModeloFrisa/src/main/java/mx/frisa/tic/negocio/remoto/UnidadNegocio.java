/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.remoto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 *
 * @author USER_1
 */
public class UnidadNegocio {
    
    @JacksonXmlProperty(localName = "BU_ID")
    private String BU_ID;
    @JacksonXmlProperty(localName = "BU_NAME")
    private String BU_NAME;
    @JacksonXmlProperty(localName = "STATUS")
    private String STATUS;

    public String getBU_ID() {
        return BU_ID;
    }

    public void setBU_ID(String BU_ID) {
        this.BU_ID = BU_ID;
    }

    public String getBU_NAME() {
        return BU_NAME;
    }

    public void setBU_NAME(String BU_NAME) {
        this.BU_NAME = BU_NAME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    
    
    
}
