<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html"%>
<meta name="viewport" content="width = device-width , intial-scale = 1 ">
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Accesso non riuscito</title>
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
				<p>Prova :</p>
				<p>Registrarti</p>
				<p>
					<a href="registra.jsp">Registrati ora>></a>
				</p>
				<p>Se sei gia registrato Accedi</p>
				<p>
					<a href="login.jsp">Login>></a>
				</p>
			</div>
		</div>
		
	</div>
	<footer ><%@ include file= "footer.html" %></footer>
</body>
</html>