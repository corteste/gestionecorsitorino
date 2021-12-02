package com.gestionecorsi.torino.utilities;



import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gestionecorsi.torino.dao.DAOCostants;
import com.gestionecorsi.torino.dbaccess.DBAccess;



public class LoginControl  implements DAOCostants {
	
	private Connection conn;
	
	
	public LoginControl() throws ClassNotFoundException,  IOException, SQLException {
		conn =DBAccess.getConnection();
	}
	
	public String getAdminPass(String admin) throws SQLException  {
		PreparedStatement st;
		try {
			st = conn.prepareStatement(SELECT_PASSWORD_ADMIN);
			st.setString(1, admin);
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
				return rs.getString(1);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SQLException();
		
		}
		return null;
		

	}
	

}
