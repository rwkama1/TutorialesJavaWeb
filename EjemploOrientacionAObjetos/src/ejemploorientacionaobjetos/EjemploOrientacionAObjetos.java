/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploorientacionaobjetos;

/**
 *
 * @author Raul
 */
public class EjemploOrientacionAObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona persona1;
        persona1 = new Persona();
        
        Persona persona2 = new Persona("Juan", "Fernández", 35);
        
        System.out.println("\nEstado de persona1: " + persona1);
        
        persona1.setNombre("Juan");
        persona1.setApellido("Fernández");
        persona1.setEdad(34);
        persona1.cumplirAnios();
        
        System.out.println("\nEstado de persona1: " + persona1);
        
        System.out.println("Estado de persona2: " + persona2);
        
        comprobarIdentidad(persona1, persona2);
        
        System.out.println("\nPersona persona3 = persona2;");
        Persona persona3 = persona2;
        comprobarIdentidad(persona2, persona3);
        
        System.out.println("\npersona3 = new Alumno(\"Ana\", \"Rodríguez\", 24, 1000);");
        persona3 = new Alumno("Ana", "Rodríguez", 24, 1000);
        comprobarIdentidad(persona2, persona3);
        
        System.out.println("\npersona2 = null;\npersona3 = null;");
        persona2 = null;
        persona3 = null;
        comprobarIdentidad(persona2, persona3);
        
        System.out.println();
        
        persona2 = new Alumno("Francisco", "García", 33, 1010);
        persona3 = new Alumno("María José", "Ramírez", 42, 1020);
        
        ((Alumno)persona2).rendirExamen(500);
        ((Alumno)persona2).rendirExamen(700);
        ((Alumno)persona3).rendirExamen(500);
    }
    
    public static void comprobarIdentidad(Persona primeraPersona, Persona segundaPersona) {
        if (primeraPersona != null && segundaPersona != null) {
            if (primeraPersona == segundaPersona) {
                System.out.println("Ambas referencias apuntan al mismo objeto (son alias una de la otra).");
            } else {
                System.out.println("Las referencias apuntan a objetos distintos.");
            }
        } else {
            System.out.println("Ambas referencias apuntan a null.");
        }
    }
    
}
