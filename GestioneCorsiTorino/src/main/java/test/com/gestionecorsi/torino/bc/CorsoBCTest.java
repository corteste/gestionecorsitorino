package test.com.gestionecorsi.torino.bc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.bc.CorsoBC;
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
		try {
			assertFalse(cbc.getAll().isEmpty());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	void testGetPopularCorso() {
		try {
			assertEquals("A",cbc.getPopularCorso());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	void testGetDataLastCorso() {
		try {
			assertEquals(21,cbc.getDataLastCorso().getIdCorso());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	void testGetCountCommenti() {
		try {
			assertEquals(14, cbc.getCountCommenti(0));
			assertEquals(3, cbc.getCountCommenti(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

	@Test
	void testGetAvailableCorso() {
		try {
			assertFalse(cbc.getAll().isEmpty());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
