<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>

<script type="text/JavaScript">
	function validateForm()
{		   
   var x = document.forms["register"]["userID"].value;
   if( x == null || x == "" )
   {
     alert( "Please provide User ID!" );
     return false;
   }
   return true;
}
	</script>
<form name ="register" action="./RegisterByDPD" method=POST onsubmit="return validateForm()">
<h1><font color="black" >Welcome To Course Registration </font></h1>
<table align="center">
<tr>
		<td align="center">
			<font color="red"><%=request.getAttribute("resultsMessage")!=null ? request.getAttribute("resultsMessage") : ""%></font>
		</td>
</tr>
<tr>
		<td>User ID :</td>
		<td><input type="text" name="userID"></td>
</tr>
<tr>
	<td><input type="submit" name="button_1"  value="enter to register"></td>
	</tr>
</table>
</form>
</body>
<!-- <form action="./welcome.html" method=POST> -->
<!--           <pre><input type="submit"  name="submit" value=" Logout"/></pre> -->
<!-- </form> -->
	<jsp:include page="footer.jsp"/>
	</body>
</html>