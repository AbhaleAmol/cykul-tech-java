package com.cykul.rides.service.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CYKULRidesLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest servletRequest , HttpServletResponse servletResponse) throws IOException {
		doPost(servletRequest , servletResponse);
	}
	
	public void doPost(HttpServletRequest servletRequest , HttpServletResponse servletResponse) throws IOException{
		
		String currentUserName = servletRequest.getParameter("username");		
		String currentPassword = servletRequest.getParameter("password");
		
		if(currentUserName.equals("root") && currentPassword.equals("toor")) {
			PrintWriter printWriter = servletResponse.getWriter();
			printWriter.write("Welcome " + currentUserName);
			printWriter.close();
		} else {
			servletResponse.sendRedirect("login-failed.html");
		}
	}

}
