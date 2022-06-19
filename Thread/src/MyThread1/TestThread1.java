package MyThread1;

public class TestThread1 implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread 1 ---"+i);
		}
	}
}
