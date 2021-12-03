<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>

<%@ include file="CDN.html"%>
<meta name="viewport" content="width = device-width , intial-scale = 1 ">
<link rel="stylesheet" href="CSS/style.css">
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>

<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Formato dati errato </h3>
		</div>
			<div class="panel panel-danger">
			<div class="panel-heading">
				<h3><%=exception.getClass().getSimpleName() %></h3>
			</div>
			<div class="panel-body">
				<p><%=exception.getMessage() %></p>
				<p>
				Torna pagina precedente
				</p>
				<input type ="button" onclick="window.history.back()"
				class ="btn btn-default" value="indietro"
				>
			</div>
		</div>
</div>

</body>
</html>