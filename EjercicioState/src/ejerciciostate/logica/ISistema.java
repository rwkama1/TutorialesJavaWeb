package ejerciciostate.logica;

public interface ISistema {
    
    public void presionarA();
    
    public void presionarB();
    
    public String consultarHora();
    
    public void agregarObservador(IObserver o);
    
    public void eliminarObservador(IObserver o);
    
}
