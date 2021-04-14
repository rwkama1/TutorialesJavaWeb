/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploorientacionaobjetos;

/**
 *
 * @author Raul
 */
public class Alumno extends Persona {
    
    private static int contadorAlumnos = 0;
    
    
    private long matricula;
    private int contadorExamenesAlumno = 0;
    
    
    public long getMatricula() {
        return matricula;
    }
    
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }
    
    
    public Alumno(String nombre, String apellido, int edad, long matricula) {
        super(nombre, apellido, edad);
        
        setMatricula(matricula);
        
        System.out.println("Se ha creado un nuevo alumno. Total de alumnos: " + ++contadorAlumnos);
    }
    
    
    public void rendirExamen(int codigoExamen) {
        System.out.println("\nEl alumno " + getNombre() + " " + getApellido() + " rindió el examen con código " + codigoExamen + ".");
        System.out.println("Exámenes rendidos por este alumno: " + ++contadorExamenesAlumno);
    }
    
    @Override
    public String toString() {
        return super.toString() + " - Matrícula: " + getMatricula();
    }
    
}
