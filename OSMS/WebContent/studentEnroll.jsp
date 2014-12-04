<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
<script type="text/JavaScript">

	function validateForm()
{
 var a = document.forms["studentEnroll"]["userID"].value;
   if( a == null || a == "" )
   {
     alert( "Please provide your User ID!" );
     return false;
   }
   var b = document.forms["studentEnroll"]["firstname"].value;
   if( b == null || b == "" )
   {
     alert( "Please provide firstname!" );
     return false;
   }
   var c = document.forms["studentEnroll"]["lastname"].value;
   if( c == null || c == "" )
   {
     alert( "Please provide lastname " );
     return false;
   }
    var d = document.forms["studentEnroll"]["address"].value;
   if( d == null || d == "" )
   {
     alert( "Please provide address!" );
     return false;
   }
   var e = document.forms["studentEnroll"]["phoneNumber"].value;
   if( e == null || e == "" )
   {
     alert( "Please provide phoneNumber " );
     return false;
   }
     var f = document.forms["studentEnroll"]["email"].value;
   if( f == null || f == "" )
   {
     alert( "Please provide email " );
     return false;
   }
   
   var atpos = f.indexOf("@");
   var dotpos = f.lastIndexOf(".");
   if (atpos< 1 || dotpos<atpos+2 || dotpos+2>=x.length) {
       alert("Not a valid e-mail address");
       return false;
   }
   
    var g = document.forms["studentEnroll"]["sessionJoined"].value;
   if( g == null || g == "" )
   {
     alert( "Please provide sessionJoined !" );
     return false;
   }
   var h = document.forms["studentEnroll"]["departmentID"].value;
   if( h == null || h == "" )
   {
     alert( "Please provide departmentID " );
     return false;
   }
    var i = document.forms["studentEnroll"]["enrollProgram"].value;
   if( i == null || i == "" )
   {
     alert( "Please provide enrollProgram!" );
     return false;
   }
   var j = document.forms["studentEnroll"]["dob"].value;
   if( j == null || j == "" )
   {
     alert( "Please provide Date of Birth " );
     return false;
   }
    var k = document.forms["studentEnroll"]["password"].value;
   if( k == null || k == "" )
   {
     alert( "Please provide password " );
     return false;
   }
    var l = document.forms["studentEnroll"]["securityQuestion"].value;
   if( l == null || l == "" )
   {
     alert( "Please provide securityQuestion " );
     return false;
   }
    var m = document.forms["studentEnroll"]["answer"].value;
   if( m == null || m == "" )
   {
     alert( "Please provide answer " );
     return false;
   }
    var n = document.forms["studentEnroll"]["accountType"].value;
   if( n == null || n == "" )
   {
     alert( "Please provide accountType " );
     return false;
   }
    var o = document.forms["studentEnroll"]["status"].value;
   if( o == null || o == "" )
   {
     alert( "Please provide status " );
     return false;
   }
   return true;
}
	</script>

<form name ="studentEnroll" action="./enroll" method="post" onsubmit="return validateForm()">

<h1 align="center"><font color="blue">Student Information Form</font></h1>
<table align="center">      
	<tr>
		<th></th>
	</tr>
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
		<td>PhoneNumber :</td>
		<td><input type="text" name="phoneNumber"></input></td>
	</tr>
	<tr>
		<td>Email :</td>
		<td><input type="text" name="email"></input></td>
	</tr>
	<tr>
		<td>SessionJoined :</td>
		<td><input type="text" name="sessionJoined"></input></td>
	</tr>
	<tr>
		<td>DepartmentID :</td>
		<td><input type="text" name=departmentID></input></td>
	</tr>
	<tr>
		<td>EnrollProgram :</td>
		<td><input type="text" name=enrollProgram></input></td>
	</tr>
	<tr>
		<td>Date of Birth :</td>
		<td><input type="text" name="dob"></input></td>
	</tr>
	<tr>
		<td>Password :</td>
		<td><input type="password" name="password"></input></td>
	</tr>
	<tr>
		<td>securityQuestion :</td>
		<td><select name="securityQuestion">
		  <option value="What is your Pet Name ?">What is your Pet Name ?</option>
		  <option value="Who is your favourite Teacher ?">Who is your favourite Teacher ?</option>
		   <option value="What is your favourite Subject ?">What is your favourite Subject ?</option>
		</select></td>
	</tr>
	<tr>
		<td>answer :</td>
		<td><input type="text" name="answer"></input></td>
	</tr>
	<tr>
		<td>Account Type :</td>
		<td><input type="text" name="accountType" value="student" readonly="readonly" /></td>
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
	<input type="submit" value="SUBMIT"/ >
	</pre>
		
</form>

 <h3 align="center"><a href="./adminsuccess.jsp">   Go to Home</a></h3>
<jsp:include page="footer.jsp"/>
</body>
</html>