package com.osms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.Student;

public class EnrollStudentOrDpd implements SessionAware,ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest request;
	Student student = new Student();
	int result1 = 0;
	int result2 = 0;
	int result3=0;

	public String enroll(){
		String accountType = request.getParameter("accountType");

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		String securityQuestion = request.getParameter("securityQuestion");
		String status = request.getParameter("status");
		String userID = request.getParameter("userID");
		String answer = request.getParameter("answer");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		Connection con = null;
		
		try {
			con = DBConnection.getConnection();

			if (accountType.equalsIgnoreCase("student")) {
				String phoneNumber = request.getParameter("phoneNumber");
				String dob = request.getParameter("dob");
				String sessionJoined = request.getParameter("sessionJoined");
				String departmentID = request.getParameter("departmentID");
				String enrollProgram = request.getParameter("enrollProgram");
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt
						.executeQuery("select UserID from studentdetails where UserID='"
								+ userID + "'");
				if (!rs.next()) {
					String query1 = "insert into studentdetails(UserID,FirstName,LastName,Address,PhoneNumber,Email,SessionJoined,DepartmentID,EnrollProgram,DateOfBirth) values(?,?,?,?,?,?,?,?,?,?) ";
					PreparedStatement psmt1 = con.prepareStatement(query1);
					psmt1.setString(1, userID);
					psmt1.setString(2, firstname);
					psmt1.setString(3, lastname);
					psmt1.setString(4, address);
					psmt1.setString(5, phoneNumber);
					psmt1.setString(6, email);
					psmt1.setString(7, sessionJoined);
					psmt1.setString(8, departmentID);
					psmt1.setString(9, enrollProgram);
					psmt1.setString(10, dob);

					result1 = psmt1.executeUpdate();
				}else{
					result1=1;
				}
				
			} else {
				System.out.println("inside the dpd registration");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt
						.executeQuery("select UserID from employee where UserID='"
								+ userID + "'");
				if(!rs.next()){
					String query1 = "insert into employee (UserID,FirstName,LastName,Address,Email) values(?,?,?,?,?) ";
					PreparedStatement psmt1 = con.prepareStatement(query1);
					psmt1.setString(1, userID);
					psmt1.setString(2, firstname);
					psmt1.setString(3, lastname);
					psmt1.setString(4, address);
					psmt1.setString(5, email);
					
					System.out.println("user id" + userID);
					System.out.println("firstname" + firstname);
					System.out.println("lastname" + lastname);
					System.out.println("address" + address);
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!! email" + email);

					result1 = psmt1.executeUpdate();
				}else{
					result1=1;
				}
			}
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select UserID from login where UserID='"
							+ userID + "'");
			if(!rs.next()){
				String query2 = "insert into login(UserID,Password,SecurityQuestion,Answer,AccountType,Status) values(?,?,?,?,?,?) ";
				PreparedStatement psmt2 = con.prepareStatement(query2);
				psmt2.setString(1, userID);
				psmt2.setString(2, password);
				psmt2.setString(3, securityQuestion);
				psmt2.setString(4, answer);
				psmt2.setString(5, accountType);
				psmt2.setString(6, status);

				result2 = psmt2.executeUpdate();
			}else{
				result2=1;
			}
			

			if (result1 == 1 && result2 == 1) {
				// request.setAttribute("firstname", firstname);
				sessionMap.put("UserID", userID);
				return "regsuccess";
			} else {
				return "regfailure";
			}
		} catch (Exception e) {
			e.printStackTrace();
			rollbackInsertion(con, userID);
			return "regfailure";
		}

	}
	
	private void rollbackInsertion(Connection con,String userID){
		String query3 = "DELETE from studentdetails where UserID=?";
		String query4 = "DELETE from login where UserID=?";
		
		PreparedStatement psmt3;
		try {
			psmt3 = con.prepareStatement(query3);
			psmt3.setString(1, userID);
			result3 = psmt3.executeUpdate();
			
			psmt3 = con.prepareStatement(query4);
			psmt3.setString(1, userID);
			result3 = psmt3.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	public HttpServletRequest getServletRequest(){
		return this.request;
	}
	
}
