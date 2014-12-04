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
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
	<script type="text/JavaScript">
	function validateForm()
{		   
   var x = document.forms["deadline1"]["Manage Fee Payment Deadline"].value;
   var y = document.forms["deadline2"]["Manage course Add/Drop Deadline"].value;
   if( x == null && y == null)
   {
     alert( "Please provide deadline" );
     return false;
   }
   
//    var y = document.forms["deadline2"]["Manage course Add/Drop Deadline"].value;
//    if( y == null || y == "" )
//    {
//      alert( "Please provide course Add/Drop deadline" );
//      return false;
//    }
   return true;
}
	</script>
	<form name = "deadline1" action="./SetDates" method=POST onsubmit="return validateForm()">
		<h1 align="center">
			<font color="blue">Edit Deadline Information</font>
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
				<td>Edit :(in dd/mm/yyyy format)</td>
				<td><input type="text" name="Manage Fee Payment Deadline" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="action"
					value="Manage Fee Payment Deadline" /></td>
			</tr>
		</table>
		</form>
		<form  name = "deadline2" action="./SetAddDropDeadLine" method=POST onsubmit="return validateForm()">
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
				<td>Edit :(in dd/mm/yyyy format)</td>
				<td><input type="text" name="Manage course Add/Drop Deadline" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="action"
					value="Manage course Add/Drop Deadline" /></td>
			</tr>
		</table>
	</form>
	<h3 align="center">
		<a href="./adminsuccess.jsp"> <font color="black">Go to Home</font></a>
	</h3>
	 <jsp:include page="footer.jsp"/>
</body>
</html>