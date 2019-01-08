/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.negocio.cargafacturacliente.frisa.cliente.cargafactura;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author USER_1
 */
public class CargadorFactura {

    public static String encodeFileToBase64Binary(String fileName)
            throws IOException {

        File file = new File(fileName);
        byte[] bytes = loadFile(file);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        String encodedString = new String(encoded, StandardCharsets.US_ASCII);

        return encodedString;
    }
    public static byte[] decodeBase64ToFileBinary(String datos)
            throws IOException {

        
        byte[] decoded = Base64.getDecoder().decode(datos);

        return decoded;
    }

    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        byte[] bytes = new byte[(int) length];

        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }
    
    public static void main(String args[]) throws IOException{
        
        String salida = CargadorFactura.encodeFileToBase64Binary("C:\\tmp\\frisa\\cargaFacturaCli\\FacturaCabeceraLinea_2.zip");
        System.err.println("Resultado : "+ salida);
    }

}
