package main;

import java.util.ArrayList;

public class DanhSachSinhVien {
	private ArrayList<SinhVien>DanhSach;

	public DanhSachSinhVien() { // contructor rong 
		this.DanhSach= new ArrayList<SinhVien>(); // cach khai bao ArrayList
	}

	public DanhSachSinhVien(ArrayList<SinhVien> danhSach) {
		
		DanhSach = danhSach;
	}
	//1. Thêm sinh viên vào danh sách
	public void ThemSinhVien(SinhVien sv) {
		this.DanhSach.add(sv); //dung de them sinh vien vao danh sach
	}
	//2. In danh sách sinh viên ra màn hình
	public void InDanhSachSinhVien() {
		for (SinhVien sinhVien : DanhSach) {
			System.out.println(sinhVien);
		}
	}
	//3. Kiểm tra danh sách có rỗng hay không
	public boolean kiemtradanhsachrong() {
		return this.DanhSach.isEmpty(); //Returns true if this list contains no elements.

	}
	//4. Lấy ra số lượng sinh viên trong danh sách.
	public int soluongsinhvien() {
		return this.DanhSach.size(); //Returns the number of elements in this list.
	}
	//5. Làm rỗng danh sách sinh viên
	public void lamrongdanhsachsinhvien() {
		this.DanhSach.removeAll(DanhSach);
	}
	//6. Kiểm tra sinh viên có tồn tại hay không dựa trên mã sinh viên.
//	public boolean kiemtratontai(SinhVien sv1) {
//		return this.DanhSach.contains(sv1);//Returns true if this list contains the specified element.
//	}
	//7. Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên .
//	public boolean xoasinhvien(SinhVien sv11) {
//		return this.DanhSach.remove(sv11);
//	}
	//8. Tìm kiếm tất cả sinh viên dựa trên tên được nhập từ bàn phím.
//	public void timsinhvien(String ten) {
//		for (SinhVien sinhVien : DanhSach) {
//			if (sinhVien.getHovaten().indexOf(ten)>=0) {
//				System.out.println(sinhVien);
//			}
//		}
//	}
	//9. Xuất ra danh sách sinh viên có điểm từ cao đến thấp
	
}
