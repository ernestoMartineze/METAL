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
public class RespuestaClienteDTO {
    
    private Proceso proceso;
    private BigDecimal idPago, proyectoID, numeroCobro, montoPendienteDeAplicar, totalLC ;
    private String nombrePago, unidadNegocio, cliente, estadoCobro, estadoConciliacion;

    public BigDecimal getIdPago() {
        return idPago;
    }

    public void setIdPago(BigDecimal idPago) {
        this.idPago = idPago;
    }

    public BigDecimal getProyectoID() {
        return proyectoID;
    }

    public void setProyectoID(BigDecimal proyectoID) {
        this.proyectoID = proyectoID;
    }

    public BigDecimal getNumeroCobro() {
        return numeroCobro;
    }

    public void setNumeroCobro(BigDecimal numeroCobro) {
        this.numeroCobro = numeroCobro;
    }

    public BigDecimal getMontoPendienteDeAplicar() {
        return montoPendienteDeAplicar;
    }

    public void setMontoPendienteDeAplicar(BigDecimal montoPendienteDeAplicar) {
        this.montoPendienteDeAplicar = montoPendienteDeAplicar;
    }

    public String getNombrePago() {
        return nombrePago;
    }

    public void setNombrePago(String nombrePago) {
        this.nombrePago = nombrePago;
    }

    public String getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(String unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstadoCobro() {
        return estadoCobro;
    }

    public void setEstadoCobro(String estadoCobro) {
        this.estadoCobro = estadoCobro;
    }

    public String getEstadoConciliacion() {
        return estadoConciliacion;
    }

    public void setEstadoConciliacion(String estadoConciliacion) {
        this.estadoConciliacion = estadoConciliacion;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public BigDecimal getTotalLC() {
        return totalLC;
    }

    public void setTotalLC(BigDecimal totalLC) {
        this.totalLC = totalLC;
    }
    
    
}
