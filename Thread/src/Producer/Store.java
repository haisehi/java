package Producer;

public class Store {
	int maxN = 50;
	long []a;
	int n;
	public Store() {
		n=0;
		a=new long[maxN];
	}
	public boolean empty() {
		return n==0;
	}
	public boolean full() {
		return n==maxN;
	}
	public /*synchronized*/ boolean put(long x) {
		if(full()) return false;
		a[n++]=x;
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception

		}
		return true;
	}
	public /*synchronized*/ long get() {
		long result =0;
		if (!empty()) {
			result =a[0];
			for (int i = 0; i <n-1; i++) 
				a[i]= a[i+1];
				n--;
		}
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
}
