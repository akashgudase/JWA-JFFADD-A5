package edu.jspiders.serializationanddeserialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeUser {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		File file = new File("D:\\Files\\user.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		User user = (User) objectInputStream.readObject();
		objectInputStream.close();
		fileInputStream.close();
		System.out.println(user);
	}

}
