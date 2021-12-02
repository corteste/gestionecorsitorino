<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
int tmp = 0;
if(session.getAttribute("attempt") != null)
	tmp = (Integer)session.getAttribute("attempt");

if(tmp< 5){
%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div style="margin-top:100px;"class="container">
<p>Hai a disposizione <%=""+(5-(tmp))+"" %></p>
<form action="/<%=application.getServletContextName()%>/loginControl" method="POST"
class="form-horizontal">

<!--------------------------------------------- Username -->
<div class="form-group">
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" id ="username" name="username"
			placeholder="Username..." class="form-control" maxlength="10">	
		</div>
	</div>
	<div class="col-md-7 control-label" id="admin"></div>
</div>

<!--------------------------------------------- Password -->
<div class="form-group">
	
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-lock"></i>
			</span>
			<input type="password" id ="password" name="password"
			placeholder="Codice Admin..." class="form-control" maxlength="20">	
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoPassword"></div>
</div>

<div class="row">
	<div class="col-md-2">
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
{
%>
<%@ include file="limit.jsp" %>  
<%}%>