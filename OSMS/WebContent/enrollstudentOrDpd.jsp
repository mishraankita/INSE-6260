<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
	<h1 align="center">
		<font color="black">View Student/DPD information</font>
	</h1>
	<table border="8" align="center">
		<tr>
			<td>
				<form action="./studentEnroll" method=POST>
					<input type="submit" name="submit" value="Register a new Student" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./dpdEnroll" method=POST>
					<input type="submit" name="submit" value="Register a new DPD" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="./adminsuccess.jsp" method=POST>
					<input type="submit" name="submit" value="Go to Home" />
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
	</table>
	<jsp:include page="footer.jsp"/>
</body>
</html>