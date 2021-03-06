package ChatClient;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.Font;

import ChatLibrary.*;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import DBmanager.*;
import sendFile.*;
public class ChatClientForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfPort;
	private JTextField tfMessage;
	private JTextField tfServerHost;
	
	ChatMessageSocket mSocket;
	private JTextField nameServerHost;
	final File[] fileToSend= new File[1];

//	private Socket socket;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientForm frame = new ChatClientForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatClientForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//label
		JLabel lblNewLabel = new JLabel("Chat Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(242, 11, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Port:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(315, 44, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Message");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 314, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Server Host");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 44, 102, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Name Server");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 72, 100, 20);
		contentPane.add(lblNewLabel_4);
		
		//text
		tfPort = new JTextField();
		tfPort.setText("9888");
		tfPort.setBounds(374, 43, 49, 20);
		contentPane.add(tfPort);
		tfPort.setColumns(10);		
		
		tfMessage = new JTextField();
		tfMessage.setBounds(100, 313, 362, 20);
		contentPane.add(tfMessage);
		tfMessage.setColumns(10);
		
		tfServerHost = new JTextField();
		tfServerHost.setText("192.168.0.103");
		tfServerHost.setBounds(122, 43, 102, 20);
		contentPane.add(tfServerHost);
		tfServerHost.setColumns(10);
		
		nameServerHost = new JTextField();
		nameServerHost.setBounds(122, 74, 102, 20);
		contentPane.add(nameServerHost);
		nameServerHost.setColumns(10);
		
		JTextPane tfMessageBoard = new JTextPane();
		
		//button
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InetAddress myHost = InetAddress.getLocalHost();
					System.out.println("Host address: "+myHost.getHostAddress()); //tra ve gia tri dia chi IP cua may
					System.out.println("Host name: "+myHost.getHostName()); // tra ve ten cua may
					tfServerHost.setText(myHost.getHostAddress());
					nameServerHost.setText(myHost.getHostName());
					
				} catch (UnknownHostException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(229, 42, 89, 23);
		contentPane.add(btnFind);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int port = Integer.parseInt(tfPort.getText());
					Socket socket = new Socket(tfServerHost.getText(),port);
					
					mSocket = new ChatMessageSocket(socket,tfMessageBoard);
					tfMessageBoard.setText(tfMessageBoard.getText()+"\nConnected!...");
					System.out.println("\nConnected!...");
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConnect.setBounds(433, 40, 128, 23);
		contentPane.add(btnConnect);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				if (tfMessage.getText().equals("")) {
					return;
				}
				mSocket.send(tfMessage.getText());
				ConnectDB cnn = new ConnectDB();
				cnn.executeDB("Insert into chatClient values( '"+tfMessage.getText()+"')");
				
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSend.setBounds(472, 310, 89, 23);
		contentPane.add(btnSend);
		
		
		JScrollPane scrollPane = new JScrollPane(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 105, 551, 198);
		scrollPane.setViewportView(tfMessageBoard);
		contentPane.add(scrollPane);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 31, 551, 2);
		contentPane.add(separator);
				
		
	}
}
