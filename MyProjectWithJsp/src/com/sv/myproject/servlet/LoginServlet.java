package com.sv.myproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.istack.internal.logging.Logger;
import com.sv.myproject.service.LoginService;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);
       
 
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			logger.info("Inside LoginServlet doGet() method ");
			HttpSession session = request.getSession(false);
			if(session !=null) {
				if(session.getAttribute("userid") !=null) {
					RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/login.jsp");
					reqDisp.forward(request, response);
				} else {
					logger.info("Userid is null");
					RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/login.jsp");
					reqDisp.forward(request, response);
				}
				
			} else {
				logger.info("session is null. Please login again.");
				RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/login.jsp");
				reqDisp.forward(request, response);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/failure.jsp");
			reqDisp.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			logger.info("Inside LoginServlet doPost() method ");
			HttpSession session = request.getSession(false);
			if(session !=null) {
				String userid = request.getParameter("userid");
				String password = request.getParameter("password");
				session.setAttribute("userid", userid);
				if(session.getAttribute("userid") !=null && !session.getAttribute("userid").equals("")) {
					boolean loginValidation = LoginService.checkCredentials(userid, password);
					if(loginValidation == true) {
						logger.info("Login successfully");
						request.setAttribute("message", "Login successfully");
						RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/home.jsp");
						reqDisp.forward(request, response);
					} else {
						logger.info("Invalid credentials or user nor register.");
						request.setAttribute("message", "Invalid credentials or user nor register");
						RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/failure.jsp");
						reqDisp.forward(request, response);
					}
					
				} else {
					logger.info("useris is null. Please login again.");
					RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/login.jsp");
					reqDisp.forward(request, response);
				}
				
			} else {
				logger.info("session is null. Please login again.");
				RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/login.jsp");
				reqDisp.forward(request, response);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher reqDisp = request.getRequestDispatcher("/WEB-INF/JSP/failure.jsp");
			reqDisp.forward(request, response);
		}
	}

}
