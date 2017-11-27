package com.estafet.j2ee.journal.ejb.entry;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import com.estafet.j2ee.journal.dao.EntryDAO;
import com.estafet.j2ee.journal.dto.entry.CreateEntryParams;
import com.estafet.j2ee.journal.dto.entry.Entry;
import com.estafet.j2ee.journal.dto.entry.UserEntries;
import com.estafet.j2ee.journal.dto.user.User;
import com.estafet.j2ee.journal.ejb.user.JournalUserServiceFactory;

public class JournalEntryServiceBean implements SessionBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserEntries createEntry(CreateEntryParams params) {
		new EntryDAO().createEntry(params.getUserId(), params.getEntryText(), params.getEntryDate());
		return getUserEntries(params.getUserId());
	}

	public UserEntries getUserEntries(String userId) {
		try {
			User user = JournalUserServiceFactory.instance().getUser(userId);
			List<Entry> entries = Entry.toEntries(new EntryDAO().getUsersEntriesByDate(userId));
			return new UserEntries(user, entries);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
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
