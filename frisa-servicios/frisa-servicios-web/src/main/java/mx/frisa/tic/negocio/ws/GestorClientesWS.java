/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import mx.frisa.tic.datos.dto.nucleo.ClienteDTO;
import mx.frisa.tic.datos.ptf.GestorClientesBeanLocal;

/**
 *
 * @author soultech
 */
@WebService(serviceName = "GestorClientesWS")
public class GestorClientesWS {

    @EJB(beanName = "GestorClientesBean")
    private GestorClientesBeanLocal clienteEjbRef;

    @WebMethod(operationName = "consultarClientes")
    public List<ClienteDTO> consultarClientes(@WebParam(name = "cliente") ClienteDTO cliente) {
        return clienteEjbRef.consultarClientes(cliente);
    }
    
}
