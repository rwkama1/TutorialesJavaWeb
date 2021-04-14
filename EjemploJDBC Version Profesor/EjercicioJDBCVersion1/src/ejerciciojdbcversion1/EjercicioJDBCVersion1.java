/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciojdbcversion1;

import java.sql.CallableStatement;
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
    
    public static void mostrarFilaActual(ResultSet datos) throws SQLException {
        long cedula = datos.getLong("Cedula");
        String nombre = datos.getString("Nombre");
        int edad = datos.getInt("Edad");
        boolean casado = datos.getBoolean("Casado");
        double sueldo = datos.getDouble("Sueldo");
        
        System.out.println("Cédula: " + cedula + ", Nombre: " + nombre + ", Edad: " + edad + ", Casado/a: " + (casado ? "Sí" : "No") + ", Sueldo: " + sueldo);
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
        Scanner teclado = new Scanner(System.in);
        
        long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
        
        System.out.print("Ingrese el nombre: ");
        String nombre = teclado.nextLine();
        
        int edad = pedirNumeroEntero("Ingrese la edad: ", "\n¡Error! La edad no es un número entero válido.\n");
        
        System.out.print("¿Está casado/a? (s/n): ");
        boolean casado = teclado.nextLine().trim().toLowerCase().equals("s");
        
        double sueldo = pedirNumeroDecimal("Ingrese el sueldo: ", "\n¡Error! El sueldo no es un número decimal válido.\n");
        
        try (PreparedStatement consulta = conexion.prepareStatement("INSERT INTO Personas VALUES (?, ?, ?, ?, ?);")) {
            consulta.setLong(1, cedula);
            consulta.setString(2, nombre);
            consulta.setInt(3, edad);
            consulta.setBoolean(4, casado);
            consulta.setDouble(5, sueldo);
            
            consulta.executeUpdate();
            
            System.out.println("\n¡Persona agregada con éxito!");
        } /*catch (SQLException ex) {
            System.out.println("Mensaje de error SQL: " + ex.getMessage());
            System.out.println("Código de error SQL: " + ex.getErrorCode());
            System.out.println("Estado SQL: " + ex.getSQLState());
        }*/ catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo agregar la persona.");
        }
    }
    
    public static void opcionBuscarPersona() {
        long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
        
        PreparedStatement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            consulta = conexion.prepareStatement("SELECT * FROM Personas WHERE Cedula = ?;");
            consulta.setLong(1, cedula);
            
            resultadoConsulta = consulta.executeQuery();
            
            if (resultadoConsulta.next()) {
                System.out.println("\n\nPersona Encontrada:\n");
                
                mostrarFilaActual(resultadoConsulta);
            } else {
                System.out.println("\n\nNo se encontró ninguna persona con esa cédula.");
            }
        } catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo buscar la persona.");
        } finally {
            try {
                if (resultadoConsulta != null) {
                    resultadoConsulta.close();
                }
                
                if (consulta != null) {
                    consulta.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    public static void opcionActualizarDatosPersona() {
        Scanner teclado = new Scanner(System.in);
        
        long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
        
        PreparedStatement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            consulta = conexion.prepareStatement("SELECT * FROM Personas WHERE Cedula = ?;");
            consulta.setLong(1, cedula);
            
            resultadoConsulta = consulta.executeQuery();
            
            if (resultadoConsulta.next()) {
                System.out.print("Ingrese el nombre: ");
                String nombre = teclado.nextLine();
                
                int edad = pedirNumeroEntero("Ingrese la edad: ", "\n¡Error! La edad no es un número entero válido.\n");
                
                System.out.print("¿Está casado/a? (s/n): ");
                boolean casado = teclado.nextLine().trim().toLowerCase().equals("s");
                
                double sueldo = pedirNumeroDecimal("Ingrese el sueldo: ", "\n¡Error! El sueldo no es un número decimal válido.\n");
                
                consulta.close();
                
                try (PreparedStatement otraConsulta = conexion.prepareStatement("UPDATE Personas SET Nombre = ?, Edad = ?, Casado = ?, Sueldo = ? WHERE Cedula = ?;")) {
                    otraConsulta.setString(1, nombre);
                    otraConsulta.setInt(2, edad);
                    otraConsulta.setBoolean(3, casado);
                    otraConsulta.setDouble(4, sueldo);
                    otraConsulta.setLong(5, cedula);
                    
                    otraConsulta.executeUpdate();
                    
                    System.out.println("\n¡Persona actualizada con éxito!");
                }
            } else {
                System.out.println("\nNo se encontró ninguna persona con esa cédula.");
            }
        } catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo actualizar la persona.");
        } finally {
            try {
                if (resultadoConsulta != null) {
                    resultadoConsulta.close();
                }
                
                if (consulta != null) {
                    consulta.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    public static void opcionEliminarPersona() {
        long cedula = pedirNumeroEntero("Ingrese la cédula: ", "\n¡Error! La cédula no es un número entero válido.\n");
        
        CallableStatement consulta = null;
        
        try {
            consulta = conexion.prepareCall("{ CALL EliminarPersona(?) }");
            consulta.setLong(1, cedula);
            
            int filasAfectadas = consulta.executeUpdate();
            
            if (filasAfectadas == 1) {
                System.out.println("\n¡Persona eliminada con éxito!");
            } else {
                System.out.println("\nNo se encontró ninguna persona con esa cédula.");
            }
        } catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo eliminar la persona.");
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    public static void opcionListarPersonas() {
        try (Statement consulta = conexion.createStatement();
                ResultSet resultadoConsulta = consulta.executeQuery("SELECT * FROM Personas;")) {
            System.out.println("\nListado de Personas:\n");
            
            while (resultadoConsulta.next()) {
                mostrarFilaActual(resultadoConsulta);
            }
        } catch (Exception ex) {
            System.out.println("\n¡Error! No se pudo listar las personas.");
        }
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
