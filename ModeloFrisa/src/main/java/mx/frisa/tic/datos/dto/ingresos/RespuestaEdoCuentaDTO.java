package mx.frisa.tic.datos.dto.ingresos;

import java.math.BigInteger;

/**
 *
 * @author soultech
 */
public class RespuestaEdoCuentaDTO {
    String proceso;
    String idError;
    String descripcionError;
    Integer idEdoCuenta;
    Integer idPago;
    Integer idLineaCaptura;
    BigInteger idMetodoPago;

    public RespuestaEdoCuentaDTO() {
    }
    
    

    public RespuestaEdoCuentaDTO(String proceso, String idError, String descripcionError) {
        this.proceso = proceso;
        this.idError = idError;
        this.descripcionError = descripcionError;
    }

    public BigInteger getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(BigInteger idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }
    
    

    public Integer getIdEdoCuenta() {
        return idEdoCuenta;
    }

    public void setIdEdoCuenta(Integer idEdoCuenta) {
        this.idEdoCuenta = idEdoCuenta;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdLineaCaptura() {
        return idLineaCaptura;
    }

    public void setIdLineaCaptura(Integer idLineaCaptura) {
        this.idLineaCaptura = idLineaCaptura;
    }
    
    

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }

    public void setDescripcionError(String descripcionError) {
        this.descripcionError = descripcionError;
    }
    
}
