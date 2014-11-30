<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login succesfull</title>
</head>
<body bgcolor="#fffff">
<%String user = (String)session.getAttribute("userName");  %>
<h1 align="center">Student <%=user%> Login succesfull</h1>
<form action="./mydetails" align="center" method="post">
<input type="hidden" name="user" value"<%=user%>"/>
<input type="submit" value="Get MyDetails" />
</form>
<!--<p align="center"><a href="./StudentRegistration.html">Get My Details</a></p>
<p align="center"><a href="./StudentRegistration.html">Student Registration click here</a></p>-->
</body>
</html>