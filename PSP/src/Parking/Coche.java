package Parking;

public class Coche extends Thread{
	
	int id;
	Barrera barrera;
	
	public Coche(int id, Barrera barrera) {
		super();
		this.id = id;
		this.barrera = barrera;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Barrera getBarrera() {
		return barrera;
	}

	public void setBarrera(Barrera barrera) {
		this.barrera = barrera;
	}


	public void run(){
			System.out.println(">     Coche nº "+ id + " y quiero entrar");
		    try {
				Barrera.barrera1.acquire();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println("> >   Coche nº "+ id + " aparcando...");
			try {
			    Thread.sleep(2000);
			} catch (InterruptedException e) {
			    System.out.print("ERROR");
			}
			System.out.println("> > > Coche nº "+ id + " sale del parking");
			Barrera.barrera1.release();
	}

}