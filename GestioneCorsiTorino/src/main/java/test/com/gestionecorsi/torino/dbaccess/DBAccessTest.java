package test.com.gestionecorsi.torino.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void testGetConnection() {
		try {
			assertNotNull(DBAccess.getConnection());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}

}
