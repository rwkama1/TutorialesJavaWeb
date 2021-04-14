/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdbcversion2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Raúl
 */
public class EjercicioJDBCVersion2 {
    
    private static Connection conexion;
    private static Statement consulta;
    private static ResultSet datos;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ejercicio de JDBC Versión 2");
        
        if (abrirConexion()) {
            int opcion;
            
            do {
                opcion = mostrarMenu();
                System.out.println();
                
                switch(opcion) {
                    case 1:
                        opcionCargarDatos();
                        
                        break;
                    case 2:
                        opcionAgregarPersona();
                        
                        break;
                    case 3:
                        opcionBuscarPersona();
                        
                        break;
                    case 4:
                        opcionActualizarDatosPersona();
                        
                        break;
                    case 5:
                        opcionEliminarPersona();
                        
                        break;
                    case 6:
                        opcionListarPersonas();
                        
                        break;
                    case 7:
                        opcionNavegadorPersonas();
                        
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
        System.out.println("1 - Cargar datos");
        System.out.println("2 - Agregar una persona");
        System.out.println("3 - Buscar una persona (por CI)");
        System.out.println("4 - Actualizar datos de una persona (por CI)");
        System.out.println("5 - Eliminar una persona (por CI)");
        System.out.println("6 - Listar todas las personas");
        System.out.println("7 - Navegador de personas");
        System.out.println("0 - Terminar");
        
        return pedirNumeroEntero("\nIngrese una opcion: ", "\n¡ERROR! La opción no es un número entero válido.");
    }
    
    public static void opcionCargarDatos() {
        
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
    
    public static String mostrarNavegadorPersonas() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("\n\nNavegador de Personas:\n");
        System.out.println("S - Ir al siguiente registro");
        System.out.println("U - Ir al último registro");
        System.out.println("P - Ir al primer registro");
        System.out.println("A - Ir al registro anterior");
        System.out.println("T - Terminar");
        
        System.out.print("\nIngrese una opcion: ");
        
        return teclado.nextLine().trim().toLowerCase();
    }
    
    public static void opcionNavegadorPersonas() {
        
    }
    
    public static void opcionTerminar() {
        try {
            if (datos != null) {
                datos.close();
            }
            
            if (consulta != null) {
                consulta.close();
            }
            
            if (conexion != null) {
                conexion.close();
            }
            
            System.out.println("\n¡Gracias!");
        } catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo cerrar los recursos.");
        }
    }
    
}
