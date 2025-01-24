package edu.jspiders.springmvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dto.Admin;

@Component
public class AdminDAO {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("springmvc");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private void closeConnection() {
		if (entityManagerFactory != null)
			entityManagerFactory.close();
		if (entityManager != null)
			entityManager.close();
		if (entityTransaction != null) {
			if (entityTransaction.isActive())
				entityTransaction.rollback();
		}
	}

	public void addAdmin(Admin admin) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		closeConnection();
	}

	public Admin authenticateAdmin(String email, String password) {
		openConnection();
		Query query = entityManager
				.createQuery("SELECT admins FROM Admin admins WHERE admins.email = ?1 AND admins.password = ?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		Admin admin = (Admin) query.getSingleResult();
		closeConnection();
		return admin;
	}

}
