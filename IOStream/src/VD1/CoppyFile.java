package VD1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import IOstream.file1;

public class CoppyFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fin = null;
		FileOutputStream fout = null;
		fin = new FileInputStream("Hello/a.txt");
		fout = new FileOutputStream("Hello/xyz.txt");
		byte[] buffer = new byte[1024];
		int bytesRead;
		while ((bytesRead = fin.read(buffer)) > 0) {
		fout.write(buffer, 0, bytesRead);
		}
		fin.close();
		fout.close();
		}
}
