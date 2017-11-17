package com.estafet.j2ee.journal.ejb.user;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;

import com.estafet.j2ee.journal.dto.user.CreateUserParams;
import com.estafet.j2ee.journal.dto.user.User;

public interface JournalUserService extends EJBObject {

	User createUser(CreateUserParams params) throws RemoteException;
	
	List<User> getAllUsers() throws RemoteException;
	
	User getUser(String userId) throws RemoteException;
	
}
