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
	<script type="text/JavaScript">
	function validateForm()
{		   
   var x = document.forms["manage"]["userID"].value;
   if( x == null || x == "" )
   {
     alert( "Please provide userID" );
     return false;
   }
   if(isNaN(x)){
	   alert( "Please enter valid Numeric User ID!" );
	   return false;
}
   return true;
}
	</script>
<h1 align="center"><font color="blue">Manage Student information</font></h1>

<s:form name = "manage" method="post" action="./manageStudent" onsubmit="return validateForm()">
<table align="center">  
	<tr>
		<h3 align="center"><font color="black"><%=request.getAttribute("resultsMessage")!=null ? request.getAttribute("resultsMessage") : ""%></font></h3>
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
 <h3 align="center"><a href="./adminsuccess.jsp">  <font color="black" > Go to Home </font> </a></h3>
<!--   <h3 align="center"><a href="./manageStudent.jsp">Manage Student</a><br/></h3> -->
<!--  <h3 align=center><a href=./dpdManage.jsp>Manage DPD</a><br/></h3> -->
	<jsp:include page="footer.jsp"/>
</body>
</html>