package TCPServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
        double a, b; String result;
        Scanner s = new Scanner(System.in);
        Socket con = new Socket("Admin",5678); 
        DataInputStream in = new DataInputStream(con.getInputStream());                                  
        DataOutputStream out = new DataOutputStream(con.getOutputStream());                                     
        System.out.print("Nhập a: ");        
        a = s.nextDouble();
        System.out.print("Nhập b: ");        
        b = s.nextDouble();
        out.writeDouble(a);  out.writeDouble(b);
        result = in.readUTF();
        System.out.println(result);
        con.close();
	}

}
