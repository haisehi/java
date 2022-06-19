package lab3;

import java.rmi.RemoteException;

import rmi01.CInterface;
import rmi01.MyInterface;
import java.rmi.*;

public class myClass implements myInterface  {
	public double cong(double kq, double n) throws RemoteException{
		return kq+n;
	}
	public double tru(double kq,double n) throws RemoteException{
		return kq-n;
	}
	public double nhan(double kq,double n) throws RemoteException{
		return kq*n;
	}
	public double chia(double kq,double n)throws RemoteException{
		if (n==0) {
			try {
				client.printMgs("loi chia cho 0.Hay nhap lai");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//callback
			
		}
		return kq/n;
	}
	//phuc vu cho viec callback
	CInterface client;
	@Override
	public void save(CInterface c) throws RemoteException {
		// TODO Auto-generated method stub
		client =c;
	}
	@Override
	public double ketqua(double kq, double n) {
		// TODO Auto-generated method stub
		return kq=n;
	}

}
