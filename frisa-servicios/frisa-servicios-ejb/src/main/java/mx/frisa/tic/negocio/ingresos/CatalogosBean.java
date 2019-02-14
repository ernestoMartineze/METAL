/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.ingresos.CuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.TipoMonedaDTO;
import mx.frisa.tic.datos.entidades.XxfrcTipoMoneda;
import mx.frisa.tic.datos.entidades.XxfrtCuentabancaria;

/**
 *
 * @author soultech
 */
@Singleton
public class CatalogosBean implements CatalogosBeanLocal {

    /**
     *
     * @param id
     * @param clave
     * @return
     */
    @Override
    public String consultarPais(int id, String clave) {
        return null;
    }
    
    @Override
    public List<CuentaBancariaDTO> consultarCuentaBancaria(String numeroCuenta) {
        
        DAO<XxfrtCuentabancaria> cuentaBancaroDao = new DAO(XxfrtCuentabancaria.class);
        List<XxfrtCuentabancaria> cuentasBancariasEnt = new ArrayList<>();
        cuentasBancariasEnt = (List<XxfrtCuentabancaria>) cuentaBancaroDao.consultaQueryNamed("XxfrtCuentabancaria.findAll");
        List<CuentaBancariaDTO> cuentasBancariaDto = new ArrayList();
        for(XxfrtCuentabancaria cuentaBancaria : cuentasBancariasEnt){
            CuentaBancariaDTO cuentaBanDto = new CuentaBancariaDTO();
            cuentaBanDto.setNumeroCuenta(cuentaBancaria.getNumerocuenta());
            cuentaBanDto.setNombre(cuentaBancaria.getNombre());
            cuentaBanDto.setFecha(cuentaBancaria.getFecharegistro());
            cuentaBanDto.setEstatus(cuentaBancaria.getEstatus());
            cuentasBancariaDto.add(cuentaBanDto);
            
        }
        return cuentasBancariaDto;
    }
    @Override
    public RespuestaDTO consultarTipoMoneda(){
        RespuestaDTO respuesta = new RespuestaDTO();
        DAO<XxfrcTipoMoneda> catTipoMonedaDao = new DAO(XxfrcTipoMoneda.class);
        List<XxfrcTipoMoneda> listaTiposMoneda = new ArrayList<>();
        listaTiposMoneda = (List<XxfrcTipoMoneda>) catTipoMonedaDao.consultaQueryNamed("XxfrcTipoMoneda.findAll");
        List<TipoMonedaDTO> listaTipoMonedaDto = new ArrayList();
        for(XxfrcTipoMoneda tipoMonedaEntidad : listaTiposMoneda){
            TipoMonedaDTO tipoMonedaDto = new TipoMonedaDTO();
            tipoMonedaDto.setCodigo(tipoMonedaEntidad.getCodigo());
            tipoMonedaDto.setDescripcion(tipoMonedaEntidad.getDescripcion());
            tipoMonedaDto.setInd_activo(tipoMonedaEntidad.getIndActivo());
            listaTipoMonedaDto.add(tipoMonedaDto);
            
            System.err.println("Codigo : " + tipoMonedaEntidad.getCodigo());
        }
        respuesta.setProceso("EXITOSO");
        respuesta.setIdError("0");
        respuesta.setDescripcionError("");
        return respuesta;
    }

    //Metodo mio
    @Override
    public List<TipoMonedaDTO>  consultarTipoMoneda(String codigo){
        RespuestaDTO respuesta = new RespuestaDTO();
        DAO<XxfrcTipoMoneda> catTipoMonedaDao = new DAO(XxfrcTipoMoneda.class);
        List<XxfrcTipoMoneda> listaTiposMoneda = new ArrayList<>();
        listaTiposMoneda = (List<XxfrcTipoMoneda>) catTipoMonedaDao.consultaQueryNamed("XxfrcTipoMoneda.findAll");
        List<TipoMonedaDTO> listaTipoMonedaDto = new ArrayList();
        for(XxfrcTipoMoneda tipoMonedaEntidad : listaTiposMoneda){
            TipoMonedaDTO tipoMonedaDto = new TipoMonedaDTO();
            tipoMonedaDto.setCodigo(tipoMonedaEntidad.getCodigo());
            tipoMonedaDto.setDescripcion(tipoMonedaEntidad.getDescripcion());
            tipoMonedaDto.setInd_activo(tipoMonedaEntidad.getIndActivo());
            listaTipoMonedaDto.add(tipoMonedaDto);
            
            System.err.println("Codigo : " + tipoMonedaEntidad.getCodigo());
        }
        respuesta.setProceso("EXITOSO");
        respuesta.setIdError("0");
        respuesta.setDescripcionError("");
        return listaTipoMonedaDto;
    }
    
 
    
}

/*
 
public List<TipoMonedaDTO>  consultarTipoMoneda(){
        RespuestaDTO respuesta = new RespuestaDTO();
        DAO<XxfrcTipoMoneda> catTipoMonedaDao = new DAO(XxfrcTipoMoneda.class);
        List<XxfrcTipoMoneda> listaTiposMoneda = new ArrayList<>();
        listaTiposMoneda = (List<XxfrcTipoMoneda>) catTipoMonedaDao.consultaQueryNamed("XxfrcTipoMoneda.findAll");
        List<TipoMonedaDTO> listaTipoMonedaDto = new ArrayList();
        for(XxfrcTipoMoneda tipoMonedaEntidad : listaTiposMoneda){
            TipoMonedaDTO tipoMonedaDto = new TipoMonedaDTO();
            tipoMonedaDto.setCodigo(tipoMonedaEntidad.getCodigo());
            tipoMonedaDto.setDescripcion(tipoMonedaEntidad.getDescripcion());
            tipoMonedaDto.setInd_activo(tipoMonedaEntidad.getIndActivo());
            listaTipoMonedaDto.add(tipoMonedaDto);
            
            System.err.println("Codigo : " + tipoMonedaEntidad.getCodigo());
        }
        respuesta.setProceso("EXITOSO");
        respuesta.setIdError("0");
        respuesta.setDescripcionError("");
        return listaTipoMonedaDto;
    }
    
 
 
 

*/







