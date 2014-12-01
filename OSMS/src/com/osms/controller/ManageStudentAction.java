package com.osms.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.Student;

public class ManageStudentAction extends ActionSupport implements
		ModelDriven<Student>, SessionAware, ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest request;
	private Student student = new Student();

	public String getStudentDetails() {
		String userID = request.getParameter("userID");
		// String userID = String.valueOf(student.getUserID());
		System.out.println("<<<<<<<<<<<<<<<<<<<<<my userID  is : " + userID);

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
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
				System.out.println(student.getUserID());
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
			while (rs2.next()) {
				student.setCourseID(rs2.getInt(2));
				student.setGradesObtained(rs2.getString(3));
			}

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

			ResultSet rs4 = stmt
					.executeQuery("select Status,Password,SecurityQuestion,Answer from login where UserID='"
							+ userID + "'");
			while (rs4.next()) {
				student.setPassword(rs4.getString(2));
				student.setSecurityQuestion(rs4.getString(3));
				student.setAnswer(rs4.getString(4));
				student.setStatus(rs4.getInt(1) == 1 ? "Active" : "InActive");
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public String updateStudent() {
		// String userID = request.getParameter("userID");
		String userID = String.valueOf(student.getUserID());
		System.out.println("<<<<<<<<<<<<<<<<<<<<<my userID  is : " + userID);

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement updateData = null;
			String updateString = "update studentdetails "
					+ "set FirstName = ?,LastName = ?, Address = ?, PhoneNumber = ?,"
					+ "Email = ?,SessionJoined = ?,DepartmentID = ?,EnrollProgram = ?,DateOfBirth = ? where UserID = ?";
			updateData = con.prepareStatement(updateString);
			updateData.setString(1, student.getFirstname());
			updateData.setString(2, student.getLastname());
			updateData.setString(3, student.getAddress());
			updateData.setLong(4, student.getPhoneNumber());
			updateData.setString(5, student.getEmail());
			updateData.setString(6, student.getSessionJoined());
			updateData.setLong(7, student.getDepartmentID());
			updateData.setString(8, student.getEnrollProgram());
			updateData.setString(9, student.getDob());
			updateData.setLong(10, student.getUserID());

			updateData.executeUpdate();

			updateString = "update login "
					+ "set Status = ?,Password = ?, SecurityQuestion = ?, Answer = ?"
					+ " where UserID = ?";
			updateData = con.prepareStatement(updateString);
			updateData.setString(1, student.getStatus());
			updateData.setString(2, student.getPassword());
			updateData.setString(3, student.getSecurityQuestion());
			updateData.setString(4, student.getAnswer());
			updateData.setLong(5, student.getUserID());

			updateData.executeUpdate();
			
			String message = "Record Successfully Updated !!";
			request.setAttribute("resultsMessage", message);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
	}

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}

	public Student getModel() {
		return student;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
