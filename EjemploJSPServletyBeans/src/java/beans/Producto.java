/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author sistemas
 */
public class Producto {
      private int codigo;
   private String descripcion;
   private double precio;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        
    }

    public Producto() {
        this(1,"N/D",0);
    }
    

    public Producto(int codigo, String descripcion, double precio) 
    {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setPrecio(precio);
    }
    
}
