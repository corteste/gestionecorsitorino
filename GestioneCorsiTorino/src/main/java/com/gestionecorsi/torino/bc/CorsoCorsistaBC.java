package com.gestionecorsi.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gestionecorsi.torino.dao.CorsoCorsistaDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;
	
	public CorsoCorsistaBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}
	
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
	
	public List<CorsoCorsista> getCorsoCorsisti() throws SQLException{
		
		return CorsoCorsistaDAO.getFactory().getAll(conn);
	}
	
	public Set<Long> getDistinctCorsista() throws SQLException{
		Set<Long> cod = new HashSet<Long>();
		for(CorsoCorsista c : this.getCorsoCorsisti())
		{
			cod.add(c.getCodCorsista());
		}
		
		return cod;
	}

}
