<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form><br><%=(String)request.getAttribute("resultsMessage")%><br>
	</form>
	<jsp:declaration>Integer outcome;</jsp:declaration>
	<jsp:scriptlet>outcome = (Integer)request.getAttribute("paymentStatus");</jsp:scriptlet>
	<% if (outcome == 1) { %>
	<form action="./FeePaymentOutcomeServlet" method=POST>
		<br><input type="submit" name="Exit" value="Process">
	</form>
	<form action="./studentsuccess.jsp" method=POST>
		<br><input type="submit" name="Exit" value="Cancel">
	</form>
<% } else { %>
	<form action="./studentsuccess.jsp" method=POST>
		<input type="submit" name="Exit" value="Close">
	</form>
<% } %>
</body>
</html>