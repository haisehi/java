package VD2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadertest {
	public static void main(String[] args) throws IOException {
		FileReader reader = null;		
		//BufferedReader dùng để đọc dữ liệu trên 1 dòng (dòng đầu tiên)
		//sử dụng giống FileInputStream
		BufferedReader bufferedReader = null;
		reader = new FileReader("VD2/vidu.txt");
		bufferedReader = new BufferedReader(reader);
		
//		//đọc dữ liệu trên 1 dòng (dòng đầu tiên)
//		string line = bufferedReader.readLine();
//		System.out.println(line);
		//đọc dữ liệu trên nhiều dòng
		String line;
		while ((line = bufferedReader.readLine())!=null) {
			System.out.println(line);
		}
		reader.close();
		bufferedReader.close();
	}
}
