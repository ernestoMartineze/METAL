/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigInteger;

/**
 *
 * @author Soultech
 */
public class LineaCaptutaFacturaDTO {
    
    protected String lineacaptura;
    protected BigInteger idfacturaprimavera;
    protected String idbatch;

    public String getLineacaptura() {
        return lineacaptura;
    }

    public void setLineacaptura(String lineacaptura) {
        this.lineacaptura = lineacaptura;
    }

    public BigInteger getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigInteger idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public String getIdbatch() {
        return idbatch;
    }

    public void setIdbatch(String idbatch) {
        this.idbatch = idbatch;
    }

    public LineaCaptutaFacturaDTO(String lineacaptura, BigInteger idfacturaprimavera, String idbatch) {
        this.lineacaptura = lineacaptura;
        this.idfacturaprimavera = idfacturaprimavera;
        this.idbatch = idbatch;
    }

    public LineaCaptutaFacturaDTO() {
    }
    
}
