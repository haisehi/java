package LocalHost;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serverLocalHost {
	public static void main(String[] args) throws IOException {
		String clientSentence;
		String capitalizedSentence;
		
		//tạo sẵn socket ở cổng 6789
		ServerSocket welcomeSocket = new ServerSocket(6789);
		System.out.println("Listening...");
		while (true) {
			//đợi đến khi có socket gửi đến
			Socket connectionSocket = welcomeSocket.accept();
			//tạo inputstream đính kèm vào socket
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			//tạo output stream đính kèm vào socket 
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			//đọc dòng ký tự trong socket
			clientSentence = inFromClient.readLine();
			System.out.println("Received: "+clientSentence);
			System.out.println("Sent: "+clientSentence);
			capitalizedSentence=clientSentence.toUpperCase()+"\n";
			//Ghi dòng ký tự đã biến đổi vào socket
			outToClient.writeBytes(capitalizedSentence);
			
			inFromClient.close();
			outToClient.close();
			connectionSocket.close();
		}
	}
}
