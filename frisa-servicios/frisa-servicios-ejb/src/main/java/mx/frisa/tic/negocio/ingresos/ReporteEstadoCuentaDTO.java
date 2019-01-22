/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;


import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author USER_1
 */
public class ReporteEstadoCuentaDTO {
    
    private String codigoError;
    private String descripcionError;
    private String uuid;
    private Date fecha;
    private BigInteger numeroCuenta;
    private BigInteger idCuenta;

    public String getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(String codigoError) {
        this.codigoError = codigoError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigInteger getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(BigInteger numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public BigInteger getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(BigInteger idCuenta) {
        this.idCuenta = idCuenta;
    }

    
    
}
