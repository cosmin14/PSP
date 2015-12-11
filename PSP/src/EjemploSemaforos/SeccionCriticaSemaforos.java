package EjemploSemaforos;
import java.util.concurrent.Semaphore;

class Acumula{
	public static int acumulador = 0;
}

class Sumador extends Thread {
	
	private int cuenta;
	private Semaphore sem;
	
	Sumador(int hasta, int id, Semaphore sem){
		this.cuenta = hasta;
		this.sem = sem;
	}
	
	public void sumar(){
		Acumula.acumulador++;
	}
	
	public void run(){
		for (int i = 0; i < cuenta; i++) {
			System.out.println("Disponibles 1: " + sem.availablePermits() + " (Libre)");
			try {
				sem.acquire();
				System.out.println("Disponibles 2: " + sem.availablePermits() + " (Ocupado)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sumar();
			System.out.println("Acumulador en el bucle: " + Acumula.acumulador);
			sem.release();
			System.out.println("Disponibles 2: " + sem.availablePermits() + " (Liberando...)");
			System.out.println();
		}
	}
}

public class SeccionCriticaSemaforos {
	
	private static Sumador sumadores[];
	private static Semaphore semaphore = new Semaphore(1);//
	
	public static void main(String[] args) {
		
		int n_sum = Integer.parseInt("5");
		sumadores = new Sumador[n_sum];
		
		for (int i = 0; i < n_sum; i++) {
			//sumadores[i] = new Sumador(100000000, i, semaphore);
			sumadores[i] = new Sumador(10, i, semaphore);
			sumadores[i].start();
		}
		for (int i = 0; i < n_sum; i++) {
			try {
				sumadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Acumulador: " + Acumula.acumulador);
	}

}
