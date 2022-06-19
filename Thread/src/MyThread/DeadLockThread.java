package MyThread;

public class DeadLockThread implements Runnable {
	//Thread t1 chiem giu ham tes2
	public synchronized void test1() {
		System.out.println("Test 1");
		test2();
	}
	//Thread t2 chiem giu ham test 1
	public synchronized void test2() {
		System.out.println("Test 2");
		test1();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		test1();
	}
	public static void main(String[] args) {
		DeadLockThread d = new DeadLockThread();
		
		Thread t1 = new Thread(d);
		Thread t2 = new Thread(d);
		
		t1.start();
		t2.start();
	}
}
