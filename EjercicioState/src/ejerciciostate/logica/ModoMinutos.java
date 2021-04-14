package ejerciciostate.logica;

public class ModoMinutos implements IModo {

    public void accion(Hora h) {
        h.incMinutos();
    }    
    
    public IModo sigModo() {
        IModo normal = new ModoNormal();
        return normal;
    }

}
