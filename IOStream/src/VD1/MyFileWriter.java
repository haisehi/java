package VD1;

import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriter {
	public static void main(String arg[]) throws IOException {
		FileWriter fileWriter = new FileWriter("abhishek.txt");
		String s = "this article complete for all of you for learning purpose";
		char ch[] = s.toCharArray();
		for (int i = 0; i < ch.length; i++)
		fileWriter.write(ch[i]);
		fileWriter.close();
		}
}
