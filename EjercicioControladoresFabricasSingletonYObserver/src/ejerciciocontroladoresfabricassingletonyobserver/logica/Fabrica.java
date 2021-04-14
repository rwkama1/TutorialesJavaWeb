package ejerciciocontroladoresfabricassingletonyobserver.logica;

public class Fabrica {

    public static IEmpleados getIEmpleados() {
        
        // Ya no hacemos el new del controlador.
        return CEmpleados.getInstance();
    }
    
}
