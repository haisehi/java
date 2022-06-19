package callbackRMI;

import java.rmi.RemoteException;
import java.util.Iterator;

public class AtServerIml implements AtServer {
	//tham chiếu đến đối tượng trến máy
	AtClient client;
	//trình khách gọi pt để đăng ký AtClient với trình chủ
	@Override
	public void registerClient(AtClient c) throws RemoteException {
		// TODO Auto-generated method stub
		client = c;
	}

	@Override
	public void callServerMethod(String message) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(message);
		for (int i = 0; i <10; i++) {
			String msg = "Server response "+i;
			//gọi phương thức của đối tượng máy khách
			client.callClientMethod(message);
		}
	}
	
}
