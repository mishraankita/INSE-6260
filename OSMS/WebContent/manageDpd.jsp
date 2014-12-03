
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
<body background="new.jpg">
<H1>Fetching Data From a Database</H1>
<form action="./ManageStudentDetails" method=POST>
<h1 align="center"><font color="blue">Edit Student Information</font></h1>
<jsp:declaration>
String userID = "";
</jsp:declaration>
<jsp:scriptlet>
userID = request.getParameter("UserID");
</jsp:scriptlet>
  <% 
  Connection con = DBConnection.getConnection();
  Statement stmt = con.createStatement();
 String action = request.getParameter("action");
 if("manageDPD".equals(action)){
	 request.getSession().getAttribute("userID");
	 session.setAttribute("userID",userID);
	 System.out.println("!!!!!!!!!!!!!!!!!UserID inside the action = managestudent option is : " + userID);
  ResultSet rs = stmt.executeQuery("select * from studentdetails where userID='"
 					+ userID + "'");	
	  while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The user ID is : " + rs.getInt(1) + "</td></tr></html>");
 	 }
  }
	if("manageDPD".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from employee where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The First Name is : " + rs.getString(2) + "</td></tr></html>");
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
	<input type="submit" name= "action" value="Edit First Name" />
	</td>
	</tr>	
	</table>
	
		<%
	if("manageDPD".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from employee where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The Last Name is : " + rs.getString(3) + "</td></tr></html>");
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
	<input type="submit" name= "action" value="Edit Last Name" />
	</td>
	</tr>	
	</table>
	
		<%
	if("manageDPD".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from employee where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The address is : " + rs.getString(4) + "</td></tr></html>");
	 }
 	}
	%>
	<table align=center><tr><td>
	<tr>
	<td> Edit : </td>
	<td><input type="text" name= "Address" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="Address" />
	</td>
	</tr>	
	</table>
	
	<%
	if("manageDPD".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from employee where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The Email is : " + rs.getString(5) + "</td></tr></html>");
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
	<input type="submit" name= "action" value="Email" />
	</td>
	</tr>	
	</table>
	
	<%
	if("manageDPD".equals(action)){
	ResultSet rs = stmt.executeQuery("select * from login where userID='"
				+ userID + "'");	
	while(rs.next()){
	 	out.println("<html><table align=center><tr><td> The Status is : " + rs.getString(6) + "</td></tr></html>");
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
	<input type="submit" name= "action" value="Status" />
	</td>
	</tr>	
	</table>
	
</form>
 <h3 align="center"><a href="./adminsuccess.jsp"> <font color="white" > Go to Home </font></a></h3>
</body>
</html>