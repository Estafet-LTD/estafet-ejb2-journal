package com.estafet.j2ee.journal.dao;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.estafet.j2ee.journal.entity.JournalEntry;

public class EntryDAO extends AbstractDAO {

	private EntryDAO(DataSource ds) {
		this.ds = ds;
	}

	public static EntryDAO instance() {
		try {
			return new EntryDAO(context());
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public List<JournalEntry> getUserEntries(String userId) {
		try {
			RowProcessor r = new JournalEntryRowProcessor();
			ResultSetHandler<JournalEntry> h = new BeanHandler<JournalEntry>(
					JournalEntry.class, r);
			QueryRunner run = new QueryRunner(ds);
			return run.execute(
					"SELECT \n" + 
					"  journal_entry.journal_entry_id, \n" + 
					"  journal_entry.entry_date, \n" + 
					"  journal_entry.entry_text, \n" + 
					"  journal_entry.journal_user_id, \n" + 
					"  journal_user.name\n" + 
					"FROM \n" + 
					"  journal_entry, \n" + 
					"  journal_user\n" + 
					"WHERE \n" + 
					"  journal_entry.journal_user_id = journal_user.journal_user_id AND \n" + 
					"  journal_user.journal_user_id = ?",
					 h, userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public JournalEntry getEntry(int entryId) {
		try {
			RowProcessor r = new JournalEntryRowProcessor();
			ResultSetHandler<JournalEntry> h = new BeanHandler<JournalEntry>(
					JournalEntry.class, r);
			QueryRunner run = new QueryRunner(ds);
			return run.query(
					"SELECT \n" + 
					"  journal_entry.journal_entry_id, \n" + 
					"  journal_entry.entry_date, \n" + 
					"  journal_entry.entry_text, \n" + 
					"  journal_entry.journal_user_id, \n" + 
					"  journal_user.name\n" + 
					"FROM \n" + 
					"  journal_entry, \n" + 
					"  journal_user\n" + 
					"WHERE \n" + 
					"  journal_entry.journal_user_id = journal_user.journal_user_id AND \n" + 
					"  journal_entry.journal_entry_id = ?",
					 h, entryId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public JournalEntry createEntry(String userId, String entryText, Calendar entryDate) {
		int entryId = lastJournalEntryId();
		try {
			QueryRunner run = new QueryRunner(ds);
			run.update("INSERT INTO journal_entry ("
					+ "journal_entry_id,"
					+ "entry_date,"
					+ "entry_text)"
					+ insertValues(new Object[] {
							entryId, 
							entryDate, 
							entryText
					}));
			return getEntry(entryId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Integer lastJournalEntryId() {
		return lastSequenceValue("entry_id_seq").intValue();
	}
	
}
