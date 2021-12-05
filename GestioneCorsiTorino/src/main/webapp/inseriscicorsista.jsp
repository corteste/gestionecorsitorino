<%@page import="com.gestionecorsi.torino.model.Corsista"%>
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
<%@ include file="neve.html" %>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/inserisci_corsista_style.css" />
<title>Inserisci nuovo corsista</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container" style="margin-top: 100px;">
	<h3><img src="img/corsi.png"></h3>
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
			<button   data-toggle="modal" data-target="#creaCorso" class="btn btn-primary btn-xs">Crea nuovo corso</button>

		</div>
		
<p>Nuovo dato inserito</p>
<%if(session.getAttribute("newcorso")!= null) {
Corso a =(Corso) session.getAttribute("newcorso");
%>
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
					
						

					</tr>
				</thead>
				<tbody>
				<tr>
					<td><%=a.getIdCorso() %></td>
					<td><%=a.getNomeCorso() %></td>
					<td><%=new SimpleDateFormat("dd/MM/yyyy").format(a.getDataInizio()) %></td>
					<td><%=new SimpleDateFormat("dd/MM/yyyy").format(a.getDataFine()) %></td>
					<td><%=String.format("%.2f",a.getCostoCorso()) %></td>
					<td><%=a.getCommenti() %></td>
					<td><%=a.getAulaCorso() %></td>
					<td><%=a.getCodDocente() %></td>
				
				</tbody>
</table>
</div>
<%session.removeAttribute("newcorso");}else
	if(session.getAttribute("newcorsista")!= null){
		Corsista a =(Corsista) session.getAttribute("newcorsista");
%>
<div class="table-responsive">
<table class="table table-hover">
	<thead>
					<tr>
						<th>Cod Corsista</th>
						<th>Nome Corsista</th>
						<th>Cognome Corsista</th>
						<th>Precedenti formativi</th>
				
						

					</tr>
				</thead>
				<tbody>
				<tr>
					<td><%=a.getCodCorsista() %></td>
					<td><%=a.getNomeCorsista()%></td>
					<td><%=a.getCognomeCorsista()%></td>
					<td><%=a.getPrecedentiFormativi()%></td>
			
				</tbody>
</table>
</div>
<% session.removeAttribute("newcorsista");}else{ %>
<p>Ancora nessun dato inserito</p>
<%} %>
</div>

</body>
<%@ include file="createCorsoModal.jsp"%>
<script type="text/javascript">
	$(document).on("click", "#add", function() {
		$("#idc").val($(this).data('id'));

	});
	
	$(function() {
		$('#datainizio').datepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			startDate : new Date()
		});

	});
	
	$(function() {
		$('#datafine').datepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			startDate : new Date() 
		});

	});

</script>
<%@ include file="modalCorsista.jsp"%>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>