<%@page import="com.gestionecorsi.torino.model.Corsista"%>
<%@page import="java.util.List"%>
<%@page import="com.gestionecorsi.torino.bc.AdminFacade"%>
<%
	String admin = (String) session.getAttribute("admin");
	if (admin != null) {
%>
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
	<div class="container" style="margin-top: 100px;">
			<div class="page-header">
				<h3>Home Page</h3>
			</div>
				<div class="pulsanti">
				<a href="inseriscicorsista.jsp" class="btn btn-primary btn-lg">Inserisci</a>
				<a href="statistiche.jsp" class="btn btn-primary btn-lg">Statistiche</a>
				<a href="corsi.jsp" class="btn btn-primary btn-lg">Elimina Corsi</a>
			</div>
					<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>COD_CORSISTA</th>
						<th>NOME</th>
						<th>COGNOME</th>
						<th>PRECEDENTI FORMATIVI</th>
						

					</tr>
				</thead>
				<tbody>
					<%
					
					List<Corsista>la = AdminFacade.getInstance().getCorsisti();
					if(la == null)
					{
					%>
					<tr><td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					</tr>
					<%
					
					}else{
					%>
					<%	
					for (Corsista c : la) {
						
					%>
					<tr>

						<td><%=c.getCodCorsista()%></td>
						<td><%=c.getNomeCorsista()%></td>
						<td><%=c.getCognomeCorsista()%></td>
						<td><%=c.getPrecedentiFormativi()%></td>
			
					
					</tr>
					<%
					}}
					%>

				</tbody>

			</table>


		</div>
		
	</div>
</body>
</html>

<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>