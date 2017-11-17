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
			p.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			p.put(Context.PROVIDER_URL, "localhost");
			InitialContext ctx = new InitialContext(p);
			JournalUserServiceHome home = (JournalUserServiceHome) ctx.lookup("jndi_JournalUserService");
			return home.create();
		} catch (RemoteException | NamingException | CreateException e) {
			throw new RuntimeException(e);
		}
	}

}
