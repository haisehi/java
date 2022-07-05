package ChatServer;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Window;

import ChatLibrary.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.EventObject;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import DBmanager.*;
import javax.swing.ImageIcon;
import sendFile.*;
import ChatServer.*;
public class ChatServerForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfPort;
	private JTextField tfMessage;
	
	
	private ChatMessageSocket mSocket;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServerForm frame = new ChatServerForm();
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
	public ChatServerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//label
		JLabel lblNewLabel = new JLabel("Chat Server");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(240, 11, 122, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Port:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 44, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Message");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 330, 80, 14);
		contentPane.add(lblNewLabel_2);
		
		//text
		tfPort = new JTextField();
		tfPort.setText("9888");
		tfPort.setBounds(100, 43, 89, 20);
		contentPane.add(tfPort);
		tfPort.setColumns(10);
		
		JTextPane tfMessageBoard = new JTextPane();
		tfMessageBoard.setBounds(1, 1, 528, 297);
		contentPane.add(tfMessageBoard);
		
		tfMessage = new JTextField();
		tfMessage.setBounds(100, 329, 368, 20);
		contentPane.add(tfMessage);
		tfMessage.setColumns(10);
		
		//button
		JButton btnListen = new JButton("Listen");
		btnListen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int port = Integer.parseInt(tfPort.getText());
					ServerSocket serverSocket = new ServerSocket(port);
					
					Thread th = new Thread() {
						public void run() {
							try {
								System.out.println("\\nListening... \\n");
								tfMessageBoard.setText(tfMessageBoard.getText()+"\nListening... \n");
								Socket socket = serverSocket.accept();
								
								mSocket = new ChatMessageSocket(socket, tfMessageBoard);
																
							} catch (Exception e2) {
								// TODO: handle exception
								tfMessageBoard.setText("<br> Error:"+e2.getMessage());
							}
						}
					};
					th.start();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					JOptionPane.showMessageDialog(btnListen, e, getTitle(), ABORT, null);

				}
			}
		});
		
		btnListen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListen.setBounds(478, 40, 89, 23);
		contentPane.add(btnListen);
		
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//kiem tra du lieu co duoc gui vao hay khong
				if(tfMessage.getText().equals("")) {
					//neu du lieu khong duoc gui vao thi se ket thuc
					return;
				}
				//du lieu duoc go day du vao message thi se duoc gui den client 
				mSocket.send(tfMessage.getText());
				
				//connect database
				ConnectDB cnn = new ConnectDB();
				cnn.executeDB("Insert into chatServer values( '"+tfMessage.getText()+"')");
				
			}
			
			
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSend.setBounds(478, 326, 89, 23);
		contentPane.add(btnSend);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 37, 557, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane(tfMessageBoard,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(20, 74, 547, 245);
		contentPane.add(scrollPane);
				
	}
	
}
