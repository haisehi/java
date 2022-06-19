package MyThread1;

public class Main {
	public static void main(String[] args) {
		TestThread1 t = new TestThread1();
		Thread t1 = new Thread(t);
		
		Mythread2 t2 = new Mythread2();
		
		//run
		t1.start();
		t2.start();
	}
}
