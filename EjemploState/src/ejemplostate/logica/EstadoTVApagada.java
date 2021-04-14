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
class EstadoTVApagada extends EstadoTV {
    
    @Override
    public EstadoTV encender() throws ExcepcionPersonalizada {
        return new EstadoTVEncendida();
    }
    
}
