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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sistemas
 */
public class EjemploJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try
        {
            Class.forName("com.mysql.jdbc.Driver")/*.newInstance()*/;
        }
        catch(Exception ex)
        {
            System.out.println("Error Ocurrio un error al instanciar el driver de Mysql");
        }
//        agregarEmpleado();
//        agregarEmpleadoConTelefonos();
//        modificarEmpleado();
//        eliminarEmpleado();
        
//       ListarEmpleado();
//        ObtenerMayorSueldo();
        BuscarNombreEmpleado();
        
        // TODO code application logic here
    }
    private static void agregarEmpleado()
    {
        Connection conexion =null;
        Statement consulta=null;
        try{
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "password");
            consulta=conexion.createStatement();
            int filasAfectadas=consulta.executeUpdate("Insert into Empleados values(4,'María José', 25, 2700, 0);");
            if(filasAfectadas==1)
            {System.out.println("Empleado agregado con exito");}
            else
            {System.out.println("Error, ocurrio un error al agregar empleado.");}
        }
    
        catch(Exception ex)
        {System.out.println("Error, Ocurrio un error al agregar el empleado");}
                   
        
    finally{
        try
    {
        if(consulta!=null)
        {consulta.close();}
        if(conexion!=null)
        {
            conexion.close();
        }
    }
        catch(Exception ex)
        {System.out.println("Error Ocurrio, un error al cerrar los recursos");}
    }
}
    private static void agregarEmpleado2()
    {
        try(Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "password");
                Statement consulta=conexion.createStatement()){
                int filasAfectadas=consulta.executeUpdate("Insert into Empleados values(4,'María José', 25, 2700, 0);");             
            if(filasAfectadas==1)
            {System.out.println("Empleado agregado con exito");}
            else
            {System.out.println("Error, ocurrio un error al agregar empleado.");}
        
    }
        catch(Exception ex)
        {System.out.println("Error,Ocurrio un error al agregar el empleado");}
   
    }
    private static void agregarEmpleadoConTelefonos(){
        
         try(Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root" , "password");
                Statement consulta=conexion.createStatement())
             
        {
            try
            {
                conexion.setAutoCommit(false);
                consulta.executeUpdate("Insert into Empleados values(5,'Arturo', 35,1500,0)");
                consulta.executeUpdate("Insert into Telefonos values(null,55555551,5)");
                 consulta.executeUpdate("Insert into Telefonos values(null,55555552,5)");
                 conexion.commit();
                 System.out.println("Empleado agregado con exito");
                 
            }
            catch(Exception ex)
            {
                try{
                if(conexion!=null)
                {
                    conexion.rollback();
                }
            }
            catch(Exception exR)
            {System.out.println("Error Ocurrio un error al deshacer los cambios");}
            System.out.println("Error,Ocurrio un error al agrega el empleado");
        }
        }catch(Exception ex)
        {
            System.out.println("Error,Ocurrio un error al agregar el Empleado.");
        }
    }
    private static void modificarEmpleado() 
    {
        try(Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "password");
                PreparedStatement consulta=conexion.prepareStatement("Update Empleados set Nombre=? where Cedula = ?;"))
        {
            consulta.setString(1, "María Pía");
            consulta.setLong(2,3);
            int filasAfectadas=consulta.executeUpdate();
            if(filasAfectadas==1)
            {
                System.out.println("Empleado modificado con exito");
                
            }
            else
            {
                System.out.println("Error,Ocurrio un error al modificar el Empleado");
            }
            
        }
        catch(Exception ex)
        {
            System.out.println("Error,Ocurrio un error al modificar el empleado");
        }
        
    }
    private static void eliminarEmpleado() 
    {
        try(Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "password");
                CallableStatement consulta= conexion.prepareCall("{CALL EliminarEmpleado(?, ?) }"))
        {
            consulta.setLong(1, 1);
            consulta.registerOutParameter(2, java.sql.Types.VARCHAR);
            consulta.executeUpdate();
            String error= consulta.getString(2);
            if(error==null)
            {
                System.out.println("Empleado eliminado con exito");
            }else
            {
                System.out.println("ERROR " + error);
            }
        }
        catch(Exception ex)
        {
            System.out.println("ERROR, Ocurrio un error al eliminar el empleado");
        }
    }
      private static void ListarEmpleado()
           {
               try(Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "password");
                CallableStatement consulta= conexion.prepareCall("{CALL ListarTodos() }");
                       ResultSet resultadoConsulta=consulta.executeQuery()){
                   System.out.println();
                   long cedula;
                   String nombre;
                   Double sueldo;
                   Integer edad;
                   Boolean casado;
                   while(resultadoConsulta.next())
                   {
                       cedula=resultadoConsulta.getLong(1);
                       nombre=resultadoConsulta.getString("Nombre");
                       sueldo=(Double)resultadoConsulta.getObject("Sueldo"); //Double con D mayuscula para que admita null                  
                       edad=(Integer)resultadoConsulta.getObject("Edad");//lo mismo para Integer
                       //se puede leer con getObject te devuelve Object y por eso hay que castear
                       //La ventaja con el GetObject no es necesario poner wasNull y verificar en cada linea
                       //en Casado se ve que no esta hecho con getObject entonces hay que verificar con wasNull
                       casado=resultadoConsulta.getBoolean("Casado");
                       casado=resultadoConsulta.wasNull() ? null : casado;
                       System.out.println("Cedula: "+cedula+", Nombre: "+ nombre +
                               ", Sueldo: "+( sueldo!= null ? sueldo :"N/D")+
                               ", Edad: "+(edad!=null ? edad :"N/D")+", Casado: "+
                       (casado!=null?casado? "SI":"NO":"N/D"));
                   }
                   
               System.out.println();
               }
               catch(Exception ex)
               {
                   System.out.println("Error Ocurrio un error al Listar los Empleados");
               }
               
           }
private static  void ObtenerMayorSueldo()
{
     try(Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "password");
                CallableStatement consulta= conexion.prepareCall("{CALL ObtenerMayorSueldo(?) }"))
     {
         consulta.registerOutParameter(1, java.sql.Types.DOUBLE);
         consulta.executeUpdate();
         double mayorSueldo=consulta.getDouble(1);
         System.out.println("Mayor Sueldo: "+ mayorSueldo);
     }
     catch(Exception ex)
     {
         System.out.println("Error, Ocurrio un error al obtener el mayor sueldo");
     }
}
private static void BuscarNombreEmpleado()
{
         try(Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/EjemploJDBC", "root", "rwkama");
                CallableStatement consulta= conexion.prepareCall("{ ?= CALL Buscar(?) }"))
         {
             consulta.registerOutParameter(1, java.sql.Types.VARCHAR);
             consulta.setLong(2, 2);
             consulta.executeUpdate();
             String nombre=consulta.getString(1);
             System.out.println("Nombre del empleado con Cedula 5: "+ nombre);
         }
         catch(Exception ex)
         {
             System.out.println("Error Ocurrio un error al obtener el nombre del empleado");
         }
                 
        
    
             }

}
