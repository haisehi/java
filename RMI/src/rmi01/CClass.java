package rmi01;

import java.rmi.RemoteException;

public class CClass implements CInterface {

	@Override
	public void printMgs(String s) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(s);
	}
	
}
