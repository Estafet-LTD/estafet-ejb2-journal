package com.estafet.j2ee.journal.ui.service;

import java.rmi.RemoteException;

import com.estafet.j2ee.journal.dto.entry.CreateEntryParams;
import com.estafet.j2ee.journal.dto.entry.UserEntries;
import com.estafet.j2ee.journal.ejb.entry.JournalEntryServiceFactory;

public class EntryService {

	public UserEntries getUserEntries(String userId) {
		try {
			return JournalEntryServiceFactory.instance().getUserEntries(userId);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}
	
	public UserEntries createEntry(CreateEntryParams params) {
		try {
			return JournalEntryServiceFactory.instance().createEntry(params);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
	}

}
