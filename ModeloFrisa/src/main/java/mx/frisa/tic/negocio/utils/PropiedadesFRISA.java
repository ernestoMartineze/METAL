package mx.frisa.tic.negocio.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

/**
 *
 * @author soultech
 */
public class PropiedadesFRISA {

    public PropiedadesFRISA() {
    }

    private static Properties appBackEndProps = new Properties();
    private static Properties appFrontEndProps = new Properties();

    static {
        ManejadorLog manejadorLog = new ManejadorLog();
        try {

            manejadorLog.debug("Iniciando propiedades del sistema");
            init();

        } catch (MalformedURLException ex) {
            manejadorLog.error(ex, PropiedadesFRISA.class);
        }
    }

    private static void init() throws MalformedURLException {
        //Cargar en carpeta de recursos del servidor de aplicaciones el archivo de configuración del Aplicativo BackEnd
        ManejadorLog manejaLog = new ManejadorLog();
//        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//        String rootPath = PropiedadesFRISA.class.getResource("/").getPath();
//        String rootPath = PropiedadesFRISA.class.getCanonicalName();
        String rootPath = "/u01/frisa/";

        System.out.println("rootPath : " + rootPath);
//        System.err.println("rootPath / : " + PropiedadesFRISA.class.getResource("/").getPath());

        String serviciosConfigPath = rootPath + "configuracion/servicios.properties";
        String portalConfigPath = rootPath + "configuracion/portal.properties";

        try {
            System.out.println("Cargando propiedades : ");
            appBackEndProps.load(new FileInputStream(serviciosConfigPath));

//            appFrontEndProps.load(new FileInputStream(portalConfigPath));
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            manejaLog.error(ex, PropiedadesFRISA.class);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            manejaLog.error(ex, PropiedadesFRISA.class);
        } catch (IOException ex) {
            ex.printStackTrace();
            manejaLog.error(ex, PropiedadesFRISA.class);
        }
    }

    public static String recuperaPropiedadBackend(String pNombrePropiedad) {
        String valorPropiedad = appBackEndProps.getProperty(pNombrePropiedad);
        return valorPropiedad;
    }

    public static String recuperaPropiedadFrontend(String pNombrePropiedad) {
        String valorPropiedad = appFrontEndProps.getProperty(pNombrePropiedad);
        return valorPropiedad;
    }

    public static void main(String[] args) {

        // checking the value of random UUID
        System.out.println("ValorProperties  : " + PropiedadesFRISA.recuperaPropiedadBackend("edoCuentaServiceContentType"));
        System.out.println("ValorProperties  : " + PropiedadesFRISA.recuperaPropiedadFrontend("lineaCapturaServiceEndPoint"));
        System.out.println("ValorProperties  : " + PropiedadesFRISA.recuperaPropiedadFrontend("lineaCapturaServiceEndPoi"));
    }
}
