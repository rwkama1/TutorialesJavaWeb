/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioreflection;

import ejercicioreflection.clasesdisponibles.A;
import ejercicioreflection.clasesdisponibles.B;
import ejercicioreflection.clasesdisponibles.C;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raul
 */
public class EjercicioReflection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        resolverSinReflection();
        resolverConReflection();
    }
    
    private static void resolverSinReflection() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("\n¿Qué clase desea instanciar? ");
        String nombreClase = teclado.nextLine();
        
        Object instancia = null;
        
        switch (nombreClase) {
            case "A":
                instancia = new A();
                
                break;
            case "B":
                instancia = new B();
                
                break;
            case "C":
                instancia = new C();
                
                break;
        }
        
        if (instancia != null) {
            System.out.print("\n¿Qué método desea ejecutar sobre dicha instancia? ");
            String nombreMetodo = teclado.nextLine();
            
            System.out.println();
            
            if (instancia instanceof A) {
                switch(nombreMetodo) {
                    case "unMetodo":
                        ((A)instancia).unMetodo();
                        
                        break;
                    case "otroMetodo":
                        ((A)instancia).otroMetodo();
                        
                        break;
                    case "otroMetodoMas":
                        ((A)instancia).otroMetodoMas();
                        
                        break;
                    default:
                        System.out.println("¡ERROR! El método indicado no está disponible en la instancia creada.");
                        
                        break;
                }
            } else if (instancia instanceof B) {
                switch(nombreMetodo) {
                    case "primerMetodo":
                        ((B)instancia).primerMetodo();
                        
                        break;
                    case "segundoMetodo":
                        ((B)instancia).segundoMetodo();
                        
                        break;
                    case "tercerMetodo":
                        ((B)instancia).tercerMetodo();
                        
                        break;
                    default:
                        System.out.println("¡ERROR! El método indicado no está disponible en la instancia creada.");
                        
                        break;
                }
            } else if (instancia instanceof C) {
                switch(nombreMetodo) {
                    case "x":
                        ((C)instancia).x();
                        
                        break;
                    case "y":
                        ((C)instancia).y();
                        
                        break;
                    case "z":
                        ((C)instancia).z();
                        
                        break;
                    default:
                        System.out.println("¡ERROR! El método indicado no está disponible en la instancia creada.");
                        
                        break;
                }
            }
        } else {
            System.out.println("\n¡ERROR! La clase indicada no está disponible.");
        }
    }
    
    private static void resolverConReflection() 
    {
        try {
            Scanner teclado = new Scanner(System.in);
            System.out.print("\n¿Qué clase desea instanciar? ");
            String nombreClase = teclado.nextLine();
            Class c=Class.forName("ejercicioreflection.clasesdisponibles."+nombreClase+"");
            System.out.print("\n¿Qué método desea ejecutar sobre dicha instancia? ");
            String nombreMetodo = teclado.nextLine();           
            System.out.println();
            Method m=c.getMethod(""+nombreMetodo+"");
           Object o=c.newInstance();
           m.invoke(o);
         }   
          catch(ClassNotFoundException|NoSuchMethodException|InstantiationException|IllegalAccessException|InvocationTargetException ex){              
        System.out.println("!ERROR! No se encontro la clase o el metodo");} 
    }  
}
    
 
     


