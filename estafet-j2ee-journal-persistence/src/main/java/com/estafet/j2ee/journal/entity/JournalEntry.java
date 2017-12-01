package com.estafet.j2ee.journal.entity;

import java.util.Calendar;

public class JournalEntry {

	private Integer id;

	private Calendar entryDate;

	private String entryText;

	private JournalUser entryUser;

	public Integer getId() {
		return id;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public String getEntryText() {
		return entryText;
	}

	public JournalUser getEntryUser() {
		return entryUser;
	}

	public JournalEntry setId(Integer id) {
		this.id = id;
		return this;
	}

	public JournalEntry setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
		return this;
	}

	public JournalEntry setEntryText(String entryText) {
		this.entryText = entryText;
		return this;
	}

	public JournalEntry setEntryUser(JournalUser entryUser) {
		this.entryUser = entryUser;
		return this;
	}

}
