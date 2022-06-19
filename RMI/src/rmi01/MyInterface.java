package rmi01;
import java.rmi.*;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {
	double cong(double a,double b) throws RemoteException;
	double tru(double a,double b) throws RemoteException;
	double nhan(double a,double b) throws RemoteException;
	double chia(double a,double b) throws RemoteException;
	void save(CInterface c)throws RemoteException;//phuc vu cho viec callback
}
