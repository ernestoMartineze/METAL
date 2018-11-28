/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;

/**
 *
 * @author Soultech
 */
@Stateless(name = "GestorPagosBean")
@LocalBean
public class GestorPagosBean implements GestorPagos{
    
    @Override
    public RespuestaDTO generarPago(PagoDTO pago) {
        RespuestaDTO respuesta = new RespuestaDTO();
        /*SECUENCIA DEL PROCESO 
        1. Consulta de estado de cuenta (ERP)
        2. Validar existencia de LC o Ref (BD)
        3. Validar factura al cobro o normal
        4. Crear factura al cobro (ERP)
        5. Registrar cabecera de pago en ERP
        6. Aplicar facturas en ERP
        */
        
        respuesta.setProceso("GestorPagosBean-generarPago");
        respuesta.setIdError("000");
        respuesta.setDescripcionError("OK");
        return respuesta;
    }
}
