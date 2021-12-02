package com.gestionecorsi.torino.idgen;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gestionecorsi.torino.dao.DAOCostants;
import com.gestionecorsi.torino.dbaccess.DBAccess;

public class CorsoIdGenerator implements IdGeneratorInterface , DAOCostants {
//TODO
	
	private static CorsoIdGenerator idGen;
	private Connection conn;
	
	public static CorsoIdGenerator getInstance() throws ClassNotFoundException, IOException, SQLException {
		if(idGen == null)
			idGen = new CorsoIdGenerator();
		return idGen;
	}
	
	private CorsoIdGenerator() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}

	@Override
	public long getNextId() throws SQLException {
		// TODO Auto-generated method stub
		long id = 0;
		Statement st;
		ResultSet rs;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ID_CORSO);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return id;
	}
	
	
}
