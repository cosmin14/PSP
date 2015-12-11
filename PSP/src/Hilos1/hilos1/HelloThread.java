/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos1.hilos1;

/**
 *
 * @author jorgi
 */
class HelloThread implements Runnable{
    
    Thread t;
    
    HelloThread (){
        for (int i = 0; i < 5; i++){
            t = new Thread(this, "Nuevo Thread");
            System.out.println("Creado hilo: " + i + " - " + t);
            t.start();
        }
    }
    
    public void run(){
        System.out.println("Hola desde el hilo creado!");
        System.out.println("Hilo finalizado.");
    }
}
