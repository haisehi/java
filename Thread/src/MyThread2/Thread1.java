package MyThread2;
//cách 4
public class Thread1 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("t1 is running");
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread one > "+i);
			//.sleep dùng để cho Thread ngủ trong thời gian nào đó
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
