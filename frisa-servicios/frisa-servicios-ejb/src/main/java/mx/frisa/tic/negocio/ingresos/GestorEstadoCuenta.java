/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.ingresos;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import mx.frisa.tic.datos.dto.ingresos.RespuestaDTO;
import mx.frisa.tic.datos.enums.ProcesoEnum;
import mx.frisa.tic.negocio.obiee.AccessDeniedException_Exception;
import mx.frisa.tic.negocio.seguridad.ApplicationConfig;
import mx.frisa.tic.negocio.seguridad.SSLClient;

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

            Configuration config = null;
//Load (String)configuration
            try {
                String currentPath = this.getClass().getCanonicalName();
                currentPath = "C:\\Users\\USER_1\\Documents\\GitHub\\Frisa\\frisa-servicios\\frisa-servicios-ejb\\src\\main\\resources\\META-INF\\";
                System.out.println(currentPath);
                config = new PropertiesConfiguration(currentPath + "frisa.properties");
            } catch (Exception e) {
                System.out.println("Exception in reading properties file : system.properties");
                e.printStackTrace();
                System.exit(-1);
            }
            ApplicationConfig ac = ApplicationConfig.getInstance();
            ac.setKEYSTOREPATH((String) config.getProperty("KEYSTOREPATH"));
            ac.setTRUSTSTOREPATH((String) config.getProperty("TRUSTSTOREPATH"));
            ac.setKEYSTOREPW((String) config.getProperty("KEYSTOREPW"));
            ac.setTRUSTSTOREPW((String) config.getProperty("TRUSTSTOREPW"));
            ac.setKEYPASS((String) config.getProperty("KEYPASS"));
            ac.setKeystoreType((String) config.getProperty("keystoreType"));
            ac.setTrustAllCertificate((String) config.getProperty("trustAllCertificate"));
            ac.setKeymanageralgorithm((String) config.getProperty("keymanageralgorithm"));
            try {
//A SOAP web service call
                SSLClient sslClient = SSLClient.getSSLClient();
                String strurl = "https://efar-test.fin.us2.oraclecloud.com:443/xmlpserver/services/ExternalReportWSSService";//you can add all the urls in config file
                URL url = new URL(strurl);
                String method = "POST";
                String message = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:pub=\"http://xmlns.oracle.com/oxp/service/PublicReportService\">\n" +
"   <soap:Header/>\n" +
"   <soap:Body>\n" +
"      <pub:runReport>\n" +
"         <pub:reportRequest>\n" +
"            <pub:parameterNameValues>\n" +
"               <pub:item>\n" +
"                  <pub:name>BANK_ACCOUNT_NUMBER</pub:name>\n" +
"                  <multiValuesAllowed>false</multiValuesAllowed>\n" +
"                  <pub:values>\n" +
"                     <pub:item>0521838999</pub:item>\n" +
"                  </pub:values>\n" +
"               </pub:item>\n" +
"               <pub:item>\n" +
"                  <pub:name>FROM_DATE</pub:name>\n" +
"                  <multiValuesAllowed>TRUE</multiValuesAllowed>\n" +
"                  <pub:values>\n" +
"                     <pub:item>11-05-2018</pub:item>\n" +
"                  </pub:values>\n" +
"               </pub:item>\n" +
"               <pub:item>\n" +
"                  <pub:name>TO_DATE</pub:name>\n" +
"                  <multiValuesAllowed>TRUE</multiValuesAllowed>\n" +
"                  <pub:values>\n" +
"                     <pub:item>11-05-2018</pub:item>\n" +
"                  </pub:values>\n" +
"               </pub:item>\n" +
"\n" +
"            </pub:parameterNameValues>\n" +
"            <pub:attributeFormat>xml</pub:attributeFormat>\n" +
"            <pub:attributeLocale/>\n" +
"            <pub:attributeTemplate/>\n" +
"            <pub:attributeTimezone/>\n" +
"            <pub:attributeUILocale/>\n" +
"            <pub:reportAbsolutePath>/Custom/Financials/Cash Management/Reports/XXFRISA_CE_ESTADO_CUENTA.xdo</pub:reportAbsolutePath>\n" +
"            <pub:sizeOfDataChunkDownload>-1</pub:sizeOfDataChunkDownload>\n" +
"         </pub:reportRequest>\n" +
"      </pub:runReport>\n" +
"   </soap:Body>\n" +
"</soap:Envelope>";
                String msgtype = "text/xml";
                String response = sslClient.sendRequest(url, method, message, msgtype);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
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
