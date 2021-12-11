package AWTBasic;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	JFrame f = new JFrame("Login");
	JLabel lbUser = new JLabel("Username");
	JTextField tfUser = new JTextField(10);
	JLabel lbPass = new JLabel("Password");
	JPasswordField tfPass =new JPasswordField(10);
	JButton btnLogin = new JButton("Login");
	JButton btnExit = new JButton("Exit");
	
	public Login() {
		Container cont = f.getContentPane();
		f.setLayout(new GridLayout(3,2));
		f.setLocation(200,350);
		cont.add(lbUser);
		cont.add(tfUser);
		cont.add(lbPass);
		cont.add(tfPass);
		cont.add(btnLogin);
		btnLogin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Hello "+tfUser.getText());
				Employee emp = new Employee();
				emp.setVisible(true);
				f.setVisible(false);
			}
			
		});
		cont.add(btnExit);
		
		f.setSize(200,200);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
