/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.Local;
import mx.frisa.tic.datos.dto.ingresos.NotaCreditoListaDTO;
import mx.frisa.tic.negocio.remoto.RespuestaERP_Nota_Credito;


@Local
public interface GestorNotaCreditoBeanLocal {

    public RespuestaERP_Nota_Credito cargarNota(NotaCreditoListaDTO notaCredito);
    
}
