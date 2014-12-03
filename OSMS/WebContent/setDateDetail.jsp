<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.osms.controller.DBConnection"%>
<%@ page import="com.osms.model.*"%>
<%
	Class.forName("com.mysql.jdbc.Driver");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="new.jpg">
	<H1>Fetching Data From a Database</H1>
	<form action="./SetDates" method=POST>
		<h1 align="center">
			<font color="blue">Edit Student Information</font>
		</h1>
		<%
			Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			String action = request.getParameter("action");

			int userID = 0;
			ResultSet rs = stmt
					.executeQuery("select PaymentFeeDeadLine from feepayment where UserID='"
							+ userID + "'");
			if (rs.next()) {
				out.println("<html><table align=center><tr><td> The payment fee deadline is : "
						+ rs.getString(1) + "</td></tr></html>");
				rs.close();
			}
		%>
		<table align=center>
			<tr>
				<td>
			<tr>
				<td>Edit :</td>
				<td><input type="text" name="Manage Fee Payment Deadline" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="action"
					value="Manage Fee Payment Deadline" /></td>
			</tr>
		</table>
		</form>
		<form action="./SetAddDropDeadLine" method=POST>
		<%
			int courseID = 0;
			ResultSet rs1 = stmt
					.executeQuery("select AddDropDeadline from courseoffered where CourseID='"
							+ courseID + "'");
			if (rs1.next()) {
				out.println("<html><table align=center><tr><td> The Add Drop Deadline is : "
						+ rs1.getString(1) + "</td></tr></html>");
				rs1.close();
			}
		%>
		<table align=center>
			<tr>
				<td>
			<tr>
				<td>Edit :</td>
				<td><input type="text" name="Manage course Add/Drop Deadline" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="action"
					value="Manage course Add/Drop Deadline" /></td>
			</tr>
		</table>
	</form>
	<h3 align="center">
		<a href="./adminsuccess.jsp"> <font color="white">Go to Home</font></a>
	</h3>
</body>
</html>