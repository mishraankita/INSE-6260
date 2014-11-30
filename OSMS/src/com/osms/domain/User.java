package com.osms.domain;

public class User {

	private int UserID;
	private String Password;
	private String SecurityPassword;
	private String Answer;
	private String AccountType;
	private int Status;
	private int LoginAttemptCount;
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSecurityPassword() {
		return SecurityPassword;
	}
	public void setSecurityPassword(String securityPassword) {
		SecurityPassword = securityPassword;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getLoginAttemptCount() {
		return LoginAttemptCount;
	}
	public void setLoginAttemptCount(int loginAttemptCount) {
		LoginAttemptCount = loginAttemptCount;
	}
	
	
}
