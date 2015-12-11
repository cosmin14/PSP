/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos1.hilos1;

import Hilos1.hilos1.HelloThread;

/**
 *
 * @author jorgi
 */
public class RunThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new HelloThread();
        System.out.println("Hola desde el hilo principal!");
        System.out.println("Proceso acabando!");
    }
    
}
