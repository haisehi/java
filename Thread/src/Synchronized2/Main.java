package Synchronized2;

public class Main {
	public static void main(String[] args) {
		shareData shareData = new shareData();
		
		Thread1 t1 = new Thread1(shareData);
		Thread2 t2 = new Thread2(shareData);
		Thread3 t3 = new Thread3(shareData);
		//run
		t1.start();
		t2.start();
		t3.start();
	}
}
