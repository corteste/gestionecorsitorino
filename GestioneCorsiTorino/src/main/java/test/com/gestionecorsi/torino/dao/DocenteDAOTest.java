package test.com.gestionecorsi.torino.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.dao.DocenteDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.model.Docente;

/**
 * 
 * @author Stefano Cortese
 *
 */
class DocenteDAOTest {

	@Test
	void testGetByString() {
		Docente docente = null;
		try {
			Connection connection = DBAccess.getConnection();
			docente = DocenteDAO.getFactory().getModelByString(connection, "00001");
			assertNotNull(docente);
			System.out.println(docente.getCodDocente() + " " + docente.getNomeDocente());
			DBAccess.closeConnection();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	void getAll() {
		List<Docente> docenti = null;
		try {
			Connection connection = DBAccess.getConnection();
			docenti = DocenteDAO.getFactory().getAll(connection);
			assertNotNull(docenti);
			System.out.println(docenti.get(1).getCodDocente() + " " + docenti.get(1).getNomeDocente());
			DBAccess.closeConnection();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			fail(e.getMessage());
		} 
	}
	
}
