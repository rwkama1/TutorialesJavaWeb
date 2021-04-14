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
abstract class EstadoTV {
    
    public EstadoTV encender() throws ExcepcionPersonalizada {
        throw new ExcepcionPersonalizada("Esta función no está disponible en este momento.");
    }
    
    public void cambiarCanal(int canal, TV tv) throws ExcepcionPersonalizada {
        throw new ExcepcionPersonalizada("Esta función no está disponible en este momento.");
    }
    
    public void subirVolumen(TV tv) throws ExcepcionPersonalizada {
        throw new ExcepcionPersonalizada("Esta función no está disponible en este momento.");
    }
    
    public void bajarVolumen(TV tv) throws ExcepcionPersonalizada {
        throw new ExcepcionPersonalizada("Esta función no está disponible en este momento.");
    }
    
    public EstadoTV apagar() throws ExcepcionPersonalizada {
        throw new ExcepcionPersonalizada("Esta función no está disponible en este momento.");
    }
    
}
