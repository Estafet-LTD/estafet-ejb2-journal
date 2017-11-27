package com.estafet.j2ee.journal.dto.entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.estafet.j2ee.journal.dto.user.User;

public class UserEntries implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Map<Calendar, List<Entry>> entries = new HashMap<Calendar, List<Entry>>();

	private User user;

	public UserEntries(User user, List<Entry> entries) {
		this.user = user;
		for (Entry entry : entries) {
			add(entry);
		}
	}

	private void add(Entry entry) {
		List<Entry> dateEntries = entries.get(getEntryDate(entry));
		if (dateEntries == null) {
			dateEntries = new ArrayList<Entry>();
		}
		dateEntries.add(entry);
		entries.put(getEntryDate(entry), dateEntries);
	}

	private Calendar getEntryDate(Entry entry) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(entry.getEntryDate().getTime());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}

	public String getUserId() {
		return user.getUserId();
	}

	public String getName() {
		return user.getName();
	}

	public List<EntryDate> getEntryDates() {
		List<EntryDate> entriesDates = new ArrayList<EntryDate>();
		for (Calendar date : entries.keySet()) {
			EntryDate entryDate = new EntryDate().setDate(date);
			for (Entry entry : entries.get(date)) {
				entryDate.addEntry(entry);
			}
		}
		return entriesDates;
	}

}
