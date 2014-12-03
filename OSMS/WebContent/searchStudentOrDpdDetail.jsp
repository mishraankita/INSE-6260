<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
<form action="./searchDetails" method=POST>
<h1 align="center"><font color="blue">View Student/DPD information</font></h1>
<table align="center">      
	<tr>
		<th></th>
	</tr>
	<tr>
		<td>Enter the type of account you want to check</td>
		<td><select name="accountType">
		  <option value="student" selected="selected">Student</option>
		  <option value="dpd">DPD</option>
		</select></td>
	</tr>
	<tr>
		<td>Enter the UserID</td>
		<td><input type="text" name="userID"></input></td>
	</tr>
</table>
	<pre >
	<input type="submit" value="SUBMIT"/ >
	</pre>
		
</form>
 <h3 align="center"><a href="./adminsuccess.jsp">   Go to Home</a></h3>
 <jsp:include page="footer.jsp"/>
</body>
</html>