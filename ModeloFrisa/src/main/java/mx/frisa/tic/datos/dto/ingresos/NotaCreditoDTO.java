/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author USER_1
 */
public class NotaCreditoDTO {

    String uuid;
    String descripcion;
    Date fechaRegistro;
    Date fechaAplicacion;
    String estatus;
    BigDecimal montoNota;
    Integer facturaPrimavera;
    String msgError;

    public String getMsgError() {
        return msgError;
    }

    public void setMsgError(String msgError) {
        this.msgError = msgError;
    }

    
    public Boolean isValido() throws Exception {

        Date fechaActual;
        Calendar currentDate = Calendar.getInstance();
        fechaActual = new Date(currentDate.getTimeInMillis());
        if (this.uuid.isEmpty()) {
            this.msgError ="Falta indicar el UUID de la nota de credito";
            return false;
        }
        if (this.descripcion.isEmpty()) {
            this.msgError ="Falta indicar la descripción o motivo de la nota de credito";
            return false;
        }
        if (this.fechaRegistro.after(fechaActual)) {
            this.msgError ="Falta indicar la fecha de registro de la nota de credito anterior o igual a la actual";
            return false;
        }
        if (this.fechaAplicacion.before(fechaActual)) {
            this.msgError ="Falta indicar la fecha de aplicación de la nota de credito mayor o igula a la actual";
            return false;
        }
        if (this.montoNota.longValue() <= 0) {
            this.msgError ="Falta indicar la cantidad aplicable de la nota de credito";
            return false;
        }
        if (this.facturaPrimavera <= 0) {
            this.msgError ="Falta indicar la factura primavera a la nota de credito";
            return false;
        }
        return true;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public BigDecimal getMontoNota() {
        return montoNota;
    }

    public void setMontoNota(BigDecimal montoNota) {
        this.montoNota = montoNota;
    }

    public Integer getFacturaPrimavera() {
        return facturaPrimavera;
    }

    public void setFacturaPrimavera(Integer facturaPrimavera) {
        this.facturaPrimavera = facturaPrimavera;
    }

}
