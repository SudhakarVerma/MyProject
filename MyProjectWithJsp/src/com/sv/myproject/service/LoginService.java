package com.sv.myproject.service;

import com.sun.istack.internal.logging.Logger;
import com.sv.myproject.dao.LoginDao;

public class LoginService {
	private static Logger logger = Logger.getLogger(LoginService.class);

	public static boolean checkCredentials(String userid, String password) {
		
		boolean validate = false;
		try {
			String credentials = LoginDao.getCredentials(userid);
			
			if(credentials != null && !credentials.equals("") && credentials.equals(password)){
				validate = true;	
			} else {
				validate = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Exception in LoginService method of checkCredentials : "+e.getMessage());
		}
		
		return validate;
	}

}
