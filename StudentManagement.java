package Test.OOP.Chapter3And4;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
public class StudentManagement {
	public StudentManagement() {
		// create a contructor
		addstudent();
		sortByAverage();
	}
	
	Vector<sinhvien> vsinhvien = new Vector<sinhvien>();
	Enumeration<sinhvien> esinhvien ;
	
	//add student 
	public void addstudent() {
		int n ;
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap vao so sinh vien : ");
		n = sc.nextInt();
		for (int i = 0; i < n ; i++) {
			sinhvien st = new sinhvien();
			st.input();
			vsinhvien.add(st);
		}
	}
	// dua cac phan tu trong vector ve mang student
	// vector -> enumeration -> mang sinh vien 
	public void sortByAverage() {
		sinhvien [] arrsinhvien = new sinhvien[vsinhvien.size()];
		esinhvien = vsinhvien.elements();
		int index = 0 ; // index la chi so cua mang 
		while(esinhvien.hasMoreElements()) {  // hasMoreElements Kiểm tra xem kiểu liệt kê này có chứa nhiều phần tử hơn không.
			arrsinhvien[index] = (sinhvien)esinhvien.nextElement();
			index++; //dung de nhap cac phan tu tiep theo 
		}
		Arrays.sort(arrsinhvien);
		for (int i = 0; i < arrsinhvien.length; i++) {
			System.out.println("mang sau khi sap xep ");
			System.out.println(arrsinhvien[i].getName()+"co diem trung binh "+arrsinhvien[i].getAvg());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//tao 1 vector kieu student  , dung enumeration de chua cac elements cua vector
		new StudentManagement();
	}

}
