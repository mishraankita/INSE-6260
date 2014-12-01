<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="new.jpg">   
	<h1 align="center">
		<font color="black">Welcome ${sessionScope.UserID} Home Page<</font>
	</h1>
	<table border="8" align="center">
	<tr><td>
	<form action="./enrollstudentOrDpd" method=POST>
		<input type="submit" name="submit" value="Enroll the student or dpd" />
	</form>
	</td></tr>
	<tr><td>
	<form action="./searchStudentOrDpdDetail" method=POST>
		<input type="submit" name="submit" value="View student/DPD Account " />
	</form>
	</td></tr>
	<tr><td>
	<form action="./manageStudentAccount" method=POST>
		<input type="submit" name="submit" value="Manage student Account" />
	</form>
	</td></tr>
	<tr><td>
	<form action="./manageDPDAccount" method=POST>
		<input type="submit" name="submit" value="Manage DPD Account" />
	</form>
	</td></tr>
	<tr><td>
	<form action="./setDateDetail" method=POST>
		<input type="submit" name="submit" value="Set deadline" />
	</form>
	</td></tr>
	<tr><td>
	<form action="./logout.jsp" method=POST>
		<pre>
			<input type="submit" name="submit" value=" Logout" />
		</pre>
	</form>
	</td></tr>
	</table>
</body>
</html>