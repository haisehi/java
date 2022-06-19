package rmi01;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String[] args) {
		try {
			MyClass obj = new MyClass();
			UnicastRemoteObject.exportObject(obj, 1100);
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost:1099/myObj", obj);
			System.out.println("Server ready ...");
		} catch (MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}
