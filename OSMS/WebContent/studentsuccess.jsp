<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg16.jpg">
	<jsp:include page="header.jsp" />
	<h1 align="center">
		<font color="black">Welcome ${sessionScope.UserID} Student Home Page </font>
	</h1>
	<table border="8" align="center">
		<tr>
			<td>
				<form action="./MyDetailsServlet" method=POST>
					<input type="submit" name="submit" value="Academic details" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./CourseRegistrationServlet" method=POST>
					<input type="submit" name="submit" value="Register for course " />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./FeePaymentServlet" method=POST>
					<input type="submit" name="submit" value="Pay Fees" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./searchMyDetails" method=POST>

					<input type="submit" name="submit" value="Account Settings details" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./logout.jsp" method=POST>
					<pre>
				<input type="submit" name="submit" value=" Logout" />
			</pre>
			</table>

				</form> <jsp:include page="footer.jsp" />
</body>
</html>