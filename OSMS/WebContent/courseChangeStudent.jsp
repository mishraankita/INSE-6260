<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="new.jpg">
<form action="./studentsuccess.jsp" method=POST>
		<input value = "Registration Output" name = "resultsMessage">
</form>
<form>
<a href="./studentsuccess.jsp">Close</a>
	<br><%=(String)request.getAttribute("resultsMessage")%><br>
</form>
<form action="./CourseRegistrationServlet" method=POST >
 <input type="submit"  name="submit" value="Return" />
 </form>
</body>
</html>