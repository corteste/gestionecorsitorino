package test.com.gestionecorsi.torino.utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.utilities.LoginControl;

class LoginControlTest {

	@Test
	void testGetAdminPass() throws ClassNotFoundException, IOException, SQLException {
		LoginControl lc = new LoginControl();
		assertEquals("PIPPO", lc.getAdminPass("AAAAA"));
		assertNotEquals("PIPPO",lc.getAdminPass("ASDF") );
		
	}

}
