/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploconsumirservicioweb;

/**
 *
 * @author sistemas
 */
public class ClienteServicioWebEjemplo {
    public static double precioConIva(double precioSinIva)
    {
        serviciosweb.ServicioWebEjemplo_Service service=new serviciosweb.ServicioWebEjemplo_Service();
        serviciosweb.ServicioWebEjemplo port=service.getServicioWebEjemploPort();
        
        return port.precioConIva(precioSinIva);
    }
    public static String datosProducto(serviciosweb.Producto producto)
    {
        serviciosweb.ServicioWebEjemplo_Service service=new serviciosweb.ServicioWebEjemplo_Service();
        serviciosweb.ServicioWebEjemplo port=service.getServicioWebEjemploPort();
        return port.datosProducto(producto);
    }
    
}
