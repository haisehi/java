package VD2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class readfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("VD2/vidu.txt");
//		de doc du lieu tu file t su dung FileInputStream
		FileInputStream fileInputStream = new FileInputStream(file);
		
//  	chỉ đọc được một kí tự đầu tiên		
//		int code =fileInputStream.read(); //dùng hàm read() để đọc từng kí tự 1
//		char c = (char)code;// ép kiểu về dạng kí tự
//		System.out.println("c>"+c);	
		
//		sử dụng while để đọc hết tất cả kí tự có trong file

		int code ;
		//cach 1:
//		while ((code =fileInputStream.read())!=-1) {
//			System.out.print((char)code);
//		}


		//cach 2:
		StringBuffer buffer = new StringBuffer();
		while ((code =fileInputStream.read())!=-1) {
			buffer.append((char)code);
		}
		String content = buffer.toString();
		System.out.println(content);
		fileInputStream.close();
	}

}
