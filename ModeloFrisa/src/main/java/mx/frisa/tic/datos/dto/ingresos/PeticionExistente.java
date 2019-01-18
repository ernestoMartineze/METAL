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
public class PeticionExistente {
    
    private String lineaCaptura;
    private String referencia;
    private BigInteger idPago, numeroRecibo;

    public String getLineaCaptura() {
        return lineaCaptura;
    }

    public void setLineaCaptura(String lineaCaptura) {
        this.lineaCaptura = lineaCaptura;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigInteger getIdPago() {
        return idPago;
    }

    public void setIdPago(BigInteger idPago) {
        this.idPago = idPago;
    }

    public BigInteger getNumeroRecibo() {
        return numeroRecibo;
    }

    public void setNumeroRecibo(BigInteger numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }
    
    
    
}
