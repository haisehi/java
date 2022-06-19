package lab3;

import java.rmi.Remote;
import java.rmi.*;
import java.rmi.RemoteException;

import rmi01.CInterface;

public interface myInterface extends Remote {
	double cong(double kq, double n) throws RemoteException;
	double tru(double kq,double n) throws RemoteException;
	double nhan(double kq, double n) throws RemoteException;
	double chia(double kq,double n)throws RemoteException;
	double ketqua(double kq,double n)throws RemoteException;
	void save(CInterface c)throws RemoteException;//phuc vu cho viec callback
}
