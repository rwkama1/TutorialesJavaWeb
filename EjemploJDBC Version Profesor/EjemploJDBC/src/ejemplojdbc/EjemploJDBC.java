/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Raúl
 */
public class EjemploJDBC {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver")/*.newInstance()*/;
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al instanciar el driver de MySQL.");
        }
        
        //agregarEmpleado();
        //agregarEmpleadoConTelefonos();
        //modificarEmpleado();
        //eliminarEmpleado();
        //listarEmpleados();
        //obtenerMayorSueldo();
        //buscarNombreEmpleado();
    }
    
    private static void agregarEmpleado() {
        Connection conexion = null;
        Statement consulta = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
            
            consulta = conexion.createStatement();
            
            int filasAfectadas = consulta.executeUpdate("INSERT INTO Empleados VALUES (4, 'María José', 25, 2700, 0);");
            
            if (filasAfectadas == 1) {
                System.out.println("Empleado agregado con éxito.");
            } else {
                System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    private static void agregarEmpleado2() {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
                Statement consulta = conexion.createStatement()) {
            int filasAfectadas = consulta.executeUpdate("INSERT INTO Empleados VALUES (4, 'María José', 25, 2700, 0);");
            
            if (filasAfectadas == 1) {
                System.out.println("Empleado agregado con éxito.");
            } else {
                System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
        }
    }
    
    private static void agregarEmpleadoConTelefonos() {
        Connection conexion = null;
        Statement consulta = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
            conexion.setAutoCommit(false);
            
            consulta = conexion.createStatement();
            
            consulta.executeUpdate("INSERT INTO Empleados VALUES (5, 'Arturo', 35, 1500, 1);");
            consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL, 55555551, 5);");
            
            /*if (true) {
                throw new Exception();
            }*/
            
            consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL, 55555552, 5);");
            
            conexion.commit();
            
            System.out.println("Empleado agregado con éxito.");
        } catch (Exception ex) {
            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (Exception exR) {
                System.out.println("¡ERROR! Ocurrió un error al deshacer los cambios.");
            }
            
            System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    private static void agregarEmpleadoConTelefonos2() {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
                Statement consulta = conexion.createStatement()) {
            try {
                conexion.setAutoCommit(false);
                
                consulta.executeUpdate("INSERT INTO Empleados VALUES (5, 'Arturo', 35, 1500, 1);");
                consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL, 55555551, 5);");
                consulta.executeUpdate("INSERT INTO Telefonos VALUES (NULL, 55555552, 5);");
                
                conexion.commit();
                
                System.out.println("Empleado agregado con éxito.");
            } catch (Exception ex) {
                try {
                    if (conexion != null) {
                        conexion.rollback();
                    }
                } catch (Exception exR) {
                    System.out.println("¡ERROR! Ocurrió un error al deshacer los cambios.");
                }
                
                System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
        }
    }
    
    private static void modificarEmpleado() {
        Connection conexion = null;
        PreparedStatement consulta = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
            
            consulta = conexion.prepareStatement("UPDATE Empleados SET Nombre = ? WHERE Cedula = ?;");
            consulta.setString(1, "María Pía");
            consulta.setLong(2, 4);
            
            int filasAfectadas = consulta.executeUpdate();
            
            if (filasAfectadas == 1) {
                System.out.println("Empleado modificado con éxito.");
            } else {
                System.out.println("¡ERROR! Ocurrió un error al modificar el empleado.");
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al modificar el empleado.");
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    private static void modificarEmpleado2() {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
                PreparedStatement consulta = conexion.prepareStatement("UPDATE Empleados SET Nombre = ? WHERE Cedula = ?;")) {
            consulta.setString(1, "María Pía");
            consulta.setLong(2, 4);
            
            int filasAfectadas = consulta.executeUpdate();
            
            if (filasAfectadas == 1) {
                System.out.println("Empleado modificado con éxito.");
            } else {
                System.out.println("¡ERROR! Ocurrió un error al modificar el empleado.");
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al modificar el empleado.");
        }
    }
    
    private static void eliminarEmpleado() {
        Connection conexion = null;
        CallableStatement consulta = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
            
            consulta = conexion.prepareCall("{ CALL EliminarEmpleado(?, ?) }");
            consulta.setLong(1, 4);
            consulta.registerOutParameter(2, java.sql.Types.VARCHAR);
            
            consulta.executeUpdate();
            
            String error = consulta.getString(2);
            
            if (error == null) {
                System.out.println("Empleado eliminado con éxito.");
            } else {
                System.out.println("¡ERROR! " + error);
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al eliminar el empleado.");
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    private static void eliminarEmpleado2() {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
                CallableStatement consulta = conexion.prepareCall("{ CALL EliminarEmpleado(?, ?) }")) {
            consulta.setLong(1, 4);
            consulta.registerOutParameter(2, java.sql.Types.VARCHAR);
            
            consulta.executeUpdate();
            
            String error = consulta.getString(2);
            
            if (error == null) {
                System.out.println("Empleado eliminado con éxito.");
            } else {
                System.out.println("¡ERROR! " + error);
            }
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al eliminar el empleado.");
        }
    }
    
    private static void listarEmpleados() {
        Connection conexion = null;
        CallableStatement consulta = null;
        ResultSet resultadoConsulta = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
            
            consulta = conexion.prepareCall("{ CALL ListarTodos() }");
            
            resultadoConsulta = consulta.executeQuery();
            
            System.out.println();
            
            long cedula;
            String nombre;
            Integer edad;
            Double sueldo;
            Boolean casado; // Tipos de datos con inicial en mayúscula para que admitan null.
            
            while (resultadoConsulta.next()) {
                cedula = resultadoConsulta.getLong(1);
                nombre = resultadoConsulta.getString("Nombre");
                edad = (Integer)resultadoConsulta.getObject("Edad");
                sueldo = (Double)resultadoConsulta.getObject("Sueldo");
                casado = resultadoConsulta.getBoolean("Casado");
                
                if (casado == false) {
                    casado = resultadoConsulta.wasNull() ? null : casado;
                }
                
                System.out.println("Cédula: " + cedula + ", Nombre: " + nombre + ", Edad: " + (edad != null ? edad : "N/D") + ", Sueldo: " + (sueldo != null ? sueldo : "N/D") + ", Casado: " + (casado != null ? casado ? "Sí" : "No" : "N/D"));
            }
            
            System.out.println();
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al listar los empleados.");
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
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    private static void listarEmpleados2() {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
                CallableStatement consulta = conexion.prepareCall("{ CALL ListarTodos() }");
                ResultSet resultadoConsulta = consulta.executeQuery()) {
            System.out.println();
            
            long cedula;
            String nombre;
            Double sueldo;
            Integer edad;
            Boolean casado; // Boolean con B mayúscula para que admita null.
            
            while (resultadoConsulta.next()) {
                cedula = resultadoConsulta.getLong(1);
                nombre = resultadoConsulta.getString("Nombre");
                sueldo = (Double)resultadoConsulta.getObject("Sueldo");
                edad = (Integer)resultadoConsulta.getObject("Edad");
                casado = resultadoConsulta.getBoolean("Casado");
                
                if (casado == false) {
                    casado = resultadoConsulta.wasNull() ? null : casado;
                }
                
                System.out.println("Cédula: " + cedula + ", Nombre: " + nombre + ", Sueldo: " + (sueldo != null ? sueldo : "N/D") + ", Edad: " + (edad != null ? edad : "N/D") + ", Casado: " + (casado != null ? casado ? "Sí" : "No" : "N/D"));
            }
            
            System.out.println();
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al listar los empleados.");
        }
    }
    
    private static void obtenerMayorSueldo() {
        Connection conexion = null;
        CallableStatement consulta = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
            
            consulta = conexion.prepareCall("{ CALL ObtenerMayorSueldo(?) }");
            consulta.registerOutParameter(1, java.sql.Types.DOUBLE);
            
            consulta.executeUpdate();
            
            double mayorSueldo = consulta.getDouble(1);
            
            System.out.println("Mayor sueldo: " + mayorSueldo);
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al obtener el mayor sueldo.");
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    private static void obtenerMayorSueldo2() {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
                CallableStatement consulta = conexion.prepareCall("{ CALL ObtenerMayorSueldo(?) }")) {
            consulta.registerOutParameter(1, java.sql.Types.DOUBLE);
            
            consulta.executeUpdate();
            
            double mayorSueldo = consulta.getDouble(1);
            
            System.out.println("Mayor sueldo: " + mayorSueldo);
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al obtener el mayor sueldo.");
        }
    }
    
    private static void buscarNombreEmpleado() {
        Connection conexion = null;
        CallableStatement consulta = null;
        
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
            
            consulta = conexion.prepareCall("{ ? = CALL Buscar(?) }");
            consulta.registerOutParameter(1, java.sql.Types.VARCHAR);
            consulta.setLong(2, 5);
            
            consulta.executeUpdate();
            
            String nombre = consulta.getString(1);
            
            System.out.println("Nombre del empleado con cédula 5: " + nombre);
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al obtener el nombre del empleado.");
        } finally {
            try {
                if (consulta != null) {
                    consulta.close();
                }
                
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al cerrar los recursos.");
            }
        }
    }
    
    private static void buscarNombreEmpleado2() {
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "root");
                CallableStatement consulta = conexion.prepareCall("{ ? = CALL Buscar(?) }")) {
            consulta.registerOutParameter(1, java.sql.Types.VARCHAR);
            consulta.setLong(2, 5);
            
            consulta.executeUpdate();
            
            String nombre = consulta.getString(1);
            
            System.out.println("Nombre del empleado con cédula 5: " + nombre);
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al obtener el nombre del empleado.");
        }
    }
    
}
