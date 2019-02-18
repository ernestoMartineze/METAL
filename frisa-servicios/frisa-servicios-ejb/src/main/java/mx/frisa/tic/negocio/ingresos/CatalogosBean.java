/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Singleton;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.CuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.TipoMonedaDTO;
import mx.frisa.tic.datos.entidades.XxfrcTipoMoneda;
import mx.frisa.tic.datos.entidades.XxfrtCuentabancaria;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.remoto.CuentaBancaria;
import mx.frisa.tic.negocio.utils.ManejadorLog;

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

        List<CatalogoParametroDTO> parametros = new ArrayList();
        parametros.add(new CatalogoParametroDTO("numerocuenta", "%" + numeroCuenta + "%", CONSTANTE.CADENA));

        List<XxfrtCuentabancaria> cuentasBancariasEnt = (List<XxfrtCuentabancaria>) cuentaBancaroDao.consultaQueryByParameters("XxfrtCuentabancaria.findByLikeNumerocuenta", parametros);
        List<CuentaBancariaDTO> cuentasBancariaDto = new ArrayList();
        for (XxfrtCuentabancaria cuentaBancaria : cuentasBancariasEnt) {
            CuentaBancariaDTO cuentaBanDto = new CuentaBancariaDTO();
            cuentaBanDto.setNumeroCuenta(cuentaBancaria.getNumerocuenta());
            cuentaBanDto.setNombre(cuentaBancaria.getNombre());
            cuentaBanDto.setFecha(cuentaBancaria.getFecharegistro());
            cuentaBanDto.setEstatus(cuentaBancaria.getEstatus());
            cuentaBanDto.setMoneda(cuentaBancaria.getMoneda());
            cuentasBancariaDto.add(cuentaBanDto);

        }
        return cuentasBancariaDto;
    }

    @Override
    public RespuestaDTO consultarTipoMoneda() {
        RespuestaDTO respuesta = new RespuestaDTO();
        DAO<XxfrcTipoMoneda> catTipoMonedaDao = new DAO(XxfrcTipoMoneda.class);
        List<XxfrcTipoMoneda> listaTiposMoneda = new ArrayList<>();
        listaTiposMoneda = (List<XxfrcTipoMoneda>) catTipoMonedaDao.consultaQueryNamed("XxfrcTipoMoneda.findAll");
        List<TipoMonedaDTO> listaTipoMonedaDto = new ArrayList();
        for (XxfrcTipoMoneda tipoMonedaEntidad : listaTiposMoneda) {
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
    public List<TipoMonedaDTO> consultarTipoMoneda(String codigo) {
        RespuestaDTO respuesta = new RespuestaDTO();
        DAO<XxfrcTipoMoneda> catTipoMonedaDao = new DAO(XxfrcTipoMoneda.class);
        List<XxfrcTipoMoneda> listaTiposMoneda = new ArrayList<>();
        listaTiposMoneda = (List<XxfrcTipoMoneda>) catTipoMonedaDao.consultaQueryNamed("XxfrcTipoMoneda.findAll");
        List<TipoMonedaDTO> listaTipoMonedaDto = new ArrayList();
        for (XxfrcTipoMoneda tipoMonedaEntidad : listaTiposMoneda) {
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

    @Override
    public RespuestaDTO actualizarCuentasBancarias() {
        ManejadorLog log = new ManejadorLog();
        log.debug("Inicio actualizarCuentasBancarias");

        RespuestaDTO respuesta = new RespuestaDTO();
        try {

            AdaptadorWS clienteWS = new AdaptadorWS();
            RespuestaCuentaBancariaDTO respuestaWS = clienteWS.getERP_obtenerCuentaBancaria();
            DAO<XxfrtCuentabancaria> cuentaBancariaDao = new DAO(XxfrtCuentabancaria.class);
            Integer contador = 0;
            for (CuentaBancaria cuentaBancaria : respuestaWS.getCuentaBancaria().getCuentaBancaria()) {
                if (contador < 190) {
                    break;
                }
                XxfrtCuentabancaria cuantaEntidad = new XxfrtCuentabancaria();
                cuantaEntidad.setEstatus(1);
                cuantaEntidad.setNumerocuenta(cuentaBancaria.getNUMERO());
                cuantaEntidad.setNombre(cuentaBancaria.getNOMBRE());
                cuantaEntidad.setFecharegistro(new Date());
                cuantaEntidad.setMoneda(cuentaBancaria.getMONEDA());
                cuentaBancariaDao.actualiza(cuantaEntidad);
            }

            respuesta.setIdError("0");
            respuesta.setDescripcionError("");
            respuesta.setProceso("EXITOSO");

        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setProceso("ERROR");
            respuesta.setIdError("1300");
            respuesta.setDescripcionError("No se ha logrado actualizar cuentas bancarias");
        }

        log.debug("Termino actualizarCuentasBancarias");

        return respuesta;
    }

    @Override
    public RespuestaDTO actualizarUsuarios() {
        ManejadorLog log = new ManejadorLog();
        log.debug("Inicio aplicarPagoManual");

        RespuestaDTO respuesta = new RespuestaDTO();
        try {

            respuesta.setIdError("0");
            respuesta.setDescripcionError("");
            respuesta.setProceso("EXITOSO");

        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setProceso("ERROR");
            respuesta.setIdError("1300");
            respuesta.setDescripcionError("No se ha logrado actualizar usuarios");
        }

        log.debug("Termino actualizarUsuarios");

        return respuesta;
    }

}
