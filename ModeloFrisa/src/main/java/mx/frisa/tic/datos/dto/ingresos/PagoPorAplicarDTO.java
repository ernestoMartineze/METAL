/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigInteger;

/**
 *
 * @author USER_1
 */
public class PagoPorAplicarDTO {
    
    private String referencia, lineaCaptura;
    private BigInteger idLineaCaputura, idPago, idEdoCuenta, termino;

    public String getReferencia() {
        return referencia;
    }    
    
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigInteger getIdLineaCaputura() {
        return idLineaCaputura;
    }

    public void setIdLineaCaputura(BigInteger idLineaCaputura) {
        this.idLineaCaputura = idLineaCaputura;
    }

    public BigInteger getIdPago() {
        return idPago;
    }

    public void setIdPago(BigInteger idPago) {
        this.idPago = idPago;
    }

    public BigInteger getIdEdoCuenta() {
        return idEdoCuenta;
    }

    public void setIdEdoCuenta(BigInteger idEdoCuenta) {
        this.idEdoCuenta = idEdoCuenta;
    }

    public BigInteger getTermino() {
        return termino;
    }

    public void setTermino(BigInteger termino) {
        this.termino = termino;
    }

    public String getLineaCaptura() {
        return lineaCaptura;
    }

    public void setLineaCaptura(String lineaCaptura) {
        this.lineaCaptura = lineaCaptura;
    }
    
}
