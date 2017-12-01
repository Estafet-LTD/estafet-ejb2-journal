package com.estafet.j2ee.journal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.BasicRowProcessor;

import com.estafet.j2ee.journal.entity.JournalUser;

class JournalUserRowProcessor extends BasicRowProcessor {

	@Override
	public Object toBean(ResultSet rs, Class type) throws SQLException {
		JournalUser user = new JournalUser(); 
		user.setName(rs.getString("name"));
		user.setUserId(rs.getString("journal_user_id"));
		return user;
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
