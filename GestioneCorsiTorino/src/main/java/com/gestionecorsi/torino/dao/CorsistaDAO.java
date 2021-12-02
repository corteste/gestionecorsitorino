package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestionecorsi.torino.dao.adapter.CorsistaDAOAdapter;
import com.gestionecorsi.torino.model.Corsista;

public class CorsistaDAO extends CorsistaDAOAdapter implements DAOCostants {

	private CorsistaDAO() {
	}

	public static CorsistaDAO getFactory() {
		return new CorsistaDAO();
	}

	@Override
	public void createFromModel(Connection conn, Corsista model) throws SQLException {
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
			rs.moveToInsertRow();
			rs.updateLong(1, model.getCodCorsista());
			rs.updateString(2, model.getNomeCorsista());
			rs.updateString(3, model.getCognomeCorsista());
			rs.updateString(4, model.getPrecedentiFormativi());
			rs.insertRow();
			conn.commit();
		} catch (SQLException exc) {
			throw exc;
		}
	}

	@Override
	public Corsista getModelByNumericalId(Connection conn, long codCorsista) throws SQLException {
		Corsista corsista = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTA_BY_ID);
			ps.setLong(1, codCorsista);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corsista = new Corsista();
				corsista.setCodCorsista(rs.getInt(1));
				corsista.setNomeCorsista(rs.getString(2));
				corsista.setCognomeCorsista(rs.getString(3));
				corsista.setPrecedentiFormativi(rs.getString(4));

			}
		} catch (SQLException exc) {
			throw exc;
		}
		return corsista;
	}

	@Override
	public List<Corsista> getAll(Connection conn) throws SQLException {
		List<Corsista> lista_corsisti = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
			rs.last();
			lista_corsisti = new ArrayList<Corsista>();
			rs.beforeFirst();
			for (; rs.next();) {
				Corsista corsista = new Corsista();
				corsista.setCodCorsista(rs.getInt(1));
				corsista.setNomeCorsista(rs.getString(2));
				corsista.setCognomeCorsista(rs.getString(3));
				corsista.setPrecedentiFormativi(rs.getString(4));
				lista_corsisti.add(corsista);
			}
			rs.close();

		} catch (SQLException exc) {
			throw exc;
		}
		return lista_corsisti;
	}

	@Override
	public void removeByModel(Connection conn, Corsista model) throws SQLException {
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE_CORSISTA);
			ps.setLong(1, model.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch (SQLException exc) {
			throw exc;
		}
	}
	
	public int getNCorsisti(Connection conn) throws SQLException {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_N_CORSISTI);
			rs.next();
			return rs.getInt(1);
		} catch (SQLException exc) {
			throw exc;
		}
	}

}
