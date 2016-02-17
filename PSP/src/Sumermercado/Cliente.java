package Sumermercado;

import java.util.Random;

public class Cliente extends Thread{
	
	int id;
	Caja cajero;
	
	public Cliente(int id, Caja cajero) {
		super();
		this.id = id;
		this.cajero = cajero;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Caja getCajero() {
		return cajero;
	}

	public void setCajero(Caja cajero) {
		this.cajero = cajero;
	}

	@Override
	public void run() {
		
		cajero.ocuparCaja();
		
		int gasto = new Random().nextInt(100);
		Resultados.ganancias += gasto;
		System.out.println("Cliente " + (id+1) + ": " + gasto + "€. Atiende: " + cajero.getId() + " " + cajero.getNombre());
		
		cajero.liberarCaja();
		
	}
	
	

}
