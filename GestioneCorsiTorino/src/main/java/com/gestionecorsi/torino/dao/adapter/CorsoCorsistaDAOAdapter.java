package com.gestionecorsi.torino.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gestionecorsi.torino.dao.CrudOperation;

import com.gestionecorsi.torino.model.CorsoCorsista;

public abstract class CorsoCorsistaDAOAdapter implements CrudOperation<CorsoCorsista> {

	@Override
	public void createFromModel(Connection conn, CorsoCorsista model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CorsoCorsista getModelByNumericalId(Connection conn, long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista getModelByString(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeByModel(Connection conn, CorsoCorsista model)throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CorsoCorsista> getAll(Connection conn)throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
