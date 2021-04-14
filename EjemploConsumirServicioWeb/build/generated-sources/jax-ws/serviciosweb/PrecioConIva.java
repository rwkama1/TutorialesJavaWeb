
package serviciosweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para precioConIva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="precioConIva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="precioSinIva" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "precioConIva", propOrder = {
    "precioSinIva"
})
public class PrecioConIva {

    protected double precioSinIva;

    /**
     * Obtiene el valor de la propiedad precioSinIva.
     * 
     */
    public double getPrecioSinIva() {
        return precioSinIva;
    }

    /**
     * Define el valor de la propiedad precioSinIva.
     * 
     */
    public void setPrecioSinIva(double value) {
        this.precioSinIva = value;
    }

}
