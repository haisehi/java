package LocalHost;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientLocalHost {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String sentence;
		String modifiedSentence;
		
		//tạo input stream
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		//tạo client socket . kết nối tới server
		Socket clientSocket = new Socket("Admin",6789);
		
		//tạo output stream,đính kèm vào socket
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		//tạo input stream đíng kèm vào trong socket 
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.println("Reading...");
		//đọc dữ liệu
		sentence = inFromUser.readLine();
		
		//Gửi dòng kí tự đến server
		outToServer.writeBytes(sentence+"\n");
		
		//đọc dòng kí tự (đã biến đổi) gửi về từ server
		modifiedSentence=inFromServer.readLine();
		System.out.println("From Server: "+modifiedSentence);
		clientSocket.close();
		
	}
}
