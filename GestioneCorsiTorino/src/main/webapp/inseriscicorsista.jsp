<%
	String user = (String) session.getAttribute("username");
	if (user != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>