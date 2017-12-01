package com.estafet.j2ee.journal.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class AbstractDAO {

	protected DataSource ds;

	protected static DataSource context() throws NamingException {
		InitialContext cxt = new InitialContext();
		DataSource ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/postgres" );
		return ds;
	}

	public AbstractDAO() {
		super();
	}

	protected Long lastSequenceValue(String sequence) {
		try {
			String sql = "SELECT last_value FROM " + sequence;
			QueryRunner run = new QueryRunner(ds);
			return run.query(sql, new ScalarHandler<Long>("last_value"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private String calendarAsString(Calendar cal) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(cal.getTime());
	}
	
	protected String insertValues(Object[] values) {
		StringBuilder buffer = new StringBuilder();
		buffer.append(" VALUES (");
		for (int i = 0; i < values.length; i++) {
			if (values[i] instanceof Calendar) {
				quoteCalendar(values, buffer, i);
			} else {
				quote(values, buffer, i);	
			}
			if (i + 1 < values.length) {
				buffer.append(",");
			} else {
				buffer.append(")");
			}
		}
		return buffer.toString();
	}

	private void quoteCalendar(Object[] values, StringBuilder buffer, int i) {
		buffer.append("'");
		buffer.append(calendarAsString((Calendar)values[i]));
		buffer.append("'");
	}

	private void quote(Object[] values, StringBuilder buffer, int i) {
		if (values[i] instanceof String) {
			buffer.append("'");
		}
		if (values[i] != null) {
			buffer.append(values[i].toString());
		} else {
			buffer.append("NULL");
		}
		if (values[i] instanceof String) {
			buffer.append("'");
		}
	}

}