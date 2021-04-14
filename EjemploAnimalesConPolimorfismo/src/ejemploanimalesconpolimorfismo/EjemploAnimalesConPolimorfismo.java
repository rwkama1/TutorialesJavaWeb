/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploanimalesconpolimorfismo;

/**
 *
 * @author Raúl
 */
public class EjemploAnimalesConPolimorfismo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal[] animales = { new Perro(), new Paloma(), new Delfin() };
        
        for (Animal a : animales) {
            System.out.println(a.andar());
            
            // ¿Qué pasaría con la sentencia anterior si agregamos una clase Serpiente?
        }
    }
}
