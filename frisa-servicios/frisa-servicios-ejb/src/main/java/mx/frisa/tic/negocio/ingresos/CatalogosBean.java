/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Singleton;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.entidades.XxfrcUnidadnegocio;
import mx.frisa.tic.datos.dto.CONSTANTE;
import mx.frisa.tic.datos.dto.comun.CatalogoParametroDTO;
import mx.frisa.tic.datos.dto.ingresos.CuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaCuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaUnidadNegocioDTO;
import mx.frisa.tic.datos.dto.ingresos.TipoMonedaDTO;
import mx.frisa.tic.datos.entidades.XxfrcCargaCtabancaria;
import mx.frisa.tic.datos.entidades.XxfrcTipoMoneda;
import mx.frisa.tic.datos.entidades.XxfrtCargaBu;
import mx.frisa.tic.datos.entidades.XxfrtCuentabancaria;
import mx.frisa.tic.negocio.remoto.AdaptadorWS;
import mx.frisa.tic.negocio.remoto.CuentaBancaria;
import mx.frisa.tic.negocio.remoto.UnidadNegocio;
import mx.frisa.tic.negocio.utils.ManejadorLog;
import mx.frisa.tic.utils.UUIDFrisa;

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
            DAO<XxfrcCargaCtabancaria> cargaCtaBancariaDao = new DAO(XxfrcCargaCtabancaria.class);
            XxfrcCargaCtabancaria cargaCtaBancariaEnt = new XxfrcCargaCtabancaria();
            List<XxfrtCuentabancaria> xxfrtCuentabancariaList = new ArrayList();
            List<XxfrcCargaCtabancaria> xxfrcCargaCtabancaria = new ArrayList();

            //Asignar datos de la transacción
            cargaCtaBancariaEnt.setEstatus(BigInteger.ONE);
            cargaCtaBancariaEnt.setId(null);
            cargaCtaBancariaEnt.setFecha(new Date());
            cargaCtaBancariaEnt.setUudi(UUIDFrisa.regresaUUID());

            cargaCtaBancariaDao.create(cargaCtaBancariaEnt);
            if (cargaCtaBancariaDao.getProceso().getTermino().equals("0")) {
                xxfrcCargaCtabancaria = (List<XxfrcCargaCtabancaria>) cargaCtaBancariaDao.consultaQueryNativo("Select t from XxfrcCargaCtabancaria t where t.uudi = '" + cargaCtaBancariaEnt.getUudi() + "' order by t.id desc");

                for (CuentaBancaria cuentaBancaria : respuestaWS.getCuentaBancaria().getCuentaBancaria()) {
                    XxfrtCuentabancaria cuantaEntidad = new XxfrtCuentabancaria();
                    cuantaEntidad.setId(xxfrcCargaCtabancaria.get(0));
                    cuantaEntidad.setEstatus(1);
                    cuantaEntidad.setNumerocuenta(cuentaBancaria.getNUMERO());
                    cuantaEntidad.setNombre(cuentaBancaria.getNOMBRE());
                    cuantaEntidad.setFecharegistro(new Date());
                    cuantaEntidad.setMoneda(cuentaBancaria.getMONEDA());
                    xxfrtCuentabancariaList.add(cuantaEntidad);
                }
                cargaCtaBancariaEnt.setXxfrtCuentabancariaList(xxfrtCuentabancariaList);

                cargaCtaBancariaDao.actualiza(cargaCtaBancariaEnt);

                respuesta.setIdError("0");
                respuesta.setDescripcionError("");
                respuesta.setProceso("EXITOSO");
            } else {
                respuesta.setIdError("1301");
                respuesta.setDescripcionError("Existe un error al registrar la carga BI a Intermedio");
                respuesta.setProceso("ERROR");

            }

            respuesta.setUuid(cargaCtaBancariaEnt.getUudi());

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
        respuesta.setUuid(UUIDFrisa.regresaUUID());
        try {

            AdaptadorWS clienteWS = new AdaptadorWS();
            RespuestaUnidadNegocioDTO respuestaWS = clienteWS.getERP_obtenerUnidadesNegocio();

            DAO<XxfrtCargaBu> xxfrtCargaBuDao = new DAO(XxfrtCargaBu.class);
            XxfrtCargaBu xxfrtCargaBuEnt = new XxfrtCargaBu();
            List<XxfrtCargaBu> xxfrtCargaBuEntList = new ArrayList();
            List<XxfrcUnidadnegocio> xxfrcUnidadnegocioList = new ArrayList();
//
//            
//            //Asignar datos de la transacción
            xxfrtCargaBuEnt.setCsEstatus(BigInteger.ONE);
            xxfrtCargaBuEnt.setIdCarga(null);
            xxfrtCargaBuEnt.setFechaRegistro(new Date());
            xxfrtCargaBuEnt.setUuid(UUIDFrisa.regresaUUID());
//            
            xxfrtCargaBuDao.create(xxfrtCargaBuEnt);
            
            if (xxfrtCargaBuDao.getProceso().getTermino().equals("0")) {
                xxfrtCargaBuEntList = (List<XxfrtCargaBu>) xxfrtCargaBuDao.consultaQueryNativo("Select t from XxfrtCargaBu t where t.uuid = '" + xxfrtCargaBuEnt.getUuid()+ "' order by t.idCarga desc");

                for (UnidadNegocio unidadNegocio : respuestaWS.getUnidadesNegocio().getUnidadNegocio()) {
                    XxfrcUnidadnegocio unidadnegocioEnt = new XxfrcUnidadnegocio();
                    unidadnegocioEnt.setIdCarga(xxfrtCargaBuEntList.get(0));
                    unidadnegocioEnt.setNombre(unidadNegocio.getBU_NAME());
                    unidadnegocioEnt.setCveBu(unidadNegocio.getBU_ID());
                    xxfrcUnidadnegocioList.add(unidadnegocioEnt);
                }
                xxfrtCargaBuEnt.setXxfrcUnidadnegocioList(xxfrcUnidadnegocioList);

                xxfrtCargaBuDao.actualiza(xxfrtCargaBuEnt);

                respuesta.setIdError("0");
                respuesta.setDescripcionError("");
                respuesta.setProceso("EXITOSO");
            } else {
                respuesta.setIdError("1401");
                respuesta.setDescripcionError("Existe un error al registrar la carga BI BU a Intermedio");
                respuesta.setProceso("ERROR");

            }

            

            respuesta.setIdError("0");
            respuesta.setDescripcionError("");
            respuesta.setProceso("EXITOSO");

        } catch (Exception e) {
            e.printStackTrace();
            respuesta.setProceso("ERROR");
            respuesta.setIdError("1400");
            respuesta.setDescripcionError("No se ha logrado actualizar usuarios");
        }

        log.debug("Termino actualizarUsuarios");

        return respuesta;
    }

}
