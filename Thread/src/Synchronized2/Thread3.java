package Synchronized2;

public class Thread3 extends Thread{
	shareData shareData;

	public Thread3(Synchronized2.shareData shareData) {
		this.shareData = shareData;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (shareData.checkAvaiable()) {
			synchronized (shareData) {
				shareData.notifyAll();
				try {
					while (shareData.getIndex()!=3 &&shareData.checkAvaiable()	) {
						shareData.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int rad = shareData.getRad();
				if (rad % 2==0) {
					if (rad %4==0) {
						System.out.println("so ngau nhien chia het cho 4");
					}else {
						System.out.println("so ngau nhien khong chia het cho 4");
					}
				} else {
					System.out.println("so le");
				}
				
				shareData.setIndex(1);
			}
		}
		System.out.println("T3 stop");
		synchronized (shareData) {
			shareData.notifyAll();	
		}
	}
	
}
