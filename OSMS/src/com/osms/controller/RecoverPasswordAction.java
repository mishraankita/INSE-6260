package com.osms.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.User;

public class RecoverPasswordAction extends ActionSupport implements ModelDriven<User>,
SessionAware {
	private static final long serialVersionUID = 1L;
	User user = new User();
	private SessionMap<String, Object> sessionMap;
	
	public String recoverPassword() {
		String userID = (String) sessionMap.get("UserID");
		String answer =  user.getAnswer();

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select Answer,Status from login where UserID='"
							+ userID + "'");// and password='"+passWord+"'");
			if (rs.next()) {
				// String dbuserID = rs.getString("UserID");
				// to chk if the userID exists.
				String dbAnswer = rs.getString("Answer");
				int status = rs.getInt("Status");
	
				if (userID == null || answer == null || userID == "") {
					return "failure";
				}
				if (answer.equalsIgnoreCase(dbAnswer) && status==1) {
					// TODO save the password to the INBOX AND OPEN THE
					// ACCOUNT
					return "studentsuccess";
				} else if(status==0){
					return "accountLocked";
				}else{
					return "failure";
				}
			}
			 con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}
	
	public User getModel() {
		return user;
	}

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}

}
