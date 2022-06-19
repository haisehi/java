package Synchronized2;
//binh phuong so tu cac so random co the chia 3
public class Thread2 extends Thread {
	shareData shareData;

	public Thread2(Synchronized2.shareData shareData) {
		this.shareData = shareData;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (shareData.checkAvaiable()) {
			synchronized (shareData) {
				shareData.notifyAll();
				try {
					while (shareData.getIndex()!=2 &&shareData.checkAvaiable()	) {
						shareData.wait();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int rad = shareData.getRad();
				if (rad % 3 ==0) {
					rad *=rad;
					System.out.println("T2 >> "+rad);
				}	
				
				shareData.setIndex(1);
			}
		}
		System.out.println("T2 stop");
		synchronized (shareData) {
			shareData.notifyAll();	
		}
	}
	
	
}
