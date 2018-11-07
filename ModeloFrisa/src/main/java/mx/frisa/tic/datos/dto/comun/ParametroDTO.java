package mx.frisa.tic.datos.dto.comun;

import java.io.Serializable;

/**
 *
 * @author José
 */
public class ParametroDTO implements Serializable{
    private static final long serialVersionUID = 190512204300001L;
    private String clave;
    private String valor;

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
