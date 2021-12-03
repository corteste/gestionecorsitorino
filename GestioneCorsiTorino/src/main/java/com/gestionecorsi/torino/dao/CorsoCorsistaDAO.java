package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	public void createFromModel(Connection conn, CorsoCorsista model) throws SQLException{
		try {
			ResultSet rs;
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(SELECT__CORSO_CORSISTA);
			rs.moveToInsertRow();
			rs.updateLong(1, model.getCodCorso());
			rs.updateLong(2, model.getCodCorsista());
			rs.insertRow();
			conn.commit();
		}  catch (SQLException exc) {
			throw exc;
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
	
	@Override
	public List<CorsoCorsista> getAll(Connection conn)throws SQLException {
		// TODO Auto-generated method stub
		List<CorsoCorsista>lc = new ArrayList<CorsoCorsista>() ;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SELECT__CORSO_CORSISTA);
		
		for(;rs.next();)
		{
			CorsoCorsista tmp = new CorsoCorsista();
			tmp.setCodCorso(rs.getLong(1));
			tmp.setCodCorsista(rs.getLong(2));
		
			lc.add(tmp);
		}
		return lc;
	}
}
