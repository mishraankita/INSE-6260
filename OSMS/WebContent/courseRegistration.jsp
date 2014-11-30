<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Registration</title>
</head>
<body>
<form action="./CourseRegistrationServlet" method=POST>
<input type="Submit" value="Return">
<%=session.getAttribute("StudentName")%>
		<table border="1" align="center" width="100" height="80">
			<tr>
				<td>StudentName</td>
				<td><input name=StudentName></td>
			</tr>
			<tr>
				<td><input name=Action type="submit" value="Add"></td>
				<td><input name=CourseName></td>
				<td><input name=Schedule></td>
			</tr>
			<tr>
				<td><input name=Action type="submit" value="Drop"></td>
				<td><input name=CourseName></td>
				<td><input name=Schedule></td>
			</tr>
			<tr>
				<td><input name=Action type="submit" value="Conflict" disabled></td>
				<td><input name=CourseName></td>
				<td><input name=Schedule></td>
			</tr>
		</table>
	</form>
</body>
</html>