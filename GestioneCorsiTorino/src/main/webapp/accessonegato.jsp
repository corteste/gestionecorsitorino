<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta name="viewport" content="width = device-width , intial-scale = 1 ">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Risorsa non trovata</title>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Non puoi accedere a questa pagina</h3>
		</div>
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3>Risorsa non disponibile</h3>
			</div>
			<div class="panel-body">
				<p>Per accedere :</p>
				<p>
					<a href="index.jsp">Login>></a>
				</p>
			</div>
		</div>
		
	</div>
</body>
</html>