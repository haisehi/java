package AWTBasic;

import java.awt.Button;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Employee extends JFrame {
	JFrame f = new JFrame("Employee Details ");
	JLabel lbUser = new JLabel("Name");
	JTextField tfUser = new JTextField(10);
	JLabel lbGender = new JLabel("Gender");
	JRadioButton rdoMale = new JRadioButton("Male");
	JRadioButton rdoFemale = new JRadioButton("Female");
	ButtonGroup bgGender = new ButtonGroup();
	String grade[] = {"Elementary","High school","Undergraduate","Mater","Doctor"};
	JLabel lblGrade = new JLabel("Grade");
	JList lstGrade = new JList(grade);
	
	JLabel lblDepartment = new JLabel("Department");
	String department[] = {"VKU","Axon","FPT","Enclave"};
	JComboBox cboDepartment = new JComboBox(department);
	
	JButton btnSave = new JButton("Add employee");
	
	
	public Employee() {
		Container cont = f.getContentPane();
		f.setLayout(new GridLayout(6,2));
		f.setLocation(300,100);
		f.add(lbUser);
		f.add(tfUser);
		f.add(lbGender);
		f.add(rdoMale);
		f.add(rdoFemale);
		bgGender.add(rdoMale);
		bgGender.add(rdoFemale);
		f.add(lblGrade);
		f.add(lstGrade);
		f.add(lblDepartment);
		f.add(cboDepartment);
		f.add(btnSave);
		f.setSize(300,700);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Employee();
	}

}
