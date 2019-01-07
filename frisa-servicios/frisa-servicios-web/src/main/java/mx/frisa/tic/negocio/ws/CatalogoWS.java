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
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.negocio.ingresos.CatalogosBeanLocal;

/**
 *
 * @author danie
 */
@WebService(serviceName = "CatalogoWS")
public class CatalogoWS {

    @EJB
    private CatalogosBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "consultarPais")
    public String consultarPais(@WebParam(name = "id") int id, @WebParam(name = "clave") String clave) {
        return ejbRef.consultarPais(id, clave);
    }

    @WebMethod(operationName = "consultarTipoMoneda")
    public RespuestaDTO consultarTipoMoneda() {
        return ejbRef.consultarTipoMoneda();
    }
    
}
