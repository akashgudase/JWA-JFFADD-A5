package edu.jspiders.multithreading.main;

public class Main {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Task task1 = new Task();
		task1.run();
		
		Task task2 = new Task();
		task2.run();
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start + "ms");
	}

}
