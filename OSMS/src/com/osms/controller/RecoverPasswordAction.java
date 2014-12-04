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
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.User;

public class RecoverPasswordAction extends ActionSupport implements ModelDriven<User>, SessionAware,ServletRequestAware,ServletResponseAware {
	
	private static final long serialVersionUID = 1L;
	User user = new User();
	private SessionMap<String, Object> sessionMap;
	HttpServletResponse response;
	HttpServletRequest request;
	
	public String recoverPassword() {
//		String userID = (String) sessionMap.get("UserID");
//		String answer = (String) sessionMap.get("Answer");
		String userID = request.getParameter("UserID");
		String answer = request.getParameter("Answer");
		String sQuestion = request.getParameter("securityQuestion");
		//String answer =  user.getAnswer();
		System.out.println("userID isxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx : " +userID);
		System.out.println("answer isxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx : " +answer);
		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select SecurityQuestion,Answer,Status from login where UserID='"
							+ userID + "'");// and password='"+passWord+"'");
			if (rs.next()) {
				// String dbuserID = rs.getString("UserID");
				// to chk if the userID exists.
				
				String dbAnswer = rs.getString("Answer");
				int status = rs.getInt("Status");
				String dbSecurityQuestion = rs.getString("SecurityQuestion");
	
				if (userID == null || answer == null || userID == "") {
					return "failure";
				}
				System.out.println("dbAnswer is >>>>>>>> " +dbAnswer);
				System.out.println("answer is <<<<<<<< " +answer);
				if (answer.equals(dbAnswer) && status==1 && sQuestion.equals(dbSecurityQuestion)) {
					// TODO save the password to the INBOX AND OPEN THE
					// ACCOUNT
					sessionMap.put("UserID", String.valueOf(user.getUserID()));
					sessionMap.put("accountType", String.valueOf(user.getAccountType()));
					return "studentsuccessreset";
				} else if(status==0){
					return "accountLocked";
				}
				else{
					return "forgetPasswordFailure";
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

}
