package edu.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CharStreamRead {

	public static void main(String[] args) throws IOException {

		File file = new File("D:\\Files\\demo.txt");
		String data = "";
		if (file.exists()) {
			FileReader fileReader = new FileReader(file);
			int ascii = -1;
			while ((ascii = fileReader.read()) != -1) {
				data += (char) ascii;
			}
			fileReader.close();
			System.out.println(data);
		} else
			System.out.println("File does not exist");

	}

}
