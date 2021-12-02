package test.com.gestionecorsi.torino.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.gestionecorsi.torino.dao.CorsistaDAO;
import com.gestionecorsi.torino.dao.CorsoCorsistaDAO;
import com.gestionecorsi.torino.dao.CorsoDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.model.Corsista;
import com.gestionecorsi.torino.model.Corso;
import com.gestionecorsi.torino.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)

class CorsoCorsistaDAOTest {
	private static CorsoCorsista cc;
	private static Corsista corsista;
	private static Corso c;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodCorsista(10);
		corsista.setNomeCorsista("Marco");
		corsista.setCognomeCorsista("Bianchi");
		corsista.setPrecedentiFormativi("S");
		CorsistaDAO.getFactory().createFromModel(conn, corsista);
		
		c = new Corso();
		c.setIdCorso(5);
		c.setNomeCorso("Corso 1");
		c.setDataInizio(new Date());
		c.setDataFine(new Date());
		c.setCostoCorso(1000);
		c.setCommenti("A;J;J;F;");
		c.setAulaCorso("A1");
		c.setCodDocente("00001");
		CorsoDAO.getFactory().createFromModel(conn, c);
		
		cc = new CorsoCorsista();
		cc.setCodCorsista(corsista.getCodCorsista());
		cc.setCodCorso(c.getIdCorso());
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			conn = DBAccess.getConnection();
			CorsoCorsistaDAO.getFactory().removeByModel(conn, cc);
			CorsistaDAO.getFactory().removeByModel(conn, corsista);
			CorsoDAO.getFactory().removeByModel(conn, c);
			corsista = null;
			c=null;
			cc=null;
			System.out.println("Eliminato corso corsista");
			DBAccess.closeConnection();
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
	}

	@AfterEach
	void tearDown() throws Exception {
		DBAccess.closeConnection();
	}

	@Test
	@Order(1)
	void testGetFactory() {
		CorsoCorsistaDAO cDAO = CorsoCorsistaDAO.getFactory();
		assertNotNull(cDAO);
	}
	
	@Test
	@Order(2)
	void testCreateFromModel() {
	try {
		CorsoCorsistaDAO.getFactory().createFromModel(conn, cc);
		System.out.println("Creato corso corsista");
	} catch(SQLException exc) {
		exc.printStackTrace();
		fail(exc.getMessage());
		}
	}

}
