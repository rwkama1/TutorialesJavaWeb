
package serviciosweb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the serviciosweb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PrecioConIvaResponse_QNAME = new QName("http://serviciosWeb/", "precioConIvaResponse");
    private final static QName _DatosProductoResponse_QNAME = new QName("http://serviciosWeb/", "datosProductoResponse");
    private final static QName _Hello_QNAME = new QName("http://serviciosWeb/", "hello");
    private final static QName _PrecioConIva_QNAME = new QName("http://serviciosWeb/", "precioConIva");
    private final static QName _HelloResponse_QNAME = new QName("http://serviciosWeb/", "helloResponse");
    private final static QName _DatosProducto_QNAME = new QName("http://serviciosWeb/", "datosProducto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: serviciosweb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatosProducto }
     * 
     */
    public DatosProducto createDatosProducto() {
        return new DatosProducto();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link PrecioConIva }
     * 
     */
    public PrecioConIva createPrecioConIva() {
        return new PrecioConIva();
    }

    /**
     * Create an instance of {@link DatosProductoResponse }
     * 
     */
    public DatosProductoResponse createDatosProductoResponse() {
        return new DatosProductoResponse();
    }

    /**
     * Create an instance of {@link PrecioConIvaResponse }
     * 
     */
    public PrecioConIvaResponse createPrecioConIvaResponse() {
        return new PrecioConIvaResponse();
    }

    /**
     * Create an instance of {@link Producto }
     * 
     */
    public Producto createProducto() {
        return new Producto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrecioConIvaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "precioConIvaResponse")
    public JAXBElement<PrecioConIvaResponse> createPrecioConIvaResponse(PrecioConIvaResponse value) {
        return new JAXBElement<PrecioConIvaResponse>(_PrecioConIvaResponse_QNAME, PrecioConIvaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "datosProductoResponse")
    public JAXBElement<DatosProductoResponse> createDatosProductoResponse(DatosProductoResponse value) {
        return new JAXBElement<DatosProductoResponse>(_DatosProductoResponse_QNAME, DatosProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrecioConIva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "precioConIva")
    public JAXBElement<PrecioConIva> createPrecioConIva(PrecioConIva value) {
        return new JAXBElement<PrecioConIva>(_PrecioConIva_QNAME, PrecioConIva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://serviciosWeb/", name = "datosProducto")
    public JAXBElement<DatosProducto> createDatosProducto(DatosProducto value) {
        return new JAXBElement<DatosProducto>(_DatosProducto_QNAME, DatosProducto.class, null, value);
    }

}
