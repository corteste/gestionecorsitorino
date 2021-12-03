<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.gestionecorsi.torino.bc.AdminFacade"%>
<%@page import="com.gestionecorsi.torino.model.Corso"%>
<%@page import="java.util.List"%>
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
<title>Inserisci nuovo corsista</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container" style="margin-top: 100px;">
	<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Cod Corso</th>
						<th>Nome Corso</th>
						<th>Data Inizio</th>
						<th>Data Fine</th>
						<th>Costo</th>
						<th>Commenti</th>
						<th>Aula</th>
						<th>Cod Docente</th>
						<th>Aggiungi corsista</th>
						

					</tr>
				</thead>
				<tbody>
					<%
				
					List<Corso>la = AdminFacade.getInstance().getCorsi();
					if (la == null) {
					%>
					<tr>
					<td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					<td>UNK</td>
					
				
					</tr>
					<%
					} else {
					%>
					<%
					for (Corso a : la) {
		
					%>
					<tr>
					<td><%=a.getIdCorso() %></td>
					<td><%=a.getNomeCorso() %></td>
					<td><%=new SimpleDateFormat("dd/MM/yyyy").format(a.getDataInizio()) %></td>
					<td><%=new SimpleDateFormat("dd/MM/yyyy").format(a.getDataFine()) %></td>
					<td><%=String.format("%.2f",a.getCostoCorso()) %></td>
					<td><%=a.getCommenti() %></td>
					<td><%=a.getAulaCorso() %></td>
					<td><%=a.getCodDocente() %></td>
						<td><button data-id="<%=a.getIdCorso()%>" id="add" data-toggle="modal" data-target="#aggiungiCorista" class="btn btn-primary btn-xs">Aggiungi corsista</button></td>
					
						</tr>
					<%
					}
					}
					%>

				</tbody>

			</table>


		</div>
</div>

</body>
<script type="text/javascript">
	$(document).on("click", "#add", function() {
		$("#idc").val($(this).data('id'));

	});


</script>
<%@ include file="modalCorsista.jsp"%>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>