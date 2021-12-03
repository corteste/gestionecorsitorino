package com.gestionecorsi.torino.bc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.gestionecorsi.torino.dao.CorsoDAO;
import com.gestionecorsi.torino.dbaccess.DBAccess;
import com.gestionecorsi.torino.exception.InvalidCorsoException;
import com.gestionecorsi.torino.idgen.CorsoIdGenerator;
import com.gestionecorsi.torino.model.Corso;
import com.gestionecorsi.torino.model.Docente;

public class CorsoBC {
	//TODO
	private Connection conn;
	private CorsoIdGenerator idGen;
	
	public CorsoBC() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
		idGen = CorsoIdGenerator.getInstance();
	}
	
	
	public void createFromModel(Corso model ) throws SQLException {
		model.setIdCorso(idGen.getNextId());
		CorsoDAO.getFactory().createFromModel(conn, model);
		
	}
	public Corso getModelByNumericalId(long id) throws SQLException {
		// TODO Auto-generated method stub
		return CorsoDAO.getFactory().getModelByNumericalId(conn, id);
	}
	public void removeByModel(Corso model) throws SQLException {
		CorsoDAO.getFactory().removeByModel(conn, model);
	}

	public List<Corso> getAll() throws SQLException {

		List<Corso> lc = new ArrayList<Corso>();

		lc = CorsoDAO.getFactory().getAll(conn);

		return lc;
	}
	
	public String getPopularCorso() throws SQLException {
		return CorsoDAO.getFactory().getPopularCorso(conn);

	}
	
	public Corso getDataLastCorso() throws SQLException {
		
		return  CorsoDAO.getFactory().getDataLastCorso(conn);
	}
	
	public int getCountCommenti(long id) throws SQLException {
		return CorsoDAO.getFactory().getCountCommenti(conn,id);
	}
	
	public List<String> getAvailableCorso() throws SQLException {
		return CorsoDAO.getFactory().getAvailableCorso(conn);
	}
	
	public double getAvgLength() throws SQLException {
		return CorsoDAO.getFactory().getAvgLength(conn);
	}
	
	public boolean isValidCorso(Corso c) throws InvalidCorsoException, ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		boolean b[] = {false,false,false,false,false};
		b[0] = checkValidNomeCorso(c.getNomeCorso());
		b[1] = checkValidDurataCorso(c.getDataInizio(),c.getDataFine());
		b[2] = checkValidCommento(c.getCommenti());
		b[3] = checkValidAula(c.getAulaCorso());
		b[4] = checkValidDocente(c.getNomeCorso(),c.getCodDocente());
		if(b[0]&&b[1]&&b[2]&&b[3]&&b[4])
		return true;
		else
		throw new InvalidCorsoException(b);
		
	}


	private boolean checkValidAula(String aulaCorso) {
		// TODO Auto-generated method stub
		if(aulaCorso.equals(""))
			return true;
		
		return aulaCorso.matches("[a-zA-Z0-9]{1,30}");
	}


	private boolean checkValidDocente(String nomeCorso,String codDocente) throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Docente d = new DocenteBC().getByString(codDocente);
		if(d == null)
			return false;
		
		String [] m = d.getCvDocente().split(";");
		
		for(String cv : m)
			if(cv.equals(nomeCorso))
				return true;
		return false;
	}


	private boolean checkValidCommento(String commento) {
		// TODO Auto-generated method stub
		if(commento.length() <=200)
		return true;
		
		return false;
	}


	private boolean checkValidDurataCorso(Date dataInizio, Date dataFine) {
		// TODO Auto-generated method stub
		boolean b = false;
		if(dataFine.getTime() > dataInizio.getTime()) { 
		GregorianCalendar di = new GregorianCalendar(),df=new GregorianCalendar();
		di.setTime(dataInizio);
		df.setTime(dataFine);
		
		
		if(df.get(GregorianCalendar.DAY_OF_MONTH) - di.get(GregorianCalendar.DAY_OF_MONTH) >=2)
		b = true;
		}
		return b;
	}


	private boolean checkValidNomeCorso(String nomeCorso) {
		// TODO Auto-generated method stub
		
		return nomeCorso.matches("^[a-zA-Z .]{1,30}");
	}
	
}
