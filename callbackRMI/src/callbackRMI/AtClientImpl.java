package callbackRMI;

import java.rmi.RemoteException;

public class AtClientImpl implements AtClient {
	public void callClientMethod(String mes) throws RemoteException{
		System.out.println(mes);
	}
}
