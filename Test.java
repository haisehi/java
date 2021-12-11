package Test;

import java.util.Scanner;

import main.DanhSachSinhVien;
import main.SinhVien;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		int luachon = 0;
		do {
			System.out.println("-----Menu-----");
			System.out.println("Chọn chức năng :");
			System.out.println(
					 "1. Thêm sinh viên vào danh sách.\n"
					+"2. In danh sách sinh viên ra màn hình.\n"
					+"3. Kiểm tra danh sách có rỗng hay không.\n"
					+"4. Lấy ra số lượng sinh viên trong danh sách.\n"
					+"5. Làm rỗng danh sách sinh viên.\n"
					+"6. Kiểm tra sinh viên có tồn tại hay không dựa trên mã sinh viên.\n"
					+"7. Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên .\n"
					+"8. Tìm kiếm tất cả sinh viên dựa trên tên được nhập từ bàn phím.\n"
					+"9. Xuất ra danh sách sinh viên có điểm từ cao đến thấp.\n"
					+"0. thoát "
					);
			luachon=Integer.parseInt(sc.nextLine());
			switch(luachon) {
			case 1 : //1. Thêm sinh viên vào danh sách
				System.out.println("nhập mã sinh viên :");
				String id=sc.nextLine();
				System.out.println("nhập họ và tên sinh viên :");
				String hovaten = sc.nextLine();
				System.out.println("nhập năm sinh : ");
				int namsinh = Integer.parseInt(sc.nextLine());
				System.out.println("nhập điểm trung bình : ");
				double diemtrungbinh = Double.parseDouble(sc.nextLine());
				SinhVien sv = new SinhVien(id, hovaten, namsinh, diemtrungbinh);
				dssv.ThemSinhVien(sv);
				
				
				break;
			case 2 ://2. In danh sách sinh viên ra màn hình
				dssv.InDanhSachSinhVien();
				
				break;
			case 3 ://3. Kiểm tra danh sách có rỗng hay không.
				System.out.println("kiểm tra danh sách rỗng hay không : "+dssv.kiemtradanhsachrong());
				
				break;
			case 4 ://4. Lấy ra số lượng sinh viên trong danh sách.
				System.out.println("số lượng sinh viên có trong danh sách là : "+dssv.soluongsinhvien());
				
				break;
			case 5 ://5. Làm rỗng danh sách sinh viên.
				System.out.println("Danh sách đã bị làm rỗng : ");
				dssv.lamrongdanhsachsinhvien();
				
				break;
//			case 6 ://6. Kiểm tra sinh viên có tồn tại hay không dựa trên mã sinh viên.
//				System.out.println("nhập mã sinh viên :");String id1=sc.nextLine();
//				SinhVien sv1 = new SinhVien(id1);
//				System.out.println("kiem tra sinh vien co trong danh sach : "+ dssv.kiemtratontai(sv1));
//
//			case 7 ://7. Xóa một sinh viên ra khỏi danh sách dựa trên mã sinh viên 
//				System.out.println("nhập mã sinh viên :");String id11=sc.nextLine();
//				SinhVien sv11 = new SinhVien(id11);
//				System.out.println("kiem tra sinh vien co trong danh sach : "+ dssv.xoasinhvien(sv11));
//				
//				break;
//			case 8 :
//				
//				break;
//			case 9 :
//				
//				break;
				
			}
			
		} while (luachon != 0);
	}

}
