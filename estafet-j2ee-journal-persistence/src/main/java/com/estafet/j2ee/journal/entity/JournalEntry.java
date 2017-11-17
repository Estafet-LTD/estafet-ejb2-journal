package com.estafet.j2ee.journal.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JOURNAL_ENTRY")
public class JournalEntry {

	@Id
	@SequenceGenerator(name = "ENTRY_ID_SEQ", sequenceName = "ENTRY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTRY_ID_SEQ")
	@Column(name = "JOURNAL_ENTRY_ID")
	private Integer id;

	@Column(name = "ENTRY_DATE", nullable = false)
	private Calendar entryDate;

	@Column(name = "ENTRY_TEXT", nullable = false)
	private String entryText;

	@ManyToOne
	@JoinColumn(name = "JOURNAL_USER_ID", nullable = false, referencedColumnName = "JOURNAL_USER_ID")
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

	public JournalEntry setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
		return this;
	}

	public JournalEntry setEntryText(String entryText) {
		this.entryText = entryText;
		return this;
	}

	void setEntryUser(JournalUser entryUser) {
		this.entryUser = entryUser;
	}

}
