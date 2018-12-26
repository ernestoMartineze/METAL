/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;

/**
 *
 * @author Soultech
 */

public class AmountTypeDTO {

    protected BigDecimal value = null;
    protected String currencyCode = null;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

}
