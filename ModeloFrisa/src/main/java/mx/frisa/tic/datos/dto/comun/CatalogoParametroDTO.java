package mx.frisa.tic.datos.dto.comun;

import java.io.Serializable;

/**
 *
 * @author Soultech S. de R.L. de C.V.
 */
public class CatalogoParametroDTO implements Serializable {

    private static final long serialVersionUID = 190512204195025123L;
    private String descripcion;
    private String valor;
    private String tipo;
    private String claveParametro;
    private String parameterMode;

    public CatalogoParametroDTO() {
        //CatalogoParametroDTO sin propiedades necesarias
    }

    public CatalogoParametroDTO(String descripcion, String valor, String tipo, String parameterMode) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.tipo = tipo;
        this.parameterMode = parameterMode;
    }

    public CatalogoParametroDTO(String descripcion, String valor, String tipo) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getParameterMode() {
        return parameterMode;
    }

    public void setParameterMode(String parameterMode) {
        this.parameterMode = parameterMode;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClaveParametro() {
        return claveParametro;
    }

    public void setClaveParametro(String claveParametro) {
        this.claveParametro = claveParametro;
    }

}
