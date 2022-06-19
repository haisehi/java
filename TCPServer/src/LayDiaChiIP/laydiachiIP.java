package LayDiaChiIP;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class laydiachiIP {
	public static void main(String args[]) throws Exception
    {
        InetAddress myIP=InetAddress.getLocalHost();
        System.out.println("Địa chỉ IP của tôi là:");
        System.out.println(myIP.getHostAddress());
        System.out.println("----------------------------");
    }
}
