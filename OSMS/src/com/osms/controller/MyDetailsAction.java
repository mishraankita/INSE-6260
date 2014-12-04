package com.osms.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.Student;

public class MyDetailsAction extends ActionSupport implements ModelDriven<Student> , SessionAware,ServletRequestAware,ServletResponseAware { 

	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	HttpServletResponse response;
	HttpServletRequest request;
	Student student = new Student();

	public String getMyDetails() {
		String userID = (String) sessionMap.get("UserID");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<my userID  is : " + userID);

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			PrintWriter out = getServletResponse().getWriter();
			// out.println(" <h2 align=center><a href=./student.jsp>VIEW MY Account</a><br/></h2>");
			ResultSet rs = stmt
					.executeQuery("select * from studentdetails where UserID='"
							+ userID + "'");
			// out.println("<html>"
			// + "<body background=welcome.jpg >"
			// + "<h1 align=center >"
			// +
			// "<font color=blue>Student Details</font></h1><br><table border =1 align=center ><tr><th>User ID</th><th>FirstName</th><th>LastName</th> <th>Address</th><th>Phone Number</th> <th>Email</th><th>Session Joined</th><th>Department ID</th><th>Enrolled in program</th><th>Date of birth</th></tr>");
			while (rs.next()) {
				student.setUserID(rs.getInt(1));
				student.setFirstname(rs.getString(2));
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
			Map<Integer,List> courseMap = new HashMap<Integer, List>();
			float cgpa=0.0f;
			float coursesFinished = 0.0f;
			while (rs2.next()) {
				List courseDetailsList = new ArrayList();
				student.setCourseID(rs2.getInt(2));
				student.setGradesObtained(rs2.getString(3));
				String gradeObtained = rs2.getString(3)!=null?rs2.getString(3):"In Progress";
				courseDetailsList.add(gradeObtained);
				if(rs2.getString(3) !=null){
					coursesFinished +=1;
					if(gradeObtained.equalsIgnoreCase("A+"))
						cgpa +=4.3;
					else if(gradeObtained.equalsIgnoreCase("A"))
						cgpa +=4;
					else if (gradeObtained.equalsIgnoreCase("A-"))
						cgpa +=3.7;
					else if (gradeObtained.equalsIgnoreCase("B+"))
						cgpa +=3.3;
					else if (gradeObtained.equalsIgnoreCase("B"))
						cgpa +=3;
					else if(gradeObtained.equalsIgnoreCase("B-"))
						cgpa +=2.7;
					else
						cgpa +=0;
				}
				courseDetailsList.add("4");
				courseDetailsList.add(rs2.getString(4));
				courseMap.put(rs2.getInt(2),courseDetailsList);
				student.setCreditsCompleted(student.getCreditsCompleted()+4);
			}
			student.setCoursesMap(courseMap);
			if(coursesFinished !=0)
				student.setGpa((cgpa / coursesFinished));
			
//			ResultSet rs2 = stmt
//					.executeQuery("select * from coursetaken where UserID='"
//							+ userID + "'");
//			while (rs2.next()) {
//					out.println("<html>"
//							+ "<body background=welcome.jpg >"
//							+ "<br><br><h1 align=center >"
//							+ "<font color=blue>Student Academic Details</font></h1><table border =1 align=center ><tr><th>Course ID</th><th>Grades Obtained</th></tr>");
//				System.out.println("UserID" + rs2.getString(1));
//				out.println("<tr><td>" + rs2.getString(2) + "</td><td>"+ rs2.getString(3)
//						+ "</td></tr>");
//			}
//				out.println("</table border=3 ></body></html>");
			
			ResultSet rs3 = stmt
					.executeQuery("select * from feepayment where UserID='"
							+ userID + "'");
			while (rs3.next()) {
				student.setFeesPaid(true);
				String paymentDateYear = rs3.getString(2).substring(0, 4);
				String paymentDateMonth = rs3.getString(2).substring(4, 6);
				String paymentDateDay = rs3.getString(2).substring(6, 8);
				student.setPaymentDate(rs3.getString(2).substring(0, 4) + "-"
						+ rs3.getString(2).substring(4, 6) + "-"
						+ rs3.getString(2).substring(6, 8));
				student.setPaymentAmount(rs3.getInt(3));
				student.setPaymentFeeDeadLine(paymentDateYear + "-"
						+ paymentDateMonth + "-" + paymentDateDay);
			}
			if(student.getFeesPaid()==null || student.getFeesPaid()){
				rs3 = stmt
						.executeQuery("select * from feepayment where UserID='0'");
				while (rs3.next()) {
					student.setFeesPaid(false);
					System.out.println();
					student.setPaymentFeeDeadLine(rs3.getString(4));
				}
			}

			ResultSet rs4 = stmt
					.executeQuery("select Status from login where UserID='"
							+ userID + "'");
			while (rs4.next()) {
				student.setStatus(rs4.getInt(1) == 1 ? "Active" : "InActive");
			}
			String accountType = (String) sessionMap.get("accountType");
			if (accountType.equals("student")) {
				return "successStudent";
			} else {
				return "successAdmin";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getServletResponse() {
		return this.response;
	}
	
	public Student getModel() {
		return student;
	}
}
