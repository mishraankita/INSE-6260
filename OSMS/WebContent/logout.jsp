<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
<table>
	<tr>
		<%=request.getAttribute("resultsMessage")!=null ? request.getAttribute("resultsMessage") : ""%>
	</tr>    
</table>
<%
		session = request.getSession(false);
		if(session!=null)
		session.invalidate();
%>
 <h3 align="center"><a href="./welcome.jsp"><font color="white">Login</font></a></h3>
 <jsp:include page="footer.jsp"/>
</body>
</html>