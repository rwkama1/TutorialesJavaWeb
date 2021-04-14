/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdbcversion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Raúl
 */
public class EjercicioJDBCVersion1 {
    
    private static Connection conexion;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio de JDBC Versión 1");
        
        if (abrirConexion()) {
            int opcion;
            
            do {
                opcion = mostrarMenu();
                System.out.println();
                
                switch(opcion) {
                    case 1:
                        opcionAgregarPersona();
                        
                        break;
                    case 2:
                        opcionBuscarPersona();
                        
                        break;
                    case 3:
                        opcionActualizarDatosPersona();
                        
                        break;
                    case 4:
                        opcionEliminarPersona();
                        
                        break;
                    case 5:
                        opcionListarPersonas();
                        
                        break;
                    case 0:
                        opcionTerminar();
                        
                        break;
                    default:
                        System.out.println("¡ERROR! Opción no válida.");
                        
                        break;
                }
            } while (opcion != 0);
        } else {
            System.out.println("\n¡Error! No se pudo abrir la conexión con la base de datos.");
        }
    }
    
    public static boolean abrirConexion() {
        try {
            // En el JDK 8 ya no se incluye el driver JdbcOdbcDriver.
            
            /*Properties propiedades = new Properties();
            propiedades.put("charSet", "iso-8859-1");
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conexion = DriverManager.getConnection("jdbc:odbc:OrigenDatosEjercicioJDBC", propiedades);*/
            
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjercicioJDBC", "root", "root");
            
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public static int pedirNumeroEntero(String mensaje, String mensajeError) {
        boolean error;
        Scanner teclado = new Scanner(System.in);
        int numero = 0;
        
        do {
            error = false;
            
            try {
                System.out.print(mensaje);
                numero = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(mensajeError);
                error = true;
            }
        } while (error);
        
        return numero;
    }
    
    public static double pedirNumeroDecimal(String mensaje, String mensajeError) {
        boolean error;
        Scanner teclado = new Scanner(System.in);
        double numero = 0;
        
        do {
            error = false;
            
            try {
                System.out.print(mensaje);
                numero = Double.parseDouble(teclado.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(mensajeError);
                error = true;
            }
        } while (error);
        
        return numero;
    }
    
    public static int mostrarMenu() {
        System.out.println("\n\nMenú:\n");
        System.out.println("1 - Agregar una persona");
        System.out.println("2 - Buscar una persona (por CI)");
        System.out.println("3 - Actualizar datos de una persona (por CI)");
        System.out.println("4 - Eliminar una persona (por CI)");
        System.out.println("5 - Listar todas las personas");
        System.out.println("0 - Terminar");
        
        return pedirNumeroEntero("\nIngrese una opcion: ", "\n¡ERROR! La opción no es un número entero válido.");
    }
    
    public static void opcionAgregarPersona() {
        
    }
    
    public static void opcionBuscarPersona() {
        
    }
    
    public static void opcionActualizarDatosPersona() {
        
    }
    
    public static void opcionEliminarPersona() {
        
    }
    
    public static void opcionListarPersonas() {
        
    }
    
    public static void opcionTerminar() {
        try {
            if (conexion != null) {
                conexion.close();
            }
            
            System.out.println("\n¡Gracias!");
        } catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo cerrar la conexión.");
        }
    }
    
}
