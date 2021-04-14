package ejerciciostate.logica;

import java.util.*;

public class Controller implements ISistema {
    private static Controller instance = null;
    private Reloj r = null;
    private Vector colObservadores = new Vector();
    
    private Controller() {
        r = new Reloj();
    }
    
    public static Controller getInstance() {
        if (instance==null)
            instance = new Controller();
        return instance;
    }
    
    public void presionarA() {
        r.presionarA();
    }
    
    public void presionarB() {
        r.presionarB();
        
        // Cada vez que presionan el botón B actualizo
        // la hora de todos los observadores registrados.
        for (int i=0; i<colObservadores.size(); i++) {
            ((IObserver)colObservadores.get(i)).update(r.toString());
        }
    }
    
    public String consultarHora() {
        return r.toString();
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
