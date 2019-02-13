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
public class cabeceraActualizaIdERPDTO {
    
    protected BigDecimal idfacturaprimavera;
    protected Long codigoerror;
    protected String mensajeerror;
    protected String relatederpinvoice;
    protected BigDecimal erptransactionnumber;

    public BigDecimal getIdfacturaprimavera() {
        return idfacturaprimavera;
    }

    public void setIdfacturaprimavera(BigDecimal idfacturaprimavera) {
        this.idfacturaprimavera = idfacturaprimavera;
    }

    public Long getCodigoerror() {
        return codigoerror;
    }

    public void setCodigoerror(Long codigoerror) {
        this.codigoerror = codigoerror;
    }

    public String getMensajeerror() {
        return mensajeerror;
    }

    public void setMensajeerror(String mensajeerror) {
        this.mensajeerror = mensajeerror;
    }

    public String getRelatederpinvoice() {
        return relatederpinvoice;
    }

    public void setRelatederpinvoice(String relatederpinvoice) {
        this.relatederpinvoice = relatederpinvoice;
    }

    public BigDecimal getErptransactionnumber() {
        return erptransactionnumber;
    }

    public void setErptransactionnumber(BigDecimal erptransactionnumber) {
        this.erptransactionnumber = erptransactionnumber;
    }
    
}
