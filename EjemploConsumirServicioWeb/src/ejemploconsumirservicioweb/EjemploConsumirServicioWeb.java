/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploconsumirservicioweb;

import serviciosweb.Producto;

/**
 *
 * @author sistemas
 */
public class EjemploConsumirServicioWeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(ClienteServicioWebEjemplo.precioConIva(100));
        System.out.println();
        Producto producto=new Producto();
        producto.setCodigo(1);
        producto.setDescripcion("Tablet Google Nexus 7");
        producto.setPrecio(300);
        System.out.println(ClienteServicioWebEjemplo.datosProducto(producto));
        // TODO code application logic here
    }
    
}
