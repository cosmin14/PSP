/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alumnos;

/**
 *
 * @author jorgi
 */
public class Principal {

    /**
     * @param args the command line arguments
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
    	
    	// SET PRIORITY - 1 minima, 10 maxima
    	
        Thread juan = new Thread(new Alumno("Juan"));
        juan.setPriority(1);
        Thread pepe = new Thread(new Alumno("Pepe"));
        pepe.setPriority(5);
        Thread jorge = new Thread(new Alumno("Jorge"));
        jorge.setPriority(10);
        
        juan.start();
        //juan.sleep(3000); //Añade una pausa de 3 segundo
        //juan.join(); //Ejecuta una espera
        
        //System.out.println("Hilo actual: " + juan.currentThread()); // Hilo en ejecucion
        //System.out.println("Esta activo el hilo? " + juan.isAlive());
        
        //System.out.println("Esta activo el hilo? " + jorge.isAlive());
        
        pepe.start();
        jorge.start();
        
    }
    
}
