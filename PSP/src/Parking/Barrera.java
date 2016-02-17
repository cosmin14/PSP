package Parking;

import java.util.concurrent.Semaphore;

public class Barrera {
	
	int num;
	static Semaphore barrera1;

	public Barrera(int num) {
		super();
		this.num = num;
		barrera1 = new Semaphore(num, true);
	}
	
	

}
