/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mayusculas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author jorgi
 */
public class ConvertirMayusculas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        System.out.println("Introduce una palabra");
        Scanner entrada = new Scanner(System.in);
        String texto;
        
        while((texto = entrada.next()).compareTo("fin") != 0){
            System.out.println(texto.toUpperCase());
            System.out.println("");
            System.out.println("Introduce una palabra");
        }
        System.out.println("");
        System.out.println("FIN DEL PROGRAMA");
    }
    
}
