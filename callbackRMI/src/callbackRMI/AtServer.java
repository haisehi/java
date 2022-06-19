package callbackRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AtServer extends Remote {
	//tiếp nhận tham chiếu đến đối tượng atClient thêm trình khách hàng
	public void registerClient(AtClient c) throws RemoteException;
	//Cung cấp dịch vụ cho trình khách hàng
	public void callServerMethod(String message) throws RemoteException;
}
