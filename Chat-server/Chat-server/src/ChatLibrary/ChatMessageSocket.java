package ChatLibrary;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextPane;

public class ChatMessageSocket {
	private Socket socket;
	private JTextPane tfMessageBoard;
	private PrintWriter out; //luong xuat
	private BufferedReader reader; //luong doc
	//contructor
	public ChatMessageSocket(Socket socket, JTextPane tfMessageBoard) throws IOException {
		this.socket = socket;
		this.tfMessageBoard = tfMessageBoard;
		out = new PrintWriter(socket.getOutputStream());
		reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		receive();
	}
	//phuong thuc cho phep nhan du lieu tu socket
	private void receive() {
		Thread th = new Thread() {
			public void run() {
				//su dung while de doc du lieu lien tuc
				while(true) {
					try {
						//doc mot dong du lieu tu socket
						String line = reader.readLine();
						
						if(line != null) {
							tfMessageBoard.setText(tfMessageBoard.getText()+"\nChat:"+line);
							System.out.println("\nChat:"+line);
						}

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		th.start();
	}
	//gui mot message den noi nhan
	public void send(String mgs) {
		String current = tfMessageBoard.getText();
		tfMessageBoard.setText(current + "\nSent:"+mgs);
		System.out.println("\nSent:"+mgs);
		out.println(mgs);
		out.flush(); //dung de do du lieu di
	}
	//dong cac luong
	public void close() {
		try {
			out.close();
			reader.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
