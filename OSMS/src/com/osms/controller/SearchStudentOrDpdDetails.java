package com.osms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.Employee;
import com.osms.domain.Student;

public class SearchStudentOrDpdDetails extends ActionSupport implements SessionAware,
ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public void searchDetails() {

		String accountType = request.getParameter("accountType");
		String userID = request.getParameter("userID");
		
		List l = new ArrayList();
		try {
			PrintWriter out = response.getWriter();
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			boolean validStudentAccount = false;
			if (accountType.equalsIgnoreCase("student")) {
				out.println(" <h2 align=center><a href=./studentEnroll.jsp>Register a new Student</a><br/></h2>");
				ResultSet rs = stmt
						.executeQuery("select * from studentdetails where UserID='"
								+ userID + "'");
				while (rs.next()) {
					validStudentAccount = true;
					out.println("<html>"
							+ "<body background=welcome.jpg >"
							+ "<h1 align=center >"
							+ "<font color=blue>Student Details</font></h1><table border =1 align=center ><tr><th>User ID</th><th>FirstName</th><th>LastName</th> <th>Address</th><th>Phone Number</th> <th>Email</th><th>Session Joined</th><th>Department ID</th><th>Enrolled in program</th><th>Date of birth</th></tr>");
					
					Student s = new Student();
					s.setUserID(rs.getInt(1));
					s.setFirstName(rs.getString(2));
					s.setLastname(rs.getString(3));
					s.setAddress(rs.getString(4));
					s.setPhoneNumber(rs.getInt(5));
					s.setEmail(rs.getString(6));
					s.setSessionJoined(rs.getString(7));
					s.setDepartmentID(rs.getInt(8));
					s.setEnrollProgram(rs.getString(9));
					s.setDob(rs.getString(10));
					l.add(s);

					System.out.println("UserID" + s.getUserID());
					out.println("<tr><td>" + s.getUserID() + "</td><td>"
							+ s.getFirstName() + "</td><td>" + s.getLastName()
							+ "</td><td>" + s.getAddress() + "</td><td>"
							+ s.getPhoneNumber() + "</td><td>" + s.getEmail()
							+ "</td><td>" + s.getSessionJoined() + "</td><td>"
							+ s.getDepartmentID() + "</td><td>"
							+ s.getEnrollProgram() + "</td><td>" + s.getDob()
							+ "</td></tr>");
					out.println("</table border=3 ></body></html>");
				}
					ResultSet rs2 = stmt
							.executeQuery("select * from coursetaken where UserID='"
									+ userID + "'");
					boolean printAcademicDetails = true;
					while (rs2.next() && validStudentAccount) {
						if(printAcademicDetails){
							out.println("<html>"
									+ "<body background=welcome.jpg >"
									+ "<br><br><h1 align=center >"
									+ "<font color=blue>Student Academic Details</font></h1><table border =1 align=center ><tr><th>Course ID</th><th>Grades Obtained</th></tr>");
							printAcademicDetails=false;
						}
						System.out.println("UserID" + rs2.getString(1));
						out.println("<tr><td>" + rs2.getString(2) + "</td><td>"+ rs2.getString(3)
								+ "</td></tr>");
					}
					if(!printAcademicDetails){
						out.println("</table border=3 ></body></html>");
					}
					ResultSet rs3 = stmt
							.executeQuery("select * from feepayment where UserID='"
									+ userID + "'");
					System.out.println("rs is :" + rs3);

					System.out
							.println("===============students====  Payment Date ,Payment Amount , Payment Fee Deadline ===========");
					boolean print = true;
					boolean printFeesNotPaid = true;
					while (rs3.next() && validStudentAccount) {
						printFeesNotPaid = false;
						if(print){
							out.println("<html>"
									+ "<body background=welcome.jpg >"
									+ "<br><br><h1 align=center >"
									+ "<font color=blue>Student Fees Payment</font></h1><table border =1 align=center ><tr><th>Payment Date</th><th>Payment Amount Obtained</th><th>Fee Payment deadline</th></tr>");
							print=false;
						}
						
						out.println("<tr><td>" + rs3.getString(2).substring(0,4)+"-"+rs3.getString(2).substring(4,6)+"-"+rs3.getString(2).substring(6,8) + "</td><td>"+ rs3.getString(3)
								+ "</td><td>"+ rs3.getString(4).substring(0,4)+"-"+rs3.getString(4).substring(4,6)+"-"+rs3.getString(4).substring(6,8)
								+ "</td></tr>");
						out.println("</table border=3 ></body></html>");
					}
					if(printFeesNotPaid && validStudentAccount){
						out.println("<html>"
								+ "<body background=welcome.jpg >"
								+ "<br><br><h1 align=center >"
								+ "<font color=blue>Student Fees Payment</font></h1><table border =1 align=center ><tr><th>Payment Date</th><th>Payment Amount Obtained</th><th>Fee Payment deadline</th></tr>");
						
						out.println("<tr><td>" + "Fee not paid" + "</td><td>"+ "Fee not paid"
								+ "</td><td>"+ "Fee not paid"
								+ "</td></tr>");
						out.println("</table border=3 ></body></html>");
					}
					
					ResultSet rs4 = stmt
							.executeQuery("select Status from login where UserID='"
									+ userID + "'");
					
					while (rs4.next() && validStudentAccount) {
						out.println("<html>"
								+ "<body background=welcome.jpg >"
								+ "<br><br><h1 align=center >"
								+ "<font color=blue>Student Account Status</font></h1><table border =1 align=center ><tr><th>Account Status</th></tr>");
						out.println("<tr><td>" + rs4.getString(1) + "</td></tr>");
						out.println("</table border=3 ></body></html>");
					}
				
				
				out.println("<br/><br/>");
			} else {
				boolean validDPDAcoount = false;
				out.println(" <h2 align=center><a href=./student.jsp>Register a new Student</a><br/></h2>");
				//if selected entry is dpd.
				ResultSet rs = stmt
						.executeQuery("select * from employee where UserID='"
								+ userID + "'");
				while (rs.next()) {
					validDPDAcoount = true;
					out.println("<html>"
							+ "<body background=welcome.jpg >"
							+ "<h1 align=center >"
							+ "<font color=blue>DPD Details</font></h1><br><table border =1 align=center ><tr><th>User ID</th><th>FirstName</th><th>LastName</th><th>Address</th><th>Email</th></tr>");
					
					Employee e = new Employee();
					e.setUserID(rs.getInt(1));
					e.setFirstName(rs.getString(2));
					e.setLastname(rs.getString(3));
					e.setAddress(rs.getString(4));
					e.setEmail(rs.getString(5));
					l.add(e);

					System.out.println("UserID" + rs.getInt(1));
					out.println("<tr><td>" + rs.getInt(1) + "</td><td>"
							+ rs.getString(2) + "</td><td>" + rs.getString(3)
							+ "</td><td>" + rs.getString(4) + "</td><td>"
							+ rs.getString(5) + "</td></tr>");
					out.println("</table border=3 ></body></html>");
				}
				
				ResultSet rs4 = stmt
						.executeQuery("select Status from login where UserID='"
								+ userID + "'");
				
				while (rs4.next() && validDPDAcoount) {
					out.println("<html>"
							+ "<body background=welcome.jpg >"
							+ "<br><br><h1 align=center >"
							+ "<font color=blue>Student Account Status</font></h1><table border =1 align=center ><tr><th>Account Status</th></tr>");
					out.println("<tr><td>" + rs4.getString(1) + "</td></tr>");
					out.println("</table border=3 ></body></html>");
				}
				
				out.println("<br/><br/>");
			}
			out.println(" <h2 align=center><a href=./studentEnroll.jsp>Register a new Student</a><br/></h2>");
			out.println(" <h2 align=center><a href=./adminsuccess.jsp> Go to Home</a></h2>");
			System.out.println("==============================");
			request.setAttribute("List", l);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
	}
}
