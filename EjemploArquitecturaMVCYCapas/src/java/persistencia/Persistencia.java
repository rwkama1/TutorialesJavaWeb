/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import compartidos.beans.datatypes.DTEmpleado;
import compartidos.beans.excepciones.ExcepcionPersonalizada;
import compartidos.beans.excepciones.ExcepcionPersistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Raúl
 */
public class Persistencia implements IPersistencia {
    
    private static Persistencia instancia = null;
    
    
    public static Persistencia getInstancia() {
        if (instancia == null) {
            instancia = new Persistencia();
        }
        
        return instancia;
    }
    
    
    private Persistencia() {
        
    }
    
    
    @Override
    public ArrayList<DTEmpleado> buscarEmpleados(String criterio)
            throws ExcepcionPersonalizada {
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            conexion = UtilidadesPersistencia.getConexion();
            
            consulta = conexion.prepareStatement("SELECT * FROM Empleados WHERE Cedula = ? OR Nombre LIKE ?;");
            
            consulta.setString(1, criterio);
            consulta.setString(2, "%" + criterio + "%");
            
            resultadoConsulta = consulta.executeQuery();
            
            ArrayList<DTEmpleado> empleados = new ArrayList();
            DTEmpleado empleado;
            
            int cedula;
            String nombre;
            double sueldo;
            
            while (resultadoConsulta.next()) {
                cedula = resultadoConsulta.getInt("Cedula");
                nombre = resultadoConsulta.getString("Nombre");
                sueldo = resultadoConsulta.getDouble("Sueldo");
                
                empleado = new DTEmpleado(cedula, nombre, sueldo);
                empleados.add(empleado);
            }
            
            return empleados;
        } catch (Exception ex) {
            throw new ExcepcionPersistencia("No se pudo buscar los empleados.", ex);
        } finally {
            UtilidadesPersistencia.cerrarRecursos(resultadoConsulta, consulta, conexion);
        }
    }
    
    @Override
    public void agregarEmpleado(DTEmpleado empleado)
            throws ExcepcionPersonalizada {
        Connection conexion = null;
        PreparedStatement consulta = null;
        
        try {
            conexion = UtilidadesPersistencia.getConexion();
            
            consulta = conexion.prepareStatement("INSERT INTO Empleados VALUES (?, ?, ?);");
            
            consulta.setInt(1, empleado.getCedula());
            consulta.setString(2, empleado.getNombre());
            consulta.setDouble(3, empleado.getSueldo());
            
            int filasAfectadas = consulta.executeUpdate();
            
            if (filasAfectadas < 1) {
                throw new Exception();
            }
        } catch (ExcepcionPersonalizada ex) {
            throw ex;
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                throw new ExcepcionPersistencia("El empleado ya existe.", ex);
            } else {
                throw new ExcepcionPersistencia("No se pudo agregar el empleado.", ex);
            }
        } catch (Exception ex) {
            throw new ExcepcionPersistencia("No se pudo agregar el empleado.", ex);
        } finally {
            UtilidadesPersistencia.cerrarRecursos(consulta, conexion);
        }
    }
    
    @Override
    public DTEmpleado buscarEmpleado(int cedula)
            throws ExcepcionPersonalizada {
        Connection conexion = null;
        PreparedStatement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            conexion = UtilidadesPersistencia.getConexion();
            
            consulta = conexion.prepareStatement("SELECT * FROM Empleados WHERE Cedula = ?;");
            
            consulta.setInt(1, cedula);
            
            resultadoConsulta = consulta.executeQuery();
            
            DTEmpleado empleado = null;
            
            String nombre;
            double sueldo;
            
            if (resultadoConsulta.next()) {
                nombre = resultadoConsulta.getString("Nombre");
                sueldo = resultadoConsulta.getDouble("Sueldo");
                
                empleado = new DTEmpleado(cedula, nombre, sueldo);
            }
            
            return empleado;
        } catch (Exception ex) {
            throw new ExcepcionPersistencia("No se pudo buscar el empleado.", ex);
        } finally {
            UtilidadesPersistencia.cerrarRecursos(resultadoConsulta, consulta, conexion);
        }
    }
    
    @Override
    public void modificarEmpleado(DTEmpleado empleado)
            throws ExcepcionPersonalizada {
        Connection conexion = null;
        PreparedStatement consulta = null;
        
        try {
            conexion = UtilidadesPersistencia.getConexion();
            
            consulta = conexion.prepareStatement("UPDATE Empleados SET Nombre = ?, Sueldo = ? WHERE Cedula = ?;");
            
            consulta.setString(1, empleado.getNombre());
            consulta.setDouble(2, empleado.getSueldo());
            consulta.setInt(3, empleado.getCedula());
            
            int filasAfectadas = consulta.executeUpdate();
            
            if (filasAfectadas < 1) {
                throw new Exception();
            }
        } catch (ExcepcionPersonalizada ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ExcepcionPersistencia("No se pudo modificar el empleado.", ex);
        } finally {
            UtilidadesPersistencia.cerrarRecursos(consulta, conexion);
        }
    }
    
    @Override
    public void eliminarEmpleado(int cedula)
            throws ExcepcionPersonalizada {
        Connection conexion = null;
        PreparedStatement consulta = null;
        
        try {
            conexion = UtilidadesPersistencia.getConexion();
            
            consulta = conexion.prepareStatement("DELETE FROM Empleados WHERE Cedula = ?;");
            
            consulta.setInt(1, cedula);
            
            int filasAfectadas = consulta.executeUpdate();
            
            if (filasAfectadas < 1) {
                throw new Exception();
            }
        } catch (ExcepcionPersonalizada ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ExcepcionPersistencia("No se pudo eliminar el empleado.", ex);
        } finally {
            UtilidadesPersistencia.cerrarRecursos(consulta, conexion);
        }
    }
    
    @Override
    public ArrayList<DTEmpleado> listarEmpleados()
            throws ExcepcionPersonalizada {
        Connection conexion = null;
        Statement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            conexion = UtilidadesPersistencia.getConexion();
            
            consulta = conexion.createStatement();
            
            resultadoConsulta = consulta.executeQuery("SELECT * FROM Empleados;");
            
            ArrayList<DTEmpleado> empleados = new ArrayList();
            DTEmpleado empleado;
            
            int cedula;
            String nombre;
            double sueldo;
            
            while (resultadoConsulta.next()) {
                cedula = resultadoConsulta.getInt("Cedula");
                nombre = resultadoConsulta.getString("Nombre");
                sueldo = resultadoConsulta.getDouble("Sueldo");
                
                empleado = new DTEmpleado(cedula, nombre, sueldo);
                empleados.add(empleado);
            }
            
            return empleados;
        } catch (Exception ex) {
            throw new ExcepcionPersistencia("No se pudo listar los empleados.", ex);
        } finally {
            UtilidadesPersistencia.cerrarRecursos(resultadoConsulta, consulta, conexion);
        }
    }
    
}
