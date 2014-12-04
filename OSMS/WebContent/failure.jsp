<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
<table align = "center">
	<tr>
		<td><font color="red" , align="center" size="7">Login
				Failure</font></td>
	</tr>
</table>
<table align = "center">
	<form action="./welcome" method=POST>
		<tr>
			<td><input type="submit" name="submit" value="Go to login page" /></td>
		</tr>
	</form>
	</table>
	<jsp:include page="footer.jsp"/>
	</body>
</html>