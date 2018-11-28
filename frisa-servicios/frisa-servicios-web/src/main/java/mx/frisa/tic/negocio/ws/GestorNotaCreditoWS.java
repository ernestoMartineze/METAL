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
import mx.frisa.tic.datos.dto.ingresos.NotaCreditoDTO;
import mx.frisa.tic.datos.dto.ingresos.Respuesta;
import mx.frisa.tic.negocio.ingresos.GestorNotaCreditoBeanLocal;

/**
 *
 * @author USER_1
 */
@WebService(serviceName = "GestorNotaCreditoWS")
public class GestorNotaCreditoWS {

    @EJB(beanName = "GestorNotaCreditoBean")
    private GestorNotaCreditoBeanLocal notaCreditoEjbRef;

    @WebMethod(operationName = "cargarNota")
    public Respuesta cargarNota(@WebParam(name = "notaCredito") NotaCreditoDTO notaCredito) {
        return notaCreditoEjbRef.cargarNota(notaCredito);
    }
    
}
