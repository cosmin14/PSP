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
public class Alumno implements Runnable{
    private String nombre;
    String mensaje;

    public Alumno(String nombre) {
        this.nombre = nombre;
        mensaje = "Hola soy " + nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void run(){
        for (int i = 0; i < 100; i++){
            System.out.println("Hola desde el hilo creado " + this.nombre + " - Repeticion: " + i);
        }
    }
    
    
}
