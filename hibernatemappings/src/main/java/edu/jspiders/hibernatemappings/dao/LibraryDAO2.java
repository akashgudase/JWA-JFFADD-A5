package edu.jspiders.hibernatemappings.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernatemappings.dto.Book;
import edu.jspiders.hibernatemappings.dto.Library;

public class LibraryDAO2 {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		openConnection();
		entityTransaction.begin();
		Book book1 = entityManager.find(Book.class, 1);
		entityManager.remove(book1);
		Book book2 = entityManager.find(Book.class, 2);
		entityManager.remove(book2);
		Library library1 = entityManager.find(Library.class, 1);
		entityManager.remove(library1);
		Library library2 = entityManager.find(Library.class, 2);
		entityManager.remove(library2);
		entityTransaction.commit();
		closeConnection();
	}

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate_mappings");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnection() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
		if (entityManager != null)
			entityManager.close();
		if (entityTransaction != null) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}

}
