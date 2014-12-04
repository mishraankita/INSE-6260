<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg16.jpg">

	<jsp:include page="header.jsp" />
	<h1>
		<font color="black">Welcome ${sessionScope.UserID} (DPD) Department Program Director Home Page</font>
	</h1>
	<table border="8" align="center">
		<tr>
			<td>
				<form action="./searchStudentID.jsp" method=POST>
					<input type="submit" name="submit" value="View Student Account" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./RegistrationByDpd.jsp" method=POST>
					<input type="submit" name="submit"
						value="Register a student for course " />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./logout.jsp" method=POST>
					<pre>
						<input type="submit" name="submit" value=" Logout" />
					</pre>
				</form>
			</td>
		</tr>
		<tr>
	</table>
			<td><jsp:include page="footer.jsp" />
</body>
</html>