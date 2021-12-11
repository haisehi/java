package deThiGiuaKy;

import java.util.ArrayList;
import java.util.Scanner;

public class VanList {
	private ArrayList<Van>Vanlist;
	
	
	public VanList() {
		this.Vanlist= new ArrayList<Van>();
	}

	public VanList(ArrayList<Van> vanlist) {
		Vanlist = vanlist ;
	}
	
	public void addObjectVan(Van v) {
		this.Vanlist.add(v);
	}
	
	public void ViewVan() {
		for (Van van : Vanlist) {
			System.out.println(van);
		}
	}
	
    public void priceForSaleGreater20() {
        boolean flag = true;
        for (int i = 0; i < this.Vanlist.size(); i++)
            if (this.Vanlist.get(i).priceForSale() > 20) {
                System.out.println(this.Vanlist.get(i).toString());
                flag = false;
            }
        if (flag)
            System.out.println("Khong co Van nao co PriceForSale lon hon 20");
    }
	
	public int soluongVan() {
		return this.Vanlist.size();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luachon = 0 ;
		VanList vl = new VanList();
		do {
			System.out.println("---MENU DRIVEN PROGRAM---");
			System.out.println("--lua chon cua ban --");
			System.out.println(
					 "1.Them 5 object Van vao danh sach .\n"
					+"2.In ra danh sach Van .\n"
					+"3.In ra danh sach Van co PriceForSale lon hon 20 .\n"
					+"4.Tinh tong so Van co trong danh sach .\n"
					+"0.ket thuc chuong trinh"
					);
			luachon = Integer.parseInt(sc.nextLine());
			switch (luachon) {
			case 1 :
				System.out.println("Nhap so doi tuong co truong can nhap : ");
				int size = Integer.parseInt(sc.nextLine());
				for(int i=0 ; i < size; i++) {
				System.out.println("Nhap ma ID : ");
				int id=Integer.parseInt(sc.nextLine());
				System.out.println("Nhap ten : ");
				String name=sc.nextLine();
				System.out.println("Nhap Price : ");
				double price=Double.parseDouble(sc.nextLine());
				System.out.println("Nhap extaOut : ");
				double extraOut=Double.parseDouble(sc.nextLine());
				System.out.println("Nhap quantity : ");
				int quantity=Integer.parseInt(sc.nextLine());
				Van v = new Van(id, name, price, extraOut, quantity);
				vl.addObjectVan(v);
				}
			break;
			case 2 :
				vl.ViewVan();
				break;
			case 3 :
				vl.priceForSaleGreater20();
				
			case 4 :
				System.out.println("So luong Van : "+vl.soluongVan());
			}
			

		} while (luachon != 0);
		
	}
}
