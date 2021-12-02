package test.com.gestionecorsi.torino.bc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.gestionecorsi.torino.bc.CorsistaBC;
import com.gestionecorsi.torino.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)

class CorsistaBCTest {
	private static Corsista corsista;
	private static CorsistaBC cors;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista = new Corsista();
		cors = new CorsistaBC();
		corsista.setNomeCorsista("Marco");
		corsista.setCognomeCorsista("Bianchi");
		corsista.setPrecedentiFormativi("S");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			cors.removeByModel(corsista);
			corsista = null;
			System.out.println("Eliminato corsista");
			cors.closeConnection();
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}

	}

	@Test
	@Order(1)
	void testCreateFromModel() {
		try {
			cors.createFromModel(corsista);
			System.out.println("Creato corsista");
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(2)
	void testGetAll() {
		try {
			List<Corsista> lc = cors.getAll();
			assertNotNull(lc);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(3)
	void testGetByNumericalID() {
		try {
			Corsista corsista2 = cors.getByNumericalId(corsista.getCodCorsista());
			assertNotNull(corsista2);
			System.out.println(corsista2.getNomeCorsista());
			System.out.println(corsista2.getCognomeCorsista());
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	@Order(4)
	void testGetNCorsisti() {
		try {
			int nCorsisti = cors.getNCorsisti();
			assertEquals(1, nCorsisti);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
