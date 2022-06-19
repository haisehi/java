package rmi01;
import java.rmi.*;
public interface CInterface extends Remote {
	void printMgs(String s)throws RemoteException;
	
}
