package mx.frisa.tic.utils;

import java.util.UUID;

/**
 *
 * @author USER_1
 */
public class UUIDFrisa {

    public static String regresaUUID() {

// creating UUID      
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {

        // checking the value of random UUID
        System.out.println("Random UUID value: " + UUIDFrisa.regresaUUID());
    }
}
