package test.com.gestionecorsi.torino.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.dao.CorsoDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.idgen.CorsoIdGenerator;
import com.gestionecorsi.torino.model.Corso;

class CorsoDAOTest {

	private static Corso c = new Corso();
	private static Connection conn;
	
	@BeforeAll
	static void init() throws ClassNotFoundException, IOException, SQLException {
		conn =   DBAccess.getConnection();
	}
	@Test
	void testCreateFromModel() {
		
		c.setNomeCorso("Corso 1");
		c.setDataInizio(new Date());
		c.setDataFine(new Date());
		c.setCostoCorso(1000);
		c.setCommenti("A;J;J;F;");
		c.setAulaCorso("A1");
		c.setCodDocente("DOC1");
		try {
			c.setIdCorso(CorsoIdGenerator.getInstance().getNextId());
			
			CorsoDAO.getFactory().createFromModel(conn, c); 
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	@Test
	void testGetAll() {
		try {
			List<Corso> lc = CorsoDAO.getFactory().getAll(conn);
			assertNotNull(lc);
			assertFalse(lc.isEmpty());
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} 
	}
	
	@Test
	void  testRemoveByModel() {
		try {
			CorsoDAO.getFactory().removeByModel(conn, c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} 
	}
	

	@Test
	void testGetModelByNumericalId() throws SQLException {
		
		assertEquals(c, CorsoDAO.getFactory().getModelByNumericalId(conn, c.getIdCorso()));
	}

	


	@Test
	void testGetPopularCorso() {
		
	}

	@Test
	void testGetDataLastCorso() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCountCommenti() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAvgLength() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAvailableCorso() {
		fail("Not yet implemented");
	}

}
