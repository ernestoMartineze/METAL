/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.ConsultarCentroCostosDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUniNegocioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.CuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.TipoMonedaDTO;

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

    List<TipoMonedaDTO> consultarTipoMoneda(String codigo);

    List<CuentaBancariaDTO> consultarCuentaBancaria(String numeroCuenta);
    
    List<ConsultarUsuarioDTO> consultarUsuario(String usuario);
    
    List<ConsultarUniNegocioDTO> consultarUnidadNegocio(String unidadNegocio);
    
    List<ConsultarCentroCostosDTO> consultarCentroCostos(String centroCostos);

    RespuestaDTO actualizarCuentasBancarias();

    RespuestaDTO actualizarUsuarios();

    RespuestaDTO actualizarCentroCosto();

    public RespuestaDTO actualizarUnidadNegocio();
}
