package ejerciciostate.logica;

public class Reloj {
    // Guarda la hora actual.
    private Hora horaActual;
    
    // Guarda el estado actual del reloj (que esta mostrando).
    private IModo modo;
    
    public Reloj() {
        // Seteamos la hora inicial.
        horaActual = new Hora(12,0);
        
        // Al principio el reloj muestra la hora (está en modo NORMAL).
        modo = new ModoNormal();
    }
    
    public void presionarA() {
        IModo sigM = modo.sigModo();
        setModo(sigM);
    }
    
    public void presionarB() {
        modo.accion(horaActual);        
    }
    
    private void setModo(IModo nuevoModo) {
        this.modo = nuevoModo;
    }
    
    public String toString() {
        return this.horaActual.toString();
    }
    
}
