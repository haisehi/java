package VD2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws IOException {
		//file class
		File file = new File("VD2/vidu.txt");
		//kiểm tra file đã tồn tại hay không
		if (file.exists()) {
			System.out.println("File is found");
		}
		//de ghi du lieu vao file ta dung FileOutputStream 
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		Scanner sc = new Scanner(System.in);
//		nhap chuoi co san vao file
//		String line = "Hello World";
//		byte[] b = line.getBytes(); 
//		fileOutputStream.write(b);
		
//		nhap chuoi tu ban phim cho den khi nao muon dung thi dung	
		System.out.println("write");
		for(;;) { //su dung vong for va cho chay den vo han
			String line = sc.nextLine() +"\n";
			byte[] b = line.getBytes();
			fileOutputStream.write(b); //dung de viet du lieu ra file
			System.out.println("continue Y/N");
			String choose = sc.nextLine();
			if (choose.equalsIgnoreCase("N")) {
				break;
			}
		}
		fileOutputStream.close();

		
	}
}
