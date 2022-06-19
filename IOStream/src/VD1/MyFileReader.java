package VD1;

import java.io.FileReader;
import java.io.IOException;

public class MyFileReader {
	public static void main(String arg[]) throws IOException {
		int i = 0;
		FileReader fileReader = new FileReader("abhishek.txt");
		while ((i = fileReader.read()) != -1)
		System.out.print((char) i);
		fileReader.close();
		}
}
