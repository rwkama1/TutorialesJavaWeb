/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploobserver;

/**
 *
 * @author Raul
 */
public class ObservadorArrayListIngles implements ObservadorArrayList {
    
    @Override
    public void alAgregarElemento(Object objetoAgregado) {
        System.out.println("Added: " + objetoAgregado);
    }
    
    @Override
    public void alQuitarElemento(Object objetoQuitado) {
        System.out.println("Removed: " + objetoQuitado);
    }
    
}
