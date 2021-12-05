<%
String admin = (String) session.getAttribute("admin");
if(admin != null ){		
%>

<nav class="navbar navbar-fixed-top navbar-inverse" id="navadm">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" data-toggle="collapse" class="navbar-toggle" data-target="#menu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<a style="color: gold" class="navbar-brand" href="home.jsp">Home</a>
		</div>
		<div class="navbar-header">
					<audio controls autoplay loop src="music/natale.mp3"></audio>
		</div>
		<div class="collapse navbar-collapse" id="menu">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a style="color: gold" href="utente.jsp"> 
						<span class="glyphicon glyphicon-user"></span> <%= admin %>
					</a>
				</li>
				<li>
					<a style="color: gold" href="logout.jsp"> 
						<span class="glyphicon glyphicon-off"></span> Logout
					</a>
				</li>
			</ul>
		</div>
	</div>
	

</nav>
<%}else{%>
<nav class="navbar navbar-fixed-top navbar-inverse" id="navout">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" data-toggle="collapse" class="navbar-toggle" data-target="#menu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<a style="color: gold" class="navbar-brand" href="index.jsp">Home</a>
		</div>
		<div class="navbar-header">
					<audio controls autoplay loop src="music/natale.mp3"></audio>
		</div>
		<div class="collapse navbar-collapse" id="menu">
			
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a style="color: gold" href="index.jsp"> 
						<span class="glyphicon glyphicon-user"></span> 
					</a>
				</li>
				<li>
					<a style="color: gold" href="index.jsp"> 
						<span class="glyphicon glyphicon-off"></span> Login
					</a>
				</li>
			</ul>
		</div>
	</div>


</nav>
<%}%>