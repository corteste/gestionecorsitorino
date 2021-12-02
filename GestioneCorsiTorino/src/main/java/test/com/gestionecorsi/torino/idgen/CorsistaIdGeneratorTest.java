package test.com.gestionecorsi.torino.idgen;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.idgen.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {

	@Test
	void test() {
		try {
			CorsistaIdGenerator idGen = CorsistaIdGenerator.getInstance();
			assertNotNull(idGen, "Istanza non generata correttamente");
			long valore = idGen.getNextId();
			assertEquals(valore, idGen.getNextId() - 1);
		} catch (ClassNotFoundException | SQLException | IOException exc) {
			fail(exc.getMessage());
		}
	}

}
