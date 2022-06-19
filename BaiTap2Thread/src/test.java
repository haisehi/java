import java.util.Random;

public class test extends Thread {
	public static void main(String[] args) {
		int s =0;
		Thead1 t1 = new Thead1();
		Thread2 t2 = new Thread2();
		Thread3 t3 = new Thread3();
		Thread4 t4 = new Thread4();
		Thread5 t5 = new Thread5();
		Thread6 t6 = new Thread6() ;
		thread7 t7 = new thread7();
		
		t1.start();
		try {
			t1.join(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		System.out.println("Tong la "+s);
	}
}
