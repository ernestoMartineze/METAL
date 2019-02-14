/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;

/**
 *
 * @author USER_1
 */
public class LineaEstadoCuentaDTO {

    private String  fecha, TipoDeposito, conceptoMovimiento, metodoPago, cliente;
    private BigDecimal orgID, idPago, idEstadoCuenta, cuentaBancaria, monto, proyecto;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(BigDecimal cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    
    public String getTipoDeposito() {
        return TipoDeposito;
    }

    public void setTipoDeposito(String TipoDeposito) {
        this.TipoDeposito = TipoDeposito;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public BigDecimal getOrgID() {
        return orgID;
    }

    public void setOrgID(BigDecimal orgID) {
        this.orgID = orgID;
    }

    public BigDecimal getIdPago() {
        return idPago;
    }

    public void setIdPago(BigDecimal idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getIdEstadoCuenta() {
        return idEstadoCuenta;
    }

    public void setIdEstadoCuenta(BigDecimal idEstadoCuenta) {
        this.idEstadoCuenta = idEstadoCuenta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getProyecto() {
        return proyecto;
    }

    public void setProyecto(BigDecimal proyecto) {
        this.proyecto = proyecto;
    }

  
    
}
