package edu.jspiders.multithreading.thread;

import edu.jspiders.multithreading.resource.Product;

public class Consumer extends Thread {

	private Product product;

	public Consumer(Product product) {
		super();
		this.product = product;
	}

	@Override
	public void run() {
		product.consume();
	}

}
