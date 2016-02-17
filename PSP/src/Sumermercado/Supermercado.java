package Sumermercado;

import java.util.Random;

public class Supermercado {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		
		int N = 5; //cajas
		
		Caja cajas[] = new Caja[N];
		String[] nombres = {"María", "Jose", "Alberto", "Juan", "Antonio", "Ana", "Marta", "Juanjo", "Josefina"};
		
		for (int i= 0; i < N; i++){
			int nombreInt = new Random().nextInt(nombres.length);
			cajas[i]= new Caja(i+1, nombres[nombreInt]);
		}
		
		int M = 10; //clientes
		
		Cliente clientes[] = new Cliente[M];
		
		for (int i = 0; i < M; i++){
			long time_start, time_end;
			time_start = System.currentTimeMillis();
			
			int j = new Random().nextInt(N);
			
			
			clientes[i]= new Cliente(i,cajas[j]);
			clientes[i].start();
			clientes[i].sleep(1000, 3000);		
			
			
			time_end = System.currentTimeMillis();
			
			long time_elapsed = time_end-time_start;
			Resultados.tiempo_espera += time_elapsed;
			Resultados.clientes_atendidos++;
			
			//System.out.println("Tiempo " + time_elapsed);
		}
		try {
			for (int i= 0; i < M; i++){
				clientes[i].join();
			}
		} catch (InterruptedException ex) {
			System.out.println("Hilo principal interrumpido.");
		}
		System.out.println("Supermercado cerrado.");
		System.out.println("Ganancias: " + Resultados.ganancias + "€.");
		System.out.println("Tiempo medio de espera: " +(Resultados.tiempo_espera / Resultados.clientes_atendidos) + " segundos");
	}
}
