package client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
public class client {
	public static void main(String[] args) {
		
		final File[] fileToSend= new File[1];
		
		JFrame jFrame = new JFrame("Client");
		//kich thuoc
		jFrame.setSize(350,350);
		//bo cuc
		jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		
		//label 1
		JLabel lbTitle = new JLabel("Flie send");
		lbTitle.setFont(new Font("Arial",Font.BOLD,25));
		lbTitle.setBorder(new EmptyBorder(20, 0, 10, 0));
		lbTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//label 2
		JLabel lbFileName = new JLabel("Choose a file to send");
		lbFileName.setFont(new Font("Arial",Font.BOLD,20));
		lbFileName.setBorder(new EmptyBorder(50, 0, 0, 0));
		lbFileName.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//jpanel 
		JPanel jpButton = new JPanel();
		jpButton.setBorder(new EmptyBorder(75, 0, 10, 0));
		
		//button 1
		JButton jpSendFile = new JButton("Send File");
		jpSendFile.setPreferredSize(new Dimension(150,75));
		jpSendFile.setFont(new Font("Arial",Font.BOLD,20));
		
		//button 2
		JButton jpChooseFile = new JButton("Choose File");
		jpChooseFile.setPreferredSize(new Dimension(150,75));
		jpChooseFile.setFont(new Font("Arial",Font.BOLD,20));
		
		//them cac nut vao bang dieu khien
		jpButton.add(jpSendFile);
		jpButton.add(jpChooseFile);
		
		//them hanh dong
		jpChooseFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//chon file can gui
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("Choose a file to send");
				
				if (jFileChooser.showOpenDialog(null)==jFileChooser.APPROVE_OPTION) {
					fileToSend[0] = jFileChooser.getSelectedFile();
					lbFileName.setText("The file you want to send:"+fileToSend[0].getName());
				}
			}
			
		});
		
		jpSendFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (fileToSend[0]==null) {
					lbFileName.setText("Please choose a flie first");
				}
				else {
					try {
						FileInputStream fileInputStream = new FileInputStream(fileToSend[0].getAbsolutePath());
						Socket socket = new Socket("Admin",9888);
						DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
						
						String fileName = fileToSend[0].getName();
						byte[] fileNameByte = fileName.getBytes();
						byte[] fileContentByte = new byte[(int)fileToSend[0].length()];
						
						fileInputStream.read(fileContentByte);
						
						dataOutputStream.writeInt(fileNameByte.length);
						dataOutputStream.write(fileNameByte);
						
						dataOutputStream.writeInt(fileContentByte.length);
						dataOutputStream.write(fileContentByte);
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		
		jFrame.add(lbTitle);
		jFrame.add(lbFileName);
		jFrame.add(jpButton);
		jFrame.setVisible(true);
		
	}
}
