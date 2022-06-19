package Synchronized;

public class Test {
	public static void main(String[] args) {
		ShareData shareDate = new ShareData();
		
		ThreadRandom threadRandom = new ThreadRandom(shareDate);
		ThreadSquare threadSquare = new ThreadSquare(shareDate);
		
		//run
		threadRandom.start();
		threadSquare.start();
		try {
			threadSquare.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stop");
	}
}
