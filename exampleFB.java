package Test.OOP.AWT;

import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.FlowLayout; 
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.JCheckBox;

public class exampleFB extends JFrame {
	JFrame f = new JFrame("The Frame");
	JLabel lbSignUp = new JLabel("Sign Up");
	JTextField tffirstName = new JTextField(10);
	JTextField tflastName = new JTextField(10);
	JButton btnSignUp = new JButton("Sign Up");
    JCheckBox checkBox1 = new JCheckBox("male"); 
    JCheckBox checkBox2 = new JCheckBox("female", true);  
	CardLayout cl = new CardLayout();
	
	public exampleFB() {
		//tao 1 container de add cac component vao 
//		this.getContentPane();
		f.setLocation(300,300);
		f.setLayout(new FlowLayout());	
		Container cont = f.getContentPane();
		cont.add(lbSignUp);
		cont.add(tffirstName);
		cont.add(tflastName);
		cont.add(btnSignUp);
		f.setSize(200,200);
		f.pack();
		f.setVisible(true); 
	    checkBox1.setBounds(100,50, 100,50);  
	    checkBox2.setBounds(100,100, 100,100);  
	    f.add(checkBox1);  
	    f.add(checkBox2);  
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);

		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exampleFB();
		
	}

}
