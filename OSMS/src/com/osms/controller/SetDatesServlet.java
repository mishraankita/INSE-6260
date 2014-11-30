package com.osms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SetDatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

		try {
			Connection con = DBConnection.getConnection();
			String action = request.getParameter("action");
			PreparedStatement updateData = null;
			
			 if("Manage Fee Payment Deadline".equals(action)){
				 String newDate = request.getParameter("Manage Fee Payment Deadline");
				 String userID = "0";
				    String updateString =
				            "update feepayment " +
				            "set PaymentFeeDeadLine = ? where UserID = ?";
				    
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, newDate);
				    updateData.setString(2, userID);
				 
				 updateData.executeUpdate();
				 //con.commit();
			 }
			 
			 if("Manage course Add/Drop Deadline".equals(action)){
				 String newDate = request.getParameter("Manage course Add/Drop Deadline");
				 String CourseID = "0";
				    String updateString =
				            "update courseoffered " +
				            "set AddDropDeadline = ? where CourseID = ?";
				    
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, newDate);
				    updateData.setString(2, CourseID);
				 
				 updateData.executeUpdate();
				 //con.commit();
			 }

				out.println(" <h2 align=center><a href=./student.jsp>Register a new Student</a><br/></h2>");
				out.println(" <h2 align=center><a href=./adminsuccess.jsp> Go to Home</a></h2>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
