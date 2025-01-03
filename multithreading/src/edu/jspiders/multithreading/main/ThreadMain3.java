package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.thread.MyThread3;

public class ThreadMain3 {
	
	public static void main(String[] args) {
		
		MyThread3 thread1 = new MyThread3();
		thread1.setName("Thread 1");
		thread1.setPriority(5);
		
		MyThread3 thread2 = new MyThread3();
		thread2.setName("Thread 2");
		thread2.setPriority(5);
		
		thread1.start();
		thread2.start();
		
	}

}
