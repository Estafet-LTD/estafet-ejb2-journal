package com.estafet.j2ee.journal.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.estafet.j2ee.journal.entity.JournalUser;

public class UserDAO {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("journal").createEntityManager();
	
	public JournalUser getUser(String userId) {
		return entityManager.find(JournalUser.class, userId);
	}
	
	public JournalUser createUser(JournalUser user) {
		entityManager.persist(user);
		entityManager.flush();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<JournalUser> getAllUsers() {
		Query query = entityManager.createQuery("select u from JournalUser u");
		return query.getResultList();
	}
	
}
