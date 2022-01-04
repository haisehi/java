package DBManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDB {
	Connection conn; //Một kết nối (phiên) với một cơ sở dữ liệu cụ thể.
	Statement stmt ; //Đối tượng được sử dụng để thực thi một câu lệnh SQL tĩnh và trả về kết quả mà nó tạo ra.
	PreparedStatement ps ;
	ResultSet rs;
	public  Connection connect() {
		// để kết nối đến csdl
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Trả về đối tượng Lớp được liên kết với lớp hoặc giao diện có tên chuỗi đã cho.
			String connectionUrl = "jdbc:sqlserver://HAISEHI\\SQLEXPRESS:1433;databaseName=StudentManage;user=sa;password=123456";
			conn = DriverManager.getConnection(connectionUrl);//kết nối với cơ sở dữ liệu
			System.out.println("Connect...");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(); //in ra lỗi
		}
		return conn;
	}
	public int executeDB(String sql) { //INSERT , UPDATE , DELETE
		int record=0; //bảng ghi
		try {
			connect();
			stmt = conn.createStatement(); //Tạo một đối tượng Statement để gửi các câu lệnh SQL đến cơ sở dữ liệu
			record = stmt.executeUpdate(sql); //số lượng hàng thay đổi sau khi thực hiện 1 trong 3 câu lệnh trên
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				conn.close(); //đóng tất cả connection 
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return record;
	}
	public int executeDBPrepare(String sql) { //INSERT , UPDATE , DELETE
		int record=0; //bảng ghi
		try {
			connect();
			ps = conn.prepareStatement(sql); 
			record = ps.executeUpdate(); 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				conn.close(); //đóng tất cả connection 
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return record;
	}
	//truy xuat csdl
		public ResultSet ListAccount(String sql) {		
			try {
				connect();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			finally {
				try {
					//conn.close();
					//stmt.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			return rs;
		}

}
-------------------------------------------------------------------------------------------------
package Business;

import DBManage.ConnectDB;

public class accountManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectDB cn = new ConnectDB();
		//cn.connect();
		cn.executeDB("Insert into account values('test123','abc')");
	}
}
---------------------------------------------------------------------------------------------
package Business;

import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout; 
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import DBManage.ConnectDB;

import java.awt.CardLayout;
import javax.swing.JCheckBox;

public class exampleFB extends JFrame {
	JFrame f = new JFrame("The Frame");
	JLabel lbSignUp = new JLabel("Sign Up");
	JTextField tffirstName = new JTextField(10);
	JPasswordField tfPass = new JPasswordField(10);
	JButton btnSignUp = new JButton("Sign Up");
	JRadioButton rdoMale = new JRadioButton("Male");
	JRadioButton rdoFemale = new JRadioButton("Female");
	ButtonGroup br = new ButtonGroup();
	JButton btnChange = new JButton("Change");
	JButton btnDelete = new JButton("Delete");
	JButton btnList = new JButton("List");
	
	
	
	PreparedStatement ps ;
	Connection conn;
	ResultSet rs;
	
	public exampleFB() {
		//tao 1 container de add cac component vao 
//		this.getContentPane();
		f.setLocation(300,300);
		f.setLayout(new FlowLayout());	
		Container cont = f.getContentPane();
		cont.add(lbSignUp);
		cont.add(tffirstName);
		cont.add(tfPass);
		cont.add(rdoMale);
		cont.add(rdoFemale);
		br.add(rdoMale);
		br.add(rdoFemale);
		
		cont.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectDB cnn = new ConnectDB();
				String gender ="";
				if(rdoMale.isSelected()) gender=rdoMale.getText();
				else gender = rdoFemale.getText();
				cnn.executeDB("Insert into account values( '"+tffirstName.getText()+"','"+tfPass.getText()+"','"+gender+"')");
			}			
		});
		cont.add(btnChange);
		btnChange.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	ConnectDB cnn = new ConnectDB();
		    	int record= cnn.executeDB("Update Account set Password='"+tfPass.getText()+"' where Username ='"+tffirstName.getText()+"' ");
		    	if(record>0) JOptionPane.showMessageDialog(null, "Change Pass sucessfully!");
		    	else JOptionPane.showMessageDialog(null, "Error");
	            
	    }  
	    });
		cont.add(btnDelete);
		btnDelete.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	ConnectDB cnn = new ConnectDB();
		    	String gender="";
		    	if(rdoMale.isSelected()) gender=rdoMale.getText();
		    	else gender = rdoFemale.getText();
		    	int record = cnn.executeDB("Delete Account where Username ='"+tffirstName.getText()+"'");
		    	if(record>0) JOptionPane.showMessageDialog(null, "Delete Account sucessfully!");
		    	else JOptionPane.showMessageDialog(null, "Error");
	    }  
	    });
		cont.add(btnList);
		btnList.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	ConnectDB cnn = new ConnectDB();
		    	String gender="";
		    	if(rdoMale.isSelected()) gender=rdoMale.getText();
		    	else gender = rdoFemale.getText();
		    	rs = cnn.ListAccount("exec [sp_SelectByGender] '"+gender+"' ");
		    	try {
					while(rs.next()) {
						System.out.println("Username ="+rs.getString("Username"));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
	    }  }
	    );
		
		f.setSize(200,200);
		f.pack();
		f.setVisible(true); 	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exampleFB();
		
	}

}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE PROCEDURE sp_SelectByGender @gender VARCHAR(10)
AS
	select * from account where gender = @gender 
