package callbackRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AtClient extends Remote {
	//phường thức này gọi bởi đối tượng AtServer trên máy chủ
	public void callClientMethod(String message) throws RemoteException;
}
