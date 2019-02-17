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

/**
 *
 * @author USER_1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaERP_Cuenta {

    @JacksonXmlProperty(localName = "G_1")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CuentaBancaria> cuentaBancaria;

    public List<CuentaBancaria> getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(List<CuentaBancaria> cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    
    

}
