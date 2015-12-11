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
class HelloThread extends Thread{
    
    int contador;
    
    public HelloThread(int cont){
        this.contador = cont;
    }
    
    public void run(){
        System.out.println("Hola desde el hilo creado " + contador);
    }
}
