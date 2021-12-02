package test.com.gestionecorsi.torino.bc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import com.gestionecorsi.torino.bc.CorsistaBC;
import com.gestionecorsi.torino.bc.CorsoBC;
import com.gestionecorsi.torino.bc.CorsoCorsistaBC;
import com.gestionecorsi.torino.model.Corsista;
import com.gestionecorsi.torino.model.Corso;
import com.gestionecorsi.torino.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)


class CorsoCorsistaBCTest {
	private static CorsoCorsista cc;
	private static Corsista corsista;
	private static Corso c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista = new Corsista();
		corsista.setCodCorsista(10);
		corsista.setNomeCorsista("Marco");
		corsista.setCognomeCorsista("Bianchi");
		corsista.setPrecedentiFormativi("S");
		CorsistaBC corsistaBC = new CorsistaBC();
		corsistaBC.createFromModel(corsista);
		
		c = new Corso();
		c.setIdCorso(5);
		c.setNomeCorso("Corso 1");
		c.setDataInizio(new Date());
		c.setDataFine(new Date());
		c.setCostoCorso(1000);
		c.setCommenti("A;J;J;F;");
		c.setAulaCorso("A1");
		c.setCodDocente("00001");
		CorsoBC corsoBC = new CorsoBC();
		corsoBC.createFromModel(c);
		
		cc = new CorsoCorsista();
		cc.setCodCorsista(corsista.getCodCorsista());
		cc.setCodCorso(c.getIdCorso());
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistaBC corsistaBC = new CorsistaBC();
			CorsoBC corsoBC = new CorsoBC();
			CorsoCorsistaBC cBC = new CorsoCorsistaBC();
			cBC.removeByModel(cc);
			corsoBC.removeByModel(c);
			corsistaBC.removeByModel(corsista);
			System.out.println("Eliminato corso, corsista, corso corsista");
			corsista = null;
			c = null;
			cc = null;
		} catch(SQLException sql) {
			fail(sql.getMessage());
		}
	}

	@Test
	@Order(1)
	void createTest() throws ClassNotFoundException, IOException {
		try {
			CorsoCorsistaBC cBC = new CorsoCorsistaBC();
			cBC.createFromModel(cc);
			System.out.println("Creato corso, corsista, corso corsista");
		} catch(SQLException exc) {
			fail(exc.getMessage());
		}
	}

}
