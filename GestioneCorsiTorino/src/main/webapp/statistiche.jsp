<%@page import="com.gestionecorsi.torino.model.Corsista"%>
<%@page import="java.util.List"%>
<%@page import="com.gestionecorsi.torino.model.CorsoCorsista"%>
<%@page import="com.gestionecorsi.torino.bc.AdminFacade"%>
<%@page import="com.gestionecorsi.torino.model.Docente"%>
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
<title>Report</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<%
		String mostCorsi = AdminFacade.getInstance().getDocenteMostCorsi();
		Docente docente = AdminFacade.getInstance().getDocenteByString(mostCorsi);
	%>

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true" style="margin-top: 100px;">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          I. Numero corsisti totali
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        Contenuto statistica qui
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          II. Nome del corso più frequentato
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      	<div class="panel-body">
      <%=AdminFacade.getInstance().getPopularCorso() %>
   		</div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          III. Data di inizio ultimo corso
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
      	Contenuto statistica qui  
      </div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFour">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          IV. Durata media dei corsi
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
      	<div class="panel-body">
      Contenuto statistica qui
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFive">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
          V. Numero di commenti presenti
        </a>
      </h4>
    </div>
    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
      	<div class="panel-body">
      <%=AdminFacade.getInstance().getCountCommenti(-1) %>
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingSix">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
          VI. Elenco corsisti
        </a>
      </h4>
    </div>
    <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingsSix">
      	<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Corsi</th>
					</tr>
					</thead>
					<tbody>
						<%
							List<CorsoCorsista> corsoCorsisti = AdminFacade.getInstance().getCorsoCorsisti();
						
							for(CorsoCorsista cc : corsoCorsisti) {
								Corsista corsista = AdminFacade.getInstance().getCorsistaById(cc.getCodCorsista());
								
						%>
						<tr>
							<td><%= corsista.getCodCorsista()%></td>
							<td><%= corsista.getNomeCorsista() %></td>
							<td><%= corsista.getCognomeCorsista() %></td>
							<td><button type="button" class="btn btn-info" 
								data-toggle="modal" data-target="#gestisciArticoloModal_<%=cc.getCodCorsista()%>">Riepilogo
								</button></td>
							<td><jsp:include page="corsiCorsistaModal.jsp">
									<jsp:param value="<%=cc.getCodCorsista()%>" name="id" />
								</jsp:include></td>
						</tr>
						<% 
							}
						%>
					</tbody>
				</table>
			</div>
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingSeven">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
          VII. Docente che può tenere più corsi
        </a>
      </h4>
    </div>
    <div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
      	<div class="panel-body">
      		<%= docente.getNomeDocente() + " " + docente.getCognomeDocente()%>
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingEight">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
          VIII. Corsi con posti disponibili
        </a>
      </h4>
    </div>
    <div id="collapseEight" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEight">
      	<div class="panel-body">
      <%for(String s : AdminFacade.getInstance().getAvailableCorso()){ %><!-- Conviene fare una lista di corsi e stamparlo a tabella -->
  		<%=s %> 	
  		<br>	
   		<%} %>
   		</div>
    </div>
  </div>
</div>

</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>