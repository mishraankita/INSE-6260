package com.osms.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Servlet implementation class CourseChangeStudentServlet
 */
public class CourseChangeStudentServlet extends ActionSupport implements ServletRequestAware,SessionAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	HttpServletRequest request;
	String result;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseChangeStudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String changeCourse() {
		String action = "Close";

		Enumeration<String> enumeration = getServletRequest().getParameterNames();
		while (enumeration.hasMoreElements()) {
			// there is only one object, the selected button
			action = enumeration.nextElement();
		}

		String message = "Operation Failed";
		String delimiter = "[$]";
		String[] tokens = action.split(delimiter);
		String query;

		if (tokens[0].equals("Close")) {
			// get out
		}

		if (tokens.length < 2) {
			// set message failed
			return "failure";
		}

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs;

			if (tokens[0].equals("Add")) {
				rs = stmt
						.executeQuery("select * from courseoffered where CourseID = "
								+ tokens[1]);
				if (rs.next()) {
					String sessionRegisteredIn = rs.getString("sessionOffered");
					String schedule = rs.getString("Schedule");
					query = "INSERT INTO coursetaken VALUES (" + tokens[2]
							+ "," + tokens[1] + "," + null + ",\""
							+ sessionRegisteredIn + "\",\"" + schedule + "\");";
					stmt.executeUpdate(query);
					result = "success";
					message = "The course was successfully added";
				}
			}
			if (tokens[0].equals("Drop")) {
				query = "DELETE FROM coursetaken WHERE UserID = " + tokens[2]
						+ " AND CourseID = " + tokens[1] + ";";
				stmt.executeUpdate(query);
				result = "success";
				message = "The course was successfully dropped";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "success";
			message = "An error ocurred during course registration.";
		}
		
		request.setAttribute("resultsMessage", message);
		return result;
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
}
