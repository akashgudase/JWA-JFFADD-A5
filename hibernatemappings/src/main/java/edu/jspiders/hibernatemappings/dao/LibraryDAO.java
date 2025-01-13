package edu.jspiders.hibernatemappings.dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jspiders.hibernatemappings.dto.Book;
import edu.jspiders.hibernatemappings.dto.Library;

public class LibraryDAO {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	public static void main(String[] args) {
		Library library1 = new Library();
		library1.setName("ABC");
		library1.setLocation("Wakad");

		Library library2 = new Library();
		library2.setName("XYZ");
		library2.setLocation("Ravet");

		Collection<Library> libraries = new ArrayList<Library>();
		libraries.add(library1);
		libraries.add(library2);

		Book book1 = new Book();
		book1.setName("Ramayan");
		book1.setAuthor("Valmiki");
		book1.setPrice(500.00);
		book1.setLibraries(libraries);

		Book book2 = new Book();
		book2.setName("Wings of Fire");
		book2.setAuthor("Dr. APJ Abdul Kalam");
		book2.setPrice(300.00);
		book2.setLibraries(libraries);

		Collection<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);

		library1.setBooks(books);
		library2.setBooks(books);

		openConnection();
		entityTransaction.begin();
		entityManager.persist(book1);
		entityManager.persist(book2);
		entityManager.persist(library1);
		entityManager.persist(library2);
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
