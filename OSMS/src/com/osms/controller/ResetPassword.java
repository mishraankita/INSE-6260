package com.osms.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.Student;
import com.osms.domain.User;

public class ResetPassword extends ActionSupport implements
		ModelDriven<User>, SessionAware, ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private SessionMap<String, Object> sessionMap;
	HttpServletResponse response;
	HttpServletRequest request;
	
	private User student = new User();

	public String updatePassword() {
		// String userID = request.getParameter("userID");
	//	String userID = String.valueOf(student.getUserID());
		//String userID = request.getParameter("userID");
		String userID = (String) sessionMap.get("UserID");
		System.out.println("<<<<<<<<<<<<<<<<<<<<<my userID  is : " + userID);

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement updateData = null;
			
			String updateString = "update login "
			+ "set Password = ?"
					+ " where UserID = ?";
			updateData = con.prepareStatement(updateString);
			updateData.setString(1, student.getPassword());
			
			updateData.setString(2, userID);

			int updateResult = updateData.executeUpdate();
			String result="failure";
			String message = "Password Not Updated";
			if(updateResult==1){
				message = "Record Successfully Updated !!";
				result =  "success";
			}
			
			request.setAttribute("resultsMessage", message);
			return result;
			
			
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

	public User getModel() {
		return student;
	}
}

