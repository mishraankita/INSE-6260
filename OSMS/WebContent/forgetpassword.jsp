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
 var a = document.forms["forgetpassword"]["UserID"].value;
   if( a == null || a == "" )
   {
     alert( "Please provide your User ID!" );
     return false;
   }
   var b = document.forms["forgetpassword"]["Answer"].value;
   if( b == null || b == "" )
   {
     alert( "Please provide Answer!" );
     return false;
   }
   return true;
}
</script>
<form name = "forgetpassword" action="./RecoverPassword" method="post" onsubmit="return validateForm()">
	<h1 align="center"><font color="blue" size="6" >Please Answer Security Question</font></h1>
<table border="8" align="center">
	<tr>
		<td >USER ID</td>
		<td ><input type="text" name="UserID"> </td>
	</tr>
	<tr>
		<td >Security Question</td>
		<td><select name="securityQuestion">
		  <option value="What is your Pet Name ?">What is your Pet Name ?</option>
		  <option value="Who is your favourite Teacher ?">Who is your favourite Teacher ?</option>
		   <option value="What is your favourite Subject ?">What is your favourite Subject ?</option>
		</select></td>
	</tr>
	<tr>
		<td>Answer</td>
		<td><input type="text" name="Answer"></td>
	</tr>
<tr>
		<td><input type="submit" name="button_1" value="SUBMIT"></td>
	</tr>
</table>	
</form>	
<jsp:include page="footer.jsp"/>
</body>
</html>