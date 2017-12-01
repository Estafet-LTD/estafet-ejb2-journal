package com.estafet.j2ee.journal.ejb.user;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.estafet.j2ee.journal.dao.UserDAO;
import com.estafet.j2ee.journal.dto.user.CreateUserParams;
import com.estafet.j2ee.journal.dto.user.User;

public class JournalUserServiceBean implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User createUser(CreateUserParams params) {
		return User.toUser(UserDAO.instance().createUser(params.toEntity()));
	}
	
	public List<User> getAllUsers() {
		return User.toUsers(UserDAO.instance().getAllUsers());
	}
	
	public User getUser(String userId) {
		return User.toUser(UserDAO.instance().getUser(userId));
	}
	
	public void ejbActivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbPassivate() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void ejbRemove() throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException {
		// TODO Auto-generated method stub

	}

}
