package com.osms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import com.osms.domain.User;


public class SetAddDropDeadLine extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	HttpServletResponse response;
	HttpServletRequest request;

	public void SetDeadLine() {
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement updateData = null;
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

				 PrintWriter out = getServletResponse().getWriter();
				out.println(" <h2 align=center><a href=./student.jsp>Register a new Student</a><br/></h2>");
				out.println(" <h2 align=center><a href=./adminsuccess.jsp> Go to Home</a></h2>");
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
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public HttpServletResponse getServletResponse() {
		return this.response;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
