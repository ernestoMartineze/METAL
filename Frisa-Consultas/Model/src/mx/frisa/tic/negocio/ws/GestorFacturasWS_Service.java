
package mx.frisa.tic.negocio.ws;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0-b170214.1743
 * Generated source version: 2.2
 *
 */
@WebServiceClient(name = "GestorFacturasWS", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                  wsdlLocation =
                  "https://129.191.25.150:7002/frisa-servicios/GestorFacturasWS?WSDL#%7Bhttp%3A%2F%2Fws.negocio.tic.frisa.mx%2F%7DGestorFacturasWS")
public class GestorFacturasWS_Service extends Service {

    private final static URL GESTORFACTURASWS_WSDL_LOCATION;
    private final static WebServiceException GESTORFACTURASWS_EXCEPTION;
    private final static QName GESTORFACTURASWS_QNAME =
        new QName("http://ws.negocio.tic.frisa.mx/", "GestorFacturasWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url =
                new URL("https://129.191.25.150:7002/frisa-servicios/GestorFacturasWS?WSDL#%7Bhttp%3A%2F%2Fws.negocio.tic.frisa.mx%2F%7DGestorFacturasWS");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GESTORFACTURASWS_WSDL_LOCATION = url;
        GESTORFACTURASWS_EXCEPTION = e;
    }

    public GestorFacturasWS_Service() {
        super(__getWsdlLocation(), GESTORFACTURASWS_QNAME);
    }

    public GestorFacturasWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GESTORFACTURASWS_QNAME, features);
    }

    public GestorFacturasWS_Service(URL wsdlLocation) {
        super(wsdlLocation, GESTORFACTURASWS_QNAME);
    }

    public GestorFacturasWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GESTORFACTURASWS_QNAME, features);
    }

    public GestorFacturasWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GestorFacturasWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns GestorFacturasWS
     */
    @WebEndpoint(name = "GestorFacturasWSPort")
    public GestorFacturasWS getGestorFacturasWSPort() {
        return super.getPort(new QName("http://ws.negocio.tic.frisa.mx/", "GestorFacturasWSPort"),
                             GestorFacturasWS.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GestorFacturasWS
     */
    @WebEndpoint(name = "GestorFacturasWSPort")
    public GestorFacturasWS getGestorFacturasWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.negocio.tic.frisa.mx/", "GestorFacturasWSPort"),
                             GestorFacturasWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GESTORFACTURASWS_EXCEPTION != null) {
            throw GESTORFACTURASWS_EXCEPTION;
        }
        return GESTORFACTURASWS_WSDL_LOCATION;
    }

}
