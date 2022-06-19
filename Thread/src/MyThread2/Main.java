package MyThread2;

public class Main {
	public static void main(String[] args) {
		//--thread main --> Luồng chính
		System.out.println("Star");
		//cách 1 
		Thread t = new Thread(new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					System.out.println("Thread 1 > "+i);
				}
			}
		});
		//chạy luồng
		t.start(); //để luồng chạy phải có lệnh .start();
		// luồng 2
		Thread t2 = new Thread(new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					System.out.println("Thread 2 > "+i);
				}
			}
		});
		//chạy luồng
		t2.start();
		
		//cách 2:
		new Thread(new Runnable() {	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//viết core tại đây
				for (int i = 0; i < 5; i++) {
					System.out.println("Thread 3 > "+i);
				}
			}
		}).start();
		//lamda
		new Thread(() -> {	
			// viết core tại đây
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 4 > "+i);
			}
		}).start();
		
		System.out.println("End");
	}
}
