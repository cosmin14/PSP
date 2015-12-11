package Sumador;

public class Suma implements Runnable{
	
	public Suma() {
		super();
		
	}

	@Override
	public void run(){
		for (int i = 0; i < 10; i++) {
			Principal.contador++;
			System.out.println("Contador en Sumador: " + Principal.contador);
		}
	}

}
