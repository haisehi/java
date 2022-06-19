package LayDiaChiIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class timDiaChiIP {
	public static void main(String[] args) {
		try {
			InetAddress []address = InetAddress.getAllByName("dantri.com.vn");
			for (int i = 0; i < address.length; i++) {
				System.out.println("Address "+(i+1)+": "+address[i]);
			}
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
