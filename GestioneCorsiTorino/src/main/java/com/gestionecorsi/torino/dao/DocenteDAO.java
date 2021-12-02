package com.gestionecorsi.torino.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.gestionecorsi.torino.dao.adapter.DocenteDAOAdapter;
import com.gestionecorsi.torino.model.Docente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DocenteDAO extends DocenteDAOAdapter implements DAOCostants {

	private DocenteDAO() {
	}

	public static DocenteDAO getFactory() {
		return new DocenteDAO();
	}

	/**
	 * @author Stefano Cortese
	 * @throws SQLException
	 */

	@Override
	public Docente getModelByString(Connection conn, String codDocente) throws SQLException {
		Docente docente = null;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SELECT_DOCENTE_BY_ID);
			ps.setString(1, codDocente);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				docente = new Docente();

				docente.setCodDocente(rs.getString(1));
				docente.setNomeDocente(rs.getString(2));
				docente.setCognomeDocente(rs.getString(3));
				docente.setCvDocente(rs.getString(4));
			}
		} catch (SQLException sql) {
			sql.getMessage();
			throw new SQLException();
		}

		return docente;
	}

	/**
	 * Daniel Cobas
	 */
	@Override
	public List<Docente> getAll(Connection conn) throws SQLException {
		List<Docente> docente = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTI);
			rs.last();
			docente = new ArrayList<Docente>(rs.getRow());
			rs.beforeFirst();

			while (rs.next()) {
				Docente d = new Docente();
				d.setCodDocente(rs.getString(1));
				d.setNomeDocente(rs.getString(2));
				d.setCognomeDocente(rs.getString(3));
				d.setCvDocente(rs.getString(4));
				docente.add(d);
			}
			rs.close();
		} catch (SQLException sql) {
			throw new SQLException(); // Manca la classe DAOException
		}
		return docente;
	}

	public String getDocenteMostCorsi(Connection conn) throws SQLException {
		String codiceDocente = null;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_DOCENTE_MOST_CORSI);
			rs.beforeFirst();
			if (rs.next()) {
				codiceDocente = rs.getString(1);
			}

		} catch (SQLException sql) {
			throw new SQLException();
		}

		return codiceDocente;
	}

}
