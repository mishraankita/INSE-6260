<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.sql.*" %>
<%@ page import="com.servlet.DBConnection" %>
<%@ page import="com.student.*" %>
<% Class.forName("com.mysql.jdbc.Driver");%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="welcome.jpg">
<H1>Fetching Data From a Database</H1>
<form action="./ManageStudentDetails" method=POST>
<h1 align="center"><font color="blue">Edit Personal Information</font></h1>
<jsp:declaration>
//String userID = "";
</jsp:declaration>
<jsp:scriptlet>
//userID = request.getParameter("userID");
</jsp:scriptlet>
  <% 
  Connection con = DBConnection.getConnection();
  Statement stmt = con.createStatement();
 String action = request.getParameter("action");
	 //String userID = request.getSession().getAttribute("userID");
	 String userID = (String) session.getAttribute("userID");	
	 //session.setAttribute("userID",userID);
	 System.out.println("!!!!!!!!!!!!!!!!!!!!!!! UserID inside the action " + userID);
	 
  ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
 					+ userID + "'");	
	  while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The user ID is : " + rs.getInt(1) + "</td></tr></html>");
 	 }
 
	ResultSet rs1 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs1.next()){
	 	out.println("<html><table align=center><tr><td> The user Name is : " + rs1.getString(2) + "</td></tr></html>");
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
	ResultSet rs2 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs2.next()){
	 	out.println("<html><table align=center><tr><td> The user last Name is : " + rs2.getString(3) + "</td></tr></html>");
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
	ResultSet rs3 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs3.next()){
	 	out.println("<html><table align=center><tr><td> The Address is : " + rs3.getString(4) + "</td></tr></html>");
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
	ResultSet rs4 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs4.next()){
	 	out.println("<html><table align=center><tr><td> The Phone Number is : " + rs4.getInt(5) + "</td></tr></html>");
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
	ResultSet rs5 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs5.next()){
	 	out.println("<html><table align=center><tr><td> The Email is : " + rs5.getString(6) + "</td></tr></html>");
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
	ResultSet rs6 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs6.next()){
	 	out.println("<html><table align=center><tr><td> The SessionJoined is : " + rs6.getString(7) + "</td></tr></html>");
	 }
	
	ResultSet rs7 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs7.next()){
	 	out.println("<html><table align=center><tr><td> The DepartmentID is : " + rs7.getInt(8) + "</td></tr></html>");
	 }
	
	ResultSet rs8 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs8.next()){
	 	out.println("<html><table align=center><tr><td> The EnrollProgram is : " + rs8.getString(9) + "</td></tr></html>");
	 }
	
	ResultSet rs9 = stmt.executeQuery("select * from studentdetails where userID='"
				+ userID + "'");	
	while(rs9.next()){
	 	out.println("<html><table align=center><tr><td> The DateOfbirth is : " + rs9.getString(10) + "</td></tr></html>");
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
	ResultSet rs10 = stmt.executeQuery("select * from login where userID='"
				+ userID + "'");	
	while(rs10.next()){
	 	out.println("<html><table align=center><tr><td> The Status of account is : " + rs10.getString(6) + "</td></tr></html>");
	 }
	%>
	
</form>
 <h3 align="center"><a href="./studentsuccess.jsp">   Go to Home</a></h3>
</body>
</html>