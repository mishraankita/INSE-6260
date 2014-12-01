package com.osms.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.osms.domain.User;

public class LoginAction extends ActionSupport implements ModelDriven<User>,
		SessionAware {

	private static final long serialVersionUID = 1L;
	User user = new User();
	private SessionMap<String, Object> sessionMap;

	public User getModel() {
		return user;
	}

	public String login() {
		String UserID = String.valueOf(user.getUserID());
		String passWord = user.getPassword();
		String AccountType = user.getAccountType();
		String dbUserID = null;
		String dbPassWord = null;
		String dbAccountType = null;
		Integer dbLoginAttemptCount = 0;

		try {
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select UserID,password,AccountType,LoginAttemptCount from login where UserID='"
							+ UserID + "'");// and password='"+passWord+"'");
			if (rs.next()) {
				dbUserID = rs.getString("UserID");
				dbLoginAttemptCount = rs.getInt("LoginAttemptCount");

				// to chk if the userID exists.
				if (dbUserID == null) {
					return "failure";
				}
				if (dbLoginAttemptCount >= 3) {
					return "accountLocked";
				}
				dbPassWord = rs.getString("password");
				dbAccountType = rs.getString("AccountType");
				
				if (UserID != null && UserID != "") {
					if (UserID.equalsIgnoreCase(dbUserID)
							&& passWord.equals(dbPassWord)
							&& AccountType.equalsIgnoreCase(dbAccountType)) {
						updateLoginAttemptCount(0, dbUserID);
						sessionMap.put("UserID", String.valueOf(user.getUserID()));
						sessionMap.put("accountType", String.valueOf(user.getAccountType()));
						if (AccountType.equals("student")) {
							return "studentsuccess";
						} else if (AccountType.equals("admin")) {
							return "adminsuccess";
						} else if (AccountType.equals("dpd")) {
							return "dpdsuccess";
						}
					} else {
						updateLoginAttemptCount(++dbLoginAttemptCount, dbUserID);
						if (dbLoginAttemptCount == 3) {
							return "accountLocked";
						} else {
							return "failure";
						}
					}
				}
			} else {
				return "failure";
			}
			con.close();
			return "failure";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failure";
	}

	private void updateLoginAttemptCount(int count, String userID) {
		String updateLoginAttemptCountString = "update login "
				+ "set LoginAttemptCount = ? where UserID = ?";
		String updateStatusString = "update login "
				+ "set Status = ? where UserID = ?";
		int status = 1;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement updateData = null;

			updateData = con.prepareStatement(updateLoginAttemptCountString);
			updateData.setInt(1, count);
			updateData.setInt(2, Integer.parseInt(userID));
			updateData.executeUpdate();

			updateData = con.prepareStatement(updateStatusString);
			if (count >= 3) {
				status = 0;
			}
			updateData.setInt(1, status);
			updateData.setInt(2, Integer.parseInt(userID));
			updateData.executeUpdate();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap) map;
	}
}
