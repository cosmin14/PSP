/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author Jorgi
 */
public class ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        String[] c1 = {"ls","-l"};
        String[] c2 = {"tr","d","D"};
        
        ProcessBuilder pb1 = new ProcessBuilder(c1);
        ProcessBuilder pb2 = new ProcessBuilder(c2);
        Process p1 = pb1.start();
        Process p2 = pb2.start();
        
        // Obtenemos el string de la ejecucion del proceso
        InputStreamReader is = new InputStreamReader(p1.getInputStream());
        
        // Almacenamos en el buffer el resultado del InputStreamReader
        BufferedReader br1 = new BufferedReader(is);
        
        // Cogemos el output del proceso2 (resultado de la ejecucion)
        // El outputStream de p2 cogemos lo que va a entrar en p2. Aqui estaria en blanco.
        OutputStream os2 = p2.getOutputStream();
        
        // Para poder llenar el outputStream necesitamos un PrintStream
        PrintStream ps = new PrintStream(os2);

        String line1;
        
        // Leemos de la salida del proceso1 y escribimos en la entrada del proceso2
        // Aqui llenamos el outputStream con lo que tiene el proceso1
        while ((line1 = br1.readLine()) != null){
            ps.println(line1);
        }
        // Aqui el outputStream tendria el br1 (el resultado del proceso1)

        ps.close();
        
        // Aqui leemos la salida del proceso2, que contendra el br1 puesto que lo hemos añadido con el PrintStream
        BufferedReader br2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        String line2;

        while ((line2 = br2.readLine()) != null){
            System.out.println(line2);
        }    
    }
    
}
