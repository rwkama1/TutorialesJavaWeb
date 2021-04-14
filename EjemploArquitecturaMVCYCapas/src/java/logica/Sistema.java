/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import compartidos.beans.datatypes.DTEmpleado;
import compartidos.beans.excepciones.ExcepcionPersonalizada;
import compartidos.beans.excepciones.ExcepcionLogica;
import java.util.ArrayList;
import persistencia.FabricaPersistencia;
import persistencia.IPersistencia;

/**
 *
 * @author Raúl
 */
public class Sistema implements ISistema {
    
    private static Sistema instancia = null;
    
    
    public static Sistema getInstancia() {
        if (instancia == null) {
            instancia = new Sistema();
        }
        
        return instancia;
    }
    
    
    private IPersistencia persistencia = FabricaPersistencia.getPersistencia();
    
    
    private Sistema() {
        
    }
    
    
    @Override
    public ArrayList<DTEmpleado> buscarEmpleados(String criterio)
            throws ExcepcionPersonalizada {
        if (criterio == null || criterio.length() == 0) {
            return listarEmpleados();
        }
        
        return persistencia.buscarEmpleados(criterio);
    }
    
    @Override
    public void validarEmpleado(DTEmpleado empleado)
            throws ExcepcionPersonalizada {
        if (empleado == null) {
            throw new ExcepcionLogica("El empleado es nulo.");
        }
        
        if (empleado.getCedula() < 1) {
            throw new ExcepcionLogica("La cédula debe ser mayor o igual a 1.");
        }
        
        if (empleado.getNombre().trim().equals("")) {
            throw new ExcepcionLogica("El nombre no puede quedar vacío.");
        }
        
        if (empleado.getNombre().length() > 50) {
            throw new ExcepcionLogica("El nombre no puede exceder los 50 caracteres de longitud.");
        }
        
        if (empleado.getSueldo() < 0) {
            throw new ExcepcionLogica("El sueldo debe ser mayor o igual a 0.");
        }
    }
    
    @Override
    public void agregarEmpleado(DTEmpleado empleado)
            throws ExcepcionPersonalizada {
        validarEmpleado(empleado);
        
        persistencia.agregarEmpleado(empleado);
    }
    
    @Override
    public DTEmpleado buscarEmpleado(int cedula)
            throws ExcepcionPersonalizada {
        return persistencia.buscarEmpleado(cedula);
    }
    
    @Override
    public void modificarEmpleado(DTEmpleado empleado)
            throws ExcepcionPersonalizada {
        validarEmpleado(empleado);
        
        persistencia.modificarEmpleado(empleado);
    }
    
    @Override
    public void eliminarEmpleado(int cedula)
            throws ExcepcionPersonalizada {
        persistencia.eliminarEmpleado(cedula);
    }
    
    @Override
    public ArrayList<DTEmpleado> listarEmpleados()
            throws ExcepcionPersonalizada {
        return persistencia.listarEmpleados();
    }
    
}
