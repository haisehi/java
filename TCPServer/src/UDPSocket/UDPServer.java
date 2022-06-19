package UDPSocket;

import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		//tạo datagram socket ở cổng 9876
		DatagramSocket serverSocket = new DatagramSocket(9876);
		 byte[] receiveData = new byte[1024];
		 byte[] SentData = new byte[1024];
		 
		 while(true) {
			 //tạo datagram nhận
			 System.out.println("listening...");
			 DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			 //nhận datagram 
			 serverSocket.receive(receivePacket);
			 
			 String sentence = new String(receivePacket.getData());
			 System.out.println("receive: "+sentence);
			 //nhận địa chỉ IP cổng của bên gửi
			 InetAddress IPAddress = receivePacket.getAddress();
			 int port = receivePacket.getPort();
			 String capitalizedSentence = sentence.toUpperCase();
			 SentData = capitalizedSentence.getBytes();
			 //tạo datagram để gửi đến client
			 DatagramPacket sendPacket = new DatagramPacket(SentData, SentData.length,IPAddress,port);
			 System.out.println("sent: "+sentence.toUpperCase());
			 //Đính datagram vào socket 
			 serverSocket.send(sendPacket);
		 }
	}
}
