package rmi01;
import java.rmi.*;
public class MyClass implements MyInterface {
	@Override
	public double cong(double a, double b)throws RemoteException{
		return a+b;
	}
	@Override
	public double tru(double a,double b)throws RemoteException{
		return a-b;
	}
	@Override
	public double nhan(double a,double b)throws RemoteException{
		return a*b;
	}
	@Override
	public double chia(double a,double b)throws RemoteException{
		if (b==0) {
			client.printMgs("loi chia cho 0.Hay nhap lai");//callback
			
		}
		return a/b;
	}
	//phuc vu cho viec callback
	CInterface client;
	@Override
	public void save(CInterface c) throws RemoteException {
		// TODO Auto-generated method stub
		client =c;
	}
}
