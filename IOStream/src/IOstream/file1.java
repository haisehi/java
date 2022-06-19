package IOstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/*cách tạo một folder và file trong java
cách sử dụng FileReader
cách sử dụng FileWrite
*/
public class file1 {
	public static void main(String[] args) throws IOException {
		File dir = new File("Hello"); //name folder
		dir.mkdir(); //hàm mldir() dùng để tạo thư mực mới
		if (!dir.exists()) {
			dir.createNewFile();
		}
		
		File file = new File("Hello/test.txt"); //tạo 1 file trong thư mục Hello
		//nếu file không tồn tại thì sẽ tự động tạo một file mới	
		if (!file.exists()) {
			file.createNewFile();
		}
		
		FileReader fileReader = new FileReader(file); //FileReader dùng để đọc file
		int c = fileReader.read();
		while (c !=-1) {
			System.out.print((char)c); 
			c = fileReader.read();
		}
		
		fileReader.close(); //dùng hàm close() để đóng chương trình
		
		//điền một chuỗi vào file
		String s= "Hello Java";
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write(s);//dùng hàm write() để viết ký tự vào file
		
		fileWriter.close();
	}
}
