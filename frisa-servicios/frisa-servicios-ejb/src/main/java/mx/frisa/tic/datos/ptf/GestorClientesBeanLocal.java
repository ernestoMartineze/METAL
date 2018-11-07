/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.datos.ptf;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.nucleo.ClienteDTO;

/**
 *
 * @author soultech
 */
@Local
public interface GestorClientesBeanLocal {

    public List<ClienteDTO> consultarClientes(ClienteDTO cliente);
    
}
