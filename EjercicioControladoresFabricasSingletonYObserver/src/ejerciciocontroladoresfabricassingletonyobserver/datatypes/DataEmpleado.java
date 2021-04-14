package ejerciciocontroladoresfabricassingletonyobserver.datatypes;

public class DataEmpleado {
    private int numero;
    private String nombre;
    
    public DataEmpleado(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String toString() {
        return "Número: " + this.numero + " Nombre: " + this.nombre;
    }
}
