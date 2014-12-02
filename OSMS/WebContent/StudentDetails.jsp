<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<body background=welcome.jpg>
	<br><h1 align=center ><font color=blue>Student Details</font></h1>
	<table border =1 align=center >
		<tr>
			<th>User ID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Address</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Session Joined</th>
			<th>Department ID</th>
			<th>Enrolled in program</th>
			<th>Date of birth</th>
		</tr>
		<tr>
			<td><s:property value="userID"/></td>
			<td><s:property value="firstname"/> </td>
			<td><s:property value="lastname"/></td>
			<td><s:property value="address"/></td>
			<td><s:property value="phoneNumber"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="sessionJoined"/></td>
			<td><s:property value="departmentID"/></td>
			<td><s:property value="enrollProgram"/></td>
			<td><s:property value="dob"/></td>
		</tr>
	</table>

	<br><h1 align=center ><font color=blue>Student Academic Details</font></h1>
	<table border =1 align=center >
		<tr><th>Course ID</th><th>Grades Obtained</th></tr>
		<tr><td><s:property value="CourseID"/></td><td><s:property value="GradesObtained"/></td></tr>
	</table>
	
	<br><h1 align=center ><font color=blue>Student fee payment</font></h1>
	<s:if test="%{feesPaid==true}">
		<table border =1 align=center >
			<tr><th>Payment Date</th><th>Payment Amount Obtained</th><th>Fee Payment deadline</th></tr>
			<tr><td><s:property value="PaymentDate"/></td><td><s:property value="PaymentAmount"/></td><td><s:property value="PaymentFeeDeadLine"/></td></tr>
		</table>
	</s:if>
	<s:else>
   		<h1 align=center ><font color=red>Please pay your fees by <s:property value="PaymentFeeDeadLine"/></font></h1>
	</s:else>
				
	<br><h1 align=center ><font color=blue>Student Account Status</font></h1>
	<table border =1 align=center >
		<tr><th>Account Status</th></tr>
		<tr><td><s:property value="status"/></td></tr>
	</table>
	
	<h2 align=center><a href=./studentsuccess.jsp> Go to Home</a></h2>
				
				
	
				
</body>
</html>