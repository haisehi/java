package SinhVien;

import java.util.Scanner;

public class SinhVien {
	//fields
	private String hoten;
	private int namsinh ;
	private double diemtoan ;
	private double diemanh ;
	private double diemtin ;
	//get() ,set()
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public int getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	public double getDiemtoan() {
		return diemtoan;
	}
	public void setDiemtoan(double diemtoan) {
		this.diemtoan = diemtoan;
	}
	public double getDiemanh() {
		return diemanh;
	}
	public void setDiemanh(double diemanh) {
		this.diemanh = diemanh;
	}
	public double getDiemtin() {
		return diemtin;
	}
	public void setDiemtin(double diemtin) {
		this.diemtin = diemtin;
	}
	//contructor
	public SinhVien() {
		
	}
	//p.contructor
	public SinhVien(String hoten, int namsinh, double diemtoan, double diemanh, double diemtin) {
		this.hoten = hoten;
		this.namsinh = namsinh;
		this.diemtoan = diemtoan;
		this.diemanh = diemanh;
		this.diemtin = diemtin;
	}
	//nhap thong tin tung doi tuong
	public void nhapThongTin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ho va ten : ");
		this.hoten=sc.nextLine();
		System.out.println("Nhap nam sinh : ");
		this.namsinh=Integer.parseInt(sc.nextLine());
		System.out.println("Nhap diem toan : ");
		this.diemtoan=Double.parseDouble(sc.nextLine());
		System.out.println("Nhap diem anh : ");
		this.diemanh=Double.parseDouble(sc.nextLine());
		System.out.println("Nhap diem tin : ");
		this.diemtin=Double.parseDouble(sc.nextLine());
	}
	//tinh diem trung binh
	public double diemTb () {
		return ((this.diemtoan + this.diemanh + this.diemtin)/3);
	}
	//in thong tin tung doi tuong
	public void inThongTin () {
		System.out.println("ho va ten la : "+this.getHoten() + " nam sinh "+this.namsinh+" co diem trung binh la : "+diemTb());
	}
	public static void main(String[] args) {
		SinhVien acc = new SinhVien(); //khai bao doi tuong 
		int mang[] = new int[3]; // tao mang gom 3 doi tuong 
		SinhVien accSV[] = new SinhVien[3];
		//nhap thong tin cho tung doi tuong trong mang 
		for (int i = 0; i <= 2 ; i++) {
			accSV[i] = new SinhVien();
			accSV[i].nhapThongTin();
		}
		//in tuong doi tuong co trong mang 
		for (int i = 0; i <= 2 ; i++) {
			accSV[i].inThongTin();
		}
		//in doi tuong co diem trung binh lon nhat trong 3 doi tuong 
		double max = accSV[0].diemTb();
		for (int i = 0; i <= 2; i++) {
			if (accSV[i].diemTb() > max) {
			max = accSV[i].diemTb();
			accSV[i].inThongTin();
			} 
		}
		//in ra nhung doi tuong duoc len lop va khong len lop 
		for (int i = 0; i <= 2 ; i++) {
			if (accSV[i].diemanh > 0 & accSV[i].diemtin> 0 & accSV[i].diemtoan > 0 & accSV[i].diemTb() > 5 ) {
				accSV[i].inThongTin();
				System.out.println("du dieu kien len lop ."); // duoc len lop 
			} else {
				accSV[i].inThongTin();
				System.out.println("khong du dieu kien ."); // khong duoc len lop
			}
		}
	}
	
}
