<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="new.jpg">
<h1 align="center"><font color="black">Welcome ${sessionScope.UserID} Home Page </font></h1>
<table border="8" align="center">  
</body>
<form action="./MyDetailsServlet" method=POST >
<input type="submit"  name="submit" value="Academic details" />
</form>
<form action="./CourseRegistrationServlet" method=POST >
 <input type="submit"  name="submit" value="Register for course " />
 </form>
 <form action="./PayFees" method=POST >
 <input type="submit"  name="submit" value="pay fee " />
 </form>
 <form action="./AccountSettingDetails" method=POST >
 <input type="submit"  name="submit" value="Account Settings details" />
 </form>
 <form action="./welcome.html" method=POST>
          <pre><input type="submit"  name="submit" value=" Logout"/></pre>
</form>
</html>