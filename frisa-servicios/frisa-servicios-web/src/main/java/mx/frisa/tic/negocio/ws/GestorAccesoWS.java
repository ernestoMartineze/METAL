/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import mx.frisa.tic.datos.dto.ingresos.AgregarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarAccesoUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUsuarioDTO;
import mx.frisa.tic.datos.dto.ingresos.ConsultarUniNegocioDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.dto.ingresos.UnidadNegocioDTO;
import mx.frisa.tic.negocio.ingresos.GestorAccesoBean;

/**
 *
 * @author Soultech
 */
@WebService(serviceName = "GestorAccesoWS")
public class GestorAccesoWS {

    @EJB
    private GestorAccesoBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "agregarUsuario")
    public RespuestaDTO agregarUsuario(@WebParam(name = "usuarioAcceso") AgregarUsuarioDTO usuarioAcceso) {
        return ejbRef.agregarUsuario(usuarioAcceso);
    }

    @WebMethod(operationName = "actualizarAcceso")
    public RespuestaDTO actualizarAcceso(@WebParam(name = "idAcceso") String idAcceso) {
        return ejbRef.actualizarUsuario(idAcceso);
        //return "true";
    }
//    @WebMethod(operationName = "actualizarUsuario")
//    public RespuestaDTO actualizarUsuario(@WebParam(name = "acceso") AgregarUsuarioDTO acceso) {
//        return ejbRef.actualizarUsuario(acceso);
//    }
    
    @WebMethod(operationName = "consultarAccesos")
    public ConsultarAccesoUsuarioDTO consultarAccesos(@WebParam(name = "usuario") String usuario){
        return ejbRef.consultarAcceso(usuario);
    }
}
