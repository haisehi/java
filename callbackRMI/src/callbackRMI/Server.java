package callbackRMI;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String[] args) throws Exception, Exception, Exception {
		//khởi tạo đối tượng
		AtServer server = new AtServerIml();
		//thông báo khả năng giao  tiếp từ xa
		UnicastRemoteObject.exportObject(server,1100);
		LocateRegistry.createRegistry(1099);
		//đăng ký đối tượng với RMI
		Naming.bind("rmi://localhost/srvobj", server);
		System.out.println("Wating for client request ...");
	}
}
