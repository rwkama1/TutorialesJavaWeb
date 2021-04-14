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
class EstadoTVEncendida extends EstadoTV {
    
    @Override
    public void cambiarCanal(int canal, TV tv) throws ExcepcionPersonalizada {
        tv.setCanal(canal);
    }
    
    @Override
    public void subirVolumen(TV tv) throws ExcepcionPersonalizada {
        int volumenActual = tv.getVolumen();
        
        if (volumenActual < 100) {
            tv.setVolumen(++volumenActual);
        }
    }
    
    @Override
    public void bajarVolumen(TV tv) throws ExcepcionPersonalizada {
        int volumenActual = tv.getVolumen();
        
        if (volumenActual > 0) {
            tv.setVolumen(--volumenActual);
        }
    }
    
    @Override
    public EstadoTV apagar() throws ExcepcionPersonalizada {
        return new EstadoTVApagada();
    }
    
}
