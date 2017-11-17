package com.estafet.j2ee.journal.dto.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EntryDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5533748384440105993L;

	private Calendar date;

	private List<Entry> entries = new ArrayList<Entry>();

	public Calendar getDate() {
		return date;
	}

	public EntryDate setDate(Calendar date) {
		this.date = date;
		return this;
	}
	
	public void addEntry(Entry entry) {
		entries.add(entry);
	}

	public List<Entry> getEntries() {
		return entries;
	}

}
