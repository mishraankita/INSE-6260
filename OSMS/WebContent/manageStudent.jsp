<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.sql.*" %>
<%@ page import="com.osms.controller.DBConnection" %>
<%@ page import="com.osms.model.*" %>
<% Class.forName("com.mysql.jdbc.Driver");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="welcome.jpg">
<H1>Fetching Data From a Database</H1>
<form action="./ManageStudentDetails" method=POST>
<h1 align="center"><font color="blue">Edit Student Information</font></h1>
<jsp:declaration>
String userID = "";
</jsp:declaration>
<jsp:scriptlet>
userID = (String)session.getAttribute("UserID");
</jsp:scriptlet>
  <% 
  Connection con = DBConnection.getConnection();
  Statement stmt = con.createStatement();
 String action = request.getParameter("action");
 if("manageStudent".equals(action)){
	 request.getSession().getAttribute("userID");
	 session.setAttribute("userID",userID);
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!! UserID inside the action = managestudent option is : " + userID);
  ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
 					+ userID + "'");	
	  while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The user ID is : " + rs.getInt(1) + "</td></tr></html>");
 	 }
  }
 
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The user Name is : " + rs.getString(2) + "</td></tr></html>");
	 }
 }
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "FirstName" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit First name" />
	</td>
	</tr>	
	</table>
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The user last Name is : " + rs.getString(3) + "</td></tr></html>");
	 }
 }
	
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "LastName" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit Last name" />
	</td>
	</tr>
	</table>	
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The Address is : " + rs.getString(4) + "</td></tr></html>");
	 }
 }
	
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "address" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit Address" />
	</td>
	</tr>
	</table>
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The Phone Number is : " + rs.getInt(5) + "</td></tr></html>");
	 }
 }
	
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "phoneNumber" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit PhoneNumber" />
	</td>
	</tr>
	</table>
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The Email is : " + rs.getString(6) + "</td></tr></html>");
	 }
 }
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "Email" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit Email" />
	</td>
	</tr>
	</table>
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The SessionJoined is : " + rs.getString(7) + "</td></tr></html>");
	 }
 }
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "SessionJoined" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit SessionJoined" />
	</td>
	</tr>
	</table>	
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The DepartmentID is : " + rs.getInt(8) + "</td></tr></html>");
	 }
 }
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "DepartmentID" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit DepartmentID" />
	</td>
	</tr>
	</table>
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The EnrollProgram is : " + rs.getString(9) + "</td></tr></html>");
	 }
 }
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "EnrollProgram" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit EnrollProgram" />
	</td>
	</tr>	
	</table>
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The DateOfbirth is : " + rs.getString(10) + "</td></tr></html>");
	 }
 }
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= DateOfbirth /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit DateOfbirth" />
	</td>
	</tr>
	</table>
	<%
	if("manageStudent".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from login where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The Status of account is : " + rs.getString(6) + "</td></tr></html>");
	 }
 	}
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "Status" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Edit Status" />
	</td>
	</tr>	
	</table>
	
</form>
 <h3 align="center"><a href="./adminsuccess.jsp">   Go to Home</a></h3>
</body>
</html>