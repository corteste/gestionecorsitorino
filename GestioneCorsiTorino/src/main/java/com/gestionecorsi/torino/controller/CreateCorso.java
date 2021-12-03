package com.gestionecorsi.torino.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gestionecorsi.torino.bc.CorsoBC;
import com.gestionecorsi.torino.exception.InvalidCorsoException;
import com.gestionecorsi.torino.model.Corso;

/**
 * Servlet implementation class CreateCorso
 */

public class CreateCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCorso() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession hs = r
		String nome = request.getParameter("nomecorso") ,dataInizio = request.getParameter("datainizio") ,dataFine = request.getParameter("datafine"),
		costo = request.getParameter("prezzo") ,commento = request.getParameter("commento"), aula = request.getParameter("aula"), docente = request.getParameter("docente");
		
		Corso c = new Corso();
		c.setNomeCorso(nome);
		try {
			c.setDataInizio(new SimpleDateFormat("dd/MM/yyyy").parse(dataInizio));
			c.setDataFine(new SimpleDateFormat("dd/MM/yyyy").parse(dataFine));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
		if(costo.length() != 0)
			if(costo.matches("([0-9]*\\.[0-9]+|[0-9]+)"))
		c.setCostoCorso(Double.parseDouble(costo));
		else
			c.setCostoCorso(0.0);
		c.setCommenti(commento+";");
		c.setAulaCorso(aula);
		c.setCodDocente(docente);
		try {
			CorsoBC cbc = new CorsoBC();
			if(cbc.isValidCorso(c))
			{
				cbc.createFromModel(c);
				
				response.sendRedirect("inseriscicorsista.jsp");
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (InvalidCorsoException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	
	}

}
