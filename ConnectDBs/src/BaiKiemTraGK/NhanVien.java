package BaiKiemTraGK;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBmanage.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NhanVien extends JFrame {
JFrame f = new JFrame("Employee management");
JLabel jLabel_id = new JLabel("ID");
JLabel jLabel_Name = new JLabel("Name");
JLabel jLabel_Address = new JLabel("Address");
JLabel jLabel_Salary = new JLabel("Salary");
JTextField jTextField_ID = new JTextField(10);
JTextField jTextField_Name = new JTextField(10);
JTextField jTextField_Address = new JTextField(10);
JTextField jTextField_Salary = new JTextField(10);
JButton jButton_add = new JButton("Add");
JButton jButton_Edit = new JButton("Edit");
JButton jButton_Delete = new JButton("Delete");
JButton jButton_Search = new JButton("Search");
JButton jButton_Clear = new JButton("Clear");
JButton jButton_Cancel = new JButton("Cancel");

Connection conn; 
Statement stmt ; 
PreparedStatement ps ;
ResultSet rs;

//private Component tbaccount;
JTable tbemp;

public NhanVien() {
    Container con = f.getContentPane();
    f.setLocation(300,300);
    f.setLayout(new GridLayout(10,2));
	
    f.add(jLabel_id);
    f.add(jTextField_ID);
    f.add(jLabel_Name);
    f.add(jTextField_Name);
    f.add(jLabel_Address);
    f.add(jTextField_Address);
    f.add(jLabel_Salary);
    f.add(jTextField_Salary);
    f.add(jButton_add);
    f.add(jButton_Edit);
    f.add(jButton_Delete);
    f.add(jButton_Search);
    f.add(jButton_Clear);
    f.add(jButton_Cancel);
    
    jButton_add.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ConnectDB cn = new ConnectDB();
			int record = cn.executeDB("Insert into NhanVien values('"+jTextField_ID.getText()+"','"+jTextField_Name.getText()+"','"+jTextField_Address.getText()+"','"+jTextField_Salary.getText()+"')");
			
		}
    	
    });
    DisplayNhanVien();
	JScrollPane rate = new JScrollPane(tbemp); 
	f.add(rate);
	f.setSize(200,200);
	f.setVisible(true); 
	f.pack();
    	
}

public void DisplayNhanVien() {
	ConnectDB conn = new ConnectDB();
    rs = conn.ListAccount("Select * from NhanVien");
    String tile[] = {"ID","Name","Address","Salary"};
	DefaultTableModel tm = new DefaultTableModel(tile,0);
    try {
    	while(rs.next()){
    		Object data[] = {rs.getString("ID"),rs.getString("Name"),rs.getString("Address"),rs.getString("Salary")};	        		
    		tbemp = new JTable(tm);
    		tm.addRow(data);
    	}}
    
    	catch (Exception e) {
			// TODO: handle exception
		}
    }

public static void main(String[] args) {
	new NhanVien();
}
}
