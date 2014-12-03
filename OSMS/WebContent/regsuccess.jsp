<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>

<h1> student (<%=request.getAttribute("userID") %>) created  successfully</h1>
<a href="./student.jsp">register a new student</a>
<a href="./adminsuccess.jsp">Go to Home</a>
<jsp:include page="footer.jsp"/>
</body>
</html>