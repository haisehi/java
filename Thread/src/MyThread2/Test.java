package MyThread2;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread main start");//main
		Thread1 t1 = new Thread1();
		t1.start();//main & thread 1
		Thread2 t2 = new Thread2();
		Thread t = new Thread(t2);
		t.start();//main , thread 1 & thread 2 -> //
		
		System.out.println("Thực hiện join 1 vào thread main");
		t1.join();//join 1 into main
		System.out.println("Thực hiện join 2 vào thread main");
		t.join();//join 2 into main
		System.out.println("Thread main stop");
//		try {
//			Thread.sleep(5000);
//			t1.stop();
//			t.stop();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
