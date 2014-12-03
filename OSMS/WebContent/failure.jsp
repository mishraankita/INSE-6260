<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
	<font color="blue" size="20" >Login Failure</font>
	
	<form action="./welcome" method=POST>
      <input type="submit"  name="submit" value="Go to login page"/>
    </form>
	
<jsp:include page="footer.jsp"/>
	</body>
</html>