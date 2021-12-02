package test.com.gestionecorsi.torino.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.gestionecorsi.torino.dao.CorsistaDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.model.Corsista;
@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista = new Corsista();
		corsista.setCodCorsista(10);
		corsista.setNomeCorsista("Marco");
		corsista.setCognomeCorsista("Bianchi");
		corsista.setPrecedentiFormativi("S");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			conn = DBAccess.getConnection();
			CorsistaDAO.getFactory().removeByModel(conn, corsista);
			corsista = null;
			System.out.println("Eliminato corsista");
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
		CorsistaDAO cDAO = CorsistaDAO.getFactory();
		assertNotNull(cDAO);
	}

	@Test
	@Order(2)
	void testCreateFromModel() {
		try {
			CorsistaDAO.getFactory().createFromModel(conn, corsista);
			System.out.println("Creato corsista");
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(3)
	void testGetAll() {
		try {
			List<Corsista> corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(4)
	void testGetByNumericalId() {
		try {
			Corsista corsista = CorsistaDAO.getFactory().getModelByNumericalId(conn, 10);
			assertNotNull(corsista);
			System.out.println(corsista.toString());
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(5)
	void testGetNCorsisti() {
		try {
			int nCorsisti = CorsistaDAO.getFactory().getNCorsisti(conn);
			assertEquals(1, nCorsisti);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
