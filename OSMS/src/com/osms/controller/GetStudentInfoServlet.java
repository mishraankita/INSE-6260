package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class GetStudentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//String userID = (String) request.getSession().getAttribute("userID");
		String userID = (String) session.getAttribute("userID");	
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! " + userID);
		//String firstName = request.getParameter("firstName");
		PrintWriter out = response.getWriter();

		try {
			Connection con = DBConnection.getConnection();
			String action = request.getParameter("action");
			PreparedStatement updateData = null;
			
			 if("Edit Address".equals(action)){
				 String address = request.getParameter("address");
				    String updateString =
				            "update studentdetails " +
				            "set Address = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, address);
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
			 if("Edit PhoneNumber".equals(action)){
				 String phoneNumber = request.getParameter("phoneNumber");
				    String updateString =
				            "update studentdetails " +
				            "set PhoneNumber = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, String.valueOf(phoneNumber));
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
			 if("Edit Email".equals(action)){
				 String email = request.getParameter("Email");
				    String updateString =
				            "update studentdetails " +
				            "set Email = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, email);
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
		
			 if("Edit DateOfBirth".equals(action)){
				 String dateOfBirth = request.getParameter("DateOfBirth");
				    String updateString =
				            "update studentdetails " +
				            "set DateOfBirth = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, dateOfBirth);
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
			 
				out.println(" <h2 align=center><a href=./studentsuccess.jsp> Go to Home</a></h2>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
