package mx.frisa.tic.datos.dto.ingresos;

/**
 *
 * @author soultech
 */
public class RespuestaDTO {
    String proceso;
    String idError;
    String descripcionError;

    public RespuestaDTO() {
    }

    public RespuestaDTO(String proceso, String idError, String descripcionError) {
        this.proceso = proceso;
        this.idError = idError;
        this.descripcionError = descripcionError;
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
