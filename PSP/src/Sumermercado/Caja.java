package Sumermercado;

public class Caja extends Thread {
	
	int id;
	String nombre;
	
	public Caja() {
		super();
	}
	public Caja(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void run(){
		System.out.println("CAJA");
	}
	
	public synchronized void ocuparCaja(){
		try {
			wait(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized void liberarCaja(){
		notify();
	} 
	

}
