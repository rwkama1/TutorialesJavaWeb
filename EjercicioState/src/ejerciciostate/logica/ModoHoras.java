package ejerciciostate.logica;

public class ModoHoras implements IModo {
    public void accion(Hora h) {
        h.incHoras();
    }
    
    public IModo sigModo() {
        IModo setM = new ModoMinutos(); 
        return setM;
    }
  
}
