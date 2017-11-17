package com.estafet.j2ee.journal.dao;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.estafet.j2ee.journal.entity.JournalEntry;
import com.estafet.j2ee.journal.entity.JournalUser;

public class EntryDAO {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("j2ee").createEntityManager();

	@SuppressWarnings("unchecked")
	public List<JournalEntry> getUsersEntriesByDate(String userId) {
		return entityManager
				.createQuery("select e from JournalEntry e where e.user = :userId")
				.setParameter("userId", userId)
				.getResultList();
	}

	public JournalEntry createEntry(String userId, String entryText, Calendar entryDate) {
		JournalUser user = entityManager.find(JournalUser.class, userId);
		JournalEntry entry = new JournalEntry().setEntryDate(entryDate).setEntryText(entryText);
		user.addEntry(entry);
		entityManager.merge(user);
		return entry;
	}

}
