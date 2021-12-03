package test.com.gestionecorsi.torino.bc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.gestionecorsi.torino.bc.DocenteBC;
import com.gestionecorsi.torino.model.Docente;

/**
 * 
 * @author Ayoub
 *
 */
class DocenteBCTest {

	@Test
	void testGetByString() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		try {
			DocenteBC dBC = new DocenteBC();
			Docente docente = dBC.getByString("00002");
			assertNotNull(docente);
			System.out.println(docente.getNomeDocente()+" "+ 
							   docente.getCognomeDocente());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testGetAll() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		try {
			DocenteBC dBC = new DocenteBC();
			List<Docente> docenti = dBC.getAll();
			assertNotNull(docenti);
		} catch (ClassNotFoundException | IOException | SQLException e) {
			fail(e.getMessage());
		}
	}
	
	/**
	 * @autor Stefano Cortese
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	
	@Test
	void testDocenteMostCorsi() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		try {
			DocenteBC dBC = new DocenteBC();
			String codDocente = dBC.getDocenteMostCorsi();
			assertNotNull(codDocente,"Codice docente nullo");
			Docente docente = dBC.getByString(codDocente);
			assertNotNull(docente);
			System.out.println(docente.getNomeDocente()+" "+ 
							   docente.getCognomeDocente() + ": Docente con più corsi " );
		} catch (ClassNotFoundException | IOException | SQLException e) {
			fail(e.getMessage());
		}
	}

}
