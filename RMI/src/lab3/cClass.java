package lab3;

import java.rmi.RemoteException;

import rmi01.CInterface;

public class cClass implements Cinterface  {
	@Override
	public void printMgs(String s) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(s);
	}
}
