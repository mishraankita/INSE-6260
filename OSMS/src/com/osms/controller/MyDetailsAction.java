package com.osms.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.Student;

public class MyDetailsAction extends ActionSupport implements ModelDriven<Student>,SessionAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	Student student = new Student();
	
	public String getMyDetails() {
		String userID = (String) sessionMap.get("UserID");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<my userID  is : " +userID);
		
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
		//		out.println(" <h2 align=center><a href=./student.jsp>VIEW MY Account</a><br/></h2>");
				ResultSet rs = stmt
						.executeQuery("select * from studentdetails where UserID='"
								+ userID + "'");
//				out.println("<html>"
//						+ "<body background=welcome.jpg >"
//						+ "<h1 align=center >"
//						+ "<font color=blue>Student Details</font></h1><br><table border =1 align=center ><tr><th>User ID</th><th>FirstName</th><th>LastName</th> <th>Address</th><th>Phone Number</th> <th>Email</th><th>Session Joined</th><th>Department ID</th><th>Enrolled in program</th><th>Date of birth</th></tr>");
				while (rs.next()) {
					student.setUserID(rs.getInt(1));
					student.setFirstName(rs.getString(2));
					student.setLastname(rs.getString(3));
					student.setAddress(rs.getString(4));
					student.setPhoneNumber(rs.getInt(5));
					student.setEmail(rs.getString(6));
					student.setSessionJoined(rs.getString(7));
					student.setDepartmentID(rs.getInt(8));
					student.setEnrollProgram(rs.getString(9));
					student.setDob(rs.getString(10));
				}
				ResultSet rs2 = stmt
							.executeQuery("select * from coursetaken where UserID='"
									+ userID + "'");
				while (rs2.next()) {
						student.setCourseID(rs2.getInt(2));
						student.setGradesObtained(rs2.getString(3));
				}
		
				ResultSet rs3 = stmt
							.executeQuery("select * from feepayment where UserID='"
									+ userID + "'");
				while (rs3.next()) {
					student.setFeesPaid(true);
					String paymentDateYear = rs3.getString(2).substring(0,4);
					String paymentDateMonth = rs3.getString(2).substring(4,6);
					String paymentDateDay = rs3.getString(2).substring(6,8);
					student.setPaymentDate(rs3.getString(2).substring(0,4)+"-"+rs3.getString(2).substring(4,6)+"-"+rs3.getString(2).substring(6,8));
					student.setPaymentAmount(rs3.getInt(3));
					student.setPaymentFeeDeadLine(paymentDateYear+"-"+paymentDateMonth+"-"+paymentDateDay);
				}
				
				ResultSet rs4 = stmt
						.executeQuery("select Status from login where UserID='"
								+ userID + "'");
				while (rs4.next()) {
					student.setStatus(rs4.getInt(1)==1 ? "Active" : "InActive");
				}
				return "success";
			}
		 catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
	}


	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}

	public Student getModel() {
		return student;
	}
}
