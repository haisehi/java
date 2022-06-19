package MyThread2;
//cách 5
public class Thread2 implements Runnable {
	Thread1 t1;
	
	public Thread2() {
		
	}
	public Thread2(Thread1 t1) {
		this.t1 = t1;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("t2 is running");
		try {
			System.out.println("join t1 into t2");
			t1.join();
			System.out.println("t1 is finished");
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread two > "+i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
