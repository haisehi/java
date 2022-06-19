package UDPSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	public static void main(String[] args) throws IOException {
		//tạo input stream
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		//tạo client socket
		DatagramSocket clientSocket = new DatagramSocket();
		//chuyển hostname thành địa chỉ IP sử dụng DNS
		InetAddress IPAddress = InetAddress.getByName("Admin");
		
		byte[]sendData = new byte[1024];
		byte[]receiveData = new byte[1024];
		System.out.println("reading...");
		String sentence = inFromUser.readLine();
		sendData=sentence.getBytes();
		//tạo datagram cùng với dữ liệu ,độ dài ,địa chỉ IP,cổng
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		//gửi datagram tới server
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		//đọc datagram gửi về cùng server
		clientSocket.receive(receivePacket);	
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("From server:"+modifiedSentence);
		clientSocket.close();
	}
}
