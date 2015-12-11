package SemaforoMedico;

import java.util.concurrent.Semaphore;

class Acumula2{
	public static int acumulador = 0;
}

class Medico2 extends Thread{
	
	private int numPacientes;
	private Semaphore sem;
	private String nombre;
	
	/*
	 * En el constructor paso como primer parametro el numero de pacientes que tendra el medico
	 */
	Medico2(int numPacientes, Semaphore sem, String nombre){
		this.numPacientes = numPacientes;
		this.sem = sem;
		this.nombre = nombre;
	}
	
	
	/*
	 * Con este sistema defino el numero de pacientes para cada medico en su clase
	 */
	public void run(){
		for (int i = 0; i < numPacientes; i++) {
			try {
				System.out.println(nombre + ". P" + i + " en consulta. (LIBRE)");
				sleep(2000);
				sem.acquire();// Pone el semaforo en espera
				System.out.println(nombre + ". P" + i + " cambiandose... (OCUPADO)");
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(nombre + ". P" + i + " saliendo... (LIBRE)");
			System.out.println();
			sem.release();// Libera el hilo y augmenta en 1 el semaforo que pasara a valer 1
			
		}
	}
	
}

public class Principal2 {
	private static Semaphore semaphore = new Semaphore(1);
	
	public static void main(String[] args) throws InterruptedException {
		
		
			Thread M1 = new Thread(new Medico2(2,semaphore, "Medico 1"));
			Thread M2 = new Thread(new Medico2(3,semaphore, "Medico 2"));
			
			M1.start();
			M2.start();
		
			try {
				M1.join();
				M2.join();
				System.out.println();
				System.out.println("=============================");
				System.out.println("     FIN DE LAS CONSULTAS    ");
				System.out.println("=============================");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		

	}

}
