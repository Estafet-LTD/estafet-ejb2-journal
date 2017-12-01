package com.estafet.j2ee.journal.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.estafet.j2ee.journal.entity.JournalUser;

public class UserDAO extends AbstractDAO {
	
	private UserDAO(DataSource ds) {
		this.ds = ds;
	}
	
	public static UserDAO instance() {
		try {
			return new UserDAO(context());
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public JournalUser getUser(String userId) {
		try {
			RowProcessor r = new JournalUserRowProcessor();
			ResultSetHandler<JournalUser> h = new BeanHandler<JournalUser>(
					JournalUser.class, r);
			QueryRunner run = new QueryRunner(ds);
			return run.query(
					"SELECT \n" + 
					"  journal_user.journal_user_id, \n" + 
					"  journal_user.name\n" + 
					"FROM \n" + 
					"  journal_user\n" + 
					"WHERE \n" + 
					"  journal_user.journal_user_id = ?",
					 h, userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public JournalUser createUser(JournalUser user) {
		try {
			QueryRunner run = new QueryRunner(ds);
			run.update("INSERT INTO journal_user ("
					+ "journal_user_id,"
					+ "name)"
					+ insertValues(new Object[] {
							user.getUserId(), 
							user.getName()
					}));
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<JournalUser> getAllUsers() {
		try {
			RowProcessor r = new JournalUserRowProcessor();
			ResultSetHandler<JournalUser> h = new BeanHandler<JournalUser>(
					JournalUser.class, r);
			QueryRunner run = new QueryRunner(ds);
			return run.execute(
					"SELECT \n" + 
							"  journal_user.journal_user_id, \n" + 
							"  journal_user.name\n" + 
							"FROM \n" + 
							"  journal_user\n",
					 h);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
