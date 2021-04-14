package ejerciciostate.logica;

public class Fabrica {

    public static ISistema getISistema() {
        return Controller.getInstance();
    }
    
}
