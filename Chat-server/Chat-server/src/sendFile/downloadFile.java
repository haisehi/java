package sendFile;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import sendFile.MyFile;
import ChatServer.ChatServerForm;
public class downloadFile extends JFrame {
	JFrame frame;
	int fileID = 0;
	static ArrayList<MyFile> myFiles = new ArrayList<MyFile>(); 
	public downloadFile() throws IOException {
		frame = new JFrame("Download");
        frame.setSize(250, 300);
		frame.setLocation(500,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout(2,1));
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

		//thanh cuon
		JScrollPane jScrollPane = new JScrollPane(jPanel);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//label
		JLabel lbTitle = new JLabel("File receiver");
		lbTitle.setFont(new Font("Arial",Font.BOLD,25));
		lbTitle.setBorder(new EmptyBorder(20, 0, 10, 0));
		lbTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		frame.add(lbTitle);
		frame.add(jScrollPane);
		frame.setVisible(true);
        
		//serverSocket
		ServerSocket serverSocket = new ServerSocket(9888);
		
		while(true) {
			try {
				Socket socket = serverSocket.accept() ;
				
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				
				int fileNameLenght = dataInputStream.readInt();
				
				if(fileNameLenght > 0) {
					byte[] fileNameByte = new byte[fileNameLenght];
					dataInputStream.readFully(fileNameByte, 0, fileNameByte.length);
					String fileName = new String(fileNameByte);
					
					int fileContentLenght = dataInputStream.readInt();
					
					if(fileContentLenght >0) {
						byte[] fileContentByte = new byte[fileContentLenght];
						
						dataInputStream.readFully(fileContentByte,0,fileContentLenght);
						
						//tao cac hang ma chung ta nam giu thong tin
						JPanel jpFileRow = new JPanel();
						jpFileRow.setLayout(new BoxLayout(jpFileRow,BoxLayout.Y_AXIS));
						
						//jlabel
						JLabel jFileName = new JLabel(fileName);
						jFileName.setFont(new Font("Arial",Font.BOLD,20));
						jFileName.setBorder(new EmptyBorder(10, 0, 10, 0));
						
						if(getFileExtension(fileName).equalsIgnoreCase("txt")) {
							jpFileRow.setName(String.valueOf(fileID));
							jpFileRow.addMouseListener( getMyMouseListener());
							
							jpFileRow.add(jFileName);
							jPanel.add(jpFileRow);
							frame.validate();
						}
						else {
							jpFileRow.setName(String.valueOf(fileID));
							jpFileRow.addMouseListener(getMyMouseListener());
							
							jpFileRow.add(jFileName);
							jPanel.add(jpFileRow);
							
							frame.validate();
						}
						
						myFiles.add(new MyFile(fileID, fileName, fileContentByte, getFileExtension(fileName)));
					
						fileID++;
					}
				}	
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	public static MouseListener getMyMouseListener() {
		return new MouseListener() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				JPanel jPanel =(JPanel)((EventObject) e).getSource();
				
				int fileID = Integer.parseInt(jPanel.getName());
				
				for(MyFile myFile: myFiles) {
					if(myFile.getId() ==fileID) {
						JFrame jfPreview = createFrame(myFile.getName(),myFile.getData(),myFile.getFileExtension());
						jfPreview.setVisible(true);
					}
				}
			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
	
	public static JFrame createFrame(String fileName,byte[] fileData, String fileExtension) {
		
		JFrame jFrame = new JFrame("File Downloader");
		jFrame.setSize(400,400);
		
		//jpanel 1
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
		
		//label 1
		JLabel jTitle = new JLabel("File Downloader");
		jTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		jTitle.setFont(new Font("Arial",Font.BOLD,25));
		jTitle.setBorder(new EmptyBorder(20, 0, 10, 0));
		
		//label 2
		JLabel jlPrompt = new JLabel("Are you sure you want to download "+fileName);
		jlPrompt.setFont(new Font("Arial",Font.BOLD,20));
		jlPrompt.setBorder(new EmptyBorder(20, 0, 10, 0));
		jlPrompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//button 1
		JButton jbYes = new JButton("Yes");
		jbYes.setPreferredSize(new Dimension(150,75));
		jbYes.setFont(new Font("Arial",Font.BOLD,20));
		
		//button 2
		JButton jbNo = new JButton("No");
		jbNo.setPreferredSize(new Dimension(150,75));
		jbNo.setFont(new Font("Arial",Font.BOLD,20));
		
		//label 3
		JLabel jlFileContent = new JLabel();
		jlFileContent.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//jpanel 2
		JPanel jpButton = new JPanel();
		jpButton.setBorder(new EmptyBorder(20, 0, 10, 0));
		jpButton.add(jbNo);
		jpButton.add(jbYes);
		
		if(fileExtension.equalsIgnoreCase("txt")) {
			jlFileContent.setText("<html>"+ new String(fileData)+"<html>");
		}
		else {
			jlFileContent.setIcon(new ImageIcon(fileData));
		}
		
		jbYes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File fileToDownload = new File(fileName);
				
				try {
					FileOutputStream fileOutputStream = new FileOutputStream(fileToDownload);
					fileOutputStream.write(fileData);
					fileOutputStream.close();
					if (fileToDownload.exists()) {
						fileToDownload.mkdir();
					}
					jFrame.dispose();
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		jbNo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jFrame.dispose();
			}
		});
		
		jPanel.add(jTitle);
		jPanel.add(jlPrompt);
		jPanel.add(jlFileContent);
		jPanel.add(jpButton);
		
		jFrame.add(jPanel);
		
		return jFrame;
		
	}
	
	public static String getFileExtension(String fileName) {
		//se khong hoat dong voi cai gi do
		int i = fileName.lastIndexOf('.');
		
		if (i >0) {
			return fileName.substring(i+1);
		}
		else {
			return "No extension found.";
		}
	}
	
	public static void main(String[] args) throws IOException {
		new downloadFile();
	}
}
