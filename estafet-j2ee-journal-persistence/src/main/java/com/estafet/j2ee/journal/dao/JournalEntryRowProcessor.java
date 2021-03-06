package com.estafet.j2ee.journal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;

import com.estafet.j2ee.journal.entity.JournalEntry;
import com.estafet.j2ee.journal.entity.JournalUser;

class JournalEntryRowProcessor extends BasicRowProcessor {

	@Override
	public Object toBean(ResultSet rs, Class type) throws SQLException {
		JournalEntry entry = new JournalEntry(); 
		entry.setEntryDate(getEntryDate(rs));
		entry.setEntryText(rs.getString("entry_text"));
		entry.setId(rs.getInt("journal_entry_id"));
		entry.setEntryUser(new JournalUser().setUserId(rs.getString("journal_user_id")).setName(rs.getString("name")));
		return entry;
	}

	private Calendar getEntryDate(ResultSet rs) throws SQLException {
		Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(rs.getTimestamp("entry_date").getTime());
		return calendar;
	}

	@Override
	public  List toBeanList(ResultSet rs, Class type)
			throws SQLException {
		try {
            List newlist = new ArrayList();
            while (rs.next()) {
                newlist.add(toBean(rs, type));
            }
            return newlist;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }		
	}
	
}
