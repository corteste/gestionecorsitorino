<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	String admin = null;
	for (Cookie cookie : cookies) {
		if ("admin".equals(cookie.getName())) {
			admin = cookie.getValue();
			session.setAttribute("admin", admin);
			response.sendRedirect("home.jsp");
		}
	}
}
int tmp = 0;
if(session.getAttribute("attempt") != null)
	tmp = (Integer)session.getAttribute("attempt");

if(tmp< 5){
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<%@ include file="neve.html" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style.css">
<title>Login Page</title>

</head>
<body>
<jsp:include page="nav.jsp"/>

<div class="container" id="boxIndex">
<%if(tmp >0){ %>
<p>Ricontrolla i dati</p>
<p>Hai a disposizione <%=""+(5-(tmp))+"" %> tentativi</p>
<% }%>

<form action="/<%=application.getServletContextName()%>/loginControl" method="POST"
class="form-horizontal">

<!--------------------------------------------- Username -->
<div class="form-group">
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group" id="boxUser">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" id ="username" name="username"
			placeholder="Username..." class="form-control" maxlength="10">	
		</div>
	</div>
	<div class="col-md-7 control-label" id="admin"></div>
</div>
<br>
<br>
<!--------------------------------------------- Password -->
<div class="form-group">
	
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group" id="boxCodAdm">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-lock"></i>
			</span>
			<input type="password" id ="password" name="password"
			placeholder="Codice Admin..." class="form-control" maxlength="20">	
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoPassword"></div>
</div>

<div class="row" id="buttonDiv">
	<div class="col-md-2" id="buttonLogin">
		<button type="submit" class="btn btn-info">
			Login&nbsp;<span class="glyphicon glyphicon-log-in"></span>
		</button>
	</div>
</div>

</form>
</div>
</body>
</html>
<%}else
response.sendRedirect("limit.jsp");
%>

