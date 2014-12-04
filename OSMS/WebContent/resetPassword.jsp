<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forget password page</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
<script type="text/JavaScript">
	function validateForm()
{		   
   var x = document.forms["resetPassword"]["Password"].value;
   var y = document.forms["resetPassword"]["Password2"].value;
   if(x == null || x == ""){
	   alert( "Please provide password" );
	     return false;
   }
   if(y == null || y == ""){
	   alert( "Please provide confirm password" );
	     return false;
   }
   if( x != y )
   {
     alert( "Confirm password and new password do not match" );
     return false;
   }
   return true;
}
	</script>
<form name ="resetPassword" action="./resetPassword" method="post" onsubmit="return validateForm()">
	<h1 align="center"><font color="blue" size="6" >Security Question</font></h1>
<table border="8" align="center">
	<tr>
		<td >UserID</td>
		<td><s:property value="UserID"/></td>
	</tr>
	<tr>
		<td >New Password</td>
		<td ><input type="password" name="Password"> </td>
	</tr>
	<tr>
		<td >Confirm New Password</td>
		<td ><input type="password" name="Password2"> </td>
	</tr>
<tr>
		<td><input type="submit" name="button_1" value="SUBMIT"></td>
	</tr>
</table>	
</form>	
<jsp:include page="footer.jsp"/>
</body>
</html>