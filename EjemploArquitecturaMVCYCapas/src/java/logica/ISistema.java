/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import compartidos.beans.datatypes.DTEmpleado;
import compartidos.beans.excepciones.ExcepcionPersonalizada;
import java.util.ArrayList;

/**
 *
 * @author Raúl
 */
public interface ISistema {
    
    ArrayList<DTEmpleado> buscarEmpleados(String criterio) throws ExcepcionPersonalizada;
    void validarEmpleado(DTEmpleado empleado) throws ExcepcionPersonalizada;
    void agregarEmpleado(DTEmpleado empleado) throws ExcepcionPersonalizada;
    DTEmpleado buscarEmpleado(int cedula) throws ExcepcionPersonalizada;
    void modificarEmpleado(DTEmpleado empleado) throws ExcepcionPersonalizada;
    void eliminarEmpleado(int cedula) throws ExcepcionPersonalizada;
    ArrayList<DTEmpleado> listarEmpleados() throws ExcepcionPersonalizada;
    
}
