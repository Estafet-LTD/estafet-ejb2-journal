package com.estafet.j2ee.journal.dto.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.estafet.j2ee.journal.entity.JournalEntry;

public class Entry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer entryId;

	private Calendar entryDate;

	private String entryText;

	private String userId;

	public Integer getEntryId() {
		return entryId;
	}

	private Entry setEntryId(Integer entryId) {
		this.entryId = entryId;
		return this;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	private Entry setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
		return this;
	}

	public String getEntryText() {
		return entryText;
	}

	private Entry setEntryText(String entryText) {
		this.entryText = entryText;
		return this;
	}

	public String getUserId() {
		return userId;
	}

	private Entry setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public static List<Entry> toEntries(List<JournalEntry> entities) {
		List<Entry> entries = new ArrayList<Entry>();
		for (JournalEntry journalEntry : entities) {
			entries.add(toEntry(journalEntry));
		}
		return entries;
	}

	public static Entry toEntry(JournalEntry entity) {
		return new Entry()
				.setEntryId(entity.getId())
				.setEntryDate(entity.getEntryDate())
				.setEntryText(entity.getEntryText())
				.setUserId(entity.getEntryUser().getUserId());
	}

}
