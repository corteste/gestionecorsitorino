<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
<form action="/<%=application.getServletContextName()%>/login" method="post"
class="form-horizontal">

<!--------------------------------------------- Username -->
<div class="form-group">
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-user"></i>
			</span>
			<input type="text" name="username"
			placeholder="username" class="form-control" maxlength="10">	
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoUsername"></div>
</div>

<!--------------------------------------------- Password -->
<div class="form-group">
	
	<div class="col-md-4 inputGroupContainer">
		<div class="input-group">
			<span class="input-group-addon">
				<i class="glyphicon glyphicon-lock"></i>
			</span>
			<input type="password" name="password"
			placeholder="Password..." class="form-control" maxlength="20">	
		</div>
	</div>
	<div class="col-md-7 control-label" id="infoPassword"></div>
</div>

<div class="row">
	<div class="col-md-2">
		<button type="button" class="btn btn-info">
			Login&nbsp;<span class="glyphicon glyphicon-log-in"></span>
		</button>
	</div>
</div>

</form>
</div>
<footer><%@include file="footer.html"%></footer>
</body>
</html>