package com.gestionecorsi.torino.bc;

import java.sql.Connection;
import java.sql.SQLException;


import com.gestionecorsi.torino.dao.CorsoCorsistaDAO;
import com.gestionecorsi.torino.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;
	
	
	public void createFromModel(CorsoCorsista corsocorsista) 
			throws SQLException {
		CorsoCorsistaDAO.getFactory().createFromModel(conn, corsocorsista);
	}
	
	public void removeByModel(CorsoCorsista corsocorsista) 
			throws SQLException {
		try {
			CorsoCorsistaDAO.getFactory().removeByModel(conn, corsocorsista);
		}catch (SQLException sql) {
			throw new SQLException(sql);
		}
	}

}
