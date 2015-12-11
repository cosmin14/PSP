package Sumador;

public class Principal {
	
	static int contador = 0;
	
	public static void main(String[] args) throws InterruptedException {		
		
		Thread sumador = new Thread(new Suma());
		Thread impresor = new Thread(new Impresor());
		
		/* Pruebas realizadas:
		 *  - Sin setPriority impresor mostraba casi siempre 10, alguna ves mostraba alguna iteracion del bucle con otro valor
		 *  	Es decir, sumador ejecuta el incremento en la variable antes de que impresor lo imprima
		 *  
		 *  - Con setPriority impresor ya mustra mas valores de la variable, aunque tambien imprime la mayoria de veces 10.
		 *  	Conseguimos que se ejecute alguna vez primero.
		 *  
		 *  - Con sleep en el hilo sumador, conseguimos hacer que impresor se inicie primero, con lo que muestra siempre el valor 1
		 *  
		 *  - Cambio de orden de ejecucion de hilos. He probado de cambiar el orden de ejecucion y a  veces obtenemos algun valor mas.
		 *  
		 *  En colcusión vemos que no podemos controlar las ejecuciones de los hilos al 100% con sleep(), setPriority() o con el orden.
		 *  Los procesos entran practicamente simultaneamente y no podemos controlar esa ejecición.
		 *  
		 */
		
		
		sumador.setPriority(1);
		impresor.setPriority(9);
		
		//impresor.sleep(100);
		sumador.start();
		impresor.start();
		
		

	}
}
