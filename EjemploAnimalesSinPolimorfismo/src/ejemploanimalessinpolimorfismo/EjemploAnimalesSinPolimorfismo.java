/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploanimalessinpolimorfismo;

/**
 *
 * @author Raúl
 */
public class EjemploAnimalesSinPolimorfismo {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Animal[] animales = { new Perro(), new Paloma(), new Delfin() };
        
        for (Animal a : animales) {
            if (a instanceof Perro) {
                System.out.println(((Perro)a).caminar());
            } else if (a instanceof Paloma) {
                System.out.println(((Paloma)a).volar());
            } else if (a instanceof Delfin) {
                System.out.println(((Delfin)a).nadar());
            } else {
                System.out.println("Animal desconocido...");
            }
            
            // ¿Qué pasaría con el if anterior si agregamos una clase Serpiente?
        }
    }
    
}
