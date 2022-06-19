package Synchronized;

public class ThreadSquare extends Thread {
	ShareData shareData;

	public ThreadSquare(ShareData shareDate) {
		this.shareData = shareDate;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("T2 >> "+i);
			synchronized (shareData) {
				try {
					shareData.notifyAll();
					shareData.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int rad = shareData.getRad();
				rad *=rad;//bình phương số ngẫu nhiên
				System.out.println("PT :"+rad);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		//stop
		synchronized (shareData) {
			shareData.notifyAll();	
		}
	}
	
}
