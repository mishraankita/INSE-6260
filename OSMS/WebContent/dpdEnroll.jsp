<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DPD registration</title>
</head>
<body background="new.jpg">
<form action="./enroll" method=POST>
<h1 align="center"><font color="black">DPD Information Form</font></h1>
<table align="center">      
	<tr>
		<td>User ID :</td>
		<td><input type="text" name=userID></input></td>
	</tr>
	<tr>
		<td>First Name :</td>
		<td><input type="text" name="firstname"></input></td>
	</tr>
	<tr>
		<td>Last Name :</td>
		<td><input type="text" name="lastname"></input></td>
	</tr>
	<tr>
		<td>Address :</td>
		<td><input type="text" name="address"></input></td>
	</tr>
	<tr>
		<td>Email :</td>
		<td><input type="text" name="email"></input></td>
	</tr>
	<tr>
		<td>Password :</td>
		<td><input type="text" name="password"></input></td>
	</tr>
	<tr>
		<td>securityQuestion :</td>
		<td><input type="text" name="securityQuestion"></input></td>
	</tr>
	<tr>
		<td>answer :</td>
		<td><input type="text" name="answer"></input></td>
	</tr>
	<tr>
		<td>Account Type :</td>
		<td><input type="text" name="accountType" value="dpd" readonly="readonly" /></td>
	</tr>
	<tr>
		<td>Status</td>
		<td><select name="status">
		  <option value="1" selected="selected">Active</option>
		  <option value="0">Inactive</option>
		</select></td>
	</tr>
</table>
</form>
	<pre><input type="submit" name="button_1"  value="SUBMIT"></pre>
 <h3 align="center"><a href="./adminsuccess.jsp">   Go to Home</a></h3>
</body>
</html>