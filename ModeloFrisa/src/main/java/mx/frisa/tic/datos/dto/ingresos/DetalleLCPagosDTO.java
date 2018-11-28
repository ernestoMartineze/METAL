/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author Ernesto
 */
public class DetalleLCPagosDTO {
    
    
    private BigInteger idpago;
    private BigInteger idfacturaerp;
    private Long idlineacaptura;
    private Long norecibo;
    private Date fecharecibo;
    private Date fechaaplicacion;
    private Date fechatransaccion;
    private BigDecimal montopagado;

    public BigInteger getIdpago() {
        return idpago;
    }

    public void setIdpago(BigInteger idpago) {
        this.idpago = idpago;
    }

    public BigInteger getIdfacturaerp() {
        return idfacturaerp;
    }

    public void setIdfacturaerp(BigInteger idfacturaerp) {
        this.idfacturaerp = idfacturaerp;
    }

    public Long getIdlineacaptura() {
        return idlineacaptura;
    }

    public void setIdlineacaptura(Long idlineacaptura) {
        this.idlineacaptura = idlineacaptura;
    }

    public Long getNorecibo() {
        return norecibo;
    }

    public void setNorecibo(Long norecibo) {
        this.norecibo = norecibo;
    }

    public Date getFecharecibo() {
        return fecharecibo;
    }

    public void setFecharecibo(Date fecharecibo) {
        this.fecharecibo = fecharecibo;
    }

    public Date getFechaaplicacion() {
        return fechaaplicacion;
    }

    public void setFechaaplicacion(Date fechaaplicacion) {
        this.fechaaplicacion = fechaaplicacion;
    }

    public Date getFechatransaccion() {
        return fechatransaccion;
    }

    public void setFechatransaccion(Date fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }

    public BigDecimal getMontopagado() {
        return montopagado;
    }

    public void setMontopagado(BigDecimal montopagado) {
        this.montopagado = montopagado;
    }
    
    
}
