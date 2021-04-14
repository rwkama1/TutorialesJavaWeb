/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

/**
 *
 * @author Raúl
 */
public class FabricaPersistencia {
    
    public static IPersistencia getPersistencia() {
        return Persistencia.getInstancia();
    }
    
}
