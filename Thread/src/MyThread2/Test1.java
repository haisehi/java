package MyThread2;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("Thread main start");
		Thread1 t1 = new Thread1();
		Thread t2 = new Thread(new Thread2(t1));
		
		t1.start();
		t2.start();
		
		System.out.println("Thread main stop");
		
	}
}
