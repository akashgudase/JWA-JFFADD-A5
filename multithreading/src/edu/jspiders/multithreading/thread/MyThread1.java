package edu.jspiders.multithreading.thread;

public class MyThread1 implements Runnable {

	@Override
	public void run() {
		for (int i = 1; i <= 10000; i++) {
			System.out.println(i);
		}
	}

}