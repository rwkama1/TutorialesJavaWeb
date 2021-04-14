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
public class EjemploObserver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayListObservable arrayListObservable = new ArrayListObservable();
        
        arrayListObservable.agregarObservador(new ObservadorArrayListIngles());
        arrayListObservable.agregarObservador(new ObservadorArrayList() {
            
            @Override
            public void alAgregarElemento(Object objetoAgregado) {
                System.out.println("Se agregó: " + objetoAgregado);
            }
            
            @Override
            public void alQuitarElemento(Object objetoQuitado) {
                System.out.println("Se quitó: " + objetoQuitado);
            }
            
        });
        
        arrayListObservable.add("Hola");
        arrayListObservable.add("Chau");
        arrayListObservable.add(1);
        arrayListObservable.add(2);
        arrayListObservable.add(3);
        
        System.out.println();
        
        arrayListObservable.remove("Hola");
        arrayListObservable.remove("Chau");
        arrayListObservable.remove((Object)1);
        arrayListObservable.remove((Object)2);
        arrayListObservable.remove((Object)3);
    }
    
}
