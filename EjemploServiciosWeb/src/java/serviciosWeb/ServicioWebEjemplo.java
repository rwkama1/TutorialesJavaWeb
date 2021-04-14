/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosWeb;

import beans.Producto;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author sistemas
 */
@WebService(serviceName = "ServicioWebEjemplo")
public class ServicioWebEjemplo {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "precioConIva")
    public double precioConIva(@WebParam(name = "precioSinIva") double precioSinIva) {
        
        return precioSinIva*1.22;
    }
     @WebMethod(operationName = "datosProducto")
    public String datosProducto(@WebParam(name = "producto") Producto producto) {
        
        return "Codigo: "+ producto.getCodigo()+", Descripcion: "+producto.getDescripcion()+",Precio: "+producto.getPrecio();
    }
}
