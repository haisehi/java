package lab3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.*;
public interface Cinterface extends Remote {
	void printMgs(String s)throws RemoteException;
}
