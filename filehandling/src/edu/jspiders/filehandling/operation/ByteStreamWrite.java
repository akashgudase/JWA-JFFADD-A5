package edu.jspiders.filehandling.operation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {

	public static void main(String[] args) throws IOException {

		byte[] password = { 'A', 'k', 'a', 's', 'h', '@', '2', '4' };

		File file = new File("D:\\Files\\demo.txt");
		if (file.exists()) {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(password, 5, 3);
			fileOutputStream.close();
			System.out.println("Data is written to a file");
		} else {
			file.createNewFile();
			System.out.println("File is created");
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(password, 5, 3);
			fileOutputStream.close();
			System.out.println("Data is written to a file");
		}

	}

}
