
<nav class="navbar navbar-fixed-top navbar-inverse">

		<div  class="navbar-header">
			<button  type="button" data-toggle="collapse" class="navbar-toggle"
				data-target="#menu">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">test3</a>
		</div>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" data-toggle="collapse" class="navbar-toggle" data-target="#menu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Home</a>
		</div>
		<div class="collapse navbar-collapse" id="menu">
			<%
				String username = (String) session.getAttribute("username");
			%>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="utente.jsp"> 
						<span class="glyphicon glyphicon-user"></span> <%= username %>
					</a>
				</li>
				<li>
					<a href="logout.jsp"> 
						<span class="glyphicon glyphicon-off"></span> Logout
					</a>
				</li>
			</ul>
		</div>
	</div>

</nav>