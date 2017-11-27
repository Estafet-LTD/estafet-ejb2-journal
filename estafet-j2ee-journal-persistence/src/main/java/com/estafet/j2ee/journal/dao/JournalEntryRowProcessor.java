package com.estafet.j2ee.journal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;

import com.estafet.j2ee.journal.entity.JournalEntry;

public class JournalEntryRowProcessor extends BasicRowProcessor {

	@Override
	public Object toBean(ResultSet rs, Class type) throws SQLException {
		JournalEntry entry = new JournalEntry(); 
		//entry.setEntryDate(rs.getTimestamp(""));
		return entry;
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
