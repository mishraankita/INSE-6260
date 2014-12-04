package com.osms.domain;

import java.util.List;
import java.util.Map;

public class Student {
	private int userID , phoneNumber , departmentID, CourseID, PaymentAmount, creditsCompleted;
	private String  firstname, lastname, address, email, sessionJoined, status,
			enrollProgram, dob,GradesObtained, sessionRegisterIn,schedule, PaymentDate,PaymentFeeDeadLine,password,securityQuestion,answer;
	private Boolean feesPaid;
	private Map<Integer,List> coursesMap;
	float gpa;
	
	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSessionJoined() {
		return sessionJoined;
	}
	public void setSessionJoined(String sessionJoined) {
		this.sessionJoined = sessionJoined;
	}
	public String getEnrollProgram() {
		return enrollProgram;
	}
	public void setEnrollProgram(String enrollProgram) {
		this.enrollProgram = enrollProgram;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getCourseID() {
		return CourseID;
	}

	public void setCourseID(int courseID) {
		CourseID = courseID;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getSessionRegisterIn() {
		return sessionRegisterIn;
	}

	public void setSessionRegisterIn(String sessionRegisterIn) {
		this.sessionRegisterIn = sessionRegisterIn;
	}

	public String getGradesObtained() {
		return GradesObtained;
	}

	public void setGradesObtained(String gradesObtained) {
		GradesObtained = gradesObtained;
	}

	public Boolean getFeesPaid() {
		return feesPaid;
	}

	public void setFeesPaid(Boolean feesPaid) {
		this.feesPaid = feesPaid;
	}

	public String getPaymentFeeDeadLine() {
		return PaymentFeeDeadLine;
	}

	public void setPaymentFeeDeadLine(String paymentFeeDeadLine) {
		PaymentFeeDeadLine = paymentFeeDeadLine;
	}

	public String getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		PaymentDate = paymentDate;
	}

	public int getPaymentAmount() {
		return PaymentAmount;
	}

	public void setPaymentAmount(int paymentAmount) {
		PaymentAmount = paymentAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<Integer,List> getCoursesMap() {
		return coursesMap;
	}

	public void setCoursesMap(Map<Integer,List> coursesMap) {
		this.coursesMap = coursesMap;
	}

	public int getCreditsCompleted() {
		return creditsCompleted;
	}

	public void setCreditsCompleted(int creditsCompleted) {
		this.creditsCompleted = creditsCompleted;
	}
}
