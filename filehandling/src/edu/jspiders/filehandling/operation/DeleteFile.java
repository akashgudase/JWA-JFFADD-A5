package edu.jspiders.filehandling.operation;

import java.io.File;

public class DeleteFile {

	public static void main(String[] args) {

		File file = new File("D:\\Files\\demo.txt");
		boolean fileIsDeleted = file.delete();
		if (fileIsDeleted)
			System.out.println("File is deleted");
		else
			System.out.println("Something went wrong");

	}

}
