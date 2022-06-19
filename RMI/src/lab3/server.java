package lab3;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import rmi01.MyClass;

public class server {
	public static void main(String[] args) {
		try {
			MyClass objCalculator = new MyClass();
			UnicastRemoteObject.exportObject(objCalculator, 1100);
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost:1099/myObj", objCalculator);
			System.out.println("Server ready ...");
		} catch (MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}
