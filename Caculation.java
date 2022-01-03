package Test.OOP.AWT;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout; 
import java.awt.GridLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

import java.awt.CardLayout;
import javax.swing.JCheckBox;
public class Caculation {
	JPanel panel = new JPanel();
	JFrame f = new JFrame("tinh toan");
	JLabel lbNhap = new JLabel(" Nhập n :");
	JTextField tfSoN = new JTextField(10);
	JLabel lbKetqua = new JLabel(" Kết quả:");
//	JTextField ftNhap= new JTextField(10);
	JTextField tfKetqua= new JTextField(10);
	JButton btnTinh = new JButton("Tính giai thừa");
public Caculation () {
	f.setLocation(100,100);
	f.setLayout(new FlowLayout());
	Container cont = f.getContentPane();
	cont.add(lbNhap);
	cont.add(tfSoN);
	cont.add(lbKetqua);
	cont.add(tfKetqua);
	cont.add(btnTinh);
	btnTinh.addActionListener(new ActionListener(){  
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
            JOptionPane.showMessageDialog(null, "Calculation");
            int n = Integer.parseInt(tfSoN.getText());
            int s=1;
            for(int i=1; i<=n;i++) {
            	s=s*i;
            }
            tfKetqua.setText(String.valueOf(s));
		}  
    });
	btnTinh.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){  
            JOptionPane.showMessageDialog(null, "Calculation");
            int n = Integer.parseInt(tfSoN.getText());
            int s= 0;
            for(int i=1; i<=n;i++) {
            	s+=Math.pow(2,i);
            }
            tfKetqua.setText(String.valueOf(s));
	    }  
    });
	f.setSize(200,200);
	f.pack();
	f.setVisible(true);
	
}
	public static void main(String[] args) {
		new Caculation();
	}
}