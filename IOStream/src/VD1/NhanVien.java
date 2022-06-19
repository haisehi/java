package VD1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NhanVien {
	public String MaNV;
	public String HoTen;
	public int tuoi;
	public double Luong;
	public String getMaNV() {
		return MaNV;
	}
	public void setMaNV(String maNV) {
		MaNV = maNV;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getLuong() {
		return Luong;
	}
	public void setLuong(double luong) {
		Luong = luong;
	}
	public NhanVien(String maNV, String hoTen, int tuoi, double luong) {
		super();
		MaNV = maNV;
		HoTen = hoTen;
		this.tuoi = tuoi;
		Luong = luong;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "NhanVien [MaNV=" + MaNV + ", HoTen=" + HoTen + ", tuoi=" + tuoi + ", Luong=" + Luong + "]";
	}
	public static void main(String[] args) throws IOException {
		int n;
		String MaNV;
		String Hoten;
		int tuoi;
		double Luong;
		
		FileReader fileReader = null;
		FileWriter fileWriter = new FileWriter("Hello/Nhanvien.txt");
		
		Scanner key = new Scanner(System.in);
		System.out.println("Nhap so nhan vien: ");
		n= key.nextInt();
		NhanVien[] nv=new NhanVien[n];
		for(int i=0; i<n;i++) {
			nv[i] = new NhanVien();
			nv[i].setMaNV(MaNV=key.next());
			nv[i].setHoTen(Hoten=key.next());
			nv[i].setTuoi(tuoi=key.nextInt());
			nv[i].setLuong(Luong=key.nextDouble());
			fileWriter.write(nv[i].toString()+"\n");
			
		}	
		fileWriter.close();
		fileReader = new FileReader("Hello/Nhanvien.txt");
		int c;
		while((c=fileReader.read())!=-1) System.out.print((char)c);
		fileReader.close();
		
		
		
	}
}