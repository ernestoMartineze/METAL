package mx.frisa.tic.utils;

import java.util.UUID;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author USER_1
 */
public class UUIDFrisa {

    public static String regresaUUID() {

// creating UUID      
        return UUID.randomUUID().toString();
    }

    public String getCadenaDesdeB64(String cadB64) {
        String str = new String(DatatypeConverter.parseBase64Binary(cadB64));
        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {

        // checking the value of random UUID
        System.out.println("Random UUID value: " + UUIDFrisa.regresaUUID());
    }
}
