/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.negocio.seguridad;

public class ShowTrueStore {

    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.keyStore", "keystore.jks");
        System.setProperty("javax.net.ssl.trustStrore", "cacerts.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");



        String trustStore = System.getProperty("javax.net.ssl.trustStore");
        if (trustStore == null) {
            System.out.println("javax.net.ssl.trustStore is not defined");
        } else {
            System.out.println("javax.net.ssl.trustStore = " + trustStore);
        }
    }
}