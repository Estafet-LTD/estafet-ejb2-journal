package com.estafet.j2ee.journal.ejb.user;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface JournalUserServiceHome extends EJBHome {

	JournalUserService create() throws RemoteException, CreateException;
	
}
