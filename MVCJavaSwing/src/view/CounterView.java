package view;

import javax.swing.JButton;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.CounterListener;

import javax.swing.*;
import java.awt.*;

import model.CounterModel;

public class CounterView extends JFrame {
	private CounterModel counterModel;
	//khai báo các nút nhấn
	private JButton jButton_up;
	private JButton jButton_down;
	private JLabel jLabel_value;
	private JButton jButton_reset;
	
	//contructor
	public CounterView() {
		this.counterModel=new CounterModel();
		this.init();
		this.setVisible(true);
	}
	//phần này dùng để thiết kế giao diện
	public void init() {
		this.setTitle("counter");
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ActionListener ac = new CounterListener(this);
		
		jButton_up = new JButton("Up");
		jButton_up.addActionListener(ac);//thêm sự kiện vào nút Up
		
		jButton_down= new JButton("Down");
		jButton_down.addActionListener(ac);//thêm sự kiện vào nút Down
		
		jButton_reset = new JButton("reset");
		jButton_reset.addActionListener(ac);//thêm sự kiện vào nút reset
		
		jLabel_value = new JLabel(this.counterModel.getValues()+"",JLabel.CENTER);

		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jButton_up,BorderLayout.WEST);
		jPanel.add(jLabel_value,BorderLayout.CENTER);
		jPanel.add(jButton_down,BorderLayout.EAST);
		jPanel.add(jButton_reset,BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		this.add(jPanel,BorderLayout.CENTER);
	}
	
	public void increment() {
		this.counterModel.increment();
		this.jLabel_value.setText(this.counterModel.getValues()+"");
	}
	
	public void decrement() {
		this.counterModel.decrement();
		this.jLabel_value.setText(this.counterModel.getValues()+"");
	}
	public void reset() {
		this.counterModel.reset();
		this.jLabel_value.setText(this.counterModel.getValues()+"");
	}
}
