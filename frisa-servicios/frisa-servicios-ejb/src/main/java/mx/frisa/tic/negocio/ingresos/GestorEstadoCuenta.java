/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.net.URL;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.soap.SOAPMessage;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.enums.ProcesoEnum;
import mx.frisa.tic.negocio.seguridad.ApplicationConfig;
import mx.frisa.tic.negocio.seguridad.SSLClient;
import mx.frisa.tic.negocio.utils.interoperabilidad.SOAPClientSAAJ;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 *
 * @author USER_1
 */
@Stateless(name = "GestorEstadoCuenta")
@LocalBean
public class GestorEstadoCuenta implements GestorEstadoCuentaLocal {

    @Override
    public RespuestaDTO procesarEstadosCuenta(final String fechaInicio, final String fechaFinal, final String numeroCuenta) {
        RespuestaDTO respuesta = new RespuestaDTO();
        try {
            SOAPClientSAAJ clienteWS = new SOAPClientSAAJ();
            SOAPMessage mensaje;
            clienteWS.consultarOBI_runReport("MAEE760124");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("-------------------------------");

        System.out.println("-------------------------------");
        //Lanzar a procedimiento de base de datos los estados de cuenta a procesar

        //Regresar respuesta exitosa
        respuesta.setIdError("0");
        respuesta.setDescripcionError("");
        respuesta.setProceso(ProcesoEnum.EXITOSO.toString());

        return null;
    }

}
