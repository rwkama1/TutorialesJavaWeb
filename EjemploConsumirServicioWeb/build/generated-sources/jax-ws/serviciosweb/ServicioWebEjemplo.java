
package serviciosweb;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioWebEjemplo", targetNamespace = "http://serviciosWeb/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioWebEjemplo {


    /**
     * 
     * @param producto
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "datosProducto", targetNamespace = "http://serviciosWeb/", className = "serviciosweb.DatosProducto")
    @ResponseWrapper(localName = "datosProductoResponse", targetNamespace = "http://serviciosWeb/", className = "serviciosweb.DatosProductoResponse")
    @Action(input = "http://serviciosWeb/ServicioWebEjemplo/datosProductoRequest", output = "http://serviciosWeb/ServicioWebEjemplo/datosProductoResponse")
    public String datosProducto(
        @WebParam(name = "producto", targetNamespace = "")
        Producto producto);

    /**
     * 
     * @param precioSinIva
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "precioConIva", targetNamespace = "http://serviciosWeb/", className = "serviciosweb.PrecioConIva")
    @ResponseWrapper(localName = "precioConIvaResponse", targetNamespace = "http://serviciosWeb/", className = "serviciosweb.PrecioConIvaResponse")
    @Action(input = "http://serviciosWeb/ServicioWebEjemplo/precioConIvaRequest", output = "http://serviciosWeb/ServicioWebEjemplo/precioConIvaResponse")
    public double precioConIva(
        @WebParam(name = "precioSinIva", targetNamespace = "")
        double precioSinIva);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://serviciosWeb/", className = "serviciosweb.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://serviciosWeb/", className = "serviciosweb.HelloResponse")
    @Action(input = "http://serviciosWeb/ServicioWebEjemplo/helloRequest", output = "http://serviciosWeb/ServicioWebEjemplo/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
