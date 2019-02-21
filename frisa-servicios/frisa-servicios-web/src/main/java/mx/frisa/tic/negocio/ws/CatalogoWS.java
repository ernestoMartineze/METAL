/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mx.frisa.tic.datos.dto.ingresos.CuentaBancariaDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.TipoMonedaDTO;
import mx.frisa.tic.negocio.ingresos.CatalogosBeanLocal;

/**
 *
 * @author danie
 */
@WebService(serviceName = "CatalogoWS")
public class CatalogoWS {

    @EJB
    private CatalogosBeanLocal ejbRef;

    @WebMethod(operationName = "consultarPais")
    public String consultarPais(@WebParam(name = "id") int id, @WebParam(name = "clave") String clave) {
        return ejbRef.consultarPais(id, clave);
    }

    @WebMethod(operationName = "consultarTipoMoneda")
    public List<TipoMonedaDTO> consultarTipoMoneda() {
        return ejbRef.consultarTipoMoneda("CODIGOQUE QUIERA");
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarCuentaBancaria")
    public List<CuentaBancariaDTO> consultarCuentaBancaria(@WebParam(name = "numeroCuenta") String numeroCuenta) {

        return ejbRef.consultarCuentaBancaria(numeroCuenta);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarUsuarios")
    public RespuestaDTO actualizarUsuarios() {
        //TODO write your implementation code here:
        return ejbRef.actualizarUsuarios();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizarCuentasBancarias")
    public RespuestaDTO actualizarCuentasBancarias() {
        //TODO write your implementation code here:
        return ejbRef.actualizarCuentasBancarias();
    }

    @WebMethod(operationName = "actualizarCentroCosto")
    public RespuestaDTO actualizarCentroCosto() {
        //TODO write your implementation code here:
        return ejbRef.actualizarCentroCosto();
    }

}
