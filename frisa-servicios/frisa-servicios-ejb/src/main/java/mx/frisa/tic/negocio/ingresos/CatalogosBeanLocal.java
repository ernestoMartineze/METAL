/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;

/**
 *
 * @author soultech
 */
@Local
public interface CatalogosBeanLocal {

    /**
     *
     * @param id
     * @param clave
     * @return
     */
    String consultarPais(int id, String clave);
    RespuestaDTO consultarTipoMoneda();
    
    
}
