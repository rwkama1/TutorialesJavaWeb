package ejerciciostate.logica;

public class ModoNormal implements IModo {

    public void accion(Hora h) {
        // No hace nada.
    }    
    
    public IModo sigModo() {
        IModo setH = new ModoHoras();
        return setH;
    }
}
