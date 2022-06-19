package test;
import DBmanage.ConnectDB;
public class accountManage {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectDB cn = new ConnectDB();
		//cn.connect();
		cn.executeDB("Insert into account values('test123','abc')");
		cn.executeDB("Update Account set name ='ngu'  where id ='test123'");
	}
}
