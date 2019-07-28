package com.sv.myproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.istack.internal.logging.Logger;
import com.sv.myproject.util.DBConnection;

public class LoginDao {
	private static Logger logger = Logger.getLogger(LoginDao.class);


	public static String getCredentials(String userid) {
		Connection conn = null;
		PreparedStatement pst = null;
		String sqlQuery = null;
		ResultSet rs = null;
		String password = "";
		try {
			conn = DBConnection.getConnection();
			if(conn !=null ) {
				sqlQuery = "SELECT USER_PASSWORD FROM USER_DETAILS WHERE USER_ID = ? ";
				pst = conn.prepareStatement(sqlQuery);
				pst.setString(1, userid);
				rs = pst.executeQuery();
				
				if(rs.next()) {
					password = rs.getString("USER_PASSWORD");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception in LoginDao method of getCredentials : "+e.getMessage());
		} finally {
			try {
				DBConnection.close(conn,rs,pst);
			} catch (Exception ex) {
				ex.printStackTrace();
				logger.info("Exception Inside finally in LoginDao method of getCredentials : "+ex.getMessage());
			}
		}
		
		return password;
	}

}
