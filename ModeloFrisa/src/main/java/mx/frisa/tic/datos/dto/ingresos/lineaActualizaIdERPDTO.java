/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author Soultech
 */
public class lineaActualizaIdERPDTO {
    
    protected int linenumber;
    protected String taxivalinea;
    protected BigDecimal montoivalinea;
    protected BigInteger taxclassificationcoderetiva;
    protected BigDecimal montobrutolinearetiva;
    protected BigInteger taxclassificationcodeisr;
    protected BigDecimal montobrutolineaisr;

    public int getLinenumber() {
        return linenumber;
    }

    public void setLinenumber(int linenumber) {
        this.linenumber = linenumber;
    }

    public String getTaxivalinea() {
        return taxivalinea;
    }

    public void setTaxivalinea(String taxivalinea) {
        this.taxivalinea = taxivalinea;
    }

    public BigDecimal getMontoivalinea() {
        return montoivalinea;
    }

    public void setMontoivalinea(BigDecimal montoivalinea) {
        this.montoivalinea = montoivalinea;
    }

    public BigInteger getTaxclassificationcoderetiva() {
        return taxclassificationcoderetiva;
    }

    public void setTaxclassificationcoderetiva(BigInteger taxclassificationcoderetiva) {
        this.taxclassificationcoderetiva = taxclassificationcoderetiva;
    }

    public BigDecimal getMontobrutolinearetiva() {
        return montobrutolinearetiva;
    }

    public void setMontobrutolinearetiva(BigDecimal montobrutolinearetiva) {
        this.montobrutolinearetiva = montobrutolinearetiva;
    }

    public BigInteger getTaxclassificationcodeisr() {
        return taxclassificationcodeisr;
    }

    public void setTaxclassificationcodeisr(BigInteger taxclassificationcodeisr) {
        this.taxclassificationcodeisr = taxclassificationcodeisr;
    }

    public BigDecimal getMontobrutolineaisr() {
        return montobrutolineaisr;
    }

    public void setMontobrutolineaisr(BigDecimal montobrutolineaisr) {
        this.montobrutolineaisr = montobrutolineaisr;
    }
    
}
