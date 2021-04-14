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
    
    public static void mostrarFilaActual() throws SQLException {
        long cedula = datos.getLong("Cedula");
        String nombre = datos.getString("Nombre");
        int edad = datos.getInt("Edad");
        boolean casado = datos.getBoolean("Casado");
        double sueldo = datos.getDouble("Sueldo");
        
        System.out.println("Cédula: " + cedula + ", Nombre: " + nombre + ", Edad: " + edad + ", Casado/a: " + (casado ? "Sí" : "No") + ", Sueldo: " + sueldo);
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
        try {
            consulta = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            datos = consulta.executeQuery("SELECT * FROM Personas;");
            
            System.out.println("\n¡Datos cargados con éxito!");
        } catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo cargar los datos.");
        }
    }
    
    public static void opcionAgregarPersona() {
        if (datos != null) {
            Scanner teclado = new Scanner(System.in);
            
            long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
            
            System.out.print("Ingrese el nombre: ");
            String nombre = teclado.nextLine();
            
            int edad = pedirNumeroEntero("Ingrese la edad: ", "\n¡Error! La edad no es un número entero válido.\n");
            
            System.out.print("¿Está casado/a? (s/n): ");
            boolean casado = teclado.nextLine().trim().toLowerCase().equals("s");
            
            double sueldo = pedirNumeroDecimal("Ingrese el sueldo: ", "\n¡Error! El sueldo no es un número decimal válido.\n");
            
            try {
                datos.moveToInsertRow();
                datos.updateLong("Cedula", cedula);
                datos.updateString("Nombre", nombre);
                datos.updateInt("Edad", edad);
                datos.updateBoolean("Casado", casado);
                datos.updateDouble("Sueldo", sueldo);
                datos.insertRow();
                
                System.out.println("\n¡Persona agregada con éxito!");
            } /*catch (SQLException ex) {
                System.out.println("Mensaje de error SQL: " + ex.getMessage());
                System.out.println("Código de error SQL: " + ex.getErrorCode());
                System.out.println("Estado SQL: " + ex.getSQLState());
            }*/ catch (Exception ex) {
                System.out.println("\n¡Error! No se pudo agregar la persona.");
            }
        } else {
            System.out.println("¡Error! No hay datos cargados.");
        }
    }
    
    public static void opcionBuscarPersona() {
        if (datos != null) {
            long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
            
            boolean personaEncontrada = false;
            
            try {
                datos.beforeFirst();
                
                while (!personaEncontrada && datos.next()) {
                    if (datos.getLong("cedula") == cedula) {
                        personaEncontrada = true;
                    }
                }
                
                if (personaEncontrada) {
                    System.out.println("\n\nPersona Encontrada:\n");
                    
                    mostrarFilaActual();
                } else {
                    System.out.println("\n\nNo se encontró ninguna persona con esa cédula.");
                }
            } catch (Exception ex) {
                System.out.println("\n¡Error! No se pudo buscar la persona.");
            }
        } else {
            System.out.println("¡Error! No hay datos cargados.");
        }
    }
    
    public static void opcionActualizarDatosPersona() {
        if (datos != null) {
            Scanner teclado = new Scanner(System.in);
            
            long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
            
            boolean personaEncontrada = false;
            
            try {
                datos.beforeFirst();
                
                while (!personaEncontrada && datos.next()) {
                    if (datos.getLong("cedula") == cedula) {
                        personaEncontrada = true;
                    }
                }
                
                if (personaEncontrada) {
                    System.out.print("Ingrese el nombre: ");
                    String nombre = teclado.nextLine();
                    
                    int edad = pedirNumeroEntero("Ingrese la edad: ", "\n¡Error! La edad no es un número entero válido.\n");
                    
                    System.out.print("¿Está casado/a? (s/n): ");
                    boolean casado = teclado.nextLine().trim().toLowerCase().equals("s");
                    
                    double sueldo = pedirNumeroDecimal("Ingrese el sueldo: ", "\n¡Error! El sueldo no es un número decimal válido.\n");
                    
                    datos.updateString("Nombre", nombre);
                    datos.updateInt("Edad", edad);
                    datos.updateBoolean("Casado", casado);
                    datos.updateDouble("Sueldo", sueldo);
                    datos.updateRow();
                    
                    System.out.println("\n¡Persona actualizada con éxito!");
                } else {
                    System.out.println("\nNo se encontró ninguna persona con esa cédula.");
                }
            } catch (Exception ex) {
                System.out.println("\n¡Error! No se pudo actualizar la persona.");
            }
        } else {
            System.out.println("¡Error! No hay datos cargados.");
        }
    }
    
    public static void opcionEliminarPersona() {
        if (datos != null) {
            long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
            
            boolean personaEncontrada = false;
            
            try {
                datos.beforeFirst();
                
                while (!personaEncontrada && datos.next()) {
                    if (datos.getLong("cedula") == cedula) {
                        personaEncontrada = true;
                    }
                }
                
                if (personaEncontrada) {
                    datos.deleteRow();
                    
                    System.out.println("\n¡Persona eliminada con éxito!");
                } else {
                    System.out.println("\nNo se encontró ninguna persona con esa cédula.");
                }
            } catch (Exception ex) {
                System.out.println("\n¡Error! No se pudo eliminar la persona.");
            }
        } else {
            System.out.println("¡Error! No hay datos cargados.");
        }
    }
    
    public static void opcionListarPersonas() {
        if (datos != null) {
            System.out.println("\nListado de Personas:\n");
            
            try {
                datos.beforeFirst();
                
                while (datos.next()) {
                    mostrarFilaActual();
                }
            } catch (Exception ex) {
                System.out.println("\n¡Error! No se pudo listar las personas.");
            }
        } else {
            System.out.println("¡Error! No hay datos cargados.");
        }
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
        if (datos != null) {
            try {
                datos.beforeFirst();
                
                String opcion;
                
                do {
                    opcion = mostrarNavegadorPersonas();
                    System.out.println();
                    
                    switch(opcion) {
                        case "s":
                            if (datos.next()) {
                                mostrarFilaActual();
                            } else {
                                datos.afterLast();
                                
                                System.out.println("¡Error! No hay datos.");
                            }
                            
                            break;
                        case "u":
                            if (datos.last()) {
                                mostrarFilaActual();
                            } else {
                                System.out.println("¡Error! No hay datos.");
                            }
                            
                            break;
                        case "p":
                            if (datos.first()) {
                                mostrarFilaActual();
                            } else {
                                System.out.println("¡Error! No hay datos.");
                            }
                            
                            break;
                        case "a":
                            if (datos.previous()) {
                                mostrarFilaActual();
                            } else {
                                datos.beforeFirst();
                                
                                System.out.println("¡Error! No hay datos.");
                            }
                            
                            break;
                        case "t":
                            System.out.println("Volviendo al menú principal...");
                            
                            break;
                        default:
                            System.out.println("¡ERROR! Opción no válida.");
                            
                            break;
                    }
                } while (!opcion.equals("t"));
            } catch (Exception ex) {
                System.out.println("\n¡Error! No se pudo navegar a través de las personas.");
            }
        } else {
            System.out.println("¡Error! No hay datos cargados.");
        }
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
