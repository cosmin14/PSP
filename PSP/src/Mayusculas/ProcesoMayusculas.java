/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mayusculas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author jorgi
 */
public class ProcesoMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String[] comando = {"java","Mayusculas.ConvertirMayusculas"};
        ProcessBuilder pb1 = new ProcessBuilder(comando);
        
        Process p1 = pb1.start();
        
        InputStreamReader is = new InputStreamReader(p1.getInputStream());
        
        // Almacenamos en el buffer el resultado del InputStreamReader
        BufferedReader br = new BufferedReader(is);
        
        OutputStream os = p1.getOutputStream();
        
        // Para poder llenar el outputStream necesitamos un PrintStream
        PrintStream ps = new PrintStream(os);
        
        String line;
        
        
        while ((line = br.readLine()) != null){
            ps.println(line);
        }
        
    }
    
}
