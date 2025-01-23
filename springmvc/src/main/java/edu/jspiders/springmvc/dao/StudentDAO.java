package edu.jspiders.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import edu.jspiders.springmvc.dto.Student;

@Component
public class StudentDAO {

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

	public void addStudent(Student student) {
		openConnection();
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		closeConnection();
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAllStudents() {
		openConnection();
		Query query = entityManager.createQuery("SELECT students FROM Student students");
		List<Student> students = query.getResultList();
		closeConnection();
		return students;
	}

	public void deleteStudentById(int id) {
		openConnection();
		entityTransaction.begin();
		Student studentToBeDeleted = entityManager.find(Student.class, id);
		entityManager.remove(studentToBeDeleted);
		entityTransaction.commit();
		closeConnection();
	}

	public Student findStudentById(int id) {
		openConnection();
		Student student = entityManager.find(Student.class, id);
		closeConnection();
		return student;
	}

	public void updateStudent(int id, String name, String email, long mobile, String course) {
		openConnection();
		entityTransaction.begin();
		Student studentToBeUpdated = entityManager.find(Student.class, id);
		studentToBeUpdated.setName(name);
		studentToBeUpdated.setEmail(email);
		studentToBeUpdated.setMobile(mobile);
		studentToBeUpdated.setCourse(course);
		entityManager.persist(studentToBeUpdated);
		entityTransaction.commit();
		closeConnection();

	}

	public Student findStudentByMobile(long mobile) {
		openConnection();
		Query query = entityManager.createQuery("SELECT student FROM Student student WHERE student.mobile = ?1");
		query.setParameter(1, mobile);
		Student student = (Student) query.getSingleResult();
		closeConnection();
		return student;
	}

}
