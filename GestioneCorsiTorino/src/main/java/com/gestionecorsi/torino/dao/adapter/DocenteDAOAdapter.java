package com.gestionecorsi.torino.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.gestionecorsi.torino.dao.CrudOperation;
import com.gestionecorsi.torino.model.Docente;


public abstract class DocenteDAOAdapter implements CrudOperation<Docente> {

	@Override
	public void createFromModel(Connection conn, Docente model)throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Docente getModelByNumericalId(Connection conn, long id)throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Docente getModelByString(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeByModel(Connection conn, Docente model) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Docente> getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
