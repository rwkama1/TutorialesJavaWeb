/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compartidos.beans.datatypes;

import java.io.Serializable;

/**
 *
 * @author Raúl
 */
public class DTEmpleado implements Serializable {
    
    private int cedula;
    private String nombre;
    private double sueldo;
    
    
    public int getCedula() {
        return cedula;
    }
    
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    public DTEmpleado() {
        this(1, "N/D", 0);
    }
    
    public DTEmpleado(int cedula, String nombre, double sueldo) {
        setCedula(cedula);
        setNombre(nombre);
        setSueldo(sueldo);
    }
    
}
