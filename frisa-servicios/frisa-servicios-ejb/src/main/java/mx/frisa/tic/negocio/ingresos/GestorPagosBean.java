/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.comun.DAO;
import mx.frisa.tic.datos.dto.ingresos.PagoDTO;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.entidades.XxfrvFactparapagos;
import mx.frisa.tic.negocio.utils.ManejadorLog;

/**
 *
 * @author Soultech
 */
@Stateless(name = "GestorPagosBean")
@LocalBean
public class GestorPagosBean implements GestorPagos{
    
    @Override
    public RespuestaDTO generarPago(List<PagoDTO> pagos) {
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
    
    private List<PagoDTO> recuperaFacturas(List<PagoDTO> pagos){
        ManejadorLog log = new ManejadorLog();
        DAO<XxfrvFactparapagos> consultaDAO = new DAO(XxfrvFactparapagos.class);
        List<XxfrvFactparapagos> facturasDTO = null;
        List<XxfrvFactparapagos> facturasAlCobro = null;
        List<PagoDTO> response = null;
        StringBuilder query = new StringBuilder();
        StringBuilder paramLc = new StringBuilder();
        
        for(PagoDTO pago : pagos){
            paramLc.append("'"+pago.getLineaCaptura()+"',");
        }
        paramLc.append("'000'");
        query.append("SELECT x ")
                .append(" FROM XxfrvFactparapagos x ")
                .append("WHERE x.lineacaptura = '")
                .append(paramLc.toString())
                .append("'");
        try{
            facturasDTO = consultaDAO.consultaQueryNativo(query.toString());
        }
        catch(Exception ex){
            log.debug("Error al ejecutar el query: " + query.toString());
            log.error(ex, GestorPagosBean.class);
        }
        
        return null;
    }
}
