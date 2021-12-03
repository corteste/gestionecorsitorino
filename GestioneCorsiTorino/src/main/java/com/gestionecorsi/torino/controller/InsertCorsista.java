package com.gestionecorsi.torino.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gestionecorsi.torino.bc.CorsistaBC;
import com.gestionecorsi.torino.bc.CorsoCorsistaBC;
import com.gestionecorsi.torino.exception.InvalidCorsistaException;
import com.gestionecorsi.torino.model.Corsista;
import com.gestionecorsi.torino.model.CorsoCorsista;

/**
 * Servlet implementation class InsertCorsista
 */

public class InsertCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCorsista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs = request.getSession();
		Corsista c = new Corsista();
		CorsoCorsista cc = new CorsoCorsista();
		String nome  = request.getParameter("nome") ,cognome = request.getParameter("cname") ;
		long idc =Long.parseLong(request.getParameter("idc"));
		c.setNomeCorsista(nome);
		c.setCognomeCorsista(cognome);
		if(request.getParameter("S")!=null)
		c.setPrecedentiFormativi("S");
		else
		c.setPrecedentiFormativi("N");
		try {
			if(CorsistaBC.isValidCorsista(c)) {
				new CorsistaBC().createFromModel(c);
				cc.setCodCorsista(c.getCodCorsista());
				cc.setCodCorso(idc);
				new CorsoCorsistaBC().createFromModel(cc);
				hs.setAttribute("newcorsista", c);
			}
		} catch (InvalidCorsistaException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}

}
