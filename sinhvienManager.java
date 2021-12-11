package Test.OOP.Chapter3And4;

import java.util.Vector;
import java.util.jar.Attributes.Name;
import java.util.Enumeration;
import java.util.Scanner;
public class sinhvienManager {
	//ham khoi tao sinhvienManager
	public sinhvienManager() {
		this.addsinhvien();
		this.viewsinhvien();
//		this.searchsinhvien("y"); // nhap t khoa can tim kiem
//		this.searchNamesinhvien("hello");
//		this.sinhvienavg();
	}
	// create default vector
	Vector<sinhvien> vsinhvien = new Vector<sinhvien>();
	//nhap so luong sinh vien
	public void addsinhvien() {
		int n ; // so doi tuong co trong mang
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of students : ");
//		n = Integer.parseInt(sc.nextLine());
		n = Integer.parseInt(sc.nextLine());	//dung de nhap vao	
		for (int i = 0; i < n; i++) {
			sinhvien s = new sinhvien();
			s.input();
			vsinhvien.add(s);
		}
	}
	//in sinh vien trong vector
	public void viewsinhvien() {
		//enumeration : lay danh sach sinh vien trong vector va luu tru
		Enumeration<sinhvien> esinhvien = vsinhvien.elements();
		while(esinhvien.hasMoreElements()) { //hasMoreElements dung de kiem tra xem phan tu co ton tai ay khong
			sinhvien s = (sinhvien)esinhvien.nextElement(); // nextElement dung de in ra man hinh phan tu tiep theo
			s.Output();
		}
	}
	//tim kiem sinh vien co ten abc
	public void searchsinhvien(String name) {
		//enumeration : lay danh sach sinh vien trong vector va luu tru
		Enumeration<sinhvien>esinhvien = vsinhvien.elements();
		while(esinhvien.hasMoreElements()) {
			sinhvien s = (sinhvien)esinhvien.nextElement();
			if(s.getName().contains(name)) {
				s.Output();
			}
		}
	}
	public void searchNamesinhvien(String name) {
		//enumeration : lay danh sach sinh vien trong vector va luu tru
		Enumeration<sinhvien>esinhvien = vsinhvien.elements();
		while(esinhvien.hasMoreElements()) {
			sinhvien s = (sinhvien)esinhvien.nextElement();
			if(s.getName().startsWith(name)) {
				s.Output();
			}
		}
	}
	//in ra danh sach sinh vien co diem trung binh duoi 5
	public void sinhvienavg() {
		Enumeration<sinhvien>esinhvien = vsinhvien.elements();
		while(esinhvien.hasMoreElements()) {
			sinhvien s = (sinhvien)esinhvien.nextElement();
			if(s.getAvg() < 5) {
				s.Output();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sinhvienManager sm = new sinhvienManager();
		

	}

}
