<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="new.jpg">
<form><br><%=(String)request.getAttribute("resultsMessage")%><br>
	</form>
	<jsp:declaration>Integer outcome;</jsp:declaration>
	<jsp:scriptlet>outcome = (Integer)request.getAttribute("paymentStatus");</jsp:scriptlet>
	<% if (outcome == 1) { %>
	<form action="./FeePaymentOutcomeServlet" method=POST>
		
		Enter credit card number (xxxx xxxx xxxx xxxx) 
			<input name="creditcardnumber" style="width: 150px" maxlength="19"><br>
			Enter expiry month and year (mmyy) 
			<input name = "expirymonthyear" style="width: 40px;" maxlength="4"><br>
			Enter the cardholder's name as it appears on the credit card
			<input name = "cardholdername" style="width: 220px; "><br><br>
			<input type="submit" name="Exit" value="Pay">
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