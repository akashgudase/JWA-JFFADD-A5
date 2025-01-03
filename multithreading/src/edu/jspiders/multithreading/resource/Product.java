package edu.jspiders.multithreading.resource;

public class Product {

	private int quantity;

	public Product(int quantity) {
		super();
		this.quantity = quantity;
	}

	synchronized public void consume() {
		if (quantity > 0)
			this.quantity--;
		else {
			System.out.println("Consumer is waiting");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("consumer consumed a product");
	}

	synchronized public void produce() {
		this.quantity++;
		System.out.println("Producer produced a product");
		if (quantity == 1)
			notify();
	}

}
