package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CrudOperation<T> {
	
	public void createFromModel(Connection conn,T model) throws SQLException;
	public T getModelByNumericalId(Connection conn,long id) throws SQLException;
	public T getModelByString(Connection conn,String id) throws SQLException;
	public void removeByModel(Connection conn,T model) throws SQLException;
	public List<T> getAll(Connection conn) throws SQLException;
}
