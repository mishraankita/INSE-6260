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
<body background="bg16.jpg">
<jsp:include page="header.jsp"/>
<h1 align="center"><font color="blue">Manage DPD information</font></h1>

<s:form method="post" action="./manageDPD">
<table align="center">  
	<tr>
		<%=request.getAttribute("resultsMessage")!=null ? request.getAttribute("resultsMessage") : ""%>
	</tr>    
	<tr>
		<td>Enter the UserID of account you want to edit</td>
		<td><input type="text" name=userID></input></td>
	</tr>
	<tr>
		<td>
				<s:submit value="Manage DPD" />
		</td>
	</tr>
</table>
</s:form>
 <h3 align="center"><a href="./adminsuccess.jsp">  <font color="white" > Go to Home </font></a></h3>
<!--   <h3 align="center"><a href="./manageStudent.jsp">Manage Student</a><br/></h3> -->
<!--  <h3 align=center><a href=./dpdManage.jsp>Manage DPD</a><br/></h3> -->
<jsp:include page="footer.jsp"/>
</body>
</html>