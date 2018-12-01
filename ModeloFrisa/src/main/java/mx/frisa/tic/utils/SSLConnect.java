/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.frisa.tic.utils;

import java.io.IOException;
import static java.lang.System.out;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.xml.soap.SOAPException;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author soultech
 */


public class SSLConnect {

    public static void main(String[] args) throws KeyManagementException,
            UnrecoverableKeyException, NoSuchAlgorithmException,
            CertificateException, KeyStoreException, IOException, SOAPException {

        //code
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("USER", "PASS");
        provider.setCredentials(AuthScope.ANY, credentials);
        HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();

        HttpResponse response = client.execute(new HttpPost("https://efar-test.fin.us2.oraclecloud.com:443/xmlpserver/services/ExternalReportWSSService"));//Replace HttpPost with HttpGet if you need to perform a GET to login
        int statusCode = response.getStatusLine().getStatusCode();
        out.println("Response Code :" + statusCode);

    }
}
