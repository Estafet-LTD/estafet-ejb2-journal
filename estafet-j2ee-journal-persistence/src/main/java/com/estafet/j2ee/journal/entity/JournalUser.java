package com.estafet.j2ee.journal.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOURNAL_USER")
public class JournalUser {

	@Id
	@Column(name = "JOURNAL_USER_ID")
	private String userId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@OneToMany(mappedBy = "entryUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<JournalEntry> entries = new ArrayList<JournalEntry>();

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public JournalUser setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public JournalUser setName(String name) {
		this.name = name;
		return this;
	}

	public void addEntry(JournalEntry entry) {
		entry.setEntryUser(this);
		entries.add(entry);
	}

}
