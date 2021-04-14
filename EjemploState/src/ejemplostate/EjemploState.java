/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplostate;

import ejemplostate.logica.ExcepcionPersonalizada;
import ejemplostate.logica.TV;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Raul
 */
public class EjemploState {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TV tv = new TV();
        
        System.out.println("¡Felicidades por su nueva TV!");
        
        Scanner teclado = new Scanner(System.in);
        
        boolean opcionValida = false;
        int opcion = 0;
        
        do {
            opcionValida = false;

            while (!opcionValida) {
                try {
                    System.out.println("\n¿Qué desea hacer?");
                    System.out.print("(1: encender, 2: cambiar canal, 3: subir volumen, 4: bajar volumen, 5: apagar, 0: terminar): ");
                    
                    opcion = Integer.parseInt(teclado.nextLine());
                    opcionValida = true;
                } catch (NumberFormatException ex) {
                    System.out.println("\nOpción no válida.");
                }
            }
            
            try {
                System.out.println();
                
                switch (opcion) {
                    case 1:
                        tv.encender();
                        
                        System.out.println("La TV está encendida (canal: " + tv.getCanal() + ", volumen: " + tv.getVolumen() + ")");

                        break;
                    case 2:
                        tv.cambiarCanal(2 + new Random().nextInt(67));
                        
                        System.out.println("El canal de la TV es: " + tv.getCanal());
                        
                        break;
                    case 3:
                        tv.subirVolumen();
                        
                        System.out.println("El volumen de la TV es: " + tv.getVolumen());
                        
                        break;
                    case 4:
                        tv.bajarVolumen();
                        
                        System.out.println("El volumen de la TV es: " + tv.getVolumen());
                        
                        break;
                    case 5:
                        tv.apagar();
                        
                        System.out.println("La TV está apagada.");
                        
                        break;
                    case 0:
                        System.out.println("¡FIN!");
                        
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        
                        break;
                }
            } catch (ExcepcionPersonalizada ex) {
                System.out.println(ex.getMessage());
            }
            
        } while (opcion != 0);
    }
    
}
