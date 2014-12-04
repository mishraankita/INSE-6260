<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body  background="bg16.jpg">
<jsp:include page="header.jsp"/>
<script type="text/JavaScript">
	function validateForm()
{		   
   var x = document.forms["login"]["UserID"].value;
   if( x == 0 || x == "" )
   {
     alert( "Please provide your User ID!" );
     return false;
   }if(isNaN(x)){
	   alert( "Please enter valid Numeric User ID!" );
	   return false;
   }
   var y = document.forms["login"]["Password"].value;
   if( y == null || y == "" )
   {
     alert( "Please provide password!" );
     return false;
   }
   var z = document.forms["login"]["AccountType"].value;
   if( z == null || z == "" )
   {
     alert( "Please provide Account Type" );
     return false;
   }
   return true;
}
	</script>
<form name ="login" action="./LogonServlet" method="post" onsubmit="return validateForm()">
	<h1 align="center"><font color="black" size="6" >Login Page</font></h1>
<table border="8" align="center">
	<tr>
		<td >USER ID</td>
		<td ><input type="text" name="UserID"> </td>
	</tr>
	<tr>
		<td>PASSWORD</td>
		<td><input type="password" name="Password"></td>
	</tr>
	<tr>
		<td>Account Type </td>
		<td><select name="AccountType">
		  <option value="admin" selected="selected">Admin</option>
		  <option value="student">Student</option>
		  <option value="dpd">DPD</option>
		</select></td>
	</tr>
	<tr>
		<td><input type="submit" name="button_1"  value="SUBMIT"></td>
	</tr>
	<tr>
		<td>
<!-- 			<input type="button" name= "action" value="Forget Password" onclick="form.action='./forgetpassword.jsp';"> -->
			<input type="button" onclick="location.href('forgetpassword.jsp');" value="Forget Password" >
		</td>
	</tr>
</table>
</form>
<jsp:include page="footer.jsp"/>
</body>

</html>