package com.estafet.j2ee.journal.entity;

public class JournalUser {

	private String userId;

	private String name;

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

}
