/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploorientacionaobjetos;

/**
 *
 * @author Raul
 */
public class Persona {
    
    private String nombre;
    private String apellido;
    private int edad;
    
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad < 0) {
            edad = 18;
        }
        
        this.edad = edad;
    }
    
    
    public Persona() {
        this("Fulano", "de Tal", 18);
    }
    
    public Persona(Persona otra) {
        this(otra.getNombre(), otra.getApellido(), otra.getEdad());
    }
    
    public Persona(String nombre, String apellido, int edad) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
    }
    
    
    public void cumplirAnios() {
        edad++;
    }
    
    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + ", " + getEdad() + " años";
    }//esto seria como el Base en c#
    
}
