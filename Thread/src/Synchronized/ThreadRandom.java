package Synchronized;
//Thread dùng để sinh số một cách ngẫu nhiên
import java.util.Random;

public class ThreadRandom extends Thread {
	ShareData shareData ;

	public ThreadRandom(ShareData shareData) {
		this.shareData = shareData;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(200);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Random random = new Random(); //hàm sinh số ngẫu nhiên
		
		for (int i = 0; i < 10; i++) {
			System.out.println("T1 >> "+i);
			synchronized (shareData) { //đồng bộ shareDate
				int rad = random.nextInt(100)+1;//sinh số ngẫu nhiên
				shareData.setRad(rad); //truyền số ngẫu nhiên vào shareData
				System.out.println("Rad : "+rad);
				/*Triển khai thêm
				 * wait => T2 chạy
				 */
				shareData.notifyAll();//Đánh thức tất cả thread
				try {
					shareData.wait(); // Để dừng một thread
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
