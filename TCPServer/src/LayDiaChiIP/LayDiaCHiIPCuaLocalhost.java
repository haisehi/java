package LayDiaChiIP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LayDiaCHiIPCuaLocalhost {
	public static void main(String[] args) {
		try {
			InetAddress myHost = InetAddress.getLocalHost();
			System.out.println("Host address: "+myHost.getHostAddress()); //tra ve gia tri dia chi IP cua may
			System.out.println("Host name: "+myHost.getHostName()); // tra ve ten cua may
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
