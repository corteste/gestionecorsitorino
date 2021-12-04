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
<meta charset="ISO-8859-1">
<title>Eliminazione corsi</title>
</head>
<body>
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
						<td><button data-id="<%=a.getIdCorso()%>" id="add" data-toggle="modal" data-target="#aggiungiCorista" class="btn btn-primary btn-xs">Aggiungi corsista</button></td>
					
						</tr>
					<%
					}
					}
					%>

				</tbody>

			</table>
			<button   data-toggle="modal" data-target="#eliminaCorso" class="btn btn-primary btn-xs">Elimina corso</button>

		</div>
</body>
</html>