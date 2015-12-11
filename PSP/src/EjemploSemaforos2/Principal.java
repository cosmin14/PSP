package EjemploSemaforos2;

import java.util.concurrent.Semaphore;

public class Principal {

	int i = 0;

	public static void main(String[] args) {

		final Principal example = new Principal();
		final Semaphore semaphore = new Semaphore(1);
		
		final Runnable r = new Runnable() {

			public void run() {
				//for (int i = 0; i < 2; i++) {
				while(true){
					try {
						System.out.println("Disponilbes 1: " + semaphore.availablePermits());
						semaphore.acquire();	//Sección crítica a proteger
						example.printSomething();
						Thread.sleep(3000);
						System.out.println("Disponilbes 2: " + semaphore.availablePermits());
						semaphore.release();

					} catch (Exception ex) {
						System.out.println(" — Interrupted…");
						ex.printStackTrace();
					}
				}
			}
		};

		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();

	}

	public void printSomething() {

		i++;

		System.out.println(" — current value of the i :" + i);

	}

}