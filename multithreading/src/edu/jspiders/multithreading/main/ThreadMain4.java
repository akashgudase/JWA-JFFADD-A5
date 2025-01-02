package edu.jspiders.multithreading.main;

import edu.jspiders.multithreading.resource.Counter;
import edu.jspiders.multithreading.thread.MyThread4;

public class ThreadMain4 {

	public static void main(String[] args) throws InterruptedException {

		Counter counter = new Counter(0);

		MyThread4 thread1 = new MyThread4(counter);

		MyThread4 thread2 = new MyThread4(counter);

		thread1.start();
		thread2.start();

		Thread.sleep(500);

		System.out.println(counter.getCount());

	}

}
