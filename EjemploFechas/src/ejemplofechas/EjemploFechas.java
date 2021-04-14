/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplofechas;

/**
 *
 * @author sistemas
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class EjemploFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Date fechactual=new Date();
        System.out.println("Fecha actual en el formato por defecto...\n");
         System.out.println(fechactual);
         System.out.println("\n\nFecha actual en diferentes formatos...\n");
         DateFormat formateador;
         formateador=DateFormat.getDateInstance(DateFormat.DEFAULT);
        System.out.println("DEFAULT: " + formateador.format(fechactual));
           formateador=DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Short: " + formateador.format(fechactual));
                formateador=DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Medium: " + formateador.format(fechactual));
                formateador=DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("Long: " + formateador.format(fechactual));
                formateador=DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Full: " + formateador.format(fechactual));
                formateador=new SimpleDateFormat("--> dd - MM - yyyy <-----");
        System.out.println("Personalizado: " + formateador.format(fechactual));
         System.out.print("\n\nHora actual en formato DEFAULT: ");
               formateador=DateFormat.getTimeInstance(DateFormat.DEFAULT);                      
        System.out.println(formateador.format(fechactual));
          formateador=DateFormat.getDateTimeInstance(DateFormat.DEFAULT,
          DateFormat.DEFAULT);                      
        System.out.println(formateador.format(fechactual));
        Scanner teclado=new Scanner(System.in);
        System.out.print("\n\n INgrese su fecha de nacimiento (dd/mm/aaaa) ");
        formateador=DateFormat.getDateInstance(DateFormat.SHORT);
        formateador.setLenient(false);
        Date Fechanacimiento=formateador.parse(teclado.nextLine());
        Calendar calendario=Calendar.getInstance();
        calendario.setTime(Fechanacimiento);
        System.out.println("\n Dia de nacimiento: "+ calendario.get(Calendar.DAY_OF_MONTH));
          System.out.println("\n Mes de nacimiento: " + calendario.get(Calendar.MONTH));
         System.out.println("\n Mes de nacimiento: "+ calendario.get(Calendar.YEAR));
        // TODO code application logic here
    }
    
}
