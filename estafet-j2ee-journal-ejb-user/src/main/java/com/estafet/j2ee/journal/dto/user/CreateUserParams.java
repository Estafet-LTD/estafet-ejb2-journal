package com.estafet.j2ee.journal.dto.user;

import java.io.Serializable;

import com.estafet.j2ee.journal.entity.JournalUser;

public class CreateUserParams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String name;

	public String getUserId() {
		return userId;
	}

	public CreateUserParams setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getName() {
		return name;
	}

	public CreateUserParams setName(String name) {
		this.name = name;
		return this;
	}
	
	public JournalUser toEntity() {
		return new JournalUser().setName(name).setUserId(userId);
	}
	
}
