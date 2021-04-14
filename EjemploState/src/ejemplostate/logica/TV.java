/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplostate.logica;

/**
 *
 * @author Raul
 */
public class TV {
    
    private EstadoTV estado;
    
    private int canal;
    private int volumen;
    
    
    public int getCanal() {
        return canal;
    }
    
    protected void setCanal(int canal) throws ExcepcionPersonalizada {
        if (canal < 2 || canal > 69) {
            throw new ExcepcionPersonalizada("Canal no válido.");
        }
        
        this.canal = canal;
    }
    
    public int getVolumen() {
        return volumen;
    }
    
    protected void setVolumen(int volumen) throws ExcepcionPersonalizada {
        if (volumen < 0 || volumen > 100) {
            throw new ExcepcionPersonalizada("Volumen no válido.");
        }
        
        this.volumen = volumen;
    }
    
    
    public TV() {
        estado = new EstadoTVApagada();
        
        canal = 2;
        volumen = 10;
    }
    
    
    public void encender() throws ExcepcionPersonalizada {
        estado = estado.encender();
    }
    
    public void cambiarCanal(int canal) throws ExcepcionPersonalizada {
        estado.cambiarCanal(canal, this);
    }
    
    public void subirVolumen() throws ExcepcionPersonalizada {
        estado.subirVolumen(this);
    }
    
    public void bajarVolumen() throws ExcepcionPersonalizada {
        estado.bajarVolumen(this);
    }
    
    public void apagar() throws ExcepcionPersonalizada {
        estado = estado.apagar();
    }
    
}
