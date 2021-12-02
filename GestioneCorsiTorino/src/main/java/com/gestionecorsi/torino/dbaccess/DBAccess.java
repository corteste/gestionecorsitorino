package com.gestionecorsi.torino.dbaccess;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBAccess {
	
	private static Connection conn;
	
	
	public static synchronized Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream in = cl.getResourceAsStream("properties/config.properties");
		Properties p = new Properties();
		p.load(in);
		Class.forName(p.getProperty("jdbcDriver"));

			conn = DriverManager.getConnection(p.getProperty("jdbcURL"),
											   p.getProperty("jdbcUserName"),
											   p.getProperty("jdbcPassword"));
			conn.setAutoCommit(false);
	
		return conn;
	}
	
	public static boolean closeConnection() throws SQLException {
		if(conn != null)
			conn.close();
			return true;
		
		
	
	}
}
