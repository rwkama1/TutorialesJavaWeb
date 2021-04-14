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
public class ExcepcionPersonalizada extends Exception {
    
    public ExcepcionPersonalizada() {
        
    }
    
    public ExcepcionPersonalizada(String mensaje) {
        super(mensaje);
    }
    
}
