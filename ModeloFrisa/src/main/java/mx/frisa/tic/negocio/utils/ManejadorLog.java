
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.utils;

import org.apache.log4j.Logger;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author ernestomtz
 */
public class ManejadorLog {

    public ManejadorLog() {
    }

    private static Logger logger;

    static {
        try {
          logger = Logger.getLogger(ManejadorLog.class.getName());
          System.out.print(ManejadorLog.class.getName());
            init();

        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(ManejadorLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private static void init() throws MalformedURLException {       
        //Cargar en carpeta de recursos del servidor de aplicaciones el archivo de configuración del log
        String file = new File("/tmp/frisa/log4j.properties").toURI().toURL().toString();
        String file1 = new File(".").toURI().toURL().toString();
        System.out.println("file1 :" + file);
        URL url = null;

        try {
            url = new URL(file);

        } catch (MalformedURLException e) {
            System.err.println(e.toString());
            System.err.println(e.getLocalizedMessage());
            System.err.println(e.getMessage());
        }

        PropertyConfigurator.configure(url);
    }

    /**
     * Invoca el método debug del logger, comprobando antes que está activado.
     *
     * @param msg
     */
    public void debug(String msg) {

        if (logger.isDebugEnabled()) {
            logger.debug(neutralizeMessage(msg));
        }
    }

    public void debug(int msg) {

        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    public void error(Exception ex, Class t) {

        if (isErrorEnabled()) {
            Logger.getLogger(t.getName()).log(Level.ERROR, null, ex);
            logger.error(ex.toString());
        }
    }

    /**
     * Invoca el método info del logger, comprobando antes que está activado.
     *
     * @param msg
     */
    public static void info(String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    /**
     * Invoca el métodoo error del logger, comprobando antes que está activado.
     *
     * @param msg
     */
    public static void error(String msg) {
        if (isErrorEnabled()) {
            logger.error(msg);
        }
    }

    /**
     * Invoca el método warn del logger, comprobando antes que está activado.
     *
     * @param msg
     */
    public static void warn(String msg) {
        if (isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    /**
     * Invoca el método fatal del logger, comprobando antes que está activado.
     *
     * @param msg
     */
    public static void fatal(String msg) {
        if (isFatalEnabled()) {
            logger.fatal(msg);
        }
    }

    private static boolean isErrorEnabled() {
        return logger.isEnabledFor(Level.ERROR);
    }

    private static boolean isWarnEnabled() {
        return logger.isEnabledFor(Level.WARN);
    }

    private static boolean isFatalEnabled() {
        return logger.isEnabledFor(Level.FATAL);
    }

    private static boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public static String neutralizeMessage(String message) {
// ensure no CRLF injection into logs for forging records
        if (message == null) {
            return message;
        }
        String clean = message.replace("\n", "").replace("\r", "");
//        if (ESAPI.securityConfiguration().getLogEncodingRequired()) {
//            clean = ESAPI.encoder().encodeForHTML(clean);
//            if (!message.equals(clean)) {
//                clean += " (Encoded)";
//            }
//        }
        return clean;
    }

}
