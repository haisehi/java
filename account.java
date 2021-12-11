package basic;

import java.util.Scanner;

public class account {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		baitap1 acc = new baitap1();
//		acc.InputAccount();
//		acc.OutputAccount();
		Scanner k= new Scanner(System.in);
		System.out.println("nhap id");
		int n = k.nextInt();
		
		
		//nhap danh sach cac sinh vien bang mang hoac list
		int mang[] =new int[n];
		baitap1 accArray[] =new baitap1[100];
		for (int i = 0; i <n; i++) {
			accArray[i]= new baitap1();
			accArray[i].InputAccount();
		}
		double min = accArray[0].getBalance();
		// in ra account co balance > 5000
		for (int i = 0; i <n; i++) {
//			if (accArray[i].getBalance()>5000) {
//				accArray[i].OutputAccount();
//			}
			
			//tim ra account co balance it nhat
			if (accArray[i].getBalance() < min) {
				min = accArray[i].getBalance();
				accArray[i].OutputAccount();
			}
		}
	}

}
