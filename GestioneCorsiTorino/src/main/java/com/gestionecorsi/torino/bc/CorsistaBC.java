package com.gestionecorsi.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.CorsistaDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.exception.InvalidCorsistaException;
import com.gestionecorsi.torino.idgen.CorsistaIdGenerator;
import com.gestionecorsi.torino.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	private CorsistaIdGenerator idGen;

	public CorsistaBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
		idGen = CorsistaIdGenerator.getInstance();
	}

	public void createFromModel(Corsista model) throws SQLException {
		try {
			model.setCodCorsista(idGen.getNextId());
			CorsistaDAO.getFactory().createFromModel(conn, model);
		} catch (SQLException sql) {
			throw sql;
		}
	}

	public Corsista getByNumericalId(long id) throws SQLException {
		try {
			return CorsistaDAO.getFactory().getModelByNumericalId(conn, id);
		} catch (SQLException sql) {
			throw sql;
		}
	}

	public List<Corsista> getAll() throws SQLException {

		List<Corsista> lc = new ArrayList<Corsista>();
		try {
			lc = CorsistaDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new SQLException(sql);
		}
		return lc;
	}

	public void removeByModel(Corsista model) throws SQLException {
		try {
			CorsistaDAO.getFactory().removeByModel(conn, model);
		} catch (SQLException sql) {
			throw new SQLException(sql);
		}
	}

	public int getNCorsisti() throws SQLException {
		int nCorsisti = 0;
		try {
			nCorsisti = CorsistaDAO.getFactory().getNCorsisti(conn);
		} catch (SQLException sql) {
			throw sql;
		}
		return nCorsisti;
	}

	public void closeConnection() throws SQLException {
		try {
			DBAccess.closeConnection();
		} catch (SQLException sql) {
			throw sql;
		}
	}
	
	public static boolean isValidCorsista(Corsista c)throws InvalidCorsistaException {
		boolean [] b = {false,false};
		
		b[0] = checkNomeCorsista(c.getNomeCorsista());
		b[1] = checkCognomeCorsita(c.getCognomeCorsista());
		if(b[0] && b[1])
		return true;
		else
		throw new InvalidCorsistaException(b);
		
	}

	private static boolean checkCognomeCorsita(String cognomeCorsista)  {
		// TODO Auto-generated method stub
		return cognomeCorsista.matches("^[a-zA-Z .]{1,30}");
	}

	private static boolean checkNomeCorsista(String nomeCorsista) {
		// TODO Auto-generated method stub
		return nomeCorsista.matches("^[a-zA-Z .]{1,30}");
	}

}
