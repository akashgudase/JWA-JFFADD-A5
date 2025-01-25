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

	public void deleteAdmin(int id) {
		openConnection();
		entityTransaction.begin();
		Admin adminToBeDeleted = entityManager.find(Admin.class, id);
		entityManager.remove(adminToBeDeleted);
		entityTransaction.commit();
		closeConnection();
	}

	public Admin findAdminById(int id) {
		openConnection();
		Admin admin = entityManager.find(Admin.class, id);
		closeConnection();
		return admin;
	}

	public void updateAdmin(int id, String email, String password) {
		openConnection();
		entityTransaction.begin();
		Admin admin = entityManager.find(Admin.class, id);
		admin.setEmail(email);
		admin.setPassword(password);
		entityManager.persist(admin);
		entityTransaction.commit();
		closeConnection();
	}

}
