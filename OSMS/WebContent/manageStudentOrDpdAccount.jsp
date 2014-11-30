<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="welcome.jpg">
<form action="manageStudent.jsp" method=POST>
<h1 align="center"><font color="blue">Manage Student/DPD information</font></h1>
<table align="center">      
	<tr>
	<td>Enter the UserID of account you want to edit</td>
	<td><input type="text" name= "UserID" /></td>
	</tr>
	<tr>
	<td>
	<input type="submit" name= "action" value="manageStudent" onclick="form.action='manageStudent.jsp';">
	</td>
	<td>
	<input type="submit" name= "action" value="manageDPD" onclick="form.action='manageDpd.jsp';">
	</td>
	</tr>
</table>
</form>
<!--  <h3 align="center"><a href="./adminsuccess.jsp">   Go to Home</a></h3> -->
<!--   <h3 align="center"><a href="./manageStudent.jsp">Manage Student</a><br/></h3> -->
<!--  <h3 align=center><a href=./dpdManage.jsp>Manage DPD</a><br/></h3> -->
</body>
</html>