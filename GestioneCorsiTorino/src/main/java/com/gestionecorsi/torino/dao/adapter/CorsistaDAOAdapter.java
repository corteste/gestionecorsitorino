package com.gestionecorsi.torino.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gestionecorsi.torino.dao.CrudOperation;
import com.gestionecorsi.torino.model.Corsista;

public abstract class CorsistaDAOAdapter implements CrudOperation<Corsista> {

	@Override
	public void createFromModel(Connection conn, Corsista model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corsista getModelByNumericalId(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corsista getModelByString(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeByModel(Connection conn, Corsista model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Corsista> getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
