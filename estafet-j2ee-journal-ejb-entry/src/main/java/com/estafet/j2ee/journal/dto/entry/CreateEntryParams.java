package com.estafet.j2ee.journal.dto.entry;

import java.io.Serializable;
import java.util.Calendar;

public class CreateEntryParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5898868299626487516L;

	private String userId;

	private String entryText;

	private Calendar entryDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEntryText() {
		return entryText;
	}

	public void setEntryText(String entryText) {
		this.entryText = entryText;
	}

	public Calendar getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Calendar entryDate) {
		this.entryDate = entryDate;
	}

}
