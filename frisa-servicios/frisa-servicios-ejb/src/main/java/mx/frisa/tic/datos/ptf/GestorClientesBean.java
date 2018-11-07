/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.ptf;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.nucleo.ClienteDTO;
import mx.frisa.tic.datos.entidades.RgoTrxClient;

/**
 *
 * @author soultech
 */
@Stateless(name = "GestorClientesBean")
@LocalBean
public class GestorClientesBean implements GestorClientesBeanLocal {

    @Override
    public List<ClienteDTO> consultarClientes(ClienteDTO cliente) {
        DAO<RgoTrxClient> clienteDAO = new DAO(RgoTrxClient.class);
        List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
        List<RgoTrxClient> clientes = clienteDAO.consultaQueryNamed("RgoTrxClient.findAll");
        for (RgoTrxClient clienteRespuesta : clientes) {
            
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setClienteId(String.valueOf(clienteRespuesta.getClientId()));
                clienteDTO.setClienteArId(clienteRespuesta.getClienteArId());
                clienteDTO.setNombre(clienteRespuesta.getNameClient());
                clienteDTO.setNumeroPieza(clienteRespuesta.getParyNumber());
                clientesDTO.add(clienteDTO);
                
        }
        
        return clientesDTO;
    }

    
}
