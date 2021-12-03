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
</div>

</body>
<div class="modal fade" id="creaCorso" role="dialog">
	<div class="modal-dialog modal-md" role="document">
		<div class="modal-content">
			<form action="/<%=application.getServletContextName()%>/creaCorso"
				method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;</button>
					<h4 class="modal-title">Aggiungi corso</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="nomecorso">Nome corso</label> <input type="text" id="nomecorso"
							name="nomecorso" class="form-control" value="">
					</div>
						<div class="form-group">
						<div class="input-group date" id="dp">
							<label for="datainizio">Data inizio</label> <span
								class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id="datainizio" name="datainizio"
								class="form-control" value="">
						</div>
					</div>
						<div class="form-group">
						<div class="input-group date" id="dp">
							<label for="datafine">Data fine</label> <span
								class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id="datafine" name="datafine"
								class="form-control" value="">
						</div>
					</div>
					<div class="form-group">
						<label for="prezzo">Costo</label> <input type="number" id="prezzo"
							name="prezzo" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="commento">Commento</label> <input type="text" id="commento"
							name="commento" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="aula">Aula</label> <input type="text" id="aula"
							name="aula" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="docente">Ricerca docente</label> <input type="text" id="docente"
							name="docente" class="form-control" placeholder="Inserisci Nome o cod docente">
					</div>
				
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-lg">
						Salva modifiche</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Annulla</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).on("click", "#add", function() {
		$("#idc").val($(this).data('id'));

	});
	
	$(function() {
		$('#datainizio').datepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			startDate : '01/01/1900',
			endDate : new Date()
		});

	});
	
	$(function() {
		$('#datafine').datepicker({
			format : 'dd/mm/yyyy',
			autoclose : true,
			startDate : '01/01/1900',
			endDate : new Date()
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