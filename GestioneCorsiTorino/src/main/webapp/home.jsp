
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<div class="container">
			<div class="page-header">
				<h3>Home Page</h3>
			</div>
			<div class="pulsanti">
				<a href="inseriscicorsista.jsp" class="btn btn-primary btn-lg">Inserisci</a>
				<a href="statistiche.jsp" class="btn btn-primary btn-lg">Statistiche</a>
				<a href="corsi.jsp" class="btn btn-primary btn-lg">Elimina Corsi</a>
			</div>
	</div>
</body>
</html>
