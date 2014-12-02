<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget password page</title>
</head>
<body background="campus.jpg">
<script type="text/JavaScript">
	function validateForm()
{		   
   var x = document.forms["login"]["Password"].value;
   var y = document.forms["login"]["Password2"].value;
   if( x == y )
   {
     alert( "Confirm password and new password do not match" );
     return false;
   }
   return true;
}
	</script>
<form action="./resetPassword" method="post" onsubmit="return validateForm();">
	<h1 align="center"><font color="blue" size="6" >Security Question</font></h1>
<table border="8" align="center">
	<tr>
		<td >UserID</td>
		<td><s:property value="UserID"/></td>
	</tr>
	<tr>
		<td >New Password</td>
		<td ><input type="text" name="Password"> </td>
	</tr>
	<tr>
		<td >Confirm New Password</td>
		<td ><input type="text" name="Password2"> </td>
	</tr>
<tr>
		<td><input type="submit" name="button_1" value="SUBMIT"></td>
	</tr>
</table>	
</form>	
</body>
</html>