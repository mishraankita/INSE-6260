<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>student registration</title>
</head>
<body background="welcome.jpg">
<h1 align="center"><font color="blue">Manage Student information</font></h1>
<jsp:declaration>
String userID = "";
</jsp:declaration>
<jsp:scriptlet>
userID = request.getParameter("userID");
private SessionMap<String, Object> sessionMap;
String userID = (String) sessionMap.get("UserID");
</jsp:scriptlet>
<s:form method="post" action="./manageStudent">
<table align="center">  
	<tr>
		<%
		String userID = (String) sessionMap.get("UserID");
		%>
	</tr>    
	<tr>
		<td>Enter the UserID of account you want to edit</td>
		<td><input type="text" name=userID></input></td>
	</tr>
	<tr>
		<td>
				<s:submit value="Manage student" />
		</td>
	</tr>
</table>
</s:form>
 <h3 align="center"><a href="./adminsuccess.jsp">   Go to Home</a></h3>
<!--   <h3 align="center"><a href="./manageStudent.jsp">Manage Student</a><br/></h3> -->
<!--  <h3 align=center><a href=./dpdManage.jsp>Manage DPD</a><br/></h3> -->
</body>
</html>