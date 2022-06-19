package updatejbdc;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class SANPHAM extends JFrame{
	JTable tbaccount = new JTable();

	public SANPHAM() {
		super("SAN PHAM");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container con = getContentPane();
        //panel chính
        JPanel jpnT=new JPanel();
        jpnT.setLayout(new GridLayout(2,1));
        
        
        
        //panel con thứ nhất
        JPanel jpnMain = new JPanel();
        jpnMain.setLayout(new BorderLayout());
        Border bd= BorderFactory.createLineBorder(Color.RED);
        TitledBorder tt= BorderFactory.createTitledBorder(bd,"Nhap thong tin san pham");
        jpnMain.setBorder(tt);
       
        
        JPanel jpn1 = new JPanel();
        jpn1.setLayout(new GridLayout(9,0));
        
            JLabel lb1 = new JLabel("Ma SP: ");
            jpn1.add(lb1);
            JLabel lb2 = new JLabel("Ten: ");
            jpn1.add(lb2);     
            JLabel lb3 = new JLabel("Loai: ");
            jpn1.add(lb3);
            JLabel lb4 = new JLabel("Size: ");
            jpn1.add(lb4);
            JLabel lb5 = new JLabel("So Luong: ");
            jpn1.add(lb5);
            JLabel lb6 = new JLabel("Gia: ");
            jpn1.add(lb6);
            JLabel lb7 = new JLabel("Von: ");
            jpn1.add(lb7);
            JLabel lb8 = new JLabel("Loi: ");
            jpn1.add(lb8);
            JLabel lb9 = new JLabel("Doanh thu: ");
            jpn1.add(lb9);
               
        jpnMain.add(jpn1, BorderLayout.WEST);
        
        JPanel jpn2 = new JPanel();
        jpn2.setLayout(new GridLayout(9,0));
        
            JTextField tf1 = new JTextField(20);
            jpn2.add(tf1);
            JTextField tf2 = new JTextField(20);
            jpn2.add(tf2);
            JComboBox cbo1 = new JComboBox();
            cbo1.addItem("Thuc an");
            cbo1.addItem("Nuoc uong");
            jpn2.add(cbo1);
            JComboBox cbo2 = new JComboBox();
            cbo2.addItem("M");
            cbo2.addItem("L");
            jpn2.add(cbo2);
            JTextField tf3 = new JTextField(20);
            jpn2.add(tf3);
            JTextField tf4 = new JTextField(20);
            jpn2.add(tf4);
            JTextField tf5 = new JTextField(20);
            jpn2.add(tf5);
            JTextField tf6 = new JTextField(20);
            jpn2.add(tf6);
            JTextField tf7 = new JTextField(20);
            jpn2.add(tf7);
            
           
        
        jpnMain.add(jpn2, BorderLayout.CENTER);
        
        JPanel jpn3 = new JPanel();
        jpn3.setLayout(new GridLayout(9,0));
        	//add 1 button fake
        	JButton btf1 = new JButton();
            jpn3.add(btf1);
            btf1.setVisible(false);
            JButton btf2 = new JButton();
            jpn3.add(btf2);
            btf2.setVisible(false);
            JButton btf3 = new JButton();
            jpn3.add(btf3);
            btf3.setVisible(false);
            JButton btf4 = new JButton();
            jpn3.add(btf4);
            btf4.setVisible(false);
           
            //2 button real
            JButton bt1 = new JButton("Them");
            jpn3.add(bt1);
            JButton bt2 = new JButton("Xoa");      
            jpn3.add(bt2);
            JButton bt3 = new JButton("Sua");      
            jpn3.add(bt3);
            JButton bt4 = new JButton("Thoat");      
            jpn3.add(bt4);
            JButton bt5 = new JButton("Tong");      
            jpn3.add(bt5);
        
        jpnMain.add(jpn3, BorderLayout.EAST);
        
        //add jpnMain(khung phía trên) vào jpnT(panel chính)
        jpnT.add(jpnMain);

        
        JPanel jpnMain2 = new JPanel();
        jpnMain2.setLayout(new BorderLayout());
        Border bd2= BorderFactory.createLineBorder(Color.RED);
        TitledBorder tt2= BorderFactory.createTitledBorder(bd2,"Hien thi");
        jpnMain2.setBorder(tt2);
        
		JScrollPane sp = new JScrollPane(tbaccount);    
		con.add(sp);
        
        DefaultTableModel cot = new DefaultTableModel();
		cot.addColumn("MaSP");
		cot.addColumn("Ten");
		cot.addColumn("Loai");
		cot.addColumn("Size");
		cot.addColumn("SoLuong");
		cot.addColumn("Gia");
		cot.addColumn("Von");
		cot.addColumn("Loi");
		cot.addColumn("DoanhThu");
		
		
		
		
		jpnMain2.add(sp, BorderLayout.CENTER);
		jpnMain2.setBorder(tt2);
		jpnT.add(jpnMain2);
		con.add(jpnT);
		
		 
        //lay du lieu tu bang len 
		tbaccount.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbaccount.getSelectedRow();
				String masp = (String)tbaccount.getValueAt(row, 0);
				tf1.setText(masp);
				String ten = (String)tbaccount.getValueAt(row, 1);
				tf2.setText(ten);
				String loai = (String)tbaccount.getValueAt(row, 2);
				cbo1.setSelectedItem(loai);
				String size = (String)tbaccount.getValueAt(row, 3);
				cbo2.setSelectedItem(size);
				String sl = (String)tbaccount.getValueAt(row, 4);
				tf3.setText(sl);
				String gia = (String)tbaccount.getValueAt(row, 5);
				tf4.setText(gia);
				String von = (String)tbaccount.getValueAt(row, 6);
				tf5.setText(von);
				String loi = (String)tbaccount.getValueAt(row, 7);
				tf6.setText(loi);
				String doanhthu = (String)tbaccount.getValueAt(row, 8);
				tf7.setText(doanhthu);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});

		//add jpnMain2(panel con thứ 2) vào panel chính
        jpnT.add(jpnMain2);
        //add panel chính vào giao diện
        con.add(jpnT);
	}
	

	public static void main(String[] args) throws Exception {
		SANPHAM sw = new SANPHAM();
		sw.setSize(400, 400);
		sw.setLocationRelativeTo(null);
		sw.setVisible(true);
		
	}
}