<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.gestionecorsi.torino.bc.AdminFacade"%>
<%@page import="com.gestionecorsi.torino.model.Corso"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="CDN.html" %>
<%@ include file="neve.html" %>
<meta charset="ISO-8859-1">
<title>Eliminazione corsi</title>
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
				
					List<Corso>la = AdminFacade.getInstance().getCorsiByDate(new Date());
					if (la.isEmpty()) {
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
						<td><button id="del" data-id="<%=a.getIdCorso()%>"   data-toggle="modal" data-target="#eliminaCorso" class="btn btn-danger btn-xs">Elimina corso</button></td>
					
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

<%@ include file="delCorsoModal.jsp"%>
<script type="text/javascript">
	$(document).on("click", "#del", function() {
		$("#idc").val($(this).data('id'));

	});
</script>
</html>