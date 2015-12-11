package SemaforoMedico;

import java.util.concurrent.Semaphore;

class Medico extends Thread{
	
	private Semaphore sem;
	private int paciente;
	private String nombre;
	
	Medico(int paciente, Semaphore sem, String nombre){
		this.paciente = paciente;
		this.sem = sem;
		this.nombre = nombre;
	}
	
	public void run(){
		//for (int i = 0; i < cuenta; i++) {
		//Paciente 1 entrando
		System.out.println(nombre + ". P" + paciente + " en consulta. (LIBRE)");
			try {
				sem.acquire();// Pone el semaforo en espera
				System.out.println(nombre + ". P" + paciente + " cambiandose... (OCUPADO)");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sem.release();// Libera el hilo y augmenta en 1 el semaforo que pasara a valer 1
		System.out.println(nombre + ". P" + paciente + " saliendo... (LIBRE)");
		System.out.println();
		//}
	}
	
}

public class Principal {
	private static Semaphore semaphore = new Semaphore(1);
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		
		int numPacientes = 2;
		
		/*
		 * Con este sistema, cada medico tiene 6 pacientes en este caso
		 */
		for (int i = 0; i < numPacientes; i++) {
			Thread M1 = new Thread(new Medico(i, semaphore, "Medico 1"));
			Thread M2 = new Thread(new Medico(i, semaphore, "Medico 2"));
			
			M1.sleep(2000);
			M1.start();

			M2.sleep(2000);
			M2.start();
			
			M1.join();
			M2.join();
		}
		System.out.println();
		System.out.println("=============================");
		System.out.println("     FIN DE LAS CONSULTAS    ");
		System.out.println("=============================");

	}

}
