package com.sv.myproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.istack.internal.logging.Logger;

public class DBConnection {
	private static Logger logger = Logger.getLogger(DBConnection.class);
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			logger.info("Inside DBConnection method of getConnection : ");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SUDHAKAR", "sudhakar");
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception Inside DBConnection method of getConnection : "+e.getMessage());
		}
		return conn; 
	}
	
	public static void close(Connection conn, ResultSet rs, PreparedStatement pst) {
		try {
			logger.info("Inside DBConnection method of close : ");
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(pst != null) {
				pst.close();
				pst = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception Inside DBConnection method of getConnection : "+e.getMessage());
		}
	}

}
