package ejerciciocontroladoresfabricassingletonyobserver.logica;

public class Empleado {
    private String nombre;
    private int numero;
    
    public Empleado(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }
    
    public String getNombre()  {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getNumero()  {
        return this.numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String toString() {
        return "Empleado " + this.nombre + " (" + this.numero + ")";
    }
    
}
