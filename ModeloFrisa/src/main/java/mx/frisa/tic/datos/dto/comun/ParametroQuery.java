package mx.frisa.tic.datos.dto.comun;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Soultech S. de R.L. de C.V.
 */
public class ParametroQuery implements Serializable{
    private static final long serialVersionUID = 190512204300002L;
    private List<CatalogoParametroDTO> parametrosDTO;
    private String query;
    
    public ParametroQuery() {
        //ParametroQuery sin propiedades necesarias
    }   

    public List<CatalogoParametroDTO> getParametrosDTO() {
        return parametrosDTO;
    }

    public void setParametrosDTO(List<CatalogoParametroDTO> parametrosDTO) {
        this.parametrosDTO = parametrosDTO;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    
}
