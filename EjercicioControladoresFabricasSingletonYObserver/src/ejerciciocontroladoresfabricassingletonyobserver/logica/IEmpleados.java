package ejerciciocontroladoresfabricassingletonyobserver.logica;

import java.util.Vector;
import ejerciciocontroladoresfabricassingletonyobserver.datatypes.*;

public interface IEmpleados {

    public void agregarEmpleado(int numero, String nombre);
    
    public boolean eliminarEmpleado(int numero);
    
    public DataEmpleado obtenerEmpleado(int numero);
    
    public Vector devolverColEmpleados();
    
    public void agregarObservador(IObserver o);
    
    public void eliminarObservador(IObserver o);
}
