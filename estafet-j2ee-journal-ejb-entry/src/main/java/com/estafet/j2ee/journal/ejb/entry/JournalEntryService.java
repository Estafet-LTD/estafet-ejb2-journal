package com.estafet.j2ee.journal.ejb.entry;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.EJBObject;

import com.estafet.j2ee.journal.dto.entry.CreateEntryParams;
import com.estafet.j2ee.journal.dto.entry.Entry;
import com.estafet.j2ee.journal.dto.entry.UserEntries;

public interface JournalEntryService extends EJBObject {

	UserEntries createEntry(CreateEntryParams params) throws RemoteException;

	UserEntries getUserEntries(String userId) throws RemoteException;

}
