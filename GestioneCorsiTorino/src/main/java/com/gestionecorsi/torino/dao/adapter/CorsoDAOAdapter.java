package com.gestionecorsi.torino.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gestionecorsi.torino.dao.CrudOperation;
import com.gestionecorsi.torino.model.Corso;

public abstract class CorsoDAOAdapter implements CrudOperation<Corso> {

	@Override
	public void createFromModel(Connection conn, Corso model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corso getModelByNumericalId(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corso getModelByString(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeByModel(Connection conn, Corso model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Corso> getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
