package com.gestionecorsi.torino.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gestionecorsi.torino.utilities.LoginControl;



/**
 * Servlet implementation class loginAdminController
 */

public class LoginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tmp = -1;
		String admin=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		String username;
		if ((!admin.equals("")) && (!password.equals(""))) { //CREDO NON POSSANO ESSERE NULLI
			try {
				LoginControl lc = new LoginControl();
				username = lc.getAdminPass(password);
				if (username != null) {
					if (username.equals(admin)) {
						session.setAttribute("admin", admin);
						response.sendRedirect("home.jsp");						
					} else {
						if(session.getAttribute("attempt") == null)
							session.setAttribute("attempt", 1);
							else{
							tmp =(Integer) session.getAttribute("attempt");
							session.setAttribute("attempt",++tmp );
							}
						response.sendRedirect("index.jsp");
					}
				}else {
					if(session.getAttribute("attempt") == null)
						session.setAttribute("attempt", 1);
						else{
						tmp =(Integer) session.getAttribute("attempt");
						session.setAttribute("attempt",++tmp );
						}
					response.sendRedirect("index.jsp");
				}
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			response.sendRedirect("index.jsp");
			//
		}
	}

}
