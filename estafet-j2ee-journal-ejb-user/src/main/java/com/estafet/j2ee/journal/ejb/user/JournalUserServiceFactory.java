package com.estafet.j2ee.journal.ejb.user;

import java.rmi.RemoteException;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JournalUserServiceFactory {

	public static JournalUserService instance() {
		try {
			Properties p = new Properties();
			p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
			p.put(Context.PROVIDER_URL, "remote://localhost:4447");
			p.put("jboss.naming.client.ejb.context", true);
			InitialContext ctx = new InitialContext(p);
			JournalUserServiceHome home = (JournalUserServiceHome) ctx.lookup("java:app/estafet-j2ee-journal-ejb-user-0.0.1-SNAPSHOT/JournalUserService!com.estafet.j2ee.journal.ejb.user.JournalUserService");
			//JournalUserServiceHome home = (JournalUserServiceHome) ctx.lookup("jndi_JournalUserService");
			return home.create();
		} catch (RemoteException | NamingException | CreateException e) {
			throw new RuntimeException(e);
		}
	}

}
