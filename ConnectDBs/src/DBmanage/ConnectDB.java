package DBmanage;


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
			String connectionUrl = "jdbc:sqlserver://ADMIN\\SQLEXPRESS01:1433;databaseName=NhanVien;user=sa;password=123456";
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
