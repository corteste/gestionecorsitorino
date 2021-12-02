package test.com.gestionecorsi.torino.bc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.bc.CorsoBC;
import com.gestionecorsi.torino.dao.CorsoDAO;
import com.gestionecorsi.torino.model.Corso;

class CorsoBCTest {
	public static CorsoBC cbc ;
	private static Corso c = new Corso();
	
	@BeforeAll
	static void  init() throws ClassNotFoundException, IOException, SQLException {
		cbc = new CorsoBC();
	}
	
	@Test
	void testCreateFromModel() {
		c.setNomeCorso("Corso 1");
		c.setDataInizio(new Date());
		c.setDataFine(new Date());
		c.setCostoCorso(1000);
		c.setCommenti("A;J;J;F;");
		c.setAulaCorso("A1");
		c.setCodDocente("DOC");
		try {
			cbc.createFromModel(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}

	@Test
	void testGetModelByNumericalId() {
		try {
			assertEquals(cbc.getModelByNumericalId(1).getIdCorso(),1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	void testRemoveByModel() {
		try {
			cbc.removeByModel(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPopularCorso() {
		fail("Not yet implemented");
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
	void testGetAvailableCorso() {
		fail("Not yet implemented");
	}

}
