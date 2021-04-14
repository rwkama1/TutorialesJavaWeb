/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplojpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Raúl
 */
public class EjemploJPA {
    
    private static EntityManagerFactory fabricaGestorEntidades;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fabricaGestorEntidades = Persistence.createEntityManagerFactory("UnidadPersistencia");
        
//        agregarEmpleado();
//        agregarEmpleadoConTelefonos();
        //modificarEmpleado();
        //eliminarEmpleado();
//        listarEmpleados();
//        obtenerMayorSueldo();
        buscarNombreEmpleado();
    }
    
    private static void agregarEmpleado() {
        EntityTransaction transaccion = null;
        
        try {
            EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
            transaccion = gestorEntidades.getTransaction();
            
            Empleado empleado = new Empleado(4, "María José", 25, 2700.0, false);
            
            transaccion.begin();
            
            gestorEntidades.persist(empleado);
            
            transaccion.commit();
            
            System.out.println("Empleado agregado con éxito.");
        } catch (Exception ex) {
            try {
                if (transaccion != null && transaccion.isActive()) {
                    transaccion.rollback();
                }
            } catch (Exception exR) {
                System.out.println("¡ERROR! Ocurrió un error al deshacer los cambios.");
            }
            
            System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
        }
    }
    
    private static void agregarEmpleadoConTelefonos() {
        EntityTransaction transaccion = null;
        
        try {
            EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
            transaccion = gestorEntidades.getTransaction();
            
            Empleado empleado = new Empleado(5, "Arturo", 35, 1500.0, true);
            empleado.getTelefonos().add(new Telefono("55555551", empleado));
            empleado.getTelefonos().add(new Telefono("55555552", empleado));
            
            transaccion.begin();
            
            gestorEntidades.persist(empleado);
            
            transaccion.commit();
            
            System.out.println("Empleado agregado con éxito.");
        } catch (Exception ex) {
            try {
                if (transaccion != null && transaccion.isActive()) {
                    transaccion.rollback();
                }
            } catch (Exception exR) {
                System.out.println("¡ERROR! Ocurrió un error al deshacer los cambios.");
            }
            
            System.out.println("¡ERROR! Ocurrió un error al agregar el empleado.");
        }
    }
    
    private static void modificarEmpleado() {
        EntityTransaction transaccion = null;
        
        try {
            EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
            transaccion = gestorEntidades.getTransaction();
            
            Empleado empleado = gestorEntidades.find(Empleado.class, 4L);
            
            transaccion.begin();
            
            empleado.setNombre("María Pía");
            
            //gestorEntidades.merge(empleado);
            
            transaccion.commit();
            
            System.out.println("Empleado modificado con éxito.");
        } catch (Exception ex) {
            try {
                if (transaccion != null && transaccion.isActive()) {
                    transaccion.rollback();
                }
            } catch (Exception exR) {
                System.out.println("¡ERROR! Ocurrió un error al deshacer los cambios.");
            }
            
            System.out.println("¡ERROR! Ocurrió un error al modificar el empleado.");
        }
    }
    
    private static void eliminarEmpleado() {
        EntityTransaction transaccion = null;
        
        try {
            EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
            transaccion = gestorEntidades.getTransaction();
            
            Empleado empleado = gestorEntidades.find(Empleado.class, 4L);
            
            transaccion.begin();
            
            gestorEntidades.remove(empleado);
            
            transaccion.commit();
            
            System.out.println("Empleado eliminado con éxito.");
        } catch (Exception ex) {
            try {
                if (transaccion != null && transaccion.isActive()) {
                    transaccion.rollback();
                }
            } catch (Exception exR) {
                System.out.println("¡ERROR! Ocurrió un error al deshacer los cambios.");
            }
            
            System.out.println("¡ERROR! Ocurrió un error al eliminar el empleado.");
        }
    }
    
    private static void listarEmpleados() {
        try {
            EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
            
            Query consulta = gestorEntidades.createQuery("select e from Empleado e");
            List<Empleado> empleados = consulta.getResultList();
            
            for (Empleado e : empleados) {
                System.out.println("Cédula: " + e.getCedula() + ", Nombre: " + e.getNombre() + ", Edad: " + (e.getEdad() != null ? e.getEdad() : "N/D") + ", Sueldo: " + (e.getSueldo() != null ? e.getSueldo() : "N/D") + ", Casado: " + (e.getCasado() != null ? e.getCasado() ? "Sí" : "No" : "N/D"));
            }
            
            System.out.println();
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al listar los empleados.");
        }
    }
    
    private static void obtenerMayorSueldo() {
        try {
            EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
            
            Query consulta = gestorEntidades.createQuery("select max(e.sueldo) from Empleado e");
            Double mayorSueldo = (Double)consulta.getSingleResult();
            
            System.out.println("Mayor sueldo: " + mayorSueldo);
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al obtener el mayor sueldo.");
        }
    }
    
    private static void buscarNombreEmpleado() {
        try {
            EntityManager gestorEntidades = fabricaGestorEntidades.createEntityManager();
            
            Query consulta = gestorEntidades.createQuery("select e.nombre from Empleado e where e.cedula = 5");
            String nombre = (String)consulta.getSingleResult();
            
            System.out.println("Nombre del empleado con cédula 5: " + nombre);
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al obtener el nombre del empleado.");
        }
    }
    
}
