package edu.jspiders.multithreading.resource;

public class Counter {

	private int count;

	public Counter(int count) {
		super();
		this.count = count;
	}

	synchronized public void increment() {
		this.count++;
	}

	public int getCount() {
		return this.count;
	}

}
