package IOstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class DocGhiFile {
	public static void main(String[] args) throws IOException {
		File file = new File("Hello/test.txt");
		//kiểm tra sự tồn tại của file ta dùng hàm exists()
		if (file.exists()) {
			file.createNewFile(); //để tự tạo file mới t sử dụng hàm createNewFile()
		}
	
		FileInputStream fileInputStream = new FileInputStream(file); //dùng FileInputStream để đọc dữ liệu từ file vào
		//gán biến c bằng fileInputStream và sử dụng hàm .read() để đọc
		int c = fileInputStream.read();
		while (c !=-1) {
			System.out.print((char)c);
			c = fileInputStream.read();
		}
		fileInputStream.close(); //dùng hàm close() để đóng file
		
		//để ghi dữ liệu vào file ta sử dụng FileOutputStream 
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		String n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextLine();
		String s = n;
		fileOutputStream.write(s.getBytes());
		
		fileOutputStream.close();
		
	}
	
}
