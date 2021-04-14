/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Raúl
 */
public class Producto implements Serializable {
    
    private int codigo;
    private String descripcion;
    private double costo;
    private int stockActual;
    
    
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
    
    public double getCosto() {
        return costo;
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public int getStockActual() {
        return stockActual;
    }
    
    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
    
    
    public Producto() {
        this(1, "N/D", 0, 0);
    }
    
    public Producto(int codigo, String descripcion, double costo, int stockActual) {
        setCodigo(codigo);
        setDescripcion(descripcion);
        setCosto(costo);
        setStockActual(stockActual);
    }
    
}
