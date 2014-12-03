<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login page</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
<script type="text/JavaScript">
</script>
<form action="./SearchStudentDetails" method="post">
	<h1 align="center"><font color="blue" size="6" >Login Page</font></h1>
<table border="8" align="center">
	<tr>
		<td >USER ID</td>
		<td ><input type="text" name="UserID"> </td>
	</tr>
	<tr>
	<td><input type="submit" name="button_1"  value="SUBMIT"></td>
	</tr>
	<tr>
</table>
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>