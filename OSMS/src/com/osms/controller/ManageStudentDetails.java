package com.osms.controller;

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


public class ManageStudentDetails extends HttpServlet {
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
			
			 if("Edit First name".equals(action)){
				 String firstname = request.getParameter("FirstName");
				 //String updateString = "update studentdetails set FirstName = " + firstname + "where UserID ="+ userID + ";";
				    String updateString =
				            "update studentdetails " +
				            "set FirstName = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, firstname);
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
			 if("Edit Last name".equals(action)){
				 String lastname = request.getParameter("LastName");
				    String updateString =
				            "update studentdetails " +
				            "set LastName = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, lastname);
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
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
			 if("Edit SessionJoined".equals(action)){
				 String sessionJoined = request.getParameter("SessionJoined");
				    String updateString =
				            "update studentdetails " +
				            "set SessionJoined = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, sessionJoined);
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
			 if("Edit DepartmentID".equals(action)){
				 String departmentID = request.getParameter("DepartmentID");
				    String updateString =
				            "update studentdetails " +
				            "set DepartmentID = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, String.valueOf(departmentID));
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
			 if("Edit EnrollProgram".equals(action)){
				 String enrollProgram = request.getParameter("EnrollProgram");
				    String updateString =
				            "update studentdetails " +
				            "set EnrollProgram = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, enrollProgram);
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
			 if("Edit Status".equals(action)){
				 String status = request.getParameter("Edit Status");
				    String updateString =
				            "update login " +
				            "set Status = ? where UserID = ?";
				    updateData = con.prepareStatement(updateString);
				    updateData.setString(1, status);
				    updateData.setInt(2, Integer.parseInt(userID));
				 
				 updateData.executeUpdate();
			 }
			 
				out.println(" <h2 align=center><a href=./student.jsp>Register a new Student</a><br/></h2>");
				out.println(" <h2 align=center><a href=./adminsuccess.jsp> Go to Home</a></h2>");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
