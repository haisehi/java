package VD1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CoppyCharacters {
	public static void main(String[] args) throws IOException {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			fileReader = new FileReader("Hello/input.txt");
			fileWriter = new FileWriter("Hello/output.txt");
			int c;
			while ((c = fileReader.read()) !=-1) fileWriter.write(c);	
		}finally {
			if(fileReader != null) fileReader.close();
			if(fileWriter != null) fileWriter.close();
				
		}
	}
}
	
