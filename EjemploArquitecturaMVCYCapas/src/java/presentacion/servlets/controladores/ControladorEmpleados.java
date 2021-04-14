/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.servlets.controladores;

import compartidos.beans.excepciones.ExcepcionPersonalizada;
import compartidos.beans.datatypes.DTEmpleado;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.FabricaLogica;

/**
 *
 * @author Raúl
 */
public class ControladorEmpleados extends Controlador {
    
    @Override
    public void index_get(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<DTEmpleado> empleados = FabricaLogica.getSistema().buscarEmpleados(request.getParameter("buscar"));
            
            request.setAttribute("empleados", empleados);
            cargarMensaje("Cantidad de empleados: " + empleados.size(), request);
        } catch (ExcepcionPersonalizada ex) {
            cargarMensaje("¡ERROR! " + ex.getMessage(), request);
        } catch (Exception ex) {
            cargarMensaje("¡ERROR! Se produjo un error al mostrar los empleados.", request);
        }
        
        mostrarVista("index", request, response);
    }
    
    public void agregar_get(HttpServletRequest request, HttpServletResponse response) {
        mostrarVista("agregar", request, response);
    }
    
    public void agregar_post(HttpServletRequest request, HttpServletResponse response) {
        int cedula = 0;
        
        try {
            cedula = Integer.parseInt(request.getParameter("cedula"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! La cédula no es válida.", request);
            
            mostrarVista("agregar", request, response);
            
            return;
        }
        
        String nombre = request.getParameter("nombre");
        
        double sueldo = 0;
        
        try {
            sueldo = Double.parseDouble(request.getParameter("sueldo"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! El sueldo no es válido.", request);
            
            mostrarVista("agregar", request, response);
            
            return;
        }
        
        DTEmpleado empleado = new DTEmpleado(cedula, nombre, sueldo);
        
        try {
            FabricaLogica.getSistema().agregarEmpleado(empleado);
            
            cargarMensaje("¡Empleado agregado con éxito!", request.getSession());
            
            response.sendRedirect("empleados");
        } catch (ExcepcionPersonalizada ex) {
            cargarMensaje("¡ERROR! " + ex.getMessage(), request);
            
            mostrarVista("agregar", request, response);
        } catch (Exception ex) {
            cargarMensaje("¡ERROR! Se produjo un error al agregar el empleado.", request);
            
            mostrarVista("agregar", request, response);
        }
    }
    
    public void ver_get(HttpServletRequest request, HttpServletResponse response) {
        int cedula;
        
        try {
            cedula = Integer.parseInt(request.getParameter("cedula"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! La cédula no es válida.", request);
            
            mostrarVista("ver", request, response);
            
            return;
        }
        
        try {
            DTEmpleado empleado = FabricaLogica.getSistema().buscarEmpleado(cedula);
            
            if (empleado != null) {
                request.setAttribute("empleado", empleado);
                cargarMensaje("¡Empleado encontrado!", request);
            } else {
                cargarMensaje("¡ERROR! No se encontró ningún empleado con la cédula " + cedula + ".", request);
            }
        } catch (ExcepcionPersonalizada ex) {
            cargarMensaje("¡ERROR! " + ex.getMessage(), request);
        } catch (Exception ex) {
            cargarMensaje("¡ERROR! Se produjo un error al buscar el empleado.", request);
        }
        
        mostrarVista("ver", request, response);
    }
    
    public void modificar_get(HttpServletRequest request, HttpServletResponse response) {
        int cedula;
        
        try {
            cedula = Integer.parseInt(request.getParameter("cedula"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! La cédula no es válida.", request);
            
            mostrarVista("modificar", request, response);
            
            return;
        }
        
        try {
            DTEmpleado empleado = FabricaLogica.getSistema().buscarEmpleado(cedula);
            
            if (empleado != null) {
                request.setAttribute("empleado", empleado);
                cargarMensaje("¡Empleado encontrado!", request);
            } else {
                request.setAttribute("ocultarFormulario", true);
                cargarMensaje("¡ERROR! No se encontró ningún empleado con la cédula " + cedula + ".", request);
            }
        } catch (ExcepcionPersonalizada ex) {
            cargarMensaje("¡ERROR! " + ex.getMessage(), request);
        } catch (Exception ex) {
            cargarMensaje("¡ERROR! Se produjo un error al buscar el empleado.", request);
        }
        
        mostrarVista("modificar", request, response);
    }
    
    public void modificar_post(HttpServletRequest request, HttpServletResponse response) {
        int cedula;
        
        try {
            cedula = Integer.parseInt(request.getParameter("cedula"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! La cédula no es válida.", request);
            
            mostrarVista("modificar", request, response);
            
            return;
        }
        
        String nombre = request.getParameter("nombre");
        
        double sueldo;
        
        try {
            sueldo = Double.parseDouble(request.getParameter("sueldo"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! El sueldo no es válido.", request);
            
            mostrarVista("modificar", request, response);
            
            return;
        }
        
        DTEmpleado empleado = new DTEmpleado(cedula, nombre, sueldo);
        
        try {
            FabricaLogica.getSistema().modificarEmpleado(empleado);
            
            cargarMensaje("¡Empleado modificado con éxito!", request.getSession());
            
            response.sendRedirect("empleados");
        } catch (ExcepcionPersonalizada ex) {
            cargarMensaje("¡ERROR! " + ex.getMessage(), request);
            
            mostrarVista("modificar", request, response);
        } catch (Exception ex) {
            cargarMensaje("¡ERROR! Se produjo un error al modificar el empleado.", request);
            
            mostrarVista("modificar", request, response);
        }
    }
    
    public void eliminar_get(HttpServletRequest request, HttpServletResponse response) {
        int cedula;
        
        try {
            cedula = Integer.parseInt(request.getParameter("cedula"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! La cédula no es válida.", request);
            
            mostrarVista("eliminar", request, response);
            
            return;
        }
        
        try {
            DTEmpleado empleado = FabricaLogica.getSistema().buscarEmpleado(cedula);
            
            if (empleado != null) {
                request.setAttribute("empleado", empleado);
                cargarMensaje("¡Empleado encontrado!", request);
            } else {
                cargarMensaje("¡ERROR! No se encontró ningún empleado con la cédula " + cedula + ".", request);
            }
        } catch (ExcepcionPersonalizada ex) {
            cargarMensaje("¡ERROR! " + ex.getMessage(), request);
        } catch (Exception ex) {
            cargarMensaje("¡ERROR! Se produjo un error al buscar el empleado.", request);
        }
        
        mostrarVista("eliminar", request, response);
    }
    
    public void eliminar_post(HttpServletRequest request, HttpServletResponse response) {
        int cedula;
        
        try {
            cedula = Integer.parseInt(request.getParameter("cedula"));
        } catch (NumberFormatException ex) {
            cargarMensaje("¡ERROR! La cédula no es válida.", request);
            
            mostrarVista("eliminar", request, response);
            
            return;
        }
        
        try {
            FabricaLogica.getSistema().eliminarEmpleado(cedula);
            
            cargarMensaje("¡Empleado eliminado con éxito!", request.getSession());
            
            response.sendRedirect("empleados");
        } catch (ExcepcionPersonalizada ex) {
            cargarMensaje("¡ERROR! " + ex.getMessage(), request);
            
            mostrarVista("eliminar", request, response);
        } catch (Exception ex) {
            cargarMensaje("¡ERROR! Se produjo un error al eliminar el empleado.", request);
            
            mostrarVista("eliminar", request, response);
        }
    }
    
}
