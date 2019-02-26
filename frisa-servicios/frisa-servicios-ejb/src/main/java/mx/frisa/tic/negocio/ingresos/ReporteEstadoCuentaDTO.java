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
    
    private String idEstadoCuenta;
    private String idLineaEstadoCuenta;
    private String codigo;
    private String descripcion;
    private String uuid;
    private String AMOUNT;
    private String CUSTOMER_REFERENCE;
    private String LINE_CAPTURE;
    private String STATEMENT_HEADER_ID;
    private String STATEMENT_LINE_ID;
    private Date fecha;
    private BigInteger numeroCuenta;
    private BigInteger idCuenta;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public void setIdEstadoCuenta(String idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    public String getIdLineaEstadoCuenta() {
        return idLineaEstadoCuenta;
    }

    public void setIdLineaEstadoCuenta(String idLineaEstadoCuenta) {
        this.idLineaEstadoCuenta = idLineaEstadoCuenta;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getCUSTOMER_REFERENCE() {
        return CUSTOMER_REFERENCE;
    }

    public void setCUSTOMER_REFERENCE(String CUSTOMER_REFERENCE) {
        this.CUSTOMER_REFERENCE = CUSTOMER_REFERENCE;
    }

    public String getLINE_CAPTURE() {
        return LINE_CAPTURE;
    }

    public void setLINE_CAPTURE(String LINE_CAPTURE) {
        this.LINE_CAPTURE = LINE_CAPTURE;
    }

    public String getSTATEMENT_HEADER_ID() {
        return STATEMENT_HEADER_ID;
    }

    public void setSTATEMENT_HEADER_ID(String STATEMENT_HEADER_ID) {
        this.STATEMENT_HEADER_ID = STATEMENT_HEADER_ID;
    }

    public String getSTATEMENT_LINE_ID() {
        return STATEMENT_LINE_ID;
    }

    public void setSTATEMENT_LINE_ID(String STATEMENT_LINE_ID) {
        this.STATEMENT_LINE_ID = STATEMENT_LINE_ID;
    }

    
    
}
