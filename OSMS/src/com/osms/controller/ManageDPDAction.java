package com.osms.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.Employee;
import com.osms.domain.Student;

public class ManageDPDAction extends ActionSupport implements
		ModelDriven<Employee>, SessionAware, ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	private HttpServletRequest request;
	private Employee dpd = new Employee();

	public String getDPDDetails() {
		String userID = request.getParameter("userID");
		// String userID = String.valueOf(student.getUserID());
		System.out.println("<<<<<<<<<<<<<<<<<<<<<my userID  is : " + userID);
		
		Connection con;
		try {
			con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from employee where UserID='"
							+ userID + "'");
			while (rs.next()) {
				dpd.setUserID(rs.getInt(1));
				dpd.setFirstname(rs.getString(2));
				dpd.setLastname(rs.getString(3));
				dpd.setAddress(rs.getString(4));
				dpd.setEmail(rs.getString(5));
			}
			
			ResultSet rs4 = stmt
					.executeQuery("select Status,Password,SecurityQuestion,Answer from login where UserID='"
							+ "123" + "'");
			while (rs4.next()) {
				dpd.setPassword(rs4.getString(2));
				dpd.setSecurityQuestion(rs4.getString(3));
				dpd.setAnswer(rs4.getString(4));
				dpd.setStatus(rs4.getInt(1) == 1 ? "Active" : "InActive");
			}
			return "success";
		} catch (SQLException e) {
			e.printStackTrace();
			return "failure";
		}
		
	}

	public String updateDPD() {
		
		String userID = String.valueOf(dpd.getUserID());
		System.out.println("<<<<<<<<<<<<<<<<<<<<<my userID  is : " + userID);
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement updateData = null;
			String updateString = "update employee "
					+ "set FirstName = ?,LastName = ?, Address = ?,"
					+ "Email = ? where UserID = ?";
			updateData = con.prepareStatement(updateString);
			updateData.setString(1, dpd.getFirstname());
			updateData.setString(2, dpd.getLastname());
			updateData.setString(3, dpd.getAddress());
			updateData.setString(4, dpd.getEmail());
			updateData.setLong(5, dpd.getUserID());

			updateData.executeUpdate();

			updateString = "update login "
					+ "set Status = ?,Password = ?, SecurityQuestion = ?, Answer = ?"
					+ " where UserID = ?";
			updateData = con.prepareStatement(updateString);
			updateData.setString(1, dpd.getStatus());
			updateData.setString(2, dpd.getPassword());
			updateData.setString(3, dpd.getSecurityQuestion());
			updateData.setString(4, dpd.getAnswer());
			updateData.setLong(5, dpd.getUserID());

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

	public Employee getModel() {
		return dpd;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
