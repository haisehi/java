package sendFile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class sendfile extends JFrame {
	JFrame frame = new JFrame("send file");
	JLabel lbfileToSend = new JLabel("File to Send");
	JButton btnChoose = new JButton("choose");
	JButton btnsend = new JButton("send");
	final File[] fileToSend= new File[1];
	public sendfile() {
		
        frame.setSize(220, 180);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(500,200);
		frame.setLayout(new GridLayout(2,1));
		frame.add(lbfileToSend);
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 1));
        p1.add(btnChoose);
        p1.add(btnsend);
		frame.add(p1);
        frame.setVisible(true);
        
        btnChoose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//chon file can gui
				JFileChooser jFileChooser = new JFileChooser();
				jFileChooser.setDialogTitle("Choose a file to send");
				
				if (jFileChooser.showOpenDialog(null)==jFileChooser.APPROVE_OPTION) {
					fileToSend[0] = jFileChooser.getSelectedFile();
					lbfileToSend.setText(fileToSend[0].getName());
				}
			}
        	
        });
        
        btnsend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (fileToSend[0]==null) {
					lbfileToSend.setText("Please choose a flie first");
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
        
	}
	public static void main(String[] args) {
		new sendfile();
	}
}
