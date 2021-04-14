/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocoleccionesdinamicas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Raul
 */
public class EjemploColeccionesDinamicas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long inicio, fin;
        
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(0);
        
        LinkedList<Integer> linkedList = new LinkedList();
        linkedList.add(0);
        
        inicio = System.nanoTime();
        realizarInserciones(arrayList);
        fin = System.nanoTime();
        System.out.println("\nDuración de inserciones en ArrayList: " + (fin - inicio));
        
        inicio = System.nanoTime();
        realizarInserciones(linkedList);
        fin = System.nanoTime();
        System.out.println("Duración de inserciones en LinkedList: " + (fin - inicio));
        
        inicio = System.nanoTime();
        realizarAccesosAleatorios(arrayList);
        fin = System.nanoTime();
        System.out.println("\nDuración de accesos aleatorios en ArrayList: " + (fin - inicio));
        
        inicio = System.nanoTime();
        realizarAccesosAleatorios(linkedList);
        fin = System.nanoTime();
        System.out.println("Duración de accesos aleatorios en LinkedList: " + (fin - inicio));
        
        inicio = System.nanoTime();
        realizarRecorrida(arrayList);
        fin = System.nanoTime();
        System.out.println("\nDuración de recorrida en ArrayList: " + (fin - inicio));
        
        inicio = System.nanoTime();
        realizarRecorrida(linkedList);
        fin = System.nanoTime();
        System.out.println("Duración de recorrida en LinkedList: " + (fin - inicio));
        
        inicio = System.nanoTime();
        realizarBorrados(arrayList);
        fin = System.nanoTime();
        System.out.println("\nDuración de borrados en ArrayList: " + (fin - inicio));
        
        inicio = System.nanoTime();
        realizarBorrados(linkedList);
        fin = System.nanoTime();
        System.out.println("Duración de borrados en LinkedList: " + (fin - inicio));
    }
    
    public static void realizarInserciones(List<Integer> coleccion) {
        int cantidadElementos = coleccion.size();
        
        for (int i = 1 ; i <= 100000 ; i++) {
            //coleccion.add(0, 0);
            coleccion.add(cantidadElementos++ / 2);
            //coleccion.add(cantidadElementos++ - 1, 0);
        }
    }
    
    public static void realizarAccesosAleatorios(List<Integer> coleccion) {
        Random azar = new Random();
        
        int cantidadElementos = coleccion.size();
        int numero;
        
        for (int i = 1 ; i <= 100000 ; i++) {
            numero = coleccion.get(azar.nextInt(cantidadElementos));
        }
    }
    
    public static void realizarRecorrida(List<Integer> coleccion) {
        int numero;
        
        for (int n : coleccion) {
            numero = n;
        }
        
        /*int cantidadElementos = coleccion.size();
        
        for (int i = 0 ; i < cantidadElementos ; i++) {
            numero = coleccion.get(i);
        }*/
    }
    
    public static void realizarBorrados(List<Integer> coleccion) {
        int cantidadElementos = coleccion.size();
        
        for (int i = 1 ; i < cantidadElementos ; i++) {
            //coleccion.remove(0);
            coleccion.remove(cantidadElementos-- / 2);
            //coleccion.remove(--cantidadElementos);
        }
    }
    
}
