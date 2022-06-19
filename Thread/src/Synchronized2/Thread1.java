package Synchronized2;
//random so ngau nhien
import java.util.Random;

public class Thread1 extends Thread {
	shareData shareData;

	public Thread1(Synchronized2.shareData shareData) {
		this.shareData = shareData;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		Random random = new Random();
		while (shareData.checkAvaiable()) {
			synchronized (shareData) {
				int rad = random.nextInt(100)+1;
				shareData.setRad(rad);
				shareData.plus(rad);
				System.out.println("T1 >> "+rad);
				//Thiet lap Thread tiep theo duoc phep chay
				if (rad % 3==0 ) {
					shareData.setIndex(2);
				}
				else {
					shareData.setIndex(3);
				}
				//synch thread
				shareData.notifyAll();
				try {
					shareData.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("T1 stop");
		synchronized (shareData) {
			shareData.notifyAll();	
		}
	}
}
