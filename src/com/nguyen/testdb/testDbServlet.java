package com.nguyen.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class testDbServlet
 */
@WebServlet("/testDbServlet")
public class testDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set up connection variables
			String user = "nguyen";
			String password = "password";
			
			String jdbcURL = "jdbc:mysql://localhost:3306/veterinary_clinic?useSSL=false";
			String driver = "com.mysql.jdbc.Driver";
		
		// get connection to db
			try {
				PrintWriter out = response.getWriter();
				out.println("Connecting to database: " + jdbcURL);
				
				Class.forName(driver);
				
				Connection myConn = DriverManager.getConnection(jdbcURL, user, password);
				out.println("Connection successful.");
				
				myConn.close();
			} catch (Exception exc) {
				exc.printStackTrace();
				throw new ServletException(exc);
			}
	}

}
