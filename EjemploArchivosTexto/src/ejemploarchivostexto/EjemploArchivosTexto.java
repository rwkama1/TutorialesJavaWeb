/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarchivostexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Date;

/**
 *
 * @author Raúl
 */
public class EjemploArchivosTexto {
    //http://www.devmanuals.com/tutorials/java/jsp/readingTextFile.html
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo = new File("log.txt");
        
        if (archivo.exists() && !archivo.isDirectory()) {
            try (FileReader fr = new FileReader(archivo);
                    BufferedReader br = new BufferedReader(fr)) {
                System.out.println("Ejecuciones anteriores...\n");
                
                String linea;
                
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (Exception ex) {
                System.out.println("¡ERROR! Ocurrió un error al leer el archivo de log.");
            }
        }
        
        try (FileOutputStream fos = new FileOutputStream(archivo, true);
                PrintStream ps = new PrintStream(fos);) {
            ps.println(new Date());
        } catch (Exception ex) {
            System.out.println("¡ERROR! Ocurrió un error al escribir en el archivo de log.");
        }
    }
    
    
}
