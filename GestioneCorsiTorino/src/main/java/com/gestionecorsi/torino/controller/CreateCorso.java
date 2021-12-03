package com.gestionecorsi.torino.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("Nome : "+request.getParameter("nomecorso")+" Data inizio = "+request.getParameter("datainizio")+" Data fine = "+request.getParameter("datafine")
		+"Costo"+request.getParameter("prezzo")+" Commento = "+request.getParameter("commento")+" Aula = "+request.getParameter("aula")+" docente = "+request.getParameter("docente"));
	}

}
