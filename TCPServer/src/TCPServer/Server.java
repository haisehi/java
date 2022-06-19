package TCPServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		double a ,b;
		ServerSocket serverSocket = new ServerSocket(5678);
		while(true) {
			System.out.println("Server ready...");
			Socket socket = serverSocket.accept();
			DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
			a = dataInputStream.readDouble();
			b = dataInputStream.readDouble();
			System.out.println("From client : "+a+" and "+b);
			dataOutputStream.writeUTF("Sum: "+(a+b));
		}
	}
}
