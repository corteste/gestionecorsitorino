package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.adapter.CorsoDAOAdapter;
import com.gestionecorsi.torino.model.Corso;

public class CorsoDAO extends CorsoDAOAdapter  implements DAOCostants{
	
	public static CorsoDAO getFactory() {
		return new CorsoDAO();
	}

	
	
	 private CorsoDAO()  {
	 }
	
	//TODO
	@Override
	public void createFromModel(Connection conn, Corso model) throws SQLException {
		// TODO Auto-generated method stub
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery(SELECT_CORSI);
		rs.moveToInsertRow();
		rs.updateLong(1, model.getIdCorso());
		rs.updateString(2,model.getNomeCorso());
		rs.updateDate(3,new java.sql.Date(model.getDataInizio().getTime()));
		rs.updateDate(4,new java.sql.Date(model.getDataFine().getTime()));
		rs.updateDouble(5, model.getCostoCorso());
		rs.updateString(6, model.getCommenti());
		rs.updateString(7,model.getAulaCorso());
		rs.updateString(8, model.getCodDocente());
		rs.insertRow();
		rs.moveToCurrentRow();
		conn.commit();
	}

	@Override
	public Corso getModelByNumericalId(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		Corso tmp = new Corso();
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSO_BY_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		tmp.setIdCorso(rs.getLong(1));
		tmp.setNomeCorso(rs.getString(2));
		tmp.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
		tmp.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
		tmp.setCostoCorso(rs.getDouble(5));
		tmp.setCommenti(rs.getString(6));
		tmp.setAulaCorso(rs.getString(7));
		tmp.setCodDocente(rs.getString(8));
		
		return tmp;
		
	}

	@Override
	public void removeByModel(Connection conn, Corso model) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSO_IN_CORSO_CORSISTA);
		ps.setLong(1, model.getIdCorso());
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			ps = conn.prepareStatement(DELETE_CORSO_FROM_CORSISTA);
			ps.setLong(1, model.getIdCorso());
		    ps.execute();
			
			
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, model.getIdCorso());
			ps.execute();
			
			
		}
		else
		{
			ps.close();
			ps = conn.prepareStatement(DELETE_CORSO);
			ps.setLong(1, model.getIdCorso());
			ps.execute();
			
			
		}
		rs.close();
		conn.commit();
	}

	@Override
	public List<Corso> getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		List<Corso>lc = new ArrayList<Corso>() ;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SELECT_CORSI);
		
		for(;rs.next();)
		{
			Corso tmp = new Corso();
			tmp.setIdCorso(rs.getLong(1));
			tmp.setNomeCorso(rs.getString(2));
			tmp.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
			tmp.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
			tmp.setCostoCorso(rs.getDouble(5));
			tmp.setCommenti(rs.getString(6));
			tmp.setAulaCorso(rs.getString(7));
			tmp.setCodDocente(rs.getString(8));
			lc.add(tmp);
		}
		return lc;
	}



	public String getPopularCorso(Connection conn) throws SQLException {
		
		Corso c = null;
		
		Statement ps = conn.createStatement();
		ResultSet rs = ps.executeQuery(SELECT_POPULAR_CORSO);
		
		if(rs.next()) {
			c = new Corso ();
			c.setNomeCorso(rs.getString(2));
		}
		
		return c.getNomeCorso();
	}



	public Corso getDataLastCorso(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		Corso tmp = new Corso();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SELECT_CORSI);
		
		for(;rs.next();)
		{
			
			tmp.setIdCorso(rs.getLong(1));
			tmp.setNomeCorso(rs.getString(2));
			tmp.setDataInizio(new java.util.Date(rs.getDate(3).getTime()));
			tmp.setDataFine(new java.util.Date(rs.getDate(4).getTime()));
			tmp.setCostoCorso(rs.getDouble(5));
			tmp.setCommenti(rs.getString(6));
			tmp.setAulaCorso(rs.getString(7));
			tmp.setCodDocente(rs.getString(8));
			
		}
		return tmp;
	}



	public int getCountCommenti(Connection conn, long id)throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_COMMENTI_CORSO);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		int count = 0;
		for(;rs.next();) {
			count=rs.getInt(1);
		}
		return count;
	}



	public List<String> getAvailableCorso(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		List<String>lc = new ArrayList<String>() ;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(SELECT_GET_AVAILABLE_CORSO);
		
		for(;rs.next();)
		{
			String tmp = new String("");
			tmp = " "+rs.getLong(1)+" "+rs.getString(2)+" "
			         +new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(rs.getDate(3).getTime()))+" "
					+new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(rs.getDate(4).getTime()))
					+" "+rs.getDouble(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getInt(9);
	
		

			lc.add(tmp);
		}
		return lc;
	}




	

}
