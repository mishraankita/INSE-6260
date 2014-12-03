<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DPD registration</title>
</head>
<body background="new.jpg">
<script type="text/JavaScript">

	function validateForm()
{
 var a = document.forms["dpdEnroll"]["userID"].value;
   if( a == null || a == "" )
   {
     alert( "Please provide your User ID!" );
     return false;
   }
   var b = document.forms["dpdEnroll"]["firstname"].value;
   if( b == null || b == "" )
   {
     alert( "Please provide firstname!" );
     return false;
   }
   var c = document.forms["dpdEnroll"]["lastname"].value;
   if( c == null || c == "" )
   {
     alert( "Please provide lastname " );
     return false;
   }
    var d = document.forms["dpdEnroll"]["address"].value;
   if( d == null || d == "" )
   {
     alert( "Please provide address!" );
     return false;
   }
   var f = document.forms["dpdEnroll"]["email"].value;
   if( f == null || f == "" )
   {
     alert( "Please provide email " );
     return false;
   }
   var j = document.forms["dpdEnroll"]["password"].value;
   if( j == null || j == "" )
   {
     alert( "Please provide password " );
     return false;
   }
    var j = document.forms["dpdEnroll"]["securityQuestion"].value;
   if( j == null || j == "" )
   {
     alert( "Please provide securityQuestion " );
     return false;
   }
    var j = document.forms["dpdEnroll"]["answer"].value;
   if( j == null || j == "" )
   {
     alert( "Please provide answer " );
     return false;
   }
    var j = document.forms["dpdEnroll"]["accountType"].value;
   if( j == null || j == "" )
   {
     alert( "Please provide accountType " );
     return false;
   }
    var j = document.forms["dpdEnroll"]["status"].value;
   if( j == null || j == "" )
   {
     alert( "Please provide status " );
     return false;
   }
   return true;
}
	</script>
<form name ="dpdEnroll" action="./updateDPD" method=POST onsubmit="return validateForm()">
<h1 align="center"><font color="black">DPD Information Form</font></h1>
<table align="center">      
	<tr>
		<td><s:textfield name="userID" label="User ID" value="%{userID}" readonly="true"/></td>
	</tr>
	<tr>
		<td><s:textfield name="firstname" label="FirstName" value="%{firstname}"/></td>
	</tr>
	<tr>
		<td><s:textfield name="lastname" label="Last Name:" value="%{lastname}"/></td>
	</tr>
	<tr>
		<td><s:textfield name="address" label="Address:" value="%{address}"/></td>
	</tr>
	<tr>
		<td><s:textfield name="email" label="Email :" value="%{email}"/></td>
	</tr>
	<tr>
		<td><s:textfield name="password" label="Password :" value="%{password}"/></td>
	</tr>
	<tr>
		<td><s:textfield name="securityQuestion" label="securityQuestion :" value="%{securityQuestion}"/></td>
	</tr>
	<tr>
		<td><s:textfield name="answer" label="answer :" value="%{answer}"/></td>
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
<pre >
	<input type="submit" value="Update" />
	</pre>
</form>
 <h3 align="center"><a href="./adminsuccess.jsp"> <font color="white" > Go to Home </font></a></h3>
</body>
</html>