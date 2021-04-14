/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploinspectorclases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author sistemas
 */
public class EjemploInspectorClases {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Class clase=Class.forName("ejemploinspectorclases.Empleado");
            System.out.println("Clase: "+clase.getName());
            System.out.println("Clase: "+clase.getSimpleName());
            System.out.println("\n\nAtributos:\n");
            Field[] atributos=clase.getFields();
            for(Field a:atributos)
            {
                System.out.println(Modifier.isPublic(a.getModifiers())?"+ ": "- "+a.getName()
                +" : "+a.getType().getSimpleName());
            }
            System.out.println();
            Field[] atributosDeclarados=clase.getDeclaredFields();
            for(Field a : atributosDeclarados)
            { System.out.println(Modifier.isPublic(a.getModifiers())?"+ ": "- "+a.getName()
                +" : "+a.getType().getSimpleName());}
            System.out.println("\n\nConstructores:\n");
            Constructor[] constructores=clase.getConstructors();
            String parametros;
            for(Constructor c:constructores)
            {
                parametros="";
                for(Class p:c.getParameterTypes())
                {
                    if(parametros.length()>0)
                    {
                        parametros+=", ";
                    }
                    parametros+=p.getSimpleName();
                }
               
                System.out.println((Modifier.isPublic(c.getModifiers()) ?"+ ":"- ")+clase.getSimpleName()+"("+ parametros+")");
            }
            System.out.println("\n\nMeotodos:\n");
            Method[] metodo=clase.getMethods();
            for(Method m:metodo)
            {
                parametros="";
                for(Class p:m.getParameterTypes())
                {
                     if(parametros.length()>0)
                    {
                        parametros+=", ";
                    }
                    parametros+=p.getSimpleName();
                }
                 System.out.println((Modifier.isPublic(m.getModifiers()) ?"+ ":"- ")+m.getName()+"("+ parametros +") : "
                 +m.getReturnType().getSimpleName());
            }
            System.out.println();
            Method[] metodoDeclarado=clase.getDeclaredMethods();
            for(Method m: metodoDeclarado)
            {
                parametros="";
                
           
            for(Class p :m.getParameterTypes())
            {
                if(parametros.length()>0)
                {parametros+=", ";}
                parametros+=p.getSimpleName();
            }
                 System.out.println((Modifier.isPublic(m.getModifiers()) ?"+ ":"- ")+m.getName()+"("+ parametros +") : "
                 +m.getReturnType().getSimpleName());
            }
                 
        }
    
        catch(ClassNotFoundException ex){
        System.out.println("!ERROR! No se encontro la clase.");}
//        catch(ex)
//                {}
        // TODO code application logic here
    }
    
}
