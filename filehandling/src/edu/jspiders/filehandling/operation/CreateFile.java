package edu.jspiders.filehandling.operation;

import java.io.File;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) throws IOException {

		File file = new File("D:\\Files\\demo.txt");
		boolean fileIsCreated = file.createNewFile();
		if (fileIsCreated)
			System.out.println("File is created");
		else
			System.out.println("File already exists");

	}

}
