import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class notepad extends JFrame {
	JFrame f = new JFrame("The Frame");
	JTextArea tfwrite = new JTextArea(100,50);
	JButton btnenter = new JButton("Enter");
	
	public notepad() {
		//tao 1 container de add cac component vao 
//		this.getContentPane();
		f.setLocation(300,300);
		f.setLayout(new GridLayout(1,1));	
		Container cont = f.getContentPane();
		cont.add(tfwrite);
		cont.add(btnenter);
		f.setSize(500,500);
		f.pack();
		f.setVisible(true); 

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new notepad();
		
	}
}
