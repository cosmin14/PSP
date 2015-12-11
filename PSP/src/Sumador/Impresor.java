package Sumador;

public class Impresor implements Runnable{
	
	
	public Impresor() {
		super();
	}



	@Override
	public void run(){
		//for (int i = 0; i < 10; i++) {
			System.out.println("Contador en Impresor: " + Principal.contador);
		//}
	}
	
}
