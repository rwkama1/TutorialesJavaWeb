/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploobserver;

import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class ArrayListObservable extends ArrayList {
    
    private ArrayList<ObservadorArrayList> observadores;
    
    
    public ArrayListObservable() {
        observadores = new ArrayList();
    }
    
    
    @Override
    public boolean add(Object e) {
        boolean resultado = super.add(e);
        
        notificarElementoAgregadoATodos(e);
        
        return resultado;
    }
    
    @Override
    public boolean remove(Object o) {
        boolean resultado = super.remove(o);
        
        notificarElementoQuitadoATodos(o);
        
        return resultado;
    }
    
    public void agregarObservador(ObservadorArrayList observador) {
        observadores.add(observador);
    }
    
    public void quitarObservador(ObservadorArrayList observador) {
        observadores.remove(observador);
    }
    
    private void notificarElementoAgregadoATodos(Object objetoAgregado) {
        for (ObservadorArrayList oal : observadores) {
            oal.alAgregarElemento(objetoAgregado);
        }
    }
    
    private void notificarElementoQuitadoATodos(Object objetoQuitado) {
        for (ObservadorArrayList oal : observadores) {
            oal.alQuitarElemento(objetoQuitado);
        }
    }
    
}
