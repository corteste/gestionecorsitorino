package test.com.gestionecorsi.torino.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.dao.CorsoDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.idgen.CorsoIdGenerator;
import com.gestionecorsi.torino.model.Corso;

class CorsoDAOTest {
	private static Corso c = new Corso();
	@Test
	void testCreateFromModel() {
		
		c.setNomeCorso("Corso 1");
		c.setDataInizio(new Date());
		c.setDataFine(new Date());
		c.setCostoCorso(1000);
		c.setCommenti("A;J;J;F;");
		c.setAulaCorso("A1");
		c.setCodDocente("AAA");
		try {
			c.setIdCorso(CorsoIdGenerator.getInstance().getNextId());
			Connection conn = DBAccess.getConnection();
			CorsoDAO.getFactory().createFromModel(conn, c); 
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	@Test
	void getAll() {
		try {
			List<Corso> lc = CorsoDAO.getFactory().getAll(DBAccess.getConnection());
			assertNotNull(lc);
			assertFalse(lc.isEmpty());
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} 
	}
	
	@Test
	void removeByModel() {
		try {
			CorsoDAO.getFactory().removeByModel(DBAccess.getConnection(), c);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		} 
	}
	
	
	@AfterAll
  static void clean() {
		
	}

}
