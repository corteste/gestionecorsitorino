package com.gestionecorsi.torino.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.gestionecorsi.torino.model.Corso;
import com.gestionecorsi.torino.model.Docente;

public class AdminFacade {
	/**
	 * 
	 * @param codDocente
	 * @return
	 * @author Stefano Cortese
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public Docente getDocenteByString(String codDocente) throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		DocenteBC dBC = new DocenteBC();
		return dBC.getByString(codDocente);
	}
	
	/**
	 * 
	 * @return Un array list di tutti i docenti
	 * @author Stefano Cortese
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<Docente> getDocenti() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
		DocenteBC dBC = new DocenteBC();
		return dBC.getAll();
	}
	
	/**
	 * 
	 * @return
	 * @author Stefano Cortese
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getDocenteMostCorsi() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		DocenteBC dBC = new DocenteBC();
		return dBC.getDocenteMostCorsi();
	}
	
	public void createFromModel(Corso model) throws ClassNotFoundException, IOException, SQLException {
		CorsoBC cBC = new CorsoBC ();
		cBC.createFromModel(model);
	}
	
	public void removeByModel(Corso model) throws ClassNotFoundException, IOException, SQLException {
		CorsoBC cBC = new CorsoBC ();
		cBC.removeByModel(model);
	}
	
	public Corso getModelByNumericalId(long id) throws ClassNotFoundException, IOException, SQLException {
		CorsoBC cBC = new CorsoBC ();
		return cBC.getModelByNumericalId(id);
	}
	
	public List<Corso> getAll() throws ClassNotFoundException, IOException, SQLException{
		CorsoBC cBC = new CorsoBC ();
		return cBC.getAll();
	}
	
	public String getPopularCorso() throws ClassNotFoundException, IOException, SQLException {
		CorsoBC cBC = new CorsoBC ();
		return cBC.getPopularCorso();
	}
	
	public Corso getDataLastCorso() throws ClassNotFoundException, IOException, SQLException {
		CorsoBC cBC = new CorsoBC();
		return cBC.getDataLastCorso();
	}
	public List<String> getAvailableCorso() throws ClassNotFoundException, IOException, SQLException{
		CorsoBC cBC = new CorsoBC();
		return cBC.getAvailableCorso();
	}
	
	public int getCountCommenti(long id) throws ClassNotFoundException, IOException, SQLException {
		CorsoBC cBC = new CorsoBC();
		return cBC.getCountCommenti(id);
	}
	
	
}
