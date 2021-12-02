package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.gestionecorsi.torino.dao.adapter.CorsoCorsistaDAOAdapter;
import com.gestionecorsi.torino.model.CorsoCorsista;

/**
 * @author Luca Pianta
 *
 */
public class CorsoCorsistaDAO extends CorsoCorsistaDAOAdapter implements DAOCostants {
	
	
	private CorsoCorsistaDAO() {
	}
	
	
	public static CorsoCorsistaDAO getFactory(){
		return new CorsoCorsistaDAO();
	}

	@Override
	public void createFromModel(Connection conn, CorsoCorsista model){
		try {
			ResultSet rs;
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT__CORSO_CORSISTA);
			rs.moveToInsertRow();
			rs.updateLong(1, model.getCodCorsista());
			rs.updateLong(2, model.getCodCorso());
			rs.insertRow();
			rs.moveToCurrentRow();
			conn.commit();
		} catch(SQLException exc) {
			exc.printStackTrace();
			exc.getMessage();
		}
		
	}
	
	@Override
	public void removeByModel(Connection conn, CorsoCorsista model) throws SQLException {
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE__CORSO_CORSISTA);
			ps.setLong(1, model.getCodCorso());
			ps.setLong(2, model.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException exc) {
			throw exc;
		}
	}
}
