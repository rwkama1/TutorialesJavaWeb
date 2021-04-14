package ejerciciocontroladoresfabricassingletonyobserver.logica;

import java.util.Vector;
import ejerciciocontroladoresfabricassingletonyobserver.datatypes.*;

public class CEmpleados implements IEmpleados { 
    
    // Ahora no es necesario que la colección sea estática,
    // pues solo habrá una instancia del controlador.
    private Vector vecEmpleados;
    
    // Aquí guardamos referencias a los observadores, pero 
    // estas referencias serán de tipo interfaz (IObserver)
    // lo cual nos evita conocer a los formularios de la 
    // presentacion, que serán quienes implementen IObserver.
    private Vector colObservadores;
    
    // Este atributo estático apunta a la (única) instancia.
    private static CEmpleados instance = null;
    
    // El constructor se hace privado para impedir que
    // cualquiera pueda instanciarlo. Solo deben usar
    // el método estático getInstance()
    private CEmpleados() {
        vecEmpleados = new Vector();
        colObservadores = new Vector();
    }
    
    // Este método debe ser el invocado para obtener una
    // referencia al controlador. Este método es quien decide
    // cuando crear una instancia del controlador.
    public static CEmpleados getInstance() {
        if (instance==null)
            instance = new CEmpleados();
        return instance;
    }
    
    public void agregarEmpleado(int numero, String nombre) {
        Empleado e = new Empleado(numero, nombre);
        vecEmpleados.add(e);        

        DataEmpleado de = new DataEmpleado(numero, nombre);
        notificar(de);
    }
    
    public void notificar(DataEmpleado de) {
        // Ahora avisamos a todos los observadores que algo
        // ocurrió, y les pasamos el nuevo empleado creado
        // pero como DataType !        
        for (int i=0; i<colObservadores.size(); i++) {
            IObserver obs = (IObserver)colObservadores.get(i);
            obs.update(de);  
        }        
    }
    
    public boolean eliminarEmpleado(int numero){
        boolean encontre=false;
        Empleado empActual=null;
        int i=0;
        while ((i<vecEmpleados.size())&&(!encontre)) {
            empActual = (Empleado)vecEmpleados.elementAt(i);
            if (empActual.getNumero()==numero)
                encontre = true;
            else
                i++;
        }
        if (!encontre)
            return false;
        else {
            vecEmpleados.remove(empActual);
            return true;
        }        
    }
    
    public DataEmpleado obtenerEmpleado(int numero) {
        boolean encontre=false;
        Empleado empActual=null;
        int i=0;
        while ((i<vecEmpleados.size())&&(!encontre)) {
            empActual = (Empleado)vecEmpleados.elementAt(i);
            if (empActual.getNumero()==numero)
                encontre = true;
            else
                i++;
        }
        if (encontre) {
            // Devolvemos un DataType con los datos del empleado.
            DataEmpleado de = new DataEmpleado(empActual.getNumero(), empActual.getNombre());
            return de;
        }
        else return null;        
    }
    
    public Vector devolverColEmpleados() {
        /*
         * Acá no podemos devolver la colección de empleados, ya que si lo hacemos
         * cualquiera de "afuera" podria borrarnos todo o modificar algo.
         * Pero como devolvemos datos, no objetos Empleado, los de "afuera" no 
         * pueden modificar los empleados !!!
         */
        Vector vecDataEmpleados = new Vector();
        for (int i=0; i<vecEmpleados.size(); i++) {
            Empleado empActual = (Empleado)vecEmpleados.get(i);
            DataEmpleado de = new DataEmpleado(empActual.getNumero(), empActual.getNombre());
            vecDataEmpleados.add(de);
        }
        
        return vecDataEmpleados;        
    }
    
    // Este método permite registrar nuevos observers.
    public void agregarObservador(IObserver o) {
        colObservadores.add(o);
    }
    
    // Este método permimte des-registrar observers.
    public void eliminarObservador(IObserver o) {
        colObservadores.remove(o);
    }
    
}
