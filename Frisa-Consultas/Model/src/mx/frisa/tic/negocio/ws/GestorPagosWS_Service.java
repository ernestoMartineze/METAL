
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
@WebServiceClient(name = "GestorPagosWS", targetNamespace = "http://ws.negocio.tic.frisa.mx/",
                  wsdlLocation =
                  "http://192.168.56.1:7001/frisa-servicios/GestorPagosWS?WSDL#%7Bhttp%3A%2F%2Fws.negocio.tic.frisa.mx%2F%7DGestorPagosWS")
public class GestorPagosWS_Service extends Service {

    private final static URL GESTORPAGOSWS_WSDL_LOCATION;
    private final static WebServiceException GESTORPAGOSWS_EXCEPTION;
    private final static QName GESTORPAGOSWS_QNAME = new QName("http://ws.negocio.tic.frisa.mx/", "GestorPagosWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url =
                new URL("http://192.168.56.1:7001/frisa-servicios/GestorPagosWS?WSDL#%7Bhttp%3A%2F%2Fws.negocio.tic.frisa.mx%2F%7DGestorPagosWS");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        GESTORPAGOSWS_WSDL_LOCATION = url;
        GESTORPAGOSWS_EXCEPTION = e;
    }

    public GestorPagosWS_Service() {
        super(__getWsdlLocation(), GESTORPAGOSWS_QNAME);
    }

    public GestorPagosWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GESTORPAGOSWS_QNAME, features);
    }

    public GestorPagosWS_Service(URL wsdlLocation) {
        super(wsdlLocation, GESTORPAGOSWS_QNAME);
    }

    public GestorPagosWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GESTORPAGOSWS_QNAME, features);
    }

    public GestorPagosWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GestorPagosWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns GestorPagosWS
     */
    @WebEndpoint(name = "GestorPagosWSPort")
    public GestorPagosWS getGestorPagosWSPort() {
        return super.getPort(new QName("http://ws.negocio.tic.frisa.mx/", "GestorPagosWSPort"), GestorPagosWS.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GestorPagosWS
     */
    @WebEndpoint(name = "GestorPagosWSPort")
    public GestorPagosWS getGestorPagosWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.negocio.tic.frisa.mx/", "GestorPagosWSPort"), GestorPagosWS.class,
                             features);
    }

    private static URL __getWsdlLocation() {
        if (GESTORPAGOSWS_EXCEPTION != null) {
            throw GESTORPAGOSWS_EXCEPTION;
        }
        return GESTORPAGOSWS_WSDL_LOCATION;
    }

}
