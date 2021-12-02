<%
	String user = (String)session.getAttribute("admin");
	String admin = (String)session.getAttribute("password");
	if(user != null || admin != null) {
		session.invalidate();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="CDN.html" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
<div class="page-header">
	<h3>Logout</h3>
</div>
<div class="panel panel-danger">
	<div class="panel-heading">
		<h3>Hai appena effettuato il logout</h3>
	</div>
	<div class="panel-body">
		<p>Per accedere nuovamente effettuare il login</p>
		<p><a href="index.jsp">Login >></a>	
	</div>
</div>
</div>
</body>
</html>
<%
	} else { 
		response.sendRedirect("accessonegato.jsp");
	}
%>
