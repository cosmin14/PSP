package SemaforoPreferencia;

import java.util.concurrent.Semaphore;

public class Main{
	
Semaphore semaphore = new Semaphore(0);
	
	public static void main(String args[]) throws InterruptedException{
		
	Semaphore sem = new Semaphore(0);
			
		Orden o1 = new Orden(sem, 1);
		Orden o2 = new Orden(sem, 2);
			
			o1.start();
			o2.start();
			
			o1.join();
			o2.join();
			
		}

}

class Orden extends Thread{
	
	private Semaphore sem;
	private int hilo;
	
	// En el contructor declaro como hilo la preferencia que tiene la Orden (hilo).
	public Orden(Semaphore sem, int hilo) {
		this.sem = sem;
		this.hilo = hilo;
	}
	
	public void run(){
	
		/* 
		 * Si el hilo es 1, pongo el semaforo en ocupado.
		 * Asi no se inicia este hilo
		 */
		if(hilo == 1){
			try {
				sem.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		/*
		 * Si el hilo es el 2, entonces libero el semaforo,
		 * asi puede entrar el hilo 2
		 */
		System.out.println("Hilo " + hilo);
		if(hilo == 2){
			sem.release();
		}
	}
	
}
