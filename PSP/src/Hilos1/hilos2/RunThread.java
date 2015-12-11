/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos1.hilos2;

/**
 *
 * @author jorgi
 */
public class RunThread {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i=0; i < 4; i++){
            new HelloThread(i).start();
            System.out.println("Hola desde el hilo principal.");
            System.out.println("Proceso acabando");
        }
    }
    
}
