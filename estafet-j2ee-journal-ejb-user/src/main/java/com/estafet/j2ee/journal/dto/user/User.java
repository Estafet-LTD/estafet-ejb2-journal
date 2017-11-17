package com.estafet.j2ee.journal.dto.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.estafet.j2ee.journal.entity.JournalUser;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4881779388353863446L;

	private String userId;

	private String name;

	public String getUserId() {
		return userId;
	}

	public User setUserId(String userId) {
		this.userId = userId;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}
	
	public static List<User> toUsers(List<JournalUser> entities) {
		List<User> users = new ArrayList<User>();
		for (JournalUser journalUser : entities) {
			users.add(toUser(journalUser));
		}
		return users;
	}

	public static User toUser(JournalUser entity) {
		return entity != null ?  new User().setName(entity.getName()).setUserId(entity.getUserId()): null;
	}

}
