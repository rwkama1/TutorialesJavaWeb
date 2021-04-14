/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Raúl
 */
public class FabricaLogica {
    
    public static ISistema getSistema() {
        return Sistema.getInstancia();
    }
    
}
