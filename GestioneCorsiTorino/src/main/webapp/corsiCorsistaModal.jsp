<%@page import="java.util.List"%>
<%@page import="com.gestionecorsi.torino.model.CorsoCorsista"%>
<%@page import="com.gestionecorsi.torino.bc.AdminFacade"%>
<%@page import="com.gestionecorsi.torino.model.Corso"%>
<% 
	int id = Integer.parseInt(request.getParameter("id")); 
	
	if(request.getParameter("id") == null) {
		response.sendRedirect("admin/gestisciArticoli.jsp");
	} else {

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
 	long idCorsista = Long.parseLong(request.getParameter("id"));
 	List<CorsoCorsista> corsoCorsisti = AdminFacade.getInstance().getCorsoCorsisti();	
 	%>
 	
 <div class="modal fade" id="gestisciArticoloModal_<%=idCorsista%>" role="dialog">
 	<div class="modal-dialog modal-md" role="document">
 		<div  class="modal-content">
	 		<div class="modal-header">
	 			<button type="button" class="close" data-dismiss="modal">&times;</button>
	 				<h4 class="modal-title"> Corsi </h4>
	 		</div>
	 			
	 		<div class="modal-body">
	 			<div>
	 				<label for="marca">Codice corsista:</label> <%=AdminFacade.getInstance().getCorsistaById(idCorsista).getCodCorsista()%>
	 			</div>
	 			<br>
	 			<div>
					<table class="table table-warning">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">Nome</th>
							</tr>
						</thead>
						<tbody>
   						<tr>
							<%
						 	for(CorsoCorsista cc : corsoCorsisti) {
								if(cc.getCodCorsista() == idCorsista) {
									Corso corso = AdminFacade.getInstance().getCorsoById(cc.getCodCorso());
						 	%>
     					<td><%=corso.getIdCorso()%></td>
      					<td><%=corso.getNomeCorso()%></td>
      					</tr>
						<% 	
					 		}
					 	}
					 	
					 %>
					</tbody>
					</table>
				</div>
	 		</div>
	 	</div>
 	</div>
 </div> 
 <%
	}
 %>