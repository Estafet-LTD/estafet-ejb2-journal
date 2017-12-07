package com.estafet.j2ee.journal.ui.service;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.estafet.j2ee.journal.dto.user.CreateUserParams;
import com.estafet.j2ee.journal.dto.user.User;
import com.estafet.j2ee.journal.ejb.user.JournalUserServiceFactory;

@Service
public class UserService {

	public User createUser(CreateUserParams params) {
		try {
			return JournalUserServiceFactory.instance().createUser(params);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
	
	public User getUser(String userId) {
		try {
			return JournalUserServiceFactory.instance().getUser(userId);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
	
}
