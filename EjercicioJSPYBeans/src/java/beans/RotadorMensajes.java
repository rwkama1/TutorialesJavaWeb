/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Raúl
 */
public class RotadorMensajes implements Serializable {
    
    private static ArrayList<String> mensajes;
    
    
    static {
        Connection conexion = null;
        Statement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            mensajes = new ArrayList();
            
            /*mensajes.add("No soy un completo inútil. Por lo menos sirvo de mal ejemplo.");
            mensajes.add("Lo importante no es saber, sino tener el teléfono del que sabe.");
            mensajes.add("Tener la conciencia limpia es síntoma de mala memoria.");
            mensajes.add("Errar es humano, pero echarle la culpa a otro es mas humano todavía.");
            mensajes.add("No te tomes la vida en serio, al fin y al cabo no saldrás vivo de ella.");*/
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjercicioJSPYBeans", "root", "password");
            
            consulta = conexion.createStatement();
            resultadoConsulta = consulta.executeQuery("SELECT * FROM Mensajes;");
            
            while (resultadoConsulta.next()) {
                mensajes.add(resultadoConsulta.getString("Mensaje"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("¡ERROR! No se pudo instanciar el driver.");
        } catch (SQLException ex) {
            System.out.println("¡ERROR! Se produjo un error con la base de datos.");
        } finally {
            try {
                if (resultadoConsulta != null) {
                    resultadoConsulta.close();
                }
                
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Se produjo un error al cerrar los recursos.");
            }
        }
    }
    
    
    private int indiceActual;
    
    
    public String getMensaje() {
        String mensaje;
        
        if (mensajes.size() > 0) {
            mensaje = mensajes.get(indiceActual);
            indiceActual = indiceActual < mensajes.size() - 1 ? indiceActual + 1 : 0;
        } else {
            mensaje = "¡ERROR! No hay mensajes para mostrar.";
        }
        
        return mensaje;
    }
    
    
    public RotadorMensajes() {
        indiceActual = 0;
    }
    
}
