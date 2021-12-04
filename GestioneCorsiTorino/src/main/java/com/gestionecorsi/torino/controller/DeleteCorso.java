package com.gestionecorsi.torino.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gestionecorsi.torino.bc.AdminFacade;
import com.gestionecorsi.torino.model.Corso;

/**
 * Servlet implementation class DeleteCorso
 */
@WebServlet("/DeleteCorso")
public class DeleteCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCorso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idc = request.getParameter("idc");
		Corso tmp = null;
		if(idc != null) {
			tmp = new Corso();
			tmp.setIdCorso(Long.parseLong(idc));
			try {
				AdminFacade.getInstance().removeCorso(tmp);
				response.sendRedirect("corsi.jsp");
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				throw new ServletException(e);
			}
		}
	}

}
