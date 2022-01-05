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
	public  Connection connectSQL() {
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
			connectSQL();
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
			connectSQL();
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
				connectSQL();
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
---------------------------------------------------------------------------------------------------------------------------------------------
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
import javax.swing.JComboBox;
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
	JLabel lbUser = new JLabel("Username");
	JTextField tfUser = new JTextField(10);
	JLabel lbPassword = new JLabel("Password");
	JTextField tfPass = new JPasswordField(10);
	//combobox
	JLabel lbDepart = new JLabel("Department");
	String[] Department = {"VKU","FPT","DUT","EDU"};
	JComboBox cboDepartment = new JComboBox(Department);
	//checkbox
	JCheckBox cbCS = new JCheckBox("computer science");
    JCheckBox cbEconomic = new JCheckBox("Economic");
	
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
		f.setLayout(new GridLayout(7,2));	
		Container cont = f.getContentPane();
		cont.add(lbUser);
		cont.add(tfUser);
		cont.add(lbPassword);
		cont.add(tfPass);
		cont.add(rdoMale);
		cont.add(rdoFemale);
		br.add(rdoMale);
		br.add(rdoFemale);
		cont.add(lbDepart);
		cont.add(cboDepartment);
	    cbCS.setBounds(100,50, 100,50);  
	    cbEconomic.setBounds(100,100, 100,100);
		cont.add(cbCS);
		cont.add(cbEconomic);
		cont.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectDB cn = new ConnectDB();
				String Gender = "";
				if(rdoFemale.isSelected()) Gender = rdoFemale.getText();
				else Gender = rdoMale.getText();
				String depart = cboDepartment.getSelectedItem().toString();
				String Faculty = "";
				if(cbCS.isSelected()) Faculty += cbCS.getText() +";";
				if(cbEconomic.isSelected()) Faculty += cbEconomic.getText();
				//int record = cn.executeDB("Insert into account values('"+tfUser.getText()+"','"+tfPass.getText()+"','"+Gender+"','"+depart+"','"+Faculty+"')");
				String sql = "Exec sp_AddUser '"+tfUser.getText()+"','"+tfPass.getText()+"','"+Gender+"','"+depart+"','"+Faculty+"'";
				//System.out.println(sql);
				//int record = cn.executeDB("Exec sp_AddUser1 '"+tfUser.getText()+"','"+tfPass.getText()+"','"+Gender+"','"+depart+"','"+Faculty+"'");
				
				//dung PreparedStatement
				conn = cn.connectSQL();
				try {
					ps = conn.prepareStatement("Exec sp_AddUser1 ?,?,?,?,?");
					ps.setString(1, tfUser.getText());
					ps.setString(2, tfPass.getText());
					ps.setString(3, Gender);
					ps.setString(4, depart);
					ps.setString(5, Faculty);
					int record  = ps.executeUpdate();
					if(record > 0) JOptionPane.showMessageDialog(null, "Success");
					else JOptionPane.showMessageDialog(null, "Fail");
				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}

			}			
		});
		cont.add(btnChange);
		btnChange.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){ 
		    	ConnectDB cnn = new ConnectDB();
		    	int record= cnn.executeDB("Update Account set Password='"+tfPass.getText()+"' where Username ='"+tfUser.getText()+"' ");
		    	if(record>0) JOptionPane.showMessageDialog(null, "Change Pass sucessfully!");
		    	else JOptionPane.showMessageDialog(null, "Error");
	    }  
	    });
		cont.add(btnDelete);
		btnDelete.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	ConnectDB connectDB = new ConnectDB();
		    	String sql = "DELETE FROM account WHERE Username = ? ";
		    	conn = connectDB.connectSQL();
		    	try {
					ps = conn.prepareStatement(sql);
					ps.setString(1,tfUser.getText());
					int no_row = ps.executeUpdate();
					if(no_row > 0) {
						System.out.println("A user is deleted");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
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
		Display();
		 
		JScrollPane sp = new JScrollPane(tbaccount);    
		cont.add(sp);
		f.setSize(200,200);
		f.pack();
		f.setVisible(true); 	
	}
	// jtable
	public void Display() {
		ConnectDB conn = new ConnectDB();
        rs = conn.ListAccount("Select * from account");
        String tile[] = {"Username","Password","Gender","Department","Faculty"};
		DefaultTableModel tm = new DefaultTableModel(tile,0);
        try {
        	while(rs.next()){
        		Object data[] = {rs.getString("Username"),rs.getString("Password"),rs.getString("gender"),rs.getString("department"),rs.getString("Faculty")};	        		
        		tbaccount = new JTable(tm);
        		tm.addRow(data);
        	}
    }
    catch(SQLException e){
    	e.printStackTrace();
    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new exampleFB();
		
	}

}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
create procedure sp_AddUser1 @Username varchar(50),@Password varchar(50), @gender varchar(10),@Department nvarchar(50),@Faculty nvarchar(50)
as
begin 
	Insert into account values(@Username,@Password,@gender,@Department,@Faculty)
end
Exec sp_AddUser1 '"+tfUser.getText()+"','"+tfPass.getText()+"','"+Gender+"','"+depart+"','"+Faculty+"'
