package com.estafet.j2ee.journal.ejb.entry;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface JournalEntryServiceHome extends EJBHome {

	JournalEntryService create() throws RemoteException, CreateException;
	
}
